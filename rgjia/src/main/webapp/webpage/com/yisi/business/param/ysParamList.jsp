<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ysParamList" checkbox="true" pagination="true" fitColumns="false" title="系统参数" actionUrl="ysParamController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="参数名称"  field="paramName"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="参数类型"  field="paramType"  replace="全局_1"   queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="参数值"  field="paramValue"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="备注"  field="remark"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="状态"  field="status"  replace="正常_1,暂停_0"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建时间"  field="createDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建人"  field="createName"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="修改时间"  field="updateDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="修改人"  field="updateName"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="ysParamController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="ysParamController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="ysParamController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ysParamController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ysParamController.do?goUpdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/yisi/business/param/ysParamList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ysParamController.do?upload', "ysParamList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ysParamController.do?exportXls","ysParamList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ysParamController.do?exportXlsByT","ysParamList");
}

 </script>