/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.web.mobile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import antlr.Utils;

import com.trs.xwcm.shjcy.util.FileUtil;
import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.common.utils.DateUtils;
import com.wondersgroup.scxj.portal.common.web.BaseController;
import com.wondersgroup.scxj.portal.modules.law.entity.Holiday;
import com.wondersgroup.scxj.portal.modules.law.entity.LawAppendix;
import com.wondersgroup.scxj.portal.modules.law.entity.Lawyer;
import com.wondersgroup.scxj.portal.modules.law.entity.LawyerApply;
import com.wondersgroup.scxj.portal.modules.law.entity.SearchApply;
import com.wondersgroup.scxj.portal.modules.law.service.BlackListService;
import com.wondersgroup.scxj.portal.modules.law.service.HolidayService;
import com.wondersgroup.scxj.portal.modules.law.service.LawAppendixService;
import com.wondersgroup.scxj.portal.modules.law.service.LawyerApplyService;
import com.wondersgroup.scxj.portal.modules.law.service.LawyerService;
import com.wondersgroup.scxj.portal.modules.law.service.SearchApplyService;
import com.wondersgroup.scxj.portal.modules.law.utils.LawUtils;

/**
 * 律师基本信息Controller
 * 
 * @author LiRiChen
 * @version 2014-01-19
 */
@Controller
@RequestMapping(value = "${mobilePath}/law/lawyer")
public class LawyerMobileController extends BaseController {
	protected final Log log = LogFactory.getLog(getClass());
	
	private String sKey = "678ILoveReamy789";
	private String sIv = "ILoveReamy123456";

	@Autowired
	private LawyerService lawyerService;

	@Autowired
	private SearchApplyService searchApplyService;

	@Autowired
	private LawyerApplyService lawyerApplyService;
	
	@Autowired
	private LawAppendixService lawAppendixService;
	
	@Autowired
	private HolidayService holidayService;
	
	@Autowired
	private BlackListService blackListService;

	@RequestMapping(value = "/{lawyerid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Lawyer get(@PathVariable String lawyerid) {
		if (lawyerid != null) {
			return lawyerService.getByPersonId(lawyerid);
		} else {
			return new Lawyer();
		}
	}

