package com.wondersgroup.scxj.portal.modules.sys.security;

import java.io.Serializable;
import org.apache.shiro.authc.AuthenticationToken;
import org.openid4java.message.ParameterList;

public class OpenIdVerifyAuthenticationToken implements AuthenticationToken, Serializable {

    private static final long serialVersionUID = 10001L;
    private final String receivingUrl;
    private final ParameterList response;

    public OpenIdVerifyAuthenticationToken(String receivingUrl, ParameterList response) {
        this.receivingUrl = receivingUrl;
        this.response = response;

    }

    @Override
    public Object getPrincipal() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return receivingUrl;
    }

    @Override
    public Object getCredentials() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	return response;
    }

    public String getReceivingUrl() {
        return receivingUrl;
    }

    public ParameterList getResponse() {
        return response;
    }
}
