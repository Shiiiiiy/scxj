/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.service;

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

import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.common.service.BaseService;
import com.wondersgroup.scxj.portal.common.utils.StringUtils;
import com.wondersgroup.scxj.portal.modules.law.dao.BlackListDao;
import com.wondersgroup.scxj.portal.modules.law.entity.BlackList;

/**
 * 假日信息Service
 * @author Ycl
 * @version 2015-08-18
 */
@Component
@Transactional(readOnly = true)
public class BlackListService extends BaseService {

	@Autowired
	private BlackListDao blackListDao;
	
	public BlackList get(Long id) {
		return blackListDao.findOne(id);
	}
	
	public Page<BlackList> find(Page<BlackList> page, BlackList blackList) {
		DetachedCriteria dc = blackListDao.createDetachedCriteria();
		dc.addOrder(Order.desc("id"));
		return blackListDao.find(page, dc);
	}
	
	public List<BlackList> find(String lawyercardnum) {
		DetachedCriteria dc = blackListDao.createDetachedCriteria();	
		if (StringUtils.isNotEmpty(lawyercardnum)) {
			dc.add(Restrictions.eq("lawyerCardnum",lawyercardnum));
		}
		dc.add(Restrictions.eq("status",Integer.parseInt("0")));
		java.util.Date date=Calendar.getInstance().getTime();
	
		dc.add(Restrictions.ge("endDate", date));
		dc.addOrder(Order.desc("id"));
		return blackListDao.find(dc);
	}
	
	@Transactional(readOnly = false)
	public void save(BlackList blackList) {
		blackListDao.save(blackList);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		blackListDao.deleteById(id);
	}
	
}
