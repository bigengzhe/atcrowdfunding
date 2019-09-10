package com.course.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.course.atcrowdfunding.bean.User;
import com.course.atcrowdfunding.manager.service.UserService;
import com.course.atcrowdfunding.util.AjaxResult;
import com.course.atcrowdfunding.util.Const;
import com.course.atcrowdfunding.util.MD5Util;

@Controller
public class DispatcherController {

	@Autowired
	private UserService userService ;
	
	
	@RequestMapping("/index")
	public String index(){		
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(){		
		return "login";
	}
	
	@RequestMapping("/main")
	public String main(){		
		return "main";
	}
	//异步请求
	//HttpMessageConverter
	//@ResponseBody 结合Jackson组件,将返回结果转换为字符串.将JSON串以流的形式返回给客户端.
	@ResponseBody
	@RequestMapping("/doLogin")
	public Object doLogin(String loginacct,String userpswd,String type,HttpSession session){
		
		AjaxResult result = new AjaxResult();
		
		try {
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("loginacct", loginacct);
			paramMap.put("userpswd", MD5Util.digest(userpswd));
			paramMap.put("type", type);		
			//
			User user = userService.queryUserlogin(paramMap);
			
			session.setAttribute(Const.LOGIN_USER, user);
			result.setSuccess(true);
			// {"success":true}
		} catch (Exception e) {
			result.setMessage("登录失败!");
			e.printStackTrace();
			result.setSuccess(false);
			// {"success":false,"message":"登录失败!"}
			//throw e ;
		}
		//System.out.println("登录执行，，，，，，，，，，，，，，，，");
		return result ;
	}
	//同步请求
	/*@RequestMapping("/doLogin")
	public String doLogin(String loginacct,String userpswd,String type,HttpSession session){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("loginacct", loginacct);
		paramMap.put("userpswd", userpswd);
		paramMap.put("type", type);		
		
		User user = userService.queryUserlogin(paramMap);
		
		session.setAttribute(Const.LOGIN_USER, user);
		
		return "redirect:/main.htm";
	}*/
	@RequestMapping("/logout")
	public String logout(HttpSession session){	
		
		session.invalidate(); //销毁session对象,或清理session域.
		
		return "redirect:/index.htm"; 
	}
}
