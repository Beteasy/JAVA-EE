<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户信息</title>
</head>
<body>
显示用户信息<hr>
用户ID：${requestScope.user.id}<br>
用户登录名：${requestScope.user.loginName}<br>
用户名：${requestScope.user.userName}<br>
用户密码：${requestScope.user.password}<br>
用户性别：${requestScope.user.sex == 1 ? "男" : "女" }<br>
用户身份证号：${requestScope.user.identityCode}<br>
用户邮箱：${requestScope.user.email}<br>
用户电话：${requestScope.user.mobile}<br>
用户类型：${requestScope.user.type}<br>
</body>
</html>