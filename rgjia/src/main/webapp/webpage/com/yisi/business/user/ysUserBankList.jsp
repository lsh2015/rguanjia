<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addYsUserBankBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delYsUserBankBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addYsUserBankBtn').bind('click', function(){   
 		 var tr =  $("#add_ysUserBank_table_template tr").clone();
	 	 $("#add_ysUserBank_table").append(tr);
	 	 resetTrNum('add_ysUserBank_table');
	 	 return false;
    });  
	$('#delYsUserBankBtn').bind('click', function(){   
      	$("#add_ysUserBank_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_ysUserBank_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#ysUserBank_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addYsUserBankBtn" href="#">添加</a> <a id="delYsUserBankBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="ysUserBank_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						用户名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						账户号码
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						账户归属
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						开户银行
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						支行名称
				  </td>
	</tr>
	<tbody id="add_ysUserBank_table">
	<c:if test="${fn:length(ysUserBankList)  > 0 }">
		<c:forEach items="${ysUserBankList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="ysUserBankList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
				   <td align="left">
					  	<input name="ysUserBankList[${stuts.index }].userName" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"  value="${poVal.userName }">
					  <label class="Validform_label" style="display: none;">用户名称</label>
				   </td>
				   <td align="left">
					  	<input name="ysUserBankList[${stuts.index }].accountNo" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"  value="${poVal.accountNo }">
					  <label class="Validform_label" style="display: none;">账户号码</label>
				   </td>
				   <td align="left">
					  	<input name="ysUserBankList[${stuts.index }].bankAddress" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"  value="${poVal.bankAddress }">
					  <label class="Validform_label" style="display: none;">账户归属</label>
				   </td>
				   <td align="left">
					  	<input name="ysUserBankList[${stuts.index }].bank" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"  value="${poVal.bank }">
					  <label class="Validform_label" style="display: none;">开户银行</label>
				   </td>
				   <td align="left">
					  	<input name="ysUserBankList[${stuts.index }].subbranch" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"  value="${poVal.subbranch }">
					  <label class="Validform_label" style="display: none;">支行名称</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
