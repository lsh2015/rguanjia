<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ysNewsList" checkbox="true" pagination="true" fitColumns="false" title="新闻管理" actionUrl="ysNewsController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="标题"  field="title"  query="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="列表图"  field="listImage"  image="true" imageSize="100,100"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="标题图"  field="bannerImage"  image="true" imageSize="100,80"   queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="内容"  field="content"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="作者"  field="author"    query="true"  queryMode="single"   width="120"></t:dgCol>
     <t:dgCol title="新闻属性"  field="newsType"  dictionary="newType"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="热点新闻"  field="hotNews"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="置顶新闻"  field="topNews"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="点击数"  field="click"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="最新新闻"  field="latestNews"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="备注"  field="remark"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="状态"  field="status"  dictionary="status"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建时间"  field="createDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建人"  field="createName"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="修改时间"  field="updateDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="修改人"  field="updateName"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="ysNewsController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="ysNewsController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="ysNewsController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ysNewsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ysNewsController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/yisi/business/news/ysNewsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ysNewsController.do?upload', "ysNewsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ysNewsController.do?exportXls","ysNewsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ysNewsController.do?exportXlsByT","ysNewsList");
}

 </script>