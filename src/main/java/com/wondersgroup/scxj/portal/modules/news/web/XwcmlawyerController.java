/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.news.web;

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
import com.wondersgroup.scxj.portal.modules.news.entity.Xwcmlawyer;
import com.wondersgroup.scxj.portal.modules.news.service.XwcmlawyerService;

/**
 * 检察院andriod版新闻Controller
 * @author jack
 * @version 2014-01-14
 */
@Controller
@RequestMapping(value = "${frontPath}/news/xwcmlawyer")
public class XwcmlawyerController extends BaseController {

	@Autowired
	private XwcmlawyerService xwcmlawyerService;
	
	@ModelAttribute
	public Xwcmlawyer get(@RequestParam(required=false) Long id) {
		if (id != null){
			return xwcmlawyerService.get(id);
		}else{
			return new Xwcmlawyer();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(Xwcmlawyer xwcmlawyer, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
        Page<Xwcmlawyer> page = xwcmlawyerService.find(new Page<Xwcmlawyer>(request, response), xwcmlawyer); 
        model.addAttribute("page", page);
		return "modules/news/xwcmlawyerList";
	}

	@RequestMapping(value = "form")
	public String form(Xwcmlawyer xwcmlawyer, Model model) {
		model.addAttribute("xwcmlawyer", xwcmlawyer);
		return "modules/news/xwcmlawyerForm";
	}

	@RequestMapping(value = "save")
	public String save(Xwcmlawyer xwcmlawyer, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, xwcmlawyer)){
			return form(xwcmlawyer, model);
		}
		xwcmlawyerService.save(xwcmlawyer);
		addMessage(redirectAttributes, "保存检察院andriod版新闻'" + xwcmlawyer.getName() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/news/xwcmlawyer/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		xwcmlawyerService.delete(id);
		addMessage(redirectAttributes, "删除检察院andriod版新闻成功");
		return "redirect:"+Global.getAdminPath()+"/news/xwcmlawyer/?repage";
	}

}
