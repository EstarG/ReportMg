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
    
    <title>My JSP 'showDate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="styles/query.css" />

	<script language="javascript" src="JP/Calendar2.js"></script>
	
	<script type="text/javascript">
	
		function f_reset(){
			var formObj = document.forms[0].elements;
			for(var i=0; i< formObj.length; i++){
				if(formObj[i].type == 'text'){
					//alert(formObj[i].value);
					formObj[i].value='';
				}
			}
			document.getElementById("empId").value= "0";
			document.getElementById("projectId").value= "0";
			return true;
		}
	
		function f_page(obj){
			
			with(document.forms[0]){
				action = "queryByDate_ReportAction";
				currentPage.value=obj;
				submit();
			}
			return false;
		}
		
		function export_report(obj) {
			 //alert("导出");
			with(document.forms[0]){
				currentPage.value=obj;
				action = "queryExportByDate_ReportAction";
				submit();
			}
		
		}
		
		 var cdr = new Calendar("cdr");
		  document.write(cdr);
		  cdr.showMoreDay = true;
		  
		  
		  function show(obj){
		  	
	    	window.open ("queryDate_ReportAction?cdate=" + obj, "newwindow", "height=280, width=750, toolbar=no, menubar=no, scrollbars=no scrollbars=no, resizable=yes,location=no, status=no,top = 250,left = 300");
	       }
	</script>

  </head>
  
  <body style="font-family: 微软雅黑" bgcolor="#ffffff">
<div
			style="height: 30px; margin-top: 2px; margin-left: 5px; margin-bottom:2px; background-color: #F5FFFA">
			<font face="幼圆" color="#008B8B" size="5"> 个人日报查询</font>
		</div>   
  

    <s:form action="queryByDate_ReportAction">
		<table bgcolor="#DCDCDC" style="margin:5px auto">
			<tr>
				<th colspan="6">日报-查询</th>
				
			</tr>
			<tr>
				<td style="width:150px">查询起始日期</td>
				<td><s:textfield name="begin" onfocus="cdr.show(this);"></s:textfield>
				</td>
				<td style="width:150px">查询结束日期</td>
				<td><s:textfield name="end" onfocus="cdr.show(this);"></s:textfield>
				</td>
				<td style="width:150px">负责人</td>
				<td>
				    
					<s:select list="empOptions" id="empId" name="empId" listKey="id" listValue="name"  headerKey="0" headerValue="请选择员工">
					</s:select>
				</td>
			</tr>
			
			<tr>
				<th colspan="6">
				<s:hidden name="currentPage"></s:hidden>
				<s:submit value="查询"></s:submit>
				
				<input type="button" value="重置" onclick="f_reset()"/>
			</th>
			</tr>		
		</table>
		
<div
			style="height: 30px; margin-top: 2px; margin-left: 5px; margin-bottom:2px; background-color: #F5FFFA">
			<font face="幼圆" color="#008B8B" size="5">查询到的日报信息</font>
		</div>   
		
		<table bgcolor="#DCDCDC" style="margin:5px auto">
			<tr><th>日期</th><th>工作量</th><th>加班</th></tr>
			
			<s:iterator var="r" value="reports">
				<tr>
				<td>
				<a style="cursor: hand;cursor: pointer;" target="_blank" onclick="show('<s:property value="#r.cdate"/>')">
				<font color="blue" ><s:property value="#r.cdate"/></font></a>   
				</td>
				<td><s:property  value="%{#r.workload}"/></td>
				<td><s:property value="#r.overtime"/></td>
				</tr>
			</s:iterator>
			<tr><td>Total</td><td> <s:property value="sumwork"/></td><td><s:property value="sumover"/></td></tr>
			
			<tr><th colspan="3" align="right"><div align="right"> 总页数：${allPage}  &nbsp;&nbsp;   
			
		 	<s:if test="%{currentPage > 1}">
			<a href="" onclick="javascript:return f_page(${currentPage-1})">上一页</a> &nbsp;&nbsp;
		   	</s:if>
			<s:else>
			上一页
			</s:else>
		   	 当前页:${currentPage}&nbsp;&nbsp;
		   	<s:if test="%{currentPage < allPage}">
		   	 <a href="" onclick="javascript:return f_page(${currentPage+1})">下一页</a>
		   	</s:if>
			<s:else>
			下一页
			</s:else>
		
			    <input type="button" onclick="export_report(${currentPage})" value="导出">
				
			</div>
			</th></tr>
		</table></s:form>
		
  </body>
</html>
