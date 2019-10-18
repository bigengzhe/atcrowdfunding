package com.course.atcrowdfunding.potal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.atcrowdfunding.bean.Project;
import com.course.atcrowdfunding.potal.dao.ProjectMapper;
import com.course.atcrowdfunding.potal.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectMapper projectMapper;
	@Override
	public int insert(Project project) {
		// TODO Auto-generated method stub
		return projectMapper.insert(project);
	}
	@Override
	public List<Project> selectByMemberid(Integer id) {
		// TODO Auto-generated method stub
		return projectMapper.selectByMemberid(id);
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return projectMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Project selectByProjectId(Integer id) {
		// TODO Auto-generated method stub
		return projectMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateProjectById(Project project) {
		// TODO Auto-generated method stub
		return projectMapper.updateByPrimaryKey(project);
	}
	@Override
	public List<Project> selectAll() {
		// TODO Auto-generated method stub
		return projectMapper.selectAll();
	}
	@Override
	public List<Project> selectStatus(String string) {
		// TODO Auto-generated method stub
		return projectMapper.selectStatus(string);
	}

}
