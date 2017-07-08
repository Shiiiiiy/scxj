/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.wondersgroup.scxj.portal.common.persistence.BaseDao;
import com.wondersgroup.scxj.portal.common.persistence.BaseDaoImpl;
import com.wondersgroup.scxj.portal.modules.law.entity.LawAppendix;

/**
 * 案件信息DAO接口
 * @author LiRiChen
 * @version 2014-03-30
 */
public interface LawAppendixDao extends LawAppendixDaoCustom, CrudRepository<LawAppendix, Long> {

	@Modifying
	@Query("update LawAppendix set delFlag='" + LawAppendix.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
	@Modifying
	@Query("delete LawAppendix where searchappid = ?1 and apptype = ?2")
	public int deleteByIdType(Long searchappid,String apptype);
	
	@Modifying
	@Query("delete LawAppendix where Appendixid = ?1")
	public int deleteByAppendixid(Long id);
	
}

/**
 * DAO自定义接口
 * @author LiRiChen
 */
interface LawAppendixDaoCustom extends BaseDao<LawAppendix> {

}

/**
 * DAO自定义接口实现
 * @author LiRiChen
 */
@Component
class LawAppendixDaoImpl extends BaseDaoImpl<LawAppendix> implements LawAppendixDaoCustom {

}
