/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.service;

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
import com.wondersgroup.scxj.portal.modules.law.entity.WcmCase;
import com.wondersgroup.scxj.portal.modules.law.dao.WcmCaseDao;

/**
 * 案件信息Service
 * 
 * @author LiRiChen
 * @version 2014-03-30
 */
@Component
@Transactional(readOnly = true)
public class CaseService extends BaseService {

	@Autowired
	private WcmCaseDao wcmCaseDao;

	public WcmCase get(Long id) {
		return wcmCaseDao.findOne(id);
	}

	public List<Object> getByPersonId(String personId) {
		return wcmCaseDao.findByPersonId(personId);
	}

	public Page<WcmCase> find(Page<WcmCase> page, WcmCase wcmCase) {
		DetachedCriteria dc = wcmCaseDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(wcmCase.getCasebrief())) {
			dc.add(Restrictions.like("casebrief", "%" + wcmCase.getCasebrief()
					+ "%"));
		}
		dc.addOrder(Order.desc("id"));
		return wcmCaseDao.find(page, dc);
	}

	public Page<WcmCase> find(Page<WcmCase> page, String personId) {
		DetachedCriteria dc = wcmCaseDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(personId)) {
			dc.add(Restrictions.eq("personid", personId));
		}
		dc.addOrder(Order.desc("id"));
		return wcmCaseDao.find(page, dc);
	}

	@Transactional(readOnly = false)
	public void save(WcmCase wcmCase) {
		wcmCaseDao.save(wcmCase);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		wcmCaseDao.deleteById(id);
	}

}
