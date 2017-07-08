/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.scxj.portal.common.config.Global;
import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.common.service.BaseService;
import com.wondersgroup.scxj.portal.common.utils.DateUtils;
import com.wondersgroup.scxj.portal.common.utils.StringUtils;
import com.wondersgroup.scxj.portal.modules.law.dao.SearchApplyDao;
import com.wondersgroup.scxj.portal.modules.law.entity.AppOperateLogs;
import com.wondersgroup.scxj.portal.modules.law.entity.MessageLogs;
import com.wondersgroup.scxj.portal.modules.law.entity.SearchApply;
import com.wondersgroup.scxj.portal.modules.law.utils.LawUtils;

/**
 * 诉讼流程Service
 * 
 * @author LiRiChen
 * @version 2014-03-30
 */
@Component
@Transactional(readOnly = true)
public class SearchApplyService extends BaseService {

	@Autowired
	private SearchApplyDao searchApplyDao;

	@Autowired
	private MessageLogsService messageLogsService;

	@Autowired
	private AppOperateLogsService appOperateLogsService;

	public SearchApply get(Long id) {
		return searchApplyDao.findOne(id);
	}

	public Page<SearchApply> find(Page<SearchApply> page,
			SearchApply searchApply) {
		DetachedCriteria dc = searchApplyDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(searchApply.getSuspectsname())) {
			dc.add(Restrictions.like("suspectsname",
					"%" + searchApply.getSuspectsname() + "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getSearchcode())) {
			dc.add(Restrictions.like("searchcode",
					"%" + searchApply.getSearchcode() + "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getBrief())) {
			dc.add(Restrictions.like("brief", "%" + searchApply.getBrief()
					+ "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getLawyercardnum())) {
			dc.add(Restrictions.like("lawyercardnum",
					"%" + searchApply.getLawyercardnum() + "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getSearchpass())) {
			dc.add(Restrictions.like("searchpass",
					"%" + searchApply.getSearchpass() + "%"));
		}
		dc.addOrder(Order.desc("crtime"));
		return searchApplyDao.find(page, dc);
	}

	public Page<SearchApply> find(Page<SearchApply> page,
			SearchApply searchApply, String pageNo) {
		DetachedCriteria dc = searchApplyDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(searchApply.getSuspectsname())) {
			dc.add(Restrictions.like("suspectsname",
					"%" + searchApply.getSuspectsname() + "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getSearchcode())) {
			dc.add(Restrictions.like("searchcode",
					"%" + searchApply.getSearchcode() + "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getBrief())) {
			dc.add(Restrictions.like("brief", "%" + searchApply.getBrief()
					+ "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getLawyercardnum())) {
			dc.add(Restrictions.eq("lawyercardnum",
					searchApply.getLawyercardnum()));
		}
		if (StringUtils.isNotEmpty(searchApply.getSearchpass())) {
			dc.add(Restrictions.like("searchpass",
					"%" + searchApply.getSearchpass() + "%"));
		}
		page.setPageNo(Integer.parseInt(pageNo));
		page.setPageSize(Integer.parseInt(Global.getPageSize()));
		dc.addOrder(Order.desc("crtime"));
		return searchApplyDao.find(page, dc);
	}
	/**
	 * 律师web诉讼流程查询
	 * @param page 
	 * @param searchApply 参数
	 * @param pageNo 页数
	 * @param pageSize 行数
	 * @return
	 */
	public Page<SearchApply> find(Page<SearchApply> page,
			SearchApply searchApply, String pageNo,String pageSize,String StartDate,String EndDate) {
		DetachedCriteria dc = searchApplyDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(searchApply.getLawyercardnum())) {
			dc.add(Restrictions.eq("lawyercardnum",
					searchApply.getLawyercardnum()));
		}
		if (StringUtils.isNotEmpty(searchApply.getSearchpass())) {
			dc.add(Restrictions.like("searchpass",
					"%" + searchApply.getSearchpass() + "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getSuspectsname())) {
			dc.add(Restrictions.like("suspectsname",
					"%" + searchApply.getSuspectsname() + "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getSearchcode())) {
			dc.add(Restrictions.like("searchcode",
					"%" + searchApply.getSearchcode() + "%"));
		}
		if (searchApply.getApplyway()!=null) {
			dc.add(Restrictions.eq("applyway", searchApply.getApplyway()));
		}
		if (searchApply.getGroupid()!=null) {
			dc.add(Restrictions.eq("groupid",searchApply.getGroupid()));
		}
		if (searchApply.getDealstatus()!=null) {
			dc.add(Restrictions.eq("dealstatus", searchApply.getDealstatus()));
		}
		if (StringUtils.isNotEmpty(StartDate)) {
			Date date1 = DateUtils.parseDate(StartDate+" 00:00:00");
			dc.add(Restrictions.ge("crtime", date1));
		}
		if (StringUtils.isNotEmpty(EndDate)) {
			Date date2 = DateUtils.parseDate(EndDate+" 23:59:59");
			dc.add(Restrictions.le("crtime", date2));
		}
		if (StringUtils.isEmpty(pageNo)) {
			pageNo="1";
		}
		page.setPageNo(Integer.parseInt(pageNo));
		page.setPageSize(Integer.parseInt(pageSize));
		dc.addOrder(Order.desc("crtime"));
		return searchApplyDao.find(page, dc);
	}

	public Page<SearchApply> find(Page<SearchApply> page, String lastUpdateDate) {
		DetachedCriteria dc = searchApplyDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(lastUpdateDate)) {
			Date lastDate = DateUtils.parseDate(lastUpdateDate);
			dc.add(Restrictions.ge("crtime", lastDate));
		}
		dc.addOrder(Order.desc("crtime"));
		return searchApplyDao.find(page, dc);
	}

	public Page<SearchApply> findFaults(Page<SearchApply> page,
			SearchApply searchApply) {
		DetachedCriteria dc = searchApplyDao.createDetachedCriteria();
		dc.add(Restrictions.eq("dealstatus", 17));
		if (StringUtils.isNotEmpty(searchApply.getSuspectsname())) {
			dc.add(Restrictions.like("suspectsname",
					"%" + searchApply.getSuspectsname() + "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getSearchcode())) {
			dc.add(Restrictions.like("searchcode",
					"%" + searchApply.getSearchcode() + "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getBrief())) {
			dc.add(Restrictions.like("brief", "%" + searchApply.getBrief()
					+ "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getLawyercardnum())) {
			dc.add(Restrictions.eq("lawyercardnum",
					searchApply.getLawyercardnum()));
		}
		if (StringUtils.isNotEmpty(searchApply.getSearchpass())) {
			dc.add(Restrictions.like("searchpass",
					"%" + searchApply.getSearchpass() + "%"));
		}
		dc.addOrder(Order.desc("crtime"));
		return searchApplyDao.find(page, dc);
	}

	public Page<SearchApply> findNoFault(Page<SearchApply> page,
			SearchApply searchApply, String pageNo) {
		DetachedCriteria dc = searchApplyDao.createDetachedCriteria();
		dc.add(Restrictions.ne("dealstatus",
				SearchApply.SEARCHAPPLY_DEAL_STATUS_DATA_FAULT));
		if (StringUtils.isNotEmpty(searchApply.getSuspectsname())) {
			dc.add(Restrictions.like("suspectsname",
					"%" + searchApply.getSuspectsname() + "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getSearchcode())) {
			dc.add(Restrictions.like("searchcode",
					"%" + searchApply.getSearchcode() + "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getBrief())) {
			dc.add(Restrictions.like("brief", "%" + searchApply.getBrief()
					+ "%"));
		}
		if (StringUtils.isNotEmpty(searchApply.getLawyercardnum())) {
			dc.add(Restrictions.eq("lawyercardnum",
					searchApply.getLawyercardnum()));
		}
		if (StringUtils.isNotEmpty(searchApply.getSearchpass())) {
			dc.add(Restrictions.like("searchpass",
					"%" + searchApply.getSearchpass() + "%"));
		}
		page.setPageNo(Integer.parseInt(pageNo));
		page.setPageSize(Integer.parseInt(Global.getPageSize()));
		dc.addOrder(Order.desc("crtime"));
		return searchApplyDao.find(page, dc);
	}
	
	//add by ycl 根据嫌疑人姓名、案由、律师执业证号、承办单位这4个字段来判断是否是重复提交
	public Page<SearchApply> findRepeat(Page<SearchApply> page,
			SearchApply searchApply) {
		DetachedCriteria dc = searchApplyDao.createDetachedCriteria();
		dc.add(Restrictions.eq("dealstatus", SearchApply.SEARCHAPPLY_DEAL_STATUS_NEW));
		if (StringUtils.isNotEmpty(searchApply.getSuspectsname())) {
			dc.add(Restrictions.eq("suspectsname", searchApply.getSuspectsname()));
		}
		if (StringUtils.isNotEmpty(searchApply.getBrief())) {
			dc.add(Restrictions.eq("brief", searchApply.getBrief()));
		}
		if (StringUtils.isNotEmpty(searchApply.getLawyercardnum())) {
			dc.add(Restrictions.eq("lawyercardnum",searchApply.getLawyercardnum()));
		}
		if (searchApply.getGroupid() != null) {
			dc.add(Restrictions.eq("groupid", searchApply.getGroupid()));
		}
		
		dc.addOrder(Order.desc("crtime"));
		return searchApplyDao.find(page, dc);
	}

	@Transactional(readOnly = false)
	public void save(SearchApply searchApply) {
		if (searchApply.getSearchappid() == null) {
			searchApply.setDealstatus(SearchApply.SEARCHAPPLY_DEAL_STATUS_NEW);
			searchApply.setSearchcode(buildSearchCode());
			searchApply.setCrtime(new Date());
			// searchApply.setSearchpass(buildSearchPass());
			// searchApply.setCruser("admin");
			// searchApply.setApplyId(2);
		}
		searchApplyDao.save(searchApply);
		if (searchApply.getDealstatus() == SearchApply.SEARCHAPPLY_DEAL_STATUS_NEW
		// && searchApply.getFeedbackstatus() < 0
		) {
			//sendMessageToOperUser(searchApply, 5);
			appOperateLogsService.save(createAppOperateLogs(searchApply, 5));
			// } else if (searchApply.getDealstatus() ==
			// SearchApply.APPLY_DEAL_STATUS_PUBLISH
			// // && searchApply.getFeedbackStatus() ==
			// // LawyerApply.APPLY_FEEDBACK_STATUS_VERIFY
			// ) {
			// messageLogsService
			// .save(createMessageLogs(searchApply,
			// searchApply.getLawyername(),
			// searchApply.getLawyertel(), 2));
			// appOperateLogsService.save(createAppOperateLogs(searchApply, 2));
		} else if (searchApply.getDealstatus() == SearchApply.SEARCHAPPLY_DEAL_STATUS_DATA_FULL) {
			// && lawyerApply.getFeedbackStatus() ==
			// LawyerApply.APPLY_FEEDBACK_STATUS_LAW_NOONTIME_CANCEL
			//sendMessageToOperUser(searchApply, 6);
			appOperateLogsService.save(createAppOperateLogs(searchApply, 6));
		} else if (searchApply.getDealstatus() == SearchApply.SEARCHAPPLY_DEAL_STATUS_CANCEL) {
			//sendMessageToOperUser(searchApply, 7);
			appOperateLogsService.save(createAppOperateLogs(searchApply, 7));
		}
		searchApplyDao.save(searchApply);
	}

	// private String buildSearchPass() {
	// Random r = new Random();
	// return r.nextInt(90000000)+10000000+"";
	// }

	public String buildSearchCode() {
		String appealCode = "";
		Calendar now = Calendar.getInstance();
		Date aDate = now.getTime();
		DateFormat aFormat = new SimpleDateFormat("yyyyMMddSSS");
		appealCode = aFormat.format(aDate);
		return appealCode.substring(2);
	}

	private void sendMessageToOperUser(SearchApply searchApply, int type) {
		List<Object> list = searchApplyDao.getGroupUsers(searchApply
				.getGroupid());
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
			messageLogsService.save(createMessageLogs(searchApply, username,
					mobile, type));
		}
	}

	private MessageLogs createMessageLogs(SearchApply searchApply,
			String userName, String mobile, int type) {
		MessageLogs logs = new MessageLogs();
		logs.setAppid(searchApply.getSearchappid());
		logs.setApptype(103L);
		// logs.setMessageid(msgResult);
		logs.setMessagetype("1");
		logs.setResusername(userName);
		logs.setResuserphone(mobile);
		logs.setResusertype(1L); // 接收人类型：1，工作人员
		logs.setBeizhu1(LawUtils.getMessage(searchApply, type));
		logs.setResult("success");
		logs.setCruser("admin");
		logs.setCrtime(new Date());
		logs.setDealstatus(0L);
		return logs;
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		searchApplyDao.deleteById(id);
	}

	private AppOperateLogs createAppOperateLogs(SearchApply searchApply,
			int type) {
		AppOperateLogs logs = new AppOperateLogs();
		logs.setAppid("103");
		logs.setSearchcode(searchApply.getSearchcode());
		logs.setSourcedeptid(searchApply.getGroupid());
		logs.setUserid(3L);
		logs.setOperatetime(new Date());
		if (type == 5) {
			logs.setOperatetype(0L);
			logs.setEditreson("新稿");
		} else {
			// long operType = Long.parseLong(String.valueOf(searchApply
			// .getFeedbackStatus()));
			// logs.setOperatetype(operType);
			// logs.setEditreson(searchApply.getNotontimereason());
		}
		logs.setCruser("admin");
		logs.setLettleusername(searchApply.getLawyername());
		logs.setCrtime(new Date());
		return logs;
	}

}
