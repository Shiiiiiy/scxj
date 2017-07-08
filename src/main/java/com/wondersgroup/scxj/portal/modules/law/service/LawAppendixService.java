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
import com.wondersgroup.scxj.portal.modules.law.entity.LawAppendix;
import com.wondersgroup.scxj.portal.modules.law.dao.LawAppendixDao;

/**
 * 案件信息Service
 * @author LiRiChen
 * @version 2014-03-30
 */
@Component
@Transactional(readOnly = true)
public class LawAppendixService extends BaseService {

	@Autowired
	private LawAppendixDao lawAppendixDao;
	
	public LawAppendix get(Long id) {
		return lawAppendixDao.findOne(id);
	}
	
	public Page<LawAppendix> find(Page<LawAppendix> page, LawAppendix lawAppendix) {
		DetachedCriteria dc = lawAppendixDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(lawAppendix.getFilename())){
			dc.add(Restrictions.like("filename", "%"+lawAppendix.getFilename()+"%"));
		}
		dc.addOrder(Order.desc("id"));
		return lawAppendixDao.find(page, dc);
	}
	
	public Page<LawAppendix> findByIdType(Page<LawAppendix> page, LawAppendix lawAppendix) {
		DetachedCriteria dc = lawAppendixDao.createDetachedCriteria();
		if (lawAppendix.getSearchappid()!=null){
			dc.add(Restrictions.eq("searchappid", lawAppendix.getSearchappid()));
		}
		if (StringUtils.isNotEmpty(lawAppendix.getApptype())){
			dc.add(Restrictions.eq("apptype",lawAppendix.getApptype()));
		}
		dc.addOrder(Order.asc("filename"));
		return lawAppendixDao.find(page, dc);
	}
	
	public List<LawAppendix> getBySearchId(Long id) {
		DetachedCriteria dc = lawAppendixDao.createDetachedCriteria();
		dc.add(Restrictions.eq("searchappid", id));
		dc.addOrder(Order.desc("id"));
		return lawAppendixDao.find(dc);
	}
	 
	@Transactional(readOnly = false)
	public void save(LawAppendix lawAppendix) {
		lawAppendixDao.save(lawAppendix);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		lawAppendixDao.deleteById(id);
	}
	
	@Transactional(readOnly = false)
	public void deleteByAppendixid(Long id) {
		lawAppendixDao.deleteByAppendixid(id);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long searchappid,String apptype) {
		lawAppendixDao.deleteByIdType(searchappid, apptype);
	}
	
}
