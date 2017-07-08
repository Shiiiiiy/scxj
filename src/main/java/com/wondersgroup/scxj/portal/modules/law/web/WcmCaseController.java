/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wondersgroup.scxj.portal.common.config.Global;
import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.common.web.BaseController;
import com.wondersgroup.scxj.portal.modules.sys.entity.User;
import com.wondersgroup.scxj.portal.modules.sys.utils.UserUtils;
import com.wondersgroup.scxj.portal.modules.law.entity.WcmCase;
import com.wondersgroup.scxj.portal.modules.law.service.CaseService;

/**
 * 案件信息Controller
 * @author LiRiChen
 * @version 2014-03-30
 */
@Controller
@RequestMapping(value = "${adminPath}/law/wcmCase")
public class WcmCaseController extends BaseController {

	@Autowired
	private CaseService wcmCaseService;
	
	@ModelAttribute
	public WcmCase get(@RequestParam(required=false) Long id) {
		if (id != null){
			return wcmCaseService.get(id);
		}else{
			return new WcmCase();
		}
	}
	
	@RequiresPermissions("law:wcmCase:view")
	@RequestMapping(value = {"list", ""})
	public String list(WcmCase wcmCase, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
	
        Page<WcmCase> page = wcmCaseService.find(new Page<WcmCase>(request, response), wcmCase); 
        model.addAttribute("page", page);
		return "law/wcmCaseList";
	}

	@RequiresPermissions("law:wcmCase:view")
	@RequestMapping(value = "form")
	public String form(WcmCase wcmCase, Model model) {
		model.addAttribute("wcmCase", wcmCase);
		return "law/wcmCaseForm";
	}

	@RequiresPermissions("law:wcmCase:edit")
	@RequestMapping(value = "save")
	public String save(WcmCase wcmCase, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wcmCase)){
			return form(wcmCase, model);
		}
		wcmCaseService.save(wcmCase);
		addMessage(redirectAttributes, "保存案件信息'" + wcmCase.getCasebrief() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/law/wcmCase/?repage";
	}
	
	@RequiresPermissions("law:wcmCase:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		wcmCaseService.delete(id);
		addMessage(redirectAttributes, "删除案件信息成功");
		return "redirect:"+Global.getAdminPath()+"/law/wcmCase/?repage";
	}

}
