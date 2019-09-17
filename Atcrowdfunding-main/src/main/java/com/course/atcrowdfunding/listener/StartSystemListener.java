package com.course.atcrowdfunding.listener;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.course.atcrowdfunding.bean.Permission;
import com.course.atcrowdfunding.manager.service.PermissionService;
import com.course.atcrowdfunding.util.Const;

public class StartSystemListener implements ServletContextListener {

	//在服务器启动时,创建application对象时需要执行的方法.
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//1.将项目上下文路径(request.getContextPath())放置到application域中.
		ServletContext application = sce.getServletContext();
		String contextPath = application.getContextPath();
		application.setAttribute("APP_PATH", contextPath);
		//System.out.println("APP_PATH...");
		
		//2.加载所有许可路径
		ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(application);
		PermissionService permissionService = ioc.getBean(PermissionService.class);
		List<Permission> queryAllPermission = permissionService.queryAllPermission();
		
		Set<String> allURIs = new HashSet<String>();
		
		for (Permission permission : queryAllPermission) {
			allURIs.add("/"+permission.getUrl());
		}
		
		application.setAttribute(Const.ALL_PERMISSION_URI, allURIs);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
