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
import com.wondersgroup.scxj.portal.modules.law.entity.LawAppendix;
import com.wondersgroup.scxj.portal.modules.law.service.LawAppendixService;

/**
 * 案件信息Controller
 * @author LiRiChen
 * @version 2014-03-30
 */
@Controller
@RequestMapping(value = "${adminPath}/law/lawAppendix")
public class LawAppendixController extends BaseController {

	@Autowired
	private LawAppendixService lawAppendixService;
	
	@ModelAttribute
	public LawAppendix get(@RequestParam(required=false) Long id) {
		if (id != null){
			return lawAppendixService.get(id);
		}else{
			return new LawAppendix();
		}
	}
	
	@RequiresPermissions("law:lawAppendix:view")
	@RequestMapping(value = {"list", ""})
	public String list(LawAppendix lawAppendix, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();

        Page<LawAppendix> page = lawAppendixService.find(new Page<LawAppendix>(request, response), lawAppendix); 
        model.addAttribute("page", page);
		return "law/lawAppendixList";
	}

	@RequiresPermissions("law:lawAppendix:view")
	@RequestMapping(value = "form")
	public String form(LawAppendix lawAppendix, Model model) {
		model.addAttribute("lawAppendix", lawAppendix);
		return "law/lawAppendixForm";
	}

	@RequiresPermissions("law:lawAppendix:edit")
	@RequestMapping(value = "save")
	public String save(LawAppendix lawAppendix, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, lawAppendix)){
			return form(lawAppendix, model);
		}
		lawAppendixService.save(lawAppendix);
		addMessage(redirectAttributes, "保存案件信息'" + lawAppendix.getFilename() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/law/lawAppendix/?repage";
	}
	
	@RequiresPermissions("law:lawAppendix:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		lawAppendixService.delete(id);
		addMessage(redirectAttributes, "删除案件信息成功");
		return "redirect:"+Global.getAdminPath()+"/law/lawAppendix/?repage";
	}

}
