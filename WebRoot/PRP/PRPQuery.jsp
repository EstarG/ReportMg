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
    
    <title>My JSP 'PRPQuery.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link type="text/css" rel="stylesheet" href="styles/prp.css" />
<script type="text/javascript" language="javascript">
	function f_page(obj){
			with(document.forms[0]){
			   
				currentPage.value = obj;
				submit();
			}
			return false;
		}
</script>
<script>
function f_selectAll() {
 var checkboxs=document.getElementsByName("ids");
 for (var i=0;i<checkboxs.length;i++) {
  var e=checkboxs[i];
  e.checked=!e.checked;
 }
}
</script>
<SCRIPT type="text/javascript">
	function f_reset(){
		document.form1.abbreviate.value = "";
		document.form1.name.value = "";
		return false;
	}
</SCRIPT>
  </head>
  
  <body bgcolor="#ffffff" style="font-family: 微软雅黑">
    <div id="prpQuery">
    <s:form action="queryPrp_PrpAction" name="form1">
	<table id="option" border="1" bgcolor="#DCDCDC">
	<tr>
		<th colspan="4"> 查询</th>
	</tr>
	<tr>
		<td style="width:150px;">PRP缩写</td>
		<td>
		<s:textfield name="abbreviate"></s:textfield>
		</td>
		<td style="width:150px;">PRP阶段名称</td>
		<td>
		<s:textfield name="name"></s:textfield>
		</td>
	</tr>	
	<tr>
		<td colspan="4" style="text-align: right">
		<s:submit value="查询"></s:submit>
		<s:submit value="增加" action="initAdd_PrpAction" ></s:submit>
		<s:submit value="重置" onclick="return f_reset()"></s:submit>
		</td>
	</tr>
	</table>
	<s:hidden name="currentPage" value="1"></s:hidden>
	<div style="color:red"><s:property value="request.msg"/> </div>
	<table id="result" border="1" bordercolor="#ffffff">
		<tr>
		<th style="width:50px;">
		<s:checkbox name="boxAll" onclick="f_selectAll();">全选</s:checkbox>
		</th>
		<th style="width:100px;">序号</th><th>PRP缩写</th><th>PRP阶段名称</th><th colspan="2">操作</th>
		</tr>
		<s:iterator var="prp" value="prps">
			<tr>
			<td style="width:50px;">
    		<s:checkbox name="ids" fieldValue="%{#prp.id}"></s:checkbox>
    		</td>
			<td style="width:100px;"><s:property value="#prp.id"/>
			</td>
			<td><s:property value="#prp.ab"/>
			</td>
			<td><s:property value="#prp.name"/>
			</td>
			<td>
			<s:a action="queryPrpById_PrpAction">
    				<s:param name="id" value="#prp.id"></s:param>
    					修改
    			</s:a>
			</td>
			<td><s:a action="deletePrp_PrpAction" onclick="javascript: return confirm('确定删除？')">
    				<s:param name="id" value="#prp.id"></s:param>
    					删除
    			</s:a>
    		</td>
			</tr>
		</s:iterator>
		<tr>
		<th height="100px" colspan="6" style="text-align: center;">
			<div align="center" style="width: 700px;height: 10px auto;"><div align="left"><s:submit  action="deleteAllPrps_PrpAction" value="批量删除">
		</s:submit></div>
	<span>当前页：${currentPage }
		<s:if test="%{currentPage > 1}">
     	 <a href="" onclick="javascript:return f_page(${currentPage-1})">上一页</a> &nbsp;&nbsp;
     	 </s:if>
     	 <s:if test="%{currentPage <= 1}">上一页</s:if>
     	 <s:if test="%{currentPage < allPage}">
   	 	 <a href="" onclick="javascript:return f_page(${currentPage+1})">下一页</a> 
   	 	 </s:if>
   	 	 <s:if test="%{currentPage >= allPage}">下一页</s:if>
   	 	 <br/>
		总页数：${allPage }</span></div>
		</th>
		</tr>
	</table>
	</s:form>
</div>
  </body>
</html>
