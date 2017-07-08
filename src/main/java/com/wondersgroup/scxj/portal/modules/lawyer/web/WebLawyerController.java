/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.lawyer.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.shiro.SecurityUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.trs.xwcm.shjcy.util.FileUtil;
import com.wondersgroup.scxj.portal.common.config.Global;
import com.wondersgroup.scxj.portal.common.persistence.BaseEntity;
import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.common.utils.StringUtils;
import com.wondersgroup.scxj.portal.common.web.BaseController;
import com.wondersgroup.scxj.portal.modules.law.entity.LawAppendix;
import com.wondersgroup.scxj.portal.modules.law.entity.Lawyer;
import com.wondersgroup.scxj.portal.modules.law.entity.LawyerApply;
import com.wondersgroup.scxj.portal.modules.law.entity.MessageLogs;
import com.wondersgroup.scxj.portal.modules.law.entity.SearchApply;
import com.wondersgroup.scxj.portal.modules.law.service.CaseService;
import com.wondersgroup.scxj.portal.modules.law.service.LawAppendixService;
import com.wondersgroup.scxj.portal.modules.law.service.LawyerApplyService;
import com.wondersgroup.scxj.portal.modules.law.service.LawyerService;
import com.wondersgroup.scxj.portal.modules.law.service.MessageLogsService;
import com.wondersgroup.scxj.portal.modules.law.service.SearchApplyService;
import com.wondersgroup.scxj.portal.modules.law.utils.LawUtils;
import com.wondersgroup.scxj.portal.modules.lawyer.entity.Leamassge;
import com.wondersgroup.scxj.portal.modules.lawyer.service.MessageService;
import com.wondersgroup.scxj.portal.modules.lawyer.utils.JcyUtils;
import com.wondersgroup.scxj.portal.modules.lawyer.utils.TransString;
import com.wondersgroup.scxj.portal.modules.sys.utils.UserUtils;

/**
 * 检察院web版律师
 * 
 */
@Controller
@RequestMapping(value = "${lawyerPath}/lawyer")
public class WebLawyerController extends BaseController {
	private String sKey = "678ILoveReamy789";
	private String sIv = "ILoveReamy123456";
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private LawAppendixService lawAppendixService;
	
	@Autowired
	private SearchApplyService searchApplyService;
	
	@Autowired
	private LawyerApplyService lawyerApplyService;
	
	@Autowired
	private LawyerService lawyerService;
	
	@Autowired
	private MessageLogsService messageLogsService;
	
	@Autowired
	private CaseService caseService;
	
	@RequestMapping(value = "loginb")
	public String loginb() {
		return "modules/lawyer/login_before";
	}
	@RequestMapping(value = "bdlogin")
	public String map1() {
		return "modules/lawyer/login";
	}
	@RequestMapping(value = "fblogin")
	public String map2(Model model) {
		model.addAttribute("pageNumHid","0");
		return "modules/lawyer/fblogin";
	}
	@RequestMapping(value = "wcmdocument/index")
	public String map3(Model model) {
		Lawyer lawyer = UserUtils.getLawyerUser();
		if(lawyer.getMobile()==null||lawyer.getMobile().equals("null")){
			lawyer.setMobile("");
		}
		if(lawyer.getEmail()==null||lawyer.getEmail().equals("null")){
			lawyer.setEmail("");
		}
		model.addAttribute("lawyerUser", lawyer);
		return "modules/lawyer/index";
	}
		
	@RequestMapping(value = "wcmdocument/dologin")
	public String map4(LawyerApply lawyerApply,HttpServletRequest request,HttpServletResponse response,Model model) {
		Lawyer lawyer = UserUtils.getLawyerUser();
		model.addAttribute("lawyerUser", lawyer);
		return "modules/lawyer/dologin";
	}
	
	@RequestMapping(value = "wcmdocument/person_home")
	public String pageMap() {
		return "modules/lawyer/pages/person_home";
	}
	@RequestMapping(value = "wcmdocument/tb_home")
	public String pageMap1() {
		return "modules/lawyer/pages/tb_home";
	}
	@RequestMapping(value = "wcmdocument/sslc_frame")
	public String pageMap2() {
		return "modules/lawyer/pages/sslc_frame";
	}
	
