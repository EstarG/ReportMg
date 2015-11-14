<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="application/msexcel; charset = utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!-- 以上这行设定本网页为excel格式的网页 -->
<%
   response.setHeader("Content-disposition","inline; filename=report.xls");
   //以上这行设定传送到前端浏览器时的档名为test1.xls
   //就是靠这一行，让前端浏览器以为接收到一个excel档
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'export.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table border="1" width="100%"> 
    	<tr> <th>项目名称 </th> <th>工作量</th> <th>加班</th> </tr>
    	<s:iterator var = "r" value="reports">
    	
				<tr>
				<td><s:property value="#r.project"/></td>
				<td><s:property value="#r.workload"/></td>
				<td><s:property value="#r.overtime"/></td>
				</tr>
		
    	</s:iterator>
    	<tr><td>Total</td><td> <s:property value="sumwork"/></td><td><s:property value="sumover"/></td></tr>
  	</table>
  </body>
</html>
