<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage=""%>
<%@page import="com.sun.xml.internal.bind.v2.runtime.Location"%>
<%
String rand=(String)session.getAttribute("rand");
String input=request.getParameter("rand");
if(rand.equals(input)){
out.print("<script>alert('��֤ͨ��');</script>");
}
else{
out.print("<script>alert('�û���/�˺Ż���֤�����');Location.href='login.jsp';</script>");
}
%>