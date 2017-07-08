package com.wondersgroup.scxj.portal.modules.sys.security;

public class AxAttribute {

    private final String name;
    private final String identifier;

    public AxAttribute(String name, String attributeIdentifier) {
        this.name = name;
        this.identifier = attributeIdentifier;
    }

    public String getName() {
        return name;
    }

    public String getAttributeIdentifier() {
        return identifier;
    }

}
