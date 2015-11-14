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
    
    <title>My JSP 'showPerson.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="styles/query.css" />

	
	
  </head>
  
  <body>

  
	查询到的日报信息
		<table border="2" bgcolor="#DCDCDC">
			
			<s:iterator var="r" value="reports">
			
				<tr><th>日期</th>
					<td><s:property value="#r.cdate"/>   </td>
					<th>填写人</th><td><s:property value="#r.empid"/></td>
				</tr>
				<tr >
					<th >任务</th><td colspan="3" ><s:property value="#r.task"/></td>
				</tr>	
				<tr>
					<th>工作量</th><td><s:property value="#r.workload"/>   </td>	
					<th>加班</th><td><s:property value="#r.overtime"/>   </td>
				</tr>
				<tr>
					<th>项目</th><td><s:property value="#r.projectid"/>   </td>
					<th>PRP阶段</th><td><s:property value="#r.prpid"/>   </td>
				</tr>
				<s:if test="%{#r.status=='未通过'}">
					<tr><th>拒绝原因</th><td colspan="3"><s:property value="#r.auditCause"/> </td></tr>
				</s:if>
				
				<tr>
					<th>审核状态</th><td colspan="3"><s:property value="#r.status"/>   </td>		
				</tr>
			
			</s:iterator>
			
		</table>

				
  </body>
</html>
