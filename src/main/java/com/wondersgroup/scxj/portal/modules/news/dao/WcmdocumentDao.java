/**
 * There are <a href="http://www.wondersgroup.com/">wonders</a> code generation
 */
package com.wondersgroup.scxj.portal.modules.news.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.wondersgroup.scxj.portal.common.persistence.BaseDao;
import com.wondersgroup.scxj.portal.common.persistence.BaseDaoImpl;
import com.wondersgroup.scxj.portal.common.persistence.Page;
import com.wondersgroup.scxj.portal.modules.news.entity.Wcmdocument;
/**
 * 检察院andriod版新闻DAO接口
 * 
 * @author jack
 * @version 2014-01-15
 */
public interface WcmdocumentDao extends WcmdocumentDaoCustom,
		CrudRepository<Wcmdocument, Long> {

	@Modifying
	@Query("delete from Wcmdocument where id = ?1")
	public int deleteById(Long id);


}

/**
 * DAO自定义接口
 * 
 * @author jack
 */
interface WcmdocumentDaoCustom extends BaseDao<Wcmdocument> {
	public List<Wcmdocument> findNextPageNews(String startRowNum, String endRowNum, String docchannel);
	public List<String> findPics(String docId);
	public Page<Wcmdocument> find(Page<Wcmdocument> page, DetachedCriteria detachedCriteria); 
	public Page<Wcmdocument> findBySqlChannel(Page<Wcmdocument> page, String channelName);
	public Wcmdocument find(Long id);
	public void count1();
	public void count2();	
	public String findBeforDoc(Long docId, Long docchannel);
	public String findNextDoc(Long docId, Long docchannel);
}

/**
 * DAO自定义接口实现
 * 
 * @author jack
 */
@Component
class WcmdocumentDaoImpl extends BaseDaoImpl<Wcmdocument> implements
		WcmdocumentDaoCustom {
	/**
	 * SQL 查询
	 * 
	 * @param sqlString
	 * @param resultClass
	 * @param parameter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <E> List<E> findBySql(String sqlString,String startRowNum, String endRowNum) {
		SQLQuery query = createSqlQuery(sqlString);
		query.setFirstResult(Integer.parseInt(startRowNum));
		query.setMaxResults(10);
		setResultTransformer(query, Wcmdocument.class);
		return query.list();
	}

	public void count1(){//下载
		String sql = "insert into count (id,time,description) values (s_count.nextval,sysdate,'2')";
		updateBySql(sql);
	}
	
	public void count2(){//使用
		String sql = "insert into count (id,time,description) values (s_count.nextval,sysdate,'1')";
		updateBySql(sql);
	}	
	
	@Override
//	public List<Wcmdocument> findNextPageNews(String startRowNum,
//			String endRowNum, String docchannel) {
//		String sql = " select * from Wcmdocument where docchannel='"+docchannel+"'order by docreltime desc ";
//		return findBySql(sql, startRowNum, endRowNum);
//	}
	//edit by ycl start 20140221
	public List<Wcmdocument> findNextPageNews(String startRowNum, String endRowNum, String docchannel) {
		String sql = "select top 10 percent * from Wcmdocument_1 where docchannel='"+docchannel+"'order by docoutupid desc, docreltime desc ";
		return findBySql(sql, startRowNum, endRowNum);
	}
	//edit by ycl end 20140221
	
	public List<String> findPics(String docId) {
		String sql = "select img_path from dc_content_picture where content_id='" + docId + "'";
		SQLQuery query = createSqlQuery(sql);
		query.setFirstResult(0);
		query.setMaxResults(10);
		//setResultTransformer(query, ContentPicture.class);
		return query.list();		
	}
	
	public Page<Wcmdocument> find(Page<Wcmdocument> page, DetachedCriteria detachedCriteria){

		return find(page, detachedCriteria, Criteria.DISTINCT_ROOT_ENTITY);
	}
	
	public Page<Wcmdocument> findBySqlChannel(Page<Wcmdocument> page, String channelName){
		String sql = "select top 10 percent * from Wcmdocument_1 where docchannel='"+ channelName + "' order by docoutupid desc, docreltime desc ";
		return this.findBySql(page, sql, null);
	}
	

	public Wcmdocument find(Long id) {
		String sql = "select * from Wcmdocument_1 where docid='"+ id + "'";
		return (Wcmdocument) findBySql(sql, "0", "0").get(0);
		//return null;
	}
	
	public String findBeforDoc(Long docId, Long docchannel) {
		String sql = "select brforDoc from (select top 10 percent docid,lead(docid,1,0)over ( order by docoutupid desc, docreltime desc ) as brforDoc,docoutupid,docreltime from Wcmdocument_1 where docchannel='"+docchannel+"') where docid='"+docId+"'";
		SQLQuery query = createSqlQuery(sql);
		//setResultTransformer(query, ContentPicture.class);
		if(query.list()!=null&&query.list().size()==1){
			return query.list().get(0).toString();
		}
		return "0";		
	}
	public String findNextDoc(Long docId, Long docchannel) {
		String sql = "select nextDoc from (select top 10 percent docid,lag(docid,1,0)over ( order by docoutupid desc, docreltime desc ) as nextDoc,docoutupid,docreltime from Wcmdocument_1 where docchannel='"+docchannel+"') where docid='"+docId+"'";
		SQLQuery query = createSqlQuery(sql);
		//setResultTransformer(query, ContentPicture.class);
		if(query.list()!=null&&query.list().size()==1){
			return query.list().get(0).toString();
		}
		return "0";		
	}

}