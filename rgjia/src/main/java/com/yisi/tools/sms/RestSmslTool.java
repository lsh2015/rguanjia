package com.yisi.tools.sms;

import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

/**
 * 
 * @author baishui
 * QQ/微信：1052202173
 * 2017年6月22日 下午10:34:15
 *
 * com.yisi.tools.sms.RestSmslTool.java
 */
public class RestSmslTool {

	private static final Logger LOG = LogManager.getLogger(RestSmslTool.class);
	
	private static  RestSmslTool instance = new RestSmslTool();

	static CCPRestSmsSDK restAPI = null;

	public static RestSmslTool getInstance() {
		return instance;
	}

	public RestSmslTool() {
		init();
	}

	public void init() {
		LOG.info("初始化融联云发送API");
		String restUrl = "app.cloopen.com";
		String restPort = "8883";
		
//		String acountSid = "8a216da85557cb1501555c68afe60744";
//		String authToken = "a01d2755b1cc414d8aae33703a31d585";
//		String appId = "8a216da85557cb1501555c68b046074a";
		
//		String acountSid = "8aaf0708582eefe901583a1d093e0457";
//		String authToken = "a2e24efe3c4b4b2d86871acef77a6322";
//		String appId = "8aaf0708582eefe901583a1d098c045c";
		
		String acountSid = ResourceUtil.getConfigByName("sms.acount.sid");
		String authToken = ResourceUtil.getConfigByName("sms.authtoken");
		String appId = ResourceUtil.getConfigByName("sms.appId");
		

		restAPI = new CCPRestSmsSDK();

		// ******************************注释*********************************************
		// *初始化服务器地址和端口 *
		// *沙盒环境（用于应用开发调试）：restAPI.init("sandboxapp.cloopen.com", "8883");*
		// *生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com", "8883"); *
		// *******************************************************************************
		restAPI.init(restUrl, restPort);

		// ******************************注释*********************************************
		// *初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN *
		// *ACOUNT SID和AUTH TOKEN在登陆官网后，在“应用-管理控制台”中查看开发者主账号获取*
		// *参数顺序：第一个参数是ACOUNT SID，第二个参数是AUTH TOKEN。 *
		// *******************************************************************************
		restAPI.setAccount(acountSid, authToken);

		// ******************************注释*********************************************
		// *初始化应用ID *
		// *测试开发可使用“测试Demo”的APP ID，正式上线需要使用自己创建的应用的App ID *
		// *应用ID的获取：登陆官网，在“应用-应用列表”，点击应用名称，看应用详情获取APP ID*
		// *******************************************************************************
		restAPI.setAppId(appId);
	}

	public CCPRestSmsSDK getRestAPI() {
		LOG.info("获取融联云发送API");
		if (null == restAPI) {
			new RestSmslTool();
		}
		return restAPI;
	}
	
	/**
	 * 
	 * 功能说明：融联云短信发送
	 *
	 * @author: 白水
	 * @date  : 2015年12月20日
	 * @param mobile  手机号码
	 * @param message  发送的内容，根据模指定数组参数
	 * @return 发送成功：success 其它发送失败
	 */
	public String sendMessage(String mobile, String[] message){
		LOG.info("发送融联云短信API");
		//茶信ID
//		String modelid = "129587";
		//String modelid = "146583";
		String modelid = "158792";
		
		HashMap<String, Object> result = getRestAPI().sendTemplateSMS(
				mobile, modelid, message);
		String returnStr = "success";
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			LOG.info("SDKTestGetSubAccounts result=" + result);
		}else{
			//异常返回输出错误码和错误信息
			LOG.error("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
			returnStr = "错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg");
		}
		
		return returnStr;
	}
	

	public static void main(String[] args) {
		HashMap<String, Object> result = getInstance().getRestAPI().sendTemplateSMS(
				"13723410575", "158792", new String[] { "6565" });

		System.out.println("SDKTestGetSubAccounts result=" + result);
	}
}
