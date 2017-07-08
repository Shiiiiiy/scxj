/**
 * Copyright &copy; 2012-2013 <a href="http://www.wondersgroup.com/">shjcy</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wondersgroup.scxj.portal.modules.sys.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wondersgroup.scxj.portal.common.persistence.BaseDao;
import com.wondersgroup.scxj.portal.common.persistence.BaseDaoImpl;
import com.wondersgroup.scxj.portal.modules.sys.entity.User;

/**
 * 用户DAO接口
 * @author LiRiChen
 * @version 2013-01-15
 */
public interface UserDao extends UserDaoCustom, CrudRepository<User, Long> {
	
	@Query("from User where loginName = ?1 and delFlag = '" + User.DEL_FLAG_NORMAL + "'")
	public User findByLoginName(String loginName);

	@Modifying
	@Query("update User set delFlag='" + User.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
	@Modifying
	@Query("update User set password=?1 where id = ?2")
	public int updatePasswordById(String newPassword, Long id);
	
	@Modifying
	@Query("update User set loginIp=?1, loginDate=?2 where id = ?3")
	public int updateLoginInfo(String loginIp, Date loginDate, Long id);
}

/**
 * DAO自定义接口
 * @author LiRiChen
 */
interface UserDaoCustom extends BaseDao<User> {

}

/**
 * DAO自定义接口实现
 * @author LiRiChen
 */
@Repository
class UserDaoImpl extends BaseDaoImpl<User> implements UserDaoCustom {

}
