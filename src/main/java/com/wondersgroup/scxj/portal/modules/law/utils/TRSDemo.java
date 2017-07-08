package com.wondersgroup.scxj.portal.modules.law.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.json.JSONObject;

import com.touch.sysif.sms.api.SmsClient;
import com.touch.sysif.sms.api.model.SmsMessage;
import com.touch.sysif.sms.api.model.SmsReport;

public class TRSDemo {
	/**
	 * WebService接口实现
	 * 
	 */
	public static SmsClient client = null;
	
	public static void main(String[] args) {
		TRSDemo trsDemo = new TRSDemo();
		
		//发送短信 返回短信批次号
		String batchID = trsDemo.insMessage("13651808734", "测试短信003！");
		System.out.println("----batchID : "+batchID);
		
		//String smsReport= getSmsReports("781b01bb7c1e4908912bd22c7c05c8c5","13651808734");
		
		/**
		 * 手机回复短信之后运行下面的方法
		 */		
		//List<JSONObject> smsRestlt = getSmsMessage();
		
	}
	
	/**
	 * 传入手机号码 短信内容 发送短信 返回短信批次号
	 * @param destAddr 手机号码
	 * @param content 短信内容
	 * @author Li.chen
	 * @date 2015/06/12
	 * @return
	 */
	public String insMessage(String destAddr,String content){
		String batchID = ""; //短信批次号
		client = new com.touch.sysif.sms.api.client.WsSmsClient();
		//初始化API，帐号信息必填，根据 SmsClient 实现选填对应参数
		client.init("api.properties");
		//设置发送消息属性
		SmsMessage message = new SmsMessage();
		//短信接收号码必填多个号号码用‘；’或者','隔开，群发时建议不超过100个号码
		message.setDestAddr(destAddr);
		//短信内容必填
		message.setContent(content);
		//是否需要状态报告可选，默认需要状态报告
		message.setReqReport(true);
		
		//定时发送时间可选，默认立即发送
		//message.setSendTime(new Date());
		
		//执行发送短信，返回批次号
		//System.out.println("发送结果："+client.send(message ));
		batchID =client.send(message);
		//退出
		client.shutdown();
		return batchID;
	}
	
	/**
	 * 根据短信发送的批次和接受短信的手机号码获取短信的发送状态
	 * @param batchID  短信发送批次
	 * @param destAddr 接受短信的手机号码
	 * @return
	 */
	public static String getSmsReports(String batchID,String destAddr) {
		String smsResult=""; //当前批次短信发送状态
		JSONObject json = new JSONObject();//短信状态
		SmsReport report = null;
		SmsReport reportArr[] = null;
		client = new com.touch.sysif.sms.api.client.WsSmsClient();
		//初始化API，帐号信息必填，根据 SmsClient 实现选填对应参数
		client.init("api.properties");
		reportArr = client.getSmsReports(batchID,destAddr);
		//System.out.println("------report : "+reportArr);
		smsResult = Arrays.toString(reportArr);
		System.out.println("------smsResult : "+smsResult);
		if(reportArr.length>0){
			report = reportArr[0];
			json.put("batchId", report.getBatchId());
			json.put("destAddr", report.getDestAddr());
			json.put("destAddr", report.getDestAddr());
			json.put("receivedTime", report.getReceivedTime());
			json.put("statusCode", report.getStatusCode());
			System.out.println("-----json : "+json);
		}
		return null;
		
	}
	
	
	/**
	 * 根据短信批次号当前批次所有未获取的短信回复内容
	 * @param batchID 短信批次号
	 * @author Li.chen
	 * @date 2015/06/12
	 * @return
	 */
	public String getMassageByBatchID(String batchID){
		String smsResult=""; //当前批次所有未获取的短信回复内容
		client = new com.touch.sysif.sms.api.client.WsSmsClient();
		//初始化API，帐号信息必填，根据 SmsClient 实现选填对应参数
		client.init("api.properties");
		//设置发送消息属性
		SmsMessage message = new SmsMessage();
		//传入短信批次号
		message.setBatchId(batchID);
		//获取上行短信
		//System.out.println("上行短信："+Arrays.toString(client.getSmsMessage()));
		smsResult = Arrays.toString(client.getSmsMessage());
		//退出
		client.shutdown();
		return smsResult;
	}
	
	public static List<JSONObject> getSmsMessage(){
		String smsResult=""; //当前批次所有未获取的短信回复内容
		JSONObject json = null;
		List<JSONObject> list = new ArrayList<JSONObject>();
		SmsMessage msg = null;
		client = new com.touch.sysif.sms.api.client.WsSmsClient();
		//初始化API，帐号信息必填，根据 SmsClient 实现选填对应参数
		client.init("api.properties");
		//获取上行短信
		SmsMessage msgArr[] = client.getSmsMessage();
		
		//System.out.println(msgArr);
		System.out.println("-------------------------------------------------");		
		smsResult = Arrays.toString(msgArr);		
		System.out.println(smsResult);	
		
		for(int i=0;i<msgArr.length;i++){
			msg = msgArr[i];
			json = new JSONObject();
			json.put("batchId", msg.getBatchId());//发送短信批次号
			json.put("content", msg.getContent());//获取短信内容
			//json.put("destAddr", msg.getDestAddr());
			//json.put("reqReport", msg.getReqReport());
			json.put("sendTime", msg.getSendTime());//接受短信时间
			//json.put("smsParam", msg.getSmsParam());
			json.put("sourceAddr", msg.getSourceAddr());//短信来源手机号
			System.out.println("-----json: "+json);
			list.add(json);
		}
		
		return list;
		
	}

}
