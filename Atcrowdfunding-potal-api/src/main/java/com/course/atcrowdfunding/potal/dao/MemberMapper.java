package com.course.atcrowdfunding.potal.dao;

import com.course.atcrowdfunding.bean.Member;
import java.util.List;
import java.util.Map;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Member member);

    Member selectByPrimaryKey(Integer id);

    List<Member> selectAll();

    int updateByPrimaryKey(Member record);

	Member queryMebmerlogin(Map<String, Object> paramMap);

	void updateAcctType(Member loginMember);

	void updateBasicinfo(Member loginMember);

	void updateEmail(Member loginMember);

	void updateAuthstatus(Member loginMember);

	Member getMemberById(Integer memberid);

	List<Map<String, Object>> queryCertByMemberid(Integer memberid);
}