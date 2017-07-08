/**
 * Copyright &copy; 2012-2013 <a href="http://www.wondersgroup.com/">shjcy</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wondersgroup.scxj.portal.common.persistence;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * Entity支持类
 * @author LiRiChen
 * @version 2013-01-15
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// 显示/隐藏
	public static final String SHOW = "1";
	public static final String HIDE = "0";
	
	// 是/否
	public static final String YES = "1";
	public static final String NO = "0";

	// 删除标记（0：正常；1：删除；2：审核；3：重复）
	public static final String DEL_FLAG = "delFlag";
	public static final String LAWYER_DEL_FLAG = "isdel";
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";
	public static final String DEL_FLAG_REPEAT = "3";
	
	public static final int LAWYER_DEL_FLAG_NORMAL = 0;
	public static final int LAWYER_DEL_FLAG_DELETE = 1;
	
	 /**  律师网上申请预约处理状态(承办员操作状态)  dealStatus**/
	  public static final int APPLY_DEAL_STATUS_NEW = 10;    //新稿，待受理
	  public static final int APPLY_DEAL_STATUS_SIGN = 11;   //已受理、待回复
	  public static final int APPLY_DEAL_STATUS_REMARK = 12; //已回复、待发布
	  public static final int APPLY_DEAL_STATUS_PUBLISH = 13;//已发布、待确认（律师回复确认）
	  public static final int APPLY_DEAL_STATUS_BACK = 14;//已退回
	  public static final int APPLY_DEAL_STATUS_CANCEL = 15;//已取消（案管部门取消）
	  public static final int APPLY_DEAL_STATUS_DEALEND = 19;//接待完毕
	  public static final int APPLY_DEAL_STATUS_DATA_FAULT = 16;//材料缺失 2015-07-12add 
	  public static final int APPLY_DEAL_STATUS_DATA_FULL = 17;//材料补齐 2015-07-12add

	  
	  
	  /**  律师网上申请预约反馈状态(用户操作状态)  FeedbackStatus**/  
	  public static final int APPLY_FEEDBACK_STATUS_NULL = -1; //已确认（律师回复确认，并承诺是否按时赴约）
	  public static final int APPLY_FEEDBACK_STATUS_VERIFY = 20; //已确认（律师回复确认，并承诺是否按时赴约）
	  public static final int APPLY_FEEDBACK_STATUS_LAW_CANCEL = 30;//已取消(预约单在受理前前律师手动取消该预约)
	  public static final int APPLY_FEEDBACK_STATUS_LAW_SHOULI_CANCEL = 31;//已取消（受理后，回复前律师手动取消）
	  public static final int APPLY_FEEDBACK_STATUS_LAW_QUEREN_CANCEL = 34;//已取消（律师确认承诺按时赴约，但在接待时间半个工作日前手动取消或预约单已受理律师手动取消）
	  public static final int APPLY_FEEDBACK_STATUS_LAW_NOONTIME_CANCEL = 35;//已取消(不能按时赴约，自动设定为取消)
	  public static final int APPLY_FEEDBACK_STATUS_WORKER_CANCEL = 36;//已取消（律师电话取消）
	  public static final int APPLY_FEEDBACK_STATUS_SYS_CANCEL = 40;//已取消(系统定时取消，条件:接待日期前半日前未确认)
	  
	  /**  律师网上申请预约判断是否爽约(小时) **/  
	  public static final int APPLY_ISMISS_TIME_HOURS = 8; //已确认（流程结束，办理完结）
	  
	  /**  诉讼进程查询状态  **/
	  public static final int SEARCHAPPLY_DEAL_STATUS_NEW = 10;        // 待审核
	  public static final int SEARCHAPPLY_DEAL_STATUS_NOTTHROUGH = 11; //未通过
	  public static final int SEARCHAPPLY_DEAL_STATUS_THROUGH = 12;    //已绑定（审核通过）
	  public static final int SEARCHAPPLY_DEAL_STATUS_PUBLISH = 13;    //挂起（尚未进入检察环节）
	  public static final int SEARCHAPPLY_DEAL_STATUS_CANCEL = 14;     //前台律师 撤销绑定、撤销委托
	  public static final int SEARCHAPPLY_DEAL_STATUS_BACK = 15;//后台工作人员 撤销绑定、撤销委托
	  public static final int SEARCHAPPLY_DEAL_STATUS_END = 16;//结束
	  public static final int SEARCHAPPLY_DEAL_STATUS_DATA_FAULT = 17;//材料缺失，需要律师补齐材料；
	  public static final int SEARCHAPPLY_DEAL_STATUS_DATA_FULL = 18;//材料补齐；
	  
	  
	  /**  诉讼进程查询 申请方式  **/
	  public static final int SEARCHAPPLY_APPLYWAY_WS = 1; //网上申请；
	  public static final int SEARCHAPPLY_APPLYWAY_XC = 2; //现场申请；
	  public static final int SEARCHAPPLY_APPLYWAY_JD = 3; //接待系统导入
	  public static final int SEARCHAPPLY_APPLYWAY_SJ = 4; //手机申请；

	
	  /**  操作结果反馈提示信息  **/
	  public static final String message_save_lawyer_apply_ok = "诉讼业务预约申请提交成功";
	  public static final String message_save_lawyer_apply_no_edit = "此诉讼业务暂时不能修改";
	  public static final String message_save_lawyer_process_ok = "诉讼流程预约申请提交成功";
	  public static final String message_save_lawyer_process_no_to = "此诉讼流程暂时不能预约";
	  public static final String message_save_lawyer_process_no_edit = "此诉讼流程暂时不能修改";
	  public static final String message_save_lawyer_repeat = "该请求目前正在审核，请及时网上查询或关注短信，若自申请之日起一个半工作日后未收到回复，可在“留言板”留言或致电24079825";

}
