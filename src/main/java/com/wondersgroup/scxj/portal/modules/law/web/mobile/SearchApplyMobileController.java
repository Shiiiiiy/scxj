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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
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

import com.trs.xwcm.shjcy.util.FileUtil;
import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.common.web.BaseController;
import com.wondersgroup.scxj.portal.modules.law.entity.LawAppendix;
import com.wondersgroup.scxj.portal.modules.law.entity.Lawyer;
import com.wondersgroup.scxj.portal.modules.law.entity.MessageLogs;
import com.wondersgroup.scxj.portal.modules.law.entity.SearchApply;
import com.wondersgroup.scxj.portal.modules.law.service.CaseService;
import com.wondersgroup.scxj.portal.modules.law.service.LawAppendixService;
import com.wondersgroup.scxj.portal.modules.law.service.LawyerService;
import com.wondersgroup.scxj.portal.modules.law.service.MessageLogsService;
import com.wondersgroup.scxj.portal.modules.law.service.SearchApplyService;
import com.wondersgroup.scxj.portal.modules.law.utils.LawUtils;

/**
 * 诉讼流程Controller
 * 
 * @author LiRiChen
 * @version 2014-03-30
 */
@Controller
@RequestMapping(value = "${mobilePath}/law/searchapply")
public class SearchApplyMobileController extends BaseController {

	protected final Log log = LogFactory.getLog(getClass());

	private String sKey = "678ILoveReamy789";
	private String sIv = "ILoveReamy123456";
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private SearchApplyService searchApplyService;

	@Autowired
	private LawAppendixService lawAppendixService;

	@Autowired
	private LawyerService lawyerService;

	@Autowired
	private CaseService caseService;

	@Autowired
	private MessageLogsService messageLogsService;

	@RequestMapping(value = "/{searchapplyid}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public SearchApply getSearchApply(@PathVariable String searchapplyid) {
		Long id = Long.parseLong(searchapplyid);
		SearchApply searchApply = searchApplyService.get(id);
		Lawyer lawyer = lawyerService.getByLawyerIdNumber(searchApply
				.getLawyeridcode());
		if (lawyer != null) {
			searchApply.setLawyerRegTel(lawyer.getMobile());
			searchApply.setLawyerRegEmail(lawyer.getEmail());
		}
		if (searchApply.getPersonid() != null) {
			List<Object> wcmCases = caseService.getByPersonId(searchApply
					.getPersonid());
			if (wcmCases != null && wcmCases.size() > 0) {
				Object[] wcmCase = (Object[]) wcmCases.get(0);
				searchApply.setCasestage((String) wcmCase[1]);
				searchApply.setCaseaccepctnum((String) wcmCase[2]);
			}
		}
		if (getUpdateDate(searchApply) != null) {
			searchApply.setCaseacceptdate(dateFormat
					.format(getUpdateDate(searchApply)));
		}
		// List<LawAppendix> appendixs =
		// lawAppendixService.getBySearchId(Long.parseLong(searchapplyid));
		// searchApply.setLawAppendixs(appendixs);
		return searchApply;
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

	@RequestMapping(value = "/savesearchapply", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public String save(@RequestBody SearchApply searchApply) {
		//判断是否重复提交,根据嫌疑人姓名、案由、律师执业证号、承办单位这4个字段来判断是否是重复提交，重复提交，判断重复提交的信息当前状态是否通过审核，已通过审核，则可以提交该信息，提示“提交成功”，未通过审核，则不能提交该信息
		Page<SearchApply> page1 = searchApplyService.findRepeat(new Page<SearchApply>(0, -1), searchApply);
		List repeatlist=new ArrayList();
		repeatlist=page1.getList();
		if(repeatlist != null && repeatlist.size() > 0){
			searchApply=(SearchApply)repeatlist.get(0);
			return SearchApply.DEL_FLAG_REPEAT + SearchApply.SEARCHAPPID + searchApply.getSearchappid();
		}else{
			searchApply.setApplyway((long) SearchApply.SEARCHAPPLY_APPLYWAY_SJ);
			//判断律师姓名、律师事务所名称、律师执证号是否为空，并在数据库内查出补上
			if(searchApply.getLawyername()==null||"".equals(searchApply.getLawyername())||searchApply.getLawfirmname()==null||"".equals(searchApply.getLawfirmname())||searchApply.getLawyercardnum()==null||"".equals(searchApply.getLawyercardnum())){
				LawyerService ls=new LawyerService();
				Lawyer locallawyer=ls.getByLawyerMobile(searchApply.getLawyertel());
				if(searchApply.getLawyername()==null||"".equals(searchApply.getLawyername())){
					searchApply.setLawyername(locallawyer.getName());
				}
				if(searchApply.getLawfirmname()==null||"".equals(searchApply.getLawfirmname())){
					searchApply.setLawfirmname(locallawyer.getLawfirmname());
				}
				if(searchApply.getLawyercardnum()==null||"".equals(searchApply.getLawyercardnum())){
					searchApply.setLawyercardnum(locallawyer.getLisensenumber());
				}
			}
			
			searchApplyService.save(searchApply);
			return SearchApply.DEL_FLAG_NORMAL + SearchApply.SEARCHAPPID + searchApply.getSearchappid();
		}
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
				SearchApply searchApply = searchApplyService.get(Long
						.parseLong(casesearchid));
				String fileName = LawUtils.getAppendixFileName(num,
						searchApply.getSearchcode(),
						oldfilename.substring(oldfilename.lastIndexOf(".")));
				String temporaryAppendixPath = LawUtils
						.getTemporaryAppendixPath(fileName,
								searchApply.getCrtime());
				String appendixPath = LawUtils.getAppendixPath(fileName,
						searchApply.getCrtime());
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
						searchApply.getSearchcode(),
						oldfilename.substring(oldfilename.lastIndexOf(".")));
				appendixPath = LawUtils.getAppendixPath(fileName,
						searchApply.getCrtime());
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
				System.out.println("附件表id是"+appendix.getAppendixid());
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
			String url = "/law/searchapply/getAppendixFile/"
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
			String temporaryAppendixPath = LawUtils.getTemporaryAppendixPath(
					appendix.getFilename(), appendix.getCrtime());
			String appendixPath = LawUtils.getAppendixPath(
					appendix.getFilename(), appendix.getCrtime());
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
