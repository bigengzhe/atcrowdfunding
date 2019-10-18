package com.course.atcrowdfunding.manager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.course.atcrowdfunding.bean.Project;
import com.course.atcrowdfunding.potal.service.MemberService;
import com.course.atcrowdfunding.potal.service.ProjectService;

@Controller
@RequestMapping("/authproject")
public class AuthProjectController {
	@Autowired
	private ProjectService projectService; 
	@Autowired
	private MemberService memberService;
	@RequestMapping("/verify")
	public String verify(Integer id){
		Project project=projectService.selectByProjectId(id);
		project.setStatus("1");
		projectService.updateProjectById(project);
		return "redirect:/authproject/index.htm";
	}
	@RequestMapping("/index")
	public String index(Map map){
		List<Project> list=projectService.selectStatus("0");
		List<Map<String,Object>> mlist=new ArrayList<>();
		Map<String,Object> mmap=null;
		for (Project project : list) {
			mmap=new HashMap<>();
			mmap.put("id", project.getId());
			mmap.put("pname", project.getName());
			mmap.put("mrealname", memberService.getMemberById(project.getMemberid()).getRealname());
			mmap.put("money", project.getMoney());
			mmap.put("day", project.getDay());
			mmap.put("createdate", project.getCreatedate());
			mlist.add(mmap);
		}
		map.put("list", mlist);
		
		
		return "authproject/index";
	}
}
