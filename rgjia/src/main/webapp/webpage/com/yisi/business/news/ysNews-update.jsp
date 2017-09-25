<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>新闻管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ysNewsController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${ysNewsPage.id }">
					<input id="hotNews" name="hotNews" type="hidden" value="${ysNewsPage.hotNews }">
					<input id="topNews" name="topNews" type="hidden" value="${ysNewsPage.topNews }">
					<input id="click" name="click" type="hidden" value="${ysNewsPage.click }">
					<input id="latestNews" name="latestNews" type="hidden" value="${ysNewsPage.latestNews }">
					<input id="status" name="status" type="hidden" value="${ysNewsPage.status }">
					<input id="createDate" name="createDate" type="hidden" value="${ysNewsPage.createDate }">
					<input id="createName" name="createName" type="hidden" value="${ysNewsPage.createName }">
					<input id="updateDate" name="updateDate" type="hidden" value="${ysNewsPage.updateDate }">
					<input id="updateName" name="updateName" type="hidden" value="${ysNewsPage.updateName }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ysNewsPage.sysCompanyCode }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ysNewsPage.sysOrgCode }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								标题:
							</label>
						</td>
						<td class="value" colspan="3">
						     	 <input id="title" name="title" type="text" style="width: 550px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${ysNewsPage.title}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">标题</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								列表图:
							</label>
						</td>
						<td class="value">
							   <t:webUploader auto="true" buttonText="选择图片" name="listImage" buttonStyle="btn-blue btn-S" type="image" pathValues="${ysNewsPage.listImage}" fileNumLimit="1"></t:webUploader>
							
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">列表图</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								标题图:
							</label>
						</td>
						<td class="value">
							<t:webUploader name="bannerImage" auto="true" buttonText="列表图上传"  buttonStyle="btn-blue btn-S" pathValues="${ysNewsPage.bannerImage}" type="image" fileNumLimit="1"></t:webUploader>
							
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">标题图</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								内容:
							</label>
						</td>
						<td class="value" colspan="3">
							 <script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
							<script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.all.min.js"></script>
					    	<textarea name="content" id="content" style="width: 550px;">${ysNewsPage.content}</textarea>
						    <script type="text/javascript">
						        var editor = UE.getEditor('content');
						    </script>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">内容</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								作者:
							</label>
						</td>
						<td class="value">
						     	 <input id="author" name="author" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${ysNewsPage.author}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">作者</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								新闻属性:
							</label>
						</td>
						<td class="value">
						     	   <t:dictSelect field="newsType" defaultVal="${ysNewsPage.newsType}"  datatype="*" typeGroupCode="newType" hasLabel="false"></t:dictSelect>
							
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">新闻属性</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value" colspan="3">
						     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${ysNewsPage.remark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/yisi/business/news/ysNews.js"></script>		
