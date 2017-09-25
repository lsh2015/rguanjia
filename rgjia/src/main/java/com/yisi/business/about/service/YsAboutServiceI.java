package com.yisi.business.about.service;
import com.yisi.business.about.entity.YsAboutEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface YsAboutServiceI extends CommonService{
	
 	public void delete(YsAboutEntity entity) throws Exception;
 	
 	public Serializable save(YsAboutEntity entity) throws Exception;
 	
 	public void saveOrUpdate(YsAboutEntity entity) throws Exception;
 	
}
