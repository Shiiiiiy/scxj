/**
 * Copyright &copy; 2012-2013 2013 WD Co., Ltd. All rights reserved.
 *
 * 2013 WD Co., Ltd.
 */
package com.wondersgroup.scxj.portal.modules.sys.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wondersgroup.scxj.portal.common.utils.SpringContextHolder;
import com.wondersgroup.scxj.portal.modules.sys.entity.User;
import com.wondersgroup.scxj.portal.modules.sys.service.SystemService;
import com.wondersgroup.scxj.portal.modules.sys.utils.SecurityUtils;

/**
 * 表单验证（包含验证码）过滤类
 * @author Wonders
 * @version 2013-5-19
 */
@Service
public class UserAuthenticationFilter extends org.apache.shiro.web.filter.authc.AuthenticatingFilter {

	private static Logger logger = LoggerFactory
			.getLogger(UserAuthenticationFilter.class);
	
	public static final String DEFAULT_USER_KEY_PARAM = "userkey";

	private String userKeyParam = DEFAULT_USER_KEY_PARAM;

	public String getUserKeyParam() {
		return userKeyParam;
	}
	
	private SystemService systemService;

	protected String getUserKey(ServletRequest request) {
		return WebUtils.getCleanParam(request, getUserKeyParam());
	}

	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUserKey(request);
		String password = "";
		boolean rememberMe = false;
		String host = "";
		username = SecurityUtils.decryptUserKey(username);
		User user = getSystemService().getUserByLoginName(username);
		if (user != null) {
			return new UsernamePasswordToken(username, user.getPassword().toCharArray(), rememberMe, host, "");

		} else {
			return null;
		}
	}
	
	/**
	 * 获取系统业务对象
	 */
	public SystemService getSystemService() {
		if (systemService == null){
			systemService = SpringContextHolder.getBean(SystemService.class);
		}
		return systemService;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		boolean loggedIn = false; //false by default or we wouldn't be in this method
        if (StringUtils.isNotEmpty(getUserKey(request))) {
            loggedIn = executeLogin(request, response);
        }
        return loggedIn;
	}
	
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        AuthenticationToken token = createToken(request, response);
        if (token == null) {
            String msg = "createToken method implementation returned null. A valid non-null AuthenticationToken " +
                    "must be created in order to execute a login attempt.";
//            throw new IllegalStateException(msg);
            logger.warn(msg);
            return false;
        }
        try {
            Subject subject = getSubject(request, response);
            subject.login(token);
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }

	

}