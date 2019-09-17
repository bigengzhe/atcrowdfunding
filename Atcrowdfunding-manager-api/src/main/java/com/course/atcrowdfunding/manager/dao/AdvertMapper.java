package com.course.atcrowdfunding.manager.dao;

import java.util.List;
import java.util.Map;

import com.course.atcrowdfunding.bean.Advert;
import com.course.atcrowdfunding.vo.Data;

public interface AdvertMapper {

	Advert queryAdvert(Map<String, Object> advertMap);

	List<Advert> pageQuery(Map<String, Object> advertMap);

	int queryCount(Map<String, Object> advertMap);

	int insertAdvert(Advert advert);

	Advert queryById(Integer id);

	int updateAdvert(Advert advert);

	int deleteAdvert(Integer id);

	int deleteAdverts(Data ds);
}
