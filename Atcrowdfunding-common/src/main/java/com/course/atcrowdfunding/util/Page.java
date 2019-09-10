package com.course.atcrowdfunding.util;

import java.util.List;

public class Page {

	private Integer pageno;//当前页索引
	private Integer pagesize;//页面大小
	private List datas;//当前页数据
	private Integer totalsize;//总记录数
	private Integer totalno;//总页数

	public Page(Integer pageno, Integer pagesize) {
		if (pageno <= 0) {
			this.pageno = 1;
		} else {
			this.pageno = pageno;
		}
		if (pagesize <= 0) {
			this.pagesize = 10;
		} else {
			this.pagesize = pagesize;
		}
	}

	public Integer getPageno() {
		return pageno;
	}

	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public Integer getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(Integer totalsize) {
		this.totalsize = totalsize;
		this.totalno = (totalsize % pagesize) == 0 ? (totalsize / pagesize) : (totalsize / pagesize + 1);
	}

	public Integer getTotalno() {
		return totalno;
	}

	private void setTotalno(Integer totalno) {
		this.totalno = totalno;
	}

	public Integer getStartIndex() {
		return (this.pageno - 1) * pagesize;
	}

}
