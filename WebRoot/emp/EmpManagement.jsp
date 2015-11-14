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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function f_dlEmp(obj){
   			var x = confirm("确定要删除");
   			if (x) {
   				window.location.href="delete_EmpAction?id="+obj;
   			}
   		}
		function f_page(obj){
			with(document.forms[0]){
				currentPage.value=obj;
				submit();
			}
			return false;
	    }
	    function f_clear(){
   			var formObj = document.forms[0].elements;
			for (var i = 0; i < formObj.length; ++i) {
				if (formObj[i].type == 'text'){
					formObj[i].value='';
				}else{
					document.getElementById("deptId").value = "0";
					document.getElementById("erole").value = "0";
					document.getElementById("nation").value = "0";
					document.getElementById("sex").value = "0";
				}
			}
   			return true;
   		}
	    function show(obj1,obj2){
	    	window.open ("getEmpDetails_EmpAction?id="+obj1+" && deptId="+obj2+"", "newwindow", "height=200, width=750, toolbar=no, menubar=no, scrollbars=no scrollbars=no, resizable=no,location=no, status=no,top = 250,left = 300");
	    }
	</script>	
  </head>
  
  <body style="font-family: 微软雅黑">

  <div align = "center">
  <form action = "query_EmpAction">
    <table border = 1 bgcolor="#DCDCDC">
    	<tr><td></td><td></td><td></td><td>员工管理-查询条件</td></tr>
    	<tr>
	    	<td>查询部门：</td><td><s:select list = "deptOptions" listKey="fkey" listValue="fvalue" 
	  			headerKey="0" headerValue="请选择" name = "deptId"></s:select></td>
	    	<td>查询姓名：</td><td><s:textfield name = "name"></s:textfield></td>
	    	<td>查询性别：</td><td><s:select list = "sexOptions" name = "sex" listKey="fkey" 
	  			listValue="fvalue" headerKey="0" headerValue="请选择">
	  			</s:select></td>
    	</tr>
    	<tr>
	    	<td>是否领导：</td><td><s:select list = "roleOptions" name = "erole" listKey="fkey" 
	  			listValue="fvalue" headerKey="0" headerValue="请选择">
	  			</s:select></td>
	    	<td>民族：</td><td><s:select list = "nationOptions" name = "nation" listKey="fkey" 
	  			listValue="fvalue" headerKey="0" headerValue="请选择">
	  			</s:select></td>
    	</tr>
    	<tr><td></td><td></td><td></td><td></td><td></td>
	    	<td>
		    	 <s:submit value = "查询" ></s:submit>
		    	 <input type = "button" value = "添加" onclick = "location.href='init_EmpAction';"/>
		    	 <input type="button" value="重置" onclick="f_clear()"/>
	    	</td>
    	</tr>
    </table><br/>
  	<table border = 2>
  		<tr bgcolor="#99ccff"><th width="90">部门</th><th width="90">姓名</th><th width="60">性别</th><th width="85">是否领导</th>
  		<th width="90">民族</th><th width="110">查看信息</th><th width="87">修改信息</th><th width="50">删除</th>
  		</tr>
  		<s:iterator var = "e" value = "emps">
  			<tr bgcolor="#e5f5ea">
  				<td><s:property value="#e.dname"/></td>
  				<td><s:property value="#e.name"/></td>
  				<td><s:property value="#e.sex"/></td>
  				<td><s:property value="#e.erole"/></td>
  				<td><s:property value="#e.nation"/></td>
  				<td align = "center"> <a style="cursor: hand;cursor: pointer;" target="_blank" onclick="show(${e.id}, ${e.did})"><font color="blue" >查看详细信息</font></a></td>
  				<td align = "center"><a href = "queryEmpById_EmpAction?id=${e.id} && deptId=${e.did}">修改信息</a></td>
  				<td align = "center"><a href = "javascript:f_dlEmp(${e.id})">删除</a></td>
  			</tr>	
  		</s:iterator>
  	</table>
  	
  	<s:hidden name = "currentPage" value="1"></s:hidden>
     <s:if test= "%{currentPage > 1}">
             <a href="" onclick = "javascript:return f_page(${currentPage-1})">上一页</a>&nbsp;&nbsp;
     </s:if>
     <s:if test= "%{currentPage <= 1}">上一页</s:if>
             当前页:${currentPage}&nbsp;&nbsp;
     <s:if test= "%{currentPage < allPage}" >
             <a href="" onclick = "javascript:return f_page(${currentPage+1})">下一页</a>&nbsp;&nbsp;
     </s:if>
     <s:if test="%{currentPage >= allPage}">下一页</s:if>
             总页数:${allPage}
  </form>  
  </div>
  </body>
</html>
