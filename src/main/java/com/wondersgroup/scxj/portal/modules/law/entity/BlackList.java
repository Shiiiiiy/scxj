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

@Entity
@Table(name = "XWCMBLACKLIST")
public class BlackList extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Long id;
	private Long personId;
	private String lawyerName;
	private String lawyerCardnum;
	private String groupName;
	private String blackReason;
	private Integer status;// status   1：无效   0：有效
	private Date staDate;
	private Date endDate;
	private String operatePer;
	private Date operateDate;
	private String description;
	private String cruser;
	private Date crtime;

	public BlackList() {
	}

	public BlackList(Long id) {
		this.id = id;
	}

	public BlackList(Long id, Long personId,String lawyerName,String lawyerCardnum, String groupName, String blackReason,
			Integer status,Date staDate,Date endDate,String operatePer,Date operateDate,String description,String cruser,Date crtime) {
		this.id = id;
		this.personId = personId;
		this.lawyerName= lawyerName;
		this.lawyerCardnum = lawyerCardnum;
		this.groupName = groupName;
		this.blackReason = blackReason;
		this.status = status;
		this.staDate = staDate;
		this.endDate = endDate;
		this.operatePer = operatePer;
		this.operateDate = operateDate;
		this.description = description;
		this.cruser = cruser;
		this.crtime = crtime;
	}

	@Id
	@TableGenerator(name = "TABLE_BLACKLIST_ID_GENERATOR", table = "WCMID", pkColumnName = "TABLENAME", pkColumnValue = "XWCMBLACKLIST", valueColumnName = "NEXTID", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_BLACKLIST_ID_GENERATOR")
	@Column(name = "BLACKLISTID", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "PERSONID")
	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = id;
	}
	
	@Column(name = "LAWYERNAME", length = 50)
	public String getLawyerName() {
		return this.lawyerName;
	}

	public void setLawyerName(String lawyerName) {
		this.lawyerName = lawyerName;
	}
	
	@Column(name = "LAWYERCARDNUM", length = 100)
	public String getLawyerCardnum() {
		return this.lawyerName;
	}

	public void setLawyerCardnum(String lawyerName) {
		this.lawyerName = lawyerName;
	}
	
	@Column(name = "GROUPNAME", length = 150)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	@Column(name = "BLACKREASON", length = 500)
	public String getBlackReason() {
		return this.blackReason;
	}

	public void setBlackReason(String blackReason) {
		this.blackReason = blackReason;
	}

	@Column(name = "STATUS", length = 50)
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "STADATE", length = 7)
	public Date getStaDate() {
		return this.staDate;
	}

	public void setStaDate(Date staDate) {
		this.staDate = staDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE", length = 7)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "OPERATEPER", length = 30)
	public String getOperatePer() {
		return this.operatePer;
	}

	public void setOperatePer(String operatePer) {
		this.operatePer = operatePer;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "OPERATEDATE", length = 7)
	public Date getOperateDate() {
		return this.operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	
	@Column(name = "DESCRIPTION", length = 30)
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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
}
