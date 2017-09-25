<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addYsUserAddressBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delYsUserAddressBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addYsUserAddressBtn').bind('click', function(){   
 		 var tr =  $("#add_ysUserAddress_table_template tr").clone();
	 	 $("#add_ysUserAddress_table").append(tr);
	 	 resetTrNum('add_ysUserAddress_table');
	 	 return false;
    });  
	$('#delYsUserAddressBtn').bind('click', function(){   
      	$("#add_ysUserAddress_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_ysUserAddress_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#ysUserAddress_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addYsUserAddressBtn" href="#">添加</a> <a id="delYsUserAddressBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="ysUserAddress_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						地址
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						地址图片
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						经度
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						纬度
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
	</tr>
	<tbody id="add_ysUserAddress_table">
	<c:if test="${fn:length(ysUserAddressList)  > 0 }">
		<c:forEach items="${ysUserAddressList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="ysUserAddressList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
				   <td align="left">
					  	<input name="ysUserAddressList[${stuts.index }].addressInfo" maxlength="500" 
					  		type="text" class="inputxt"  style="width:120px;"  value="${poVal.addressInfo }">
					  <label class="Validform_label" style="display: none;">地址</label>
				   </td>
				   <td align="left">
					  	<input name="ysUserAddressList[${stuts.index }].images" maxlength="500" 
					  		type="text" class="inputxt"  style="width:120px;"  value="${poVal.images }">
					  <label class="Validform_label" style="display: none;">地址图片</label>
				   </td>
				   <td align="left">
					  	<input name="ysUserAddressList[${stuts.index }].longitude" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"  value="${poVal.longitude }">
					  <label class="Validform_label" style="display: none;">经度</label>
				   </td>
				   <td align="left">
					  	<input name="ysUserAddressList[${stuts.index }].latitude" maxlength="12" 
					  		type="text" class="inputxt"  style="width:120px;"  value="${poVal.latitude }">
					  <label class="Validform_label" style="display: none;">纬度</label>
				   </td>
				   <td align="left">
					  	<input name="ysUserAddressList[${stuts.index }].remark" maxlength="200" 
					  		type="text" class="inputxt"  style="width:120px;"  value="${poVal.remark }">
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
