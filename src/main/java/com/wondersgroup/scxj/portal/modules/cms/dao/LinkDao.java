/**
 * Copyright &copy; 2012-2013 <a href="http://www.wondersgroup.com/">shjcy</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wondersgroup.scxj.portal.modules.cms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wondersgroup.scxj.portal.common.persistence.BaseDao;
import com.wondersgroup.scxj.portal.common.persistence.BaseDaoImpl;
import com.wondersgroup.scxj.portal.modules.cms.entity.Link;

/**
 * 链接DAO接口
 * @author LiRiChen
 * @version 2013-01-15
 */
public interface LinkDao extends LinkDaoCustom, CrudRepository<Link, Long> {

	@Modifying
	@Query("update Link set delFlag=?2 where id = ?1")
	public int updateDelFlag(Long id, String status);
	
	public List<Link> findByIdIn(Long[] ids);
	
	@Modifying
	@Query("update Link set weight=0 where weight > 0 and weightDate < current_timestamp()")
	public int updateExpiredWeight();
}

/**
 * DAO自定义接口
 * @author LiRiChen
 */
interface LinkDaoCustom extends BaseDao<Link> {

}

/**
 * DAO自定义接口实现
 * @author LiRiChen
 */
@Repository
class LinkDaoImpl extends BaseDaoImpl<Link> implements LinkDaoCustom {

}
