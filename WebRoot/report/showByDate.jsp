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
    
    <title>My JSP 'showPerson.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="styles/query.css" />
	
	
	<script type="text/javascript">
	
	
		function f_page(obj){
			//alert("换页");
			with(document.forms[0]){
				currentPage.value=obj;
				submit();
			}
			return false;
		}
	
		 
		  
	</script>
	
  </head>
  
  <body>

  <s:form action="queryDate_ReportAction">
		个人日报查询
	<s:hidden name="currentPage" value="1"></s:hidden>
	<s:hidden name="cdate"></s:hidden>
查询到的日报信息
		<table border="2" bgcolor="#DCDCDC">
			<tr><th>日期</th><th>项目</th><th>PRP阶段</th><th>任务</th><th>工作量</th><th>加班</th><th>状态</th></tr>
			<s:iterator var="r" value="reports">
				<tr>
					
					<td>
					<s:property value="#r.cdate"/>   </td>
					
					<td><s:property value="#r.projectid"/>   </td>
					<td><s:property value="#r.prpid"/>   </td>
					<td><s:property value="#r.task"/>   </td>
					<td><s:property value="#r.workload"/>   </td>
					<td><s:property value="#r.overtime"/>   </td>
					<td><s:if test="%{#r.status=='未通过'}">
						<font color="red">	<s:property value="#r.status"/></font>
						</s:if> 
						<s:else>
						 <s:property value="#r.status"/></s:else>   </td>
				   
				</tr>
			
			</s:iterator>
			<tr><th colspan="9">总页数：${allPage}  &nbsp;&nbsp;   
			
		 	<s:if test="%{currentPage > 1}">
			<a href="" onclick="javascript:return f_page(${currentPage-1})">上一页</a> &nbsp;&nbsp;
		   	</s:if>
			<s:else>
			上一页
			</s:else>
		   	 当前页:${currentPage}&nbsp;&nbsp;
		   	<s:if test="%{currentPage < allPage}">
		   	 <a href="" onclick="javascript:return f_page(${currentPage+1})">下一页</a><br/>
		   	</s:if>
			<s:else>
			下一页
			</s:else></th></tr>
		</table>
</s:form>
				
  </body>
</html>
