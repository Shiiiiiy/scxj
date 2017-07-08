package com.wondersgroup.scxj.portal.modules.news.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Wcmuser entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "WCMUSER", schema = "scxj_DBA")
public class Wcmuser implements java.io.Serializable {

	// Fields

	private Long userid;
	private Long status;
	private String username;
	private String password;
	private String nickname;
	private String truename;
	private String address;
	private String tel;
	private String mobile;
	private String email;
	private String reminderquestion;
	private String reminderanswer;
	private Long ifpubmyinfo;
	private Date applytime;
	private Date regtime;
	private Long logintimes;
	private Date logintime;
	private Date logouttime;
	private Long msginterval;
	private Long viewinterval;
	private String attribute;
	private String cruser;
	private Date crtime;
	private Long price;
	private Long isdeleted;
	private Long passwordlev;
	private Long viewdoclevel;

	// Constructors

	/** default constructor */
	public Wcmuser() {
	}

	/** minimal constructor */
	public Wcmuser(Long userid) {
		this.userid = userid;
	}

	/** full constructor */
	public Wcmuser(Long userid, Long status, String username, String password,
			String nickname, String truename, String address, String tel,
			String mobile, String email, String reminderquestion,
			String reminderanswer, Long ifpubmyinfo, Date applytime,
			Date regtime, Long logintimes, Date logintime, Date logouttime,
			Long msginterval, Long viewinterval, String attribute,
			String cruser, Date crtime, Long price, Long isdeleted,
			Long passwordlev, Long viewdoclevel) {
		this.userid = userid;
		this.status = status;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.truename = truename;
		this.address = address;
		this.tel = tel;
		this.mobile = mobile;
		this.email = email;
		this.reminderquestion = reminderquestion;
		this.reminderanswer = reminderanswer;
		this.ifpubmyinfo = ifpubmyinfo;
		this.applytime = applytime;
		this.regtime = regtime;
		this.logintimes = logintimes;
		this.logintime = logintime;
		this.logouttime = logouttime;
		this.msginterval = msginterval;
		this.viewinterval = viewinterval;
		this.attribute = attribute;
		this.cruser = cruser;
		this.crtime = crtime;
		this.price = price;
		this.isdeleted = isdeleted;
		this.passwordlev = passwordlev;
		this.viewdoclevel = viewdoclevel;
	}

	// Property accessors
	@Id
	@Column(name = "USERID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Column(name = "STATUS", precision = 5, scale = 0)
	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	@Column(name = "USERNAME", length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "NICKNAME", length = 100)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "TRUENAME", length = 128)
	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	@Column(name = "ADDRESS", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "TEL", length = 100)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "MOBILE", length = 100)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "EMAIL", length = 2000)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "REMINDERQUESTION", length = 200)
	public String getReminderquestion() {
		return this.reminderquestion;
	}

	public void setReminderquestion(String reminderquestion) {
		this.reminderquestion = reminderquestion;
	}

	@Column(name = "REMINDERANSWER", length = 200)
	public String getReminderanswer() {
		return this.reminderanswer;
	}

	public void setReminderanswer(String reminderanswer) {
		this.reminderanswer = reminderanswer;
	}

	@Column(name = "IFPUBMYINFO", precision = 5, scale = 0)
	public Long getIfpubmyinfo() {
		return this.ifpubmyinfo;
	}

	public void setIfpubmyinfo(Long ifpubmyinfo) {
		this.ifpubmyinfo = ifpubmyinfo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "APPLYTIME", length = 7)
	public Date getApplytime() {
		return this.applytime;
	}

	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REGTIME", length = 7)
	public Date getRegtime() {
		return this.regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	@Column(name = "LOGINTIMES", precision = 10, scale = 0)
	public Long getLogintimes() {
		return this.logintimes;
	}

	public void setLogintimes(Long logintimes) {
		this.logintimes = logintimes;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LOGINTIME", length = 7)
	public Date getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LOGOUTTIME", length = 7)
	public Date getLogouttime() {
		return this.logouttime;
	}

	public void setLogouttime(Date logouttime) {
		this.logouttime = logouttime;
	}

	@Column(name = "MSGINTERVAL", precision = 5, scale = 0)
	public Long getMsginterval() {
		return this.msginterval;
	}

	public void setMsginterval(Long msginterval) {
		this.msginterval = msginterval;
	}

	@Column(name = "VIEWINTERVAL", precision = 5, scale = 0)
	public Long getViewinterval() {
		return this.viewinterval;
	}

	public void setViewinterval(Long viewinterval) {
		this.viewinterval = viewinterval;
	}

	@Column(name = "ATTRIBUTE", length = 1000)
	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	@Column(name = "CRUSER", length = 100)
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

	@Column(name = "PRICE", precision = 10, scale = 0)
	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Column(name = "ISDELETED", precision = 5, scale = 0)
	public Long getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(Long isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Column(name = "PASSWORDLEV", precision = 10, scale = 0)
	public Long getPasswordlev() {
		return this.passwordlev;
	}

	public void setPasswordlev(Long passwordlev) {
		this.passwordlev = passwordlev;
	}

	@Column(name = "VIEWDOCLEVEL", precision = 10, scale = 0)
	public Long getViewdoclevel() {
		return this.viewdoclevel;
	}

	public void setViewdoclevel(Long viewdoclevel) {
		this.viewdoclevel = viewdoclevel;
	}

}