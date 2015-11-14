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
    
    <title>My JSP 'updateReport.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
	
	<script language="javascript" src="<%=basePath %>JP/jquery-1.7.2.js"> </script>
	<script language="javascript" src="JP/Calendar2.js"></script>
	
	<script type="text/javascript">
		  function f_check() {
		  		
		  		var length = document.getElementById("task").value.replace(/[^\x00-\xff]/g,"**").length; 
				 if(length>100){
					
					window.alert("字数超过最大限制");
					document.form1.task.focus();
					return false;
				}
				else{
					return true;
			}
	}
		  
		  function f_reset(){
			var formObj = document.forms[0].elements;
			for(var i=0; i< formObj.length; i++){
				if(formObj[i].type == 'text'){
					//alert(formObj[i].value);
					formObj[i].value='';
				}
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
			//alert(data);
		    $("#prpId").empty();
		    
			$.each(data,function(indx,obj){
				$("#prpId").append("<option value='"+obj.id+"'>"+obj.name+"</option>");
			});
					
		}
	</script>
  </head>
  
  <body>
  <script type="text/javascript">
  	 var cdr = new Calendar("cdr");
		  document.write(cdr);
		  cdr.showMoreDay = true;
		  
		 
		  
  </script>
  	<s:form action="update_ReportAction" name="form1">
  	      
  			<s:hidden name="id" value="%{r.id.trim()}"></s:hidden>
  			<s:hidden name="empId" value="%{#session.user.id}"></s:hidden>
  			<s:hidden name="status" value="1"></s:hidden>
			    <table border="1" bgcolor="#DCDCDC">
				<tr>
					<th colspan="4">更新日报</th>
					
				</tr>
				<tr>
					<td style="width:150px">日期</td>
					<td><s:textfield name="cdate"  onfocus="cdr.show(this);">
						<s:param name = "value" > <s:date name="%{r.cdate}" format="yyyy-MM-dd" />  </s:param>
					</s:textfield>
					</td>
					<td style="width:150px">填写人</td>
					<td>${session.user.name}
					
					</td>
				</tr>
				<tr>
					<td style="width:150px" >任务（不可超过50个字符！）</td>
					<td colspan="3"><s:textarea rows="4" name="task" cols="50" value="%{r.task}" id="task"></s:textarea>
					</td></tr>
				<tr>
					<td style="width:150px">工作量</td>
					<td><s:textfield name="workload" value="%{r.workload}"></s:textfield>
					</td>
				
					<td style="width:150px">加班</td>
					<td><s:textfield name="overtime" value="%{r.overtime}"></s:textfield>
					</td></tr>
				<tr>
					<td style="width:150px">项目</td>
					
					<td><s:select list="projectOptions" listKey="id"  listValue="name"  name="projectId" id="projectId" value="%{r.projectId}"  ></s:select>
					</td>
					<td style="width:150px">PRP阶段</td>
					<td>
                       
						<select id="prpId" name="prpId" >
							<option value="${r.prpId}" selected="selected"> <s:property value="%{r.prpName}"/>  </option>
						</select>
					</td>
					
				</tr>
				<tr>
					<th colspan="4">
					
					<s:submit value="提交" onclick="return f_check()"></s:submit>
					
					<input type="button" value="重置" onclick="f_reset()"/>
					
				</th>
				</tr>
				
			</table>
	</s:form>
    
  </body>
</html>