	@RequestMapping(value = "wcmdocument/sslc_menu")
	public String pageMap3() {
		return "modules/lawyer/pages/sslc_menu";
	}
	@RequestMapping(value = "wcmdocument/bar")
	public String pageMap4() {
		return "modules/lawyer/pages/bar";
	}
	/*@RequestMapping(value = "sslc_list")
	public String pageMap5() {
		return "modules/lawyer/pages/sslc_list";
	}*/
	@RequestMapping(value = "wcmdocument/cx_list")
	public String pageMap6() {
		return "modules/lawyer/pages/cx_list";
	}
	@RequestMapping(value = "wcmdocument/sy_menu")
	public String pageMap7() {
		return "modules/lawyer/pages/sy_menu";
	}
	@RequestMapping(value = "wcmdocument/sy_list")
	public String pageMap8() {
		return "modules/lawyer/pages/sy_list";
	}
	@RequestMapping(value = "wcmdocument/tb_frame")
	public String pageMap9() {
		return "modules/lawyer/pages/tb_frame";
	}
	@RequestMapping(value = "wcmdocument/tb_menu")
	public String pageMap10() {
		return "modules/lawyer/pages/tb_menu";
	}
	@RequestMapping(value = "wcmdocument/tb_list_1")
	public String pageMap11() {
		return "modules/lawyer/pages/tb_list_1";
	}
	@RequestMapping(value = "wcmdocument/tb_list_2")
	public String pageMap12() {
		return "modules/lawyer/pages/tb_list_2";
	}
	@RequestMapping(value = "wcmdocument/tb_list_3")
	public String pageMap13() {
		return "modules/lawyer/pages/tb_list_3";
	}
	@RequestMapping(value = "wcmdocument/jcyTree/{ssType}")
	public String pageMap14(@PathVariable String ssType, Model model) {
		String ssUrl="";
		if(ssType.equals("sslc")){
			ssUrl="/l/lawyer/wcmdocument/sslc_yy";
		}else if(ssType.equals("ssyw")){
			ssUrl="/l/lawyer/wcmdocument/ssyw_yy";
		}
		model.addAttribute("ssUrl",ssUrl);
		return "modules/lawyer/pages/jcyTree";
	}
	@RequestMapping(value = "wcmdocument/lyb_con")
	public String pageMap15() {
		return "modules/lawyer/pages/lyb_con";
	}
	@RequestMapping(value = "wcmdocument/sslc_yy")
	public String pageMap16(@RequestParam(value = "lawId", required = false) Long lawId,
			@RequestParam(value = "groupId", required = false) String groupId,Model model) {
		Lawyer lawyer = UserUtils.getLawyerUser();
		model.addAttribute("lawyerUser", lawyer);
		List<String> list=JcyUtils.getJcyInfo(groupId);
		model.addAttribute("groupId", groupId);
		model.addAttribute("groupName", list.get(0));
		model.addAttribute("groupAdd", list.get(1));
		model.addAttribute("groupTel", list.get(2));
		model.addAttribute("groupTime", list.get(3));
		return "modules/lawyer/pages/sslc_yy";
	}
	@RequestMapping(value = "wcmdocument/ssyw_yy")
	public String pageMap17(@RequestParam(value = "lawId", required = false) Long lawId,
			@RequestParam(value = "groupId", required = false) String groupId,Model model) {
		Lawyer lawyer = UserUtils.getLawyerUser();
		model.addAttribute("lawyerUser", lawyer);
		List<String> list=JcyUtils.getJcyInfo(groupId);
		model.addAttribute("groupId", groupId);
		model.addAttribute("groupName", list.get(0));
		model.addAttribute("groupAdd", list.get(1));
		model.addAttribute("groupTel", list.get(2));
		model.addAttribute("groupTime", list.get(3));
		return "modules/lawyer/pages/ssyw_yy";
	}
	@RequestMapping(value = "wcmdocument/ssyw_frame")
	public String pageMap18() {
		return "modules/lawyer/pages/ssyw_frame";
	}
	@RequestMapping(value = "wcmdocument/ssyw_menu")
	public String pageMap19() {
		return "modules/lawyer/pages/ssyw_menu";
	}
	
	@RequestMapping(value = "wcmdocument/liuyan_menu")
	public String pageMap22() {
		return "modules/lawyer/pages/liuyan_menu";
	}
	
	@RequestMapping(value = {"wcmdocument/ajax/ssyw_list",""})
	public String ssywList(@RequestParam(value = "StartDate", required = false) String StartDate,
			@RequestParam(value = "EndDate", required = false) String EndDate,
			@RequestParam(value = "pageNumHid", required = false) String pageNumHid,
			@RequestParam(value = "dealStatus", required = false) Integer dealStatus,
			@RequestParam(value = "ismiss", required = false) Integer isMiss,
			@RequestParam(value = "feedbackStatus", required = false) Integer feedStatus,
			LawyerApply lawyerApply,HttpServletRequest request,HttpServletResponse response, Model model) {
		Lawyer lawyer = UserUtils.getLawyerUser();
		lawyerApply.setLawyerCardnum(lawyer.getLisensenumber());
		if (StringUtils.isEmpty(pageNumHid)) {
			pageNumHid="1";
		}
        Page<LawyerApply> page = lawyerApplyService.find(new Page<LawyerApply>(request, response), lawyerApply,pageNumHid,"10",StartDate,EndDate,dealStatus,isMiss,feedStatus); 
        long total=page.getCount();
        long n=total/10;
        long m=total%10;
        if(m>0){
        	n=n+1;
        }
        model.addAttribute("page", page);
        model.addAttribute("pageNumHid",pageNumHid);
        model.addAttribute("total",n);
        model.addAttribute("totals",total);
		return "modules/lawyer/pages/ssyw_list";
	}
	
