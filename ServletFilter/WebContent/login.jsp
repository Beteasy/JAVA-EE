<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	
	<body>
		<h1 align ="center">Login</h1><br><br>
		<div align="center">
			<form action="${pageContext.request.contextPath }/LoginServlet" method="post" >
		<!-- errorMsg为LoginServlet传递过来的信息 -->
			用户名：<input type="text" name="username">${errorMsg } <br><br>
			密   码：<input type="password" name="password"> <br><br>
			多少天内自动登录：
			<input type="radio" name="autologin" value="${60*60*24*1 }">一天
			<input type="radio" name="autologin" value="${60*60*24*3 }">三天
			<input type="radio" name="autologin" value="${60*60*24*7 }">一周
			<br><br>
			<button type="submit">登录</button><br><br>
			<span>用户名：root   密码：root</span>
		</form>
		</div>
		
	</body>
	
</html>