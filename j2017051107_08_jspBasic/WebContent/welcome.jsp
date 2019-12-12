<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>welcome page</title>
	</head>
	
	<body>
		欢迎回来！<br>
		登录时间：
		<%
			out.println(new Date().toLocaleString());
		%>
	</body>
	
</html>