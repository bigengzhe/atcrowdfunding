package com.course.atcrowdfunding.potal.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.course.atcrowdfunding.bean.Form;
import com.course.atcrowdfunding.bean.Member;
import com.course.atcrowdfunding.bean.Project;
import com.course.atcrowdfunding.bean.Return;
import com.course.atcrowdfunding.potal.service.FormService;
import com.course.atcrowdfunding.potal.service.MemberService;
import com.course.atcrowdfunding.potal.service.ProjectService;
import com.course.atcrowdfunding.potal.service.ReturnService;
import com.course.atcrowdfunding.util.AjaxResult;
import com.course.atcrowdfunding.util.Const;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ReturnService returnService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private FormService formService;
	@RequestMapping("/project")
	public String project(){
		return "project/project";
	}
	@RequestMapping("/start")
	public String start(HttpSession session){
		Member loginMember = (Member)session.getAttribute(Const.LOGIN_MEMBER);
		if("2".equals(loginMember.getAuthstatus())){
			return "project/start";
		}else{
			return "redirect:/member/apply.htm";
		}
		
	}
	@RequestMapping("/start-step-1")
	public String startStep1(){
		return "project/start-step-1";
	}
	@RequestMapping("/paymoney")
	public String paymoney(Integer id){
		Form form=formService.selectById(id);
		Return myreturn=returnService.selectByPrimarykey(form.getReturnid());
		Project project=projectService.selectByProjectId(myreturn.getProjectid());
		form.setStatus("0");
		int fcount= formService.updateById(form);
		project.setSupportmoney(project.getSupportmoney()+Long.parseLong(form.getMoney()));
		project.setMoneyProgress(project.getSupportmoney()*100/project.getMoney());
		//System.out.println("hhhhhhhhhhhhhhh"+project.getMoneyProgress());
		project.setSupporter(project.getSupporter()+1);
		int projectCount= projectService.updateProjectById(project);
		return "redirect:/member/minecrowdfunding.htm";
	}
	@RequestMapping("/frontpay-step-1")
	public String frontpaystep1( HttpSession session,Integer id){
		Return myreturn=returnService.selectByPrimarykey(id);
		Project project=projectService.selectByProjectId(myreturn.getProjectid());
		Member member = memberService.getMemberById(project.getMemberid());
		Form form=new Form();
		form.setReturnid(myreturn.getId());
		form.setMemberid(member.getId());
		form.setStatus("0");
		form.setMoney(myreturn.getSupportmoney()+"");
		form.setDate(new Date());
		formService.insert(form);
		int fid =form.getId();
		return "redirect:/project/pay-step-1.htm?"+"fid="+fid;
	}
	@RequestMapping("/pay-step-1")
	public String paystep1( HttpSession session,Integer fid,Map map){
		Form form=formService.selectById(fid);
		Return myreturn=returnService.selectByPrimarykey(form.getReturnid());
		Project project=projectService.selectByProjectId(myreturn.getProjectid());
		Member member = memberService.getMemberById(project.getMemberid());
		
		
		//project.setSupportmoney(Long.parseLong(form.getMoney()));
		//int projectCount= projectService.updateProjectById(project);
		//int fid =formService.insert(form);
		map.put("project", project);
		map.put("myreturn", myreturn);
		map.put("member", member);
		map.put("form", form);
		return "project/pay-step-1";
	}
	
	@RequestMapping("/pay-step-2")
	public String paystep2(Integer id,Map map){
		map.put("fid", id);
		return "project/pay-step-2";
	}
	@RequestMapping("/toDisplayProject")
	public String toDisplayProject(Integer id,Map map){
		Project project=projectService.selectByProjectId(id);
		map.put("project", project);
		List<Return> list=returnService.selectByProjectid(id);
		map.put("list", list);
		return "project/myproject";
	}
	@RequestMapping("/start-step-2")
	public String startStep2(HttpSession session,Map map){
		Member loginMember = (Member)session.getAttribute(Const.LOGIN_MEMBER);
		List<Project> plist=projectService.selectByMemberid(loginMember.getId());
		Project project= plist.get(plist.size()-1);
		List<Return> list=returnService.selectByProjectid(project.getId());
		map.put("list", list);
		map.put("project", project);
		return "project/start-step-2";
	}
	@RequestMapping("/start-step-3")
	public String startStep3(){
		return "project/start-step-3";
	}
	@RequestMapping("/start-step-4")
	public String startStep4(){
		return "project/start-step-4";
	}
	@RequestMapping("/doDeleteReturn")
	public String doDeleteReturn(Integer id, Map map){
		int count= returnService.deleteByPrimaryKey(id);
		
		return "redirect:/project/start-step-2.htm";
	}
	@RequestMapping("/doDeleteProject")
	public String doDeleteProject(Integer id, Map map){
		int count= projectService.deleteByPrimaryKey(id);
		
		return "redirect:/member/minecrowdfunding.htm";
	}
	@RequestMapping("/doAddReturn")
	public String doAddReturn(Return re, Map map){
		int count= returnService.insert(re);
		return "redirect:/project/start-step-2.htm";
	}
	
	@ResponseBody
	@RequestMapping("/doRegProject")
	public Object doRegProject( HttpSession session, Project project){
		AjaxResult result = new AjaxResult();
		Member loginMember = (Member)session.getAttribute(Const.LOGIN_MEMBER);
		String realPath = session.getServletContext().getRealPath("/pics");
		try{
			
			MultipartFile headImg =project.getHeadimg();
			String extName = headImg.getOriginalFilename().substring(headImg.getOriginalFilename().lastIndexOf("."));
			String tmpName = UUID.randomUUID().toString() +  extName; 
			String filename = realPath + "/project" +"/" + tmpName;
			
			headImg.transferTo(new File(filename));	
			project.setHeadimgpath(tmpName);
			MultipartFile detailImg =project.getDetailimg();
			extName = detailImg.getOriginalFilename().substring(detailImg.getOriginalFilename().lastIndexOf("."));
			tmpName = UUID.randomUUID().toString() +  extName; 
			filename = realPath + "/project" +"/" + tmpName;
			
			detailImg.transferTo(new File(filename));	
			project.setDetailimgpath(tmpName);
			project.setStatus("0");
			project.setMemberid(loginMember.getId());
			int count= projectService.insert(project);
			if(count==1){
				result.setSuccess(true);
				List<Project> list=projectService.selectByMemberid(loginMember.getId());
				project= list.get(list.size()-1);
				project.setHeadimg(null);
				project.setDetailimg(null);
				result.setData(project);
			}
			//System.out.println(project.getType());
			//project.setDeploydate(new Date().toString());待等审核通过，才能生效
			//roject.setSupportmoney(0L);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
