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
 * Xwcmappoperatelogs generated by hbm2java
 */
@Entity
@Table(name = "XWCMAPPOPERATELOGS")
public class AppOperateLogs extends BaseEntity {

	private Long id;
	private String appid;
	private String searchcode;
	private Long sourcedeptid;
	private Long targetdeptid;
	private Long userid;
	private Date operatetime;
	private Long operatetype;
	private String cruser;
	private Date crtime;
	private String lettleusername;
	private String editreson;

	public AppOperateLogs() {
	}

	public AppOperateLogs(Long appoperatelogsid, String appid,
			String searchcode, Date operatetime) {
		this.id = appoperatelogsid;
		this.appid = appid;
		this.searchcode = searchcode;
		this.operatetime = operatetime;
	}

	public AppOperateLogs(Long appoperatelogsid, String appid,
			String searchcode, Long sourcedeptid,
			Long targetdeptid, Long userid, Date operatetime,
			Long operatetype, String cruser, Date crtime,
			String lettleusername, String editreson) {
		this.id = appoperatelogsid;
		this.appid = appid;
		this.searchcode = searchcode;
		this.sourcedeptid = sourcedeptid;
		this.targetdeptid = targetdeptid;
		this.userid = userid;
		this.operatetime = operatetime;
		this.operatetype = operatetype;
		this.cruser = cruser;
		this.crtime = crtime;
		this.lettleusername = lettleusername;
		this.editreson = editreson;
	}

	@Id
	@TableGenerator(name = "TABLE_APP_OPERATE_LOGS_ID_GENERATOR", table = "WCMID", pkColumnName = "TABLENAME", pkColumnValue = "XWCMAPPOPERATELOGS", valueColumnName = "NEXTID", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_APP_OPERATE_LOGS_ID_GENERATOR")
	@Column(name = "APPOPERATELOGSID", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "APPID", nullable = false, length = 3)
	public String getAppid() {
		return this.appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	@Column(name = "SEARCHCODE", nullable = false, length = 15)
	public String getSearchcode() {
		return this.searchcode;
	}

	public void setSearchcode(String searchcode) {
		this.searchcode = searchcode;
	}

	@Column(name = "SOURCEDEPTID", precision = 22, scale = 0)
	public Long getSourcedeptid() {
		return this.sourcedeptid;
	}

	public void setSourcedeptid(Long sourcedeptid) {
		this.sourcedeptid = sourcedeptid;
	}

	@Column(name = "TARGETDEPTID", precision = 22, scale = 0)
	public Long getTargetdeptid() {
		return this.targetdeptid;
	}

	public void setTargetdeptid(Long targetdeptid) {
		this.targetdeptid = targetdeptid;
	}

	@Column(name = "USERID", precision = 22, scale = 0)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OPERATETIME", nullable = false, length = 7)
	public Date getOperatetime() {
		return this.operatetime;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	@Column(name = "OPERATETYPE", precision = 22, scale = 0)
	public Long getOperatetype() {
		return this.operatetype;
	}

	public void setOperatetype(Long operatetype) {
		this.operatetype = operatetype;
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

	@Column(name = "LETTLEUSERNAME", length = 100)
	public String getLettleusername() {
		return this.lettleusername;
	}

	public void setLettleusername(String lettleusername) {
		this.lettleusername = lettleusername;
	}

	@Column(name = "EDITRESON", length = 1000)
	public String getEditreson() {
		return this.editreson;
	}

	public void setEditreson(String editreson) {
		this.editreson = editreson;
	}

}
