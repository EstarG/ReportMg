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
    
    <title>My JSP 'addReport.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript" src="<%=basePath %>JP/Calendar2.js"></script>
	<script language="javascript" src="<%=basePath %>JP/jquery-1.7.2.js">
	</script>
  <script type="text/javascript">
  
  		function f_reset(){
			var formObj = document.forms[0].elements;
			for(var i=0; i< formObj.length; i++){
				if(formObj[i].type == 'text'){
					//alert(formObj[i].value);
					formObj[i].value='';
				}
				document.getElementById("projectId").value = '0';
				document.getElementById("prpId").value = '0';
			}
			return true;
		}
  
		  $(document).ready(
		  			
					function(){
						$("#projectId").change(
							
							function(){
								var id = $(this).val();
								$.post(
									"getPrps_ReportAction",
									{"pro":id},
									call_back,
									"json"
								);
							}
						);
					}
		);
				function call_back(data){
					$("#prpId").empty();
					$.each(data,function(indx,obj){
							$("#prpId").append("<option value='"+obj.id+"'>"+obj.name+"</option>");
					});
				}
		  
		  function f_check() {
		  		var obj = document.getElementById("projectId");
		  		var index = obj.selectedIndex;
		  		var val = obj.options[index].value;
		  		var length = document.getElementById("task").value.replace(/[^\x00-\xff]/g,"**").length; 
				if (document.form1.cdate.value == "") {
					window.alert("日期不能为空");
					document.form1.cdate.focus();
					return false;
				}else if (document.form1.task.value == "") {
					window.alert("任务不能为空");
					document.form1.task.focus();
					return false;
				}else if(length>50){
					
					window.alert("字数超过最大限制");
					document.form1.task.focus();
					return false;
				}
				else if (document.form1.workload.value == "") {
					window.alert("工作量不能为空");
					document.form1.workload.focus();
					return false;
				}else if (document.form1.overtime.value == "") {
					window.alert("加班不能为空");
					document.form1.overtime.focus();
					return false;
				}else if (val == "0") {
					window.alert("项目不能为空");
					document.form1.projectId.focus();
					return false;
				}
				return true;
		}
		  
		  
	</script>
  </head>
  
  <body>
	  <script language="javascript">
	  var cdr = new Calendar("cdr");
	  document.write(cdr);
	  cdr.showMoreDay = true;
	  </script>
	 
		<s:form action="add_ReportAction" name="form1">
			<font color=red><s:property value="#request.msg" /></font>
		   <table border="2" bgcolor="#DCDCDC">
			<tr >
				<th colspan="4"  align="center">增加新日报<font color="red">(红色为必填)</font></th>
			</tr>
			<tr>
				<td ><font color="red">日期</font></td>
				<td>
					<s:textfield name="cdate" onfocus="cdr.show(this);" >
					</s:textfield>
				</td>
				<td style="width:100px"><font color="red">填写人</font></td>
				<td>${session.user.name}
				
				<s:hidden name="empId" value="%{#session.user.id}"></s:hidden>
				</td>
			</tr>
			<tr>
				<td style="width:100px"><font color="red">任务（不可超过50个字符！）</font></td>
				<td colspan="3">
				<s:textarea name="task" rows="4" cols="55" id = "task"></s:textarea>
				
				</td>
				</tr>
			<tr>
				<td style="width:100px"><font color="red">工作量</font></td>
				<td>
				<s:textfield name="workload"></s:textfield>
				</td>
			
				<td style="width:100px"><font color="red">加班</font></td>
				<td><s:textfield name="overtime"></s:textfield>
				</td></tr>
			<tr>
				<td style="width:100px"><font color="red">项目</font></td>
				<td><s:select list="projectOptions" listKey="id" headerKey="0" headerValue="请选择项目" listValue="name" name="projectId" id="projectId"></s:select>
					
				</td>
				<td style="width:100px"><font color="red">PRP阶段</font></td>
				<td>
					<select id="prpId" name="prpId">
						<option value="0">请选择prp阶段</option>
					</select>
					<s:hidden name="status" value="1"></s:hidden>   </td>
									
			</tr>
			<tr>
				<th colspan="4">
				<div align="right">
				<s:submit value="提交" align="right" onclick="return f_check()"></s:submit>
				<input type="button" value="重置" onclick="f_reset()"/>
				
				</div>
			</th>
			</tr>
			
		</table>
</s:form>
   
  </body>
</html>
