<#if packageStyle == "service">
package ${bussiPackage}.${entityPackage}.controller;
import ${bussiPackage}.${entityPackage}.entity.${entityName}Entity;
import ${bussiPackage}.${entityPackage}.service.${entityName}ServiceI;
<#else>
package ${bussiPackage}.controller.${entityPackage};
import ${bussiPackage}.entity.${entityPackage}.${entityName}Entity;
import ${bussiPackage}.service.${entityPackage}.${entityName}ServiceI;
</#if>
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

<#-- restful 通用方法生成 -->
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
<#-- restful 通用方法生成 -->

<#-- 列为文件类型的文件代码生成 -->
<#assign fileFlag = false />
<#list columns as filePo>
	<#if filePo.showType=='file'>
		<#assign fileFlag = true />
	</#if>
</#list>

<#if fileFlag==true>
import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
</#if>
<#-- 列为文件类型的文件代码生成 -->
/**   
 * @Title: Controller  
 * @Description: ${ftl_description}
 * @author onlineGenerator
 * @date ${ftl_create_time}
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/${entityName?uncap_first}Controller")
public class ${entityName}Controller extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(${entityName}Controller.class);

	@Autowired
	private ${entityName}ServiceI ${entityName?uncap_first}Service;
	@Autowired
	private SystemService systemService;
	<#-- restful 通用方法生成 -->
	@Autowired
	private Validator validator;
	<#-- restful 通用方法生成 -->
	
	<#-- 列为文件类型的文件代码生成 -->
	<#if fileFlag==true>
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	</#if>
	<#-- 列为文件类型的文件代码生成 -->
	


	/**
	 * ${ftl_description}列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("${bussiPackage?replace(".","/")}/${entityPackage}/${entityName?uncap_first}List");
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
	public void datagrid(${entityName}Entity ${entityName?uncap_first},HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(${entityName}Entity.class, dataGrid);
		<#if cgformConfig.cgFormHead.isTree == 'Y'>
		if(StringUtil.isEmpty(${entityName?uncap_first}.getId())){
			cq.isNull("${cgformConfig.cgFormHead.treeParentIdFieldNamePage}");
		}else{
			cq.eq("${cgformConfig.cgFormHead.treeParentIdFieldNamePage}", ${entityName?uncap_first}.getId());
			${entityName?uncap_first}.setId(null);
		}
		</#if>
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ${entityName?uncap_first}, request.getParameterMap());
		try{
		//自定义追加查询条件
		<#list columns as po>
		<#if po.isQuery =='Y' && po.queryMode =='group'>
		String query_${po.fieldName}_begin = request.getParameter("${po.fieldName}_begin");
		String query_${po.fieldName}_end = request.getParameter("${po.fieldName}_end");
		if(StringUtil.isNotEmpty(query_${po.fieldName}_begin)){
			<#if po.type == "java.util.Date">
			cq.ge("${po.fieldName}", new SimpleDateFormat("yyyy-MM-dd").parse(query_${po.fieldName}_begin));
			<#else>
			cq.ge("${po.fieldName}", Integer.parseInt(query_${po.fieldName}_begin));
			</#if>
		}
		if(StringUtil.isNotEmpty(query_${po.fieldName}_end)){
			<#if po.type == "java.util.Date">
			cq.le("${po.fieldName}", new SimpleDateFormat("yyyy-MM-dd").parse(query_${po.fieldName}_end));
			<#else>
			cq.le("${po.fieldName}", Integer.parseInt(query_${po.fieldName}_end));
			</#if>
		}
		</#if>
		</#list> 
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.${entityName?uncap_first}Service.getDataGridReturn(cq, true);
		<#if cgformConfig.cgFormHead.isTree == 'Y'>
		TagUtil.treegrid(response, dataGrid);
		<#else>
		TagUtil.datagrid(response, dataGrid);
		</#if>
	}
	
	/**
	 * 删除${ftl_description}
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(${entityName}Entity ${entityName?uncap_first}, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		${entityName?uncap_first} = systemService.getEntity(${entityName}Entity.class, ${entityName?uncap_first}.getId());
		message = "${ftl_description}删除成功";
		try{
			${entityName?uncap_first}Service.delete(${entityName?uncap_first});
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "${ftl_description}删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除${ftl_description}
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "${ftl_description}删除成功";
		try{
			for(String id:ids.split(",")){
				${entityName}Entity ${entityName?uncap_first} = systemService.getEntity(${entityName}Entity.class, 
				<#if cgformConfig.cgFormHead.jformPkType?if_exists?html == "UUID">
				id
				<#elseif cgformConfig.cgFormHead.jformPkType?if_exists?html == "NATIVE">
				Integer.parseInt(id)
				<#elseif cgformConfig.cgFormHead.jformPkType?if_exists?html == "SEQUENCE">
				Integer.parseInt(id)
				<#else>
				id
				</#if>
				);
				${entityName?uncap_first}Service.delete(${entityName?uncap_first});
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "${ftl_description}删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加${ftl_description}
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(${entityName}Entity ${entityName?uncap_first}, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "${ftl_description}添加成功";
		try{
			<#if cgformConfig.cgFormHead.isTree == 'Y'>
			if(StringUtil.isEmpty(${entityName?uncap_first}.get${cgformConfig.cgFormHead.treeParentIdFieldNamePage?cap_first}())){
				${entityName?uncap_first}.set${cgformConfig.cgFormHead.treeParentIdFieldNamePage?cap_first}(null);
			}
			</#if>
			${entityName?uncap_first}Service.save(${entityName?uncap_first});
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "${ftl_description}添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		<#-- 列为文件类型的文件代码生成 -->
		<#if fileFlag==true>
		j.setObj(${entityName?uncap_first});
		</#if>
		<#-- 列为文件类型的文件代码生成 -->
		return j;
	}
	
	/**
	 * 更新${ftl_description}
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(${entityName}Entity ${entityName?uncap_first}, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "${ftl_description}更新成功";
		${entityName}Entity t = ${entityName?uncap_first}Service.get(${entityName}Entity.class, ${entityName?uncap_first}.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(${entityName?uncap_first}, t);
			<#if cgformConfig.cgFormHead.isTree == 'Y'>
			if(StringUtil.isEmpty(t.get${cgformConfig.cgFormHead.treeParentIdFieldNamePage?cap_first}())){
				t.set${cgformConfig.cgFormHead.treeParentIdFieldNamePage?cap_first}(null);
			}
			</#if>
			${entityName?uncap_first}Service.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "${ftl_description}更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	<#list buttons as btn>
 	<#if btn.optType=='action'>
 	/**
	 * 自定义按钮-[${btn.buttonName}]业务
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "do${btn.buttonCode?cap_first}")
	@ResponseBody
	public AjaxJson do${btn.buttonCode?cap_first}(${entityName}Entity ${entityName?uncap_first}, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "${btn.buttonName}成功";
		${entityName}Entity t = ${entityName?uncap_first}Service.get(${entityName}Entity.class, ${entityName?uncap_first}.getId());
		try{
			${entityName?uncap_first}Service.do${btn.buttonCode?cap_first}Bus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "${btn.buttonName}失败";
		}
		j.setMsg(message);
		return j;
	}
 	</#if>
 	</#list> 

	/**
	 * ${ftl_description}新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(${entityName}Entity ${entityName?uncap_first}, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(${entityName?uncap_first}.getId())) {
			${entityName?uncap_first} = ${entityName?uncap_first}Service.getEntity(${entityName}Entity.class, ${entityName?uncap_first}.getId());
			req.setAttribute("${entityName?uncap_first}Page", ${entityName?uncap_first});
		}
		return new ModelAndView("${bussiPackage?replace(".","/")}/${entityPackage}/${entityName?uncap_first}-add");
	}
	/**
	 * ${ftl_description}编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(${entityName}Entity ${entityName?uncap_first}, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(${entityName?uncap_first}.getId())) {
			${entityName?uncap_first} = ${entityName?uncap_first}Service.getEntity(${entityName}Entity.class, ${entityName?uncap_first}.getId());
			req.setAttribute("${entityName?uncap_first}Page", ${entityName?uncap_first});
		}
		return new ModelAndView("${bussiPackage?replace(".","/")}/${entityPackage}/${entityName?uncap_first}-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","${entityName?uncap_first}Controller");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(${entityName}Entity ${entityName?uncap_first},HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(${entityName}Entity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ${entityName?uncap_first}, request.getParameterMap());
		List<${entityName}Entity> ${entityName?uncap_first}s = this.${entityName?uncap_first}Service.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"${ftl_description}");
		modelMap.put(NormalExcelConstants.CLASS,${entityName}Entity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("${ftl_description}列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,${entityName?uncap_first}s);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(${entityName}Entity ${entityName?uncap_first},HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"${ftl_description}");
    	modelMap.put(NormalExcelConstants.CLASS,${entityName}Entity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("${ftl_description}列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
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
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<${entityName}Entity> list${entityName}Entitys = ExcelImportUtil.importExcel(file.getInputStream(),${entityName}Entity.class,params);
				for (${entityName}Entity ${entityName?uncap_first} : list${entityName}Entitys) {
					${entityName?uncap_first}Service.save(${entityName?uncap_first});
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
	
	<#-- 列为文件类型的文件代码生成 -->
	<#if fileFlag==true>
	/**
	 * 获取文件附件信息
	 * 
	 * @param id ${entityName?uncap_first}主键id
	 */
	@RequestMapping(params = "getFiles")
	@ResponseBody
	public AjaxJson getFiles(String id){
		List<CgUploadEntity> uploadBeans = cgFormFieldService.findByProperty(CgUploadEntity.class, "cgformId", id);
		List<Map<String,Object>> files = new ArrayList<Map<String,Object>>(0);
		for(CgUploadEntity b:uploadBeans){
			String title = b.getAttachmenttitle();//附件名
			String fileKey = b.getId();//附件主键
			String path = b.getRealpath();//附件路径
			String field = b.getCgformField();//表单中作为附件控件的字段
			Map<String, Object> file = new HashMap<String, Object>();
			file.put("title", title);
			file.put("fileKey", fileKey);
			file.put("path", path);
			file.put("field", field==null?"":field);
			files.add(file);
		}
		AjaxJson j = new AjaxJson();
		j.setObj(files);
		return j;
	}
	</#if>
	<#-- 列为文件类型的文件代码生成 -->
	
	<#-- restful 通用方法生成 -->
	  /** 
	    * @apiDefine ${entityName}Entity
		<#list columns as po>
		* @apiSuccess {${po.type}}  ${po.fieldName} ${po.content}
		</#list>
		*
	  **/
	
	/** 
	 * @api {GET} /rest/${entityName?uncap_first}Intf/${entityName?uncap_first}List ${ftl_description}列表
	 * @apiName ${entityName?uncap_first}List
	 * @apiGroup ${entityName} 
	 * @apiVersion 1.0.0 
	 * @apiDescription ${ftl_description}列表
	 *  
	 * 
	 * @apiUse RETURN_MESSAGE
	 * @apiSuccess {String} model 返回成功信息
	 * @apiUse ${entityName}Entity
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
	@RequestMapping(value = "/${entityName?uncap_first}List",method = RequestMethod.GET)
	@ResponseBody
	public IResult list() {
		String listSql = " select  <#list columns as po> <#if po.type == "java.util.Date"> date_format( ${fieldMeta[po.fieldName]},'%Y-%m-%d') <#else> ${fieldMeta[po.fieldName]} </#if>  ${po.fieldName},  </#list> "
					   + " from ${tableName} " ;
		List<Map<String,Object>> ${entityName?uncap_first}List = systemService.findForJdbc(listSql);
		return successResult(${entityName?uncap_first}List);
	}
	
	/** 
	 * @api {GET} /rest/${entityName?uncap_first}Intf/getId 获取${ftl_description}信息
	 * @apiName getId
	 * @apiGroup ${entityName} 
	 * @apiVersion 1.0.0 
	 * @apiDescription 获取${ftl_description}信息
	 *  
	 * 
	 * @apiUse RETURN_MESSAGE
	 * @apiSuccess {String} model 返回成功信息
	 * @apiUse ${entityName}Entity
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
	public IResult getId(@PathVariable("id") String id) {
		if( null == id ){
 			return errResultAsString("${ftl_description}ID为空");
 		}
 		
		String listSql = " select  <#list columns as po> <#if po.type == "java.util.Date"> date_format( ${fieldMeta[po.fieldName]},'%Y-%m-%d') <#else> ${fieldMeta[po.fieldName]} </#if>  ${po.fieldName},  </#list> "
					   + " from ${tableName}  where id = ? " ;
		Map<String,Object> ${entityName?uncap_first}Map = systemService.findOneForJdbc(listSql,id);
		return successResult(${entityName?uncap_first}Map);
	}
	
	/** 
	 * @api {POST} /rest/${entityName?uncap_first}Intf/add${entityName} 添加${ftl_description}
	 * @apiName add${entityName}
	 * @apiGroup ${entityName}  
	 * @apiVersion 1.0.0 
	 * @apiDescription 添加${ftl_description}
	 *  
	 <#list columns as po>
	 * @apiParam {${po.type}}  ${po.fieldName} ${po.content}
	 </#list>
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
	@RequestMapping(value = "/add${entityName}",method = RequestMethod.POST)
	@ResponseBody
	public IResult add${entityName}(${entityName}Entity ${entityName?uncap_first} ) {
 		systemService.save(${entityName?uncap_first});
		return successResult("${ftl_description}添加成功");
	}	
	
	/** 
	 * @api {POST} /rest/${entityName?uncap_first}Intf/update${entityName} 修改${ftl_description}
	 * @apiName update${entityName}
	 * @apiGroup ${entityName} 
	 * @apiVersion 1.0.0 
	 * @apiDescription 修改${ftl_description}
	 *  
	  <#list columns as po>
	 * @apiParam {${po.type}}  ${po.fieldName} ${po.content}
	 </#list>
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
	@RequestMapping(value = "/update${entityName}",method = RequestMethod.POST)
	@ResponseBody
	public IResult update${entityName}(${entityName}Entity ${entityName?uncap_first} ) {
		
		Integer id = ${entityName?uncap_first}.getId();
		if( null == id ){
			return errResultAsString("${ftl_description}ID为空");
		}
		
		${entityName}Entity t = systemService.get(${entityName}Entity.class, id);
		
		if( null == t ){
			return errResultAsString("${ftl_description}ID不存在");
		}
		try {
			MyBeanUtils.copyBeanNotNull2Bean(${entityName?uncap_first},t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		systemService.updateEntitie(t);
		return successResult("${ftl_description}修改成功");
	}
	
	/** 
	 * @api {POST} /rest/${entityName?uncap_first}Intf/delete${entityName} 删除${ftl_description}
	 * @apiName delete${entityName}
	 * @apiGroup ${entityName} 
	 * @apiVersion 1.0.0 
	 * @apiDescription 删除${ftl_description}
	 *  
	 * @apiParam {Integer} id ${ftl_description}ID
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
	@RequestMapping(value = "/delete${entityName}",method = RequestMethod.POST)
	@ResponseBody
	public IResult delete${entityName}(${entityName}Entity ${entityName?uncap_first} ) {
		
		Integer id = ${entityName?uncap_first}.getId();
		if( null == id ){
			return errResultAsString("${ftl_description}ID为空");
		}
		String delSql = " delete from ${tableName} where id = ? ";
		systemService.executeSql(delSql,id);
		return successResult("${ftl_description}删除成功");
	}	
	
	<#-- restful 通用方法生成 -->
}
