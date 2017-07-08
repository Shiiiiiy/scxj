/**
 * Copyright &copy; 2012-2013 <a href="http://www.wondersgroup.com/">shjcy</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wondersgroup.scxj.portal.modules.sys.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wondersgroup.scxj.portal.common.persistence.BaseDao;
import com.wondersgroup.scxj.portal.common.persistence.BaseDaoImpl;
import com.wondersgroup.scxj.portal.modules.sys.entity.Log;

/**
 * 日志DAO接口
 * @author LiRiChen
 * @version 2013-06-02
 */
public interface LogDao extends LogDaoCustom, CrudRepository<Log, Long> {
	
}

/**
 * DAO自定义接口
 * @author LiRiChen
 */
interface LogDaoCustom extends BaseDao<Log> {

}

/**
 * DAO自定义接口实现
 * @author LiRiChen
 */
@Repository
class LogDaoImpl extends BaseDaoImpl<Log> implements LogDaoCustom {

}
