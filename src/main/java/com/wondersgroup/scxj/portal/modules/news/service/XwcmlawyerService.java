/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.news.service;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.common.service.BaseService;
import com.wondersgroup.scxj.portal.common.utils.StringUtils;
import com.wondersgroup.scxj.portal.modules.news.entity.Xwcmlawyer;
import com.wondersgroup.scxj.portal.modules.news.dao.XwcmlawyerDao;

/**
 * 检察院andriod版新闻Service
 * @author jack
 * @version 2014-01-14
 */
@Component
@Transactional(readOnly = true)
public class XwcmlawyerService extends BaseService {

	@Autowired
	private XwcmlawyerDao xwcmlawyerDao;
	
	public Xwcmlawyer get(Long id) {
		return xwcmlawyerDao.findOne(id);
	}
	
	public Page<Xwcmlawyer> find(Page<Xwcmlawyer> page, Xwcmlawyer xwcmlawyer) {
		DetachedCriteria dc = xwcmlawyerDao.createDetachedCriteria();
		dc.addOrder(Order.desc("id"));
		return xwcmlawyerDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(Xwcmlawyer xwcmlawyer) {
		xwcmlawyerDao.save(xwcmlawyer);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		xwcmlawyerDao.deleteById(id);
	}
	
}
