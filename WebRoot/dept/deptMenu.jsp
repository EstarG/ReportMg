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
    
    <title>My JSP 'deptMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div>
  <div
			style="height: 30px;  background-color: #F5FFFA">
			<font face="幼圆" color="#008B8B" size="5">添加子部门</font>
		</div>
	 <a href="addInit_DeptAction" target="deptcontent">添加部门  </a>  <br/><br/>
	<hr>
	
	    
		<script language="JavaScript">
		<!--
		//声明几个变量
		NS4 = (document.layers) ? 1 : 0;// 当用户的浏览器是Netscape时，变量NS4的值为1
		IE4 = (document.all) ? 1 : 0; //当用户的浏览器是IE时，变量IE4的值为1
		ver4 = (NS4 || IE4) ? 1 : 0; //当用户的浏览器是IE或是Netscape时，变量ver4的值为1
		if (ver4) {
			with (document) {       //定义各个层的位置及显示状态
				write("<STYLE TYPE='text/css'>");
				if (NS4) {
					write(".parent {position:absolute; visibility:visible}");
					write(".child {position:absolute; visibility:visible}");
					write(".regular {position:absolute; visibility:visible}")
				}
				else { write(".child {display:none}") }   //隐藏子菜单
				write("</STYLE>");
			}
		}
		function getIndex(el) { //定义一个函数getIndex，功能是获得变量ind的值
			ind = null;
			for (i=0; i<document.layers.length; i++) {
				whichEl = document.layers[i];
				if (whichEl.id == el) {
					ind = i;
					break;
				}
			}
			return ind;
		}
		function arrange()  //定义一个函数，功能是定义页面上元素的位置。
		{
			nextY = document.layers[firstInd].pageY +document.layers[firstInd].document.height;
			for (i=firstInd+1; i<document.layers.length; i++) {
				whichEl = document.layers[i];
				//当菜单打开时，子菜单位置顺序往下推；
				//菜单合起时，子菜单位置自动上移
				if (whichEl.visibility != "hide") { 
					whichEl.pageY = nextY;
					nextY += whichEl.document.height;
				}
			}
		}
		function initIt() { //页面载入时，首先调用该函数。功能是初始化菜单。
			if (!ver4) return;
			if (NS4) {                                  
				for (i=0; i<document.layers.length; i++) {  //对于NS浏览器，设置菜单隐藏
					whichEl = document.layers[i];
					if (whichEl.id.indexOf("Child") != -1) whichEl.visibility = "hide";
				}
				arrange();
			}
			else {
				divColl = document.all.tags("DIV");
				for (i=0; i<divColl.length; i++) {          //对于IE浏览器，设置菜单隐藏
					whichEl = divColl(i);
					if (whichEl.className == "child") whichEl.style.display = "none";
				}
			}
		}
		function expandIt(el) 
		{
			if (!ver4) return;
			if (IE4) {            //对于IE浏览器
				whichEl = eval(el + "Child");
				//如果菜单是打开的，那么当再点击时，子菜单就不可见
		//如果菜单是关闭状态，那么当再点击时，子菜单就可见。
				if (whichEl.style.display == "none") {whichEl.style.display = "block";}
				else {whichEl.style.display = "none";}
			}
			else {              //对于非IE浏览器
				//如果菜单是打开的，那么当再点击时，子菜单就不可见
		//如果菜单是关闭状态，那么当再点击时，子菜单就可见。
				whichEl = eval("document." + el + "Child");
				if (whichEl.visibility == "hide") {whichEl.visibility = "show";}
				else {whichEl.visibility = "hide";}
				arrange();
			}
		}
		onload = initIt;
		//-->
	</script>
	<div id="KB1Parent" class="parent">
		<a href="#" onClick="expandIt('KB1'); return false" >
		<img src="<%=basePath%>/images/plus.gif" border=0></a>
		<a href="queryById_DeptAction?id=47" target="deptcontent">技术部</a>
	</div>
	<div id="KB1Child" class="child">
		<a href="sample.htm" target="_blank" >
		<img src="<%=basePath%>/images/spacer.gif"  border=0 alt="">
		<img src="<%=basePath%>/images/open.gif"  border=0>电子商务部</a>
		<br>
		<a href="sample.htm" target="_blank" >
		<img src="<%=basePath%>/images/spacer.gif"  border=0 alt="" width="15" height="11">
		<img src="<%=basePath%>/images/open.gif"  border=0>搜索部</a>
		<br>
		<a href="sample.htm" target="_blank" >
		<img src="<%=basePath%>/images/spacer.gif"  border=0 alt="" width="15" height="11">
		<img src="<%=basePath%>/images/open.gif"  border=0>移动产品部</a>
	</div>
	<div id="KB2Parent" class="parent">
		<a href="#" onClick="expandIt('KB2'); return false" >
		<img src="plus.gif" border=0>文件夹二</a>
	</div>
	<div id="KB2Child" class="child">
		<a href="sample.htm" target="_blank" >
		<img src="spacer.gif"  border=0 alt="" width="15" height="11">
		<img src="open.gif"  border=0>页面一</a>
		<br>
		<a href="sample.htm" target="_blank" >
		<img src="spacer.gif"  border=0 alt="">
		<img src="open.gif"  border=0>页面二</a>
		<br>
		<a href="sample.htm" target="_blank" >
		<img src="spacer.gif"  border=0 alt="" width="15" height="11">
		<img src="open.gif"  border=0>页面三</a>
	</div>
	<div id="KB3Parent" class="parent">
		<a href="#" onClick="expandIt('KB3'); return false" >
		<img src="plus.gif"  border=0>文件夹三</a>
	</div>
	<div id="KB3Child" class="child">
		<a href="sample.htm" target="_blank" >
		<img src="spacer.gif"  border=0 alt="">
		<img src="open.gif"  border=0>页面一</a>
		<br>
		<a href="sample.htm" target="_blank" >
		<img src="open.gif"  border=0>页面二</a>
		<br>
		<a href="sample.htm" target="_blank" >
		<img src="spacer.gif"  border=0 alt="">
		<img src="open.gif"  border=0>页面三</a>
	</div>
	<script language="JavaScript">
	<!--
	if (NS4) { //如果用户的浏览器是NetScape，先初始化变量
	        firstEl = "KB1Parent";
	        firstInd = getIndex(firstEl);
	        arrange();
	}
	//-->
	</script>
	</div>
	</body>
</html>
