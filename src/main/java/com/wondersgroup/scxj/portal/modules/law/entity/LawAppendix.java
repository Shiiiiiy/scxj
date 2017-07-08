package com.wondersgroup.scxj.portal.modules.law.entity;

// Generated 2014-3-28 23:55:25 by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wondersgroup.scxj.portal.common.persistence.BaseEntity;

/**
 * Xwcmlawappendix generated by hbm2java
 */
@Entity
@Table(name = "XWCMLAWAPPENDIX")
@DynamicInsert
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LawAppendix extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long appendixid;
	private String oldfilename;
	private String filename;
	private String apptype;//add by ycl 附件类型：诉讼业务字段值为103，诉讼流程字段值104。
	private Long searchappid;
	private Date crtime;
	
	public LawAppendix() {
	}

	public LawAppendix(Long appendixid) {
		this.appendixid = appendixid;
	}

	public LawAppendix(Long appendixid, String oldfilename,
			String filename, String apptype,Long searchappid, Date crtime) {
		this.appendixid = appendixid;
		this.oldfilename = oldfilename;
		this.filename = filename;
		this.apptype = apptype;
		this.searchappid = searchappid;
		this.crtime = crtime;
	}
	@Id
	@TableGenerator(name = "TABLE_APPENDIX_ID_GENERATOR", table = "WCMID", pkColumnName = "TABLENAME", pkColumnValue = "XWCMLAWAPPENDIX", valueColumnName = "NEXTID", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_APPENDIX_ID_GENERATOR")
	@Column(name = "APPENDIXID", nullable = false)
	public Long getAppendixid() {
		return this.appendixid;
	}

	public void setAppendixid(Long appendixid) {
		this.appendixid = appendixid;
	}

	@Column(name = "OLDFILENAME", nullable = false)
	public String getOldfilename() {
		return this.oldfilename;
	}

	public void setOldfilename(String oldfilename) {
		this.oldfilename = oldfilename;
	}

	@Column(name = "FILENAME", nullable = false)
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	@Column(name = "APPTYPE", nullable = false)
	public String getApptype() {
		return this.apptype;
	}
	
	public void setApptype(String apptype) {
		this.apptype = apptype;
	}
	
	@Column(name = "SEARCHAPPID", nullable = false)
	public Long getSearchappid() {
		return this.searchappid;
	}

	public void setSearchappid(Long searchappid) {
		this.searchappid = searchappid;
	}

	@Column(name = "CRTIME", nullable = true)
	public Date getCrtime() {
		return this.crtime;
	}

	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}

}
