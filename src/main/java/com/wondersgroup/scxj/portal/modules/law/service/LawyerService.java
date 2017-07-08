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
import com.wondersgroup.scxj.portal.modules.law.entity.Lawyer;
import com.wondersgroup.scxj.portal.modules.law.dao.LawyerDao;

/**
 * 律师基本信息Service
 * @author LiRiChen
 * @version 2014-01-19
 */
@Component
@Transactional(readOnly = true)
public class LawyerService extends BaseService {

	@Autowired
	private LawyerDao lawyerDao;
	
	public Lawyer get(Long id) {
		return lawyerDao.findOne(id);
	}
	
	public Lawyer getByPersonId(String personId) {
		return lawyerDao.findByPersonId(personId);
	}
	
	public Lawyer getByLawyerIdNumber(String idNumber) {
		return lawyerDao.findByLawyerIdNumber(idNumber);
	}
	
	public Lawyer getByLawyerMobile(String mobile) {
		return lawyerDao.findByLawyerMobile(mobile);
	}
	
	public Page<Lawyer> find(Page<Lawyer> page, Lawyer lawyer) {
		DetachedCriteria dc = lawyerDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(lawyer.getName())){
			dc.add(Restrictions.like("name", "%"+lawyer.getName()+"%"));
		}
		dc.add(Restrictions.eq(Lawyer.DEL_FLAG, Lawyer.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return lawyerDao.find(page, dc);
	}	
	
	@Transactional(readOnly = false)
	public void save(Lawyer lawyer) {
		lawyerDao.save(lawyer);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		lawyerDao.deleteById(id);
	}
	
}
