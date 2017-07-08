package com.wondersgroup.scxj.portal.modules.news.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Xwcmlawyerapply entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "XWCMLAWYERAPPLY", schema = "scxj_DBA")
public class Xwcmlawyerapply implements java.io.Serializable {

	// Fields

	private XwcmlawyerapplyId id;

	// Constructors

	/** default constructor */
	public Xwcmlawyerapply() {
	}

	/** full constructor */
	public Xwcmlawyerapply(XwcmlawyerapplyId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "lawyerapplyid", column = @Column(name = "LAWYERAPPLYID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "applyid", column = @Column(name = "APPLYID", precision = 22, scale = 0)),
			@AttributeOverride(name = "applydate", column = @Column(name = "APPLYDATE", length = 7)),
			@AttributeOverride(name = "orderdate", column = @Column(name = "ORDERDATE", length = 500)),
			@AttributeOverride(name = "accusation", column = @Column(name = "ACCUSATION", length = 500)),
			@AttributeOverride(name = "suspectsname", column = @Column(name = "SUSPECTSNAME", length = 50)),
			@AttributeOverride(name = "isadults", column = @Column(name = "ISADULTS", precision = 22, scale = 0)),
			@AttributeOverride(name = "brief", column = @Column(name = "BRIEF", length = 3000)),
			@AttributeOverride(name = "entrustname", column = @Column(name = "ENTRUSTNAME", length = 50)),
			@AttributeOverride(name = "relation", column = @Column(name = "RELATION", length = 200)),
			@AttributeOverride(name = "lawyernoticenum", column = @Column(name = "LAWYERNOTICENUM", length = 100)),
			@AttributeOverride(name = "lawyername", column = @Column(name = "LAWYERNAME", length = 50)),
			@AttributeOverride(name = "lawyeridcode", column = @Column(name = "LAWYERIDCODE", length = 50)),
			@AttributeOverride(name = "lawfirmname", column = @Column(name = "LAWFIRMNAME", length = 50)),
			@AttributeOverride(name = "lawyertel", column = @Column(name = "LAWYERTEL", length = 50)),
			@AttributeOverride(name = "lawyeremail", column = @Column(name = "LAWYEREMAIL", length = 50)),
			@AttributeOverride(name = "lawyercardnum", column = @Column(name = "LAWYERCARDNUM", length = 100)),
			@AttributeOverride(name = "reservation", column = @Column(name = "RESERVATION", length = 500)),
			@AttributeOverride(name = "searchcode", column = @Column(name = "SEARCHCODE", length = 15)),
			@AttributeOverride(name = "searchpass", column = @Column(name = "SEARCHPASS", length = 8)),
			@AttributeOverride(name = "groupid", column = @Column(name = "GROUPID", precision = 22, scale = 0)),
			@AttributeOverride(name = "groupname", column = @Column(name = "GROUPNAME", length = 50)),
			@AttributeOverride(name = "dealcontent", column = @Column(name = "DEALCONTENT", length = 4000)),
			@AttributeOverride(name = "dealstatus", column = @Column(name = "DEALSTATUS", precision = 22, scale = 0)),
			@AttributeOverride(name = "dealdate", column = @Column(name = "DEALDATE", length = 7)),
			@AttributeOverride(name = "dealuserid", column = @Column(name = "DEALUSERID", precision = 22, scale = 0)),
			@AttributeOverride(name = "dealusername", column = @Column(name = "DEALUSERNAME", length = 50)),
			@AttributeOverride(name = "isforward", column = @Column(name = "ISFORWARD", precision = 22, scale = 0)),
			@AttributeOverride(name = "forwardreason", column = @Column(name = "FORWARDREASON", length = 500)),
			@AttributeOverride(name = "forwardsource", column = @Column(name = "FORWARDSOURCE", precision = 22, scale = 0)),
			@AttributeOverride(name = "issendemail", column = @Column(name = "ISSENDEMAIL", precision = 22, scale = 0)),
			@AttributeOverride(name = "cruser", column = @Column(name = "CRUSER", length = 30)),
			@AttributeOverride(name = "crtime", column = @Column(name = "CRTIME", length = 7)),
			@AttributeOverride(name = "isdel", column = @Column(name = "ISDEL", precision = 22, scale = 0)),
			@AttributeOverride(name = "casetype", column = @Column(name = "CASETYPE", length = 500)),
			@AttributeOverride(name = "lawsuitpeopletype", column = @Column(name = "LAWSUITPEOPLETYPE", length = 500)),
			@AttributeOverride(name = "applymattertype", column = @Column(name = "APPLYMATTERTYPE", length = 500)),
			@AttributeOverride(name = "receptiondate", column = @Column(name = "RECEPTIONDATE", length = 500)),
			@AttributeOverride(name = "isoverrule", column = @Column(name = "ISOVERRULE", precision = 22, scale = 0)),
			@AttributeOverride(name = "receptionplace", column = @Column(name = "RECEPTIONPLACE", length = 500)),
			@AttributeOverride(name = "isontime", column = @Column(name = "ISONTIME", precision = 22, scale = 0)),
			@AttributeOverride(name = "notontimereason", column = @Column(name = "NOTONTIMEREASON", length = 2000)),
			@AttributeOverride(name = "ismiss", column = @Column(name = "ISMISS", precision = 22, scale = 0)),
			@AttributeOverride(name = "feedbackstatus", column = @Column(name = "FEEDBACKSTATUS", precision = 22, scale = 0)),
			@AttributeOverride(name = "acceptnumber", column = @Column(name = "ACCEPTNUMBER", length = 500)),
			@AttributeOverride(name = "meetpeople", column = @Column(name = "MEETPEOPLE", length = 500)),
			@AttributeOverride(name = "meetpeoplemobile", column = @Column(name = "MEETPEOPLEMOBILE", length = 500)) })
	public XwcmlawyerapplyId getId() {
		return this.id;
	}

	public void setId(XwcmlawyerapplyId id) {
		this.id = id;
	}

}