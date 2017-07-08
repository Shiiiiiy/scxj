/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.common.service.BaseService;
import com.wondersgroup.scxj.portal.common.utils.DateUtils;
import com.wondersgroup.scxj.portal.common.utils.StringUtils;
import com.wondersgroup.scxj.portal.modules.law.dao.LawyerApplyDao;
import com.wondersgroup.scxj.portal.modules.law.entity.AppOperateLogs;
import com.wondersgroup.scxj.portal.modules.law.entity.Lawyer;
import com.wondersgroup.scxj.portal.modules.law.entity.LawyerApply;
import com.wondersgroup.scxj.portal.modules.law.entity.MessageLogs;
import com.wondersgroup.scxj.portal.modules.law.entity.SearchApply;
import com.wondersgroup.scxj.portal.modules.law.utils.LawUtils;
import com.wondersgroup.scxj.portal.modules.sys.utils.UserUtils;

/**
 * 诉讼业务办理Service
 * 
 * @author LiRiChen
 * @version 2014-01-13
 */
@Component
@Transactional(readOnly = true)
public class LawyerApplyService extends BaseService {

	@Autowired
	private LawyerApplyDao lawyerApplyDao;

	@Autowired
	private MessageLogsService messageLogsService;

	@Autowired
	private AppOperateLogsService appOperateLogsService;

	public LawyerApply get(Long id) {
		DetachedCriteria dc = lawyerApplyDao.createDetachedCriteria();
		dc.add(Restrictions.eq("id", id));
		List<LawyerApply> list = lawyerApplyDao.find(dc);
		if (list != null && list.size() == 1) {
			return list.get(0);
		} else {
			return new LawyerApply();
		}
	}

