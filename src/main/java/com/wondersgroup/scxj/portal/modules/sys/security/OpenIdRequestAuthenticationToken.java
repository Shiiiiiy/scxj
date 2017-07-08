package com.wondersgroup.scxj.portal.modules.sys.security;

import java.io.Serializable;
import org.apache.shiro.authc.AuthenticationToken;

public class OpenIdRequestAuthenticationToken implements AuthenticationToken, Serializable {

    private static final long serialVersionUID = 10001L;
    private final String userSupliedOpenId;
    private final String returnToUrl;

    public OpenIdRequestAuthenticationToken(String userSupliedOpenId, String returnToUrl) {
        this.userSupliedOpenId = userSupliedOpenId;
        this.returnToUrl = returnToUrl;
    }

    public String getUserSupliedOpenId() {
        return userSupliedOpenId;
    }

    public String getReturnToUrl() {
        return returnToUrl;
    }

    @Override
    public Object getPrincipal() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	return userSupliedOpenId;
    }

    @Override
    public Object getCredentials() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	return returnToUrl;
    }
}
