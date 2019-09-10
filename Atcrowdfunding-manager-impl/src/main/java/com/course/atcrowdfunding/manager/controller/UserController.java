package com.course.atcrowdfunding.manager.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.course.atcrowdfunding.bean.Role;
import com.course.atcrowdfunding.bean.User;
import com.course.atcrowdfunding.manager.service.UserService;
import com.course.atcrowdfunding.util.AjaxResult;
import com.course.atcrowdfunding.util.Page;
import com.course.atcrowdfunding.util.StringUtil;
import com.course.atcrowdfunding.vo.Data;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService ;
	
	@RequestMapping("/toIndex")
	public String toIndex(){		
		return "user/index";
	}
	@RequestMapping("/toAdd")
	public String toAdd(){		
		return "user/add";
	}
	@ResponseBody
	@RequestMapping("/doAdd")
	public Object doAdd(User user){
		AjaxResult result = new AjaxResult();
		try {
			
			int count = userService.saveUser(user);
			result.setSuccess(count==1);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("保存数据失败!");
		}
		 
		return result; 
	}
	//分配角色
		@ResponseBody
		@RequestMapping("/doAssignRole")
		public Object doAssignRole(Integer userid,Data data){
			AjaxResult result = new AjaxResult();
			try {
				
				//userService.saveUserRoleRelationship(userid,data);
				result.setSuccess(true);
			} catch (Exception e) {
				result.setSuccess(false);
				e.printStackTrace();
				result.setMessage("分配角色数据失败!");
			}
			 
			return result; 
		}
		
		//取消分配角色
		@ResponseBody
		@RequestMapping("/doUnAssignRole")
		public Object doUnAssignRole(Integer userid,Data data){
			AjaxResult result = new AjaxResult();
			try {
				
				//userService.deleteUserRoleRelationship(userid,data);
				result.setSuccess(true);
			} catch (Exception e) {
				result.setSuccess(false);
				e.printStackTrace();
				result.setMessage("取消分配角色数据失败!");
			}
			 
			return result; 
		}
		
		
		//显示分配页面数据.
		@RequestMapping("/assignRole")
		public String assignRole(Integer id,Map map){	
			
			List<Role> allListRole = userService.querAllRole();
			
			List<Integer> roleIds = userService.queryRoleByUserid(id);
			
			
			List<Role> leftRoleList = new ArrayList<Role>(); //未分配角色
			List<Role> rightRoleList = new ArrayList<Role>(); //已分配角色
			
			
			for(Role role : allListRole){			
				
				if(roleIds.contains(role.getId())){
					rightRoleList.add(role);
				}else{
					leftRoleList.add(role);
				}
				
			}
			
			
			map.put("leftRoleList", leftRoleList);
			map.put("rightRoleList", rightRoleList);
			
			
			return "user/assignrole";
		}
		
		
		
	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id,Map map){	
		
		User user = userService.getUserById(id);
		map.put("user", user);
		
		return "user/update";
	}
	@ResponseBody
	@RequestMapping("/doUpdate")
	public Object doUpdate(User user){
		AjaxResult result = new AjaxResult();
		try {
			
			int count = userService.updateUser(user);
			result.setSuccess(count==1);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("修改数据失败!");
		}
		 
		return result; 
	}
	@ResponseBody
	@RequestMapping("/doDelete")
	public Object doDelete(Integer id){
		AjaxResult result = new AjaxResult();
		try {
			
			int count = userService.deleteUser(id);
			result.setSuccess(count==1);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("删除数据失败!");
		}
		 
		return result; 
	}
	//接收多条数据.
	@ResponseBody
	@RequestMapping("/doDeleteBatch")
	public Object doDeleteBatch(Data data){
		AjaxResult result = new AjaxResult();
		try {
			
			int count = userService.deleteBatchUserByVO(data);
			result.setSuccess(count==data.getDatas().size());
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("删除数据失败!");
		}
		 
		return result; 
	}
	//接收一个参数名带多个值.
	/*@ResponseBody
	@RequestMapping("/doDeleteBatch")
	public Object doDeleteBatch(Integer[] id){
		AjaxResult result = new AjaxResult();
		try {
			//System.out.println(Arrays.toString(id));
			int count = userService.deleteBatchUser(id);
			result.setSuccess(count==id.length);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("删除数据失败!");
		}
		 
		return result; 
	}*/
	//条件查询
	@ResponseBody
	@RequestMapping("/index")
	public Object index(@RequestParam(value="pageno",required=false,defaultValue="1") Integer pageno,
				@RequestParam(value="pagesize",required=false,defaultValue="10") Integer pagesize,
				String queryText){
		AjaxResult result = new AjaxResult();
		try {
			
			Map paramMap = new HashMap();
			paramMap.put("pageno", pageno);
			paramMap.put("pagesize", pagesize);			
			
			if(StringUtil.isNotEmpty(queryText)){
				
				if(queryText.contains("%")){
					queryText = queryText.replaceAll("%", "\\\\%");
				}
				
				paramMap.put("queryText", queryText); //   \%
			}
			Page page = userService.queryPage(paramMap);
			result.setSuccess(true);
			result.setPage(page);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("查询数据失败!");
		}
		 
		return result; //将对象序列化为JSON字符串,以流的形式返回.
	}
	
	
	//异步请求
	/*@ResponseBody
	@RequestMapping("/index")
	public Object index(@RequestParam(value="pageno",required=false,defaultValue="1") Integer pageno,
				@RequestParam(value="pagesize",required=false,defaultValue="10") Integer pagesize){
		AjaxResult result = new AjaxResult();
		try {
			Page page = userService.queryPage(pageno,pagesize);
			
			result.setSuccess(true);
			result.setPage(page);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("查询数据失败!");
		}
		 
		return result; //将对象序列化为JSON字符串,以流的形式返回.
	}*/
	
	
	//同步请求
	/*@RequestMapping("/index")
	public String index(@RequestParam(value="pageno",required=false,defaultValue="1") Integer pageno,
				@RequestParam(value="pagesize",required=false,defaultValue="10") Integer pagesize,Map map){
		
		Page page = userService.queryPage(pageno,pagesize);
		 
		map.put("page", page);
		
		return "user/index";
	}*/
	
}
