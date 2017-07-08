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
import com.wondersgroup.scxj.portal.modules.law.entity.Lawyer;
import com.wondersgroup.scxj.portal.modules.sys.entity.User;

/**
 * 律师基本信息DAO接口
 * @author LiRiChen
 * @version 2014-01-19
 */
public interface LawyerDao extends LawyerDaoCustom, CrudRepository<Lawyer, Long> {

	@Modifying
	@Query("update Lawyer set delFlag='" + Lawyer.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
	@Query("from Lawyer where personid = ?1")
	public Lawyer findByPersonId(String personId);
	

	@Query("from Lawyer where idnumber = ?1")
	public Lawyer findByLawyerIdNumber(String idNumber);
	
	@Query("from Lawyer where mobile = ?1")
	public Lawyer findByLawyerMobile(String mobile);
}

/**
 * DAO自定义接口
 * @author LiRiChen
 */
interface LawyerDaoCustom extends BaseDao<Lawyer> {

}

/**
 * DAO自定义接口实现
 * @author LiRiChen
 */
@Component
class LawyerDaoImpl extends BaseDaoImpl<Lawyer> implements LawyerDaoCustom {

}
