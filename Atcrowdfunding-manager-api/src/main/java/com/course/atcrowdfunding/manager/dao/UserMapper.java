package com.course.atcrowdfunding.manager.dao;

import com.course.atcrowdfunding.bean.Role;
import com.course.atcrowdfunding.bean.User;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

	User queryUserlogin(Map<String, Object> paramMap);
	//List<User> queryList(@Param("startIndex") Integer startIndex, @Param("pagesize")  Integer pagesize);

	//Integer queryCount();


	List<User> queryList(Map<String, Object> paramMap);

	Integer queryCount(Map<String, Object> paramMap);
	//int deleteBatchUserByVO(Data data);

	//int deleteBatchUserByVO(List<User> userList);
	
	//int deleteBatchUserByVO(User[] userList);1
	int deleteBatchUserByVO(List<User> datas);

	List<Role> querAllRole();

	List<Integer> queryRoleByUserid(Integer id);
}