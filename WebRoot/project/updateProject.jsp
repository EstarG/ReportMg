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
    
    <title>My JSP 'updateProject.jsp' starting page</title>
    
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
	<script type="text/javascript" src="<%=basePath%>/JP/jquery-1.7.2.js"> </script>
	
	<script type="text/javascript">
		  var cdr = new Calendar("cdr");
		  document.write(cdr);
		  cdr.showMoreDay = true;
		  
		   function f_check() {
		  		
		  		var length = document.getElementById("remark").value.replace(/[^\x00-\xff]/g,"**").length; 
				 if(length>100){
					
					window.alert("字数超过最大限制");
					document.form1.remark.focus();
					return false;
				}
				else{
					return true;
			}
		}
		  
		  
	</script>
  </head>
  
  <body bgcolor="#ffffff" style="font-family: 微软雅黑">
  	<s:form action="update_ProjectAction" name="form1">
		<%--   隐藏信息			--%>
  	       <s:hidden name = "id" value="%{project.id}"></s:hidden>
  	       <s:hidden name = "pmanager" value="%{project.pmanager}"></s:hidden>
  	       <s:hidden name = "rdmanager" value="%{project.rdmanager}"></s:hidden>
  	       <s:hidden name = "mkmanager" value="%{project.mkmanager}"></s:hidden>
  	       <s:hidden name = "qtmanager" value="%{project.qtmanager}"></s:hidden>
  	       <s:hidden name = "other" value="%{project.other}"></s:hidden>
  	            
	    	<table bgcolor="#DCDCDC" border="1">
			<tr>
				<td colspan="2" align="center">项目设定</td>
			</tr>
			<tr>
				<td>项目名</td>
				<td>  <s:textfield name = "projectid" value="%{project.projectid}"></s:textfield>  </td>
			</tr>
			<tr>
				<td>项目编码</td>
				<td><s:textfield name = "name" value="%{project.name}"></s:textfield></td>
			</tr>
			<tr>
				<td>开始时间</td>
				
				<td>   
				    
					<s:textfield name = "begindate"  onfocus="cdr.show(this);">
						<s:param name = "value"> <s:date name="%{project.begindate}" format="yyyy-MM-dd"/>  </s:param>
					</s:textfield>
				</td>
			</tr>
			<tr>
				<td>结束时间</td>
				<td>   
					<s:textfield name = "enddate" onfocus="cdr.show(this);">
						<s:param name = "value"> <s:date name="%{project.enddate}" format="yyyy-MM-dd"/> </s:param>
					</s:textfield>
				</td>
			</tr>
			<tr>
				<td>项目状态</td>
				<td>
					<s:select list="proStatusOptions" name = "status" listKey="fkey" listValue="fvalue" headerKey="%{project.status}">
					
					</s:select>
				  
				</td>
			</tr>
			
			<tr>
				<td>项目描述（不可超过100个字符！）</td>
				<td colspan="35"><s:textarea rows="5" cols="35" name = "remark" value="%{project.remark}" id="remark"></s:textarea></td>
			</tr>
			<tr><td colspan="2" align="center">
			
				<s:submit value=" 更新" onclick="return f_check()"></s:submit>
			    <s:reset value="重置"></s:reset>
			    
			    </td>
			                   
		</table>
	</s:form>
  </body>
</html>
