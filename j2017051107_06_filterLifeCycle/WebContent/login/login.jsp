<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>登录</title>
	</head>
	
	<body>
		<form action="../LoginServlet" method="post" align="center">
			用户名：<input type="text" name="username"><br>
			密   码：<input type="password" name="password"><br>
			<button type="submit">登录</button>
		</form>
	</body>
	
</html>