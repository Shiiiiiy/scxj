/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.news.web.mobile;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wondersgroup.scxj.portal.common.config.Global;
import com.wondersgroup.scxj.portal.common.web.BaseController;
import com.wondersgroup.scxj.portal.modules.law.entity.Lawyer;
import com.wondersgroup.scxj.portal.modules.sys.utils.UserUtils;

/**
 * 检察院andriod版新闻Controller
 * @author jack
 * @version 2014-01-15
 */
@Controller
@RequestMapping(value = "${frontPath}")
public class DocumentMobileController extends BaseController {

	
	/**
	 * 网站首页
	 */
	@RequestMapping
	public String index(Model model) {
		return "redirect:" + Global.getFrontPath() + "/news/wcmdocument/list/62?type=portal_default";
	}
	
	/**
	 * 网站首页
	 */
	@RequestMapping(value = "login/{type}")
	public String login(@PathVariable String type, Model model) {
		//Lawyer lawyer = UserUtils.getLawyerUser();
		//if(lawyer != null && StringUtils.isNotEmpty(lawyer.getPersonid())){
			String url =  "/law/apply/list";
			if(StringUtils.equals(type, "applyform")){
				 url =  "/law/apply/form";
			} else if(StringUtils.equals(type, "login")){
				 url =  "/law/apply/login";
			} else if(StringUtils.equals(type, "logout")){
				 url =  "/law/apply/logout";
			} else if(StringUtils.equals(type, "liststatus")){
				//查询待处理的预约
				 url =  "/law/apply/list?lawstatus=1";
			} else if(StringUtils.equals(type, "searchapplylist")){
				 url =  "/law/searchapply/forlist";
			}  else if(StringUtils.equals(type, "searchapplyform")){
				 url =  "/law/searchapply/form";
			} 
			return "redirect:" + Global.getMobilePath() + url;
//		}else {
//			model.addAttribute("type", type);
//			return "modules/law/mobile/lawyerLogin";
//			
//		}
	}
}
