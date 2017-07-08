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
import com.wondersgroup.scxj.portal.modules.law.entity.BlackList;
import com.wondersgroup.scxj.portal.modules.law.entity.Holiday;

/**
 * 假日信息DAO接口
 * @author Ycl
 * @version 2014-01-21
 */
public interface BlackListDao extends BlackListDaoCustom, CrudRepository<BlackList, Long> {

	@Modifying
	@Query("update BlackList set delFlag='" + BlackList.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Ycl
 */
interface BlackListDaoCustom extends BaseDao<BlackList> {

}

/**
 * DAO自定义接口实现
 * @author Ycl
 */
@Component
class BlackListDaoImpl extends BaseDaoImpl<BlackList> implements BlackListDaoCustom {

}
