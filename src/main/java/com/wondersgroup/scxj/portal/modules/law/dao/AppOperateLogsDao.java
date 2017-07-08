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
import com.wondersgroup.scxj.portal.modules.law.entity.AppOperateLogs;

/**
 * 律师基本信息DAO接口
 * @author LiRiChen
 * @version 2014-01-20
 */
public interface AppOperateLogsDao extends AppOperateLogsDaoCustom, CrudRepository<AppOperateLogs, Long> {

	@Modifying
	@Query("update AppOperateLogs set delFlag='" + AppOperateLogs.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author LiRiChen
 */
interface AppOperateLogsDaoCustom extends BaseDao<AppOperateLogs> {

}

/**
 * DAO自定义接口实现
 * @author LiRiChen
 */
@Component
class AppOperateLogsDaoImpl extends BaseDaoImpl<AppOperateLogs> implements AppOperateLogsDaoCustom {

}
