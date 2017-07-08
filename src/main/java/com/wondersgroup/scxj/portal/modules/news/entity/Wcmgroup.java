package com.wondersgroup.scxj.portal.modules.news.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Wcmgroup entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "WCMGROUP", schema = "scxj_DBA")
public class Wcmgroup implements java.io.Serializable {

	// Fields

	private Long groupid;
	private String gname;
	private String gdesc;
	private Long parentid;
	private String email;
	private String attribute;
	private String cruser;
	private Date crtime;
	private Long grouporder;
	private String nameinids;
	private Long iscxj;

	// Constructors

	/** default constructor */
	public Wcmgroup() {
	}

	/** minimal constructor */
	public Wcmgroup(Long groupid) {
		this.groupid = groupid;
	}

	/** full constructor */
	public Wcmgroup(Long groupid, String gname, String gdesc, Long parentid,
			String email, String attribute, String cruser, Date crtime,
			Long grouporder, String nameinids, Long iscxj) {
		this.groupid = groupid;
		this.gname = gname;
		this.gdesc = gdesc;
		this.parentid = parentid;
		this.email = email;
		this.attribute = attribute;
		this.cruser = cruser;
		this.crtime = crtime;
		this.grouporder = grouporder;
		this.nameinids = nameinids;
		this.iscxj = iscxj;
	}

	// Property accessors
	@Id
	@Column(name = "GROUPID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	@Column(name = "GNAME", length = 100)
	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	@Column(name = "GDESC", length = 400)
	public String getGdesc() {
		return this.gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	@Column(name = "PARENTID", precision = 10, scale = 0)
	public Long getParentid() {
		return this.parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	@Column(name = "EMAIL", length = 400)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Column(name = "GROUPORDER", precision = 10, scale = 0)
	public Long getGrouporder() {
		return this.grouporder;
	}

	public void setGrouporder(Long grouporder) {
		this.grouporder = grouporder;
	}

	@Column(name = "NAMEINIDS", length = 100)
	public String getNameinids() {
		return this.nameinids;
	}

	public void setNameinids(String nameinids) {
		this.nameinids = nameinids;
	}

	@Column(name = "Iscxj", precision = 22, scale = 0)
	public Long getIscxj() {
		return this.iscxj;
	}

	public void setIscxj(Long iscxj) {
		this.iscxj = iscxj;
	}

}