/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.common.service.BaseService;
import com.wondersgroup.scxj.portal.modules.law.dao.HolidayDao;
import com.wondersgroup.scxj.portal.modules.law.entity.Holiday;

/**
 * 假日信息Service
 * @author LiRiChen
 * @version 2014-01-21
 */
@Component
@Transactional(readOnly = true)
public class HolidayService extends BaseService {

	@Autowired
	private HolidayDao holidayDao;
	
	public Holiday get(Long id) {
		return holidayDao.findOne(id);
	}
	
	public Page<Holiday> find(Page<Holiday> page, Holiday holiday) {
		DetachedCriteria dc = holidayDao.createDetachedCriteria();
		
		dc.addOrder(Order.desc("id"));
		return holidayDao.find(page, dc);
	}
	
	public List<Holiday> find(Holiday holiday) {
		DetachedCriteria dc = holidayDao.createDetachedCriteria();		
		dc.addOrder(Order.desc("id"));
		return holidayDao.find(dc);
	}
	
	@Transactional(readOnly = false)
	public void save(Holiday holiday) {
		holidayDao.save(holiday);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		holidayDao.deleteById(id);
	}
	
}
