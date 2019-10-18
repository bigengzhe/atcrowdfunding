package com.course.atcrowdfunding.potal.service;

import java.util.List;

import com.course.atcrowdfunding.bean.Return;

public interface ReturnService {

	int insert(Return re);

	List<Return> selectByProjectid(Integer projectid);

	int deleteByPrimaryKey(Integer id);

	Return selectByPrimarykey(Integer id);

}
