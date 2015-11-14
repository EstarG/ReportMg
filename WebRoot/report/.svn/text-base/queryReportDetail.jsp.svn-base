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
    
    <title>My JSP 'queryReportDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <h1>个人未写日报查询</h1>
     
     <table border="1" width="50px">
       
<!--       打出表头-->
      
     
       <tr>  
	        <s:iterator var = "title" value="titleDate">
		     	<th> <div style="font-size: 8"> <s:property value="#title"/> </div> </th> 
	     	</s:iterator>
     	</tr>
<!--     内容	-->
     	 <tr>
	     
	       
	        <s:iterator var = "rn" value="reportNumber">
	             <s:if test="%{#rn.key == 'name'}">
	             	<td>
	             		 <s:property value="#rn.value"/>
	             	</td>
	             </s:if>
	             <s:else>
	               <s:if test="%{#rn.value > 0}">
	            	<td bgcolor="yellow">
		     			<s:property value="#rn.value"/>
		     		</td>
		            </s:if>
		            <s:else>
		            	<td bgcolor="red">
			     		</td>
		            </s:else>
	             </s:else>
	     	</s:iterator>
     	</tr>
     </table>
  </body>
</html>
