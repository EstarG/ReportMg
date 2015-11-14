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
    
    <title>My JSP 'cfDeptProject.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link type="text/css" rel="stylesheet" href="styles/query.css" />
	
	<script type="text/javascript">

	     
		function openwin(obj){
			//alert(obj)
			window.open ('configInitEmp_ProjectAction?schName=' + obj + ' & id = ' + ${project.id} ,'newwindow','height=500,width=600,top=100,left=300,toolbar=no,menubar=no,scrollbars=no,        resizable=no,location=no, status=no') ;
		}
		function openwinOther() {
			window.open ('configInitEmpOther_ProjectAction?id ='+${project.id} ,'newwindow','height=500,width=600,top=100,left=300,toolbar=no,menubar=no,scrollbars=no,        resizable=no,location=no, status=no') ;
		}
		
		function f_clear() {
			var formObj = document.forms[0].elements;
			for (var i = 0; i < formObj.length; ++i) {
				if (formObj[i].type == 'text'){
					formObj[i].value='';
				}
			}
			document.getElementById("tot").value = "";
			document.getElementById("ot").value = "";
			document.getElementById("pm").value = "";
			document.getElementById("rd").value = "";
			document.getElementById("mk").value = "";
			document.getElementById("qt").value = "";
			
	   		return true;
		}
		function f_clear_other() {
			document.getElementById("ot").value = "";
			document.getElementById("tot").value = "";
		}
	</script>
  </head>
  
  <body bgcolor="#ffffff" style="font-family: 微软雅黑">
  <s:form action="configEmp_ProjectAction">
       <font color="red"> 您正在为项目  <font color="blue"><s:property value="project.name"/></font>   配置人员   </font> <br/><br/><br/>
       <s:hidden name = "id" value="%{project.id}"></s:hidden>
	    <table border="1" bgcolor="#DCDCDC">
			<tr>
				<td>项目经理</td>
			      <s:hidden name = "pm" id = "pm" value="%{project.pmanager}"></s:hidden>
				<td> <s:textfield name = "tpm" id = "tpm" value="%{pm}"></s:textfield>  </td>
				<td> <input type="button" onclick="openwin('pm')" value="配置" />       </td>
			</tr>
			
			<tr>
				<td>研发负责人</td>
				 <s:hidden  name = "rd" id = "rd" value="%{project.rdmanager}"> </s:hidden>
				<td> <s:textfield name = "trd"  id = "trd"  value="%{rd}"></s:textfield> </td>
				<td> <input type="button" onclick="openwin('rd')" value="配置" /></td>
			</tr>
			
			<tr>
				<td>市场负责人</td>
				<s:hidden  name = "mk" id = "mk" value="%{project.mkmanager}"> </s:hidden>
				<td> <s:textfield name = "tmk"  id = "tmk"  value="%{mk}"></s:textfield> </td>
				<td> <input type="button" onclick="openwin('mk')" value="配置" /></td>
			</tr>
			
			<tr>
				<td>质量负责人</td>
				<s:hidden  name = "qt" id = "qt" value="%{project.qtmanager}"> </s:hidden>
				<td> <s:textfield name = "tqt"  id = "tqt"  value="%{qt}"></s:textfield> </td>
				<td> <input type="button" onclick="openwin('qt')" value="配置" /></td>
			</tr>
			
			
			<tr><td colspan="9"><h3 align="center">项目负责人设置</h3></td></tr>
			<tr>
				<td >其他参与人员</td>
				<s:hidden name = "ot" id = "ot" value="%{project.other}"> </s:hidden>
				<td >  <s:textarea id="tot" name="tot" value="%{ot}"  rows="5" cols="50"></s:textarea>    </td>
				<td> <input type="button" onclick="openwinOther()" value="配置" />  <br/> 
				<input type="button" value="清空"  onclick="f_clear_other()"/> </td>

			</tr>
			
		</table>
		
		 <s:submit value="提交"></s:submit>  
		 <input type="button" value="重置"  onclick="f_clear()"/>
	</s:form>
	
  </body>
</html>
