package com.yisi.business.user.service;
import com.yisi.business.user.entity.YsUserEntity;
import com.yisi.business.user.entity.YsUserAddressEntity;
import com.yisi.business.user.entity.YsUserBankEntity;
import com.yisi.business.user.entity.YsUserDegreeEntity;
import com.yisi.business.user.entity.YsUserImagesEntity;
import com.yisi.business.user.entity.YsUserWorkEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface YsUserServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(YsUserEntity ysUser,
	        List<YsUserAddressEntity> ysUserAddressList,List<YsUserBankEntity> ysUserBankList,List<YsUserDegreeEntity> ysUserDegreeList,List<YsUserImagesEntity> ysUserImagesList,List<YsUserWorkEntity> ysUserWorkList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(YsUserEntity ysUser,
	        List<YsUserAddressEntity> ysUserAddressList,List<YsUserBankEntity> ysUserBankList,List<YsUserDegreeEntity> ysUserDegreeList,List<YsUserImagesEntity> ysUserImagesList,List<YsUserWorkEntity> ysUserWorkList);
	public void delMain (YsUserEntity ysUser);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(YsUserEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(YsUserEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(YsUserEntity t);
}
