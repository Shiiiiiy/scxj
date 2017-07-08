package com.wondersgroup.scxj.portal.modules.lawyer.entity;



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
@Table(name = "XWCMLEAMASSGE")
public class Leamassge extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String pid;
	private String lmusername;
	private Integer lyone;
	private Integer lytwo;
	private Integer lythr;
	private Integer lyfour;
	private Integer lyfive;
	private String lmsg;
	private String cruser;
	private Date crtime;
	private String dealcontent;

	public Leamassge() {

	}

	public Leamassge(Long id) {
		this.id = id;
	}

	public Leamassge(Long id, String lmusername) {
		this.id = id;
		this.lmusername = lmusername;
	}

	
	public Leamassge(Long id, String pid, String lmusername, Integer lyone, Integer lytwo, Integer lythr,
			Integer lyfour, Integer lyfive, String lmsg, String cruser, Date crtime, String dealcontent) {
		this.id = id;
		this.pid = pid;
		this.lmusername = lmusername;
		this.lyone = lyone;
		this.lytwo = lytwo;
		this.lythr = lythr;
		this.lyfour = lyfour;
		this.lyfive = lyfive;
		this.lmsg = lmsg;
		this.cruser = cruser;
		this.crtime = crtime;
		this.dealcontent = dealcontent;
	}

	@Id
	@TableGenerator(name = "TABLE_LEAMASSGEID_GENERATOR", table = "WCMID", pkColumnName = "TABLENAME", pkColumnValue = "XWCMLEAMASSGE", valueColumnName = "NEXTID", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_LEAMASSGEID_GENERATOR")
	@Column(name = "LEAMASSGEID", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	@Column(name = "LMUSERNAME", length = 20)
	public String getLmusername() {
		return lmusername;
	}

	public void setLmusername(String lmusername) {
		this.lmusername = lmusername;
	}
    @Column(name="LYONE",length=20)
	public Integer getLyone() {
		return lyone;
	}

	public void setLyone(Integer lyone) {
		this.lyone = lyone;
	}
    @Column(name="LYTWO",length=20)
	public Integer getLytwo() {
		return lytwo;
	}

	public void setLytwo(Integer lytwo) {
		this.lytwo = lytwo;
	}
    @Column(name="LYTHR",length=20)
	public Integer getLythr() {
		return lythr;
	}

	public void setLythr(Integer lythr) {
		this.lythr = lythr;
	}
    @Column(name="LYFOUR",length=20)
	public Integer getLyfour() {
		return lyfour;
	}

	public void setLyfour(Integer lyfour) {
		this.lyfour = lyfour;
	}
   @Column(name="LYFIVE",length=20)
	public Integer getLyfive() {
		return lyfive;
	}

	public void setLyfive(Integer lyfive) {
		this.lyfive = lyfive;
	}
    @Column(name="LMSG",length=500)
	public String getLmsg() {
		return lmsg;
	}

	public void setLmsg(String lmsg) {
		this.lmsg = lmsg;
	}
    @Column(name="CRUSER",length=50)
	public String getCruser() {
		return cruser;
	}

	public void setCruser(String cruser) {
		this.cruser = cruser;
	}
    @Temporal(TemporalType.DATE)
    @Column(name="CRTIME",length=7)
	public Date getCrtime() {
		return crtime;
	}

	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	 @Column(name="DEALCONTENT",length=500)
	public String getDealcontent() {
		return dealcontent;
	}

	public void setDealcontent(String dealcontent) {
		this.dealcontent = dealcontent;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", pid=" + pid + ", lmusername=" + lmusername + ", lyone=" + lyone + ", lytwo="
				+ lytwo + ", lythr=" + lythr + ", lyfour=" + lyfour + ", lyfive=" + lyfive + ", lmsg=" + lmsg
				+ ", cruser=" + cruser + ", crtime=" + crtime + "]";
	}
	

}
