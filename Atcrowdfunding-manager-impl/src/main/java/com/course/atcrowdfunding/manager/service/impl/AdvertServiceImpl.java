package com.course.atcrowdfunding.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.atcrowdfunding.bean.Advert;
import com.course.atcrowdfunding.manager.dao.AdvertMapper;
import com.course.atcrowdfunding.manager.service.AdvertService;
import com.course.atcrowdfunding.util.Page;
import com.course.atcrowdfunding.vo.Data;

@Service
public class AdvertServiceImpl implements AdvertService {

	@Autowired
	private AdvertMapper advertDao;

	public Advert queryAdvert(Map<String, Object> advertMap) {
		return advertDao.queryAdvert(advertMap);
	}

	public Page<Advert> pageQuery(Map<String, Object> paramMap) {
		Page<Advert> advertPage = new Page<Advert>((Integer)paramMap.get("pageno"),(Integer)paramMap.get("pagesize"));
		paramMap.put("startIndex", advertPage.getStartIndex());
		List<Advert> advertList= advertDao.pageQuery(paramMap);
		// 获取数据的总条数
		int count = advertDao.queryCount(paramMap);
		
		advertPage.setData(advertList);
		advertPage.setTotalsize(count);
		return advertPage;
	}

	public int queryCount(Map<String, Object> advertMap) {
		return advertDao.queryCount(advertMap);
	}

	public int insertAdvert(Advert advert) {
		return advertDao.insertAdvert(advert);
	}

	public Advert queryById(Integer id) {
		return advertDao.queryById(id);
	}

	public int updateAdvert(Advert advert) {
		return advertDao.updateAdvert(advert);
	}

	public int deleteAdvert(Integer id) {
		return advertDao.deleteAdvert(id);
	}

	public int deleteAdverts(Data ds) {
		return advertDao.deleteAdverts(ds);
	}

}
