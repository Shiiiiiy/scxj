package com.wondersgroup.scxj.portal.modules.news.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Xwcmmessagelogs entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "XWCMMESSAGELOGS", schema = "scxj_DBA")
public class Xwcmmessagelogs implements java.io.Serializable {

	// Fields

	private XwcmmessagelogsId id;

	// Constructors

	/** default constructor */
	public Xwcmmessagelogs() {
	}

	/** full constructor */
	public Xwcmmessagelogs(XwcmmessagelogsId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "messagelogsid", column = @Column(name = "MESSAGELOGSID", precision = 22, scale = 0)),
			@AttributeOverride(name = "messagetype", column = @Column(name = "MESSAGETYPE", length = 50)),
			@AttributeOverride(name = "messageid", column = @Column(name = "MESSAGEID", length = 50)),
			@AttributeOverride(name = "apptype", column = @Column(name = "APPTYPE", precision = 22, scale = 0)),
			@AttributeOverride(name = "appid", column = @Column(name = "APPID", precision = 22, scale = 0)),
			@AttributeOverride(name = "resusername", column = @Column(name = "RESUSERNAME", length = 50)),
			@AttributeOverride(name = "resuserphone", column = @Column(name = "RESUSERPHONE", length = 50)),
			@AttributeOverride(name = "result", column = @Column(name = "RESULT", length = 200)),
			@AttributeOverride(name = "beizhu1", column = @Column(name = "BEIZHU1", length = 500)),
			@AttributeOverride(name = "beizhu2", column = @Column(name = "BEIZHU2", length = 500)),
			@AttributeOverride(name = "cruser", column = @Column(name = "CRUSER", length = 30)),
			@AttributeOverride(name = "crtime", column = @Column(name = "CRTIME", length = 7)),
			@AttributeOverride(name = "resusertype", column = @Column(name = "RESUSERTYPE", precision = 22, scale = 0)),
			@AttributeOverride(name = "groupid", column = @Column(name = "GROUPID", precision = 22, scale = 0)),
			@AttributeOverride(name = "dealstatus", column = @Column(name = "DEALSTATUS", precision = 22, scale = 0)),
			@AttributeOverride(name = "dealuser", column = @Column(name = "DEALUSER", length = 30)),
			@AttributeOverride(name = "dealdate", column = @Column(name = "DEALDATE", length = 7)) })
	public XwcmmessagelogsId getId() {
		return this.id;
	}

	public void setId(XwcmmessagelogsId id) {
		this.id = id;
	}

}