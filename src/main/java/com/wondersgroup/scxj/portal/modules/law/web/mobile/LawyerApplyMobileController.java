/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.web.mobile;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wondersgroup.scxj.portal.common.config.Global;
import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.common.utils.DateUtils;
import com.wondersgroup.scxj.portal.common.utils.StringUtils;
import com.wondersgroup.scxj.portal.common.web.BaseController;
import com.wondersgroup.scxj.portal.modules.law.entity.Lawyer;
import com.wondersgroup.scxj.portal.modules.law.entity.LawyerApply;
import com.wondersgroup.scxj.portal.modules.law.service.LawyerApplyService;
import com.wondersgroup.scxj.portal.modules.news.entity.Wcmdocument;
import com.wondersgroup.scxj.portal.modules.sys.utils.UserUtils;

/**
 * 诉讼业务办理Controller
 * 
 * @author LiRiChen
 * @version 2014-01-13
 */
@Controller
@RequestMapping(value = "${mobilePath}/law/apply")
public class LawyerApplyMobileController extends BaseController {

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

	public final String URL_PARAM_LAWYER_STATUS = "lawstatus";

	@RequestMapping(value = { "list", "" })
	public String list(LawyerApply lawyerApply, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String type = request.getParameter(URL_PARAM_LAWYER_STATUS);
		if (StringUtils.isNotEmpty(type)) {
			lawyerApply.setDealStatus(LawyerApply.APPLY_DEAL_STATUS_PUBLISH);
			lawyerApply
					.setFeedbackStatus(LawyerApply.APPLY_FEEDBACK_STATUS_NULL);
		}
		Page<LawyerApply> page = lawyerApplyService.find(new Page<LawyerApply>(
				request, response), lawyerApply);
		model.addAttribute("page", page);
		return "modules/law/mobile/lawyerApplyMobileList";
	}

	@ResponseBody
	@RequestMapping(value = { "listdata", "" })
	public String listdata(LawyerApply lawyerApply, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<LawyerApply> page = lawyerApplyService.find(new Page<LawyerApply>(
				request, response), lawyerApply);
		JSONArray jArray = new JSONArray();
		for (int i = 0; i < page.getList().size(); i++) {
			LawyerApply apply = page.getList().get(i);
			JSONObject object = new JSONObject();
			object.append("id", apply.getId());
			object.append("suspectsName", apply.getSuspectsName());
			object.append("brief", apply.getBrief());
			object.append("status", apply.getStatus());
			object.append("dealDate",
					DateUtils.formatDate(apply.getDealDate(), "yyyy-MM-dd"));
			object.append("receptionDate", apply.getReceptionDate());
			object.append(
					"suspectsBriefName",
					StringUtils.abbr(apply.getSuspectsName() + apply.getBrief()
							+ "案", 36));
			jArray.put(i, object);
		}
		return jArray.toString();
	}

	@RequestMapping(value = { "search", "" })
	public String search(LawyerApply lawyerApply, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "modules/law/mobile/lawyerApplyMobileSearchForm";
	}

	@RequestMapping(value = "form")
	public String form(LawyerApply lawyerApply, Model model) {
		Lawyer lawyer = UserUtils.getLawyerUser();
		model.addAttribute("lawyerUser", lawyer);
		model.addAttribute("lawyerApply", lawyerApply);
		return "modules/law/mobile/lawyerApplyMobileForm";
	}

	@RequestMapping(value = "save")
	public String save(LawyerApply lawyerApply, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, lawyerApply)) {
			return form(lawyerApply, model);
		}
		lawyerApplyService.save(lawyerApply);
		addMessage(redirectAttributes, "保存诉讼业务办理'" + lawyerApply.getBrief()
				+ "'成功");
		return "redirect:" + Global.getMobilePath() + "/law/apply/list?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		lawyerApplyService.delete(id);
		addMessage(redirectAttributes, "删除诉讼业务办理成功");
		return "redirect:" + Global.getMobilePath() + "/law/apply/list?repage";
	}

	@RequestMapping(value = "login")
	public String login(LawyerApply lawyerApply, Model model) {
		Lawyer lawyer = UserUtils.getLawyerUser();
		model.addAttribute("lawyerUser", lawyer);
		return "modules/law/mobile/lawyerApplyMobileLogin";
	}

	public static final String URL_LAWYER_LOGOUT = "http://passport3.lawyers.org.cn/logout.do";

	@RequestMapping(value = "logout")
	public String logout(LawyerApply lawyerApply, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		// try {
		// response.sendRedirect(URL_LAWYER_LOGOUT);
		// } catch (IOException e) {
		// logger.error(e.getMessage());
		// }
		SecurityUtils.getSubject().logout();
		return "modules/law/mobile/lawyerApplyMobileLogout";
		// return "redirect:" + URL_LAWYER_LOGOUT;
	}

}
