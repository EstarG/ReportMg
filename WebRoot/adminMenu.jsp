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
	<link type="text/css" rel="stylesheet" href="styles/menu.css" />
<script type="text/javascript" language="javascript">
	function f_show(con){
		var show = document.getElementById(con);
		if(show.style.display != 'block'){
			show.style.display = 'block';
		}else{
			show.style.display = 'none';
		}
	}

</script>

  </head>
  
  <body style="font-family: 微软雅黑">
  <div   style="margin-top: 4px;margin-right: 0px; height: 492px;" >
    <div id="content">
    	<div id="reportConfig" class="query" onclick="f_show('reportConfigDetails');">
		<img src="images/tip.jpg" onclick="f_show('reportConfigDetails');"/><font face="幼圆" color="black"><b>日报设定</b></font><br/>
		</div>
		<div id="reportConfigDetails" class="reportConfigDetails" style="display:none">
		 &nbsp;<font face="微软雅黑">&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tip5.jpg"/>&nbsp;<a href="init_DeptAction" style="color:#1874CD;text-decoration:none" target="content">部门设定</a></li><br />
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tip5.jpg"/>&nbsp;<a href="query_ProjectAction" target="content" style="color: #1874CD;text-decoration:none">项目设定</a></li><br />
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tip5.jpg"/>&nbsp;<a href="queryPrp_PrpAction" target="content" style="color:#1874CD;text-decoration:none">PRP阶段设定</a></font>
		</div>
		
		<div id="query" class="query" onclick="f_show('queryShow');">
		<img src="images/tip.jpg" onclick="f_show('reportConfigDetails');"/><font face="幼圆" color="black"><b>日报查询</b></font><br/>
		</div>
		<div id="queryShow" class="queryDetails">
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tip5.jpg"/>&nbsp;<a href="queryByDate_ReportAction" target="content" style="color:#1874CD;text-decoration:none"><font face="微软雅黑">按日期查询</font></a><br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tip5.jpg"/>&nbsp;<a href="queryByProject_ReportAction" style="color: #1874CD; text-decoration: none" target="content">按项目查询</a>
		<br />
		</div>
		
		<div id="query" class="query" onclick="f_show('queryAudit');">
		<img src="images/tip.jpg" onclick="f_show('reportConfigDetails');"/><font face="幼圆" color="black"><b>日报审核</b></font><br/>
		</div>
		<div id="queryAudit" class="queryDetails">
	     &nbsp; &nbsp;&nbsp;&nbsp;<img src="images/tip5.jpg"/>&nbsp;<a href="queryReportAuditAdmin_ReportAuditAction" target="content" style="color:#1874CD;text-decoration:none"><font face="微软雅黑">日报审核</font></a><br />
		</div>
    	<div id="emp" class="query" onclick="f_show('empMg');">
		<img src="images/tip.jpg" onclick="f_show('reportConfigDetails');"/><font face="幼圆" color="black"><b>用户管理</b></font><br/>
		</div>
		<div id="empMg" class="empMg" style="display:none">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tip5.jpg"/>&nbsp;<a href="query_EmpAction" target="content" style="color: #1874CD;text-decoration:none">员工信息管理</a></li><br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tip5.jpg"/>&nbsp;<a href="newPass_EmpAction" target="content" style="color: #1874CD;text-decoration:none">个人密码修改</font></a></li>
		</div>
		<div id="sys" class="query" onclick="f_show('log');">
		<img src="images/tip.jpg" onclick="f_show('reportConfigDetails');"/><font face="幼圆" color="black"><b>系统管理</b></font><br/>
		</div>
		<div id="log" class="log" style="display:none">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tip5.jpg"/>&nbsp;<a href="querylog_LogAction" target="content" style="color: #1874CD;text-decoration:none"><font face="微软雅黑">日志管理操作</font></a><br />
		</div>
    
	</div>
	</div>
  </body>
</html>
