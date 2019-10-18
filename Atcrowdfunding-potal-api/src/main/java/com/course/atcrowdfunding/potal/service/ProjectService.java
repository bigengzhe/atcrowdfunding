package com.course.atcrowdfunding.potal.service;

import java.util.List;

import com.course.atcrowdfunding.bean.Project;

public interface ProjectService {

	int insert(Project project);

	List<Project> selectByMemberid(Integer id);

	int deleteByPrimaryKey(Integer id);

	Project selectByProjectId(Integer id);

	int updateProjectById(Project project);

	List<Project> selectAll();

	List<Project> selectStatus(String string);


}
