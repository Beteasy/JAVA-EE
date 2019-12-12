<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%!boolean CheckExistsName(String name)
{
	return name.equals("javaee");
} 
%>
<%
	//设置编码格式
	request.setCharacterEncoding("utf-8");
	String uname=request.getParameter("username");
	String userpass=request.getParameter("userpass");
	String email=request.getParameter("email");
	if(CheckExistsName(uname)){
%>
<jsp:forward page="login.jsp">
	<jsp:param name="username" value="<%=uname%>" />
</jsp:forward>
<%}  else {%>
<jsp:forward page="enter.jsp">
	<jsp:param name="username" value="<%=uname%>" />
	<jsp:param name="userpass" value="<%=userpass%>" />
	<jsp:param name="email" value="<%=email%>" />
</jsp:forward>
<%}%>