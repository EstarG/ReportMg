<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UpdateEmp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript" src = "<%=basePath%>/JP/Calendar2.js"></script>
	<script type="text/javascript" src="<%=basePath%>/JP/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(document).ready(
			function(){
				$("#sf").change(
					function(){
						var fkey = $(this).val();
						$.post(
							"getCitys_EmpAction",
							{"fkey":fkey},
							call_back,
							"json"
						);
					}
				);
			}
		);
		function call_back(data){
			$("#city").empty();
			$.each(data,function(indx,obj){
								$("#city").append("<option value='"+obj.fkey+"'>"+obj.fvalue+"</option>");
			});
		}
	</script>
  </head>
  
  <body>
  <script language="javascript">
		  var cdr = new Calendar("cdr");
		  document.write(cdr);
		  cdr.showMoreDay = true;
  </script>
  <div align = "center">
  	<form action="update_EmpAction" >
  	<font color = "red"><s:property value = "#request.updateMess"/></font>
  		<table border = 1 bgcolor = "#F5F5DC">
  			<tr><th></th><th></th><th></th><th align = "center">员工管理-修改员工</th></tr>
  			<tr>
  			    <s:hidden name="id" value="%{emp.id}"></s:hidden>
	  			<td>部门:</td><td><s:select list = "deptOptions" listKey="fkey" listValue="fvalue" 
	  			headerKey="0" headerValue="请选择" name = "deptId" value = "%{emp.did}"></s:select></td>
	  			<td>姓名:</td><td><s:textfield name = "name" value = "%{emp.name}"></s:textfield></td>
	  			<td>性别:</td><td><s:select list = "sexOptions" name = "sex" value = "%{emp.sex}" listKey="fkey" 
	  			listValue="fvalue" headerKey="0" headerValue="请选择">
	  			</s:select></td>
  			</tr>
  			<tr>
	  			<td>是否领导:</td><td><s:select list = "roleOptions" name = "erole" value = "%{emp.erole}"listKey="fkey" 
	  			listValue="fvalue" headerKey="0" headerValue="请选择">
	  			</s:select></td>
	  			<td>民族:</td><td><s:select list = "nationOptions" name = "nation"  value = "%{emp.nation}" listKey="fkey" 
	  			listValue="fvalue" headerKey="0" headerValue="请选择">
	  			</s:select></td>
	  			<td>英文名:</td><td><s:textfield name = "engname" value = "%{emp.engname}"></s:textfield></td>
  			</tr>
  			<tr>
	  			<td>生日:</td><td>
	  			<s:textfield name = "birth"  onfocus="cdr.show(this);">
	  				<s:param name = "value"> <s:date name="%{emp.birth}" format="yyyy-MM-dd"/> </s:param>
	  			</s:textfield>
	  			</td>
	  			<td>家庭电话:</td><td><s:textfield name = "homephone" value = "%{emp.homephone}"></s:textfield></td>
	  			<td>籍贯:</td><td><s:select list = "sfOptions" name = "address" listKey = "fkey" 
	  			      listValue="fvalue" value="sf" id = "sf" headerKey="0" headerValue="请选择"></s:select>
	  			      <select id = "city" name = "address">
	  			      	<option value = "city">${mycity}</option>
	  			      </select>
	  			      </td>
  			</tr>
  			<tr>
	  			<td>QQ:</td><td><s:textfield name = "qq" value = "%{emp.qq}"></s:textfield></td>
	  			<td>邮箱地址:</td><td><s:textfield name = "email" value = "%{emp.email}"></s:textfield></td>
	  			<td>联系方式:</td><td><s:textfield name = "officephone" value = "%{emp.officephone}"></s:textfield></td>
  			</tr>
  			<tr>
	  			<td>毕业学校:</td><td><s:textfield name = "school" value = "%{emp.school}"></s:textfield></td>
	  			<td>毕业日期:</td><td>
	  			<s:textfield name = "graddate" onfocus="cdr.show(this);">
	  				<s:param name = "value"><s:date name = "%{emp.graddate}" format = "yyyy-MM-dd"/></s:param>
	  			</s:textfield></td>	
  			</tr>
  			<tr><td></td><td></td><td></td><td></td><td></td><td align = "right"><s:submit value = "修改"></s:submit></td></tr>
  		</table>
  	</form>
  	</div>
  </body>
</html>
