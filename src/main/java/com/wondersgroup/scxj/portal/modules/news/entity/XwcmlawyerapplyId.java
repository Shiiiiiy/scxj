package com.wondersgroup.scxj.portal.modules.news.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * XwcmlawyerapplyId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class XwcmlawyerapplyId implements java.io.Serializable {

	// Fields

	private Long lawyerapplyid;
	private Long applyid;
	private Date applydate;
	private String orderdate;
	private String accusation;
	private String suspectsname;
	private Long isadults;
	private String brief;
	private String entrustname;
	private String relation;
	private String lawyernoticenum;
	private String lawyername;
	private String lawyeridcode;
	private String lawfirmname;
	private String lawyertel;
	private String lawyeremail;
	private String lawyercardnum;
	private String reservation;
	private String searchcode;
	private String searchpass;
	private Long groupid;
	private String groupname;
	private String dealcontent;
	private Long dealstatus;
	private Date dealdate;
	private Long dealuserid;
	private String dealusername;
	private Long isforward;
	private String forwardreason;
	private Long forwardsource;
	private Long issendemail;
	private String cruser;
	private Date crtime;
	private Long isdel;
	private String casetype;
	private String lawsuitpeopletype;
	private String applymattertype;
	private String receptiondate;
	private Long isoverrule;
	private String receptionplace;
	private Long isontime;
	private String notontimereason;
	private Long ismiss;
	private Long feedbackstatus;
	private String acceptnumber;
	private String meetpeople;
	private String meetpeoplemobile;

	// Constructors

	/** default constructor */
	public XwcmlawyerapplyId() {
	}

	/** minimal constructor */
	public XwcmlawyerapplyId(Long lawyerapplyid) {
		this.lawyerapplyid = lawyerapplyid;
	}

	/** full constructor */
	public XwcmlawyerapplyId(Long lawyerapplyid, Long applyid, Date applydate,
			String orderdate, String accusation, String suspectsname,
			Long isadults, String brief, String entrustname, String relation,
			String lawyernoticenum, String lawyername, String lawyeridcode,
			String lawfirmname, String lawyertel, String lawyeremail,
			String lawyercardnum, String reservation, String searchcode,
			String searchpass, Long groupid, String groupname,
			String dealcontent, Long dealstatus, Date dealdate,
			Long dealuserid, String dealusername, Long isforward,
			String forwardreason, Long forwardsource, Long issendemail,
			String cruser, Date crtime, Long isdel, String casetype,
			String lawsuitpeopletype, String applymattertype,
			String receptiondate, Long isoverrule, String receptionplace,
			Long isontime, String notontimereason, Long ismiss,
			Long feedbackstatus, String acceptnumber, String meetpeople,
			String meetpeoplemobile) {
		this.lawyerapplyid = lawyerapplyid;
		this.applyid = applyid;
		this.applydate = applydate;
		this.orderdate = orderdate;
		this.accusation = accusation;
		this.suspectsname = suspectsname;
		this.isadults = isadults;
		this.brief = brief;
		this.entrustname = entrustname;
		this.relation = relation;
		this.lawyernoticenum = lawyernoticenum;
		this.lawyername = lawyername;
		this.lawyeridcode = lawyeridcode;
		this.lawfirmname = lawfirmname;
		this.lawyertel = lawyertel;
		this.lawyeremail = lawyeremail;
		this.lawyercardnum = lawyercardnum;
		this.reservation = reservation;
		this.searchcode = searchcode;
		this.searchpass = searchpass;
		this.groupid = groupid;
		this.groupname = groupname;
		this.dealcontent = dealcontent;
		this.dealstatus = dealstatus;
		this.dealdate = dealdate;
		this.dealuserid = dealuserid;
		this.dealusername = dealusername;
		this.isforward = isforward;
		this.forwardreason = forwardreason;
		this.forwardsource = forwardsource;
		this.issendemail = issendemail;
		this.cruser = cruser;
		this.crtime = crtime;
		this.isdel = isdel;
		this.casetype = casetype;
		this.lawsuitpeopletype = lawsuitpeopletype;
		this.applymattertype = applymattertype;
		this.receptiondate = receptiondate;
		this.isoverrule = isoverrule;
		this.receptionplace = receptionplace;
		this.isontime = isontime;
		this.notontimereason = notontimereason;
		this.ismiss = ismiss;
		this.feedbackstatus = feedbackstatus;
		this.acceptnumber = acceptnumber;
		this.meetpeople = meetpeople;
		this.meetpeoplemobile = meetpeoplemobile;
	}

	// Property accessors

	@Column(name = "LAWYERAPPLYID", nullable = false, precision = 22, scale = 0)
	public Long getLawyerapplyid() {
		return this.lawyerapplyid;
	}

	public void setLawyerapplyid(Long lawyerapplyid) {
		this.lawyerapplyid = lawyerapplyid;
	}

	@Column(name = "APPLYID", precision = 22, scale = 0)
	public Long getApplyid() {
		return this.applyid;
	}

	public void setApplyid(Long applyid) {
		this.applyid = applyid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "APPLYDATE", length = 7)
	public Date getApplydate() {
		return this.applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	@Column(name = "ORDERDATE", length = 500)
	public String getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	@Column(name = "ACCUSATION", length = 500)
	public String getAccusation() {
		return this.accusation;
	}

	public void setAccusation(String accusation) {
		this.accusation = accusation;
	}

	@Column(name = "SUSPECTSNAME", length = 50)
	public String getSuspectsname() {
		return this.suspectsname;
	}

	public void setSuspectsname(String suspectsname) {
		this.suspectsname = suspectsname;
	}

	@Column(name = "ISADULTS", precision = 22, scale = 0)
	public Long getIsadults() {
		return this.isadults;
	}

	public void setIsadults(Long isadults) {
		this.isadults = isadults;
	}

	@Column(name = "BRIEF", length = 3000)
	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@Column(name = "ENTRUSTNAME", length = 50)
	public String getEntrustname() {
		return this.entrustname;
	}

	public void setEntrustname(String entrustname) {
		this.entrustname = entrustname;
	}

	@Column(name = "RELATION", length = 200)
	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Column(name = "LAWYERNOTICENUM", length = 100)
	public String getLawyernoticenum() {
		return this.lawyernoticenum;
	}

	public void setLawyernoticenum(String lawyernoticenum) {
		this.lawyernoticenum = lawyernoticenum;
	}

	@Column(name = "LAWYERNAME", length = 50)
	public String getLawyername() {
		return this.lawyername;
	}

	public void setLawyername(String lawyername) {
		this.lawyername = lawyername;
	}

	@Column(name = "LAWYERIDCODE", length = 50)
	public String getLawyeridcode() {
		return this.lawyeridcode;
	}

	public void setLawyeridcode(String lawyeridcode) {
		this.lawyeridcode = lawyeridcode;
	}

	@Column(name = "LAWFIRMNAME", length = 50)
	public String getLawfirmname() {
		return this.lawfirmname;
	}

	public void setLawfirmname(String lawfirmname) {
		this.lawfirmname = lawfirmname;
	}

	@Column(name = "LAWYERTEL", length = 50)
	public String getLawyertel() {
		return this.lawyertel;
	}

	public void setLawyertel(String lawyertel) {
		this.lawyertel = lawyertel;
	}

	@Column(name = "LAWYEREMAIL", length = 50)
	public String getLawyeremail() {
		return this.lawyeremail;
	}

	public void setLawyeremail(String lawyeremail) {
		this.lawyeremail = lawyeremail;
	}

	@Column(name = "LAWYERCARDNUM", length = 100)
	public String getLawyercardnum() {
		return this.lawyercardnum;
	}

	public void setLawyercardnum(String lawyercardnum) {
		this.lawyercardnum = lawyercardnum;
	}

	@Column(name = "RESERVATION", length = 500)
	public String getReservation() {
		return this.reservation;
	}

	public void setReservation(String reservation) {
		this.reservation = reservation;
	}

	@Column(name = "SEARCHCODE", length = 15)
	public String getSearchcode() {
		return this.searchcode;
	}

	public void setSearchcode(String searchcode) {
		this.searchcode = searchcode;
	}

	@Column(name = "SEARCHPASS", length = 8)
	public String getSearchpass() {
		return this.searchpass;
	}

	public void setSearchpass(String searchpass) {
		this.searchpass = searchpass;
	}

	@Column(name = "GROUPID", precision = 22, scale = 0)
	public Long getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	@Column(name = "GROUPNAME", length = 50)
	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	@Column(name = "DEALCONTENT", length = 4000)
	public String getDealcontent() {
		return this.dealcontent;
	}

	public void setDealcontent(String dealcontent) {
		this.dealcontent = dealcontent;
	}

	@Column(name = "DEALSTATUS", precision = 22, scale = 0)
	public Long getDealstatus() {
		return this.dealstatus;
	}

	public void setDealstatus(Long dealstatus) {
		this.dealstatus = dealstatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DEALDATE", length = 7)
	public Date getDealdate() {
		return this.dealdate;
	}

	public void setDealdate(Date dealdate) {
		this.dealdate = dealdate;
	}

	@Column(name = "DEALUSERID", precision = 22, scale = 0)
	public Long getDealuserid() {
		return this.dealuserid;
	}

	public void setDealuserid(Long dealuserid) {
		this.dealuserid = dealuserid;
	}

	@Column(name = "DEALUSERNAME", length = 50)
	public String getDealusername() {
		return this.dealusername;
	}

	public void setDealusername(String dealusername) {
		this.dealusername = dealusername;
	}

	@Column(name = "ISFORWARD", precision = 22, scale = 0)
	public Long getIsforward() {
		return this.isforward;
	}

	public void setIsforward(Long isforward) {
		this.isforward = isforward;
	}

	@Column(name = "FORWARDREASON", length = 500)
	public String getForwardreason() {
		return this.forwardreason;
	}

	public void setForwardreason(String forwardreason) {
		this.forwardreason = forwardreason;
	}

	@Column(name = "FORWARDSOURCE", precision = 22, scale = 0)
	public Long getForwardsource() {
		return this.forwardsource;
	}

	public void setForwardsource(Long forwardsource) {
		this.forwardsource = forwardsource;
	}

	@Column(name = "ISSENDEMAIL", precision = 22, scale = 0)
	public Long getIssendemail() {
		return this.issendemail;
	}

	public void setIssendemail(Long issendemail) {
		this.issendemail = issendemail;
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

	@Column(name = "ISDEL", precision = 22, scale = 0)
	public Long getIsdel() {
		return this.isdel;
	}

	public void setIsdel(Long isdel) {
		this.isdel = isdel;
	}

	@Column(name = "CASETYPE", length = 500)
	public String getCasetype() {
		return this.casetype;
	}

	public void setCasetype(String casetype) {
		this.casetype = casetype;
	}

	@Column(name = "LAWSUITPEOPLETYPE", length = 500)
	public String getLawsuitpeopletype() {
		return this.lawsuitpeopletype;
	}

	public void setLawsuitpeopletype(String lawsuitpeopletype) {
		this.lawsuitpeopletype = lawsuitpeopletype;
	}

	@Column(name = "APPLYMATTERTYPE", length = 500)
	public String getApplymattertype() {
		return this.applymattertype;
	}

	public void setApplymattertype(String applymattertype) {
		this.applymattertype = applymattertype;
	}

	@Column(name = "RECEPTIONDATE", length = 500)
	public String getReceptiondate() {
		return this.receptiondate;
	}

	public void setReceptiondate(String receptiondate) {
		this.receptiondate = receptiondate;
	}

	@Column(name = "ISOVERRULE", precision = 22, scale = 0)
	public Long getIsoverrule() {
		return this.isoverrule;
	}

	public void setIsoverrule(Long isoverrule) {
		this.isoverrule = isoverrule;
	}

	@Column(name = "RECEPTIONPLACE", length = 500)
	public String getReceptionplace() {
		return this.receptionplace;
	}

	public void setReceptionplace(String receptionplace) {
		this.receptionplace = receptionplace;
	}

	@Column(name = "ISONTIME", precision = 22, scale = 0)
	public Long getIsontime() {
		return this.isontime;
	}

	public void setIsontime(Long isontime) {
		this.isontime = isontime;
	}

	@Column(name = "NOTONTIMEREASON", length = 2000)
	public String getNotontimereason() {
		return this.notontimereason;
	}

	public void setNotontimereason(String notontimereason) {
		this.notontimereason = notontimereason;
	}

	@Column(name = "ISMISS", precision = 22, scale = 0)
	public Long getIsmiss() {
		return this.ismiss;
	}

	public void setIsmiss(Long ismiss) {
		this.ismiss = ismiss;
	}

	@Column(name = "FEEDBACKSTATUS", precision = 22, scale = 0)
	public Long getFeedbackstatus() {
		return this.feedbackstatus;
	}

	public void setFeedbackstatus(Long feedbackstatus) {
		this.feedbackstatus = feedbackstatus;
	}

	@Column(name = "ACCEPTNUMBER", length = 500)
	public String getAcceptnumber() {
		return this.acceptnumber;
	}

	public void setAcceptnumber(String acceptnumber) {
		this.acceptnumber = acceptnumber;
	}

	@Column(name = "MEETPEOPLE", length = 500)
	public String getMeetpeople() {
		return this.meetpeople;
	}

	public void setMeetpeople(String meetpeople) {
		this.meetpeople = meetpeople;
	}

	@Column(name = "MEETPEOPLEMOBILE", length = 500)
	public String getMeetpeoplemobile() {
		return this.meetpeoplemobile;
	}

	public void setMeetpeoplemobile(String meetpeoplemobile) {
		this.meetpeoplemobile = meetpeoplemobile;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof XwcmlawyerapplyId))
			return false;
		XwcmlawyerapplyId castOther = (XwcmlawyerapplyId) other;

		return ((this.getLawyerapplyid() == castOther.getLawyerapplyid()) || (this
				.getLawyerapplyid() != null
				&& castOther.getLawyerapplyid() != null && this
				.getLawyerapplyid().equals(castOther.getLawyerapplyid())))
				&& ((this.getApplyid() == castOther.getApplyid()) || (this
						.getApplyid() != null
						&& castOther.getApplyid() != null && this.getApplyid()
						.equals(castOther.getApplyid())))
				&& ((this.getApplydate() == castOther.getApplydate()) || (this
						.getApplydate() != null
						&& castOther.getApplydate() != null && this
						.getApplydate().equals(castOther.getApplydate())))
				&& ((this.getOrderdate() == castOther.getOrderdate()) || (this
						.getOrderdate() != null
						&& castOther.getOrderdate() != null && this
						.getOrderdate().equals(castOther.getOrderdate())))
				&& ((this.getAccusation() == castOther.getAccusation()) || (this
						.getAccusation() != null
						&& castOther.getAccusation() != null && this
						.getAccusation().equals(castOther.getAccusation())))
				&& ((this.getSuspectsname() == castOther.getSuspectsname()) || (this
						.getSuspectsname() != null
						&& castOther.getSuspectsname() != null && this
						.getSuspectsname().equals(castOther.getSuspectsname())))
				&& ((this.getIsadults() == castOther.getIsadults()) || (this
						.getIsadults() != null
						&& castOther.getIsadults() != null && this
						.getIsadults().equals(castOther.getIsadults())))
				&& ((this.getBrief() == castOther.getBrief()) || (this
						.getBrief() != null
						&& castOther.getBrief() != null && this.getBrief()
						.equals(castOther.getBrief())))
				&& ((this.getEntrustname() == castOther.getEntrustname()) || (this
						.getEntrustname() != null
						&& castOther.getEntrustname() != null && this
						.getEntrustname().equals(castOther.getEntrustname())))
				&& ((this.getRelation() == castOther.getRelation()) || (this
						.getRelation() != null
						&& castOther.getRelation() != null && this
						.getRelation().equals(castOther.getRelation())))
				&& ((this.getLawyernoticenum() == castOther
						.getLawyernoticenum()) || (this.getLawyernoticenum() != null
						&& castOther.getLawyernoticenum() != null && this
						.getLawyernoticenum().equals(
								castOther.getLawyernoticenum())))
				&& ((this.getLawyername() == castOther.getLawyername()) || (this
						.getLawyername() != null
						&& castOther.getLawyername() != null && this
						.getLawyername().equals(castOther.getLawyername())))
				&& ((this.getLawyeridcode() == castOther.getLawyeridcode()) || (this
						.getLawyeridcode() != null
						&& castOther.getLawyeridcode() != null && this
						.getLawyeridcode().equals(castOther.getLawyeridcode())))
				&& ((this.getLawfirmname() == castOther.getLawfirmname()) || (this
						.getLawfirmname() != null
						&& castOther.getLawfirmname() != null && this
						.getLawfirmname().equals(castOther.getLawfirmname())))
				&& ((this.getLawyertel() == castOther.getLawyertel()) || (this
						.getLawyertel() != null
						&& castOther.getLawyertel() != null && this
						.getLawyertel().equals(castOther.getLawyertel())))
				&& ((this.getLawyeremail() == castOther.getLawyeremail()) || (this
						.getLawyeremail() != null
						&& castOther.getLawyeremail() != null && this
						.getLawyeremail().equals(castOther.getLawyeremail())))
				&& ((this.getLawyercardnum() == castOther.getLawyercardnum()) || (this
						.getLawyercardnum() != null
						&& castOther.getLawyercardnum() != null && this
						.getLawyercardnum()
						.equals(castOther.getLawyercardnum())))
				&& ((this.getReservation() == castOther.getReservation()) || (this
						.getReservation() != null
						&& castOther.getReservation() != null && this
						.getReservation().equals(castOther.getReservation())))
				&& ((this.getSearchcode() == castOther.getSearchcode()) || (this
						.getSearchcode() != null
						&& castOther.getSearchcode() != null && this
						.getSearchcode().equals(castOther.getSearchcode())))
				&& ((this.getSearchpass() == castOther.getSearchpass()) || (this
						.getSearchpass() != null
						&& castOther.getSearchpass() != null && this
						.getSearchpass().equals(castOther.getSearchpass())))
				&& ((this.getGroupid() == castOther.getGroupid()) || (this
						.getGroupid() != null
						&& castOther.getGroupid() != null && this.getGroupid()
						.equals(castOther.getGroupid())))
				&& ((this.getGroupname() == castOther.getGroupname()) || (this
						.getGroupname() != null
						&& castOther.getGroupname() != null && this
						.getGroupname().equals(castOther.getGroupname())))
				&& ((this.getDealcontent() == castOther.getDealcontent()) || (this
						.getDealcontent() != null
						&& castOther.getDealcontent() != null && this
						.getDealcontent().equals(castOther.getDealcontent())))
				&& ((this.getDealstatus() == castOther.getDealstatus()) || (this
						.getDealstatus() != null
						&& castOther.getDealstatus() != null && this
						.getDealstatus().equals(castOther.getDealstatus())))
				&& ((this.getDealdate() == castOther.getDealdate()) || (this
						.getDealdate() != null
						&& castOther.getDealdate() != null && this
						.getDealdate().equals(castOther.getDealdate())))
				&& ((this.getDealuserid() == castOther.getDealuserid()) || (this
						.getDealuserid() != null
						&& castOther.getDealuserid() != null && this
						.getDealuserid().equals(castOther.getDealuserid())))
				&& ((this.getDealusername() == castOther.getDealusername()) || (this
						.getDealusername() != null
						&& castOther.getDealusername() != null && this
						.getDealusername().equals(castOther.getDealusername())))
				&& ((this.getIsforward() == castOther.getIsforward()) || (this
						.getIsforward() != null
						&& castOther.getIsforward() != null && this
						.getIsforward().equals(castOther.getIsforward())))
				&& ((this.getForwardreason() == castOther.getForwardreason()) || (this
						.getForwardreason() != null
						&& castOther.getForwardreason() != null && this
						.getForwardreason()
						.equals(castOther.getForwardreason())))
				&& ((this.getForwardsource() == castOther.getForwardsource()) || (this
						.getForwardsource() != null
						&& castOther.getForwardsource() != null && this
						.getForwardsource()
						.equals(castOther.getForwardsource())))
				&& ((this.getIssendemail() == castOther.getIssendemail()) || (this
						.getIssendemail() != null
						&& castOther.getIssendemail() != null && this
						.getIssendemail().equals(castOther.getIssendemail())))
				&& ((this.getCruser() == castOther.getCruser()) || (this
						.getCruser() != null
						&& castOther.getCruser() != null && this.getCruser()
						.equals(castOther.getCruser())))
				&& ((this.getCrtime() == castOther.getCrtime()) || (this
						.getCrtime() != null
						&& castOther.getCrtime() != null && this.getCrtime()
						.equals(castOther.getCrtime())))
				&& ((this.getIsdel() == castOther.getIsdel()) || (this
						.getIsdel() != null
						&& castOther.getIsdel() != null && this.getIsdel()
						.equals(castOther.getIsdel())))
				&& ((this.getCasetype() == castOther.getCasetype()) || (this
						.getCasetype() != null
						&& castOther.getCasetype() != null && this
						.getCasetype().equals(castOther.getCasetype())))
				&& ((this.getLawsuitpeopletype() == castOther
						.getLawsuitpeopletype()) || (this
						.getLawsuitpeopletype() != null
						&& castOther.getLawsuitpeopletype() != null && this
						.getLawsuitpeopletype().equals(
								castOther.getLawsuitpeopletype())))
				&& ((this.getApplymattertype() == castOther
						.getApplymattertype()) || (this.getApplymattertype() != null
						&& castOther.getApplymattertype() != null && this
						.getApplymattertype().equals(
								castOther.getApplymattertype())))
				&& ((this.getReceptiondate() == castOther.getReceptiondate()) || (this
						.getReceptiondate() != null
						&& castOther.getReceptiondate() != null && this
						.getReceptiondate()
						.equals(castOther.getReceptiondate())))
				&& ((this.getIsoverrule() == castOther.getIsoverrule()) || (this
						.getIsoverrule() != null
						&& castOther.getIsoverrule() != null && this
						.getIsoverrule().equals(castOther.getIsoverrule())))
				&& ((this.getReceptionplace() == castOther.getReceptionplace()) || (this
						.getReceptionplace() != null
						&& castOther.getReceptionplace() != null && this
						.getReceptionplace().equals(
								castOther.getReceptionplace())))
				&& ((this.getIsontime() == castOther.getIsontime()) || (this
						.getIsontime() != null
						&& castOther.getIsontime() != null && this
						.getIsontime().equals(castOther.getIsontime())))
				&& ((this.getNotontimereason() == castOther
						.getNotontimereason()) || (this.getNotontimereason() != null
						&& castOther.getNotontimereason() != null && this
						.getNotontimereason().equals(
								castOther.getNotontimereason())))
				&& ((this.getIsmiss() == castOther.getIsmiss()) || (this
						.getIsmiss() != null
						&& castOther.getIsmiss() != null && this.getIsmiss()
						.equals(castOther.getIsmiss())))
				&& ((this.getFeedbackstatus() == castOther.getFeedbackstatus()) || (this
						.getFeedbackstatus() != null
						&& castOther.getFeedbackstatus() != null && this
						.getFeedbackstatus().equals(
								castOther.getFeedbackstatus())))
				&& ((this.getAcceptnumber() == castOther.getAcceptnumber()) || (this
						.getAcceptnumber() != null
						&& castOther.getAcceptnumber() != null && this
						.getAcceptnumber().equals(castOther.getAcceptnumber())))
				&& ((this.getMeetpeople() == castOther.getMeetpeople()) || (this
						.getMeetpeople() != null
						&& castOther.getMeetpeople() != null && this
						.getMeetpeople().equals(castOther.getMeetpeople())))
				&& ((this.getMeetpeoplemobile() == castOther
						.getMeetpeoplemobile()) || (this.getMeetpeoplemobile() != null
						&& castOther.getMeetpeoplemobile() != null && this
						.getMeetpeoplemobile().equals(
								castOther.getMeetpeoplemobile())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getLawyerapplyid() == null ? 0 : this.getLawyerapplyid()
						.hashCode());
		result = 37 * result
				+ (getApplyid() == null ? 0 : this.getApplyid().hashCode());
		result = 37 * result
				+ (getApplydate() == null ? 0 : this.getApplydate().hashCode());
		result = 37 * result
				+ (getOrderdate() == null ? 0 : this.getOrderdate().hashCode());
		result = 37
				* result
				+ (getAccusation() == null ? 0 : this.getAccusation()
						.hashCode());
		result = 37
				* result
				+ (getSuspectsname() == null ? 0 : this.getSuspectsname()
						.hashCode());
		result = 37 * result
				+ (getIsadults() == null ? 0 : this.getIsadults().hashCode());
		result = 37 * result
				+ (getBrief() == null ? 0 : this.getBrief().hashCode());
		result = 37
				* result
				+ (getEntrustname() == null ? 0 : this.getEntrustname()
						.hashCode());
		result = 37 * result
				+ (getRelation() == null ? 0 : this.getRelation().hashCode());
		result = 37
				* result
				+ (getLawyernoticenum() == null ? 0 : this.getLawyernoticenum()
						.hashCode());
		result = 37
				* result
				+ (getLawyername() == null ? 0 : this.getLawyername()
						.hashCode());
		result = 37
				* result
				+ (getLawyeridcode() == null ? 0 : this.getLawyeridcode()
						.hashCode());
		result = 37
				* result
				+ (getLawfirmname() == null ? 0 : this.getLawfirmname()
						.hashCode());
		result = 37 * result
				+ (getLawyertel() == null ? 0 : this.getLawyertel().hashCode());
		result = 37
				* result
				+ (getLawyeremail() == null ? 0 : this.getLawyeremail()
						.hashCode());
		result = 37
				* result
				+ (getLawyercardnum() == null ? 0 : this.getLawyercardnum()
						.hashCode());
		result = 37
				* result
				+ (getReservation() == null ? 0 : this.getReservation()
						.hashCode());
		result = 37
				* result
				+ (getSearchcode() == null ? 0 : this.getSearchcode()
						.hashCode());
		result = 37
				* result
				+ (getSearchpass() == null ? 0 : this.getSearchpass()
						.hashCode());
		result = 37 * result
				+ (getGroupid() == null ? 0 : this.getGroupid().hashCode());
		result = 37 * result
				+ (getGroupname() == null ? 0 : this.getGroupname().hashCode());
		result = 37
				* result
				+ (getDealcontent() == null ? 0 : this.getDealcontent()
						.hashCode());
		result = 37
				* result
				+ (getDealstatus() == null ? 0 : this.getDealstatus()
						.hashCode());
		result = 37 * result
				+ (getDealdate() == null ? 0 : this.getDealdate().hashCode());
		result = 37
				* result
				+ (getDealuserid() == null ? 0 : this.getDealuserid()
						.hashCode());
		result = 37
				* result
				+ (getDealusername() == null ? 0 : this.getDealusername()
						.hashCode());
		result = 37 * result
				+ (getIsforward() == null ? 0 : this.getIsforward().hashCode());
		result = 37
				* result
				+ (getForwardreason() == null ? 0 : this.getForwardreason()
						.hashCode());
		result = 37
				* result
				+ (getForwardsource() == null ? 0 : this.getForwardsource()
						.hashCode());
		result = 37
				* result
				+ (getIssendemail() == null ? 0 : this.getIssendemail()
						.hashCode());
		result = 37 * result
				+ (getCruser() == null ? 0 : this.getCruser().hashCode());
		result = 37 * result
				+ (getCrtime() == null ? 0 : this.getCrtime().hashCode());
		result = 37 * result
				+ (getIsdel() == null ? 0 : this.getIsdel().hashCode());
		result = 37 * result
				+ (getCasetype() == null ? 0 : this.getCasetype().hashCode());
		result = 37
				* result
				+ (getLawsuitpeopletype() == null ? 0 : this
						.getLawsuitpeopletype().hashCode());
		result = 37
				* result
				+ (getApplymattertype() == null ? 0 : this.getApplymattertype()
						.hashCode());
		result = 37
				* result
				+ (getReceptiondate() == null ? 0 : this.getReceptiondate()
						.hashCode());
		result = 37
				* result
				+ (getIsoverrule() == null ? 0 : this.getIsoverrule()
						.hashCode());
		result = 37
				* result
				+ (getReceptionplace() == null ? 0 : this.getReceptionplace()
						.hashCode());
		result = 37 * result
				+ (getIsontime() == null ? 0 : this.getIsontime().hashCode());
		result = 37
				* result
				+ (getNotontimereason() == null ? 0 : this.getNotontimereason()
						.hashCode());
		result = 37 * result
				+ (getIsmiss() == null ? 0 : this.getIsmiss().hashCode());
		result = 37
				* result
				+ (getFeedbackstatus() == null ? 0 : this.getFeedbackstatus()
						.hashCode());
		result = 37
				* result
				+ (getAcceptnumber() == null ? 0 : this.getAcceptnumber()
						.hashCode());
		result = 37
				* result
				+ (getMeetpeople() == null ? 0 : this.getMeetpeople()
						.hashCode());
		result = 37
				* result
				+ (getMeetpeoplemobile() == null ? 0 : this
						.getMeetpeoplemobile().hashCode());
		return result;
	}

}