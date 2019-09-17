package com.course.atcrowdfunding.manager.service;

import java.util.List;
import java.util.Map;

import com.course.atcrowdfunding.bean.Role;
import com.course.atcrowdfunding.util.Page;
import com.course.atcrowdfunding.vo.Data;

/**
 * 
 * <p>Title: RoleService.java<／p>
 * <p>Description: 角色模块的业务接口<／p>
 * <p>Copyright: Copyright (c) 2017<／p>
 * <p>Company: course<／p>
 * @author admin
 * @date 2017年8月1日
 * @version 1.0
 */
public interface RoleService {

	public Page<Role> pageQuery(Map<String, Object> paramMap);

	public int queryCount(Map<String, Object> paramMap);

	public void saveRole(Role user);

	public Role getRole(Integer id);

	public int updateRole(Role user);

	public int deleteRole(Integer uid);

	public int batchDeleteRole(Integer[] uid);
	
	public int batchDeleteRole(Data datas);

	public List<Role> queryAllRole();

	public List<Integer> queryRoleidByUserid(Integer id);

	/*public void doAssignRoleByUserid(Integer userid, Integer[] ids);

	public void doUnAssignRoleByUserid(Integer userid, Integer[] ids);*/


	public void doAssignRoleByUserid(Integer userid, List<Integer> ids);

	public void doUnAssignRoleByUserid(Integer userid, List<Integer> ids);

	public int saveRolePermissionRelationship(Integer roleid, Data datas);
}
