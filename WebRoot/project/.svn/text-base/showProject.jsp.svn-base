<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'projectConfig.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript" src="JP/Calendar2.js"></script>	
	
	<script type="text/javascript">
		  
	   function f_dlPro(obj){
			var x = confirm("确定要删除项目" + obj);
			if (x) {
				window.location.href="delete_ProjectAction?id="+obj;
			}
		}

		  function f_page(obj) {
			   
				//alert(obj)
				with(document.forms[0]) {
					currentPage.value = obj;
					submit();
				}
		}

		 function f_clear(){
	   			var formObj = document.forms[0].elements;
				for (var i = 0; i < formObj.length; ++i) {
					if (formObj[i].type == 'text'){
						formObj[i].value='';
					}
				}
				document.getElementById("status").value = '0';
	   			return true;
	   	}

		 function f_slAll(){
		 //alert("1111");
	   		   var s = document.getElementById("selectAll");
			   with(document.forms[0]){
				    if (selectAll.checked){
						for (var i = 0; i < ids.length; ++i) {
							ids[i].checked = true;
						}
					} else {
						for (var i = 0; i < ids.length; ++i){
							ids[i].checked = false;
						}
					}
				}
	   	}
		function  f_dlAllok() {
			var x = confirm("确定要删除选中全部");
			if (x) {
				return true;
			} else {
				return false;
			}
		}
		   	
		var cdr = new Calendar("cdr");
	    document.write(cdr);
	    cdr.showMoreDay = true;
	</script>
  </head>
  
  <body style="font-family: '微软雅黑'">
  		<div style=" width:802px ;height:492px ;background-color:#DCDCDC;">
    	<s:form action="query_ProjectAction">
    	
    	<div
			style="height: 30px;  background-color: #F5FFFA">
			<font face="幼圆" color="#008B8B" size="5">日报设定&gt;&gt;项目设定&gt;&gt;查询</font>
		</div>
		
           <hr align="left" width="50%" size="4" color="#20B2AA" />
        
            <s:hidden name = "currentPage" value="1"></s:hidden>
            <table />
            	<tr >
	                <td>&nbsp;&nbsp;&nbsp;&nbsp;项目编号：<br/>&nbsp;&nbsp;&nbsp; <s:textfield name = "projectid" ></s:textfield> </td>
	                <td>&nbsp;&nbsp;&nbsp;&nbsp;项目名称：<br/> &nbsp;&nbsp;&nbsp;<s:textfield  name = "name"></s:textfield>  </td>
	          
	           	
	           		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项目状态：<br/> &nbsp;&nbsp;&nbsp;
			           	<s:select list="proStatusOptions" name = "status" id = "status" listKey="fkey" listValue="fvalue" headerKey="0"  headerValue="  请  选  择 状  态  ">
			           	</s:select>
			        </td>
	            </tr>    
	            
	            <tr>
	            	
	            	 <td> &nbsp;&nbsp;&nbsp;&nbsp;开始时间: <br/>&nbsp;&nbsp;&nbsp;&nbsp;
	            	 <s:textfield name = "begindate" onfocus="cdr.show(this);" >
	            	 	<s:param name="value"><s:date name="begindate" format="yyyy-MM-dd"/> </s:param>
	            	 </s:textfield>  </td>   
	            	         
	                 <td>&nbsp;&nbsp;&nbsp;&nbsp;结束时间：<br/> &nbsp;&nbsp;&nbsp;
	                 	<s:textfield name = "enddate"  onfocus="cdr.show(this);" >
	                 		<s:param name = "value"> <s:date name="enddate" format="yyyy-MM-dd" /> </s:param>
	                 	</s:textfield> 	</td>
	             	 <td>&nbsp;&nbsp;&nbsp; 参与人员：<br/>&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield  name = "other"></s:textfield> </td>
	           </tr>
            </table>      
            <div style="margin-left: 20;margin-top: 20">
            <s:submit style="width:45px;height:28px;font-size:14px;color:#3272b9" value="查询"></s:submit>&nbsp;
            <input style="width:45px;height:28px;font-size:14px;color:#3272b9"type="button" value="重置" onclick="f_clear()"/>&nbsp;
          

			<input style="width:45px;height:28px;font-size:14px;color:#3272b9" type="button" value="添加" onclick="location.href='<%=basePath%>/project/addProject.jsp';">
</div>
            <br/>
            
            <div
			style="height: 40px; margin-top: 2px; margin-left: 20px; background-color: #DCDCDC">
			<font face="黑体" size="6">项目：<font color="red">  <s:property value="request.msg"/>  </font>  </font>  
		</div>
            <div style="height: 30px; margin-top: 2px; margin-left: 5px; background-color: #DCDCDC">
            <table border="4" bordercolor="#F0F8FF" width="780">
                <tr  bordercolor="#B0C4DE">
                <th style="border:0" bordercolor="#B0C4DE">选择</th> <th style="border:0" bordercolor="#B0C4DE">项目编号</th>  <th style="border:0" bordercolor="#B0C4DE">项目名称</th> <th style="border:0" bordercolor="#B0C4DE">开始时间</th> <th style="border:0" bordercolor="#B0C4DE">结束时间</th> <th style="border:0" bordercolor="#B0C4DE">状态</th> <th style="border:0" bordercolor="#B0C4DE" align="center">配置</th>
                </tr>
                <s:iterator var = "p" value="projects">
	                <tr>
	                    <td><s:checkbox name="ids" fieldValue="%{#p.id}"></s:checkbox>   </td>
	                	<td bgcolor="#d7d7d7"> <s:property value="#p.projectId"/> </td> 
	                	<td bgcolor="#d7d7d7"> <s:property value="#p.name"/>  </td>
	                	<td bgcolor="#d7d7d7"> <s:property value="#p.beginDate"/> </td>
	                	<td bgcolor="#d7d7d7"> <s:property value="#p.endDate"/> </td>
	                	<td bgcolor="#d7d7d7"> <s:property value="#p.status"/> </td> 
	               
		               	<td style="border:0">	
		               	    <table  border="1"  bordercolor="#d7d7d7" background="#A9A9A9">
		               	      <tr style="border:1" bordercolor="d7d7d7">
					                <td style="border:1" bgcolor="#d7d7d7">  <a href="configInit_PrpAction? projectId = ${ p.id }"><font color="#000E00">PRP</font></a>  </td> 
					                <td style="border:1" bgcolor="#d7d7d7">  <a href="configInit_ProjectAction? id = ${ p.id }"><font color="#000E00">部门</font></a>     </td>
					                <td style="border:1" bgcolor="#d7d7d7">  <a href="beforeConfigEmp_ProjectAction? id = ${p.id}"><font color="#000E00">负责人</font></a>     </td> 
					                <td style="border:1" bgcolor="#d7d7d7">  
					                	<s:a action="queryById_ProjectAction">
					     					<s:param name="id" value="#p.id"></s:param>
					     					<font color="#000E00">更新</font>
				     					</s:a>
					                </td>
					                 <td style="border:0" bgcolor="#d7d7d7">  
					                	<a href="javascript:f_dlPro(${p.id})"> 
	            							删除
	            						</a>
					                </td>
					               
				               </tr>
			                </table>
			               
		                </td>  
	                </tr>
	                 </div>
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
			
			<s:checkbox name="selectAll" onclick="f_slAll()"> </s:checkbox> 全选
            
              <s:submit action="deleteAll_ProjectAction" value="删除选中项" onclick="return f_dlAllok()"></s:submit>
	       	
         </s:form>
         </div>
  </body>
</html>
