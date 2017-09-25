package com.yisi.tools.sms.service;
import org.jeecgframework.core.common.service.CommonService;

public interface CcSmscodeServiceI extends CommonService{
	
 	/**
 	 * 判断手机验证码是否正确
 	 * @param mobile
 	 * @param code
 	 * @param minute
 	 * @return
 	 */
 	public Boolean isTrueCode(String mobile,String code,Integer minute);
 	
}
