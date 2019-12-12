<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>在线人数统计</title>
	</head>
	
	<body>
		<h1>登录</h1>
		<form action="../LoginAllServlet" method="post">
			用户名：<input type="text" name="username"><br>
			密   码：<input type="password" name="password"><br>
			<button type="submit">登录</button>
		</form>
		
		<h1>在线用户：</h1>
		<%
			ArrayList<String> users = (ArrayList<String>) application.getAttribute("users");
			Iterator iter = users.iterator();
			while(iter.hasNext()){
			
		%>
		<li><%=iter.next() %></li>
		<%
			}
		%>
		<p>当前在线用户数:<%=users.size() %>人</p>
	</body>
	
</html>