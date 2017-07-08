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
import com.wondersgroup.scxj.portal.modules.law.entity.MessageLogs;

/**
 * 律师基本信息DAO接口
 * @author LiRiChen
 * @version 2014-01-20
 */
public interface MessageLogsDao extends MessageLogsDaoCustom, CrudRepository<MessageLogs, Long> {

	@Modifying
	@Query("update MessageLogs set delFlag='" + MessageLogs.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author LiRiChen
 */
interface MessageLogsDaoCustom extends BaseDao<MessageLogs> {

}

/**
 * DAO自定义接口实现
 * @author LiRiChen
 */
@Component
class MessageLogsDaoImpl extends BaseDaoImpl<MessageLogs> implements MessageLogsDaoCustom {

}
