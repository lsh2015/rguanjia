<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ysUserList" checkbox="true" fitColumns="false" title="用户管理" actionUrl="ysUserController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="级别"  field="grade"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="级别说明"  field="gradeName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="芝麻积分"  field="sesamePoint"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="邀请码"  field="inviteCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单数"  field="agreement"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="访客数"  field="visitor"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="自我介绍"  field="introduction"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="个人优势"  field="advantage"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职业经历"  field="experience"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="资料完善度"  field="perfect"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="缴纳保证金"  field="isDeposit"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="推荐人数"  field="refferNum"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="上级推荐人"  field="parentId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
  <t:dgCol title="用户名"  field="userName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="邮箱"  field="email"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="头像"  field="image"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="注册时间"  field="createTime" formatter="yyyy-MM-dd" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="出生年月"  field="birthday" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="注册IP"  field="createIp"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="注册城市"  field="createCity"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="QQ号"  field="qqNumber"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="微博号"  field="weiboNumber"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="微信号"  field="weixinNumber"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="QQID"  field="qqId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="微博ID"  field="weiboId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="微信ID"  field="weixinId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="支付宝账号"  field="zfb"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="微信账号"  field="weixi"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="实名认证"  field="realName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="企业认证"  field="companyAuth"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="一级密码"  field="passwordOne"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="二级密码"  field="passwordTwo"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="呢称"  field="nickName"    queryMode="group"  width="120"></t:dgCol>
   
   <t:dgCol title="性别"  field="sex"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="手机号码"  field="mobile"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="status"  dictionary="status"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="备注"  field="remark"    queryMode="group"  width="120"></t:dgCol>
  
  <t:dgCol title="经度"  field="longitude"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="纬度"  field="latitude"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="个推ID"  field="clinetId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="免打拢"  field="trouble"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="隐身登录"  field="hiding"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人"  field="createName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改时间"  field="updateDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改人"  field="updateName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户属性"  field="userType"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="ysUserController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="ysUserController.do?goAdd" funname="add" width="800" height="450"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="ysUserController.do?goUpdate" funname="update" width="800" height="450"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ysUserController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ysUserController.do?goUpdate" funname="detail" width="800" height="450"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/yisi/business/user/ysUserList.js"></script>		
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ysUserController.do?upload', "ysUserList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ysUserController.do?exportXls","ysUserList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ysUserController.do?exportXlsByT","ysUserList");
}
 </script>