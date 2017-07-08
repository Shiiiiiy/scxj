/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.web.mobile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.common.web.BaseController;
import com.wondersgroup.scxj.portal.modules.law.entity.LawyerApply;
import com.wondersgroup.scxj.portal.modules.law.service.LawyerApplyService;

/**
 * 诉讼业务办理Controller
 * 
 * @author LiRiChen
 * @version 2014-01-13
 */
@Controller
@RequestMapping(value = "${frontPath}/law/apply")
public class LawyerLocalApplyMobileController extends BaseController {

	@Autowired
	private LawyerApplyService lawyerApplyService;

	@ModelAttribute
	public LawyerApply get(@RequestParam(required = false) Long id) {
		if (id != null) {
			return lawyerApplyService.get(id);
		} else {
			return new LawyerApply();
		}
	}

	@RequestMapping(value = { "list", "" })
	public String list(LawyerApply lawyerApply, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if (StringUtils.isNotEmpty(lawyerApply.getSearchCode())
				&& StringUtils.isNotEmpty(lawyerApply.getSearchPass())) {
			Page<LawyerApply> page = lawyerApplyService.find(
					new Page<LawyerApply>(request, response), lawyerApply);
			
			model.addAttribute("page", page);
		} else {
			
		}
		return "modules/law/mobile/lawyerApplyLocalMobileList";
	}
}
