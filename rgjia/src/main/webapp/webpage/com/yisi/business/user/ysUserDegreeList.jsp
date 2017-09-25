<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addYsUserDegreeBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delYsUserDegreeBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addYsUserDegreeBtn').bind('click', function(){   
 		 var tr =  $("#add_ysUserDegree_table_template tr").clone();
	 	 $("#add_ysUserDegree_table").append(tr);
	 	 resetTrNum('add_ysUserDegree_table');
	 	 return false;
    });  
	$('#delYsUserDegreeBtn').bind('click', function(){   
      	$("#add_ysUserDegree_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_ysUserDegree_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#ysUserDegree_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addYsUserDegreeBtn" href="#">添加</a> <a id="delYsUserDegreeBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="ysUserDegree_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						学校名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						学历
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						专业
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						入学时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						毕业时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						备注
				  </td>
	</tr>
	<tbody id="add_ysUserDegree_table">
	<c:if test="${fn:length(ysUserDegreeList)  > 0 }">
		<c:forEach items="${ysUserDegreeList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="ysUserDegreeList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
				   <td align="left">
					  	<input name="ysUserDegreeList[${stuts.index }].school" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;"  value="${poVal.school }">
					  <label class="Validform_label" style="display: none;">学校名称</label>
				   </td>
				   <td align="left">
					  	<input name="ysUserDegreeList[${stuts.index }].education" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;"  value="${poVal.education }">
					  <label class="Validform_label" style="display: none;">学历</label>
				   </td>
				   <td align="left">
					  	<input name="ysUserDegreeList[${stuts.index }].specialty" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;"  value="${poVal.specialty }">
					  <label class="Validform_label" style="display: none;">专业</label>
				   </td>
				   <td align="left">
							<input name="ysUserDegreeList[${stuts.index }].startDate" maxlength="0" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:100px;"    value="<fmt:formatDate value='${poVal.startDate}' type="date" pattern="yyyy-MM-dd"/>">
					  <label class="Validform_label" style="display: none;">入学时间</label>
				   </td>
				   <td align="left">
							<input name="ysUserDegreeList[${stuts.index }].endDate" maxlength="0" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:100px;"    value="<fmt:formatDate value='${poVal.endDate}' type="date" pattern="yyyy-MM-dd"/>">
					  <label class="Validform_label" style="display: none;">毕业时间</label>
				   </td>
				   <td align="left">
					  	<input name="ysUserDegreeList[${stuts.index }].remark" maxlength="500" 
					  		type="text" class="inputxt"  style="width:100px;"  value="${poVal.remark }">
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
