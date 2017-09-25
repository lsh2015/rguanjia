<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addYsUserWorkBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delYsUserWorkBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addYsUserWorkBtn').bind('click', function(){   
 		 var tr =  $("#add_ysUserWork_table_template tr").clone();
	 	 $("#add_ysUserWork_table").append(tr);
	 	 resetTrNum('add_ysUserWork_table');
	 	 return false;
    });  
	$('#delYsUserWorkBtn').bind('click', function(){   
      	$("#add_ysUserWork_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_ysUserWork_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#ysUserWork_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addYsUserWorkBtn" href="#">添加</a> <a id="delYsUserWorkBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="ysUserWork_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						单位名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						职业
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						入职时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						离职时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						工作内容
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						备注
				  </td>
	</tr>
	<tbody id="add_ysUserWork_table">
	<c:if test="${fn:length(ysUserWorkList)  > 0 }">
		<c:forEach items="${ysUserWorkList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="ysUserWorkList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
				   <td align="left">
					  	<input name="ysUserWorkList[${stuts.index }].company" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;"  value="${poVal.company }">
					  <label class="Validform_label" style="display: none;">单位名称</label>
				   </td>
				   <td align="left">
					  	<input name="ysUserWorkList[${stuts.index }].profession" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;"  value="${poVal.profession }">
					  <label class="Validform_label" style="display: none;">职业</label>
				   </td>
				   <td align="left">
							<input name="ysUserWorkList[${stuts.index }].startDate" maxlength="0" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:100px;"    value="<fmt:formatDate value='${poVal.startDate}' type="date" pattern="yyyy-MM-dd"/>">
					  <label class="Validform_label" style="display: none;">入职时间</label>
				   </td>
				   <td align="left">
							<input name="ysUserWorkList[${stuts.index }].endDate" maxlength="0" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:100px;"    value="<fmt:formatDate value='${poVal.endDate}' type="date" pattern="yyyy-MM-dd"/>">
					  <label class="Validform_label" style="display: none;">离职时间</label>
				   </td>
				   <td align="left">
					       	<input name="ysUserWorkList[${stuts.index }].workInfo" maxlength="5000" 
						  		type="text" class="inputxt"  style="width:100px;"   value="${poVal.workInfo }">
					  <label class="Validform_label" style="display: none;">工作内容</label>
				   </td>
				   <td align="left">
					  	<input name="ysUserWorkList[${stuts.index }].remark" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;"  value="${poVal.remark }">
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
