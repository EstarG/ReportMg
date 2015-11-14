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
    
    <title>My JSP 'cfDeptProject.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="styles/query.css" />
	
	<SCRIPT type="text/javascript">
	
		function f_clear() {
			var prps = document.getElementsByName("prpIds");
			var length = prps.length;
			
			//alert(length);
			for (var i = 0; i < length; ++i) {
				prps[i].checked = false;
			}
		}
		
		 function f_slAll(){
	   		   var s = document.getElementById("selectAll");
			   with(document.forms[0]){
				    if (selectAll.checked){
						for (var i = 0; i < prpIds.length; ++i) {
							prpIds[i].checked = true;
						}
					} else {
						for (var i = 0; i < prpIds.length; ++i){
							prpIds[i].checked = false;
						}
					}
				}
	   	}
	</SCRIPT>
  </head>
  <body bgcolor="#ffffff" style="font-family: 微软雅黑">
  
  	
     <s:form action="configPrp_ProjectAction">   
     
        <s:hidden name = "id" value="%{projectId}"></s:hidden>
        <table bgcolor="#DCDCDC">			
           <tr> <th>选择</th> <th>PRPID</th> <th>PRP缩写</th> <th>PRP名称</th> <th>备注</th> </tr>
            
	       <s:iterator var = "prp" value="prps">
	       	<tr>	   	 
	       		<td>  <input type="checkbox" name="prpIds" value="<s:property  value = "#prp.id" /> "
				        <s:iterator value="proPrps" var="pprp">
				            <s:if test="#prp.id==#pprp.id">
				                checked="checked"
				            </s:if>
				        </s:iterator>
		        /> </td>
		        
		      	
		       <td> <s:property value="#prp.id"/> </td>
		       <td> <s:property value="#prp.ab"/> </td>
		       <td> <s:property value="#prp.name"/> </td>
		       <td> <s:property value="#prp.remarks"/>  </td>
	     
	           </tr>
	       </s:iterator>
	   	
	   	 <tr>
	   		<td ><input type="submit" value="设置" /></td>
	   		<td><input type="button" value="重置" onclick="f_clear()">   </td>
         	<td><s:checkbox name="selectAll" onclick="f_slAll()"> </s:checkbox> 全选</td>
          <td></td>
         	<td></td>
         	<td></td>
         </tr>
         	
       </table>
       
     </s:form>  
  </body>
</html>
