package com.wondersgroup.scxj.portal.modules.lawyer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.wondersgroup.scxj.portal.common.persistence.BaseDao;
import com.wondersgroup.scxj.portal.common.persistence.BaseDaoImpl;
import com.wondersgroup.scxj.portal.modules.lawyer.entity.Leamassge;
/**
 * 假日信息DAO接口
 * 
 * @author LiRiChen
 * @version 2014-01-21
 */
public interface MessageDao extends MessageDaoCustom, CrudRepository<Leamassge, Long> {

	@Modifying
	@Query("update Leamassge set delFlag='" + Leamassge.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);

}

/**
 * DAO自定义接口
 * 
 * @author LiRiChen
 */
interface MessageDaoCustom extends BaseDao<Leamassge> {

}

/**
 * DAO自定义接口实现
 * 
 * @author LiRiChen
 */
@Component
class MessageDaoImpl extends BaseDaoImpl<Leamassge> implements MessageDaoCustom {
	public List<Object> getListByIdAndName(String pid,String lmusername){
		String sql = "select * from XWCMLEAMASSGE where pid=? and lmusername=?";
		List<Object> list =findBySql(sql, pid,lmusername);
		return list;
}
}