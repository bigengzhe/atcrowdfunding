package com.course.atcrowdfunding.potal.service;

import java.util.List;

import com.course.atcrowdfunding.bean.Form;

public interface FormService {

	int insert(Form form);

	List<Form> selectByMemberid(Integer id);

	Form selectById(Integer id);

	int updateById(Form form);

}
