package com.wondersgroup.scxj.portal.modules.law.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name="message")
public class MessageTemplate {

	@Attribute(name="name")
	String name;
	@Attribute(name="desc")
	String desc;	
	@Attribute(name="content")
	String content;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
