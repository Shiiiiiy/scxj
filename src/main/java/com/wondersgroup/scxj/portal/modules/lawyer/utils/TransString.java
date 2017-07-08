package com.wondersgroup.scxj.portal.modules.lawyer.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.wondersgroup.scxj.portal.common.persistence.BaseEntity;

public class TransString {
	public static String getWayStr(long applyWay){
		if(applyWay==BaseEntity.SEARCHAPPLY_APPLYWAY_WS){
			return "网上申请";
		}else if(applyWay==BaseEntity.SEARCHAPPLY_APPLYWAY_XC){
			return "现场申请";
		}else if(applyWay==BaseEntity.SEARCHAPPLY_APPLYWAY_JD){
			return "阅卷导入";
		}else if(applyWay==BaseEntity.SEARCHAPPLY_APPLYWAY_SJ){
			return "手机申请";
		}
		return applyWay+"";
	}
	
	public static String getStatuStr(long statu){
		if(statu==BaseEntity.SEARCHAPPLY_DEAL_STATUS_NEW){
			return "待审核";
		}else if(statu==BaseEntity.SEARCHAPPLY_DEAL_STATUS_NOTTHROUGH){
			return "未通过";
		}else if(statu==BaseEntity.SEARCHAPPLY_DEAL_STATUS_THROUGH){
			return "已通过";
		}else if(statu==BaseEntity.SEARCHAPPLY_DEAL_STATUS_PUBLISH){
			return "尚未进入检察环节";
		}else if(statu==BaseEntity.SEARCHAPPLY_DEAL_STATUS_CANCEL){
			return "律师撤销绑定";
		}else if(statu==BaseEntity.SEARCHAPPLY_DEAL_STATUS_BACK){
			return "后台撤销委托";
		}else if(statu==BaseEntity.SEARCHAPPLY_DEAL_STATUS_END){
			return "结束";
		}else if(statu==BaseEntity.SEARCHAPPLY_DEAL_STATUS_DATA_FAULT){
			return "材料缺失";
		}else if(statu==BaseEntity.SEARCHAPPLY_DEAL_STATUS_DATA_FULL){
			return "材料补齐";
		}
		return statu+"";
	}
	
	public static String getDateStr(Date date){
		if(date!=null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String datestr=format.format(date);
			return datestr;
		}
		return "";
	}
	
	public static String getDealStr(Long dealstatus,Long isMiss,Long feedBackStatus){
		 String statusStr = "";
		  if(isMiss==1){//爽约
			  statusStr="已爽约";
		  }else if(dealstatus==BaseEntity.APPLY_DEAL_STATUS_DEALEND){
			  statusStr="接待完毕";
		  }else if(dealstatus==BaseEntity.APPLY_DEAL_STATUS_BACK){
			  statusStr="已退回";
		  }else if(feedBackStatus==BaseEntity.APPLY_FEEDBACK_STATUS_LAW_CANCEL || 
			  feedBackStatus==BaseEntity.APPLY_FEEDBACK_STATUS_SYS_CANCEL|| 
			  feedBackStatus==BaseEntity.APPLY_FEEDBACK_STATUS_LAW_QUEREN_CANCEL|| 
			  feedBackStatus==BaseEntity.APPLY_FEEDBACK_STATUS_LAW_NOONTIME_CANCEL|| 
			  feedBackStatus==BaseEntity.APPLY_FEEDBACK_STATUS_LAW_SHOULI_CANCEL){
			   //律师确认前手动取消该预约；不能按时赴约，自动设定为取消；系统定时取消，条件:接待日期前半日前未确认；确认后提前半个工作日内取消
			  statusStr="已取消";
		  }else if(dealstatus==BaseEntity.APPLY_DEAL_STATUS_PUBLISH && feedBackStatus==BaseEntity.APPLY_FEEDBACK_STATUS_VERIFY){
			  statusStr="已确认";
		  }else if(dealstatus==BaseEntity.APPLY_DEAL_STATUS_PUBLISH && feedBackStatus!=BaseEntity.APPLY_FEEDBACK_STATUS_VERIFY){
			  statusStr="已回复";
		  }else if(dealstatus==BaseEntity.APPLY_DEAL_STATUS_DATA_FAULT && feedBackStatus<0){
			  statusStr="材料缺失";
		  }else{
			  statusStr="处理中";
		  }
		return statusStr;
	}
}
