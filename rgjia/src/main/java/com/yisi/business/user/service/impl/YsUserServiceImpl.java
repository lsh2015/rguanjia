package com.yisi.business.user.service.impl;
import com.yisi.business.user.service.YsUserServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.yisi.business.user.entity.YsUserEntity;
import com.yisi.business.user.entity.YsUserAddressEntity;
import com.yisi.business.user.entity.YsUserBankEntity;
import com.yisi.business.user.entity.YsUserDegreeEntity;
import com.yisi.business.user.entity.YsUserImagesEntity;
import com.yisi.business.user.entity.YsUserWorkEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("ysUserService")
@Transactional
public class YsUserServiceImpl extends CommonServiceImpl implements YsUserServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((YsUserEntity)entity);
 	}
	
	public void addMain(YsUserEntity ysUser,
	        List<YsUserAddressEntity> ysUserAddressList,List<YsUserBankEntity> ysUserBankList,List<YsUserDegreeEntity> ysUserDegreeList,List<YsUserImagesEntity> ysUserImagesList,List<YsUserWorkEntity> ysUserWorkList){
			//保存主信息
			this.save(ysUser);
		
			/**保存-用户地址*/
			for(YsUserAddressEntity ysUserAddress:ysUserAddressList){
				//外键设置
				ysUserAddress.setYsUser(ysUser);
				this.save(ysUserAddress);
			}
			/**保存-用户银行*/
			for(YsUserBankEntity ysUserBank:ysUserBankList){
				//外键设置
				ysUserBank.setYsUser(ysUser);
				this.save(ysUserBank);
			}
			/**保存-用户学历*/
			for(YsUserDegreeEntity ysUserDegree:ysUserDegreeList){
				//外键设置
				ysUserDegree.setYsUser(ysUser);
				this.save(ysUserDegree);
			}
			/**保存-用户图片*/
			for(YsUserImagesEntity ysUserImages:ysUserImagesList){
				//外键设置
				ysUserImages.setYsUser(ysUser);
				this.save(ysUserImages);
			}
			/**保存-用户工作*/
			for(YsUserWorkEntity ysUserWork:ysUserWorkList){
				//外键设置
				ysUserWork.setYsUser(ysUser);
				this.save(ysUserWork);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(ysUser);
	}

	
	public void updateMain(YsUserEntity ysUser,
	        List<YsUserAddressEntity> ysUserAddressList,List<YsUserBankEntity> ysUserBankList,List<YsUserDegreeEntity> ysUserDegreeList,List<YsUserImagesEntity> ysUserImagesList,List<YsUserWorkEntity> ysUserWorkList) {
		//保存主表信息
		this.saveOrUpdate(ysUser);
		//===================================================================================
		//获取参数
		Object id0 = ysUser.getId();
		Object id1 = ysUser.getId();
		Object id2 = ysUser.getId();
		Object id3 = ysUser.getId();
		Object id4 = ysUser.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-用户地址
	    String hql0 = "from YsUserAddressEntity where 1 = 1 AND uSER_ID = ? ";
	    List<YsUserAddressEntity> ysUserAddressOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-用户地址
		if(ysUserAddressList!=null&&ysUserAddressList.size()>0){
		for(YsUserAddressEntity oldE:ysUserAddressOldList){
			boolean isUpdate = false;
				for(YsUserAddressEntity sendE:ysUserAddressList){
					//需要更新的明细数据-用户地址
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-用户地址
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-用户地址
			for(YsUserAddressEntity ysUserAddress:ysUserAddressList){
				if(oConvertUtils.isEmpty(ysUserAddress.getId())){
					//外键设置
					ysUserAddress.setYsUser(ysUser);
					this.save(ysUserAddress);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-用户银行
	    String hql1 = "from YsUserBankEntity where 1 = 1 AND uSER_ID = ? ";
	    List<YsUserBankEntity> ysUserBankOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-用户银行
		if(ysUserBankList!=null&&ysUserBankList.size()>0){
		for(YsUserBankEntity oldE:ysUserBankOldList){
			boolean isUpdate = false;
				for(YsUserBankEntity sendE:ysUserBankList){
					//需要更新的明细数据-用户银行
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-用户银行
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-用户银行
			for(YsUserBankEntity ysUserBank:ysUserBankList){
				if(oConvertUtils.isEmpty(ysUserBank.getId())){
					//外键设置
					ysUserBank.setYsUser(ysUser);
					this.save(ysUserBank);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-用户学历
	    String hql2 = "from YsUserDegreeEntity where 1 = 1 AND uSER_ID = ? ";
	    List<YsUserDegreeEntity> ysUserDegreeOldList = this.findHql(hql2,id2);
		//2.筛选更新明细数据-用户学历
		if(ysUserDegreeList!=null&&ysUserDegreeList.size()>0){
		for(YsUserDegreeEntity oldE:ysUserDegreeOldList){
			boolean isUpdate = false;
				for(YsUserDegreeEntity sendE:ysUserDegreeList){
					//需要更新的明细数据-用户学历
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-用户学历
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-用户学历
			for(YsUserDegreeEntity ysUserDegree:ysUserDegreeList){
				if(oConvertUtils.isEmpty(ysUserDegree.getId())){
					//外键设置
					ysUserDegree.setYsUser(ysUser);
					this.save(ysUserDegree);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-用户图片
	    String hql3 = "from YsUserImagesEntity where 1 = 1 AND uSER_ID = ? ";
	    List<YsUserImagesEntity> ysUserImagesOldList = this.findHql(hql3,id3);
		//2.筛选更新明细数据-用户图片
		if(ysUserImagesList!=null&&ysUserImagesList.size()>0){
		for(YsUserImagesEntity oldE:ysUserImagesOldList){
			boolean isUpdate = false;
				for(YsUserImagesEntity sendE:ysUserImagesList){
					//需要更新的明细数据-用户图片
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-用户图片
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-用户图片
			for(YsUserImagesEntity ysUserImages:ysUserImagesList){
				if(oConvertUtils.isEmpty(ysUserImages.getId())){
					//外键设置
					ysUserImages.setYsUser(ysUser);
					this.save(ysUserImages);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-用户工作
	    String hql4 = "from YsUserWorkEntity where 1 = 1 AND uSER_ID = ? ";
	    List<YsUserWorkEntity> ysUserWorkOldList = this.findHql(hql4,id4);
		//2.筛选更新明细数据-用户工作
		if(ysUserWorkList!=null&&ysUserWorkList.size()>0){
		for(YsUserWorkEntity oldE:ysUserWorkOldList){
			boolean isUpdate = false;
				for(YsUserWorkEntity sendE:ysUserWorkList){
					//需要更新的明细数据-用户工作
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-用户工作
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-用户工作
			for(YsUserWorkEntity ysUserWork:ysUserWorkList){
				if(oConvertUtils.isEmpty(ysUserWork.getId())){
					//外键设置
					ysUserWork.setYsUser(ysUser);
					this.save(ysUserWork);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(ysUser);
	}

	
	public void delMain(YsUserEntity ysUser) {
		//删除主表信息
		this.delete(ysUser);
		//===================================================================================
		//获取参数
		Object id0 = ysUser.getId();
		Object id1 = ysUser.getId();
		Object id2 = ysUser.getId();
		Object id3 = ysUser.getId();
		Object id4 = ysUser.getId();
		//===================================================================================
		//删除-用户地址
	    String hql0 = "from YsUserAddressEntity where 1 = 1 AND uSER_ID = ? ";
	    List<YsUserAddressEntity> ysUserAddressOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(ysUserAddressOldList);
		//===================================================================================
		//删除-用户银行
	    String hql1 = "from YsUserBankEntity where 1 = 1 AND uSER_ID = ? ";
	    List<YsUserBankEntity> ysUserBankOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(ysUserBankOldList);
		//===================================================================================
		//删除-用户学历
	    String hql2 = "from YsUserDegreeEntity where 1 = 1 AND uSER_ID = ? ";
	    List<YsUserDegreeEntity> ysUserDegreeOldList = this.findHql(hql2,id2);
		this.deleteAllEntitie(ysUserDegreeOldList);
		//===================================================================================
		//删除-用户图片
	    String hql3 = "from YsUserImagesEntity where 1 = 1 AND uSER_ID = ? ";
	    List<YsUserImagesEntity> ysUserImagesOldList = this.findHql(hql3,id3);
		this.deleteAllEntitie(ysUserImagesOldList);
		//===================================================================================
		//删除-用户工作
	    String hql4 = "from YsUserWorkEntity where 1 = 1 AND uSER_ID = ? ";
	    List<YsUserWorkEntity> ysUserWorkOldList = this.findHql(hql4,id4);
		this.deleteAllEntitie(ysUserWorkOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(YsUserEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(YsUserEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(YsUserEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,YsUserEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{grade}",String.valueOf(t.getGrade()));
 		sql  = sql.replace("#{grade_name}",String.valueOf(t.getGradeName()));
 		sql  = sql.replace("#{sesame_point}",String.valueOf(t.getSesamePoint()));
 		sql  = sql.replace("#{invite_code}",String.valueOf(t.getInviteCode()));
 		sql  = sql.replace("#{agreement}",String.valueOf(t.getAgreement()));
 		sql  = sql.replace("#{visitor}",String.valueOf(t.getVisitor()));
 		sql  = sql.replace("#{introduction}",String.valueOf(t.getIntroduction()));
 		sql  = sql.replace("#{advantage}",String.valueOf(t.getAdvantage()));
 		sql  = sql.replace("#{experience}",String.valueOf(t.getExperience()));
 		sql  = sql.replace("#{perfect}",String.valueOf(t.getPerfect()));
 		sql  = sql.replace("#{is_deposit}",String.valueOf(t.getIsDeposit()));
 		sql  = sql.replace("#{reffer_num}",String.valueOf(t.getRefferNum()));
 		sql  = sql.replace("#{parent_id}",String.valueOf(t.getParentId()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{mobile}",String.valueOf(t.getMobile()));
 		sql  = sql.replace("#{user_name}",String.valueOf(t.getUserName()));
 		sql  = sql.replace("#{email}",String.valueOf(t.getEmail()));
 		sql  = sql.replace("#{image}",String.valueOf(t.getImage()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{birthday}",String.valueOf(t.getBirthday()));
 		sql  = sql.replace("#{create_ip}",String.valueOf(t.getCreateIp()));
 		sql  = sql.replace("#{create_city}",String.valueOf(t.getCreateCity()));
 		sql  = sql.replace("#{qq_number}",String.valueOf(t.getQqNumber()));
 		sql  = sql.replace("#{weibo_number}",String.valueOf(t.getWeiboNumber()));
 		sql  = sql.replace("#{weixin_number}",String.valueOf(t.getWeixinNumber()));
 		sql  = sql.replace("#{qq_id}",String.valueOf(t.getQqId()));
 		sql  = sql.replace("#{weibo_id}",String.valueOf(t.getWeiboId()));
 		sql  = sql.replace("#{weixin_id}",String.valueOf(t.getWeixinId()));
 		sql  = sql.replace("#{zfb}",String.valueOf(t.getZfb()));
 		sql  = sql.replace("#{weixi}",String.valueOf(t.getWeixi()));
 		sql  = sql.replace("#{real_name}",String.valueOf(t.getRealName()));
 		sql  = sql.replace("#{company_auth}",String.valueOf(t.getCompanyAuth()));
 		sql  = sql.replace("#{password_one}",String.valueOf(t.getPasswordOne()));
 		sql  = sql.replace("#{password_two}",String.valueOf(t.getPasswordTwo()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{nick_name}",String.valueOf(t.getNickName()));
 		sql  = sql.replace("#{longitude}",String.valueOf(t.getLongitude()));
 		sql  = sql.replace("#{latitude}",String.valueOf(t.getLatitude()));
 		sql  = sql.replace("#{clinet_id}",String.valueOf(t.getClinetId()));
 		sql  = sql.replace("#{trouble}",String.valueOf(t.getTrouble()));
 		sql  = sql.replace("#{hiding}",String.valueOf(t.getHiding()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{user_type}",String.valueOf(t.getUserType()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}