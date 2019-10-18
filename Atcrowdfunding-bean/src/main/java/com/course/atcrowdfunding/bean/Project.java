package com.course.atcrowdfunding.bean;

import org.springframework.web.multipart.MultipartFile;

public class Project {
    private Integer id;

    private String name;

    private String remark;

    private Long money;

    private Integer day;

    private String status;

    private String deploydate;

    private Long supportmoney;

    private Integer supporter;

    private Integer completion;

    private Integer memberid;

    private String createdate;
    
    private MultipartFile headimg;
    
    private double moneyProgress;
    
    public String getHeadimgpath() {
		return headimgpath;
	}

	public String getDetailimgpath() {
		return detailimgpath;
	}

	public void setHeadimgpath(String headimgpath) {
		this.headimgpath = headimgpath;
	}

	public void setDetailimgpath(String detailimgpath) {
		this.detailimgpath = detailimgpath;
	}

	private String headimgpath;
    
    private String detailimgpath;
    
    private MultipartFile detailimg;
    
    private Integer type;
    
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRemark() {
		return remark;
	}

	public Long getMoney() {
		return money;
	}

	public Integer getDay() {
		return day;
	}

	public String getStatus() {
		return status;
	}

	public String getDeploydate() {
		return deploydate;
	}

	public Long getSupportmoney() {
		return supportmoney;
	}

	public Integer getSupporter() {
		return supporter;
	}

	public Integer getCompletion() {
		return completion;
	}

	public Integer getMemberid() {
		return memberid;
	}

	public String getCreatedate() {
		return createdate;
	}

	public MultipartFile getHeadimg() {
		return headimg;
	}

	public MultipartFile getDetailimg() {
		return detailimg;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDeploydate(String deploydate) {
		this.deploydate = deploydate;
	}

	public void setSupportmoney(Long supportmoney) {
		this.supportmoney = supportmoney;
	}

	public void setSupporter(Integer supporter) {
		this.supporter = supporter;
	}

	public void setCompletion(Integer completion) {
		this.completion = completion;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public void setHeadimg(MultipartFile headimg) {
		this.headimg = headimg;
	}

	public void setDetailimg(MultipartFile detailimg) {
		this.detailimg = detailimg;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public double getMoneyProgress() {
		return moneyProgress;
	}

	public void setMoneyProgress(double moneyProgress) {
		this.moneyProgress = moneyProgress;
	}
	

}