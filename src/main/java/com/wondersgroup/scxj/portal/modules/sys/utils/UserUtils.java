/**
 * Copyright &copy; 2012-2013 <a href="http://www.wondersgroup.com/">shjcy</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wondersgroup.scxj.portal.modules.sys.utils;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.subject.Subject;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.google.common.collect.Maps;
import com.wondersgroup.scxj.portal.common.service.BaseService;
import com.wondersgroup.scxj.portal.common.utils.SpringContextHolder;
import com.wondersgroup.scxj.portal.modules.law.dao.LawyerDao;
import com.wondersgroup.scxj.portal.modules.law.entity.Lawyer;
import com.wondersgroup.scxj.portal.modules.sys.dao.AreaDao;
import com.wondersgroup.scxj.portal.modules.sys.dao.MenuDao;
import com.wondersgroup.scxj.portal.modules.sys.dao.OfficeDao;
import com.wondersgroup.scxj.portal.modules.sys.dao.UserDao;
import com.wondersgroup.scxj.portal.modules.sys.entity.Area;
import com.wondersgroup.scxj.portal.modules.sys.entity.Menu;
import com.wondersgroup.scxj.portal.modules.sys.entity.Office;
import com.wondersgroup.scxj.portal.modules.sys.entity.User;
import com.wondersgroup.scxj.portal.modules.sys.security.OpenIdAuthentication;
import com.wondersgroup.scxj.portal.modules.sys.security.Principal;

/**
 * 用户工具类
 * 
 * @author LiRiChen
 * @version 2013-5-29
 */
public class UserUtils extends BaseService {

	private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
	private static MenuDao menuDao = SpringContextHolder.getBean(MenuDao.class);
	private static AreaDao areaDao = SpringContextHolder.getBean(AreaDao.class);
	private static LawyerDao lawyerDao = SpringContextHolder.getBean(LawyerDao.class);
	private static OfficeDao officeDao = SpringContextHolder
			.getBean(OfficeDao.class);

	public static final String CACHE_USER = "user";
	public static final String CACHE_LAWYER_PERSON_ID = "lawyerPersonId";
	public static final String CACHE_LAWYER_USER = "lawyerUser";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";

	public static User getUser() {
		User user = (User) getCache(CACHE_USER);
		if (user == null) {
			boolean isAuthenticated = SecurityUtils.getSubject().isAuthenticated();
			if(isAuthenticated){
				Principal principal = SecurityUtils.getSubject().getPrincipals().oneByType(Principal.class);
				if (principal != null && principal.getId() != null) {
					user = userDao.findOne(principal.getId());
					putCache(CACHE_USER, user);
				}
			}
		}
		if (user == null) {
			user = new User();
			SecurityUtils.getSubject().logout();
		}
		return user;
	}

	public static User getUser(boolean isRefresh) {
		if (isRefresh) {
			removeCache(CACHE_USER);
		}
		return getUser();
	}

	public static List<Menu> getMenuList() {
		@SuppressWarnings("unchecked")
		List<Menu> menuList = (List<Menu>) getCache(CACHE_MENU_LIST);
		if (menuList == null) {
			User user = getUser();
			if (user.isAdmin()) {
				menuList = menuDao.findAllList();
			} else {
				menuList = menuDao.findByUserId(user.getId());
			}
			putCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}

	public static List<Area> getAreaList() {
		@SuppressWarnings("unchecked")
		List<Area> areaList = (List<Area>) getCache(CACHE_AREA_LIST);
		if (areaList == null) {
			// User user = getUser();
			// if (user.isAdmin()){
			areaList = areaDao.findAllList();
			// }else{
			// areaList = areaDao.findAllChild(user.getArea().getId(),
			// "%,"+user.getArea().getId()+",%");
			// }
			putCache(CACHE_AREA_LIST, areaList);
		}
		return areaList;
	}

	public static List<Office> getOfficeList() {
		@SuppressWarnings("unchecked")
		List<Office> officeList = (List<Office>) getCache(CACHE_OFFICE_LIST);
		if (officeList == null) {
			User user = getUser();
			// if (user.isAdmin()){
			// officeList = officeDao.findAllList();
			// }else{
			// officeList = officeDao.findAllChild(user.getOffice().getId(),
			// "%,"+user.getOffice().getId()+",%");
			// }
			DetachedCriteria dc = officeDao.createDetachedCriteria();
			dc.add(dataScopeFilter(user, dc.getAlias(), ""));
			dc.add(Restrictions.eq("delFlag", Office.DEL_FLAG_NORMAL));
			dc.addOrder(Order.asc("code"));
			officeList = officeDao.find(dc);
			putCache(CACHE_OFFICE_LIST, officeList);
		}
		return officeList;
	}
	
	public static Lawyer getLawyerUser() {
		Lawyer lawyer = (Lawyer)getCache(CACHE_LAWYER_USER);
		if (lawyer == null) {
			boolean isAuthenticated = SecurityUtils.getSubject().isAuthenticated();
			if(isAuthenticated){
				OpenIdAuthentication openIdPrincipal = SecurityUtils.getSubject().getPrincipals().oneByType(OpenIdAuthentication.class);
				if (openIdPrincipal != null && openIdPrincipal.getUserId() != null) {
					lawyer = lawyerDao.findByPersonId(openIdPrincipal.getUserId());
					putCache(CACHE_LAWYER_USER, lawyer);
				}
			}
		}
		if (lawyer == null) {
			lawyer = new Lawyer();
			SecurityUtils.getSubject().logout();
		}
		return lawyer;
	}

	// ============== User Cache ==============

	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {
		Object obj = getCacheMap().get(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putCache(String key, Object value) {
		getCacheMap().put(key, value);
	}

	public static void removeCache(String key) {
		getCacheMap().remove(key);
	}

	public static Map<String, Object> getCacheMap() {
		Map<String, Object> map = Maps.newHashMap();
		try {
			boolean isAuthenticated = SecurityUtils.getSubject().isAuthenticated();
			if(isAuthenticated){
				Subject subject = SecurityUtils.getSubject();
				Principal principal = subject.getPrincipals().oneByType(Principal.class);
				OpenIdAuthentication openIdPrincipal = subject.getPrincipals().oneByType(OpenIdAuthentication.class);
				if(principal == null){
					if(openIdPrincipal == null){
						return map;
					}else {
						return openIdPrincipal.getCacheMap();
					}
				} else {
					return principal.getCacheMap();
				}
			} else {
				return map;
			}
			
		} catch (UnavailableSecurityManagerException e) {
			return map;
		}
	}

}
