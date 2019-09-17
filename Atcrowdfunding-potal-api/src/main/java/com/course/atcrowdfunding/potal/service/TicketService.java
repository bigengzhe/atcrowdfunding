package com.course.atcrowdfunding.potal.service;

import com.course.atcrowdfunding.bean.Member;
import com.course.atcrowdfunding.bean.Ticket;

public interface TicketService {

	Ticket getTicketByMemberId(Integer id);

	void saveTicket(com.course.atcrowdfunding.bean.Ticket ticket);

	void updatePstep(Ticket ticket);

	void updatePiidAndPstep(Ticket ticket);

	Member getMemberByPiid(String processInstanceId);

	void updateStatus(Member member);

}
