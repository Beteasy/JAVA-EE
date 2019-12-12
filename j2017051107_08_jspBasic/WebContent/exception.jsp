<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>exception object</title>
	</head>
	
	<body>
	<!-- errorPage="error.jsp -->
		<%
			int x = 1;
			int y = 0;
		%>
		1除以0的结果为：
		<%=(x/y) %>
	</body>
	
</html>