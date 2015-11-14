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
    
    <title>My JSP 'addDept.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-color: #B0E0E6; font-family: '微软雅黑'">
  <div
			style="height: 30px; margin-top: 2px; margin-left: 5px; margin-bottom:2px; background-color: #F5FFFA">
			<font face="幼圆" color="#008B8B" size="5">添加子部门</font>
		</div>
   		
    	<s:form action="add_DeptAction">
    		
    		<table>
	    		 <tr>
		    		<td>  部门名称：<s:textfield name = "name"></s:textfield> </td>
		    		<td>  联系电话：<s:textfield name = "phone" onkeyup="this.value=this.value.replace(/[^\d-]/g,'')" ></s:textfield> </td>
		    	</tr>
		    	
		    	
		    	<tr>
		    		
		    		<td> 传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真：<s:textfield name = "fax" onkeyup="this.value=this.value.replace(/[^\d-]/g,'')"></s:textfield> </td>
		    		<td> 
		    			上级部门：
		    			<s:select list="deptOptions" name = "pid" listKey="fkey" listValue="fvalue" headerKey="1" headerValue="请选择部门">
		    			</s:select> 
		    			
		    		</td>
		    		
		    		
		    	</tr>	   
		    	<tr>   <td> <font color="red"> 默认为一级部门 </font> </td> </tr>
		    	
	    	
    		</table>
    		
    		<s:submit value="添加"></s:submit>
    		<s:reset value="重置"></s:reset>
    		
    	</s:form>
    	
  </body>
</html>
