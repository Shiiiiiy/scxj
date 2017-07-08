package com.wondersgroup.scxj.portal.modules.sys.web.mobile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.scxj.portal.common.config.Global;
import com.wondersgroup.scxj.portal.modules.sys.entity.Updater;

/**
 * A controller class to process the user related requests.
 * 
 * @author Li RiChen
 */
@Controller
@RequestMapping("${frontPath}/sys")
public class SysMobileController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	public SysMobileController() {
		// userService = ServiceLocator.getUserService();
	}
	
	@RequestMapping(value = "/validateversion", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Updater getSysemVersion(
			HttpServletRequest request, HttpServletResponse response) {
		Updater updater = new Updater();
		updater.setVersion(Global.getMobileClientVersion());
		updater.setUpdateUrl("/static/app/scxj.apk");
		return updater;
	}

}
