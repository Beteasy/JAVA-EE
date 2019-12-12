<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改用户信息</title>
	</head>
	<body>

		<h1>请输入新的用户的信息</h1>
		<form action="/j2017051107_26_javaeeMVCDemo01/ChangeUserController" method="post">
			<input type="hidden" name="id" value="${requestScope.user.id}">
			用户名：<input type="text" name="userName" value="${requestScope.user.userName} "><br>
			登录名：<input type="text" name="loginName" value="${requestScope.user.loginName} "><br>
			密码：<input type="text" name="password" value="${requestScope.user.password} "><br>
			性别：<input type="radio" name="sex" value="0" ${requestScope.user.sex == 0 ? "checked" : ""}>男
				 <input type="radio" name="sex" value="1" ${requestScope.user.sex == 1 ? "checked" : ""}>女<br>
			类型：<input type="text" name="type" value="${requestScope.user.type}" ><br>
			<input type="submit" name="submit" value="修改">
		</form>
	</body>
</html>