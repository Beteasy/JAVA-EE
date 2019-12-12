<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请输入用户信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/saveusercontroller" method="post">
	用户登录名：<input type="text" name="loginName" value="" />
	<br>用户名：<input type="text" name="userName" value="" />
	<br>用户密码：<input type="text" name="password" value="" />
	<br>性别：<input type="radio" name="sex" value="1" />男&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="sex" value="0" />女
	<br>身份证号：<input type="text" name="identityCode" value="" />
	<br>邮箱：<input type="text" name="email" value="" />
	<br>电话：<input type="text" name="mobile" value="" />
	<br>类型：<input type="radio" name="type" value="2" />管理员&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="radio" name="type" value="1" />后台用户&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="type" value="0" />前台用户
	<br><input type="submit" value="提交" />
</form>
</body>
</html>