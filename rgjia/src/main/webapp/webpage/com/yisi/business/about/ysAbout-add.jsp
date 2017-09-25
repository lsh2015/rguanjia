<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目介绍</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="ysAboutController.do?doAdd" >
		<input id="id" name="id" type="hidden" value="${ysAboutPage.id }"/>
		<input id="legalPerson" name="legalPerson" type="hidden" value="${ysAboutPage.legalPerson }"/>
		<input id="businessLicense" name="businessLicense" type="hidden" value="${ysAboutPage.businessLicense }"/>
		<input id="licenseNo" name="licenseNo" type="hidden" value="${ysAboutPage.licenseNo }"/>
		<input id="idNumber" name="idNumber" type="hidden" value="${ysAboutPage.idNumber }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="projectName" name="projectName" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							网址:
						</label>
					</td>
					<td class="value">
					     	 <input id="projectUrl" name="projectUrl" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">网址</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							关于项目:
						</label>
					</td>
					<td class="value">
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="about" name="about" 
						  	 ignore="ignore"
						  	 ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">关于项目</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							简介:
						</label>
					</td>
					<td class="value">
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="synopsis" name="synopsis" 
						  	 ignore="ignore"
						  	 ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">简介</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							logo:
						</label>
					</td>
					<td class="value">
					     	 <input id="logo" name="logo" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">logo</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司图片:
						</label>
					</td>
					<td class="value">
					     	 <input id="images" name="images" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司图片</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							客服电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="serviceTel" name="serviceTel" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客服电话</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							QQ:
						</label>
					</td>
					<td class="value">
					     	 <input id="qqNumber" name="qqNumber" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">QQ</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							微信号:
						</label>
					</td>
					<td class="value">
					     	 <input id="weixinNumber" name="weixinNumber" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">微信号</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							微信二维码:
						</label>
					</td>
					<td class="value">
					     	 <input id="weixinImage" name="weixinImage" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">微信二维码</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							邮箱:
						</label>
					</td>
					<td class="value">
					     	 <input id="mail" name="mail" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">邮箱</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							微博:
						</label>
					</td>
					<td class="value">
					     	 <input id="weiboNumber" name="weiboNumber" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">微博</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="projectAddress" name="projectAddress" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">地址</label>
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
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/yisi/business/about/ysAbout.js"></script>		
