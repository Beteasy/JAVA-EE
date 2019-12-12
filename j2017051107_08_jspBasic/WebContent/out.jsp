<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>out object</title>
	</head>
	
	<body>
		<%
			out.println("我是out对象，我正在输出<br>");
			response.getWriter().println("我是response对象，我正在输出<br>");
		%>
	</body>
	
</html>