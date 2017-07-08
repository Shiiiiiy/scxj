package com.wondersgroup.scxj.portal.modules.law.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Media;

import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wondersgroup.scxj.portal.common.config.Global;
import com.wondersgroup.scxj.portal.common.utils.DateUtils;
import com.wondersgroup.scxj.portal.modules.law.entity.LawyerApply;
import com.wondersgroup.scxj.portal.modules.law.entity.MessageTemplate;
import com.wondersgroup.scxj.portal.modules.law.entity.MessageTemplateSet;
import com.wondersgroup.scxj.portal.modules.law.entity.SearchApply;

public class LawUtils {
	public static final String BASE_PATH = "ims.file.basepath";
	protected static Logger logger = LoggerFactory.getLogger(LawUtils.class);

	private static Map<String, Long> lastModifiedMap = new HashMap<String, Long>();

	private static Map<String, List<MessageTemplate>> map = new HashMap<String, List<MessageTemplate>>();

	public static List<MessageTemplate> getListAdapterData() {
		MessageTemplateSet templateList = new MessageTemplateSet();
		String filePath = Global.getMessageTemplatePath();

		try {
			File groupSource = new File(filePath);
			if (lastModifiedMap.get(filePath) != null
					&& lastModifiedMap.get(filePath) == groupSource
							.lastModified()) {
				return map.get(filePath);
			}
			Serializer serializer = new Persister();
			lastModifiedMap.put(filePath, groupSource.lastModified());
			templateList = serializer.read(MessageTemplateSet.class,
					groupSource);
			map.put(filePath, templateList.getList());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return templateList.getList();
	}

	public static String getMessage(LawyerApply lawyerApply, int type) {
		if (type == 0) {
			return LawUtils.genNewMessage(lawyerApply.getLawyerName(),
					lawyerApply.getSearchCode(), 0);
		} else if (type == 2) {
			return LawUtils
					.genConfirmApplyMessage(DateUtils.formatDate(
							lawyerApply.getCrtime(), "yyyy-MM-dd"), lawyerApply
							.getReceptionDate(), lawyerApply.getSearchCode(),
							lawyerApply.getGroupName());
		} else if (type == 3) {
			return LawUtils.genNewMessage(lawyerApply.getLawyerName(),
					lawyerApply.getSearchCode(), 3);
		} else if (type == 4) {
			return LawUtils.genNewMessage(lawyerApply.getLawyerName(),
					lawyerApply.getSearchCode(), 4);
		} else if (type == 6) {
			//add by ycl 补齐材料的操作界面，提交成功后，增短信【补齐材料——工作人员】
			return LawUtils.genNewMessage(lawyerApply.getLawyerName(),
					lawyerApply.getSearchCode(), 6);
		} else {
			return "";
		}
	}
	public static String getMessage(SearchApply searchApply, int type) {
		if (type == 5) {
			return LawUtils.genNewMessage(searchApply.getLawyername(),
					searchApply.getSearchcode(), 5);
//		} else if (type == 2) {
//			return
//					LawUtils
//					.genConfirmApplyMessage(DateUtils.formatDate(
//							searchApply.getCrtime(), "yyyy-MM-dd"),DateUtils.formatDate(
//							 searchApply.getDealdate()), searchApply.getSearchcode(),
//							searchApply.getGroupname());
		} else if (type == 6) {
			return LawUtils.genNewMessage(searchApply.getLawyername(),
					searchApply.getSearchcode(), 6);
		} else if (type == 7) {
			return LawUtils.genNewMessage(searchApply.getLawyername(),
					searchApply.getSearchcode(), 7);
		} else {
			return "";
		}
	}

	public static String genNewMessage(String lawyerName, String searchCode,
			int type) {

		List<MessageTemplate> messageList = getListAdapterData();
		MessageTemplate message = messageList.get(type);
		String content = message.getContent();
		content = StringUtils.replace(content, "lawyerName", lawyerName);
		content = StringUtils.replace(content, "searchCode", searchCode);
		return content;
	}

	public static String genConfirmApplyMessage(String applyDate,
			String receptionDate, String searchCode, String receptionPlace) {

		List<MessageTemplate> messageList = getListAdapterData();
		MessageTemplate message = messageList.get(2);
		String content = message.getContent();
		content = StringUtils.replace(content, "applyDate", applyDate);
		content = StringUtils.replace(content, "searchCode", searchCode);
		content = StringUtils.replace(content, "receptionDate", receptionDate);
		content = StringUtils
				.replace(content, "receptionPlace", receptionPlace);
		return content;
	}

	public static String getAppendixPath(String fileName,Date date){
		String basepath = Global.getFileBasePath();
		final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return basepath+File.separator+format.format(date)+File.separator+fileName;
	}
	public static String getTemporaryAppendixPath(String fileName,Date date){
		String basepath = Global.getFileBasePath();
		final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return basepath+File.separator+format.format(date)+File.separator+"temporary"+fileName;
	}
	
	public static String getAppendixFileName(String num,String searchCode,String type){
		return searchCode+num+type;
	}
	
	public static String getAppendixOldFileName(String oldFileName){
		return oldFileName.substring(oldFileName.lastIndexOf("/")+1);
	}
}
