<%@page import="javaBean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>从UserDao中拿数据来显示</title>
</head>
<body>
用户ID号是：${requestScope.user.id}<br/>
用户登录名是：${requestScope.user.loginName}<br/>
用户名是：${requestScope.user.userName}<br/>
用户密码是：${requestScope.user.password}<br/>
用户性别：${requestScope.user.sex }<br/>
用户身份证号：${requestScope.user.identityCode }<br/>
用户邮箱：${requestScope.user.email }<br/>
用户手机号：${requestScope.user.mobile }<br/>
用户类型：${requestScope.user.type }<br/>
<hr/>
用户ID号是：${requestScope.user.id}<br/>
用户登录名是：${requestScope.user.loginName}<br/>
用户名是：${requestScope.user.userName}<br/>
用户密码是：${requestScope.user.password}<br/>
用户性别：${requestScope.user.sex=="1"?"男":"女"}<br/>
用户身份证号：${requestScope.user.identityCode }<br/>
用户邮箱：${requestScope.user.email }<br/>
用户手机号：${requestScope.user.mobile }<br/>
用户类型：${requestScope.user.type=="0"?"管理员":"普通用户"}<br/>
<%-- 
<%
	User u = (User)request.getAttribute("user");
	out.print("用户ID号是："+u.getId()+"<br/>");

%> 
--%>
</body>
</html>