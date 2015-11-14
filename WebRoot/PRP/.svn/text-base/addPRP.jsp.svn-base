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
    
    <title>My JSP 'addPRP.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="styles/prp.css" />
	<script type="text/javascript" src="<%=basePath%>/JP/jquery-1.7.2.js"> </script>
<script language="JavaScript">
	var mark;
	function f_check() {
		if (mark == "0") {
			 window.alert("PRP缩写或名称已存在,请重新输入");
			 return false;
		}
		if (document.form1.abbreviate.value == "") {
			window.alert("PRP缩写不能为空");
			document.form1.abbreviate.focus();
			return false;
		}else if (document.form1.name.value == "") {
			window.alert("PRP阶段名称不能为空");
			document.form1.name.focus();
			return false;
		}else{
			return true;
		}
	}
	function f_checkPrpAb(obj) {
			 $.post(
				"isExist_PrpAction",
				 {"abbreviate" : obj},
				 c_bJsonAb,
				 'text'
			 );
			 
		} 
		function c_bJsonAb(data) {
			mark = eval(data);
			if (mark == "0") {
				document.getElementById("isokPrpAb").innerHTML = "该缩写已存在或不合法";	
			}  else {
				document.getElementById("isokPrpAb").innerHTML = "缩写合法";	
			}
		} 
	    function f_checkPrpName(obj) {
			 $.post(
				"isExist_PrpAction",
				 {"name" : obj},
				 c_bJsonName,
				 'text'
			 );
			 
		} 
		function c_bJsonName(data) {
			mark = eval(data);
			if (mark == "0") {
				document.getElementById("isokPrpName").innerHTML = "该阶段名称已存在或不合法";	
			}  else {
				document.getElementById("isokPrpName").innerHTML = "阶段名称合法";	
			}
		} 
</script>
<SCRIPT type="text/javascript">
	function f_reset(){
		document.form1.abbreviate.value = "";
		document.form1.name.value = "";
		return false;
	}
</SCRIPT>
	</head>

  <body background="#DCDCDC" style="font-family: 微软雅黑" onload="f_reset()">
    <s:form action="addPrp_PrpAction" name="form1">
<table id="option2" bgcolor="#DCDCDC">
	<tr>
		<th colspan="4"> 增加PRP阶段（红色为必填）</th>
	</tr>
	<tr>
		<td style="color:#FF0000">PRP缩写</td>
		<td>
		<s:textfield name="abbreviate" onblur="f_checkPrpAb(this.value)"></s:textfield><div id = "isokPrpAb" style="color:red;font-size:12px;font-weight:normal"></div>
		</td>
		<td style="color:#FF0000">PRP阶段名称</td>
		<td><s:textfield name="name" onblur="f_checkPrpName(this.value)"></s:textfield> 
			<div id = "isokPrpName" style="color:red;font-size:12px;font-weight:normal"></div>
		</td>
	</tr>	
	<tr>
		<td style="width:150px;">备注</td>
		<td colspan="3">
		<s:textarea rows="8" cols="70" name="remarks"></s:textarea>
		</td>
	</tr>	
	<tr>
		<td colspan="4" style="text-align:right">
		<s:submit value="提交" onclick="return f_check()"></s:submit>
		<s:submit value="重置" onclick="return f_reset()"></s:submit>
		<input type="button" value="返回" onclick="window.location.href='<%=basePath%>/PRP/PRPQuery.jsp'"/>
		</td>
	</tr>
	</table>
</s:form>
  </body>
</html>
