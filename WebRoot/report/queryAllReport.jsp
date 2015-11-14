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
    
    <title>My JSP 'queryAllReport.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=basePath%>/JP/jquery-1.7.2.js"> </script>
	<SCRIPT type="text/javascript">
		function f_getName(obj) {
			//alert(obj.options[obj.selectedIndex].text);
			document.getElementById("empName").value = obj.options[obj.selectedIndex].text;
		}
		function f_sendEmail() {
			window.location.href = "mailto:raymond@neusoft.com";
		}
	</SCRIPT>
	
  </head>
  
  <body>
     <s:form action="queryAllReport_ReportAction">
       
       <s:select list="empOptions" id = "empId" name = "empId" listKey="id"  listValue="name" headerKey="0" headerValue="选择下属" onchange="f_getName(this)"></s:select>  
       <s:hidden name = "empName" id = "empName"  value=""></s:hidden>    
       
       <s:hidden name = "deptId" value="%{deptId}"></s:hidden>
       <s:submit value="查询"></s:submit>
       
       <div>
       		<input type="button" value="发送邮件" onclick="f_sendEmail()"/>
       </div>
       
       <br/> <br/>
		<!--       打出表头-->
      
 	    <table border="1" width="200">
	        <tr>  
		        <s:iterator var = "title" value="titleDate">
			     	<th>  <div style="font-size: 8"> <s:property value="#title"/> </div>  </th> 
		     	</s:iterator>
	     	</tr>
	     	
	     
		     	<s:iterator var = "reportNumber" value="writeReportDetail">
		     		<tr>
			     		 <s:iterator var = "rn" value="#reportNumber">
			     		 
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
		     	</s:iterator>	
     	</table>
     	
      </s:form>	
  </body>
</html>
