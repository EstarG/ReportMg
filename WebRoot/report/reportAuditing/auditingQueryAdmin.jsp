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
    
    <title>My JSP 'auditingQuery.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link type="text/css" rel="stylesheet" href="styles/report.css" />

<script language="javascript" src="./JP/Calendar2.js"></script>

<script type="text/javascript" language="javascript">
	function f_page(obj){
			with(document.forms[0]){
			   
				currentPage.value = obj;
				submit();
			}
			return false;
		}
</script>
<script type="text/javascript" language="javascript">
	function f_selectAll() {
 		var checkboxs=document.getElementsByName("ids");
 		for (var i=0;i<checkboxs.length;i++) {
  		var e=checkboxs[i];
  		e.checked=!e.checked;
 		}
	}
</script>
<SCRIPT type="text/javascript">
	function f_reset(){
		document.form1.empId.value = "0";
		document.form1.status.value = "0";
		document.form1.begin.value = "";
		document.form1.end.value = "";
		return false;
	}
</SCRIPT>
<script type="text/javascript" language="javascript">
	function f_updateOne() {
 		var checkboxs=document.getElementsByName("ids");
 		var num = 0;
 		for (var i=0;i<checkboxs.length;i++) {
 			var e=checkboxs[i];
 			if(e.checked){
 				num = num + 1;
 			}
 		}
 		if(num < 1){
 			window.alert("请勾选一条记录");
 			return false;
 		}else if(num > 1){
 			window.alert("您只能选择一条记录进行修改");
 			return false;
 		}else{
 			return true;
 		}
	}
</script>
  </head>
  
  <body onload="f_selectCheck()">
<script language="javascript">
  var cdr = new Calendar("cdr");
  document.write(cdr);
  cdr.showMoreDay = true;
</script>
    <div id="report">
    <s:form action="queryReportAuditAdmin_ReportAuditAction" name="form1">
	<table id="option">
	<tr>
		<th colspan="4">&nbsp;查询条件</th>
	</tr>
	
	<tr>
		<td style="width:150px;">人员</td>
		<td>
		<s:select list="empOptions" listKey="id" listValue="name" id="sel"
		 name="empId" headerKey="0" headerValue="请选择人员" value="%{empId}"></s:select>
		</td>
		<td style="width:150px;">审核状态</td>
		<td>
		<s:select name="status" list="statusOps" listKey="fkey" listValue="fvalue"
		 headerKey="0" headerValue="请选择状态"></s:select>
		</td>
	</tr>
	<tr>
		<td style="width:150px;">开始时间</td>
		<td>
		<s:textfield name="begin" onfocus="cdr.show(this);"></s:textfield>
		</td>
		<td style="width:150px;">结束时间</td>
		<td>
		<s:textfield name="end" onfocus="cdr.show(this);"></s:textfield>
		</td>
	</tr>	
	<s:hidden name="currentPage" value="1"></s:hidden>	
	<tr>
		<td colspan="4" style="text-align:right">
		<s:submit value="查询"></s:submit>
		<s:submit value="不通过" action="notPass_ReportAuditAction"></s:submit>
		<s:submit value="通过" action="passAll_ReportAuditAction"></s:submit>
		<s:submit value="修改" onclick="return f_updateOne()" action="queryAuditById_ReportAuditAction"></s:submit>
		<s:submit value="重置" onclick="return f_reset()"></s:submit>
		</td>
	</tr>
	</table>
	<div style="color:red"><s:property value="request.msg"/> </div>
	<table id="result">
		<tr>
		<th><s:checkbox name="boxAll" onclick="f_selectAll();">全选</s:checkbox>
		</th>
		<th>姓名</th><th>项目</th><th>工作内容</th><th>PRP阶段</th>
		<th>日期</th><th>工作量</th><th>加班</th><th>状态</th>
		</tr>
			<s:iterator var="ar" value="auditReports">
				<tr>
				<td><s:checkbox name="ids" fieldValue="%{#ar.id}"></s:checkbox> </td>
				<td><s:property value="#ar.eName"/> </td>
				<td><s:property value="#ar.proName"/> </td>
				<td><s:property value="#ar.task"/> </td>
				<td><s:property value="#ar.prpName"/> </td>
				<td><s:property value="#ar.cdate"/> </td>
				<td><s:property value="#ar.workload"/> </td>
				<td><s:property value="#ar.overtime"/> </td>
				<td>
				<s:if test="%{#ar.status == '未审核'}">
				<font color="red">	<s:property value="#ar.status"/>  </font>
				</s:if>
				<s:else>
				<s:property value="#ar.status"/>
				</s:else>
				</td>
				</tr>
			</s:iterator>
		<tr>
		<th colspan="9" >
		当前页：${currentPage }
		<s:if test="%{currentPage > 1}">
     	 <a href="" onclick="javascript:return f_page(${currentPage-1})">上一页</a> &nbsp;&nbsp;
     	 </s:if>
     	 <s:if test="%{currentPage <= 1}">上一页</s:if>
     	 <s:if test="%{currentPage < allPage}">
   	 	 <a href="" onclick="javascript:return f_page(${currentPage+1})">下一页</a> 
   	 	 </s:if>
   	 	 <s:if test="%{currentPage >= allPage}">下一页</s:if>
   	 	 <br/>
		总页数：${allPage }
		</th>
		</tr>
	</table>
	</s:form>
</div>
  </body>
</html>
