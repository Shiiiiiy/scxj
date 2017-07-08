package com.wondersgroup.scxj.portal.modules.lawyer.service;

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
import com.wondersgroup.scxj.portal.modules.law.entity.SearchApply;
import com.wondersgroup.scxj.portal.modules.lawyer.dao.MessageDao;
import com.wondersgroup.scxj.portal.modules.lawyer.entity.Leamassge;
import com.wondersgroup.scxj.portal.common.utils.DateUtils;
import com.wondersgroup.scxj.portal.common.utils.StringUtils;
@Component
@Transactional(readOnly=true)
public class MessageService extends BaseService{
  @Autowired
  private MessageDao messageDao;
  
  public Leamassge get(Long id) {
		return messageDao.findOne(id);
	}
	
  public Page<Leamassge> find(Page<Leamassge> page,
			Leamassge msg) {
		DetachedCriteria dc = messageDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(msg.getLmusername())) {
			dc.add(Restrictions.like("lmusername",
					"%" + msg.getLmusername() + "%"));
		}
		if (StringUtils.isNotEmpty(msg.getPid())){
			dc.add(Restrictions.like("pid",
					"%" +msg.getPid()+ "%"));
		}
		if(StringUtils.isNotEmpty(msg.getLmsg())){
			dc.add(Restrictions.like("lmsg",
					"%" +msg.getLmsg()+ "%"));
		}
		dc.addOrder(Order.desc("crtime"));
		return messageDao.find(page, dc);
	}
  public Page<Leamassge> find(Page<Leamassge> page,
			Leamassge msg, String pageNo,String pageSize) {
		DetachedCriteria dc = messageDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(msg.getLmusername())) {
			dc.add(Restrictions.eq("lmusername",
					msg.getLmusername()));
		}
		if (StringUtils.isNotEmpty(msg.getPid())) {
			dc.add(Restrictions.like("pid",
					"%" + msg.getPid() + "%"));
		}
		if (StringUtils.isNotEmpty(msg.getLmsg())) {
			dc.add(Restrictions.like("lmsg",
					"%" + msg.getLmsg() + "%"));
		}
		if (StringUtils.isEmpty(pageNo)) {
			pageNo="1";
		}
		page.setPageNo(Integer.parseInt(pageNo));
		page.setPageSize(Integer.parseInt(pageSize));
		dc.addOrder(Order.desc("crtime"));
		return messageDao.find(page, dc);
	}

	
	public List<Leamassge> find(Leamassge msg) {
		DetachedCriteria dc = messageDao.createDetachedCriteria();		
		dc.addOrder(Order.desc("id"));
		return messageDao.find(dc);
	}
	
	@Transactional(readOnly = false)
	public void save(Leamassge msg) {
		messageDao.save(msg);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		messageDao.deleteById(id);
	}
  
}
