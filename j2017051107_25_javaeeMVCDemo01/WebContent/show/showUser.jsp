<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>显示查询到的用户</title>
	</head>
	<body>
		<h1>查询到该用户的信息：</h1>
		用户ID：${requestScope.user.id }<br>
		用户名：${requestScope.user.userName }<br>
		登录名：${requestScope.user.loginName }<br>
		密码：${requestScope.user.password }<br>
		性别：${requestScope.user.sex == 0 ? '男' : '女'}<br>
		用户类型：${requestScope.user.type }<br>
	</body>
</html>