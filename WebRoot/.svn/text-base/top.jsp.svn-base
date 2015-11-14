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
    
    
    
    
    <title>My JSP 'top' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<SCRIPT LANGUAGE="JavaScript">
		function gettime(){
				var datetime = new Date();
				var year = datetime.getFullYear();
				var month = datetime.getMonth()+1;//js从0开始取
				var date = datetime.getDate();
				var hour = datetime.getHours();
				var minutes = datetime.getMinutes();
				var second = datetime.getSeconds();
				
				if(month<10){
				month = "0" + month;
				}
				if(date<10){
				date = "0" + date;
				}
				if(hour <10){
				hour = "0" + hour;
				}
				if(minutes <10){
				minutes = "0" + minutes;
				}
				if(second <10){
				second = "0" + second ;
				}
				
				var time = year+"-"+month+"-"+date+" "+hour+":"+minutes+":"+second; //2009-06-12 17:18:05

				document.getElementById("t").innerHTML =time;
				window.setTimeout("gettime()",1000);
			}
	
			window.onload = gettime;
	</SCRIPT>
  </head>

  <body background="images/toppic1.jpg">
     <div align = "right">
     	<s:if test="#session.user.name != null">
	    	<div style = "margin-top: 70px;"><font size="2" face="微软雅黑" color = "#002d7e">您好：<s:property value = "#session.user.name"/>
	    		<a style='text-decoration:none;' href = "exit_LoginAction" >退出</a></font>
	    	</div>
    	</s:if>
    	<div id = "t" style = ""></div>	
    </div>   

  </body>
</html>
