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
			
			<script type="text/javascript" src="<%=basePath%>/JP/jquery-1.7.2.js"> </script>
	
	<script type="text/javascript">
		$(document).ready(
		 	function () {
		 	
		 		//为eSL添加change事件
		 		$("#eSL").change(
		 			function() {
		 			    
		 				var did = $(this).val();
		 			//	alert(did);
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
		 	var  str = "员工 : ";
		 
	    	$.each(eval(data),
	    		function(idx, obj) {
	    		    var tmp = obj;
	   			   	str = str + "<input type=\"radio\" name =\"empIds\"  id = " + obj.name + "  value=\"" + obj.id + "\" " + "  '//'>"+obj.name+"<br'/'>";	 
	   			   	c.innerHTML = str;   
	    		}
	    	);
	    }
	    
	    function f_close(schName) {

		  // alert(schName);
		   //获得父窗口
		   var prtW = window.opener;
		  // var prtW = window.parent;
		   var pmId = "";
		   var pmName = "";
		   //必须要清空否在更新新的员工的会累加
		   var emps = document.getElementsByName("empIds");
		   var length = document.getElementsByName("empIds").length;
		   //alert("length = " + length);
			
			for (var i = 0; i < length; ++i) {
				//alert(emps[i].value + " : " + emps[i].checked + emps[i].id) ;
				if (emps[i].checked==true) {
					pmId = emps[i].value;
					pmName = emps[i].id;
					break;
				}
			}
			var name = "t"+schName;
			//alert(name.trim() + " : pmName"  + pmName + "pmId : " + pmId);
			//alert(prtW.document.getElementById("t" + schName).value);
			//注意trim 前台可能会传来有空个的字符串
			prtW.document.getElementById(name.trim()).value = pmName;
		    prtW.document.getElementById(schName.trim()).value = pmId;
		    window.close();
		} 
	</SCRIPT>
	
  </head >
  
  <body background="images/123.jpg">
  	 
        	
   
        	
        	
			<!-- 	获得部门的下拉列表		-->
	       <s:select list="proDepts" listKey="id" listValue="name" id = "eSL" headerKey="0" headerValue="请选择部门"> </s:select>  
	       <br/>
			<!--	获得该部门的员工	  -->
		   <div id = "f_emps" style="color:red;width: 100%; height: 30% ;　border:solid ;background-color:#FFFAFA">
		  </div>
		  
		  <div >
		 	 <input type="button" onclick="f_close('<s:property value="schName"/>')" value="配    置"/>
		  </div>
		 
		  
	     

  </body>
</html>