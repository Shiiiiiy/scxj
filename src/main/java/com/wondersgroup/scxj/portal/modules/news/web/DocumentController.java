/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.news.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wondersgroup.scxj.portal.common.config.Global;
import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.common.utils.StringUtils;
import com.wondersgroup.scxj.portal.common.utils.WebContentUtil;
import com.wondersgroup.scxj.portal.common.web.BaseController;
import com.wondersgroup.scxj.portal.modules.news.entity.Wcmdocument;
import com.wondersgroup.scxj.portal.modules.news.service.WcmdocumentService;
import com.wondersgroup.scxj.portal.modules.sys.entity.User;
import com.wondersgroup.scxj.portal.modules.sys.utils.UserUtils;

/**
 * 检察院andriod版新闻Controller
 * 
 * @author jack
 * @version 2014-01-15
 */
@Controller
@RequestMapping(value = "${frontPath}/news/wcmdocument")
public class DocumentController extends BaseController {

	@Autowired
	private WcmdocumentService wcmdocumentService;

	@ModelAttribute
	public Wcmdocument get(@RequestParam(required = false) Long id) {
		if (id != null) {
			return wcmdocumentService.get(id);
		} else {
			return new Wcmdocument();
		}
	}

	@RequestMapping(value = { "list/{channelName}", "" })
	public String list(
			@PathVariable String channelName,
			@RequestParam(value = "type", required = false) String type,
			 @RequestParam(value = "state", required = false) String state,
			Wcmdocument wcmdocument, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		Page<Wcmdocument> page = wcmdocumentService.findBySqlChannel(new Page<Wcmdocument>(
				request, response), channelName);
		model.addAttribute("page", page);
		if (type == null)
			type = "new_default";
		if (state == null)
			state = "open";
		model.addAttribute("type", type);
		model.addAttribute("state", state);
		return "modules/news/wcmdocumentList";
	}

	@ResponseBody
	@RequestMapping(value = "refreshNews")
	public String findNextPageNews(String startRowNum, String endRowNum, String docchannel) {
		List<Wcmdocument> list = wcmdocumentService.findNextPageNews(
				startRowNum, endRowNum, docchannel);
		JSONArray jArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			Wcmdocument wcmdocument = list.get(i);
			JSONObject object = new JSONObject();
			object.append("id", wcmdocument.getDocid());
			object.append("title",
					StringUtils.abbr(wcmdocument.getDoctitle(), 60));
			object.append("docpubtime", wcmdocument.getDocpubtime());
			jArray.put(i, object);
		}
		return jArray.toString();
	}

	@RequestMapping(value = "form")
	public String form(Wcmdocument wcmdocument, @RequestParam(value = "type", required = false) String type,Model model) {
		wcmdocument = wcmdocumentService.get(wcmdocument.getDocid());
		String content = wcmdocument.getDochtmlcon().toLowerCase();
		// 处理图片里面的连接
		content = WebContentUtil.analyseImgSrc(content, wcmdocument
				.getDocchannel().toString());
		// 处理图片里面的样式
		content = WebContentUtil.clearWordFormat(content);

		wcmdocument.setDocpubhtmlcon(content);
		if(StringUtils.equals(type, "portal_default")){
			type = "portal_form_default";
		}else {
			type = "new_default";
		}
		model.addAttribute("type", type);
		model.addAttribute("wcmdocument", wcmdocument);
		return "modules/news/wcmdocumentForm";
	}

	@RequiresPermissions("news:wcmdocument:edit")
	@RequestMapping(value = "save")
	public String save(Wcmdocument wcmdocument, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wcmdocument)) {
			return form(wcmdocument,"", model);
		}
		wcmdocumentService.save(wcmdocument);
		return "redirect:" + Global.getAdminPath()
				+ "/news/wcmdocument/?repage";
	}

	@RequiresPermissions("news:wcmdocument:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		wcmdocumentService.delete(id);
		addMessage(redirectAttributes, "删除检察院andriod版新闻成功");
		return "redirect:" + Global.getAdminPath()
				+ "/news/wcmdocument/?repage";
	}

}
