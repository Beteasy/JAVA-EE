<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新用户注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/save.do" method="post" >
用户登录号：<input type="text" name="loginName" value=""/><br>
用户名：<input type="text" name="userName" value=""/><br>
用户密码：<input type="password" name="password" value=""/><br>
用户性别：<input type="radio" name="sex" value="1" checked>男
	<input type="radio" name="sex" value="0" checked>女<br>
用户身份证号：<input type="text" name="identityCode" value=""/><br>
用户邮箱：<input type="text" name="email" value=""/><br>
用户手机号：<input type="text" name="mobile" value=""/><br>
用户类型：<input type="radio" name="type" value="1" checked>管理员
	<input type="radio" name="type" value="0" checked>普通用户<br>
	<input type="submit" value="提交">&nbsp;&nbsp;
	<input type="reset" value="重置"><br>
</form>
</body>
</html>