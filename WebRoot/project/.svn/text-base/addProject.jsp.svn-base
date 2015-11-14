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
    
    <title>My JSP 'addProject.jsp' starting page</title>
    
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
          var mark;
          
		  function f_check() {
			    if (mark == "0") {
			    	window.alert("项目编号已存在,请重新输入");
			    	return false;
				}
				if (document.form1.name.value == "") {
					window.alert("项目名称不能为空");
					document.form1.name.focus();
					return false;
				}else if (document.form1.projectid.value == "") {
					window.alert("项目编号不能为空");
					document.form1.projectid.focus();
					return false;
				}else if (document.form1.begindate.value == "") {
					window.alert("项目开始时间不能为空");
					document.form1.begindate.focus();
					return false;
				} else if (document.form1.enddate.value == "") {
					window.alert("项目结束时间不能为空");
					document.form1.enddate.focus();
					return false;
				} 
		}
		function f_checkProId(obj) {
            //alert("调用。。" + obj);
			 $.post(
				"isExist_ProjectAction",
				 {"projectid" : obj},
				 c_bJson,
				 'text'
			 );
			 
		} 
		function c_bJson(data) {
			//alert(data);
			mark = eval(data);
			//alert(mark);
			/*$.each(eval(data),
		    		function(idx, obj) {
		    		    var tmp = obj;
		   			    if (tmp == "1") {
		   			    	alert("项目已存在..");
		   					document.getElementById("isokProId").innerHTML = "该编号已存在";	
			   			}
		    		}
		    );*/
		    
			if (mark == "0") {
				document.getElementById("isokProId").innerHTML = "该编号已存在";	
			}  else {
				document.getElementById("isokProId").innerHTML = "编号合法";	
			}
		} 
			
	</script>
  </head>
  
  <body bgcolor="#ffffff" style="font-family: 微软雅黑">
  		<s:form action="add_ProjectAction" name = "form1">
			   <table bgcolor="#DCDCDC" style="margin:5px auto">
				<tr>
					<th colspan="4">日报设定>>项目设定>>添加</th>
				</tr>
				
				<tr>
					<td style="width:150px;" >项目名称&nbsp;&nbsp;<font color="red">* </font> </td>
					<td>  <s:textfield name = "name"></s:textfield> </td>
					
					<td style="width:150px;">项目编码&nbsp;&nbsp;<font color="red">* </font></td>
					<td>  <s:textfield name = "projectid" onblur="f_checkProId(this.value)"></s:textfield>  <div id = "isokProId" style="color: red"></div> </td>
					
				</tr>
				
				<tr>
					<td style="width:150px; ">开始时间&nbsp;&nbsp;<font color="red">* </font>  </td>
					<td>  <s:textfield name = "begindate" onfocus="cdr.show(this);"></s:textfield> </td>
					
					<td style="width:150px;">结束时间&nbsp;&nbsp;<font color="red">* </font></td>
					<td> <s:textfield name = "enddate" onfocus="cdr.show(this);"></s:textfield> </td>
				</tr>
				
				
				<tr>
					<td style="width:150px">项目描述 </td>
					<td>  <s:textfield name = "remark"></s:textfield> </td>
					
					<td style="width:150px">项目描述 </td>
					<td> <s:select list="#{'1':'运行中', '2':'挂起', '3':'关闭'}" name = "status" listKey="key" listValue="value"></s:select> </td>
				</tr>
				<tr>
				<th colspan="4">
					<div id="button">
					<span>	<s:submit value="添加" onclick="return f_check()"> </s:submit>
						<s:reset value="重置"></s:reset>
					</div>
				</th>
				</tr>
				
			</table>
		</s:form>
  </body>
</html>
