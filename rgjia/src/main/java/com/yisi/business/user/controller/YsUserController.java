package com.yisi.business.user.controller;
import com.yisi.business.user.entity.YsUserEntity;
import com.yisi.business.user.service.YsUserServiceI;
import com.yisi.business.user.page.YsUserPage;
import com.yisi.business.user.entity.YsUserAddressEntity;
import com.yisi.business.user.entity.YsUserBankEntity;
import com.yisi.business.user.entity.YsUserDegreeEntity;
import com.yisi.business.user.entity.YsUserImagesEntity;
import com.yisi.business.user.entity.YsUserWorkEntity;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.IOException;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller
 * @Description: 用户管理
 * @author onlineGenerator
 * @date 2017-06-26 21:17:58
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ysUserController")
public class YsUserController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(YsUserController.class);

	@Autowired
	private YsUserServiceI ysUserService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 用户管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yisi/business/user/ysUserList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(YsUserEntity ysUser,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(YsUserEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ysUser);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ysUserService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除用户管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(YsUserEntity ysUser, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		ysUser = systemService.getEntity(YsUserEntity.class, ysUser.getId());
		String message = "用户管理删除成功";
		try{
			ysUserService.delMain(ysUser);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "用户管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除用户管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "用户管理删除成功";
		try{
			for(String id:ids.split(",")){
				YsUserEntity ysUser = systemService.getEntity(YsUserEntity.class,
				Integer.parseInt(id)
				);
				ysUserService.delMain(ysUser);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "用户管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加用户管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(YsUserEntity ysUser,YsUserPage ysUserPage, HttpServletRequest request) {
		List<YsUserAddressEntity> ysUserAddressList =  ysUserPage.getYsUserAddressList();
		List<YsUserBankEntity> ysUserBankList =  ysUserPage.getYsUserBankList();
		List<YsUserDegreeEntity> ysUserDegreeList =  ysUserPage.getYsUserDegreeList();
		List<YsUserImagesEntity> ysUserImagesList =  ysUserPage.getYsUserImagesList();
		List<YsUserWorkEntity> ysUserWorkList =  ysUserPage.getYsUserWorkList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			ysUserService.addMain(ysUser, ysUserAddressList,ysUserBankList,ysUserDegreeList,ysUserImagesList,ysUserWorkList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "用户管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新用户管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(YsUserEntity ysUser,YsUserPage ysUserPage, HttpServletRequest request) {
		List<YsUserAddressEntity> ysUserAddressList =  ysUserPage.getYsUserAddressList();
		List<YsUserBankEntity> ysUserBankList =  ysUserPage.getYsUserBankList();
		List<YsUserDegreeEntity> ysUserDegreeList =  ysUserPage.getYsUserDegreeList();
		List<YsUserImagesEntity> ysUserImagesList =  ysUserPage.getYsUserImagesList();
		List<YsUserWorkEntity> ysUserWorkList =  ysUserPage.getYsUserWorkList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			ysUserService.updateMain(ysUser, ysUserAddressList,ysUserBankList,ysUserDegreeList,ysUserImagesList,ysUserWorkList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新用户管理失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 用户管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(YsUserEntity ysUser, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ysUser.getId())) {
			ysUser = ysUserService.getEntity(YsUserEntity.class, ysUser.getId());
			req.setAttribute("ysUserPage", ysUser);
		}
		return new ModelAndView("com/yisi/business/user/ysUser-add");
	}
	
	/**
	 * 用户管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(YsUserEntity ysUser, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ysUser.getId())) {
			ysUser = ysUserService.getEntity(YsUserEntity.class, ysUser.getId());
			req.setAttribute("ysUserPage", ysUser);
		}
		return new ModelAndView("com/yisi/business/user/ysUser-update");
	}
	
	
	/**
	 * 加载明细列表[用户地址]
	 * 
	 * @return
	 */
	@RequestMapping(params = "ysUserAddressList")
	public ModelAndView ysUserAddressList(YsUserEntity ysUser, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = ysUser.getId();
		//===================================================================================
		//查询-用户地址
	    String hql0 = "from YsUserAddressEntity where 1 = 1 AND uSER_ID = ? ";
	    try{
	    	List<YsUserAddressEntity> ysUserAddressEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("ysUserAddressList", ysUserAddressEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/yisi/business/user/ysUserAddressList");
	}
	/**
	 * 加载明细列表[用户银行]
	 * 
	 * @return
	 */
	@RequestMapping(params = "ysUserBankList")
	public ModelAndView ysUserBankList(YsUserEntity ysUser, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = ysUser.getId();
		//===================================================================================
		//查询-用户银行
	    String hql1 = "from YsUserBankEntity where 1 = 1 AND uSER_ID = ? ";
	    try{
	    	List<YsUserBankEntity> ysUserBankEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("ysUserBankList", ysUserBankEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/yisi/business/user/ysUserBankList");
	}
	/**
	 * 加载明细列表[用户学历]
	 * 
	 * @return
	 */
	@RequestMapping(params = "ysUserDegreeList")
	public ModelAndView ysUserDegreeList(YsUserEntity ysUser, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = ysUser.getId();
		//===================================================================================
		//查询-用户学历
	    String hql2 = "from YsUserDegreeEntity where 1 = 1 AND uSER_ID = ? ";
	    try{
	    	List<YsUserDegreeEntity> ysUserDegreeEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("ysUserDegreeList", ysUserDegreeEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/yisi/business/user/ysUserDegreeList");
	}
	/**
	 * 加载明细列表[用户图片]
	 * 
	 * @return
	 */
	@RequestMapping(params = "ysUserImagesList")
	public ModelAndView ysUserImagesList(YsUserEntity ysUser, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id3 = ysUser.getId();
		//===================================================================================
		//查询-用户图片
	    String hql3 = "from YsUserImagesEntity where 1 = 1 AND uSER_ID = ? ";
	    try{
	    	List<YsUserImagesEntity> ysUserImagesEntityList = systemService.findHql(hql3,id3);
			req.setAttribute("ysUserImagesList", ysUserImagesEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/yisi/business/user/ysUserImagesList");
	}
	/**
	 * 加载明细列表[用户工作]
	 * 
	 * @return
	 */
	@RequestMapping(params = "ysUserWorkList")
	public ModelAndView ysUserWorkList(YsUserEntity ysUser, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id4 = ysUser.getId();
		//===================================================================================
		//查询-用户工作
	    String hql4 = "from YsUserWorkEntity where 1 = 1 AND uSER_ID = ? ";
	    try{
	    	List<YsUserWorkEntity> ysUserWorkEntityList = systemService.findHql(hql4,id4);
			req.setAttribute("ysUserWorkList", ysUserWorkEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/yisi/business/user/ysUserWorkList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(YsUserEntity ysUser,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(YsUserEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ysUser);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<YsUserEntity> list=this.ysUserService.getListByCriteriaQuery(cq, false);
    	List<YsUserPage> pageList=new ArrayList<YsUserPage>();
        if(list!=null&&list.size()>0){
        	for(YsUserEntity entity:list){
        		try{
        		YsUserPage page=new YsUserPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from YsUserAddressEntity where 1 = 1 AND uSER_ID = ? ";
        	        List<YsUserAddressEntity> ysUserAddressEntityList = systemService.findHql(hql0,id0);
            		page.setYsUserAddressList(ysUserAddressEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from YsUserBankEntity where 1 = 1 AND uSER_ID = ? ";
        	        List<YsUserBankEntity> ysUserBankEntityList = systemService.findHql(hql1,id1);
            		page.setYsUserBankList(ysUserBankEntityList);
            	    Object id2 = entity.getId();
				    String hql2 = "from YsUserDegreeEntity where 1 = 1 AND uSER_ID = ? ";
        	        List<YsUserDegreeEntity> ysUserDegreeEntityList = systemService.findHql(hql2,id2);
            		page.setYsUserDegreeList(ysUserDegreeEntityList);
            	    Object id3 = entity.getId();
				    String hql3 = "from YsUserImagesEntity where 1 = 1 AND uSER_ID = ? ";
        	        List<YsUserImagesEntity> ysUserImagesEntityList = systemService.findHql(hql3,id3);
            		page.setYsUserImagesList(ysUserImagesEntityList);
            	    Object id4 = entity.getId();
				    String hql4 = "from YsUserWorkEntity where 1 = 1 AND uSER_ID = ? ";
        	        List<YsUserWorkEntity> ysUserWorkEntityList = systemService.findHql(hql4,id4);
            		page.setYsUserWorkList(ysUserWorkEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"用户管理");
        map.put(NormalExcelConstants.CLASS,YsUserPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("用户管理列表", "导出人:Jeecg",
            "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,pageList);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

    /**
	 * 通过excel导入数据
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<YsUserPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), YsUserPage.class, params);
				YsUserEntity entity1=null;
				for (YsUserPage page : list) {
					entity1=new YsUserEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            ysUserService.addMain(entity1, page.getYsUserAddressList(),page.getYsUserBankList(),page.getYsUserDegreeList(),page.getYsUserImagesList(),page.getYsUserWorkList());
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
			return j;
	}
	/**
	* 导出excel 使模板
	*/
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ModelMap map) {
		map.put(NormalExcelConstants.FILE_NAME,"用户管理");
		map.put(NormalExcelConstants.CLASS,YsUserPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("用户管理列表", "导出人:"+ ResourceUtil.getSessionUserName().getRealName(),
		"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	* 导入功能跳转
	*
	* @return
	*/
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "ysUserController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<YsUserEntity> list() {
		List<YsUserEntity> listYsUsers=ysUserService.getList(YsUserEntity.class);
		return listYsUsers;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		YsUserEntity task = ysUserService.get(YsUserEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody YsUserPage ysUserPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<YsUserPage>> failures = validator.validate(ysUserPage);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		List<YsUserAddressEntity> ysUserAddressList =  ysUserPage.getYsUserAddressList();
		List<YsUserBankEntity> ysUserBankList =  ysUserPage.getYsUserBankList();
		List<YsUserDegreeEntity> ysUserDegreeList =  ysUserPage.getYsUserDegreeList();
		List<YsUserImagesEntity> ysUserImagesList =  ysUserPage.getYsUserImagesList();
		List<YsUserWorkEntity> ysUserWorkList =  ysUserPage.getYsUserWorkList();
		
		YsUserEntity ysUser = new YsUserEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(ysUser,ysUserPage);
		}catch(Exception e){
            logger.info(e.getMessage());
        }
		ysUserService.addMain(ysUser, ysUserAddressList,ysUserBankList,ysUserDegreeList,ysUserImagesList,ysUserWorkList);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		Integer id = ysUserPage.getId();
		URI uri = uriBuilder.path("/rest/ysUserController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody YsUserPage ysUserPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<YsUserPage>> failures = validator.validate(ysUserPage);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		List<YsUserAddressEntity> ysUserAddressList =  ysUserPage.getYsUserAddressList();
		List<YsUserBankEntity> ysUserBankList =  ysUserPage.getYsUserBankList();
		List<YsUserDegreeEntity> ysUserDegreeList =  ysUserPage.getYsUserDegreeList();
		List<YsUserImagesEntity> ysUserImagesList =  ysUserPage.getYsUserImagesList();
		List<YsUserWorkEntity> ysUserWorkList =  ysUserPage.getYsUserWorkList();
		
		YsUserEntity ysUser = new YsUserEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(ysUser,ysUserPage);
		}catch(Exception e){
            logger.info(e.getMessage());
        }
		ysUserService.updateMain(ysUser, ysUserAddressList,ysUserBankList,ysUserDegreeList,ysUserImagesList,ysUserWorkList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		YsUserEntity ysUser = ysUserService.get(YsUserEntity.class, id);
		ysUserService.delMain(ysUser);
	}
}
