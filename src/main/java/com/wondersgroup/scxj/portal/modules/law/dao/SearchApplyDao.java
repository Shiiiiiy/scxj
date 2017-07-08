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
import com.wondersgroup.scxj.portal.modules.law.entity.SearchApply;

/**
 * 诉讼流程DAO接口
 * @author LiRiChen
 * @version 2014-03-30
 */
public interface SearchApplyDao extends SearchApplyDaoCustom, CrudRepository<SearchApply, Long> {

	@Modifying
	@Query("update SearchApply set delFlag='" + SearchApply.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author LiRiChen
 */
interface SearchApplyDaoCustom extends BaseDao<SearchApply> {
	public List<Object> getGroupUsers(long groupId);
}

/**
 * DAO自定义接口实现
 * @author LiRiChen
 */
@Component
class SearchApplyDaoImpl extends BaseDaoImpl<SearchApply> implements SearchApplyDaoCustom {
	public List<Object> getGroupUsers(long groupId){
		String sql = "select username, mobile, nickname from wcmuser a left join wcmgrpuser b on a.userid = b.userid where b.groupid = ?";
//		SQLQuery query = createSqlQuery(sql);
//		query.setParameter(1, groupId);
		List<Object> list = findBySql(sql, groupId);
		return list;
		
	}
}
