<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<form action="../servlet/LoginServlet" method="post" >
		<div id="user">
			用 户<input type="text" name="name" />
		</div>
		<div id="password">
			密   码<input type="password" name="pass" />
		</div>
		<div id="btn">
			<input type="submit" value="登录">
		</div>
	</form>

</body>
</html>