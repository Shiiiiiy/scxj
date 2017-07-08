package com.wondersgroup.scxj.portal.modules.sys.security;

import java.io.Serializable;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

public final class OpenIdAuthentication implements Principal, Serializable {


	private static final long serialVersionUID = 10001L;
    private final String claimedId;
    private final String userId;
    private Map<String, Object> cacheMap;

    public OpenIdAuthentication(String claimedId, String userId) {
        this.claimedId = claimedId;
        this.userId = userId;
    }

    @Override
    public String getName() {
        return claimedId;
    }
    
    public Map<String, Object> getCacheMap() {
		if (cacheMap==null){
			cacheMap = new HashMap<String, Object>();
		}
		return cacheMap;
	}
    

    public String getUserId() {
		return userId;
	}
    

}