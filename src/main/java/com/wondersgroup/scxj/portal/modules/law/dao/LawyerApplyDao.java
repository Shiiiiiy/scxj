/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.law.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.wondersgroup.scxj.portal.common.persistence.BaseDao;
import com.wondersgroup.scxj.portal.common.persistence.BaseDaoImpl;
import com.wondersgroup.scxj.portal.modules.law.entity.LawyerApply;

/**
 * 诉讼业务办理DAO接口
 * @author LiRiChen
 * @version 2014-01-13
 */
public interface LawyerApplyDao extends LawyerApplyDaoCustom, CrudRepository<LawyerApply, Long> {

	@Modifying
	@Query("update LawyerApply set isdel='" + LawyerApply.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author LiRiChen
 */
interface LawyerApplyDaoCustom extends BaseDao<LawyerApply> {
	public List<Object> getGroupUsers(long groupId);
}

/**
 * DAO自定义接口实现
 * @author LiRiChen
 */
@Component
class LawyerApplyDaoImpl extends BaseDaoImpl<LawyerApply> implements LawyerApplyDaoCustom {
	public List<Object> getGroupUsers(long groupId){
		String sql = "select username, mobile, nickname from wcmuser a left join wcmgrpuser b on a.userid = b.userid where b.groupid = ?";
//		SQLQuery query = createSqlQuery(sql);
//		query.setParameter(1, groupId);
		List<Object> list = findBySql(sql, groupId);
		return list;
		
	}
}
