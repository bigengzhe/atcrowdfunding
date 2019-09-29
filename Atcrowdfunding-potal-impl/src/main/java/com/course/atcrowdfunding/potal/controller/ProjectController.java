package com.course.atcrowdfunding.potal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.course.atcrowdfunding.potal.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@RequestMapping("/project")
	public String project(){
		return "project/project";
	}
	@RequestMapping("/start")
	public String start(){
		return "project/start";
	}
	@RequestMapping("/start-step-1")
	public String startStep1(){
		return "project/start-step-1";
	}
}
