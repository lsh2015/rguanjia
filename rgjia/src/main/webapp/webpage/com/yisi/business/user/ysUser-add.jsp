<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="ysUserController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${ysUserPage.id }">
					<input id="grade" name="grade" type="hidden" value="${ysUserPage.grade }">
					<input id="gradeName" name="gradeName" type="hidden" value="${ysUserPage.gradeName }">
					<input id="sesamePoint" name="sesamePoint" type="hidden" value="${ysUserPage.sesamePoint }">
					<input id="inviteCode" name="inviteCode" type="hidden" value="${ysUserPage.inviteCode }">
					<input id="agreement" name="agreement" type="hidden" value="${ysUserPage.agreement }">
					<input id="visitor" name="visitor" type="hidden" value="${ysUserPage.visitor }">
					<input id="introduction" name="introduction" type="hidden" value="${ysUserPage.introduction }">
					<input id="advantage" name="advantage" type="hidden" value="${ysUserPage.advantage }">
					<input id="experience" name="experience" type="hidden" value="${ysUserPage.experience }">
					<input id="perfect" name="perfect" type="hidden" value="${ysUserPage.perfect }">
					<input id="isDeposit" name="isDeposit" type="hidden" value="${ysUserPage.isDeposit }">
					<input id="refferNum" name="refferNum" type="hidden" value="${ysUserPage.refferNum }">
					<input id="parentId" name="parentId" type="hidden" value="${ysUserPage.parentId }">
					<input id="status" name="status" type="hidden" value="${ysUserPage.status }">
					<input id="email" name="email" type="hidden" value="${ysUserPage.email }">
					<input id="createTime" name="createTime" type="hidden" value="${ysUserPage.createTime }">
					<input id="createIp" name="createIp" type="hidden" value="${ysUserPage.createIp }">
					<input id="createCity" name="createCity" type="hidden" value="${ysUserPage.createCity }">
					<input id="qqNumber" name="qqNumber" type="hidden" value="${ysUserPage.qqNumber }">
					<input id="weiboNumber" name="weiboNumber" type="hidden" value="${ysUserPage.weiboNumber }">
					<input id="weixinNumber" name="weixinNumber" type="hidden" value="${ysUserPage.weixinNumber }">
					<input id="qqId" name="qqId" type="hidden" value="${ysUserPage.qqId }">
					<input id="weiboId" name="weiboId" type="hidden" value="${ysUserPage.weiboId }">
					<input id="weixinId" name="weixinId" type="hidden" value="${ysUserPage.weixinId }">
					<input id="zfb" name="zfb" type="hidden" value="${ysUserPage.zfb }">
					<input id="weixi" name="weixi" type="hidden" value="${ysUserPage.weixi }">
					<input id="realName" name="realName" type="hidden" value="${ysUserPage.realName }">
					<input id="companyAuth" name="companyAuth" type="hidden" value="${ysUserPage.companyAuth }">
					<input id="passwordOne" name="passwordOne" type="hidden" value="${ysUserPage.passwordOne }">
					<input id="passwordTwo" name="passwordTwo" type="hidden" value="${ysUserPage.passwordTwo }">
					<input id="longitude" name="longitude" type="hidden" value="${ysUserPage.longitude }">
					<input id="latitude" name="latitude" type="hidden" value="${ysUserPage.latitude }">
					<input id="clinetId" name="clinetId" type="hidden" value="${ysUserPage.clinetId }">
					<input id="trouble" name="trouble" type="hidden" value="${ysUserPage.trouble }">
					<input id="hiding" name="hiding" type="hidden" value="${ysUserPage.hiding }">
					<input id="createDate" name="createDate" type="hidden" value="${ysUserPage.createDate }">
					<input id="createName" name="createName" type="hidden" value="${ysUserPage.createName }">
					<input id="updateDate" name="updateDate" type="hidden" value="${ysUserPage.updateDate }">
					<input id="updateName" name="updateName" type="hidden" value="${ysUserPage.updateName }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${ysUserPage.sysCompanyCode }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${ysUserPage.sysOrgCode }">
					<input id="userType" name="userType" type="hidden" value="${ysUserPage.userType }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">用户名:</label>
			</td>
			<td class="value">
		     	 <input id="userName" name="userName" type="text" style="width: 150px" class="inputxt" 
				ignore="ignore"
		     	 >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">用户名</label>
			</td>
			<td align="right">
				<label class="Validform_label">手机号码:</label>
			</td>
			<td class="value">
		     	 <input id="mobile" name="mobile" type="text" style="width: 150px" class="inputxt" 
				ignore="ignore"
		     	 >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">手机号码</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">出生年月:</label>
			</td>
			<td class="value">
					  <input id="birthday" name="birthday" type="text" style="width: 150px" 
							 class="Wdate" onClick="WdatePicker()"  
									ignore="ignore"
							 >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">出生年月</label>
			</td>
			<td align="right">
				<label class="Validform_label">头像:</label>
			</td>
			<td class="value">
		     	 <input id="image" name="image" type="text" style="width: 150px" class="inputxt" 
				ignore="ignore"
		     	 >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">头像</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">呢称:</label>
			</td>
			<td class="value">
		     	 <input id="nickName" name="nickName" type="text" style="width: 150px" class="inputxt" 
				ignore="ignore"
		     	 >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">呢称</label>
			</td>
			<td align="right">
				<label class="Validform_label">性别:</label>
			</td>
			<td class="value">
		     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt" 
				ignore="ignore"
		     	 >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">性别</label>
			</td>
		</tr>
		<tr>
			
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value">
		     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt" 
				ignore="ignore"
		     	 >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
			<td>
			</td>
			<td>
			</td>
		</tr>
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="ysUserController.do?ysUserAddressList&id=${ysUserPage.id}" icon="icon-search" title="用户地址" id="ysUserAddress"></t:tab>
				 <t:tab href="ysUserController.do?ysUserBankList&id=${ysUserPage.id}" icon="icon-search" title="用户银行" id="ysUserBank"></t:tab>
				 <t:tab href="ysUserController.do?ysUserDegreeList&id=${ysUserPage.id}" icon="icon-search" title="用户学历" id="ysUserDegree"></t:tab>
				 <t:tab href="ysUserController.do?ysUserImagesList&id=${ysUserPage.id}" icon="icon-search" title="用户图片" id="ysUserImages"></t:tab>
				 <t:tab href="ysUserController.do?ysUserWorkList&id=${ysUserPage.id}" icon="icon-search" title="用户工作" id="ysUserWork"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_ysUserAddress_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="ysUserAddressList[#index#].addressInfo" maxlength="500" 
					  		type="text" class="inputxt"  style="width:120px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">地址</label>
				  </td>
				  <td align="left">
					  	<input name="ysUserAddressList[#index#].images" maxlength="500" 
					  		type="text" class="inputxt"  style="width:120px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">地址图片</label>
				  </td>
				  <td align="left">
					  	<input name="ysUserAddressList[#index#].longitude" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">经度</label>
				  </td>
				  <td align="left">
					  	<input name="ysUserAddressList[#index#].latitude" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">纬度</label>
				  </td>
				  <td align="left">
					  	<input name="ysUserAddressList[#index#].remark" maxlength="200" 
					  		type="text" class="inputxt"  style="width:120px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_ysUserBank_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="ysUserBankList[#index#].userName" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">用户名称</label>
				  </td>
				  <td align="left">
					  	<input name="ysUserBankList[#index#].accountNo" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">账户号码</label>
				  </td>
				  <td align="left">
					  	<input name="ysUserBankList[#index#].bankAddress" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">账户归属</label>
				  </td>
				  <td align="left">
					  	<input name="ysUserBankList[#index#].bank" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">开户银行</label>
				  </td>
				  <td align="left">
					  	<input name="ysUserBankList[#index#].subbranch" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">支行名称</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_ysUserDegree_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="ysUserDegreeList[#index#].school" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">学校名称</label>
				  </td>
				  <td align="left">
					  	<input name="ysUserDegreeList[#index#].education" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">学历</label>
				  </td>
				  <td align="left">
					  	<input name="ysUserDegreeList[#index#].specialty" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">专业</label>
				  </td>
				  <td align="left">
							<input name="ysUserDegreeList[#index#].startDate" maxlength="0" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:100px;"
									ignore="ignore"
					  		 >
					  <label class="Validform_label" style="display: none;">入学时间</label>
				  </td>
				  <td align="left">
							<input name="ysUserDegreeList[#index#].endDate" maxlength="0" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:100px;"
									ignore="ignore"
					  		 >
					  <label class="Validform_label" style="display: none;">毕业时间</label>
				  </td>
				  <td align="left">
					  	<input name="ysUserDegreeList[#index#].remark" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_ysUserImages_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="ysUserImagesList[#index#].imageUrl" maxlength="500" 
					  		type="text" class="inputxt"  style="width:120px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">图片路径</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_ysUserWork_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="ysUserWorkList[#index#].company" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">单位名称</label>
				  </td>
				  <td align="left">
					  	<input name="ysUserWorkList[#index#].profession" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">职业</label>
				  </td>
				  <td align="left">
							<input name="ysUserWorkList[#index#].startDate" maxlength="0" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:100px;"
									ignore="ignore"
					  		 >
					  <label class="Validform_label" style="display: none;">入职时间</label>
				  </td>
				  <td align="left">
							<input name="ysUserWorkList[#index#].endDate" maxlength="0" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:100px;"
									ignore="ignore"
					  		 >
					  <label class="Validform_label" style="display: none;">离职时间</label>
				  </td>
				  <td align="left">
					       	<input name="ysUserWorkList[#index#].workInfo" maxlength="5000" 
						  		type="text" class="inputxt"  style="width:100px;"
						  		 
									ignore="ignore"
						  		>
					  <label class="Validform_label" style="display: none;">工作内容</label>
				  </td>
				  <td align="left">
					  	<input name="ysUserWorkList[#index#].remark" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;" 
									ignore="ignore"
					  		>
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/yisi/business/user/ysUser.js"></script>
	