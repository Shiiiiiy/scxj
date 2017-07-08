/**
 * Copyright &copy; 2012-2013 2013 WD Co., Ltd. All rights reserved.
 *
 * 2013 WD Co., Ltd.
 */
package com.wondersgroup.scxj.portal.modules.sys.security;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import com.wondersgroup.scxj.portal.common.utils.SpringContextHolder;
import com.wondersgroup.scxj.portal.modules.sys.entity.Menu;
import com.wondersgroup.scxj.portal.modules.sys.entity.User;
import com.wondersgroup.scxj.portal.modules.sys.service.SystemService;
import com.wondersgroup.scxj.portal.modules.sys.utils.UserUtils;

/**
 * 系统安全认证实现类
 * 
 * @author Wonders
 * @version 2013-5-29
 */
@Service
@DependsOn({ "userDao", "roleDao", "menuDao" })
public class UserKeyAuthorizingRealm extends AuthorizingRealm {

	private SystemService systemService;

	/**
	 * 认证回调函数, 登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = getSystemService().getUserByLoginName(token.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(new Principal(user),
					user.getPassword(), getName());
		} else {
			return null;
		}
	}
	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		Principal principal = (Principal) getAvailablePrincipal(principals);
		User user = getSystemService().getUserByLoginName(
				principal.getLoginName());
		if (user != null) {
			UserUtils.putCache("user", user);
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			List<Menu> list = UserUtils.getMenuList();
			for (Menu menu : list) {
				if (StringUtils.isNotBlank(menu.getPermission())) {
					// 添加基于Permission的权限信息
					info.addStringPermission(menu.getPermission());
				}
			}
			// 更新登录IP和时间
			getSystemService().updateUserLoginInfo(user.getId());
			return info;
		} else {
			return null;
		}
	}

	/**
	 * 设定密码校验的Hash算法与迭代次数
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		// HashedCredentialsMatcher matcher = new
		// HashedCredentialsMatcher(SystemService.HASH_ALGORITHM);
		// matcher.setHashIterations(SystemService.HASH_INTERATIONS);
		SimpleCredentialsMatcher matcher = new SimpleCredentialsMatcher();
		setCredentialsMatcher(matcher);
	}

	/**
	 * 清空用户关联权限认证，待下次使用时重新加载
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清空所有关联认证
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}

	/**
	 * 获取系统业务对象
	 */
	public SystemService getSystemService() {
		if (systemService == null) {
			systemService = SpringContextHolder.getBean(SystemService.class);
		}
		return systemService;
	}

}
