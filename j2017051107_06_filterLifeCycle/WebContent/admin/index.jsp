<%@page import="com.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>admin主页</title>
	</head>
	
	<body>
		<%
			User user = (User)request.getSession().getAttribute("user");
		%>
		<h1>
			<%=user.getUsername() %> ,欢迎回来！
		</h1>
	</body>
	
</html>