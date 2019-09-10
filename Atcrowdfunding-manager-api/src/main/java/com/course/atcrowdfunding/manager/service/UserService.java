package com.course.atcrowdfunding.manager.service;

import java.util.List;
import java.util.Map;

import com.course.atcrowdfunding.bean.Role;
import com.course.atcrowdfunding.bean.User;
import com.course.atcrowdfunding.util.Page;
import com.course.atcrowdfunding.vo.Data;

public interface UserService {

	User queryUserlogin(Map<String, Object> paramMap);

	//@Deprecated
	//Page queryPage(Integer pageno, Integer pagesize);
	
	
	int saveUser(User user);

	Page queryPage(Map<String,Object> paramMap);

	User getUserById(Integer id);

	int updateUser(User user);

	int deleteUser(Integer id);

	int deleteBatchUser(Integer[] ids);

	int deleteBatchUserByVO(Data data);

	List<Role> querAllRole();

	List<Integer> queryRoleByUserid(Integer id);
}
