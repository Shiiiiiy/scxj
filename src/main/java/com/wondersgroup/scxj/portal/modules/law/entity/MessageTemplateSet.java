package com.wondersgroup.scxj.portal.modules.law.entity;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="app")
public class MessageTemplateSet {

    @ElementList(inline=true)
    private List<MessageTemplate> list;

	public List<MessageTemplate> getList() {
		return list;
	}

	public void setList(List<MessageTemplate> list) {
		this.list = list;
	}

    


}
