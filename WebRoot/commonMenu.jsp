<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" language="javascript">
	function f_show(con){
		var show = document.getElementById(con);
		if(show.style.display != 'block'){
			show.style.display = 'block';
		}else{
			show.style.display = 'none';
		}
	}
bb
</script>
<link type="text/css" rel="stylesheet" href="styles/menu.css" />
  </head>
  
  <body style="font-family: 微软雅黑">
  <div style="margin-top: 4px;margin-right: 0px; height: 492px;">
    <div id="content">

		<div id="query" class="query" onclick="f_show('queryDetails');">
		<img src="images/tip.jpg" onclick="f_show('reportConfigDetails');"/><font face="幼圆" color="black"><b>日报登陆</b></font><br/>
		</div>
		<div id="queryDetails" class="queryDetails">

	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	    <img src="images/tip5.jpg"/>&nbsp;<a href="query_ReportAction?empId = ${ session.user.id }" target="content" style="color:#1874CD;text-decoration:none"><font face="微软雅黑">日报管理</font></a><br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tip5.jpg"/>&nbsp;<a href="initAdd_ReportAction?empId = ${ session.user.id }" style="color: #1874CD; text-decoration: none"

					target="content"><font face="微软雅黑">新增个人日报</font></a>
				<br />
				&nbsp;&nbsp;&nbsp;&nbsp;
				<img src="images/tip5.jpg"/>&nbsp;<a href="queryReportDetail_ReportAction?empId = ${ session.user.id }& empName = ${ session.user.name }" style="color: #1874CD; text-decoration: none"
					target="content">未写日报查询</a>
				<br />
		</div>
		
		
		
		
		<div id="emp" class="query" onclick="f_show('empMg');">
		<img src="images/tip.jpg" onclick="f_show('reportConfigDetails');"/><font face="幼圆" color="black"><b>用户管理</b></font><br/>
		</div>
		<div id="empMg" class="empMg" style="display:none">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tip5.jpg"/>&nbsp;<a href="<%=basePath%>/emp/updatePassword.jsp" target="content" style="color: #1874CD;text-decoration:none">个人密码修改</font></a></li>
		</div>
		
	</div>	
	</div>
  </body>
</html>
