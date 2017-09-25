<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>系统参数</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ysParamController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${ysParamPage.id }">
					<input id="paramType" name="paramType" type="hidden" value="${ysParamPage.paramType }">
					<input id="status" name="status" type="hidden" value="${ysParamPage.status }">
					<input id="createDate" name="createDate" type="hidden" value="${ysParamPage.createDate }">
					<input id="createName" name="createName" type="hidden" value="${ysParamPage.createName }">
					<input id="updateDate" name="updateDate" type="hidden" value="${ysParamPage.updateDate }">
					<input id="updateName" name="updateName" type="hidden" value="${ysParamPage.updateName }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ysParamPage.sysCompanyCode }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ysParamPage.sysOrgCode }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								参数名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="paramName" name="paramName" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${ysParamPage.paramName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">参数名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								参数值:
							</label>
						</td>
						<td class="value">
						     	 <input id="paramValue" name="paramValue" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${ysParamPage.paramValue}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">参数值</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${ysParamPage.remark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/yisi/business/param/ysParam.js"></script>		
