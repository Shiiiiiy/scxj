package com.wondersgroup.scxj.portal.modules.news.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * XwcmmessagelogsId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class XwcmmessagelogsId implements java.io.Serializable {

	// Fields

	private Long messagelogsid;
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

	// Constructors

	/** default constructor */
	public XwcmmessagelogsId() {
	}

	/** full constructor */
	public XwcmmessagelogsId(Long messagelogsid, String messagetype,
			String messageid, Long apptype, Long appid, String resusername,
			String resuserphone, String result, String beizhu1, String beizhu2,
			String cruser, Date crtime, Long resusertype, Long groupid,
			Long dealstatus, String dealuser, Date dealdate) {
		this.messagelogsid = messagelogsid;
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

	// Property accessors

	@Column(name = "MESSAGELOGSID", precision = 22, scale = 0)
	public Long getMessagelogsid() {
		return this.messagelogsid;
	}

	public void setMessagelogsid(Long messagelogsid) {
		this.messagelogsid = messagelogsid;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof XwcmmessagelogsId))
			return false;
		XwcmmessagelogsId castOther = (XwcmmessagelogsId) other;

		return ((this.getMessagelogsid() == castOther.getMessagelogsid()) || (this
				.getMessagelogsid() != null
				&& castOther.getMessagelogsid() != null && this
				.getMessagelogsid().equals(castOther.getMessagelogsid())))
				&& ((this.getMessagetype() == castOther.getMessagetype()) || (this
						.getMessagetype() != null
						&& castOther.getMessagetype() != null && this
						.getMessagetype().equals(castOther.getMessagetype())))
				&& ((this.getMessageid() == castOther.getMessageid()) || (this
						.getMessageid() != null
						&& castOther.getMessageid() != null && this
						.getMessageid().equals(castOther.getMessageid())))
				&& ((this.getApptype() == castOther.getApptype()) || (this
						.getApptype() != null
						&& castOther.getApptype() != null && this.getApptype()
						.equals(castOther.getApptype())))
				&& ((this.getAppid() == castOther.getAppid()) || (this
						.getAppid() != null
						&& castOther.getAppid() != null && this.getAppid()
						.equals(castOther.getAppid())))
				&& ((this.getResusername() == castOther.getResusername()) || (this
						.getResusername() != null
						&& castOther.getResusername() != null && this
						.getResusername().equals(castOther.getResusername())))
				&& ((this.getResuserphone() == castOther.getResuserphone()) || (this
						.getResuserphone() != null
						&& castOther.getResuserphone() != null && this
						.getResuserphone().equals(castOther.getResuserphone())))
				&& ((this.getResult() == castOther.getResult()) || (this
						.getResult() != null
						&& castOther.getResult() != null && this.getResult()
						.equals(castOther.getResult())))
				&& ((this.getBeizhu1() == castOther.getBeizhu1()) || (this
						.getBeizhu1() != null
						&& castOther.getBeizhu1() != null && this.getBeizhu1()
						.equals(castOther.getBeizhu1())))
				&& ((this.getBeizhu2() == castOther.getBeizhu2()) || (this
						.getBeizhu2() != null
						&& castOther.getBeizhu2() != null && this.getBeizhu2()
						.equals(castOther.getBeizhu2())))
				&& ((this.getCruser() == castOther.getCruser()) || (this
						.getCruser() != null
						&& castOther.getCruser() != null && this.getCruser()
						.equals(castOther.getCruser())))
				&& ((this.getCrtime() == castOther.getCrtime()) || (this
						.getCrtime() != null
						&& castOther.getCrtime() != null && this.getCrtime()
						.equals(castOther.getCrtime())))
				&& ((this.getResusertype() == castOther.getResusertype()) || (this
						.getResusertype() != null
						&& castOther.getResusertype() != null && this
						.getResusertype().equals(castOther.getResusertype())))
				&& ((this.getGroupid() == castOther.getGroupid()) || (this
						.getGroupid() != null
						&& castOther.getGroupid() != null && this.getGroupid()
						.equals(castOther.getGroupid())))
				&& ((this.getDealstatus() == castOther.getDealstatus()) || (this
						.getDealstatus() != null
						&& castOther.getDealstatus() != null && this
						.getDealstatus().equals(castOther.getDealstatus())))
				&& ((this.getDealuser() == castOther.getDealuser()) || (this
						.getDealuser() != null
						&& castOther.getDealuser() != null && this
						.getDealuser().equals(castOther.getDealuser())))
				&& ((this.getDealdate() == castOther.getDealdate()) || (this
						.getDealdate() != null
						&& castOther.getDealdate() != null && this
						.getDealdate().equals(castOther.getDealdate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getMessagelogsid() == null ? 0 : this.getMessagelogsid()
						.hashCode());
		result = 37
				* result
				+ (getMessagetype() == null ? 0 : this.getMessagetype()
						.hashCode());
		result = 37 * result
				+ (getMessageid() == null ? 0 : this.getMessageid().hashCode());
		result = 37 * result
				+ (getApptype() == null ? 0 : this.getApptype().hashCode());
		result = 37 * result
				+ (getAppid() == null ? 0 : this.getAppid().hashCode());
		result = 37
				* result
				+ (getResusername() == null ? 0 : this.getResusername()
						.hashCode());
		result = 37
				* result
				+ (getResuserphone() == null ? 0 : this.getResuserphone()
						.hashCode());
		result = 37 * result
				+ (getResult() == null ? 0 : this.getResult().hashCode());
		result = 37 * result
				+ (getBeizhu1() == null ? 0 : this.getBeizhu1().hashCode());
		result = 37 * result
				+ (getBeizhu2() == null ? 0 : this.getBeizhu2().hashCode());
		result = 37 * result
				+ (getCruser() == null ? 0 : this.getCruser().hashCode());
		result = 37 * result
				+ (getCrtime() == null ? 0 : this.getCrtime().hashCode());
		result = 37
				* result
				+ (getResusertype() == null ? 0 : this.getResusertype()
						.hashCode());
		result = 37 * result
				+ (getGroupid() == null ? 0 : this.getGroupid().hashCode());
		result = 37
				* result
				+ (getDealstatus() == null ? 0 : this.getDealstatus()
						.hashCode());
		result = 37 * result
				+ (getDealuser() == null ? 0 : this.getDealuser().hashCode());
		result = 37 * result
				+ (getDealdate() == null ? 0 : this.getDealdate().hashCode());
		return result;
	}

}