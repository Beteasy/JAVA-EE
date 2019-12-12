<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询到的符合条件的用户</title>
	</head>
	<body>
		<h1>查询到的符合条件的用户：</h1>
		<c:forEach var="user" items="${requestScope.users}">
			用户ID：${user.id }<br>
			用户名：${user.userName }<br>
			登录名：${user.loginName }<br>
			密码：${user.password }<br>
			性别：${user.sex == 0 ? '男' : '女'}<br>
			用户类型：${user.type }<br>
			<hr>
			<br>
		</c:forEach>
	</body>
</html>