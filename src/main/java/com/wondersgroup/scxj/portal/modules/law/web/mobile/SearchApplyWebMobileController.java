/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.web.mobile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.wondersgroup.scxj.portal.common.web.BaseController;
import com.wondersgroup.scxj.portal.modules.law.entity.Lawyer;
import com.wondersgroup.scxj.portal.modules.law.entity.MessageLogs;
import com.wondersgroup.scxj.portal.modules.law.entity.SearchApply;
import com.wondersgroup.scxj.portal.modules.law.service.CaseService;
import com.wondersgroup.scxj.portal.modules.law.service.MessageLogsService;
import com.wondersgroup.scxj.portal.modules.law.service.SearchApplyService;
import com.wondersgroup.scxj.portal.modules.sys.utils.UserUtils;

/**
 * 诉讼流程Controller
 * 
 * @author LiRiChen
 * @version 2014-03-30
 */
@Controller
@RequestMapping(value = "${mobilePath}/law/searchapply")
public class SearchApplyWebMobileController extends BaseController {

	@Autowired
	private SearchApplyService searchApplyService;
	@Autowired
	private MessageLogsService messageLogsService;

	@Autowired
	private CaseService caseService;

	private SimpleDateFormat format;

	@ModelAttribute
	public SearchApply get(@RequestParam(required = false) Long id) {
		if (id != null) {
			return searchApplyService.get(id);
		} else {
			return new SearchApply();
		}
	}

	@ResponseBody
	@RequestMapping(value = { "list", "" }, method = RequestMethod.POST, consumes = "application/json")
	public List<SearchApply> list(@RequestBody SearchApply searchApply,
			HttpServletRequest request, HttpServletResponse response,
			Model model, @RequestParam("pageNo") String pageNo) {
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// User user = UserUtils.getUser();
		Page<SearchApply> page1 = searchApplyService.findFaults(
				new Page<SearchApply>(0, -1), searchApply);
		Page<SearchApply> page = searchApplyService.findNoFault(
				new Page<SearchApply>(request, response), searchApply, pageNo);
		List<SearchApply> all = new ArrayList<SearchApply>();
		all.addAll(page1.getList());
		all.addAll(page.getList());
		List<SearchApply> result = new ArrayList<SearchApply>();
		for (SearchApply apply : all) {
			if (getUpdateDate(apply) != null)
				apply.setCaseacceptdate(format.format(getUpdateDate(apply)));
			if (apply.getPersonid() != null) {
				List<Object> wcmCases = caseService.getByPersonId(apply
						.getPersonid());
				if (wcmCases != null && wcmCases.size() > 0) {
					Object[] wcmCase = (Object[]) wcmCases.get(0);
					apply.setCasestage((String) wcmCase[1]);
					apply.setCaseaccepctnum((String) wcmCase[2]);
				}
			}
			result.add(apply);
		}
		return result;

	}

	@ResponseBody
	@RequestMapping(value = { "listdata", "" })
	public List<SearchApply> listdata(SearchApply searchApply,
			HttpServletRequest request, HttpServletResponse response,
			Model model, @RequestParam("pageNo") String pageNo) {
		Page<SearchApply> page = searchApplyService.findNoFault(
				new Page<SearchApply>(request, response), searchApply, pageNo);
		// JSONArray jArray = new JSONArray();
		// for (int i = 0; i < page.getList().size(); i++) {
		// SearchApply apply = page.getList().get(i);
		// JSONObject object = new JSONObject();
		// object.append("id", apply.getId());
		// object.append("suspectsName", apply.getSuspectsName());
		// object.append("brief", apply.getBrief());
		// object.append("status", apply.getStatus());
		// object.append("dealDate",
		// DateUtils.formatDate(apply.getDealDate(), "yyyy-MM-dd"));
		// object.append("receptionDate", apply.getReceptionDate());
		// object.append(
		// "suspectsBriefName",
		// StringUtils.abbr(apply.getSuspectsName() + apply.getBrief()
		// + "案", 36));
		// jArray.put(i, object);
		// }
		return page.getList();
	}

	@RequestMapping(value = "/getFaultNum", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	String getFaultNum(
			@RequestParam(value = "lawyercardnum", required = true) String lawyerCardnum,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		SearchApply searchApply = new SearchApply();
		searchApply.setLawyercardnum(lawyerCardnum);
		return "" + getFaultData(searchApply).size();
	}

	@ResponseBody
	@RequestMapping(value = { "listfaultdata", "" })
	public List<SearchApply> getFaultData(SearchApply searchApply) {
		Page<SearchApply> page = searchApplyService.findFaults(
				new Page<SearchApply>(0, -1), searchApply);
		return page.getList();

	}

	public Date getUpdateDate(SearchApply searchApply) {
		Page<MessageLogs> logs = messageLogsService.findUpDate(
				new Page<MessageLogs>(0, 10), searchApply.getSearchappid());
		if (logs.getList() != null && logs.getList().size() > 0) {
			MessageLogs log = logs.getList().get(0);
			return log.getCrtime();
		}
		return null;
	}

	// @RequestMapping(value = "form")
	// public String form(SearchApply searchApply, Model model) {
	// model.addAttribute("searchApply", searchApply);
	// return "law/searchApplyForm";
	// }
	@RequestMapping(value = "form")
	public String form(SearchApply searchApply, Model model) {
		Lawyer lawyer = UserUtils.getLawyerUser();
		model.addAttribute("lawyerUser", lawyer);
		model.addAttribute("searchApply", searchApply);
		return "modules/law/mobile/lawyerProcessMobileForm";
	}

	@RequestMapping(value = "forlist")
	public String forlist(SearchApply searchApply, Model model) {
		Lawyer lawyer = UserUtils.getLawyerUser();
		model.addAttribute("lawyerUser", lawyer);
		model.addAttribute("searchApply", searchApply);
		return "modules/law/mobile/lawyerProcessListMobile";
	}

	@RequestMapping(value = "save")
	public String save(SearchApply searchApply, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, searchApply)) {
			return form(searchApply, model);
		}
		searchApplyService.save(searchApply);
		addMessage(redirectAttributes, "保存诉讼流程'" + searchApply.getBrief()
				+ "'成功");
		return "redirect:" + Global.getAdminPath() + "/law/searchApply/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		searchApplyService.delete(id);
		addMessage(redirectAttributes, "删除诉讼流程成功");
		return "redirect:" + Global.getAdminPath() + "/law/searchApply/?repage";
	}

}
