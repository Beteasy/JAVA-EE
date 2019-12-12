<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>分页查询</title>
		<style type="text/css">
			form{
				position:relative;
				top:20px;
			}
		</style>
	</head>
	<body>
		<h1>当前页面的用户：</h1>
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
		<form action="/j2017051107_26_javaeeMVCDemo01/GetUserByPageController" method="post" name="form">
			跳转到第<input type="text" name="page" > 页
		</form>
		
	</body>
</html>