	/**
	 * 律师诉讼流程列表
	 */
	@RequestMapping(value = {"wcmdocument/ajax/sslc_list", ""})
	public String sslcList(@RequestParam(value = "StartDate", required = false) String StartDate,
			@RequestParam(value = "EndDate", required = false) String EndDate,
			@RequestParam(value = "pageNumHid", required = false) String pageNumHid,
			SearchApply searchApply,HttpServletRequest request,HttpServletResponse response, Model model) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Lawyer lawyer = UserUtils.getLawyerUser();
		searchApply.setLawyercardnum(lawyer.getLisensenumber());
		if (StringUtils.isEmpty(pageNumHid)) {
			pageNumHid="1";
		}
        Page<SearchApply> page = searchApplyService.find(new Page<SearchApply>(request, response), searchApply,pageNumHid,"10",StartDate,EndDate); 
        List<SearchApply> result = new ArrayList<SearchApply>();
		for (SearchApply apply : page.getList()) {
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
        page.setList(result);
        long total=page.getCount();
        long n=total/10;
        long m=total%10;
        if(m>0){
        	n=n+1;
        }
        model.addAttribute("page", page);
        model.addAttribute("pageNumHid",pageNumHid);
        model.addAttribute("total",n);
        model.addAttribute("totals",total);
		return "modules/lawyer/pages/sslc_list";
	}
	/**
	 * 律师诉讼业务  在线预约
	 */
	@RequestMapping(value = "wcmdocument/ssyw/apply", method = RequestMethod.POST,headers = "Content-Type=multipart/form-data")
	public String ssywApply(LawyerApply lawyerApply,HttpServletRequest request,HttpServletResponse response, Model model) {
		//判断是否重复提交,根据嫌疑人姓名、案由、律师执业证号、承办单位这4个字段来判断是否是重复提交，重复提交，判断重复提交的信息当前状态是否通过审核，已通过审核，则可以提交该信息，提示“提交成功”，未通过审核，则不能提交该信息
		List repeatlist = lawyerApplyService.findRepeat(lawyerApply);
		if(repeatlist != null && repeatlist.size() > 0){
			lawyerApply=(LawyerApply)repeatlist.get(0);
			
			model.addAttribute("applyType","error");
			//model.addAttribute("OPRESULT", SearchApply.DEL_FLAG_REPEAT);
			model.addAttribute("OPRESULT", LawyerApply.message_save_lawyer_repeat);
			model.addAttribute("OPFLAG", LawyerApply.SEARCHAPPID );
			model.addAttribute("OPFLAGID",lawyerApply.getId());
			return "modules/lawyer/pages/reload";
		}else{
			
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
			String orderDate=lawyerApply.getOrderDate().trim();
			if(orderDate.endsWith("或")){
				orderDate=orderDate.substring(0,orderDate.length()-2 );
			}
			lawyerApply.setOrderDate(orderDate);
			lawyerApply.setApplyId(LawyerApply.SEARCHAPPLY_APPLYWAY_WS);
			lawyerApplyService.save(lawyerApply);
			HttpServletRequest request1=request;
			MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request1;
			Map<String, MultipartFile> fileMap = mRequest.getFileMap();

			int i=1;
			for (Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet()	.iterator(); it.hasNext();) {
					Map.Entry<String, MultipartFile> entry = it.next();
					MultipartFile uploadfile = entry.getValue();
					String oldfilename =uploadfile.getOriginalFilename();
					String casesearchid = String.valueOf(lawyerApply.getId());
					String num = String.valueOf(i);
					String apptype = "103";
					i++;
					sendAttachmentLawyerForm(oldfilename,casesearchid,num,apptype,uploadfile,request,response);
			}
			
			model.addAttribute("applyType","ssyw");
			model.addAttribute("lawyerApply",lawyerApply);
			//model.addAttribute("OPRESULT", LawyerApply.message_save_lawyer_apply_ok);
			//model.addAttribute("OPFLAG", LawyerApply.SEARCHAPPID );
			//model.addAttribute("OPFLAGID",lawyerApply.getId());
			return "modules/lawyer/pages/reload";
		}
	}
	
	/**
	 * 律师诉讼流程  在线预约
	 */
	@RequestMapping(value = "wcmdocument/sslc/apply", method = RequestMethod.POST,headers = "Content-Type=multipart/form-data")
	public String sslcApply(SearchApply searchApply,HttpServletRequest request,HttpServletResponse response, Model model) {
		//判断是否重复提交,根据嫌疑人姓名、案由、律师执业证号、承办单位这4个字段来判断是否是重复提交，重复提交，判断重复提交的信息当前状态是否通过审核，已通过审核，则可以提交该信息，提示“提交成功”，未通过审核，则不能提交该信息
		Page<SearchApply> page1 = searchApplyService.findRepeat(new Page<SearchApply>(0, -1), searchApply);
		List repeatlist=new ArrayList();
		repeatlist=page1.getList();
		if(repeatlist != null && repeatlist.size() > 0){
			searchApply=(SearchApply)repeatlist.get(0);
			//model.addAttribute("OPRESULT", SearchApply.DEL_FLAG_REPEAT);
			model.addAttribute("applyType","error");
			model.addAttribute("OPRESULT", SearchApply.message_save_lawyer_repeat);
			model.addAttribute("OPFLAG", SearchApply.SEARCHAPPID );
			model.addAttribute("OPFLAGID", searchApply.getSearchappid());
			return "modules/lawyer/pages/reload";
		}else{
			searchApply.setApplyway((long) SearchApply.SEARCHAPPLY_APPLYWAY_WS);
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
			HttpServletRequest request1=request;
			MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request1;
			Map<String, MultipartFile> fileMap = mRequest.getFileMap();

			int i=1;
			for (Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet()	.iterator(); it.hasNext();) {
					Map.Entry<String, MultipartFile> entry = it.next();
					MultipartFile uploadfile = entry.getValue();
					String oldfilename =uploadfile.getOriginalFilename();
					String casesearchid = String.valueOf(searchApply.getSearchappid());
					String num = String.valueOf(i);
					String apptype = "104";
					i++;
					sendAttachmentForm(oldfilename,casesearchid,num,apptype,uploadfile,request,response);
			}
			
			model.addAttribute("applyType","sslc");
			model.addAttribute("searchApply",searchApply);
			//model.addAttribute("OPRESULT", SearchApply.message_save_lawyer_process_ok);
			//model.addAttribute("OPFLAG", SearchApply.SEARCHAPPID );
			//model.addAttribute("OPFLAGID", searchApply.getSearchappid());
			return "modules/lawyer/pages/reload";
		}
	}
	
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

