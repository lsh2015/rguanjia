package com.yisi.tools.sms.service.impl;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.ListUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yisi.tools.sms.entity.YsSmscodeEntity;
import com.yisi.tools.sms.service.CcSmscodeServiceI;

@Service("ccSmscodeService")
@Transactional
public class CcSmscodeServiceImpl extends CommonServiceImpl implements CcSmscodeServiceI {


	@Override
	public Boolean isTrueCode(String mobile, String code, Integer minute) {
		// TODO Auto-generated method stub
		int minCode = 5;
		if(null != minute && 0 != minute){
			minCode = Integer.valueOf(minute);
		}
		
		String hql = " from CcSmscodeEntity s where s.mobile = ? and vaildCode =? order by createTime desc ";
		List<YsSmscodeEntity> codeList = this.findHql(hql, mobile,code);
		if( ListUtils.isNullOrEmpty(codeList)){
			return false;
		}
		YsSmscodeEntity codeEntity = codeList.get(0);
		Date createTime = codeEntity.getCreateTime();
		Calendar create =  Calendar.getInstance();
		create.setTime(createTime);
		
		Calendar today =  Calendar.getInstance();
		
		//判断两个时间相隔分钟
		int mindiff = DateUtils.dateDiff('m',today,create);
		if(mindiff > minCode){
			return false;
		}
		
		return true;
	}
}