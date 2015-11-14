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
    
    <title>My JSP 'deptDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<SCRIPT type="text/javascript">
		 function f_page(obj) {
			//alert(obj)
			with(document.forms[0]) {
				currentPage.value = obj;
				submit();
			}
		}
		 function f_dlEmp(obj){
	   		var x = confirm("确定要删除" + obj + "号部门");
	 		if (x) {
	   			window.location.href="delete_DeptAction?id="+obj;
	   		}
	   	}

		 function f_clear(){
	   			var formObj = document.forms[0].elements;
				for (var i = 0; i < formObj.length; ++i) {
					if (formObj[i].type == 'text'){
						formObj[i].value='';
					}
				}
	   			return true;
	   	}
		function f_Ntest(obj) {
			
			if (!isNaN(obj)) {
				alert("请输入1-9的数字");
				document.getElementById("id").value = "";
			} 
		}
	</SCRIPT>
  </head>
  
  <body style="font-family: '微软雅黑'">
  <div style="background-color:#DCDCDC;height: 490px ">
  <div
	  style="height: 30px; background-color: #F5FFFA">
	  <font face="幼圆" color="#008B8B" size="5">查询部门信息</font>
		</div>
   
     
    <s:form action="query_DeptAction">
    	<s:hidden name = "currentPage" value="1"></s:hidden>
    	部门编号:<s:textfield name = "id" value="" onkeyup="this.value=this.value.replace(/[^\d-]/g,'')" ></s:textfield> <br/>
    	部门名称:<s:textfield name = "name"></s:textfield> <br/>
    	上级部门:<s:textfield name = "pid"></s:textfield> <br/>
    	练习电话:<s:textfield name = "phone" onkeyup="this.value=this.value.replace(/[^\d-]/g,'')"></s:textfield> <br/>
                     部门传真:<s:textfield name = "fax" onkeyup="this.value=this.value.replace(/[^\d-]/g,'')"></s:textfield> <br/>
    	      
    	 <s:submit value="查询"></s:submit>
    	 <input type="button" value="重置" onclick="f_clear()"/>
    	
    	<h2>部门信息</h2>
    	<font color="red"> <s:property value="#request.msg"/>   </font>
    	<table border="4" bordercolor="#F0F8FF">
    		<tr> <th>部门编号</th>  <th>部门名称</th> <th>上级部门</th> <th>联系电话</th> <th>传真</th>  </tr>
    		<s:iterator var = "d" value="depts">
				<tr bordercolor="#B0C4DE"> 
					<td>  <s:property value="#d.id"/> </td>
					<td>  <s:property value="#d.name"/> </td>
					<td>  <s:property value="#d.pname"/> </td>
					<td>  <s:property value="#d.phone"/> </td>
					<td>  <s:property value="#d.fax"/> </td>
					<td>
						<s:a action="queryById_DeptAction">
							<s:param name = "id" value="#d.id"></s:param>
							更新
						</s:a>
					</td>
					
					<td>
						<a href="javascript:f_dlEmp(${d.id})"> 删除 </a>
					</td>
			    </tr>
    		</s:iterator>
    	</table>
    	
    	
    	 	当前页:  ${currentPage}  &nbsp;&nbsp; 总页数 : ${allPage} 
	       	
	       	<s:if test="%{currentPage > 1}">
	       		<a href="javascript:f_page(${currentPage-1})">上一页 </a> &nbsp;&nbsp;
	       	</s:if>
	       	<s:if test="%{currentPage <= 1}">
	       		上一页
	       	</s:if>
	       	
	       	<s:if test="%{currentPage < allPage}">
	       		<a href="javascript:f_page(${currentPage+1})"> 下一页</a>
	       	</s:if>
	       	<s:if test="%{currentPage >= allPage}">
	       		下一页
	       	</s:if>
    
    </s:form>   
   	
</div>
  </body>
</html>
