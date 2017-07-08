/**
 * Copyright &copy; 2012-2013 <a href="http://www.wondersgroup.com/">shjcy</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wondersgroup.scxj.portal.modules.sys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wondersgroup.scxj.portal.common.persistence.BaseDao;
import com.wondersgroup.scxj.portal.common.persistence.BaseDaoImpl;
import com.wondersgroup.scxj.portal.modules.sys.entity.Office;

/**
 * 机构DAO接口
 * @author LiRiChen
 * @version 2013-05-15
 */
public interface OfficeDao extends OfficeDaoCustom, CrudRepository<Office, Long> {

	@Modifying
	@Query("update Office set delFlag='" + Office.DEL_FLAG_DELETE + "' where id = ?1 or parentIds like ?2")
	public int deleteById(Long id, String likeParentIds);
	
	public List<Office> findByParentIdsLike(String parentIds);

//	@Query("from Office where delFlag='" + Office.DEL_FLAG_NORMAL + "' order by code")
//	public List<Office> findAllList();
//	
//	@Query("from Office where (id=?1 or parent.id=?1 or parentIds like ?2) and delFlag='" + Office.DEL_FLAG_NORMAL + "' order by code")
//	public List<Office> findAllChild(Long parentId, String likeParentIds);
}

/**
 * DAO自定义接口
 * @author LiRiChen
 */
interface OfficeDaoCustom extends BaseDao<Office> {

}

/**
 * DAO自定义接口实现
 * @author LiRiChen
 */
@Repository
class OfficeDaoImpl extends BaseDaoImpl<Office> implements OfficeDaoCustom {

}
