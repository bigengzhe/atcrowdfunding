package com.course.atcrowdfunding.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.atcrowdfunding.bean.Permission;
import com.course.atcrowdfunding.manager.dao.PermissionMapper;
import com.course.atcrowdfunding.manager.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public Permission getRootPermission() {
		return permissionMapper.getRootPermission();
	}

	@Override
	public List<Permission> getChildrenPermissionByPid(Integer id) {
		return permissionMapper.getChildrenPermissionByPid(id);
	}

	@Override
	public List<Permission> queryAllPermission() {
		return permissionMapper.queryAllPermission();
	}
	
}
