/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.service;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.common.service.BaseService;
import com.wondersgroup.scxj.portal.common.utils.StringUtils;
import com.wondersgroup.scxj.portal.modules.law.entity.MessageLogs;
import com.wondersgroup.scxj.portal.modules.law.dao.MessageLogsDao;

/**
 * 律师基本信息Service
 * 
 * @author LiRiChen
 * @version 2014-01-20
 */
@Component
@Transactional(readOnly = true)
public class MessageLogsService extends BaseService {

	@Autowired
	private MessageLogsDao messageLogsDao;

	@Autowired
	private SmsService smsService;

	public MessageLogs get(Long id) {
		return messageLogsDao.findOne(id);
	}

	public Page<MessageLogs> find(Page<MessageLogs> page,
			MessageLogs messageLogs) {
		DetachedCriteria dc = messageLogsDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(messageLogs.getMessagetype())) {
			dc.add(Restrictions.like("name", "%" + messageLogs.getMessagetype()
					+ "%"));
		}
		dc.addOrder(Order.desc("id"));
		return messageLogsDao.find(page, dc);
	}

	public Page<MessageLogs> findUpDate(Page<MessageLogs> page, Long appid) {
		DetachedCriteria dc = messageLogsDao.createDetachedCriteria();
		dc.add(Restrictions.eq("apptype", 104L));
		dc.add(Restrictions.eq("appid", appid));
		dc.add(Restrictions.isNotNull("beizhu2"));
		dc.addOrder(Order.desc("crtime"));
		return messageLogsDao.find(page, dc);
	}

	@Transactional(readOnly = false)
	public void save(MessageLogs messageLogs) {
		String messageid = smsService.send(messageLogs.getResuserphone(),
				messageLogs.getBeizhu1());
		messageLogs.setMessageid(messageid);
		logger.debug("send sms message " + messageid + "to"
				+ messageLogs.getResuserphone() + " "
				+ messageLogs.getBeizhu1());
		messageLogsDao.save(messageLogs);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		messageLogsDao.deleteById(id);
	}

}
