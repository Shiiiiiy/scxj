package com.wondersgroup.scxj.portal.modules.law.entity;

// Generated 2014-3-28 23:55:25 by Hibernate Tools 4.0.0

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.wondersgroup.scxj.portal.common.persistence.BaseEntity;

/**
 * Xwcmcase generated by hbm2java
 */
@Entity
@Table(name = "XWCMCASE")
@DynamicInsert
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WcmCase extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String caseid;
	private String casename;
	private String caseaccepctnum;
	private Long groupid;
	private String groupname;
	private String personid;
	private String personname;
	private String casebrief;
	private String casestage;
	private String relationcaseids;
	private String relationpersonids;
	private Date crtime;
	private String approvedate;
	private String caseaccepctnum1;
	private String caseaccepctnum2;
	private String acceptdate;
	private Clob relationids;

	public WcmCase() {
	}

	public WcmCase(Long id) {
		this.id = id;
	}

	public WcmCase(Long id, String caseid, String casename,
			String caseaccepctnum, Long groupid, String groupname,
			String personid, String personname, String casebrief,
			String casestage, String relationcaseids, String relationpersonids,
			Date crtime, String approvedate, String caseaccepctnum1,
			String caseaccepctnum2, String acceptdate, Clob relationids) {
		this.id = id;
		this.caseid = caseid;
		this.casename = casename;
		this.caseaccepctnum = caseaccepctnum;
		this.groupid = groupid;
		this.groupname = groupname;
		this.personid = personid;
		this.personname = personname;
		this.casebrief = casebrief;
		this.casestage = casestage;
		this.relationcaseids = relationcaseids;
		this.relationpersonids = relationpersonids;
		this.crtime = crtime;
		this.approvedate = approvedate;
		this.caseaccepctnum1 = caseaccepctnum1;
		this.caseaccepctnum2 = caseaccepctnum2;
		this.acceptdate = acceptdate;
		this.relationids = relationids;
	}
	@Id
	@TableGenerator(name = "TABLE_CASE_ID_GENERATOR", table = "WCMID", pkColumnName = "TABLENAME", pkColumnValue = "WCMCASE", valueColumnName = "NEXTID", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_CASE_ID_GENERATOR")
	@Column(name = "ID", nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CASEID", nullable = true)
	public String getCaseid() {
		return this.caseid;
	}

	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}

	@Column(name = "CASENAME", nullable = true)
	public String getCasename() {
		return this.casename;
	}

	public void setCasename(String casename) {
		this.casename = casename;
	}

	@Column(name = "CASEACCEPCTNUM", nullable = true)
	public String getCaseaccepctnum() {
		return this.caseaccepctnum;
	}

	public void setCaseaccepctnum(String caseaccepctnum) {
		this.caseaccepctnum = caseaccepctnum;
	}

	@Column(name = "GROUPID", nullable = true)
	public Long getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	@Column(name = "GROUPNAME", nullable = true, length = 50)
	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	@Column(name = "PERSONID", nullable = true)
	public String getPersonid() {
		return this.personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	@Column(name = "PERSONNAME", nullable = true)
	public String getPersonname() {
		return this.personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	@Column(name = "CASEBRIEF", nullable = true, length = 500)
	public String getCasebrief() {
		return this.casebrief;
	}

	public void setCasebrief(String casebrief) {
		this.casebrief = casebrief;
	}

	@Column(name = "CASESTAGE", nullable = true, length = 500)
	public String getCasestage() {
		return this.casestage;
	}

	public void setCasestage(String casestage) {
		this.casestage = casestage;
	}

	@Column(name = "RELATIONCASEIDS", nullable = true)
	public String getRelationcaseids() {
		return this.relationcaseids;
	}

	public void setRelationcaseids(String relationcaseids) {
		this.relationcaseids = relationcaseids;
	}

	@Column(name = "RELATIONPERSONIDS", nullable = true)
	public String getRelationpersonids() {
		return this.relationpersonids;
	}

	public void setRelationpersonids(String relationpersonids) {
		this.relationpersonids = relationpersonids;
	}

	@Column(name = "CRTIME", nullable = true)
	public Date getCrtime() {
		return this.crtime;
	}

	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}

	@Column(name = "APPROVEDATE", nullable = true)
	public String getApprovedate() {
		return this.approvedate;
	}

	public void setApprovedate(String approvedate) {
		this.approvedate = approvedate;
	}

	@Column(name = "CASEACCEPCTNUM1", nullable = true)
	public String getCaseaccepctnum1() {
		return this.caseaccepctnum1;
	}

	public void setCaseaccepctnum1(String caseaccepctnum1) {
		this.caseaccepctnum1 = caseaccepctnum1;
	}

	@Column(name = "CASEACCEPCTNUM2", nullable = true)
	public String getCaseaccepctnum2() {
		return this.caseaccepctnum2;
	}

	public void setCaseaccepctnum2(String caseaccepctnum2) {
		this.caseaccepctnum2 = caseaccepctnum2;
	}

	@Column(name = "ACCEPTDATE", nullable = true, length = 500)
	public String getAcceptdate() {
		return this.acceptdate;
	}

	public void setAcceptdate(String acceptdate) {
		this.acceptdate = acceptdate;
	}
	
	@Column(name = "RELATIONIDS", nullable = true)
	public Clob getRelationids() {
		return this.relationids;
	}

	public void setRelationids(Clob relationids) {
		this.relationids = relationids;
	}

}
