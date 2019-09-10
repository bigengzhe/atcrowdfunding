package com.course.atcrowdfunding.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.course.atcrowdfunding.manager.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService; //依赖倒转原则.

	@RequestMapping("/test")
	public String test(String name) {
		System.out.println("TestController");
		testService.insert();
		return "success";
	}
}
