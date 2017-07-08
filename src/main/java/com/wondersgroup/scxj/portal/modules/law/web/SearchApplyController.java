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
import com.wondersgroup.scxj.portal.modules.law.entity.SearchApply;
import com.wondersgroup.scxj.portal.modules.law.service.SearchApplyService;

/**
 * 诉讼流程Controller
 * @author LiRiChen
 * @version 2014-03-30
 */
@Controller
@RequestMapping(value = "${adminPath}/law/search")
public class SearchApplyController extends BaseController {

	@Autowired
	private SearchApplyService searchApplyService;
	
	@ModelAttribute
	public SearchApply get(@RequestParam(required=false) Long id) {
		if (id != null){
			return searchApplyService.get(id);
		}else{
			return new SearchApply();
		}
	}
	
	@RequiresPermissions("law:searchApply:view")
	@RequestMapping(value = {"list", ""})
	public String list(SearchApply searchApply, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();

        Page<SearchApply> page = searchApplyService.find(new Page<SearchApply>(request, response), searchApply); 
        model.addAttribute("page", page);
		return "law/searchApplyList";
	}

	@RequiresPermissions("law:searchApply:view")
	@RequestMapping(value = "form")
	public String form(SearchApply searchApply, Model model) {
		model.addAttribute("searchApply", searchApply);
		return "law/searchApplyForm";
	}

	@RequiresPermissions("law:searchApply:edit")
	@RequestMapping(value = "save")
	public String save(SearchApply searchApply, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, searchApply)){
			return form(searchApply, model);
		}
		searchApplyService.save(searchApply);
		addMessage(redirectAttributes, "保存诉讼流程'" + searchApply.getBrief() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/law/searchApply/?repage";
	}
	
	@RequiresPermissions("law:searchApply:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		searchApplyService.delete(id);
		addMessage(redirectAttributes, "删除诉讼流程成功");
		return "redirect:"+Global.getAdminPath()+"/law/searchApply/?repage";
	}

}
