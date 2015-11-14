<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


  </head>
<frameset cols="145,*,145" border="0" >
	<frame  src=""name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" >
	<frameset rows="110,*">
		<frame src="top.jsp" noresize="noresize" scrolling="no" />
		<frameset cols="180,*" >
			<frame src="<%=basePath%>/adminMenu.jsp" noresize="noresize"
				scrolling="no" />
			<frame src="<%=basePath%>/content.html" noresize="noresize" name="content" marginheight="4px" marginwidth="4px"
			style="overflow-x:hidden;"/>
			<!-- style="overflow-x:hidden;"  -->
	</frameset>
	</frameset>
	<frame/>
	</frameset>
</html>
