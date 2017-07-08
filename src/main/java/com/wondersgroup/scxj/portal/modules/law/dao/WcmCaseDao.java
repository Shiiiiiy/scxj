/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.wondersgroup.scxj.portal.common.persistence.BaseDao;
import com.wondersgroup.scxj.portal.common.persistence.BaseDaoImpl;
import com.wondersgroup.scxj.portal.modules.law.entity.WcmCase;

/**
 * 案件信息DAO接口
 * @author LiRiChen
 * @version 2014-03-30
 */
public interface WcmCaseDao extends WcmCaseDaoCustom, CrudRepository<WcmCase, Long> {

	@Modifying
	@Query("update WcmCase set delFlag='" + WcmCase.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author LiRiChen
 */
interface WcmCaseDaoCustom extends BaseDao<WcmCase> {
	public List<Object> findByPersonId(String personid);
}

/**
 * DAO自定义接口实现
 * @author LiRiChen
 */
@Component
class WcmCaseDaoImpl extends BaseDaoImpl<WcmCase> implements WcmCaseDaoCustom {

	@Override
	public List<Object>  findByPersonId(String personid) {
		String sql = "select id, casestage, caseaccepctnum from xwcmcase where personid = ?";
		return findBySql(sql, personid);
	}

}
