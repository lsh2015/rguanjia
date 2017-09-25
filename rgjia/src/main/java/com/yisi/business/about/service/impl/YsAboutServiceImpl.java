package com.yisi.business.about.service.impl;
import com.yisi.business.about.service.YsAboutServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.yisi.business.about.entity.YsAboutEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("ysAboutService")
@Transactional
public class YsAboutServiceImpl extends CommonServiceImpl implements YsAboutServiceI {

	
 	public void delete(YsAboutEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(YsAboutEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(YsAboutEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(YsAboutEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(YsAboutEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(YsAboutEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(YsAboutEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("project_name", t.getProjectName());
		map.put("project_url", t.getProjectUrl());
		map.put("about", t.getAbout());
		map.put("synopsis", t.getSynopsis());
		map.put("logo", t.getLogo());
		map.put("images", t.getImages());
		map.put("service_tel", t.getServiceTel());
		map.put("qq_number", t.getQqNumber());
		map.put("weixin_number", t.getWeixinNumber());
		map.put("weixin_image", t.getWeixinImage());
		map.put("mail", t.getMail());
		map.put("weibo_number", t.getWeiboNumber());
		map.put("project_address", t.getProjectAddress());
		map.put("legal_person", t.getLegalPerson());
		map.put("business_license", t.getBusinessLicense());
		map.put("license_no", t.getLicenseNo());
		map.put("id_number", t.getIdNumber());
		map.put("remark", t.getRemark());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,YsAboutEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{project_name}",String.valueOf(t.getProjectName()));
 		sql  = sql.replace("#{project_url}",String.valueOf(t.getProjectUrl()));
 		sql  = sql.replace("#{about}",String.valueOf(t.getAbout()));
 		sql  = sql.replace("#{synopsis}",String.valueOf(t.getSynopsis()));
 		sql  = sql.replace("#{logo}",String.valueOf(t.getLogo()));
 		sql  = sql.replace("#{images}",String.valueOf(t.getImages()));
 		sql  = sql.replace("#{service_tel}",String.valueOf(t.getServiceTel()));
 		sql  = sql.replace("#{qq_number}",String.valueOf(t.getQqNumber()));
 		sql  = sql.replace("#{weixin_number}",String.valueOf(t.getWeixinNumber()));
 		sql  = sql.replace("#{weixin_image}",String.valueOf(t.getWeixinImage()));
 		sql  = sql.replace("#{mail}",String.valueOf(t.getMail()));
 		sql  = sql.replace("#{weibo_number}",String.valueOf(t.getWeiboNumber()));
 		sql  = sql.replace("#{project_address}",String.valueOf(t.getProjectAddress()));
 		sql  = sql.replace("#{legal_person}",String.valueOf(t.getLegalPerson()));
 		sql  = sql.replace("#{business_license}",String.valueOf(t.getBusinessLicense()));
 		sql  = sql.replace("#{license_no}",String.valueOf(t.getLicenseNo()));
 		sql  = sql.replace("#{id_number}",String.valueOf(t.getIdNumber()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("t_ys_about",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}