<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>域对象</title>
</head>
<body>
	<% pageContext.setAttribute("userName", "admin"); %>
	<% request.setAttribute("bookName", "《Java Web 程序设计任务教程》"); %>
	<% session.setAttribute("userName", "itheima"); %>
	<% application.setAttribute("bookName", "《Java 基础案例教程》"); %>
	表达式\${pageScope.userName}的值为：${pageScope.userName} <br /> 
	表达式\${requestScope.bookName}的值为：${requestScope.bookName} <br /> 
	表达式\${sessionScope.userName}的值为：${sessionScope.userName} <br />
	表达式\${applicationScope.bookName}的值为：${applicationScope.bookName} 
     <br /> 
	表达式\${userName}的值为：${userName}
</body>
</html>
