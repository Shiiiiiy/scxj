package com.wondersgroup.scxj.portal.modules.news.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.wondersgroup.scxj.portal.common.persistence.DataEntity;

/**
 * Xwcmlawyer entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "XWCMLAWYER", schema = "scxj_DBA")
public class Xwcmlawyer  implements java.io.Serializable {

	private Long lawid;
	private String lawyerid;
	private String personid;
	private String lawfirmid;
	private Long practicetype;
	private String name;
	private Long gender;
	private String politic;
	private String portrait;
	private String position;
	private String education;
	private String nation;
	private String faith;
	private String idnumber;
	private String birthday;
	private String address;
	private String phone;
	private String fax;
	private String mobile;
	private String email;
	private Long practicestatus;
	private Date lastupdatedate;
	private String lisensenumber;
	private String lawfirmname;
	private String lawfirmaddress;
	private String lawfirmjusticebureau;
	private String lawfirmpinyin;
	private Date lawfirmlastupdatedate;
	private String membernumber;

	// Property accessors
	@Id
	@Column(name = "LAWID", precision = 22, scale = 0)
	public Long getLawid() {
		return this.lawid;
	}

	public void setLawid(Long lawid) {
		this.lawid = lawid;
	}

	@Column(name = "LAWYERID", length = 50)
	public String getLawyerid() {
		return this.lawyerid;
	}

	public void setLawyerid(String lawyerid) {
		this.lawyerid = lawyerid;
	}

	@Column(name = "PERSONID", length = 50)
	public String getPersonid() {
		return this.personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	@Column(name = "LAWFIRMID", length = 50)
	public String getLawfirmid() {
		return this.lawfirmid;
	}

	public void setLawfirmid(String lawfirmid) {
		this.lawfirmid = lawfirmid;
	}

	@Column(name = "PRACTICETYPE", precision = 22, scale = 0)
	public Long getPracticetype() {
		return this.practicetype;
	}

	public void setPracticetype(Long practicetype) {
		this.practicetype = practicetype;
	}

	@Column(name = "NAME", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "GENDER", precision = 22, scale = 0)
	public Long getGender() {
		return this.gender;
	}

	public void setGender(Long gender) {
		this.gender = gender;
	}

	@Column(name = "POLITIC", length = 50)
	public String getPolitic() {
		return this.politic;
	}

	public void setPolitic(String politic) {
		this.politic = politic;
	}

	@Column(name = "PORTRAIT", length = 200)
	public String getPortrait() {
		return this.portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	@Column(name = "POSITION", length = 50)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "EDUCATION", length = 50)
	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Column(name = "NATION", length = 50)
	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name = "FAITH", length = 50)
	public String getFaith() {
		return this.faith;
	}

	public void setFaith(String faith) {
		this.faith = faith;
	}

	@Column(name = "IDNUMBER", length = 50)
	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	@Column(name = "BIRTHDAY", length = 50)
	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(name = "ADDRESS", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "PHONE", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "FAX", length = 50)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "MOBILE", length = 50)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PRACTICESTATUS", precision = 22, scale = 0)
	public Long getPracticestatus() {
		return this.practicestatus;
	}

	public void setPracticestatus(Long practicestatus) {
		this.practicestatus = practicestatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LASTUPDATEDATE", length = 7)
	public Date getLastupdatedate() {
		return this.lastupdatedate;
	}

	public void setLastupdatedate(Date lastupdatedate) {
		this.lastupdatedate = lastupdatedate;
	}

	@Column(name = "LISENSENUMBER", length = 50)
	public String getLisensenumber() {
		return this.lisensenumber;
	}

	public void setLisensenumber(String lisensenumber) {
		this.lisensenumber = lisensenumber;
	}

	@Column(name = "LAWFIRMNAME", length = 200)
	public String getLawfirmname() {
		return this.lawfirmname;
	}

	public void setLawfirmname(String lawfirmname) {
		this.lawfirmname = lawfirmname;
	}

	@Column(name = "LAWFIRMADDRESS", length = 200)
	public String getLawfirmaddress() {
		return this.lawfirmaddress;
	}

	public void setLawfirmaddress(String lawfirmaddress) {
		this.lawfirmaddress = lawfirmaddress;
	}

	@Column(name = "LAWFIRMJUSTICEBUREAU", length = 200)
	public String getLawfirmjusticebureau() {
		return this.lawfirmjusticebureau;
	}

	public void setLawfirmjusticebureau(String lawfirmjusticebureau) {
		this.lawfirmjusticebureau = lawfirmjusticebureau;
	}

	@Column(name = "LAWFIRMPINYIN", length = 200)
	public String getLawfirmpinyin() {
		return this.lawfirmpinyin;
	}

	public void setLawfirmpinyin(String lawfirmpinyin) {
		this.lawfirmpinyin = lawfirmpinyin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LAWFIRMLASTUPDATEDATE", length = 7)
	public Date getLawfirmlastupdatedate() {
		return this.lawfirmlastupdatedate;
	}

	public void setLawfirmlastupdatedate(Date lawfirmlastupdatedate) {
		this.lawfirmlastupdatedate = lawfirmlastupdatedate;
	}

	@Column(name = "MEMBERNUMBER", length = 200)
	public String getMembernumber() {
		return this.membernumber;
	}

	public void setMembernumber(String membernumber) {
		this.membernumber = membernumber;
	}

}