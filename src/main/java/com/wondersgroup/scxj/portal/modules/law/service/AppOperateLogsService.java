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
import com.wondersgroup.scxj.portal.modules.law.entity.AppOperateLogs;
import com.wondersgroup.scxj.portal.modules.law.dao.AppOperateLogsDao;

/**
 * 律师基本信息Service
 * @author LiRiChen
 * @version 2014-01-20
 */
@Component
@Transactional(readOnly = true)
public class AppOperateLogsService extends BaseService {

	@Autowired
	private AppOperateLogsDao appOperateLogsDao;
	
	public AppOperateLogs get(Long id) {
		return appOperateLogsDao.findOne(id);
	}
	
	public Page<AppOperateLogs> find(Page<AppOperateLogs> page, AppOperateLogs appOperateLogs) {
		DetachedCriteria dc = appOperateLogsDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(appOperateLogs.getLettleusername())){
			dc.add(Restrictions.like("name", "%"+appOperateLogs.getLettleusername()+"%"));
		}
		dc.addOrder(Order.desc("id"));
		return appOperateLogsDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(AppOperateLogs appOperateLogs) {
		appOperateLogsDao.save(appOperateLogs);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		appOperateLogsDao.deleteById(id);
	}
	
}
