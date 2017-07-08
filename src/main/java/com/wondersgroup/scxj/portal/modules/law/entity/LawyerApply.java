/**
 * Copyright &copy; 2012-2013 <a href="http://www.wondersgroup.com/">shjcy</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wondersgroup.scxj.portal.modules.law.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.wondersgroup.scxj.portal.common.persistence.BaseEntity;

/**
 * 诉讼业务办理表单Entity
 * 
 * @author LiRiChen
 * @version 2013-05-15
 */
@Entity
@Table(name = "XWCMLAWYERAPPLY")
@DynamicInsert
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LawyerApply extends BaseEntity {

	private static final long serialVersionUID = 1L;
	public static final String SEARCHAPPID = "lawyerappid";	
	private Long id; // 编号
	private Integer applyId;// 分类编号
	private Date applyDate; // 标题
	private String orderDate;
	private String accusation;
	private String suspectsName;
	private Integer isAdults;
	private String brief;
	private String entrustName;
	private String relation;
	private String lawyerNoticeNum;
	private String lawyerName;
	private String lawyerIdcode;
	private String lawfirmName;
	private String lawyerTel;
	private String lawyerEmail;
	private String lawyerCardnum;
	private String reservation;
	private String searchCode;
	private String searchPass;
	private Long groupId;
	private String groupName;
	private String dealContent;
	private Integer dealStatus = 0;
	private Date dealDate;
	private Long dealUserid;
	private String dealUserName;
	private Integer isforward;
	private String forwardReason;
	private Integer forwardSource;
	private Integer issendEmail;
	private String cruser;
	private Date crtime;
	private Integer isdel = 0;
	private String caseType;
	private String lawsuitPeopleType;
	private String applyMatterType;
	private String receptionDate;
	private Integer isOverrule = -1;
	private String receptionPlace;
	private Integer isOntime = -1;
	private String notontimeReason;
	private Integer ismiss = -1;
	private Integer feedbackStatus = -1;
	private String acceptNumber;
	private String meetPeople;
	private String meetPeopleMobile;
	
	private String status;
	
	private String suspectsBriefName;
	
	private String confirmTimeLeft;
	
	private String lawyerRegTel;
	private String lawyerRegEmail;
	
	private Integer canCancel = -1; 
	
	private List<LawAppendix> lawAppendixs = Lists.newArrayList();

	@Id
	@TableGenerator(name = "TABLE_LAWYER_APPLY_ID_GENERATOR", table = "WCMID", pkColumnName = "TABLENAME", pkColumnValue = "XWCMLAWYERAPPLY", valueColumnName = "NEXTID", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_LAWYER_APPLY_ID_GENERATOR")
	@Column(name = "LAWYERAPPLYID", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "APPLYID", nullable = false)
	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	@Column(name = "APPLYDATE", nullable = true)
	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	@Column(name = "ORDERDATE", nullable = true, length = 500)
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "ACCUSATION", nullable = true, length = 512)
	public String getAccusation() {
		return accusation;
	}

	public void setAccusation(String accusation) {
		this.accusation = accusation;
	}

	@Column(name = "SUSPECTSNAME", nullable = true, length = 50)
	public String getSuspectsName() {
		return suspectsName;
	}

	public void setSuspectsName(String suspectsName) {
		this.suspectsName = suspectsName;
	}

	@Column(name = "ISADULTS", nullable = true)
	public Integer getIsAdults() {
		return isAdults;
	}

	public void setIsAdults(Integer isAdults) {
		this.isAdults = isAdults;
	}

	@Column(name = "BRIEF", nullable = true, length = 3000)
	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@Column(name = "ENTRUSTNAME", nullable = true, length = 50)
	public String getEntrustName() {
		return entrustName;
	}

	public void setEntrustName(String entrustName) {
		this.entrustName = entrustName;
	}

	@Column(name = "RELATION", nullable = true, length = 200)
	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Column(name = "LAWYERNOTICENUM", nullable = true, length = 100)
	public String getLawyerNoticeNum() {
		return lawyerNoticeNum;
	}

	public void setLawyerNoticeNum(String lawyerNoticeNum) {
		this.lawyerNoticeNum = lawyerNoticeNum;
	}

	@Column(name = "LAWYERNAME", nullable = true, length = 50)
	public String getLawyerName() {
		return lawyerName;
	}

	public void setLawyerName(String lawyerName) {
		this.lawyerName = lawyerName;
	}

	@Column(name = "LAWYERIDCODE", nullable = true, length = 50)
	public String getLawyerIdcode() {
		return lawyerIdcode;
	}

	public void setLawyerIdcode(String lawyerIdcode) {
		this.lawyerIdcode = lawyerIdcode;
	}

	@Column(name = "LAWFIRMNAME", nullable = true, length = 50)
	public String getLawfirmName() {
		return lawfirmName;
	}

	public void setLawfirmName(String lawfirmName) {
		this.lawfirmName = lawfirmName;
	}

	@Column(name = "LAWYERTEL", nullable = true, length = 50)
	public String getLawyerTel() {
		return lawyerTel;
	}

	public void setLawyerTel(String lawyerTel) {
		this.lawyerTel = lawyerTel;
	}

	@Column(name = "LAWYEREMAIL", nullable = true, length = 50)
	public String getLawyerEmail() {
		return lawyerEmail;
	}

	public void setLawyerEmail(String lawyerEmail) {
		this.lawyerEmail = lawyerEmail;
	}

	@Column(name = "LAWYERCARDNUM", nullable = true, length = 100)
	public String getLawyerCardnum() {
		return lawyerCardnum;
	}

	public void setLawyerCardnum(String lawyerCardnum) {
		this.lawyerCardnum = lawyerCardnum;
	}

	@Column(name = "RESERVATION", nullable = true, length = 500)
	public String getReservation() {
		return reservation;
	}

	public void setReservation(String reservation) {
		this.reservation = reservation;
	}

	@Column(name = "SEARCHCODE", nullable = true, length = 15)
	public String getSearchCode() {
		return searchCode;
	}

	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}

	@Column(name = "SEARCHPASS", nullable = true, length = 8)
	public String getSearchPass() {
		return searchPass;
	}

	public void setSearchPass(String searchPass) {
		this.searchPass = searchPass;
	}

	@Column(name = "GROUPID", nullable = true)
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Column(name = "GROUPNAME", nullable = true, length = 50)
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "DEALCONTENT", nullable = true, length = 4000)
	public String getDealContent() {
		return dealContent;
	}

	public void setDealContent(String dealContent) {
		this.dealContent = dealContent;
	}

	@Column(name = "DEALSTATUS", nullable = true)
	public Integer getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}

	@Column(name = "DEALDATE", nullable = true)
	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	@Column(name = "DEALUSERID", nullable = true)
	public Long getDealUserid() {
		return dealUserid;
	}

	public void setDealUserid(Long dealUserid) {
		this.dealUserid = dealUserid;
	}

	@Column(name = "DEALUSERNAME", nullable = true, length = 50)
	public String getDealUserName() {
		return dealUserName;
	}

	public void setDealUserName(String dealUserName) {
		this.dealUserName = dealUserName;
	}

	@Column(name = "ISFORWARD", nullable = true)
	public Integer getIsforward() {
		return isforward;
	}

	public void setIsforward(Integer isforward) {
		this.isforward = isforward;
	}

	@Column(name = "FORWARDREASON", nullable = true, length = 500)
	public String getForwardReason() {
		return forwardReason;
	}

	public void setForwardReason(String forwardReason) {
		this.forwardReason = forwardReason;
	}

	@Column(name = "FORWARDSOURCE", nullable = true)
	public Integer getForwardSource() {
		return forwardSource;
	}

	public void setForwardSource(Integer forwardSource) {
		this.forwardSource = forwardSource;
	}

	@Column(name = "ISSENDEMAIL", nullable = true, length = 512)
	public Integer getIssendEmail() {
		return issendEmail;
	}

	public void setIssendEmail(Integer issendEmail) {
		this.issendEmail = issendEmail;
	}

	@Column(name = "CRUSER", nullable = true, length = 30)
	public String getCruser() {
		return cruser;
	}

	public void setCruser(String cruser) {
		this.cruser = cruser;
	}

	@Column(name = "CRTIME", nullable = true)
	public Date getCrtime() {
		return crtime;
	}

	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}

	@Column(name = "ISDEL", nullable = true)
	public Integer getIsdel() {
		return isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

	@Column(name = "CASETYPE", nullable = true, length = 500)
	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	@Column(name = "LAWSUITPEOPLETYPE", nullable = true, length = 500)
	public String getLawsuitPeopleType() {
		return lawsuitPeopleType;
	}

	public void setLawsuitPeopleType(String lawsuitPeopleType) {
		this.lawsuitPeopleType = lawsuitPeopleType;
	}

	@Column(name = "APPLYMATTERTYPE", nullable = true, length = 500)
	public String getApplyMatterType() {
		return applyMatterType;
	}

	public void setApplyMatterType(String applyMatterType) {
		this.applyMatterType = applyMatterType;
	}

	@Column(name = "RECEPTIONDATE", nullable = true, length = 500)
	public String getReceptionDate() {
		return receptionDate;
	}

	public void setReceptionDate(String receptionDate) {
		this.receptionDate = receptionDate;
	}

	@Column(name = "ISOVERRULE", nullable = true)
	public Integer getIsOverrule() {
		return isOverrule;
	}

	public void setIsOverrule(Integer isOverrule) {
		this.isOverrule = isOverrule;
	}

	@Column(name = "RECEPTIONPLACE", nullable = true, length = 500)
	public String getReceptionPlace() {
		return receptionPlace;
	}

	public void setReceptionPlace(String receptionPlace) {
		this.receptionPlace = receptionPlace;
	}

	@Column(name = "ISONTIME", nullable = true)
	public Integer getIsOntime() {
		return isOntime;
	}

	public void setIsOntime(Integer isOntime) {
		this.isOntime = isOntime;
	}

	@Column(name = "NOTONTIMEREASON", nullable = true, length = 2000)
	public String getNotontimeReason() {
		return notontimeReason;
	}

	public void setNotontimeReason(String notontimeReason) {
		this.notontimeReason = notontimeReason;
	}

	@Column(name = "ISMISS", nullable = true)
	public Integer getIsmiss() {
		return ismiss;
	}

	public void setIsmiss(Integer ismiss) {
		this.ismiss = ismiss;
	}

	@Column(name = "FEEDBACKSTATUS", nullable = true)
	public Integer getFeedbackStatus() {
		return feedbackStatus;
	}

	public void setFeedbackStatus(Integer feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}

	@Column(name = "ACCEPTNUMBER", nullable = true, length = 500)
	public String getAcceptNumber() {
		return acceptNumber;
	}

	public void setAcceptNumber(String acceptNumber) {
		this.acceptNumber = acceptNumber;
	}

	@Column(name = "MEETPEOPLE", nullable = true, length = 500)
	public String getMeetPeople() {
		return meetPeople;
	}

	public void setMeetPeople(String meetPeople) {
		this.meetPeople = meetPeople;
	}

	@Column(name = "MEETPEOPLEMOBILE", nullable = true, length = 500)
	public String getMeetPeopleMobile() {
		return meetPeopleMobile;
	}

	public void setMeetPeopleMobile(String meetPeopleMobile) {
		this.meetPeopleMobile = meetPeopleMobile;
	}
	
	@Transient
	public String getStatus(){
		String resultString = "";
		int dealStatus = this.getDealStatus();
		int isMiss = this.getIsmiss();
		int FeedbackStatus  = this.getFeedbackStatus();
		//resultString = "FeedbackStatus:"+FeedbackStatus+" dealStatus:"+dealStatus+" isMiss:"+isMiss);
		/*if(FeedbackStatus==APPLY_FEEDBACK_STATUS_LAW_CANCEL
			||FeedbackStatus==APPLY_FEEDBACK_STATUS_SYS_CANCEL ||FeedbackStatus==APPLY_FEEDBACK_STATUS_LAW_NOONTIME_CANCEL ||FeedbackStatus==APPLY_FEEDBACK_STATUS_LAW_SHOULI_CANCEL
		    ||FeedbackStatus==APPLY_FEEDBACK_STATUS_LAW_QUEREN_CANCEL){
			resultString = "已取消";
		}else */if(isMiss==1){
			resultString = "已爽约";
		}else if(dealStatus==APPLY_DEAL_STATUS_DEALEND){
			resultString = "接待完毕";
		}else if(dealStatus==APPLY_DEAL_STATUS_BACK){
		    resultString = "已退回";
		}else if(dealStatus==APPLY_DEAL_STATUS_CANCEL){
		    resultString = "已取消";
		}/*else if(isMiss==0){
			resultString = "未爽约";
		}*/else if(FeedbackStatus==APPLY_FEEDBACK_STATUS_LAW_CANCEL
			||FeedbackStatus==APPLY_FEEDBACK_STATUS_SYS_CANCEL 
			||FeedbackStatus==APPLY_FEEDBACK_STATUS_LAW_NOONTIME_CANCEL 
			||FeedbackStatus==APPLY_FEEDBACK_STATUS_LAW_SHOULI_CANCEL
		    ||FeedbackStatus==APPLY_FEEDBACK_STATUS_LAW_QUEREN_CANCEL
			||FeedbackStatus==APPLY_FEEDBACK_STATUS_WORKER_CANCEL){
			resultString = "已取消";
		}else if(dealStatus==APPLY_DEAL_STATUS_PUBLISH && FeedbackStatus==APPLY_FEEDBACK_STATUS_VERIFY){
			resultString = "已确认";
		}else if(dealStatus==APPLY_DEAL_STATUS_PUBLISH && FeedbackStatus<0){
			resultString = "<font color=\"#ff8800\">待确认</font>";
		}/*else if(dealStatus==APPLY_DEAL_STATUS_REMARK or dealStatus==APPLY_DEAL_STATUS_SIGN){
			resultString = "待发布";
		}*/else if(dealStatus==APPLY_DEAL_STATUS_REMARK || dealStatus==APPLY_DEAL_STATUS_SIGN){
			resultString = "待回复";
		}else if(dealStatus==APPLY_DEAL_STATUS_NEW){
			resultString = "待受理";
		}else if(dealStatus==APPLY_DEAL_STATUS_DATA_FAULT){
			resultString = "材料缺失";
		}else if(dealStatus==APPLY_DEAL_STATUS_DATA_FULL){
			resultString = "材料补齐";
		}
		return resultString;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Transient
	public Integer getCanCancel() {
		return canCancel;
	}

	public void setCanCancel(Integer canCancel) {
		this.canCancel = canCancel;
	}

	@Transient
	public String getLawyerRegTel() {
		return lawyerRegTel;
	}

	public void setLawyerRegTel(String lawyerRegTel) {
		this.lawyerRegTel = lawyerRegTel;
	}

	@Transient
	public String getLawyerRegEmail() {
		return lawyerRegEmail;
	}

	public void setLawyerRegEmail(String lawyerRegEmail) {
		this.lawyerRegEmail = lawyerRegEmail;
	}

	@Transient
	@JsonIgnore
	public String getSuspectsBriefName() {
		return suspectsName + brief + "案";
	}

	@Transient
	public String getConfirmTimeLeft() {
		return confirmTimeLeft;
	}

	public void setConfirmTimeLeft(String confirmTimeLeft) {
		this.confirmTimeLeft = confirmTimeLeft;
	}

	@Transient
	@JsonIgnore
	public List<LawAppendix> getLawAppendixs() {
		return lawAppendixs;
	}

	public void setLawAppendixs(List<LawAppendix> lawAppendixs) {
		this.lawAppendixs = lawAppendixs;
	}

}
