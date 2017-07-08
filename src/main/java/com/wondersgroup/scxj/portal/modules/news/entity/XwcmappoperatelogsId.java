package com.wondersgroup.scxj.portal.modules.news.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * XwcmappoperatelogsId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class XwcmappoperatelogsId implements java.io.Serializable {

	// Fields

	private Long appoperatelogsid;
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

	// Constructors

	/** default constructor */
	public XwcmappoperatelogsId() {
	}

	/** minimal constructor */
	public XwcmappoperatelogsId(Date operatetime) {
		this.operatetime = operatetime;
	}

	/** full constructor */
	public XwcmappoperatelogsId(Long appoperatelogsid, String appid,
			String searchcode, Long sourcedeptid, Long targetdeptid,
			Long userid, Date operatetime, Long operatetype, String cruser,
			Date crtime, String lettleusername, String editreson) {
		this.appoperatelogsid = appoperatelogsid;
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

	// Property accessors

	@Column(name = "APPOPERATELOGSID", precision = 22, scale = 0)
	public Long getAppoperatelogsid() {
		return this.appoperatelogsid;
	}

	public void setAppoperatelogsid(Long appoperatelogsid) {
		this.appoperatelogsid = appoperatelogsid;
	}

	@Column(name = "APPID", length = 3)
	public String getAppid() {
		return this.appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	@Column(name = "SEARCHCODE", length = 15)
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof XwcmappoperatelogsId))
			return false;
		XwcmappoperatelogsId castOther = (XwcmappoperatelogsId) other;

		return ((this.getAppoperatelogsid() == castOther.getAppoperatelogsid()) || (this
				.getAppoperatelogsid() != null
				&& castOther.getAppoperatelogsid() != null && this
				.getAppoperatelogsid().equals(castOther.getAppoperatelogsid())))
				&& ((this.getAppid() == castOther.getAppid()) || (this
						.getAppid() != null
						&& castOther.getAppid() != null && this.getAppid()
						.equals(castOther.getAppid())))
				&& ((this.getSearchcode() == castOther.getSearchcode()) || (this
						.getSearchcode() != null
						&& castOther.getSearchcode() != null && this
						.getSearchcode().equals(castOther.getSearchcode())))
				&& ((this.getSourcedeptid() == castOther.getSourcedeptid()) || (this
						.getSourcedeptid() != null
						&& castOther.getSourcedeptid() != null && this
						.getSourcedeptid().equals(castOther.getSourcedeptid())))
				&& ((this.getTargetdeptid() == castOther.getTargetdeptid()) || (this
						.getTargetdeptid() != null
						&& castOther.getTargetdeptid() != null && this
						.getTargetdeptid().equals(castOther.getTargetdeptid())))
				&& ((this.getUserid() == castOther.getUserid()) || (this
						.getUserid() != null
						&& castOther.getUserid() != null && this.getUserid()
						.equals(castOther.getUserid())))
				&& ((this.getOperatetime() == castOther.getOperatetime()) || (this
						.getOperatetime() != null
						&& castOther.getOperatetime() != null && this
						.getOperatetime().equals(castOther.getOperatetime())))
				&& ((this.getOperatetype() == castOther.getOperatetype()) || (this
						.getOperatetype() != null
						&& castOther.getOperatetype() != null && this
						.getOperatetype().equals(castOther.getOperatetype())))
				&& ((this.getCruser() == castOther.getCruser()) || (this
						.getCruser() != null
						&& castOther.getCruser() != null && this.getCruser()
						.equals(castOther.getCruser())))
				&& ((this.getCrtime() == castOther.getCrtime()) || (this
						.getCrtime() != null
						&& castOther.getCrtime() != null && this.getCrtime()
						.equals(castOther.getCrtime())))
				&& ((this.getLettleusername() == castOther.getLettleusername()) || (this
						.getLettleusername() != null
						&& castOther.getLettleusername() != null && this
						.getLettleusername().equals(
								castOther.getLettleusername())))
				&& ((this.getEditreson() == castOther.getEditreson()) || (this
						.getEditreson() != null
						&& castOther.getEditreson() != null && this
						.getEditreson().equals(castOther.getEditreson())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAppoperatelogsid() == null ? 0 : this
						.getAppoperatelogsid().hashCode());
		result = 37 * result
				+ (getAppid() == null ? 0 : this.getAppid().hashCode());
		result = 37
				* result
				+ (getSearchcode() == null ? 0 : this.getSearchcode()
						.hashCode());
		result = 37
				* result
				+ (getSourcedeptid() == null ? 0 : this.getSourcedeptid()
						.hashCode());
		result = 37
				* result
				+ (getTargetdeptid() == null ? 0 : this.getTargetdeptid()
						.hashCode());
		result = 37 * result
				+ (getUserid() == null ? 0 : this.getUserid().hashCode());
		result = 37
				* result
				+ (getOperatetime() == null ? 0 : this.getOperatetime()
						.hashCode());
		result = 37
				* result
				+ (getOperatetype() == null ? 0 : this.getOperatetype()
						.hashCode());
		result = 37 * result
				+ (getCruser() == null ? 0 : this.getCruser().hashCode());
		result = 37 * result
				+ (getCrtime() == null ? 0 : this.getCrtime().hashCode());
		result = 37
				* result
				+ (getLettleusername() == null ? 0 : this.getLettleusername()
						.hashCode());
		result = 37 * result
				+ (getEditreson() == null ? 0 : this.getEditreson().hashCode());
		return result;
	}

}