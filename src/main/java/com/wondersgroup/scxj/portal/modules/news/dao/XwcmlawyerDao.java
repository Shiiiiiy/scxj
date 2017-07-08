/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.news.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.wondersgroup.scxj.portal.common.persistence.BaseDao;
import com.wondersgroup.scxj.portal.common.persistence.BaseDaoImpl;
import com.wondersgroup.scxj.portal.modules.news.entity.Xwcmlawyer;

/**
 * 检察院andriod版新闻DAO接口
 * @author jack
 * @version 2014-01-14
 */
public interface XwcmlawyerDao extends XwcmlawyerDaoCustom, CrudRepository<Xwcmlawyer, Long> {

	@Modifying
	@Query("delete from Xwcmlawyer where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author jack
 */
interface XwcmlawyerDaoCustom extends BaseDao<Xwcmlawyer> {

}

/**
 * DAO自定义接口实现
 * @author jack
 */
@Component
class XwcmlawyerDaoImpl extends BaseDaoImpl<Xwcmlawyer> implements XwcmlawyerDaoCustom {

}
