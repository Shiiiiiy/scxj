/**
 * Copyright &copy; 2012-2013 <a href="http://www.wondersgroup.com/">shjcy</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wondersgroup.scxj.portal.modules.cms.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wondersgroup.scxj.portal.common.persistence.BaseDao;
import com.wondersgroup.scxj.portal.common.persistence.BaseDaoImpl;
import com.wondersgroup.scxj.portal.modules.cms.entity.Comment;

/**
 * 评论DAO接口
 * @author LiRiChen
 * @version 2013-01-15
 */
public interface CommentDao extends CommentDaoCustom, CrudRepository<Comment, Long> {

	@Modifying
	@Query("update Comment set delFlag=?2 where id = ?1")
	public int updateDelFlag(Long id, String status);
	
}

/**
 * DAO自定义接口
 * @author LiRiChen
 */
interface CommentDaoCustom extends BaseDao<Comment> {

}

/**
 * DAO自定义接口实现
 * @author LiRiChen
 */
@Repository
class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDaoCustom {

}
