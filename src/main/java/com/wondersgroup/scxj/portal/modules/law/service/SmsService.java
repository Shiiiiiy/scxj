package com.wondersgroup.scxj.portal.modules.law.service;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Service;

import com.dfw.sms.client.Client;
import com.wondersgroup.scxj.portal.common.service.BaseService;
import com.wondersgroup.scxj.portal.modules.law.utils.TRSDemo;

@Service
public class SmsService extends BaseService{
	
	private static String ip = "sms.easttone.com"; // 服务端地址
	private static int port = 8080; // 服务端端口号
	private static String eid = "0001"; // 企业号
	private static String serviceNO = "0001"; // 服务号
	private static String password = "jianchayuan$%^123"; // 密码
	private static Client client = new Client(ip, port, serviceNO, eid, password);

	/**
	 * 发送（支持群发，多个号码之间以英文逗号隔开，最多支持100个号码，不能以逗号开头和结尾）
	 * @param mobile
	 * @param content
	 * @return
	 */
	public String send(String mobile,String content){
//		return client.sendSms(mobile, content);
		TRSDemo demo = new TRSDemo();
		return demo.insMessage(mobile, content);
	}

	/**
	 * 接收上行短信
	 * @return
	 */
	public String[] mo(){
		return client.receiveMo().split(";");
	}
	
	
	/**
	 * 查询状态报告
	 * @param msgId 查询所有短信的状态报告传参数"1"，查询单条短信状态报告传发送方法返回的msgId
	 * @return
	 */
	public String[] report(String msgId){
		String report = client.queryReport(msgId); 
		return report.split("\r\n");
	}

	
	public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
		
		SmsService demo = new SmsService();
		
		//发送测试
		String result = demo.send("13816825266", "测试");
		System.out.println(result);
		
		
		//群发测试
//		String result = demo.send("133****5823,186****2852", "09:34");
//		System.out.println(result);
		
		//接收上行短信测试
//		String[] mos = demo.mo();
//		for (String msg : mos) {
//			if(null != msg && msg.trim().length() > 0){
//				String[] mo = msg.split(",");
//				System.out.println(URLDecoder.decode(mo[2],"UTF-8"));
//			}
//		}
		
		//查询状态报告
//		String[] results = demo.report("1");
//		System.out.println("=============状态报告============");
//		for (String report : results) {
//			System.out.println(report);
//		}
//		String[] results = demo.report("1358405048261");
//		System.out.println("=============状态报告============");
//		for (String report : results) {
//			System.out.println(report);
//		}
		
	}
	
}
