package com.wondersgroup.scxj.portal.modules.news.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Xwcmappoperatelogs entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "XWCMAPPOPERATELOGS", schema = "scxj_DBA")
public class Xwcmappoperatelogs implements java.io.Serializable {

	// Fields

	private XwcmappoperatelogsId id;

	// Constructors

	/** default constructor */
	public Xwcmappoperatelogs() {
	}

	/** full constructor */
	public Xwcmappoperatelogs(XwcmappoperatelogsId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "appoperatelogsid", column = @Column(name = "APPOPERATELOGSID", precision = 22, scale = 0)),
			@AttributeOverride(name = "appid", column = @Column(name = "APPID", length = 3)),
			@AttributeOverride(name = "searchcode", column = @Column(name = "SEARCHCODE", length = 15)),
			@AttributeOverride(name = "sourcedeptid", column = @Column(name = "SOURCEDEPTID", precision = 22, scale = 0)),
			@AttributeOverride(name = "targetdeptid", column = @Column(name = "TARGETDEPTID", precision = 22, scale = 0)),
			@AttributeOverride(name = "userid", column = @Column(name = "USERID", precision = 22, scale = 0)),
			@AttributeOverride(name = "operatetime", column = @Column(name = "OPERATETIME", nullable = false, length = 7)),
			@AttributeOverride(name = "operatetype", column = @Column(name = "OPERATETYPE", precision = 22, scale = 0)),
			@AttributeOverride(name = "cruser", column = @Column(name = "CRUSER", length = 30)),
			@AttributeOverride(name = "crtime", column = @Column(name = "CRTIME", length = 7)),
			@AttributeOverride(name = "lettleusername", column = @Column(name = "LETTLEUSERNAME", length = 100)),
			@AttributeOverride(name = "editreson", column = @Column(name = "EDITRESON", length = 1000)) })
	public XwcmappoperatelogsId getId() {
		return this.id;
	}

	public void setId(XwcmappoperatelogsId id) {
		this.id = id;
	}

}