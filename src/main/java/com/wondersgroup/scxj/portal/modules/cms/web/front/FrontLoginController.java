/**
 * Copyright &copy; 2012-2013 <a href="http://www.wondersgroup.com/">shjcy</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wondersgroup.scxj.portal.modules.cms.web.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wondersgroup.scxj.portal.common.config.Global;
import com.wondersgroup.scxj.portal.common.web.BaseController;
import com.wondersgroup.scxj.portal.modules.sys.entity.User;
import com.wondersgroup.scxj.portal.modules.sys.utils.UserUtils;

/**
 * 登录Controller
 * @author LiRiChen
 * @version 2013-5-31
 */
@Controller
public class FrontLoginController extends BaseController{
	
	/**
	 * 管理登录
	 */
	@RequestMapping(value = "${frontPath}/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/cms/front/cmsLogin";
	}

	
}
