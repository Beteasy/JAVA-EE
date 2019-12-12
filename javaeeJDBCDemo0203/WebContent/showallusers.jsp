<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所有用户信息</title>
</head>
<body>
	用户信息表<hr>
	<c:forEach var="user" items="${requestScope.userList }">
		用户ID：${user.id}<br>
		用户登录名：${user.loginName}<br>
		用户名：${user.userName}<br>
		用户密码：${user.password}<br>
		用户性别：${user.sex == 1 ? "男" : "女" }<br>
		用户身份证号：${user.identityCode}<br>
		用户邮箱：${user.email}<br>
		用户电话：${user.mobile}<br>
		用户类型：${user.type}<br> <hr>
	</c:forEach>
</body>
</html>