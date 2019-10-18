package com.course.atcrowdfunding.potal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.atcrowdfunding.bean.Return;
import com.course.atcrowdfunding.potal.dao.ReturnMapper;
import com.course.atcrowdfunding.potal.service.ReturnService;
@Service
public class ReturnServiceImpl implements ReturnService {
	
	@Autowired
	private ReturnMapper returnMapper;
	@Override
	public int insert(Return re) {
		// TODO Auto-generated method stub
		return returnMapper.insert(re);
	}
	@Override
	public List<Return> selectByProjectid(Integer projectid) {
		// TODO Auto-generated method stub
		return returnMapper.selectByProjectid(projectid);
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return returnMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Return selectByPrimarykey(Integer id) {
		// TODO Auto-generated method stub
		return returnMapper.selectByPrimaryKey(id);
	}

}
