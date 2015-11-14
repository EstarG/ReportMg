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
			$("#trees").treeview({url:"getDeptTree_DeptAction",});
		});
	</script>
  </head>
  
  <body style="font-family: '微软雅黑'" >
  <div style="background-color:#e8f0ff;height: 490px;">
    <div
			style="height: 30px; margin-left:0px;  background-color: #f4f9ff">
			<font face="幼圆" color="#008B8B" size="5">部门列表</font> 
		</div><br/>

	 <a href="addInit_DeptAction" target="deptcontent" style="text-decoration:none"><font face="微软雅黑" color="#78878a" size="3">&nbsp;&nbsp;&nbsp;添加部门</font>  
	 </a> 
	 <a href="<%=basePath%>/dept/configDept.jsp" target="content" style="text-decoration:none"><font face="微软雅黑" color="#78878a" size="3">&nbsp;&nbsp;&nbsp;刷新部门列表</font>  
	 </a> 
	  <br/><br/>

	 

	<hr color="#b9bbbc" size="3">
	   
	 <ul id = "trees"></ul>
	  
	  
	  
	  </div>
</body>
</html>