	@RequestMapping(value = "/lawyerapply", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	LawyerApply getLawyerApply(
			@RequestParam(value = "applyid", required = true) String applyid) {
		Long id = Long.parseLong(applyid);
		LawyerApply lawyerApply = lawyerApplyService.get(id);
		Lawyer lawyer = lawyerService.getByLawyerIdNumber(lawyerApply
				.getLawyerIdcode());
		if (lawyer != null) {
			lawyerApply.setLawyerRegTel(lawyer.getMobile());
			lawyerApply.setLawyerRegEmail(lawyer.getEmail());
		}
		lawyerApply.setCanCancel(checkCanCancelApply(lawyerApply));
		lawyerApply.setConfirmTimeLeft(getVerifyDateDiff(lawyerApply));
		lawyerApply.setOrderDate(StringUtils.replace(
				lawyerApply.getOrderDate(), "或", ";"));
		return lawyerApply;
	}

	@RequestMapping(value = "/getpendingapply", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<String> getLawyerPendingApply(
			@RequestParam(value = "lawyercardnum", required = true) String lawyerCardnum) {
		List<String> result = new ArrayList<String>();
		if (StringUtils.isNotEmpty(lawyerCardnum)) {
			LawyerApply lawyerApply = new LawyerApply();
			lawyerApply.setDealStatus(LawyerApply.APPLY_DEAL_STATUS_PUBLISH);
			lawyerApply.setFeedbackStatus(LawyerApply.APPLY_FEEDBACK_STATUS_NULL);
			lawyerApply.setLawyerCardnum(lawyerCardnum);
			
			SearchApply searchApply = new SearchApply();
			searchApply.setLawyercardnum(lawyerCardnum);
			searchApply.setDealstatus(SearchApply.SEARCHAPPLY_DEAL_STATUS_DATA_FAULT);
			Page<SearchApply> page = searchApplyService.findFaults(new Page<SearchApply>(0, -1), searchApply);
			List<LawyerApply> list = lawyerApplyService.findAppendix(lawyerApply);

			if (list != null && list.size() > 0) {
				result.add(String.valueOf(list.size()));
			}else{
				result.add("-1");
			}
			if (page != null && page.getList().size() > 0) {
				result.add(String.valueOf(page.getList().size()));
			}else{
				result.add("-1");
			}
		}
		return result;
	}

	@RequestMapping(value = "/savelawyerapply", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	String saveLawyerApply(@RequestBody LawyerApply lawyerApply) {
		// add by ycl 根据嫌疑人姓名、诉讼阶段、案由、律师执业证号、承办单位这5个字段来判断是否是重复提交，重复提交，判断重复提交的信息当前状态是否通过审核，未通过审核，则不能提交该信息，
		List repeatlist=(List<LawyerApply>)lawyerApplyService.findRepeat(lawyerApply);
		if(repeatlist != null && repeatlist.size() > 0){
			lawyerApply=(LawyerApply)repeatlist.get(0);
			return LawyerApply.DEL_FLAG_REPEAT + LawyerApply.SEARCHAPPID + lawyerApply.getId();
		}else{
			List<Holiday> holidayList = getHolidays();
			String[] orderDate = StringUtils.split(lawyerApply.getOrderDate(), ";");
			for (String item : orderDate) {
				String[] detailTime = StringUtils.split(item, " ");
				int time = StringUtils.equals(detailTime[1], "上午") ? 1 : 2;
				String result = validateOrderDate(holidayList, detailTime[0], time);
				if (!StringUtils.equals(result, LawyerApply.DEL_FLAG_NORMAL)) {
					return result;
				}
			}
			lawyerApply.setOrderDate(StringUtils.replace(
					lawyerApply.getOrderDate(), ";", "或"));
			//判断律师姓名、律师事务所名称、律师执证号是否为空，并在数据库内查出补上
			if(lawyerApply.getLawyerName()==null||"".equals(lawyerApply.getLawyerName())||lawyerApply.getLawfirmName()==null||"".equals(lawyerApply.getLawfirmName())||lawyerApply.getLawyerCardnum()==null||"".equals(lawyerApply.getLawyerCardnum())){
				LawyerService ls=new LawyerService();
				Lawyer locallawyer=ls.getByLawyerMobile(lawyerApply.getLawyerTel());
				if(lawyerApply.getLawyerName()==null||"".equals(lawyerApply.getLawyerName())){
					lawyerApply.setLawyerName(locallawyer.getName());
				}
				if(lawyerApply.getLawfirmName()==null||"".equals(lawyerApply.getLawfirmName())){
					lawyerApply.setLawfirmName(locallawyer.getLawfirmname());
				}
				if(lawyerApply.getLawyerCardnum()==null||"".equals(lawyerApply.getLawyerCardnum())){
					lawyerApply.setLawyerCardnum(locallawyer.getLisensenumber());
				}
			}
			lawyerApplyService.save(lawyerApply);
			// add by ycl 诉讼业务添加上传附件后修改返回值
			//return LawyerApply.DEL_FLAG_NORMAL；
			return LawyerApply.DEL_FLAG_NORMAL + LawyerApply.SEARCHAPPID + lawyerApply.getId();
		}
		
	}

	@RequestMapping(value = "/updatelawyerapply", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	String updateLawyerApply(@RequestBody LawyerApply lawyerApply) {
		lawyerApply.setOrderDate(StringUtils.replace(
				lawyerApply.getOrderDate(), ";", "或"));
		lawyerApplyService.save(lawyerApply);
		return LawyerApply.DEL_FLAG_NORMAL;
	}

	@RequestMapping(value = "/getholidays", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<Holiday> getHolidays() {
		List<Holiday> list = holidayService.find(new Holiday());
		return list;
	}

	private String validateOrderDate(List<Holiday> holidayList,
			String selectDay, int time) {
		List<String> specialDates = new ArrayList<String>();// 周末上班
		List<String> disabledDates = new ArrayList<String>();// 周一至周五不上班
		for (Holiday currHoliday : holidayList) {
			if (currHoliday.getStatus() == 1) {
				disabledDates.add(currHoliday.getHolidaytime());
			} else if (currHoliday.getStatus() == 2) {
				specialDates.add(currHoliday.getHolidaytime());
			}
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtils.parseDate(selectDay));
		int selWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if (((selWeek == Calendar.SUNDAY || selWeek == Calendar.SATURDAY) && !specialDates
				.contains(selectDay))
				|| (selWeek != Calendar.SUNDAY && selWeek != Calendar.SATURDAY && disabledDates
						.contains(selectDay))) {
			return LawyerApply.DEL_FLAG_DELETE;
		}

		Calendar current = Calendar.getInstance();
		current.add(Calendar.DATE, 1);
		current.add(Calendar.SECOND, -1);
		// 判断接待时间是否晚于当前时间半个工作日
		if (time == 1) { // 上午
			calendar.add(Calendar.HOUR, 12);
		} else if (time == 2) { // 下午
			calendar.add(Calendar.HOUR, 24);
		}
		if (calendar.compareTo(current) < 0) {
			return LawyerApply.DEL_FLAG_AUDIT;
		}
		return LawyerApply.DEL_FLAG_NORMAL;
	}

	/* 是否在接待时间的半个工作日之前 */
	private int checkCanCancelApply(LawyerApply lawyerApply) {
		String receptDate = lawyerApply.getReceptionDate();
		int cancel = -1;

		Calendar today = Calendar.getInstance();
		today.setTime(new Date());

		if (StringUtils.isNotEmpty(receptDate)) {
			// 判断当前时间是否在可允许操作的范围内
			if (today.compareTo(getVerifyDate(receptDate)) <= 0) {
				cancel = 1; // 允许取消预约
			} else {
				cancel = 0;
			}
		} else {
			cancel = 1; // 允许取消预约
		}
		return cancel;

	}

	private String getVerifyDateDiff(LawyerApply lawyerApply) {
		String receptDate = lawyerApply.getReceptionDate();
		String result = "";

		Calendar today = Calendar.getInstance();
		today.setTime(new Date());
		Calendar verifyDate = getVerifyDate(receptDate);
		// in milliseconds
		long diff = verifyDate.getTimeInMillis() - today.getTimeInMillis();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
		result += diffDays > 0 ? String.valueOf(diffDays) + "天" : "";
		result += diffHours > 0 ? String.valueOf(diffHours) + "小时" : "";
		result += diffMinutes > 0 ? String.valueOf(diffMinutes) + "分" : "";
		// result += diffSeconds > 0? String.valueOf(diffSeconds)+ "秒" : "";
		return result;

	}

	private Calendar getVerifyDate(String receptDate) {
		Calendar verifyDate = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		today.setTime(new Date());
		if (StringUtils.isNotEmpty(receptDate)) {
			if (receptDate.indexOf("上午") > -1) {
				receptDate = receptDate.substring(0, receptDate.indexOf("上午"))
						.trim();
				Date receptionDate = DateUtils.parseDate(receptDate);
				verifyDate.setTime(receptionDate);
				if (verifyDate.get(Calendar.DAY_OF_WEEK) <= 6
						&& verifyDate.get(Calendar.DAY_OF_WEEK) > 2) {// 如果接待时间为周二到周五
					verifyDate.add(Calendar.DATE, -1);// + " 16:00:00";
					verifyDate.set(Calendar.HOUR, 16);
					verifyDate.set(Calendar.MINUTE, 0);
					verifyDate.set(Calendar.SECOND, 0);
				} else if (verifyDate.get(Calendar.DAY_OF_WEEK) == 2) {// 接待时间为周一
					verifyDate.add(Calendar.DATE, -3);// + " 16:00:00";
					verifyDate.set(Calendar.HOUR, 16);
					verifyDate.set(Calendar.MINUTE, 0);
					verifyDate.set(Calendar.SECOND, 0);
				}
			} else if (receptDate.indexOf("下午") > -1) {
				receptDate = receptDate.substring(0, receptDate.indexOf("下午"))
						.trim();
				Date receptionDate = DateUtils.parseDate(receptDate);
				verifyDate.setTime(receptionDate);
				verifyDate.set(Calendar.HOUR, 10);
				verifyDate.set(Calendar.MINUTE, 0);
				verifyDate.set(Calendar.SECOND, 0);
			}
			logger.debug("today=" + today.toString() + " verifyDate="
					+ verifyDate.toString());
			// 判断当前时间是否在可允许操作的范围内
			return verifyDate;
		} else {
			return today; // 允许取消预约
		}
	}
	
	
	/**
	 * 根据lawyercardnum查看对应律师是否存在有效黑名单记录 
	 * 2015/5/7
	 * @return
	 */
	@RequestMapping(value = "/inBlackList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	 int getLawyerInfoByPersonid(@RequestParam(value = "lawyercardnum", required = true) String lawyerCardnum) {
		int isStatus = 0;
		List blacklist=blackListService.find(lawyerCardnum);
		if(blacklist != null && blacklist.size() >0 ){
			isStatus=blacklist.size();
		}
		return isStatus;
	}
	
	@RequestMapping(value = "/sendappendix", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
	@ResponseBody
	public String sendAttachmentForm(
			// @RequestParam("appendix_id") String appendix_id,
			@RequestParam("old_filename") String oldfilename,
			// @RequestParam("filename") String filename,
			@RequestParam("casesearch_id") String casesearchid,
			@RequestParam("appendixNum") String num,
			@RequestParam("apptype") String apptype,

			@RequestParam("file") MultipartFile uploadfile,
			HttpServletRequest request, HttpServletResponse response) {

		if (!uploadfile.isEmpty()) {
			byte[] bytes = null;
			int index = Integer.parseInt(num);
			try {
				if ("".equals(casesearchid)) {
					return null;
				}
				
				LawyerApply lawyerApply = lawyerApplyService.get(Long
						.parseLong(casesearchid));
				
				String fileName = LawUtils.getAppendixFileName(num,
						lawyerApply.getSearchCode(),
						oldfilename.substring(oldfilename.lastIndexOf(".")));
				String temporaryAppendixPath = LawUtils
						.getTemporaryAppendixPath(fileName,
								lawyerApply.getCrtime());
				String appendixPath = LawUtils.getAppendixPath(fileName,
						lawyerApply.getCrtime());
				
				File file = new File(temporaryAppendixPath);
				LawAppendix appendix = new LawAppendix();
				appendix.setFilename(fileName);
				Page<LawAppendix> lawAppendix = lawAppendixService.find(
						new Page<LawAppendix>(request, response), appendix);
				if (lawAppendix.getList() != null
						&& lawAppendix.getList().size() > 0) {
					num = lawAppendix.getList().size() + index + "";
				}

				fileName = LawUtils.getAppendixFileName(num,
						lawyerApply.getSearchCode(),
						oldfilename.substring(oldfilename.lastIndexOf(".")));
				appendixPath = LawUtils.getAppendixPath(fileName,
						lawyerApply.getCrtime());
				bytes = uploadfile.getBytes();
				FileUtils.writeByteArrayToFile(file, bytes);
				try {
					FileUtil.Encrypt(sKey, sIv, temporaryAppendixPath,
							appendixPath);
					file.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
				appendix.setFilename(fileName);
				appendix.setOldfilename(LawUtils
						.getAppendixOldFileName(oldfilename));
				appendix.setSearchappid(Long.parseLong(casesearchid));
				//add by ycl 附件类型：诉讼业务字段值为103，诉讼流程字段值104。
				appendix.setApptype(apptype);
				appendix.setCrtime(new Date());
				lawAppendixService.save(appendix);
				
				if(LawyerApply.APPLY_DEAL_STATUS_DATA_FAULT == lawyerApply.getDealStatus()){
					lawyerApply.setDealStatus(LawyerApply.APPLY_DEAL_STATUS_DATA_FULL);
					lawyerApplyService.save(lawyerApply);
				}
			} catch (IOException e) {
			}
			
			return "file upload received! ID:[" + casesearchid + "] Size:["
					+ bytes.length + "]";
		} else {
			return "file upload failed!";
		}
	}
	@RequestMapping(value = "/getAppendixs/{searchapplyid}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<LawAppendix> getAppendixs(@PathVariable String searchapplyid) {
		Long id = Long.parseLong(searchapplyid);
		List<LawAppendix> appendixs = lawAppendixService.getBySearchId(id);
		for (LawAppendix lawAppendix : appendixs) {
			String url = "/law/lawyer/getAppendixFile/"
					+ lawAppendix.getAppendixid();
			lawAppendix.setOldfilename(url);
		}
		return appendixs;
	}

	@RequestMapping(value = "/getAppendixFile/{appendixid}", method = RequestMethod.GET)
	public void getFile(@PathVariable("appendixid") String appendixid,
			HttpServletResponse response) {
		LawAppendix appendix = null;
		try {
			long id = NumberUtils.toLong(appendixid);
			appendix = lawAppendixService.get(id);
			LawyerApply lawyerApply = lawyerApplyService.get(appendix.getSearchappid());
			String temporaryAppendixPath = LawUtils.getTemporaryAppendixPath(
					appendix.getFilename(), appendix.getCrtime());
			String appendixPath = LawUtils.getAppendixPath(
					appendix.getFilename(), lawyerApply.getCrtime());
			try {
				FileUtil.fileDecrypt(sKey, sIv, appendixPath,
						temporaryAppendixPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
			File file = new File(temporaryAppendixPath);
			BufferedImage image = ImageIO.read(file);
			BufferedImage thumbnail = Scalr.resize(image, Scalr.Method.SPEED,
					300);

			// copy it to response's OutputStream
			OutputStream out = response.getOutputStream();
			ImageIO.write(thumbnail, "jpg", out);
			// get your file as InputStream
			InputStream is = new FileInputStream(file);
			// copy it to response's OutputStream
			IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();
			file.delete();
		} catch (IOException ex) {
			log.error("Error writing file to output stream. Filename was '"
					+ appendix.getFilename() + "'");
			throw new RuntimeException("IOError writing file to output stream");
		}
	}


}
