package com.yisi.business.news.service;
import com.yisi.business.news.entity.YsNewsEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface YsNewsServiceI extends CommonService{
	
 	public void delete(YsNewsEntity entity) throws Exception;
 	
 	public Serializable save(YsNewsEntity entity) throws Exception;
 	
 	public void saveOrUpdate(YsNewsEntity entity) throws Exception;
 	
}
