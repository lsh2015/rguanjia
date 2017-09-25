package com.yisi.framework.common;


import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yisi.framework.result.IResult;
import com.yisi.framework.result.ResultSupport;



/**
 * 
 * 功能说明：基础接口类控制器，
 * @author baishui
 * @2016年6月27日 下午2:36:04
 *
 * @com.jzy.intf.common.BaseIntfController.java
 */
@Controller
@RequestMapping("/baseIntfController")
public class BaseIntfController extends BaseController {

	@Autowired
	protected SystemService systemService;
	
	
	protected String serverUrl = ResourceUtil.getConfigByName("service.url");
	/**
	 * 返回错误代码信息
	 * @param returnCode
	 * @return
	 */
	public IResult<?> errResult(ReturnCode returnCode){
		
		return ResultSupport.buildResult(returnCode);
	}
	/**
	 * 返回错误代码信息
	 * @param returnCode
	 * @return
	 */
	public IResult<?> errResult(int code,String message){
		
		return ResultSupport.buildResult(code,message);
	}
	
	/**
	 * 返回错误代码信息
	 * @param returnCode
	 * @return
	 */
	public IResult<?> errResultAsString(String message){
		
		return ResultSupport.buildResultMessage(message);
	}
	
	
	/**
	 * 返回正确信息
	 * @param returnCode
	 * @return
	 */
	public <T> IResult<?> successResult(T model){
		
		return  ResultSupport.buildResult(model);
	}
	
	

	
}
