<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新增用户</title>
	</head>
	<body>

		<h1>请输入要增加的用户的信息</h1>
		<form action="../InsertUserController" method="post">
			用户名：<input type="text" name="userName"><br>
			登录名：<input type="text" name="loginName"><br>
			密码：<input type="password" name="password"><br>
			性别：<input type="radio" name="sex" value="0">男
				 <input type="radio" name="sex" value="1">女<br>
			类型：<input type="text" name="type" value="0" ><br>
			<input type="submit" name="submit" value="添加">
		</form>
	</body>
</html>