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
import com.wondersgroup.scxj.portal.modules.law.entity.Holiday;
import com.wondersgroup.scxj.portal.modules.law.service.HolidayService;

/**
 * 假日信息Controller
 * @author LiRiChen
 * @version 2014-01-21
 */
@Controller
@RequestMapping(value = "${adminPath}/law/holiday")
public class HolidayController extends BaseController {

	@Autowired
	private HolidayService holidayService;
	
	@ModelAttribute
	public Holiday get(@RequestParam(required=false) Long id) {
		if (id != null){
			return holidayService.get(id);
		}else{
			return new Holiday();
		}
	}
	
	@RequiresPermissions("law:holiday:view")
	@RequestMapping(value = {"list", ""})
	public String list(Holiday holiday, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		
        Page<Holiday> page = holidayService.find(new Page<Holiday>(request, response), holiday); 
        model.addAttribute("page", page);
		return "law/holidayList";
	}

	@RequiresPermissions("law:holiday:view")
	@RequestMapping(value = "form")
	public String form(Holiday holiday, Model model) {
		model.addAttribute("holiday", holiday);
		return "law/holidayForm";
	}

	@RequiresPermissions("law:holiday:edit")
	@RequestMapping(value = "save")
	public String save(Holiday holiday, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, holiday)){
			return form(holiday, model);
		}
		holidayService.save(holiday);
		addMessage(redirectAttributes, "保存假日信息'" + holiday.getHolidayname() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/law/holiday/?repage";
	}
	
	@RequiresPermissions("law:holiday:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		holidayService.delete(id);
		addMessage(redirectAttributes, "删除假日信息成功");
		return "redirect:"+Global.getAdminPath()+"/law/holiday/?repage";
	}

}
