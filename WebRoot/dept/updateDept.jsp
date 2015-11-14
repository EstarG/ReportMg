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
    
    <title>My JSP 'updateDept.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-color: #DCDCDC; font-family: '微软雅黑'">
  <div
			style="height: 30px; margin-top: 2px; margin-left: 5px; margin-bottom:2px; background-color: #F5FFFA">
			<font face="幼圆" color="#008B8B" size="5">更新部门信息</font>
		</div>
    	
    	<s:form action="update_DeptAction">
    	    <s:hidden name = "id" value="%{dept.id}"></s:hidden>
    		部门名称：<s:textfield name = "name" value="%{dept.name}"></s:textfield> <br/><br/>
    		联系电话：<s:textfield name = "phone" value="%{dept.phone}"></s:textfield> <br/><br/>
    		部门传真：<s:textfield name = "fax" value="%{dept.fax}"></s:textfield> <br/><br/>
    		上级部门：
    		<s:select list="deptOptions" name = "pid" value="%{dept.pid}" listKey="fkey" listValue="fvalue">
    		</s:select>&nbsp;&nbsp;
    		<s:submit value="更新"></s:submit>
    	</s:form>
  </body>
</html>
