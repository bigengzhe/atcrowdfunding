package com.course.atcrowdfunding.manager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.course.atcrowdfunding.bean.Role;
import com.course.atcrowdfunding.bean.RolePermission;
import com.course.atcrowdfunding.vo.Data;

public interface RoleMapper {

	List<Role> pageQuery(Map<String, Object> paramMap);

	int queryCount(Map<String, Object> paramMap);

	void insert(Role user);

	Role getRole(Integer id);

	int update(Role role);

	int delete(Integer uid); 

	int batchDelete(@Param("ids") Integer[] uid);

	int batchDeleteObj(Data datas);

	List<Role> queryAllRole();

	List<Integer> queryRoleidByUserid(Integer id);

	/*void saveUserRole(@Param("userid") Integer userid, @Param("roleids") Integer[] ids);

	void deleteUserRole(@Param("userid") Integer userid,@Param("roleids")  Integer[] ids);*/
	void saveUserRole(@Param("userid") Integer userid, @Param("roleids") List<Integer> ids);
	
	void deleteUserRole(@Param("userid") Integer userid,@Param("roleids")  List<Integer> ids);

	int insertRolePermission(RolePermission rp);

	void deleteRolePermissionRelationship(Integer roleid);

}
