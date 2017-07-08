/**
 * Copyright &copy; 2012-2013 <a href="http://www.wondersgroup.com/">shjcy</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wondersgroup.scxj.portal.common.config;

import java.util.Map;

import com.google.common.collect.Maps;
import com.wondersgroup.scxj.portal.common.utils.PropertiesLoader;

/**
 * 全局配置类
 * @author LiRiChen
 * @version 2013-03-23
 */
public class Global {
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader = new PropertiesLoader("application.properties");
	
	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = propertiesLoader.getProperty(key);
			map.put(key, value);
		}
		return value;
	}

	/////////////////////////////////////////////////////////
	
	/**
	 * 获取管理端根路径
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}
	
	/**
	 * 获取前端根路径
	 */
	public static String getFrontPath() {
		return getConfig("frontPath");
	}
	/**
	 * 获取律师web端根路径
	 */
	public static String getLawyerPath() {
		return getConfig("lawyerPath");
	}
	
	/**
	 * 获取移动端根路径
	 */
	public static String getMobilePath() {
		return getConfig("mobilePath");
	}
	
	public static String getMobileClientVersion() {
		return getConfig("mobileVersion");
	}
	
	/**
	 * 获取URL后缀
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}
	
	/**
	 * 是否是演示模式，演示模式下不能修改用户、角色、密码、菜单、授权
	 */
	public static Boolean isDemoMode() {
		String dm = getConfig("demoMode"); 
		return "true".equals(dm) || "1".equals(dm);
	}
	
	/**
	 * 获取移动端根路径
	 */
	public static String getMessageTemplatePath() {
		return getConfig("sms.template.path");
	}
	/**
	 * 获取附件根目录
	 */
	public static String getFileBasePath() {
		return getConfig("ims.file.basepath");
	}
	/**
	 * 获取pageSize
	 */
	public static String getPageSize() {
		return getConfig("page.pageSize");
	}
}
