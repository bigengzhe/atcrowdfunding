package com.course.atcrowdfunding.manager.dao;

import com.course.atcrowdfunding.bean.Permission;
import com.course.atcrowdfunding.bean.Role;
import com.course.atcrowdfunding.bean.User;
import com.course.atcrowdfunding.vo.Data;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

	User queryUserlogin(Map<String, Object> paramMap);
	List<User> queryList(@Param("startIndex") Integer startIndex, @Param("pagesize")  Integer pagesize);

	Integer queryCount();


	List<User> queryList(Map<String, Object> paramMap);//全部分页查询

	Integer queryCount(Map<String, Object> paramMap);
	//int deleteBatchUserByVO(Data data);

	//int deleteBatchUserByVO(List<User> userList);
	
	//int deleteBatchUserByVO(User[] userList);1
	int deleteBatchUserByVO(List<User> datas);

	List<Role> querAllRole();

	List<Integer> queryRoleByUserid(Integer id);

	int saveUserRoleRelationship(@Param("userid") Integer userid,@Param("data") Data data);

	int deleteUserRoleRelationship(@Param("userid") Integer userid,@Param("data")  Data data);

	List<Permission> queryPermissionByUserid(Integer id);

	User getUserByName(String loginacct);

	List<User> selectList(Map<String, Object> paramMap);//按条件查询
	Integer selectCount(Map<String, Object> paramMap);//同上
	
}