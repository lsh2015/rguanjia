package com.yisi.business.about.intf;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yisi.business.about.entity.YsAboutEntity;
import com.yisi.framework.common.BaseIntfController;
import com.yisi.framework.common.ReturnCode;
import com.yisi.framework.result.IResult;
import com.yisi.tools.sms.RestSmslTool;
import com.yisi.tools.sms.entity.YsSmscodeEntity;


/**
 * 项目介绍接口
 * @author baishui
 * QQ/微信：1052202173
 * 2017年6月27日 下午5:13:52
 *
 * com.yisi.business.about.intf.YsAboutIntf.java
 */
@Controller
@RequestMapping("/ysAboutIntf")
public class YsAboutIntf extends  BaseIntfController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(YsAboutIntf.class);

	 /** 
	    * @apiDefine YsAboutEntity
		* @apiSuccess {Integer}  id id
		* @apiSuccess {String}  projectName 名称
		* @apiSuccess {String}  projectUrl 网址
		* @apiSuccess {String}  about 关于项目
		* @apiSuccess {String}  synopsis 简介
		* @apiSuccess {String}  logo logo
		* @apiSuccess {String}  images 公司图片
		* @apiSuccess {String}  serviceTel 客服电话
		* @apiSuccess {String}  qqNumber QQ
		* @apiSuccess {String}  weixinNumber 微信号
		* @apiSuccess {String}  weixinImage 微信二维码
		* @apiSuccess {String}  mail 邮箱
		* @apiSuccess {String}  weiboNumber 微博
		* @apiSuccess {String}  projectAddress 地址
		* @apiSuccess {String}  legalPerson 法人
		* @apiSuccess {String}  businessLicense 营业执照
		* @apiSuccess {String}  licenseNo 执照号
		* @apiSuccess {String}  idNumber 身份证号
		* @apiSuccess {String}  remark 备注
		*
	  **/
	
	/** 
	 * @api {GET} /rest/ysAboutIntf/ysAboutList 项目介绍列表
	 * @apiName ysAboutList
	 * @apiGroup YsAbout 
	 * @apiVersion 1.0.0 
	 * @apiDescription 项目介绍列表
	 *  
	 * 
	 * @apiUse RETURN_MESSAGE
	 * @apiSuccess {String} model 返回成功信息
	 * @apiUse YsAboutEntity
	 * @apiSuccessExample Success-Response: 
	 *  HTTP/1.1 200 OK 
	 * {
	 *  "result": {
	 *	"model": {
	 *		
	 * 	},
	 *	  "status": {
	 *	    "code": 200,
	 *	    "msg": "请求成功"
	 *	  }
	 *	}
	 */ 
	@RequestMapping(value = "/ysAboutList",method = RequestMethod.GET)
	@ResponseBody
	public IResult list() {
		String listSql = " select    ID   id,    PROJECT_NAME   projectName,    PROJECT_URL   projectUrl,    ABOUT   about,    SYNOPSIS   synopsis,    LOGO   logo,    IMAGES   images,    SERVICE_TEL   serviceTel,    QQ_NUMBER   qqNumber,    WEIXIN_NUMBER   weixinNumber,    WEIXIN_IMAGE   weixinImage,    MAIL   mail,    WEIBO_NUMBER   weiboNumber,    PROJECT_ADDRESS   projectAddress,    LEGAL_PERSON   legalPerson,    BUSINESS_LICENSE   businessLicense,    LICENSE_NO   licenseNo,    ID_NUMBER   idNumber,    REMARK   remark    "
					   + " from t_ys_about " ;
		List<Map<String,Object>> ysAboutList = systemService.findForJdbc(listSql);
		return successResult(ysAboutList);
	}
	
	/** 
	 * @api {GET} /rest/ysAboutIntf/getId 获取项目介绍信息
	 * @apiName getId
	 * @apiGroup YsAbout 
	 * @apiVersion 1.0.0 
	 * @apiDescription 获取项目介绍信息
	 *  
	 *  @apiParam {Integer}  id id
	 *  
	 * @apiUse RETURN_MESSAGE
	 * @apiSuccess {String} model 返回成功信息
	 * @apiUse YsAboutEntity
	 * @apiSuccessExample Success-Response: 
	 *  HTTP/1.1 200 OK 
	 * {
	 *  "result": {
	 *	"model": {
	 *		
	 * 	},
	 *	  "status": {
	 *	    "code": 200,
	 *	    "msg": "请求成功"
	 *	  }
	 *	}
	 */ 
	@RequestMapping(value = "/getId", method = RequestMethod.GET)
	@ResponseBody
	public IResult getId(String id) {
		if( null == id ){
			return errResultAsString("项目介绍ID为空");
		}
		
		String listSql = " select    ID   id,    PROJECT_NAME   projectName,    PROJECT_URL   projectUrl,    ABOUT   about,    SYNOPSIS   synopsis,    LOGO   logo,    IMAGES   images,    SERVICE_TEL   serviceTel,    QQ_NUMBER   qqNumber,    WEIXIN_NUMBER   weixinNumber,    WEIXIN_IMAGE   weixinImage,    MAIL   mail,    WEIBO_NUMBER   weiboNumber,    PROJECT_ADDRESS   projectAddress,    LEGAL_PERSON   legalPerson,    BUSINESS_LICENSE   businessLicense,    LICENSE_NO   licenseNo,    ID_NUMBER   idNumber,    REMARK   remark   "
					   + " from t_ys_about  where id = ? " ;
		Map<String,Object> ysAboutMap = systemService.findOneForJdbc(listSql,id);
		return successResult(ysAboutMap);
	}
	
	/** 
	 * @api {POST} /rest/ysAboutIntf/addYsAbout 添加项目介绍
	 * @apiName addYsAbout
	 * @apiGroup YsAbout  
	 * @apiVersion 1.0.0 
	 * @apiDescription 添加项目介绍
	 *  
	 * @apiParam {Integer}  id id
	 * @apiParam {String}  projectName 名称
	 * @apiParam {String}  projectUrl 网址
	 * @apiParam {String}  about 关于项目
	 * @apiParam {String}  synopsis 简介
	 * @apiParam {String}  logo logo
	 * @apiParam {String}  images 公司图片
	 * @apiParam {String}  serviceTel 客服电话
	 * @apiParam {String}  qqNumber QQ
	 * @apiParam {String}  weixinNumber 微信号
	 * @apiParam {String}  weixinImage 微信二维码
	 * @apiParam {String}  mail 邮箱
	 * @apiParam {String}  weiboNumber 微博
	 * @apiParam {String}  projectAddress 地址
	 * @apiParam {String}  legalPerson 法人
	 * @apiParam {String}  businessLicense 营业执照
	 * @apiParam {String}  licenseNo 执照号
	 * @apiParam {String}  idNumber 身份证号
	 * @apiParam {String}  remark 备注
	 * 
	 * @apiUse RETURN_MESSAGE
	 * @apiSuccess {String} model 返回成功信息
	 * @apiSuccessExample Success-Response: 
	 *  HTTP/1.1 200 OK 
	 * {
	 *  "result": {
	 *	"model": {
	 *		"添加成功"
	 * 	},
	 *	  "status": {
	 *	    "code": 200,
	 *	    "msg": "请求成功"
	 *	  }
	 *	}
	 * 
	 */ 
	@RequestMapping(value = "/addYsAbout",method = RequestMethod.POST)
	@ResponseBody
	public IResult addYsAbout(YsAboutEntity ysAbout ) {
		systemService.save(ysAbout);
		return successResult("项目介绍添加成功");
	}	
	
	/** 
	 * @api {POST} /rest/ysAboutIntf/updateYsAbout 修改项目介绍
	 * @apiName updateYsAbout
	 * @apiGroup YsAbout 
	 * @apiVersion 1.0.0 
	 * @apiDescription 修改项目介绍
	 *  
	 * @apiParam {Integer}  id id
	 * @apiParam {String}  projectName 名称
	 * @apiParam {String}  projectUrl 网址
	 * @apiParam {String}  about 关于项目
	 * @apiParam {String}  synopsis 简介
	 * @apiParam {String}  logo logo
	 * @apiParam {String}  images 公司图片
	 * @apiParam {String}  serviceTel 客服电话
	 * @apiParam {String}  qqNumber QQ
	 * @apiParam {String}  weixinNumber 微信号
	 * @apiParam {String}  weixinImage 微信二维码
	 * @apiParam {String}  mail 邮箱
	 * @apiParam {String}  weiboNumber 微博
	 * @apiParam {String}  projectAddress 地址
	 * @apiParam {String}  legalPerson 法人
	 * @apiParam {String}  businessLicense 营业执照
	 * @apiParam {String}  licenseNo 执照号
	 * @apiParam {String}  idNumber 身份证号
	 * @apiParam {String}  remark 备注
	 * 
	 * @apiUse RETURN_MESSAGE
	 * @apiSuccess {String} model 返回成功信息
	 * @apiSuccessExample Success-Response: 
	 *  HTTP/1.1 200 OK 
	 * {
	 *  "result": {
	 *	"model": {
	 *		"修改成功"
	 * 	},
	 *	  "status": {
	 *	    "code": 200,
	 *	    "msg": "请求成功"
	 *	  }
	 *	}
	 */ 
	@RequestMapping(value = "/updateYsAbout",method = RequestMethod.POST)
	@ResponseBody
	public IResult updateYsAbout(YsAboutEntity ysAbout ) {
		
		Integer id = ysAbout.getId();
		if( null == id ){
			return errResultAsString("项目介绍ID为空");
		}
		
		YsAboutEntity t = systemService.get(YsAboutEntity.class, id);
		
		if( null == t ){
			return errResultAsString("项目介绍ID不存在");
		}
		try {
			MyBeanUtils.copyBeanNotNull2Bean(ysAbout,t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		systemService.updateEntitie(t);
		return successResult("项目介绍修改成功");
	}
	
	/** 
	 * @api {POST} /rest/ysAboutIntf/deleteYsAbout 删除项目介绍
	 * @apiName deleteYsAbout
	 * @apiGroup YsAbout 
	 * @apiVersion 1.0.0 
	 * @apiDescription 删除项目介绍
	 *  
	 * @apiParam {Integer} id 项目介绍ID
	 * 
	 * @apiUse RETURN_MESSAGE
	 * @apiSuccess {String} model 返回成功信息
	 * @apiSuccessExample Success-Response: 
	 *  HTTP/1.1 200 OK 
	 * {
	 *  "result": {
	 *	"model": {
	 *		"删除成功"
	 * 	},
	 *	  "status": {
	 *	    "code": 200,
	 *	    "msg": "请求成功"
	 *	  }
	 *	}
	 */ 
	@RequestMapping(value = "/deleteYsAbout",method = RequestMethod.POST)
	@ResponseBody
	public IResult deleteYsAbout(YsAboutEntity ysAbout ) {
		
		Integer id = ysAbout.getId();
		if( null == id ){
			return errResultAsString("项目介绍ID为空");
		}
		String delSql = " delete from t_ys_about where id = ? ";
		systemService.executeSql(delSql,id);
		return successResult("项目介绍删除成功");
	}	
	
}
