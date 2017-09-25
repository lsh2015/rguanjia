package com.yisi.business.common;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yisi.framework.common.ReturnCode;
import com.yisi.framework.result.IResult;
import com.yisi.tools.sms.RestSmslTool;
import com.yisi.tools.sms.entity.YsSmscodeEntity;


/**
 * 通用接口
 * 
 * @author baishui
 * QQ/微信：1052202173
 * 2017年6月22日 下午10:36:03
 *
 * com.yisi.business.common.CommonIntf.java
 */
@Controller
@RequestMapping("/commonIntf")
public class CommonIntf extends com.yisi.framework.common.BaseIntfController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CommonIntf.class);

	 /** 
     *  
     * @api {get} /rest/commonIntf/sendMessage 获取短信验证码
     * @apiName sendMessage  
     * @apiGroup Common 
     * @apiVersion 1.0.0 
     * @apiDescription 根据手机号码返回短信验证码
     *  
     * @apiParam {String} mobile 手机号码  
     *  
     * @apiUse RETURN_MESSAGE
     * @apiSuccess {String} model 验证码
     * 
     * @apiSuccessExample Success-Response: 
     *  HTTP/1.1 200 OK 
     * {
     * 	"model": "760428",
     *	"success": true,
     *	"errorMessage": null,
     *	"resultCode": 200
	 * }
     *  
     *  @apiError 301 对应<code>301</code> 手机号码为空  
     *  @apiError 302 对应<code>302</code> 短信发送失败  
     *  @apiErrorExample {json} Error-Response: 
     *  手机号码为空
     * {
     * 	"model": null,
     *	"success": false,
     *	"errorMessage": 手机号码为空,
     *	"resultCode": 301
	 * }
	* @apiUse ERROR_405
     */  
	@RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
	@ResponseBody
	public IResult sendMessage(String mobile) {
		if(StringUtil.isEmpty(mobile)  ){
			return errResult(ReturnCode.CODE301);	
		}
		
		String content = "" + ((int) (Math.random() * 1000000));
		
		// 新的短信验证码发送
		String[] sendMmessage = new String[] { content, "3" };
		String status = RestSmslTool.getInstance().sendMessage(mobile,sendMmessage);
		if (!status.equals("success")) {
			return errResult(ReturnCode.CODE302);	
		} else {
		
			/**
			 * 短信验证码是本地验证 还是服务器验证 服务器验证保存本地
			*/
			YsSmscodeEntity smsCode = new YsSmscodeEntity();
			smsCode.setMobile(mobile);
			smsCode.setCodeType("1");
			smsCode.setCreateTime(new Date());
			smsCode.setStatus(1);
			smsCode.setVaildCode(content);
			systemService.save(smsCode);
			
			return successResult(content);
		}

	}
	

	 /** 
     * 
     * @api {post} /rest/commonIntf/uploadImg 上传图片接口 
     * @apiName uploadImg  
     * @apiGroup Common 
     * @apiVersion 1.0.0 
     * @apiDescription 上传图片接口,返回绝对路径,都是指定以png后辍结尾
     *  
     * @apiParam {MultipartFile} fileName 文件数据流
     *  
     * @apiUse RETURN_MESSAGE
     * @apiSuccess {String} viewPath 文件预览路径 
     * @apiSuccess {String} filePath 文件保存的绝对路径 
     * @apiSuccessExample Success-Response: 
     *  HTTP/1.1 200 OK 
     * {
  	 *	"model": {
     *		"filePath": "/upload/sc/images/20161227005210KOI5P4ew.png",
     *		"viewPath": "http://127.0.0.1:90/upload/sc/images/20161227005210KOI5P4ew.png"
     *	},
     *	"success": true,
     *	"errorMessage": null,
  	 *	"resultCode": 200
	 *  }
     *   
     *  @apiError 305 对应<code>305</code> 图片保存失败  
     *  @apiUse ERROR_405
     */  
	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	@ResponseBody
	public IResult<?> uploadImg(@RequestParam MultipartFile  fileName,
			HttpServletRequest request){
	
		// 获取web应用根路径,也可以直接指定服务器任意盘符路径
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		
		//保存在项目的路径上
		String savePath = "/upload/cc/images/";
		
		File file1 = new File(rootPath + savePath);
		if (!file1.exists()) {
			file1.mkdirs();
		}
		// 文件真实文件名
//		String fileName = fromFile.getFileName();
//		String extend = FileUtils.getExtend(fileName);// 获取文件扩展名
		

		
		int fileSize = 5*1024*1204;
		// 我们一般会根据某种命名规则对其进行重命名
		String saveFileName = "";
//		String fileprefixName = FileUtils.getFilePrefix(fileName);
		String noextfilename = DateUtils.getDataString(DateUtils.yyyymmddhhmmss) + StringUtil.random(8);// 自定义文件名称
		saveFileName = noextfilename + ".png";// 自定义文件名称
		
		File fileToCreate = new File(rootPath + savePath, saveFileName);

		// 检查同名文件是否存在,不存在则将文件流写入文件磁盘系统
		FileOutputStream os = null;
		try {
			
			
			os = new FileOutputStream(fileToCreate, false);
			os.write(fileName.getBytes());
//			os.write(fromFile.getFileData().getBytes());
			os.flush();
		} catch (Exception e) {
			logger.info("save file error,freespace=" +fileToCreate.getParentFile().getFreeSpace(),e);
			return errResult(ReturnCode.CODE305);
		}finally{
			IOUtils.closeQuietly(os);
		}

		String serviceUrl = ResourceUtil.getConfigByName("service.url");
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("filePath", savePath + saveFileName);
		resultMap.put("viewPath", serviceUrl + savePath + saveFileName);
		return successResult(resultMap);
	}
	
	
	 /** 
     *  
     *  {get} /rest/baseIntf/areaList 地区列表
     * @apiName areaList  
     * @apiGroup Base 
     * @apiVersion 1.0.0 
     * @apiDescription 地区列表
     * 
     * @apiParam {Integer} [hot] 热门分类  1：热门分类
     *  
     * @apiUse RETURN_MESSAGE
     * @apiSuccess {Integer} id 地区ID
     * @apiSuccess {String} areaName 地区名称
     * @apiSuccess {String} pingyin 首字母拼音
     * @apiSuccess {String} hot 1:热门 0:普通
     * @apiSuccess {List} model 验证码
     * 
     * @apiSuccessExample Success-Response: 
     *  HTTP/1.1 200 OK 
     * {
     * 	"model": "[
     *  {
     *       "id": 1,
     *       "areaName": "深圳"
     *   },
     *   {
     *       "id": 2,
     *       "areaName": "广州"
     *   }
     * ]", 
     *	"success": true,
     *	"errorMessage": null,
     *	"resultCode": 200
	 * }
     *
	 * @apiUse ERROR_405
     */  
	@RequestMapping(value = "/areaList", method = RequestMethod.GET)
	@ResponseBody
	public IResult areaList(Integer hot) {
		String sql = " select id,area_name areaName,pingyin,hot from t_sc_area  ";
		if(null != hot){
			sql += " where hot =" + hot ;
		}
		
		List<Map<String,Object>> cateGroyList = systemService.findForJdbc(sql);
		return successResult(cateGroyList);

	}
	
	/** 
	 *  
	 * @api {get} /rest/commonIntf/dicList 词典列表
	 * @apiName dicList  
	 * @apiGroup Common 
	 * @apiVersion 1.0.0 
	 * @apiDescription 词典列表
	 * 
	 * @apiParam {String} dicCode 词典代码
	 *  
	 * @apiUse RETURN_MESSAGE
	 * @apiSuccess {Integer} id 地区ID
	 * @apiSuccess {String} code 词典代码
	 * @apiSuccess {String} name 词典名称
	 * 
	 * @apiSuccessExample Success-Response: 
	 *  HTTP/1.1 200 OK 
	 * {
	 * 	"model": "[
	 *  {
	 *       "id": 1,
	 *       "code": "1"
	 *       "name": "深圳地区"
	 *   }
	 * ]", 
	 *	"success": true,
	 *	"errorMessage": null,
	 *	"resultCode": 200
	 * }
	 *
	 * @apiUse ERROR_405
	 */  
	@RequestMapping(value = "/dicList", method = RequestMethod.GET)
	@ResponseBody
	public IResult dicList(String dicCode) {
		if(StringUtils.isBlank(dicCode)){
			return errResultAsString("词典代码为空");
		}
		String sql = " select id, typecode code, typename name from t_s_type "
				   + " where typegroupid =(		"
				   + "		select  id from t_s_typegroup 	"
				   + "      where typegroupcode= ?) ";
		
		List<Map<String,Object>> cateGroyList = systemService.findForJdbc(sql,dicCode);
		return successResult(cateGroyList);
		
	}
	
	/** 
	 *  
	 * @api {get} /rest/commonIntf/categroyList 分类列表
	 * @apiName categroyList  
	 * @apiGroup Common 
	 * @apiVersion 1.0.0 
	 * @apiDescription 分类列表
	 * 
	 * @apiParam {String} code 上级分类代码
	 *  
	 * @apiUse RETURN_MESSAGE
	 * @apiSuccess {Integer} id 分类ID
	 * @apiSuccess {String} code 分类代码
	 * @apiSuccess {String} name 分类名称
	 * @apiSuccess {String} image 分类图片
	 * @apiSuccess {String} parent 分类上级
	 * 
	 * @apiSuccessExample Success-Response: 
	 *  HTTP/1.1 200 OK 
	 * {
	 * 	"model": "[
	 *  {
	 *       "id": 1,
	 *       "code": "A01A01"
	 *       "name": "深圳地区"
	 *       "image": "upload\image\11.png"
	 *       "parent": "A01"
	 *   }
	 * ]", 
	 *	"success": true,
	 *	"errorMessage": null,
	 *	"resultCode": 200
	 * }
	 *
	 * @apiUse ERROR_405
	 */  
	@RequestMapping(value = "/categroyList", method = RequestMethod.GET)
	@ResponseBody
	public IResult categroyList(String code) {
		if(StringUtils.isBlank(code)){
			return errResultAsString("分类代码为空");
		}
		String sql = " select  id,code,name,CONCAT('" + serverUrl + "/' ,image) image,parent_code parent from t_s_category	"
				   + "      where parent_code= ?  ";
		
		List<Map<String,Object>> cateGroyList = systemService.findForJdbc(sql,code);
		return successResult(cateGroyList);
		
	}
	
	
	
	
	 /** 
     *  
     * {post} /rest/baseIntf/gettui 个推参数定义 
     * @apiName getui  
     * @apiGroup Base 
     * @apiVersion 1.0.0 
     * @apiDescription 个推参数定义 
     *  
     * @apiSuccess {String} notifyType  通知类型 1:活动公告    2：系统通知  3订单通知 前台那有问题没 
     * @apiSuccess {String} openType  打开类型 101：活动公告，进入h5  201:审核通知，进入审核界面
     *                                      202：新增推荐人, 203:用户点赞能知，进入个人主页
     *                                      204：提现审核通知，进入提现详情 205:退款通知  206:服务驳回 
	 *  									207：同意退款 208：拒绝退款
	 *  									209:用户关注  210：取消关注
     *                                      301：订单通知 进入订单详情  302：订单通知 进入服务详情
     *                                       
     * @apiSuccess {String} title 标题
     * @apiSuccess {String} content 内容 
     * @apiSuccess {String} image 图标 
     * @apiSuccess {Integer} userId 推送人ID
     * @apiSuccess {String}  date 通知时间  
     * @apiSuccess {String}  orderId 订单ID  
     * @apiSuccess {String}  withdrawId 提现ID  
     * @apiSuccess {String}  url 地址  
     */  

}
