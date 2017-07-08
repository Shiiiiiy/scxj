/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.news.service;

import java.util.ArrayList;
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
import com.wondersgroup.scxj.portal.modules.news.entity.Wcmdocument;
import com.wondersgroup.scxj.portal.modules.news.dao.WcmdocumentDao;

/**
 * 检察院andriod版新闻Service
 * @author jack
 * @version 2014-01-15
 */
@Component
@Transactional(readOnly = true)
public class WcmdocumentService extends BaseService {

	@Autowired
	private WcmdocumentDao wcmdocumentDao;
	
	@Autowired
	private WcmdocumentDao wcmdocumentDaoCustom;
	
	public Wcmdocument get(Long id) {
		return wcmdocumentDao.findOne(id);
	}
	
	public List<Wcmdocument> findNextPageNews(String startRowNum, String endRowNum, String docchannel){
		List<Wcmdocument> list = new ArrayList<Wcmdocument>();
		list = wcmdocumentDaoCustom.findNextPageNews(startRowNum, endRowNum, docchannel);
		return list;
	}
	
	public Page<Wcmdocument> find(Page<Wcmdocument> page, Wcmdocument wcmdocument) {
		DetachedCriteria dc = wcmdocumentDao.createDetachedCriteria();
		dc.add(Restrictions.eq("docstatus", Long.parseLong("10")));
		if (wcmdocument.getDocchannel()!=null){
			dc.add(Restrictions.eq("docchannel", wcmdocument.getDocchannel()));
		}
		dc.addOrder(Order.desc("docreltime"));
		return wcmdocumentDao.find(page, dc);
	}
	
	public Page<Wcmdocument> findBySqlChannel(Page<Wcmdocument> page, String channelName) {
		return wcmdocumentDao.findBySqlChannel(page, channelName);
	}
	
	@Transactional(readOnly = false)
	public void save(Wcmdocument wcmdocument) {
		wcmdocumentDao.save(wcmdocument);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		wcmdocumentDao.deleteById(id);
	}
	
}
