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
    
    <title>My JSP 'updatePassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link type="text/css" rel="stylesheet" href="styles/query.css" />
    <SCRIPT type="text/javascript">
    	function checkOld(){
    		var obj  = " ${session.user.userpassword} ".toString().trim();	
    		if(document.form1.userpassword.value != obj){
    			alert("原密码错误！");
    		}
    		return false;
    	}
    	function checkPass(){
    		if(document.form1.userpassword.value==""){
				alert("原密码不能为空！");
				document.form1.userpassword.focus();
				return false;
			}else if(document.form1.newPassword.value==""){
				alert("新密码不能为空！");
				document.form1.newPassword.focus();
				return false;
			}else if(document.form1.newpassword2.value=="" || (document.form1.newpassword2.value != document.form1.newPassword.value)){
				alert("重复密码错误！");
				document.form1.newpassword2.focus();
				return false;
			}else document.form1.submit();
    	}
    </SCRIPT>
  </head>
  
  <body style="font-family: 微软雅黑">
  <div style="background-color: #DCDCDC">
  <form action="updatePassword_EmpAction" onsubmit="return checkPass()" name = "form1">
<!--  <input name = "id" value = "${session.user.id}"/>-->
  <s:hidden name = "id" value="%{#session.user.id}"></s:hidden>
  <font color = "red"><s:property value = "#request.message"/></font>
  <table align="center">
		<tr ><th style="color: #000000" colspan="2"><div align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改密码</div></th></tr>
		<tr><td style="width:150px">用户名：</td>
			<td style="width:200px"><input type="text" name = "username" value="${session.user.username}"/></td>
		</tr>
		<tr><td style="width:150px">原密码：</td>
			<td style="width:280px"><input type="password" name = "userpassword" value = "" onblur="checkOld();"/></td>
		</tr>
		<tr><td style="width:150px">新密码：</td>
			<td style="width:280px"><input type="password" name = "newPassword"/></td>
		</tr>
		<tr><td style="width:150px">确认密码：</td>
			<td style="width:280px"><input type="password" name = "newpassword2"/></td>
		</tr>
		<tr><th colspan="2"><div align="right"><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="返回" onclick = "location.href='content.html';"/></div></th></tr>
	</table></form>
	</div>
  </body>
</html>
