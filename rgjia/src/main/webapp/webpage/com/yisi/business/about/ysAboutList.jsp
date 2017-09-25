<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ysAboutList" checkbox="true" pagination="true" fitColumns="false" title="项目介绍" actionUrl="ysAboutController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="名称"  field="projectName"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="网址"  field="projectUrl"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="关于项目"  field="about"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="简介"  field="synopsis"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="logo"  field="logo"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="公司图片"  field="images"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="客服电话"  field="serviceTel"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="QQ"  field="qqNumber"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="微信号"  field="weixinNumber"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="微信二维码"  field="weixinImage"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="邮箱"  field="mail"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="微博"  field="weiboNumber"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="地址"  field="projectAddress"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="法人"  field="legalPerson"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="营业执照"  field="businessLicense"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="执照号"  field="licenseNo"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="身份证号"  field="idNumber"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="备注"  field="remark"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="ysAboutController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="ysAboutController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="ysAboutController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ysAboutController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ysAboutController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%-- <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <%-- <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
   <%-- <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/yisi/business/about/ysAboutList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ysAboutController.do?upload', "ysAboutList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ysAboutController.do?exportXls","ysAboutList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ysAboutController.do?exportXlsByT","ysAboutList");
}

 </script>