<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'Log.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript" src="JP/Calendar2.js"></script>

  <SCRIPT type="text/javascript">
	var cdr = new Calendar("cdr");
	document.write(cdr);
	cdr.showMoreDay = true;
	function f_clear(){
   			var formObj = document.forms[0].elements;
			for (var i = 0; i < formObj.length; ++i) {
				if (formObj[i].type == 'text'){
					formObj[i].value='';
				}
			}
   			return true;
   	}
   	function f_page(obj){
			with(document.forms[0]){
				currentPage.value=obj;
				submit();
			}
			return false;
	    }
   </SCRIPT>
	</head>

	<body style=" font-family: '微软雅黑'">
	<div style="background-color:#DCDCDC ">
		<div
			style="height: 25px;background-color: #F5FFFA">
			日志管理操纵>>日志查询
		</div>
		<hr align="left" width="50%" size="3" color="#ffffff" />
		<s:form action="querylog_LogAction">
		<div
			style="height: 100px; margin-top: 10px; margin-left: 5px; margin-bottom: 20px;background-color: #FFFAFA">
			<br/>
         &nbsp;&nbsp;&nbsp;用户名查询： <s:textfield name="username"></s:textfield>
				
       &nbsp;&nbsp;操作类型查询： <s:textfield name="optype"></s:textfield> <br />
				<br />
     &nbsp;&nbsp;  起止时间查询：<s:textfield name="startDate"
					onfocus="cdr.show(this);"></s:textfield> 
 &nbsp;至&nbsp;&nbsp;<s:textfield name="endDate"
					onfocus="cdr.show(this);"></s:textfield>
       		&nbsp;&nbsp;&nbsp;&nbsp;<s:submit value="查询"></s:submit>
       		<input type="button" value="重置" onclick="f_clear()"/>
		
		</div>
		
		<table border="3" bordercolor="#F0F8FF">
	      			<tr bordercolor="#B0E0E6">
	      				<th bordercolor="#B0E0E6" bgcolor="#B0E0E6">序号 </th> 
	      				<th bordercolor="#B0E0E6" bgcolor="#B0E0E6">用户名</th>
	      				<th bordercolor="#B0E0E6" bgcolor="#B0E0E6">类型</th>
	      				<th width="400px" bordercolor="#B0E0E6" bgcolor="#B0E0E6">日志内容</th> 
	      				<th bordercolor="#B0E0E6" bgcolor="#B0E0E6">备注</th> 
	      				<th bordercolor="#B0E0E6" bgcolor="#B0E0E6">时间</th> 
	      				
	      			</tr>
	      			
	      			<s:iterator var="log" value="logs">
	      				<tr> 
	      					<td bgcolor="#e5f5ea"> <s:property value="#log.id"/>  </td>
	      					<td bgcolor="#e2e2e4"> <s:property value="#log.username"/>  </td>
	      					<td bgcolor="#e5f5ea"> <s:property value="#log.optype"/>  </td>
	      					<td bgcolor="#e2e2e4"> <s:property value="#log.context"/>  </td>
	      					<td bgcolor="#e5f5ea"> <s:property value=""/>  </td>
	      					<td bgcolor="#e2e2e4"> <s:date name = "#log.cdate" format="yyyy-MM-dd HH:MM:ss"></s:date>  </td>
	      				    
	      				</tr>
	      			</s:iterator>
	      		</table>
	      		  
	      		<s:hidden name = "currentPage"></s:hidden>
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
	      </s:form>
	      </div>
	</body>
</html>
