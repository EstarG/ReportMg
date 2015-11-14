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
    
    <title>My JSP 'showPerson.jsp' starting page</title>
    
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
	<script language="javascript" src="<%=basePath %>JP/jquery-1.7.2.js"></script>
	<script type="text/javascript">
	
	function f_reset(){
			var formObj = document.forms[0].elements;
			for(var i=0; i< formObj.length; i++){
				if(formObj[i].type == 'text'){
					//alert(formObj[i].value);
					formObj[i].value='';
				}
			}
			document.getElementById("projectId").value= "0";
			document.getElementById("status").value= "0";
			
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
		  
		  
		function f_page(obj){
			with(document.forms[0]){
				
				currentPage.value=obj;
				submit();
			}
			return false;
		}
		 var cdr = new Calendar("cdr");
		  document.write(cdr);
		  cdr.showMoreDay = true;
	
		   function show(obj){
		  
	    	window.open ("queryOne_ReportAction?id=" + obj, "newwindow", "height=260, width=750, toolbar=no, menubar=no, scrollbars=no scrollbars=no, resizable=no,location=no, status=no,top = 250,left = 300");
	       }
	</script>
	
  </head>
  
  <body>

  
		个人日报查询
	<s:form action="query_ReportAction">
			
			<s:hidden name="empId" value="%{#session.user.id}"></s:hidden>
			<table border="2" bgcolor="#DCDCDC">
				<tr>
					<th colspan="4">日报管理-查询</th>
					
				</tr>
				<tr>
					<td style="width:150px">查询起始日期</td>
					<td><s:textfield name="begin" onfocus="cdr.show(this);"></s:textfield>
					</td>
					<td style="width:150px">查询结束日期</td>
					<td><s:textfield name="end" onfocus="cdr.show(this);"></s:textfield>
					</td>
				</tr>
				<tr>
					<td style="width:150px">项目</td>
					<td><s:select list="projectOptions" listKey="id" headerKey="0" headerValue="请选择项目" listValue="name" name="projectId" id="projectId"></s:select>
					</td>
					<td style="width:150px">prp阶段</td>
					<td><select id="prpId" name="prpId">
						<option value="0">请选择prp阶段</option>
					</select></td>
				
					
				</tr>
				<tr>
					<td style="width:150px">审核状态</td>
					<td><s:select list="statusOptions" name = "status" listKey="fkey" listValue="fvalue" headerKey="0" headerValue="请选择" id="status"></s:select>
					</td>
					<td style="width:150px">任务</td>
					<td><s:textfield name="task" ></s:textfield>
					<s:hidden name="currentPage" value="1"></s:hidden>
					</td>
				</tr>
				<tr>
					<th colspan="4" >
					<s:submit value="查询" ></s:submit>
					
					<input type="button" value="添加" onclick="location.href = 'initAdd_ReportAction?empId = ${session.user.id} '; ">

					<input type="button" value="重置" onclick="f_reset()"/>
					
					
				</th>
				</tr>
				
			</table>
查询到的日报信息<br/><font color=red><s:property value="#request.msg" /></font>
		<table border="2" bgcolor="#DCDCDC">
			<tr style="color:gray"><th>日期</th><th>项目</th><th>PRP阶段</th><th>任务</th><th>工作量</th><th>加班</th><th>状态</th><th colspan="2">操作</th></tr>
			<s:iterator var="r" value="reports">
				<tr>
					
					<td>
					<s:property value="#r.cdate"/>   </td>
					
					<td><s:property value="#r.projectid"/>   </td>
					<td><s:property value="#r.prpid"/>   </td>
					<td><a style="cursor: hand;cursor: pointer;" target="_blank" onclick="show('<s:property value="#r.id"/>')"><font color="blue" ><s:property value="#r.task"/></font></a>   </td>
					<td><s:property value="#r.workload"/>   </td>
					<td><s:property value="#r.overtime"/>   </td>
					<td><s:if test="%{#r.status=='未通过'}">
						<font color="red">	<s:property value="#r.status"/></font>
						</s:if> 
						<s:else>
						 <s:property value="#r.status"/></s:else>   </td>
				    <s:if test="%{#r.status=='已通过'}">
				    <td></td><td>s</td>
				    </s:if>
				    <s:else>
					<td>
						<s:a action="queryById_ReportAction">
     						<s:param name = "empId" value="%{#session.user.id}"></s:param>
     						<s:param name="id" value="#r.id"></s:param>
     					更新
     				</s:a>
					</td>
					
					<td>     <a href="delete_ReportAction?id=<s:property value="#r.id"/>" onclick="javascript:return confirm('确定删除？')">删除</a></td>
					</s:else>
				</tr>
			
			</s:iterator>
			<tr><th colspan="9">总页数：${allPage}  &nbsp;&nbsp;   
			
		 	<s:if test="%{currentPage > 1}">
			<a href="" onclick="javascript:return f_page(${currentPage-1})">上一页</a> &nbsp;&nbsp;
		   	</s:if>
			<s:else>
			上一页
			</s:else>
		   	 当前页:${currentPage}&nbsp;&nbsp;
		   	<s:if test="%{currentPage < allPage}">
		   	 <a href="" onclick="javascript:return f_page(${currentPage+1})">下一页</a><br/>
		   	</s:if>
			<s:else>
			下一页
			</s:else></th></tr>
		</table>
</s:form>
				
  </body>
</html>