	public Page<LawyerApply> find(Page<LawyerApply> page,
			LawyerApply lawyerApply) {
		Lawyer lawyer = UserUtils.getLawyerUser();
		DetachedCriteria dc = lawyerApplyDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(lawyerApply.getSuspectsName())) {
			dc.add(Restrictions.like("suspectsName",
					"%" + lawyerApply.getSuspectsName() + "%"));
		}
		if (StringUtils.isNotEmpty(lawyerApply.getBrief())) {
			dc.add(Restrictions.like("brief", "%" + lawyerApply.getBrief()
					+ "%"));
		}
		if (StringUtils.isNotEmpty(lawyerApply.getSearchCode())) {
			dc.add(Restrictions.like("searchCode",
					"%" + lawyerApply.getSearchCode() + "%"));
		}
		if (lawyerApply.getDealStatus() > 0) {
			dc.add(Restrictions.eq("dealStatus",
					lawyerApply.getDealStatus()));
		}
		if (lawyerApply.getDealStatus() > 0) {
			dc.add(Restrictions.eq("feedbackStatus",
					lawyerApply.getFeedbackStatus()));
		}
		dc.add(Restrictions.eq("lawyerCardnum", lawyer.getLisensenumber()));
		dc.add(Restrictions.eq(LawyerApply.LAWYER_DEL_FLAG,
				LawyerApply.LAWYER_DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return lawyerApplyDao.find(page, dc);
	}
	/**
	 * 律师web诉讼业务查询
	 * @param page 
	 * @param searchApply 参数
	 * @param pageNo 页数
	 * @param pageSize 行数
	 * @return
	 */
	public Page<LawyerApply> find(Page<LawyerApply> page,
			LawyerApply lawyerApply, String pageNo,String pageSize,String StartDate,String EndDate,
			Integer dealStatus,Integer isMiss,Integer feedStatus) {
		DetachedCriteria dc = lawyerApplyDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(lawyerApply.getLawyerCardnum())) {
			dc.add(Restrictions.eq("lawyerCardnum",lawyerApply.getLawyerCardnum()));
		}
		if (StringUtils.isNotEmpty(lawyerApply.getSuspectsName())) {
			dc.add(Restrictions.like("suspectsName",
					"%" + lawyerApply.getSuspectsName() + "%"));
		}
		if (StringUtils.isNotEmpty(lawyerApply.getCaseType())) {
			dc.add(Restrictions.like("caseType",
					"%" + lawyerApply.getCaseType() + "%"));
		}
		if (StringUtils.isNotEmpty(lawyerApply.getSearchCode())) {
			dc.add(Restrictions.like("searchCode",
					"%" + lawyerApply.getSearchCode() + "%"));
		}
		if (lawyerApply.getGroupId()!=null) {
			dc.add(Restrictions.eq("groupId",lawyerApply.getGroupId()));
		}
		
		/*if (lawyerApply.getDealStatus()!=null) {
			dc.add(Restrictions.eq("dealStatus",lawyerApply.getDealStatus()));
		}*/
		
		if (StringUtils.isNotEmpty(StartDate)) {
			Date date1 = DateUtils.parseDate(StartDate+" 00:00:00");
			dc.add(Restrictions.ge("crtime", date1));
		}
		if (StringUtils.isNotEmpty(EndDate)) {
			Date date2 = DateUtils.parseDate(EndDate+" 23:59:59");
			dc.add(Restrictions.le("crtime", date2));
		}
		if (dealStatus!=null) {
			if(dealStatus==101112){
				dc.add(Restrictions.or(Restrictions.eq("dealStatus", 10),Restrictions.eq("dealStatus", 11),Restrictions.eq("dealStatus", 12)));
			}else{
				dc.add(Restrictions.eq("dealStatus", dealStatus));
			}
		}
		if (isMiss!=null) {
			if(isMiss==-1){
				dc.add(Restrictions.lt("ismiss", 0));
			}else{
				dc.add(Restrictions.eq("ismiss",isMiss));
			}
		}
		if (feedStatus!=null) {
			if(feedStatus==313435){
				dc.add(Restrictions.or(Restrictions.eq("feedbackStatus", 30),Restrictions.eq("feedbackStatus", 31),Restrictions.eq("feedbackStatus", 34),Restrictions.eq("feedbackStatus", 35),Restrictions.eq("feedbackStatus", 40)));
			}else if(feedStatus==-1){
				dc.add(Restrictions.lt("feedbackStatus", 0));
			}else{
				dc.add(Restrictions.eq("dealStatus",feedStatus));
			}
		}
		dc.add(Restrictions.eq(LawyerApply.LAWYER_DEL_FLAG,
				LawyerApply.LAWYER_DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("crtime"));
		if (StringUtils.isEmpty(pageNo)) {
			pageNo="1";
		}
		page.setPageNo(Integer.parseInt(pageNo));
		page.setPageSize(Integer.parseInt(pageSize));

		return lawyerApplyDao.find(page, dc);

	}
	
	public List<LawyerApply> find(
			LawyerApply lawyerApply) {
		DetachedCriteria dc = lawyerApplyDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(lawyerApply.getSuspectsName())) {
			dc.add(Restrictions.like("suspectsName",
					"%" + lawyerApply.getSuspectsName() + "%"));
		}
		if (StringUtils.isNotEmpty(lawyerApply.getBrief())) {
			dc.add(Restrictions.like("brief", "%" + lawyerApply.getBrief()
					+ "%"));
		}
		if (StringUtils.isNotEmpty(lawyerApply.getSearchCode())) {
			dc.add(Restrictions.like("searchCode",
					"%" + lawyerApply.getSearchCode() + "%"));
		}
		if (lawyerApply.getDealStatus() > 0) {
			dc.add(Restrictions.eq("dealStatus",
					lawyerApply.getDealStatus()));
		}
		if (lawyerApply.getDealStatus() > 0) {
			dc.add(Restrictions.eq("feedbackStatus",
					lawyerApply.getFeedbackStatus()));
		}
		dc.add(Restrictions.eq("lawyerCardnum", lawyerApply.getLawyerCardnum()));
		dc.add(Restrictions.eq(LawyerApply.LAWYER_DEL_FLAG,
				LawyerApply.LAWYER_DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return lawyerApplyDao.find(dc);
	}
	////add by ycl 增补齐材料的操作界面后的查询
	public List<LawyerApply> findAppendix(LawyerApply lawyerApply) {
		DetachedCriteria dc = lawyerApplyDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(lawyerApply.getSuspectsName())) {
			dc.add(Restrictions.like("suspectsName",
					"%" + lawyerApply.getSuspectsName() + "%"));
		}
		if (StringUtils.isNotEmpty(lawyerApply.getBrief())) {
			dc.add(Restrictions.like("brief", "%" + lawyerApply.getBrief()
					+ "%"));
		}
		if (StringUtils.isNotEmpty(lawyerApply.getSearchCode())) {
			dc.add(Restrictions.like("searchCode",
					"%" + lawyerApply.getSearchCode() + "%"));
		}
		if (lawyerApply.getDealStatus() > 0) {
			List statuslist=new ArrayList();
			statuslist.add(lawyerApply.getDealStatus());
			statuslist.add(LawyerApply.APPLY_DEAL_STATUS_DATA_FULL);
			dc.add(Restrictions.in("dealStatus", statuslist));
		}
		if (lawyerApply.getDealStatus() > 0) {
			dc.add(Restrictions.eq("feedbackStatus",
					lawyerApply.getFeedbackStatus()));
		}
		dc.add(Restrictions.eq("lawyerCardnum", lawyerApply.getLawyerCardnum()));
		dc.add(Restrictions.eq(LawyerApply.LAWYER_DEL_FLAG,
				LawyerApply.LAWYER_DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return lawyerApplyDao.find(dc);
	}
	//add by ycl 根据嫌疑人姓名、诉讼阶段、案由、律师执业证号、承办单位这5个字段来判断是否是重复提交
	public List<LawyerApply> findRepeat(LawyerApply lawyerApply) {
		DetachedCriteria dc = lawyerApplyDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(lawyerApply.getSuspectsName())) {
			dc.add(Restrictions.eq("suspectsName", lawyerApply.getSuspectsName()));
		}
		if (StringUtils.isNotEmpty(lawyerApply.getCaseType())) {
			dc.add(Restrictions.eq("caseType", lawyerApply.getCaseType()));
		}
		if (StringUtils.isNotEmpty(lawyerApply.getBrief())) {
			dc.add(Restrictions.eq("brief", lawyerApply.getBrief()));
		}
		if (StringUtils.isNotEmpty(lawyerApply.getLawyerCardnum())) {
			dc.add(Restrictions.eq("lawyerCardnum", lawyerApply.getLawyerCardnum()));
		}
		if (lawyerApply.getGroupId() != null) {
			dc.add(Restrictions.eq("groupId", lawyerApply.getGroupId()));
		}
		
		dc.add(Restrictions.eq("dealStatus", LawyerApply.APPLY_DEAL_STATUS_NEW));
		dc.add(Restrictions.eq(LawyerApply.LAWYER_DEL_FLAG,LawyerApply.LAWYER_DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return lawyerApplyDao.find(dc);
	}

	@Transactional(readOnly = false)
	public void save(LawyerApply lawyerApply) {
		if (lawyerApply.getId() == null) {
			lawyerApply.setDealStatus(LawyerApply.APPLY_DEAL_STATUS_NEW);
			lawyerApply.setSearchCode(buildSearchCode());
			lawyerApply.setCrtime(new Date());
			lawyerApply.setCruser("admin");
			if(lawyerApply.getApplyId()==null){
				lawyerApply.setApplyId(2);
			}
		}
		lawyerApplyDao.save(lawyerApply);
		if (lawyerApply.getDealStatus() == LawyerApply.APPLY_DEAL_STATUS_NEW
				&& lawyerApply.getFeedbackStatus() < 0) {
			//sendMessageToOperUser(lawyerApply, 0);
			appOperateLogsService.save(createAppOperateLogs(lawyerApply, 0));
		} else if (lawyerApply.getDealStatus() == LawyerApply.APPLY_DEAL_STATUS_PUBLISH
				&& lawyerApply.getFeedbackStatus() == LawyerApply.APPLY_FEEDBACK_STATUS_VERIFY) {
			/*messageLogsService
					.save(createMessageLogs(lawyerApply,
							lawyerApply.getLawyerName(),
							lawyerApply.getLawyerTel(), 2));*/
			appOperateLogsService.save(createAppOperateLogs(lawyerApply, 2));
		} else if (lawyerApply.getDealStatus() == LawyerApply.APPLY_DEAL_STATUS_PUBLISH
				&& lawyerApply.getFeedbackStatus() == LawyerApply.APPLY_FEEDBACK_STATUS_LAW_NOONTIME_CANCEL) {
			//sendMessageToOperUser(lawyerApply, 3);
			appOperateLogsService.save(createAppOperateLogs(lawyerApply, 3));
		}else if (lawyerApply.getDealStatus() == LawyerApply.APPLY_DEAL_STATUS_DATA_FULL) {
			//add by ycl 补齐材料的操作界面，提交成功后，增短信【补齐材料——工作人员】
			//sendMessageToOperUser(lawyerApply, 6);
			appOperateLogsService.save(createAppOperateLogs(lawyerApply, 6));
		} else if ((lawyerApply.getDealStatus() == LawyerApply.APPLY_DEAL_STATUS_NEW && lawyerApply
				.getFeedbackStatus() == LawyerApply.APPLY_FEEDBACK_STATUS_LAW_CANCEL)
				|| (lawyerApply.getDealStatus() == LawyerApply.APPLY_DEAL_STATUS_SIGN && lawyerApply
						.getFeedbackStatus() == LawyerApply.APPLY_FEEDBACK_STATUS_LAW_SHOULI_CANCEL)
				|| (lawyerApply.getDealStatus() == LawyerApply.APPLY_DEAL_STATUS_REMARK && lawyerApply
						.getFeedbackStatus() == LawyerApply.APPLY_FEEDBACK_STATUS_LAW_SHOULI_CANCEL)
				|| (lawyerApply.getDealStatus() == LawyerApply.APPLY_DEAL_STATUS_PUBLISH && lawyerApply
						.getFeedbackStatus() == LawyerApply.APPLY_FEEDBACK_STATUS_LAW_QUEREN_CANCEL)) {
			//sendMessageToOperUser(lawyerApply, 4);
			appOperateLogsService.save(createAppOperateLogs(lawyerApply, 4));
		}
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		lawyerApplyDao.deleteById(id);
	}

	private void sendMessageToOperUser(LawyerApply lawyerApply, int type) {
		List<Object> list = lawyerApplyDao.getGroupUsers(lawyerApply
				.getGroupId());
		for (Object obj : list) {
			Object[] users = (Object[]) obj;
			String username = "";
			if (users != null && users[0] != null) {
				username = users[0].toString();
			}
			String mobile = "";
			if (users != null && users[1] != null) {
				mobile = users[1].toString();
			}
			messageLogsService.save(createMessageLogs(lawyerApply, username,
					mobile, type));
		}
	}

	private AppOperateLogs createAppOperateLogs(LawyerApply lawyerApply,
			int type) {
		AppOperateLogs logs = new AppOperateLogs();
		logs.setAppid("103");
		logs.setSearchcode(lawyerApply.getSearchCode());
		logs.setSourcedeptid(lawyerApply.getGroupId());
		logs.setUserid(3L);
		logs.setOperatetime(new Date());
		if (type == 0) {
			logs.setOperatetype(0L);
			logs.setEditreson("新稿");
		} else {
			long operType = Long.parseLong(String.valueOf(lawyerApply
					.getFeedbackStatus()));
			logs.setOperatetype(operType);
			logs.setEditreson(lawyerApply.getNotontimeReason());
		}
		logs.setCruser("admin");
		logs.setLettleusername(lawyerApply.getLawyerName());
		logs.setCrtime(new Date());
		return logs;
	}

	private MessageLogs createMessageLogs(LawyerApply lawyerApply,
			String userName, String mobile, int type) {
		MessageLogs logs = new MessageLogs();
		logs.setAppid(lawyerApply.getId());
		logs.setApptype(103L);
		// logs.setMessageid(msgResult);
		logs.setMessagetype("1");
		logs.setResusername(userName);
		logs.setResuserphone(mobile);
		logs.setResusertype(1L); // 接收人类型：1，工作人员
		logs.setBeizhu1(LawUtils.getMessage(lawyerApply, type));
		logs.setResult("success");
		logs.setCruser("admin");
		logs.setCrtime(new Date());
		logs.setDealstatus(0L);
		return logs;
	}

	public String buildSearchCode() {
		String appealCode = "";
		Calendar now = Calendar.getInstance();
		Date aDate = now.getTime();
		DateFormat aFormat = new SimpleDateFormat("yyyyMMddHHmmSSS");
		appealCode = aFormat.format(aDate);
		return appealCode;
	}

}
