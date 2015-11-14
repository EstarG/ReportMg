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
    
    <title>My JSP 'AddEmp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript" src = "<%=basePath%>/JP/Calendar2.js"></script>
	<script type="text/javascript" src="<%=basePath%>/JP/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(document).ready(
			function(){
				$("#sf").change(
					function(){
						var fkey = $(this).val();
						$.post(
							"getCitys_EmpAction",
							{"fkey":fkey},
							call_back,
							"json"
						);
					}
				);
			}
		);
		function call_back(data){
			$("#city").empty();
			$.each(data,function(indx,obj){
					$("#city").append("<option value='"+obj.fkey+"'>"+obj.fvalue+"</option>");
			});
		}
		function check(){
			if(document.form1.name.value==""){
				alert("姓名不能为空！");
				document.form1.name.focus();
				return false;
			}else if(document.form1.sex.value=="0"){
				alert("请填写性别！")
				document.form1.sex.focus();
				return false;
			}else if(document.form1.email.value==""){
				alert("请填写邮箱！")
				document.form1.email.focus();
				return false;
			}else if(document.form1.erole.value=="0"){
				alert("请填写职位！")
				document.form1.erole.focus();
				return false;
			}else if(document.form1.nation.value=="0"){
				alert("请填写民族！")
				document.form1.nation.focus();
				return false;
			}else if(document.form1.deptId.value==""){
				alert("请填写部门！")
				document.form1.deptId.focus();
				return false;
			}else if(document.form1.username.value==""){
				alert("请分配账号！")
				document.form1.username.focus();
				return false;
			}else if(document.form1.userpassword.value==""){
				alert("请分配原始密码！")
				document.form1.userpassword.focus();
				return false;
			}else document.form1.submit();
		}
		function checkemail(){
			var temp = document.getElementById("email");
			//对电子邮件的验证
			var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if(temp.value!=""){
				if(!myreg.test(temp.value)){
					alert('提示:请输入有效的E_mail！');
					tbEmail.focus();
					return false;
				}
			}
		} 
	</script>
  </head>
  
  <body style="font-family: 微软雅黑" bgcolor="#99ccff">
  <script language="javascript">
		  var cdr = new Calendar("cdr");
		  document.write(cdr);
		  cdr.showMoreDay = true;
  </script>
  <div align = "center">
  <div align = "center">员工管理-添加员工</div>
  <font color = "red"><s:property value = "#request.addMess"/></font>
  <div align = "right" style = "margin-right: 40px"><s:submit value = "返回" onclick = "location.href='query_EmpAction';"></s:submit></div>
    <form name = "form1" action="add_EmpAction" onsubmit="return check()">
  		<table border="0" bordercolor="#ffffff" bgcolor="#ffffff">	
  			<tr>
	  			<td>部门:</td><td><s:select list = "deptOptions" listKey="fkey" listValue="fvalue" 
	  			headerKey="0" headerValue="请选择" name = "deptId"></s:select><font color="red">&nbsp;&nbsp;*</font></td>
	  			<td>姓名:</td><td><s:textfield name = "name"></s:textfield><font color="red">&nbsp;&nbsp;*</font></td>
	  			<td>&nbsp;&nbsp;性别:</td><td><s:select list = "sexOptions" name = "sex" listKey="fkey" 
	  			listValue="fvalue" headerKey="0" headerValue="请选择">
	  			</s:select><font color="red">&nbsp;&nbsp;*</font></td>
  			</tr>
  			<tr>
	  			<td>职位:</td><td><s:select list = "roleOptions" name = "erole" listKey="fkey" 
	  			listValue="fvalue" headerKey="0" headerValue="请选择">
	  			</s:select><font color="red">&nbsp;&nbsp;*</font></td>
	  			<td>民族:<td><s:select list = "nationOptions" name = "nation" listKey="fkey" 
	  			listValue="fvalue" headerKey="0" headerValue="请选择">
	  			</s:select><font color="red">&nbsp;&nbsp;*</font></td>
	  			<td>&nbsp;&nbsp;电子邮件:</td><td><s:textfield name = "email" onBlur="checkemail();"></s:textfield><font color="red">&nbsp;&nbsp;*&nbsp;</font></td>
  			</tr>
  			<tr>
	  			<td>生日:</td><td>
	  			<s:textfield name = "birth"  onfocus="cdr.show(this);">
	  				<s:param name = "value"> <s:date name="%{emp.birth}" format="yyyy-MM-dd"/> </s:param>
	  			</s:textfield></td>
	  			<td>籍贯:</td><td><s:select list = "sfOptions" name = "address" listKey = "fkey" listValue = "fvalue" 
	  			id = "sf" headerKey="0" headerValue="省份"></s:select>
	  			<select id = "city" name = "address">
	  				<option value = "0">城市</option>
	  			</select></td>
	  			<td>&nbsp;&nbsp;英文名:</td><td><s:textfield name = "engname"></s:textfield></td>
  			</tr>
  			<tr>
	  			<td>QQ:</td><td><s:textfield name = "qq"></s:textfield></td>
	  			<td>家庭电话:</td><td><s:textfield name = "homephone"></s:textfield></td>
	  			<td>&nbsp;&nbsp;联系方式:</td><td><s:textfield name = "officephone"></s:textfield></td>
  			</tr>
  			<tr>
	  			<td>毕业学校:</td><td><s:textfield name = "school"></s:textfield></td>
	  			<td>毕业日期:</td><td>
	  			<s:textfield name = "graddate"  onfocus="cdr.show(this);">
	  				<s:param name = "value"><s:date name="%{emp.graddate}" format="yyyy-MM-dd"/> </s:param>
	  			</s:textfield>
	  			
  			</tr>
  			<tr><td></td><td></td><td></td><td></td><td></td>
  			<td align="right"><s:submit value = "添加"></s:submit>
  			</td>
  			</tr>
  		</table><br/>
  		<hr width="715"/>
  		分配账号和密码：<br/><br/>
  		账号：<s:textfield name = "username"></s:textfield>
  		密码：<s:textfield name = "userpassword"></s:textfield>
  	</form>
  	</div>
  </body>
</html>
