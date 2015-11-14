<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'empDetails.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form>
  		<table border = 1 bgcolor = "#F5F5DC">
  			<tr><th></th><th></th><th></th><th align = "center">员工详细信息</th></tr>
  			<tr>
  			    <s:hidden name="id" value="%{emp.id}"></s:hidden>
	  			<td>部门:</td><td><s:select list = "deptOptions" listKey="fkey" listValue="fvalue" 
	  			headerKey="0" headerValue="请选择" name = "deptId" disabled="true" value = "%{emp.did}"></s:select></td>
	  			<td>姓名:</td><td><s:textfield name = "name" value = "%{emp.name}" readonly="true"></s:textfield></td>
	  			<td>性别:</td><td><s:select list = "sexOptions"  disabled="true" name = "sex" value = "%{emp.sex}" listKey="fkey" 
	  			listValue="fvalue" headerKey="0" headerValue="请选择">
	  			</s:select></td>
  			</tr>
  			<tr>
	  			<td>是否领导:</td><td><s:select list = "roleOptions" disabled="true" name = "erole" value = "%{emp.erole}"listKey="fkey" 
	  			listValue="fvalue" headerKey="0" headerValue="请选择">
	  			</s:select></td>
	  			<td>民族:</td><td><s:select list = "nationOptions" name = "nation" disabled="true" value = "%{emp.nation}" listKey="fkey" 
	  			listValue="fvalue" headerKey="0" headerValue="请选择">
	  			</s:select></td>
	  			<td>英文名:</td><td><s:textfield name = "engname" value = "%{emp.engname}" readonly="true"></s:textfield></td>
  			</tr>
  			<tr>
	  			<td>生日:</td><td>
	  			<s:textfield name = "birth"  onfocus="cdr.show(this);" readonly="true">
	  				<s:param name = "value"> <s:date name="%{emp.birth}" format="yyyy-MM-dd"/> </s:param>
	  			</s:textfield>
	  			</td>
	  			<td>家庭电话:</td><td><s:textfield name = "homephone" value = "%{emp.homephone}" readonly="true"></s:textfield></td>
	  			<td>籍贯:</td><td><s:textfield name = "address" value = "%{emp.address}" readonly="true"></s:textfield></td>
  			</tr>
  			<tr>
	  			<td>QQ:</td><td><s:textfield name = "qq" value = "%{emp.qq}" readonly="true"></s:textfield></td>
	  			<td>邮箱地址:</td><td><s:textfield name = "email" value = "%{emp.email}" readonly="true"></s:textfield></td>
	  			<td>联系方式:</td><td><s:textfield name = "officephone" value = "%{emp.officephone}" readonly="true"></s:textfield></td>
  			</tr>
  			<tr>
	  			<td>毕业学校:</td><td><s:textfield name = "school" value = "%{emp.school}" readonly="true"></s:textfield></td>
	  			<td>毕业日期:</td><td>
	  			<s:textfield name = "graddate" onfocus="cdr.show(this);" readonly="true">
	  				<s:param name = "value"><s:date name = "%{emp.graddate}" format = "yyyy-MM-dd"/></s:param>
	  			</s:textfield></td>	
  			</tr>
  		</table>
  	</form>
  </body>
</html>
