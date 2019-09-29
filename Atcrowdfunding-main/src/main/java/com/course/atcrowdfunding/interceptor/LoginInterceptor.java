package com.course.atcrowdfunding.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.course.atcrowdfunding.bean.Member;
import com.course.atcrowdfunding.bean.User;
import com.course.atcrowdfunding.util.Const;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//1.定义哪些路径是不需要拦截(将这些路径称为白名单)
		Set<String> uri = new HashSet<String>();
		uri.add("/user/reg.do");
		uri.add("/user/reg.htm");
		uri.add("/login.htm");
		uri.add("/doLogin.do");
		uri.add("/logout.do");
		uri.add("/index.htm");
		uri.add("/member/reg.htm");
		uri.add("/member/doReg.do");
		uri.add("/project/project.htm");
		//获取请求路径.
		String servletPath = request.getServletPath();
		
		if(uri.contains(servletPath)){
			return true ;
		}
		
		
		//2.判断用户是否登录,如果登录就放行
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Const.LOGIN_USER);
		Member member = (Member)session.getAttribute(Const.LOGIN_MEMBER);
		
		if(user!=null || member!=null){
			return true ;
		}else{
			response.sendRedirect(request.getContextPath()+"/login.htm");
			return false;
		}
		
	}
	
}
