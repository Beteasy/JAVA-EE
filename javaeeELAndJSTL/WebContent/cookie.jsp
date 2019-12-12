<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>cookie对象</title>
</head>
<body>
    <% response.addCookie(new Cookie("userName", "admin")); %>
	Cookie对象的信息： ${cookie.userName } <br /> 
	Cookie对象的名称和值： ${cookie.userName.name }=${cookie.userName.value }
</body>
</html>