				LawAppendix appendix = new LawAppendix();
				appendix.setApptype("104");
				appendix.setSearchappid(Long.parseLong(casesearchid));
				Page<LawAppendix> lawAppendix = lawAppendixService.findByIdType(
						new Page<LawAppendix>(request, response), appendix);
				if (lawAppendix.getList() != null
						&& lawAppendix.getList().size() > 0) {
					int s= lawAppendix.getList().size() + 1 ;
					num=s+"";
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
				
				if(SearchApply.SEARCHAPPLY_DEAL_STATUS_DATA_FAULT == searchApply.getDealstatus()){
					searchApply.setDealstatus(SearchApply.SEARCHAPPLY_DEAL_STATUS_DATA_FULL);
					searchApplyService.save(searchApply);
				}
			} catch (IOException e) {
			}
			return "file upload received! ID:[" + casesearchid + "] Size:["
					+ bytes.length + "]";
		} else {
			return "file upload failed!";
		}
	}
	
	public String sendAttachmentLawyerForm(
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

				LawAppendix appendix = new LawAppendix();
				appendix.setApptype("103");
				appendix.setSearchappid(Long.parseLong(casesearchid));
				Page<LawAppendix> lawAppendix = lawAppendixService.findByIdType(
						new Page<LawAppendix>(request, response), appendix);
				if (lawAppendix.getList() != null
						&& lawAppendix.getList().size() > 0) {
					int s= lawAppendix.getList().size() + 1 ;
					num=s+"";
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
	
	public String sendAttachmentLawyerForm(String oldfilename,String casesearchid,String num,String apptype,
			String temporaryAppendixPath,
			HttpServletRequest request, HttpServletResponse response) {

				if ("".equals(casesearchid)) {
					return null;
				}
				int index = Integer.parseInt(num);
				LawyerApply lawyerApply = lawyerApplyService.get(Long
						.parseLong(casesearchid));
				//文件名称
				String fileName = LawUtils.getAppendixFileName(num,
						lawyerApply.getSearchCode(),
						oldfilename.substring(oldfilename.lastIndexOf(".")));
				//存储地址
				String appendixPath = LawUtils.getAppendixPath(fileName,
						lawyerApply.getCrtime());
				LawAppendix appendix = new LawAppendix();
				appendix.setFilename(fileName);
				//由拼成的文件名查找数据库中是否存在。一条数据最多对应五张附件，且对应顺序1-5，则若已存在，当前为修改，应先删除原有的
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
				try {
					//将原解密文件拷贝到新的地址
					FileUtil.Encrypt(sKey, sIv, temporaryAppendixPath,
							appendixPath);
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
			
			
			return "file upload received! ID:[" + casesearchid + "]";
		
	}
	
	@RequestMapping(value = "logout")
	public String logout(LawyerApply lawyerApply, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		SecurityUtils.getSubject().logout();
		//return "modules/law/mobile/lawyerApplyMobileLogout";
		//return "redirect:" + URL_LAWYER_LOGOUT;			
		return "modules/lawyer/dologout";
	}
	
	@RequestMapping(value = "wcmdocument/liuyan_frame")
	public String pageMap21() {
		return "modules/lawyer/pages/liuyan_frame";
	}

	@RequestMapping(value = "wcmdocument/leamassge")
	// 封装留言板表单数据
	public String getFormData(HttpServletRequest request) {
		String lyone = request.getParameter("LYONE");
		String lytwo = request.getParameter("LYTWO");
		String lmsg = request.getParameter("LMSG");
		Leamassge msg = new Leamassge();
		Lawyer lawyer = UserUtils.getLawyerUser();
		msg.setPid(lawyer.getId());
		msg.setLmusername(lawyer.getName());
		msg.setLyone(Integer.parseInt(lyone));
		msg.setLytwo(Integer.parseInt(lytwo));
		msg.setLmsg(lmsg);
		msg.setCrtime(new Date());
		/*request.setAttribute("msg", msg);*/
		messageService.save(msg);
		return "redirect:../../lawyer/wcmdocument/lyb_con";
	}

	/**
	 * 律师预约留言列表
	 */
	@RequestMapping(value = "lyb_con")
	public String lybList(@RequestParam(value = "pageNumHid", required = false) String pageNumHid, Leamassge msg,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		if (StringUtils.isEmpty(pageNumHid)) {
			pageNumHid = "1";
		}
		Page<Leamassge> page = messageService.find(new Page<Leamassge>(request, response), msg, pageNumHid, "10");
		model.addAttribute("page", page);
		model.addAttribute("pageNumHid", pageNumHid);
		model.addAttribute("pageCount", pageNumHid);
		return "modules/lawyer/pages/lyb_con";
	}

	@RequestMapping(value = "wcmdocument/lsly_list")
	public String lslyList(@RequestParam(value = "pageNumHid", required = false) String pageNumHid, Leamassge msg,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		Lawyer lawyer = UserUtils.getLawyerUser();
		msg.setPid(lawyer.getId());
		msg.setLmusername(lawyer.getName());
		if (StringUtils.isEmpty(pageNumHid)) {
			pageNumHid = "1";
		}
		Page<Leamassge> page = messageService.find(new Page<Leamassge>(request, response), msg, pageNumHid, "10");
		model.addAttribute("page", page);
		model.addAttribute("pageNumHid", pageNumHid);
		int num = 0;
		int b = (int) page.getCount() % 10;
		if (b == 0) {
			num = (int) page.getCount() / 10;
		} else {
			num = (int) page.getCount() / 10 + 1;
		}
		model.addAttribute("pageCount", num);
		model.addAttribute("record", page.getCount());
		return "modules/lawyer/pages/lsly_list";
	}
	
	@RequestMapping(value = { "fblist", "" })
	public String fbList(@RequestParam(value = "pageNumHid", required = false) String pageNumHid,
			SearchApply searchApply,HttpServletRequest request,HttpServletResponse response, Model model) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// User user = UserUtils.getUser();
		if(pageNumHid==null || pageNumHid.equals("0") || pageNumHid.equals("")){
			pageNumHid="1";
		}
		
		Page<SearchApply> page = searchApplyService.find(new Page<SearchApply>(request, response), searchApply,pageNumHid,"10",null,null); 
		List<SearchApply> all = new ArrayList<SearchApply>();
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
		 int total=(int) page.getCount();
	     int n=total/10;
	     int m=total%10;
	     if(m>0){
	        n=n+1;
	      }
	      model.addAttribute("lawyercardnum", searchApply.getLawyercardnum());
	      model.addAttribute("searchpass", searchApply.getSearchpass());
	      model.addAttribute("list", result);
	      model.addAttribute("pageNumHid",pageNumHid);
	      model.addAttribute("total",n);
	      model.addAttribute("totals",total);
	      return "modules/lawyer/fblogin";
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
	
	//诉讼流程查看
	@RequestMapping(value = { "wcmdocument/sslcview", "" })
	public String sslcForm(@RequestParam(value = "id", required = false) String id,HttpServletRequest request,HttpServletResponse response, Model model) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Lawyer lawyer = UserUtils.getLawyerUser();
		SearchApply searchApply = searchApplyService.get(Long.parseLong(id));
		//获取附件
		LawAppendix appendix=new LawAppendix();
		appendix.setApptype("104");
		appendix.setSearchappid(searchApply.getSearchappid());
		Page<LawAppendix> lawAppendix = lawAppendixService.findByIdType(new Page<LawAppendix>(request, response), appendix);
		searchApply.setLawAppendixs(lawAppendix.getList());
		
		for(int i=0;i<lawAppendix.getList().size();i++){
			appendix=lawAppendix.getList().get(i);
			String temporaryAppendixPath = LawUtils.getTemporaryAppendixPath(
					appendix.getFilename(), searchApply.getCrtime());
			String appendixPath = LawUtils.getAppendixPath(
					appendix.getFilename(), searchApply.getCrtime());
			try {
				FileUtil.fileDecrypt(sKey, sIv, appendixPath,
						temporaryAppendixPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (getUpdateDate(searchApply) != null)
			searchApply.setCaseacceptdate(format.format(getUpdateDate(searchApply)));
		if (searchApply.getPersonid() != null) {
			List<Object> wcmCases = caseService.getByPersonId(searchApply
					.getPersonid());
			if (wcmCases != null && wcmCases.size() > 0) {
				Object[] wcmCase = (Object[]) wcmCases.get(0);
				searchApply.setCasestage((String) wcmCase[1]);
				searchApply.setCaseaccepctnum((String) wcmCase[2]);
			}
		}

		model.addAttribute("lawyerUser", lawyer);
		model.addAttribute("searchApply", searchApply);
		
		return "modules/lawyer/pages/sslc_view";
	}
	
	//诉讼流程预约进入诉讼业务
		@RequestMapping(value = { "wcmdocument/sslcTossyw", "" })
		public String sslcTossyw(@RequestParam(value = "id", required = false) String id,HttpServletRequest request,HttpServletResponse response, Model model) {
			SearchApply searchApply = searchApplyService.get(Long.parseLong(id));
			if("已通过".equals(TransString.getStatuStr(searchApply.getDealstatus()))){
				
			}else{
				model.addAttribute("OPRESULT", LawyerApply.message_save_lawyer_process_no_to);
				model.addAttribute("applyType","error");
				return "modules/lawyer/pages/reload";
			}

			LawAppendix appendix=new LawAppendix();
			appendix.setApptype("104");
			appendix.setSearchappid(searchApply.getSearchappid());
			Page<LawAppendix> lawAppendix = lawAppendixService.findByIdType(new Page<LawAppendix>(request, response), appendix);
			searchApply.setLawAppendixs(lawAppendix.getList());
			
			for(int i=0;i<lawAppendix.getList().size();i++){
				appendix=lawAppendix.getList().get(i);
				String temporaryAppendixPath = LawUtils.getTemporaryAppendixPath(
						appendix.getFilename(), searchApply.getCrtime());
				String appendixPath = LawUtils.getAppendixPath(
						appendix.getFilename(), searchApply.getCrtime());
				try {
					FileUtil.fileDecrypt(sKey, sIv, appendixPath,
							temporaryAppendixPath);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			Lawyer lawyer = UserUtils.getLawyerUser();
			
			List<String> list=JcyUtils.getJcyInfo(searchApply.getGroupid()+"");
			model.addAttribute("groupAdd", list.get(1));
			model.addAttribute("groupTel", list.get(2));
			model.addAttribute("groupTime", list.get(3));
			model.addAttribute("lawyerUser", lawyer);
			model.addAttribute("searchApply", searchApply);
			return "modules/lawyer/pages/sslc_To_ssyw";
	}
		/**
		 * 律师诉讼流程预约后，提交诉讼业务
		 */
		@RequestMapping(value = "wcmdocument/ssyw/newSave", method = RequestMethod.POST,headers = "Content-Type=multipart/form-data")
		public String ssywnewSave(@RequestParam(value = "oldSearchId", required = false) Long oldSearchId,LawyerApply lawyerApply,HttpServletRequest request,HttpServletResponse response, Model model) {
			//判断是否重复提交,根据嫌疑人姓名、案由、律师执业证号、承办单位这4个字段来判断是否是重复提交，重复提交，判断重复提交的信息当前状态是否通过审核，已通过审核，则可以提交该信息，提示“提交成功”，未通过审核，则不能提交该信息
			List repeatlist = lawyerApplyService.findRepeat(lawyerApply);
			if(repeatlist != null && repeatlist.size() > 0){
				lawyerApply=(LawyerApply)repeatlist.get(0);
				//model.addAttribute("OPRESULT", SearchApply.DEL_FLAG_REPEAT);
				model.addAttribute("applyType","error");
				model.addAttribute("OPRESULT", LawyerApply.message_save_lawyer_repeat);
				model.addAttribute("OPFLAG", LawyerApply.SEARCHAPPID );
				model.addAttribute("OPFLAGID",lawyerApply.getId());
				return "modules/lawyer/pages/reload";
			}
				String orderDate=lawyerApply.getOrderDate().trim();
				if(orderDate.endsWith("或")){
					orderDate=orderDate.substring(0,orderDate.length()-2 );
				}
				lawyerApply.setOrderDate(orderDate);
				lawyerApplyService.save(lawyerApply);
				HttpServletRequest request1=request;
				MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request1;
				Map<String, MultipartFile> fileMap = mRequest.getFileMap();
				
				
				LawAppendix appendix=new LawAppendix();
				appendix.setApptype("104");
				appendix.setSearchappid(oldSearchId);
				List<LawAppendix> lawAppendixs = lawAppendixService.findByIdType(new Page<LawAppendix>(request, response), appendix).getList();

				for(int j=0;j<lawAppendixs.size();j++){
					LawAppendix old =lawAppendixs.get(j);
					LawAppendix law=new LawAppendix();
					//存储在诉讼流程中的文件
					String appendixPath = LawUtils.getAppendixPath(
							old.getFilename(), old.getCrtime());
					String temporaryAppendixPath = LawUtils.getTemporaryAppendixPath(
							old.getFilename(), old.getCrtime());
					try {
						FileUtil.fileDecrypt(sKey, sIv, appendixPath,
								temporaryAppendixPath);
					} catch (Exception e) {
						e.printStackTrace();
					}

					//将诉讼流程的图片的对应序号取出
					int  n=old.getFilename().lastIndexOf(".");
					String num=old.getFilename().substring(n-1, n);	
					//获取存储所需的值
					String casesearchid = String.valueOf(lawyerApply.getId());
					String apptype = "103";
					
					sendAttachmentLawyerForm(old.getOldfilename(), casesearchid, num, apptype, temporaryAppendixPath, mRequest, response);
					
				}
				
				model.addAttribute("applyType","ssyw");
				model.addAttribute("lawyerApply",lawyerApply);
				//model.addAttribute("OPRESULT", LawyerApply.message_save_lawyer_process_to_apply_ok);
				//model.addAttribute("OPFLAG", LawyerApply.SEARCHAPPID );
				//model.addAttribute("OPFLAGID",lawyerApply.getId());
				return "modules/lawyer/pages/reload";
			
	}	
	
		//诉讼流程修改进入
		@RequestMapping(value = { "wcmdocument/sslcedit", "" })
		public String sslcEdit(@RequestParam(value = "id", required = false) String id,HttpServletRequest request,HttpServletResponse response, Model model) {
			SearchApply searchApply = searchApplyService.get(Long.parseLong(id));
			if(searchApply.getDealstatus()==17){
				
			}else{
				model.addAttribute("OPRESULT", LawyerApply.message_save_lawyer_process_no_edit);
				model.addAttribute("applyType","error");
				return "modules/lawyer/pages/reload";
			}

			LawAppendix appendix=new LawAppendix();
			appendix.setApptype("104");
			appendix.setSearchappid(searchApply.getSearchappid());
			Page<LawAppendix> lawAppendix = lawAppendixService.findByIdType(new Page<LawAppendix>(request, response), appendix);
			searchApply.setLawAppendixs(lawAppendix.getList());
			
			for(int i=0;i<lawAppendix.getList().size();i++){
				appendix=lawAppendix.getList().get(i);
				String temporaryAppendixPath = LawUtils.getTemporaryAppendixPath(
						appendix.getFilename(), searchApply.getCrtime());
				String appendixPath = LawUtils.getAppendixPath(
						appendix.getFilename(), searchApply.getCrtime());
				try {
					FileUtil.fileDecrypt(sKey, sIv, appendixPath,
							temporaryAppendixPath);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			Lawyer lawyer = UserUtils.getLawyerUser();
			
			List<String> list=JcyUtils.getJcyInfo(searchApply.getGroupid()+"");
			model.addAttribute("groupAdd", list.get(1));
			model.addAttribute("groupTel", list.get(2));
			model.addAttribute("groupTime", list.get(3));
			model.addAttribute("lawyerUser", lawyer);
			model.addAttribute("searchApply", searchApply);
			return "modules/lawyer/pages/sslc_edit";
		
		}	
		
		/**
		 * 律师诉讼流程  修改后提交
		 */
		@RequestMapping(value = "wcmdocument/sslc/edit", method = RequestMethod.POST,headers = "Content-Type=multipart/form-data")
		public String sslcEdit(SearchApply searchApply,HttpServletRequest request,HttpServletResponse response, Model model) {
			SearchApply oldsearchApply=searchApplyService.get(searchApply.getSearchappid());
			if(oldsearchApply.getDealstatus()==17){
				
			}else{
				model.addAttribute("OPRESULT", LawyerApply.message_save_lawyer_process_no_edit);
				model.addAttribute("applyType","error");
				return "modules/lawyer/pages/reload";
			}
			
			oldsearchApply.setSuspectsname(searchApply.getSuspectsname());
			oldsearchApply.setBrief(searchApply.getBrief());
			oldsearchApply.setRelation(searchApply.getRelation());
			oldsearchApply.setLawyertel(searchApply.getLawyertel());
			oldsearchApply.setLawyeremail(searchApply.getLawyeremail());
			searchApplyService.save(oldsearchApply);

			HttpServletRequest request1=request;
			MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request1;
			Map<String, MultipartFile> fileMap = mRequest.getFileMap();

			int i=1;
			for (Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet()	.iterator(); it.hasNext();) {
					Map.Entry<String, MultipartFile> entry = it.next();
					MultipartFile uploadfile = entry.getValue();
					String oldfilename =uploadfile.getOriginalFilename();
					String casesearchid = String.valueOf(searchApply.getSearchappid());
					String num = String.valueOf(i);
					String apptype = "104";
					i++;
					sendAttachmentForm(oldfilename,casesearchid,num,apptype,uploadfile,request,response);
			}
				
			model.addAttribute("applyType","sslc");
			model.addAttribute("searchApply",oldsearchApply);
				//model.addAttribute("OPRESULT", LawyerApply.message_save_lawyer_process_ok);
				//model.addAttribute("OPFLAG", LawyerApply.SEARCHAPPID );
				//model.addAttribute("OPFLAGID",lawyerApply.getId());
			return "modules/lawyer/pages/reload";
			
		}
		
		
	
	//诉讼业务查看
	@RequestMapping(value = { "wcmdocument/ssywview", "" })
	public String ssywForm(@RequestParam(value = "id", required = false) String id,HttpServletRequest request,HttpServletResponse response, Model model) {
		Lawyer lawyer = UserUtils.getLawyerUser();
		LawyerApply lawyerApply = lawyerApplyService.get(Long.parseLong(id));
		//获取附件
		LawAppendix appendix=new LawAppendix();
		appendix.setApptype("103");
		appendix.setSearchappid(lawyerApply.getId());
		Page<LawAppendix> lawAppendix = lawAppendixService.findByIdType(new Page<LawAppendix>(request, response), appendix);
		lawyerApply.setLawAppendixs(lawAppendix.getList());

		for(int i=0;i<lawAppendix.getList().size();i++){
			appendix=lawAppendix.getList().get(i);
			String temporaryAppendixPath = LawUtils.getTemporaryAppendixPath(
					appendix.getFilename(), lawyerApply.getCrtime());
			String appendixPath = LawUtils.getAppendixPath(
					appendix.getFilename(), lawyerApply.getCrtime());
			try {
				FileUtil.fileDecrypt(sKey, sIv, appendixPath,
						temporaryAppendixPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("lawyerUser", lawyer);
		model.addAttribute("lawyerApply", lawyerApply);
		return "modules/lawyer/pages/ssyw_view";
	}
	//诉讼业务修改进入
	@RequestMapping(value = { "wcmdocument/ssywedit", "" })
	public String ssywEdit(@RequestParam(value = "id", required = false) String id,HttpServletRequest request,HttpServletResponse response, Model model) {
		LawyerApply lawyerApply = lawyerApplyService.get(Long.parseLong(id));
		Lawyer lawyer = UserUtils.getLawyerUser();
		//获取附件
		LawAppendix appendix=new LawAppendix();
		appendix.setApptype("103");
		appendix.setSearchappid(lawyerApply.getId());
		Page<LawAppendix> lawAppendix = lawAppendixService.findByIdType(new Page<LawAppendix>(request, response), appendix);
		lawyerApply.setLawAppendixs(lawAppendix.getList());

		for(int i=0;i<lawAppendix.getList().size();i++){
			appendix=lawAppendix.getList().get(i);
			String temporaryAppendixPath = LawUtils.getTemporaryAppendixPath(
					appendix.getFilename(), lawyerApply.getCrtime());
			String appendixPath = LawUtils.getAppendixPath(
					appendix.getFilename(), lawyerApply.getCrtime());
			try {
				FileUtil.fileDecrypt(sKey, sIv, appendixPath,
						temporaryAppendixPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		List<String> list=JcyUtils.getJcyInfo(lawyerApply.getGroupId()+"");
		model.addAttribute("groupAdd", list.get(1));
		model.addAttribute("groupTel", list.get(2));
		model.addAttribute("groupTime", list.get(3));
		model.addAttribute("lawyerUser", lawyer);
		model.addAttribute("lawyerApply", lawyerApply);
		return "modules/lawyer/pages/ssyw_edit";
	}
	/**
	 * 律师诉讼业务  修改后提交
	 */
	@RequestMapping(value = "wcmdocument/ssyw/edit", method = RequestMethod.POST,headers = "Content-Type=multipart/form-data")
	public String ssywEdit(LawyerApply lawyerApply,HttpServletRequest request,HttpServletResponse response, Model model) {
			LawyerApply oldlawyerApply=lawyerApplyService.get(lawyerApply.getId());
			if((oldlawyerApply.getDealStatus()==10||oldlawyerApply.getDealStatus()==16)&&oldlawyerApply.getFeedbackStatus()<=0){
				
			}else{
				model.addAttribute("OPRESULT", LawyerApply.message_save_lawyer_apply_no_edit);
				model.addAttribute("applyType","error");
				//model.addAttribute("OPFLAG", LawyerApply.SEARCHAPPID );
				//model.addAttribute("OPFLAGID",lawyerApply.getId());
				return "modules/lawyer/pages/reload";
			}
			
			
			oldlawyerApply.setSuspectsName(lawyerApply.getSuspectsName());
			oldlawyerApply.setBrief(lawyerApply.getBrief());
			oldlawyerApply.setRelation(lawyerApply.getRelation());
			oldlawyerApply.setCaseType(lawyerApply.getCaseType());
			oldlawyerApply.setApplyMatterType(lawyerApply.getApplyMatterType());
			oldlawyerApply.setReservation(lawyerApply.getReservation());
			oldlawyerApply.setLawyerName(lawyerApply.getLawyerName());
			oldlawyerApply.setLawyerIdcode(lawyerApply.getLawyerIdcode());
			oldlawyerApply.setLawyerCardnum(lawyerApply.getLawyerCardnum());
			oldlawyerApply.setLawfirmName(lawyerApply.getLawfirmName());
			oldlawyerApply.setLawyerTel(lawyerApply.getLawyerTel());
			oldlawyerApply.setLawyerEmail(lawyerApply.getLawyerEmail());
		
			String orderDate=lawyerApply.getOrderDate().trim();
			if(orderDate.endsWith("或")){
				orderDate=orderDate.substring(0,orderDate.length()-2 );
			}
			oldlawyerApply.setOrderDate(orderDate);
			lawyerApplyService.save(oldlawyerApply);
			HttpServletRequest request1=request;
			MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request1;
			Map<String, MultipartFile> fileMap = mRequest.getFileMap();
			
			//删除原有图片数据
			//lawAppendixService.delete(oldlawyerApply.getId(), "103");
			
			int i=1;
			for (Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet()	.iterator(); it.hasNext();) {
					Map.Entry<String, MultipartFile> entry = it.next();
					MultipartFile uploadfile = entry.getValue();
					String oldfilename =uploadfile.getOriginalFilename();
					String casesearchid = String.valueOf(lawyerApply.getId());
					String num = String.valueOf(i);
					String apptype = "103";
					i++;
					sendAttachmentLawyerForm(oldfilename,casesearchid,num,apptype,uploadfile,request,response);
			}
			
			model.addAttribute("applyType","ssyw");
			model.addAttribute("lawyerApply",oldlawyerApply);
			//model.addAttribute("OPRESULT", LawyerApply.message_save_lawyer_process_ok);
			//model.addAttribute("OPFLAG", LawyerApply.SEARCHAPPID );
			//model.addAttribute("OPFLAGID",lawyerApply.getId());
			return "modules/lawyer/pages/reload";
		
	}
	/**
	 * 律师诉讼业务  取消
	 */
	@RequestMapping(value = "wcmdocument/ssyw/qxedit/{lawyerApplyId}", method = RequestMethod.GET)
	public String ssywQxEdit(@PathVariable("lawyerApplyId") String lawyerApplyId,HttpServletRequest request,HttpServletResponse response, Model model) {
			LawyerApply oldlawyerApply=lawyerApplyService.get(Long.parseLong(lawyerApplyId));
			int dealstatus = oldlawyerApply.getDealStatus();
			if(dealstatus == BaseEntity.APPLY_DEAL_STATUS_PUBLISH){//回复确认后取消
				oldlawyerApply.setFeedbackStatus(BaseEntity.APPLY_FEEDBACK_STATUS_LAW_QUEREN_CANCEL);
			}else if(dealstatus == BaseEntity.APPLY_DEAL_STATUS_NEW){//受理前取消
				oldlawyerApply.setFeedbackStatus(BaseEntity.APPLY_FEEDBACK_STATUS_LAW_CANCEL);
			}else if(dealstatus == BaseEntity.APPLY_DEAL_STATUS_SIGN || dealstatus == BaseEntity.APPLY_DEAL_STATUS_REMARK){//受理后发布前取消
				oldlawyerApply.setFeedbackStatus(BaseEntity.APPLY_FEEDBACK_STATUS_LAW_SHOULI_CANCEL);
			}
			lawyerApplyService.save(oldlawyerApply);
			
			return "redirect:/l/lawyer/wcmdocument/ajax/ssyw_list";
	}
	
	/**
	 * 律师诉讼业务  是否按时
	 */
	@RequestMapping(value = "wcmdocument/ssyw/ontimeedit",method = RequestMethod.POST)
	public String ssywOntimeEdit(LawyerApply lawyerApply,HttpServletRequest request,HttpServletResponse response, Model model) {
			LawyerApply oldlawyerApply=lawyerApplyService.get(lawyerApply.getId());
			if(0==lawyerApply.getIsOntime()){
				oldlawyerApply.setIsOntime(lawyerApply.getIsOntime());
				oldlawyerApply.setFeedbackStatus(BaseEntity.APPLY_FEEDBACK_STATUS_LAW_NOONTIME_CANCEL);
				oldlawyerApply.setNotontimeReason(lawyerApply.getNotontimeReason());
			}else if(1==lawyerApply.getIsOntime()){
				oldlawyerApply.setIsOntime(lawyerApply.getIsOntime());
				oldlawyerApply.setFeedbackStatus(BaseEntity.APPLY_FEEDBACK_STATUS_VERIFY);
			}
			lawyerApplyService.save(oldlawyerApply);
			
			return "redirect:/l/lawyer/wcmdocument/ajax/ssyw_list";

		
	}
	
	
	@RequestMapping(value = { "wcmdocument/sslc_dyview", "" })
	public String sslcDyView(@RequestParam(value = "id", required = false) String id,HttpServletRequest request,HttpServletResponse response, Model model) {
		SearchApply searchApply = searchApplyService.get(Long.parseLong(id));
		model.addAttribute("searchApply", searchApply);
		return "modules/lawyer/pages/sslc_dyview";
	}
	@RequestMapping(value = { "wcmdocument/ssyw_dyview", "" })
	public String ssywDyView(@RequestParam(value = "id", required = false) String id,HttpServletRequest request,HttpServletResponse response, Model model) {
		LawyerApply lawyerApply = lawyerApplyService.get(Long.parseLong(id));
		List<String> list=JcyUtils.getJcyInfo(lawyerApply.getGroupId()+"");
		model.addAttribute("lawyerApply", lawyerApply);
		model.addAttribute("groupName", list.get(0));
		model.addAttribute("groupAdd", list.get(1));
		model.addAttribute("groupTel", list.get(2));
		model.addAttribute("groupTime", list.get(3));
		return "modules/lawyer/pages/ssyw_dyview";
	}
	
	@RequestMapping(value = "wcmdocument/getLawyerAppendixFile/{appendixid}", method = RequestMethod.GET)
	public void getLawyerFile(@PathVariable("appendixid") String appendixid,
			HttpServletResponse response) {
		LawAppendix appendix = null;
		try {
			long id = NumberUtils.toLong(appendixid);
			appendix = lawAppendixService.get(id);
			
			LawyerApply lawyerApply = lawyerApplyService.get(appendix.getSearchappid());
			
			String temporaryAppendixPath = LawUtils.getTemporaryAppendixPath(
					appendix.getFilename(), lawyerApply.getCrtime());
		
			File file = new File(temporaryAppendixPath);
			BufferedImage image = ImageIO.read(file);
			BufferedImage thumbnail = Scalr.resize(image, Scalr.Method.SPEED,
					300);

			// copy it to response's OutputStream
			OutputStream out = response.getOutputStream();
			ImageIO.write(thumbnail, "jpg", out);
			// get your file as InputStream
			//InputStream is = new FileInputStream(file);
			// copy it to response's OutputStream
			//IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();
			file.delete();
		} catch (IOException ex) {
			
			throw new RuntimeException("IOError writing file to output stream");
		}
	}
	
	@RequestMapping(value = "wcmdocument/getSearchAppendixFile/{appendixid}", method = RequestMethod.GET)
	public void getSearchFile(@PathVariable("appendixid") String appendixid,
			HttpServletResponse response) {
		LawAppendix appendix = null;
		try {
			long id = NumberUtils.toLong(appendixid);
			appendix = lawAppendixService.get(id);
			
			SearchApply searchApply = searchApplyService.get(appendix.getSearchappid());
			
			String temporaryAppendixPath = LawUtils.getTemporaryAppendixPath(
					appendix.getFilename(), searchApply.getCrtime());
			
			File file = new File(temporaryAppendixPath);
			BufferedImage image = ImageIO.read(file);
			BufferedImage thumbnail = Scalr.resize(image, Scalr.Method.SPEED,
					300);

			// copy it to response's OutputStream
			OutputStream out = response.getOutputStream();
			ImageIO.write(thumbnail, "jpg", out);
			// get your file as InputStream
			//InputStream is = new FileInputStream(file);
			// copy it to response's OutputStream
			//IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();
			file.delete();
		} catch (IOException ex) {
			
			throw new RuntimeException("IOError writing file to output stream");
		}
	}


}
