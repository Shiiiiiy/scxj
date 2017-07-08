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
import com.wondersgroup.scxj.portal.modules.law.entity.Lawyer;
import com.wondersgroup.scxj.portal.modules.law.service.LawyerService;

/**
 * 律师基本信息Controller
 * @author LiRiChen
 * @version 2014-01-19
 */
@Controller
@RequestMapping(value = "${adminPath}/law/lawyer")
public class LawyerController extends BaseController {

	@Autowired
	private LawyerService lawyerService;
	
	@ModelAttribute
	public Lawyer get(@RequestParam(required=false) Long id) {
		if (id != null){
			return lawyerService.get(id);
		}else{
			return new Lawyer();
		}
	}
	
	@RequiresPermissions("law:lawyer:view")
	@RequestMapping(value = {"list", ""})
	public String list(Lawyer lawyer, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
        Page<Lawyer> page = lawyerService.find(new Page<Lawyer>(request, response), lawyer); 
        model.addAttribute("page", page);
		return "law/lawyerList";
	}

	@RequiresPermissions("law:lawyer:view")
	@RequestMapping(value = "form")
	public String form(Lawyer lawyer, Model model) {
		model.addAttribute("lawyer", lawyer);
		return "law/lawyerForm";
	}

	@RequiresPermissions("law:lawyer:edit")
	@RequestMapping(value = "save")
	public String save(Lawyer lawyer, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, lawyer)){
			return form(lawyer, model);
		}
		lawyerService.save(lawyer);
		addMessage(redirectAttributes, "保存律师基本信息'" + lawyer.getName() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/law/lawyer/?repage";
	}
	
	@RequiresPermissions("law:lawyer:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		lawyerService.delete(id);
		addMessage(redirectAttributes, "删除律师基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/law/lawyer/?repage";
	}

}
