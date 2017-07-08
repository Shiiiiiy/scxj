package com.wondersgroup.scxj.portal.modules.sys.security;

import org.apache.shiro.authc.AuthenticationException;

public class OpenIdRequiresRedirect extends AuthenticationException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String address;

    public OpenIdRequiresRedirect(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    
    
}
