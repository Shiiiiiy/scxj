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
import com.wondersgroup.scxj.portal.modules.law.entity.LawyerApply;
import com.wondersgroup.scxj.portal.modules.law.service.LawyerApplyService;

/**
 * 诉讼业务办理Controller
 * @author LiRiChen
 * @version 2014-01-13
 */
@Controller
@RequestMapping(value = "${adminPath}/law/apply")
public class LawyerApplyController extends BaseController {

	@Autowired
	private LawyerApplyService lawyerApplyService;
	
	@ModelAttribute
	public LawyerApply get(@RequestParam(required=false) Long id) {
		if (id != null){
			return lawyerApplyService.get(id);
		}else{
			return new LawyerApply();
		}
	}
	
	@RequiresPermissions("law:lawyer:view")
	@RequestMapping(value = {"list", ""})
	public String list(LawyerApply lawyerApply, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<LawyerApply> page = lawyerApplyService.find(new Page<LawyerApply>(request, response), lawyerApply); 
        model.addAttribute("page", page);
		return "modules/law/lawyerApplyList";
	}

	@RequiresPermissions("law:lawyer:view")
	@RequestMapping(value = "form")
	public String form(LawyerApply lawyerApply, Model model) {
		model.addAttribute("lawyerApply", lawyerApply);
		return "modules/law/lawyerApplyForm";
	}

	@RequiresPermissions("law:lawyer:edit")
	@RequestMapping(value = "save")
	public String save(LawyerApply lawyerApply, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, lawyerApply)){
			return form(lawyerApply, model);
		}
		lawyerApplyService.save(lawyerApply);
		addMessage(redirectAttributes, "保存诉讼业务办理'" + lawyerApply.getBrief() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/law/apply/list?repage";
	}
	
	@RequiresPermissions("law:lawyer:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		lawyerApplyService.delete(id);
		addMessage(redirectAttributes, "删除诉讼业务办理成功");
		return "redirect:"+Global.getAdminPath()+"/law/apply/list?repage";
	}

}
