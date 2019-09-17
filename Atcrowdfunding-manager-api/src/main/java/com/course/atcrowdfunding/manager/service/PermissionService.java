package com.course.atcrowdfunding.manager.service;

import java.util.List;

import com.course.atcrowdfunding.bean.Permission;

public interface PermissionService {

	Permission getRootPermission();

	List<Permission> getChildrenPermissionByPid(Integer id);

	List<Permission> queryAllPermission();

	int savePermission(Permission permission);

	Permission getPermissionById(Integer id);

	int updatePermission(Permission permission);

	int deletePermission(Integer id);

	List<Integer> queryPermissionidsByRoleid(Integer roleid);

}
