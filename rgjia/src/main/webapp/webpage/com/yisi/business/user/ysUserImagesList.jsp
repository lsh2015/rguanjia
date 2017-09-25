<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addYsUserImagesBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delYsUserImagesBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addYsUserImagesBtn').bind('click', function(){   
 		 var tr =  $("#add_ysUserImages_table_template tr").clone();
	 	 $("#add_ysUserImages_table").append(tr);
	 	 resetTrNum('add_ysUserImages_table');
	 	 return false;
    });  
	$('#delYsUserImagesBtn').bind('click', function(){   
      	$("#add_ysUserImages_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_ysUserImages_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#ysUserImages_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addYsUserImagesBtn" href="#">添加</a> <a id="delYsUserImagesBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="ysUserImages_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						图片路径
				  </td>
	</tr>
	<tbody id="add_ysUserImages_table">
	<c:if test="${fn:length(ysUserImagesList)  > 0 }">
		<c:forEach items="${ysUserImagesList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="ysUserImagesList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
				   <td align="left">
					  	<input name="ysUserImagesList[${stuts.index }].imageUrl" maxlength="500" 
					  		type="text" class="inputxt"  style="width:120px;"  value="${poVal.imageUrl }">
					  <label class="Validform_label" style="display: none;">图片路径</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
