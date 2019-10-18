package com.course.atcrowdfunding.potal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.atcrowdfunding.bean.Form;
import com.course.atcrowdfunding.potal.dao.FormMapper;
import com.course.atcrowdfunding.potal.service.FormService;
@Service
public class FormServiceImpl implements FormService {
	@Autowired
	private FormMapper formMapper;
	@Override
	public int insert(Form form) {
		// TODO Auto-generated method stub
		return formMapper.insert(form);
	}
	@Override
	public List<Form> selectByMemberid(Integer id) {
		// TODO Auto-generated method stub
		return formMapper.selectByMemberid(id);
	}
	@Override
	public Form selectById(Integer id) {
		// TODO Auto-generated method stub
		return formMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateById(Form form) {
		// TODO Auto-generated method stub
		return formMapper.updateByPrimaryKey(form);
	}

}
