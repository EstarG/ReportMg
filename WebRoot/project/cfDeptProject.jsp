<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deptMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=basePath%>treeview/jquery.treeview.css" />

	<script src="<%=basePath%>/treeview/jquery.js" type="text/javascript"></script>
	<script src="<%=basePath%>/treeview/jquery.cookie.js" type="text/javascript"></script>
	<script src="<%=basePath%>/treeview/jquery.treeview.js" type="text/javascript"></script>
	<script src="<%=basePath%>/treeview/jquery.treeview.edit.js" type="text/javascript"></script>
	<script src="<%=basePath%>/treeview/jquery.treeview.async.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#trees").treeview({url:"getDeptTree2_DeptAction?projectId=${project.id}",});
		});
		
		function f_clear() {
			var depts = document.getElementsByName("deptIds");
			var length = depts.length;
			
			//alert(length);
			for (var i = 0; i < length; ++i) {
				depts[i].checked = false;
			}
		}
		
	</script>
  </head>
  
  <body bgcolor="#ffffff" style="font-family: 微软雅黑">
	<div
			style="height: 30px; margin-top: 2px; margin-left: 5px; margin-bottom:2px; background-color: #ffffff">
			<font face="幼圆" color="#000000" size="5">部门列表</font>
		</div>
	
	<hr>
	<div
			style="height: 30px; margin-top: 2px; margin-left: 5px; margin-bottom:2px; background-color: #DCDCDC">
			<font face="幼圆" color="#ffffff" size="5">部门配置</font>
		</div>
	 
<!--      ${project.id}   -->
      <font color="red">  <font size="5" color="blue"> ${project.name} </font> : 已配置  ${fn:length(proDepts)}  了个部门</font>
	  <s:form action="configDept_ProjectAction">
	      <s:hidden name = "id" value="%{project.id}"></s:hidden>
	      
	      
		  <div style="margin-left: 150px">
		  		<ul id = "trees"></ul>
		  </div>
		  
		  <div align="right">
		  		<s:submit value="配置"></s:submit>
		  	    <input type="button" value="重置"  onclick="f_clear()"/>
		  </div>
		 
	  </s:form>
	  
</body>
</html>
