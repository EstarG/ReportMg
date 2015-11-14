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
    
    <title>My JSP 'getMyPass.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#DCDCDC">
  	<div>	
		<s:form action = "getBackPass_LoginAction">
			请输入您的姓名：<s:textfield name = "name" value = ""></s:textfield><br/><br/>
			请输入您的邮箱：<s:textfield name = "email" value = ""></s:textfield><br/>
			<s:submit value = "提交"></s:submit>	
		</s:form> 
		<font color = "red"><s:property value = "#request.message"/></font><br/>
		<font color = "red"><s:property value = "#request.message1"/></font><br/>
  		<font color = "red"><s:property value = "#request.message2"/></font><br/>
  		<font color = "red"><s:property value = "#request.message3"/></font>
	</div>
  </body>
</html>
