package com.wondersgroup.scxj.portal.modules.law.entity;

// Generated 2014-1-20 14:16:03 by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.wondersgroup.scxj.portal.common.persistence.BaseEntity;

/**
 * Xwcmmessagelogs generated by hbm2java
 */
@Entity
@Table(name = "XWCMMESSAGELOGS")
public class MessageLogs extends BaseEntity {

	private Long id;
	private String messagetype;
	private String messageid;
	private Long apptype;
	private Long appid;
	private String resusername;
	private String resuserphone;
	private String result;
	private String beizhu1;
	private String beizhu2;
	private String cruser;
	private Date crtime;
	private Long resusertype;
	private Long groupid;
	private Long dealstatus;
	private String dealuser;
	private Date dealdate;

	public MessageLogs() {
	}

	public MessageLogs(Long messagelogsid) {
		this.id = messagelogsid;
	}

	public MessageLogs(Long messagelogsid, String messagetype,
			String messageid, Long apptype, Long appid,
			String resusername, String resuserphone, String result,
			String beizhu1, String beizhu2, String cruser, Date crtime,
			Long resusertype, Long groupid, Long dealstatus,
			String dealuser, Date dealdate) {
		this.id = messagelogsid;
		this.messagetype = messagetype;
		this.messageid = messageid;
		this.apptype = apptype;
		this.appid = appid;
		this.resusername = resusername;
		this.resuserphone = resuserphone;
		this.result = result;
		this.beizhu1 = beizhu1;
		this.beizhu2 = beizhu2;
		this.cruser = cruser;
		this.crtime = crtime;
		this.resusertype = resusertype;
		this.groupid = groupid;
		this.dealstatus = dealstatus;
		this.dealuser = dealuser;
		this.dealdate = dealdate;
	}

	@Id
	@TableGenerator(name = "TABLE_MESSAGE_LOGS_ID_GENERATOR", table = "WCMID", pkColumnName = "TABLENAME", pkColumnValue = "XWCMMESSAGELOGS", valueColumnName = "NEXTID", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_MESSAGE_LOGS_ID_GENERATOR")
	@Column(name = "MESSAGELOGSID", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	@Column(name = "MESSAGETYPE", length = 50)
	public String getMessagetype() {
		return this.messagetype;
	}

	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}

	@Column(name = "MESSAGEID", length = 50)
	public String getMessageid() {
		return this.messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	@Column(name = "APPTYPE", precision = 22, scale = 0)
	public Long getApptype() {
		return this.apptype;
	}

	public void setApptype(Long apptype) {
		this.apptype = apptype;
	}

	@Column(name = "APPID", precision = 22, scale = 0)
	public Long getAppid() {
		return this.appid;
	}

	public void setAppid(Long appid) {
		this.appid = appid;
	}

	@Column(name = "RESUSERNAME", length = 50)
	public String getResusername() {
		return this.resusername;
	}

	public void setResusername(String resusername) {
		this.resusername = resusername;
	}

	@Column(name = "RESUSERPHONE", length = 50)
	public String getResuserphone() {
		return this.resuserphone;
	}

	public void setResuserphone(String resuserphone) {
		this.resuserphone = resuserphone;
	}

	@Column(name = "RESULT", length = 200)
	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Column(name = "BEIZHU1", length = 500)
	public String getBeizhu1() {
		return this.beizhu1;
	}

	public void setBeizhu1(String beizhu1) {
		this.beizhu1 = beizhu1;
	}

	@Column(name = "BEIZHU2", length = 500)
	public String getBeizhu2() {
		return this.beizhu2;
	}

	public void setBeizhu2(String beizhu2) {
		this.beizhu2 = beizhu2;
	}

	@Column(name = "CRUSER", length = 30)
	public String getCruser() {
		return this.cruser;
	}

	public void setCruser(String cruser) {
		this.cruser = cruser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CRTIME", length = 7)
	public Date getCrtime() {
		return this.crtime;
	}

	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}

	@Column(name = "RESUSERTYPE", precision = 22, scale = 0)
	public Long getResusertype() {
		return this.resusertype;
	}

	public void setResusertype(Long resusertype) {
		this.resusertype = resusertype;
	}

	@Column(name = "GROUPID", precision = 22, scale = 0)
	public Long getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	@Column(name = "DEALSTATUS", precision = 22, scale = 0)
	public Long getDealstatus() {
		return this.dealstatus;
	}

	public void setDealstatus(Long dealstatus) {
		this.dealstatus = dealstatus;
	}

	@Column(name = "DEALUSER", length = 30)
	public String getDealuser() {
		return this.dealuser;
	}

	public void setDealuser(String dealuser) {
		this.dealuser = dealuser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DEALDATE", length = 7)
	public Date getDealdate() {
		return this.dealdate;
	}

	public void setDealdate(Date dealdate) {
		this.dealdate = dealdate;
	}

}
