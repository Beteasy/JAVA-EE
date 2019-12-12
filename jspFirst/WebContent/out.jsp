<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
 	<title>out对象</title>
</head>
<body>
	<%
	   out.println("First<br />");
	   response.getWriter().println("Second<br />");
	%>	
</body>
</html>
