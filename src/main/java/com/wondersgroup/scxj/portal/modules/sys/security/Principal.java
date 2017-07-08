package com.wondersgroup.scxj.portal.modules.sys.security;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.wondersgroup.scxj.portal.modules.sys.entity.User;

/**
 * 授权用户信息
 */
public class Principal implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String loginName;
	private String name;
	private Map<String, Object> cacheMap;
	
	private String claimedId;
	private String serverAddress;

	public Principal(User user) {
		this.id = user.getId();
		this.loginName = user.getLoginName();
		this.name = user.getName();
	}
	
	public Principal(User user, String claimedId) {
		this.id = user.getId();
		this.loginName = user.getLoginName();
		this.name = user.getName();
		this.claimedId = claimedId;
	}

    public Principal(String serverAddress) {
        this.serverAddress = serverAddress;
    }

	public Long getId() {
		return id;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getName() {
		return name;
	}

	public Map<String, Object> getCacheMap() {
		if (cacheMap==null){
			cacheMap = new HashMap<String, Object>();
		}
		return cacheMap;
	}
	
	public String getClaimedId() {
		return claimedId;
	}

    public String getAddress() {
        return serverAddress;
    }
}
