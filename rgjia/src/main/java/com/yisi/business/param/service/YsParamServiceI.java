package com.yisi.business.param.service;
import com.yisi.business.param.entity.YsParamEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface YsParamServiceI extends CommonService{
	
 	public void delete(YsParamEntity entity) throws Exception;
 	
 	public Serializable save(YsParamEntity entity) throws Exception;
 	
 	public void saveOrUpdate(YsParamEntity entity) throws Exception;
 	
 	
}
