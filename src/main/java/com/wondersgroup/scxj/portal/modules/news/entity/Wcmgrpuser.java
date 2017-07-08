package com.wondersgroup.scxj.portal.modules.news.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Wcmgrpuser entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "WCMGRPUSER", schema = "scxj_DBA", uniqueConstraints = @UniqueConstraint(columnNames = {
		"GROUPID", "USERID" }))
public class Wcmgrpuser implements java.io.Serializable {

	// Fields

	private Long grpuserid;
	private Long groupid;
	private Long userid;
	private String cruser;
	private Date crtime;
	private Long isadministrator;

	// Constructors

	/** default constructor */
	public Wcmgrpuser() {
	}

	/** minimal constructor */
	public Wcmgrpuser(Long grpuserid) {
		this.grpuserid = grpuserid;
	}

	/** full constructor */
	public Wcmgrpuser(Long grpuserid, Long groupid, Long userid, String cruser,
			Date crtime, Long isadministrator) {
		this.grpuserid = grpuserid;
		this.groupid = groupid;
		this.userid = userid;
		this.cruser = cruser;
		this.crtime = crtime;
		this.isadministrator = isadministrator;
	}

	// Property accessors
	@Id
	@Column(name = "GRPUSERID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getGrpuserid() {
		return this.grpuserid;
	}

	public void setGrpuserid(Long grpuserid) {
		this.grpuserid = grpuserid;
	}

	@Column(name = "GROUPID", precision = 10, scale = 0)
	public Long getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	@Column(name = "USERID", precision = 10, scale = 0)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
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

	@Column(name = "ISADMINISTRATOR", precision = 5, scale = 0)
	public Long getIsadministrator() {
		return this.isadministrator;
	}

	public void setIsadministrator(Long isadministrator) {
		this.isadministrator = isadministrator;
	}

}