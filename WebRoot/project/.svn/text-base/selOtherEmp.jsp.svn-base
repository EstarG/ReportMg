<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ce.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=basePath%>/JP/jquery-1.7.2.js"> </script>
	
	<SCRIPT type="text/javascript">
			
		$(document).ready(
		 	function () {
		 		//为eSL添加change事件
		 		$("#eSL").change(
		 			function() {
		 				var did = $(this).val();
		 				$.post(
		 					"queryDeptEmps_DeptAction",
		 					{"id" : did},
		 					c_bJson,
		 					'text'
		 				);
		 			}
		 		);
		 	}
		 );
	    function c_bJson(data) {
	    	//alert(data);
	    	var c = document.getElementById("f_emps");
		 	var  str = "员工 :   ";
		    //遍历拼接chaeckbox
	    	$.each(eval(data),
	    		function(idx, obj) {
	    		    var tmp = obj;
	   			   	str = str + "<input type=\"checkbox\" name =\"empIds\"  id = " + obj.name + "  value=\"" + obj.id + "\" " + "  '//'>"+obj.name+"<br'/'>";	 
	   			   	c.innerHTML = str;   
	   			   	//alert(c.innerHTML);
	    		}
	    	);
	    }
	    
	    function f_close() {
		   //获得父窗口
		   var prtW = window.opener;
		   var emps = document.getElementsByName("empIds");
		   var length = emps.length;
		   
			
			//循环遍历出我们所选择的项目组成员，然后标记
			//prtW.document.getElementById("tot").value = "";
			//prtW.document.getElementById("ot").value = "";
			
			//获得已选员工的编号
			var slEmps = prtW.document.getElementById("ot").value.split(";");
			var length2 = slEmps.length;
			
			//如果从未选过就	清空
			if (length2 == 1) {
				//alert("leng " + length2);
				prtW.document.getElementById("ot").value = "";
				prtW.document.getElementById("tot").value = "";
			}
			
			/*
			alert("已选的员工的编号  " + slEmps.length);
			for (var j = 0; j < length2; ++j) {
				alert(j  + "  " + slEmps[j]);
			}
			*/
			
			for (var i = 0; i < length; ++i) {
				//alert(emps[i].value + " : " + emps[i].checked + " : " +  emps[i].id) ;
				if (emps[i].checked == true) {
					
					//1表示没有选过2表示已经选过
					var flag = 1;
					for (var j = 0; j < length2; ++j) {
						if (emps[i].value == slEmps[j]) {
							flag = 2; 
							break;
						}
					}
					if (flag == 1) {
						prtW.document.getElementById("tot").value += emps[i].id + ";";
						prtW.document.getElementById("ot").value += emps[i].value + ";";
					}
				}
			}
		    //关闭窗口
		    window.close();
		} 
	</SCRIPT>
	
  </head >
  
  <body background="images/123.jpg">      	
   
			<!-- 	获得部门的下拉列表		-->
			
			选择部门<br/>
	       <s:select list="proDepts" listKey="id" listValue="name" id = "eSL" headerKey="0" headerValue="清选择员工"> </s:select>  
	       <br/>
			<!--	获得该部门的员工	  -->
		  <div id = "f_emps" style="color:red;width: 100%; height: 30% ;　border:solid ;background-color:#FFFAFA" align="center">
		  
		  </div>

		  <div >
		 	 <input type="button" onclick="f_close('<s:property value="schName"/>')" value="配    置"/>
		  </div>
  </body>
</html>