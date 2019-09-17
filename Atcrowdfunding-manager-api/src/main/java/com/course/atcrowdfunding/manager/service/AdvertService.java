package com.course.atcrowdfunding.manager.service;

import java.util.Map;

import com.course.atcrowdfunding.bean.Advert;
import com.course.atcrowdfunding.util.Page;
import com.course.atcrowdfunding.vo.Data;

public interface AdvertService {
	public Advert queryAdvert(Map<String, Object> advertMap);

	public Page<Advert> pageQuery(Map<String, Object> advertMap);

	public int queryCount(Map<String, Object> advertMap);

	public int insertAdvert(Advert advert);

	public Advert queryById(Integer id);

	public int updateAdvert(Advert advert);

	public int deleteAdvert(Integer id);

	public int deleteAdverts(Data ds);
}
