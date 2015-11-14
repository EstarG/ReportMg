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
    
    <title>My JSP 'auditingUpdate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link type="text/css" rel="stylesheet" href="styles/report.css" />
<SCRIPT type="text/javascript">
	function f_checkRadio(){
		
		var noAudit = document.form1.statusPanbie.value;
		//alert(noAudit);
		if(noAudit != "1"){
			var radios=document.getElementsByName("status");
 			for (var i=0;i<radios.length;i++) {
  				var e=radios[i];
  				if(e.value == "1"){
  					e.disabled = "true";
  					break;
  				}
 			}
		}
	}
</SCRIPT>
  </head>
  
  <body onload="f_checkRadio()">
  <s:form action="updateAudit_ReportAuditAction" name="form1">
    <div id="report">

	<table id="option">
	<tr>
		<th colspan="4"> 日报信息</th>
	</tr>
	<s:hidden name="id" value="%{reportMap.id}"></s:hidden>
	<s:hidden name="empId" value="%{reportMap.empId}"></s:hidden>
	<tr>
	<s:hidden name="emp" value="%{emp}"></s:hidden>
		<td style="width:150px;">姓名</td>
		<td>
		<s:textfield name="eName" value="%{reportMap.eName}" readonly="true"></s:textfield>
		</td>
		<td style="width:150px;">日期</td>
		<td>
		<s:textfield name="cdate" value="%{reportMap.cdate}" readonly="true"></s:textfield>
		</td>
	</tr>
	<tr>
		<td style="width:150px;">工作量</td>
		<td>
		<s:textfield name="workload" value="%{reportMap.workload}" readonly="true"></s:textfield>
		</td>
		<td style="width:150px;">加班量</td>
		<td>
		<s:textfield name="overtime" value="%{reportMap.overtime}" readonly="true"></s:textfield>
		</td>
	</tr>	
	<tr>
		<td style="width:150px;">项目</td>
		<s:hidden name="proId" value="%{reportMap.proId}"></s:hidden>
		<td>
		<s:textfield name="proName" value="%{reportMap.proName}" readonly="true"></s:textfield>
		</td>
		<s:hidden name="prpId" value="%{reportMap.prpId}"></s:hidden>
		<td style="width:150px;">PRP阶段</td>
		<td>
		<s:textfield name="prpName" value="%{reportMap.prpName}" readonly="true"></s:textfield>
		</td>
	</tr>
	<tr>
		<td style="width:150px;">工作描述:</td>
		<td colspan="3" style="text-align:left; color:#000000; font-weight:normal"> 
		<s:textarea rows="3" cols="70" name="task" value="%{reportMap.task}" readonly="true"></s:textarea>
		</td>
	</tr>			
	</table>
	<table id="update">
	<tr>
		<th colspan="2"> 审核信息</th>
	</tr>
	<tr>
		<td style="width:200px;">审核状态</td>
		<td style="text-align:left">
		<s:hidden name="statusPanbie" value="%{reportMap.status}"></s:hidden>
		<s:radio name="status" list="statusOps" listKey="fkey" listValue="fvalue" value="%{reportMap.status}"></s:radio>
		</td>
	</tr>
	<tr>
		<td style="width:200px;">原因</td>
		<td style="text-align:left">
		<textarea rows="6" cols="80" name="auditCause"></textarea>
		</td>
	</tr>	
	<tr>
		<td colspan="2">
		</td>
	</tr>	
	<tr>
		<td colspan="2" style="text-align:center">
		<s:submit value="确认提交"></s:submit>
		<s:if test="%{emp == null}"><s:submit value="返回" action="queryReportAuditAdmin_ReportAuditAction"></s:submit></s:if>
		<s:else><s:submit value="返回" action="queryReportAuditing_ReportAuditAction"></s:submit></s:else>
		
		</td>
	</tr>
	</table>
</div>
</s:form>
  </body>
</html>
