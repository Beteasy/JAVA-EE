<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/change.do" method="post">
用户ID号：<input type="text" name="id" value="${requestScope.user.id}" readonly /><br>
用户登录名：<input type="text" name="loginName" value="${requestScope.user.loginName }" readonly /><br>
用户名：<input type="text" name="userName" value="${requestScope.user.userName }" /><br>
用户密码：<input type="password" name="password" value="${requestScope.user.password }" /><br>
用户性别：<input type="text" name="sex" value="${requestScope.user.sex }" /><br>
用户身份证号：<input type="text" name="identityCode" value="${requestScope.user.identityCode }" /><br>
用户邮箱：<input type="text" name="email" value="${requestScope.user.email }" /><br>
用户手机号：<input type="text" name="mobile" value="${requestScope.user.mobile }" /><br>
用户类型：<input type="text" name="type" value="${requestScope.user.type }" readonly /><br>
<input type="submit" value="提交" />&nbsp;&nbsp;
<input type="reset" value="重置" />
</form>
</body>
</html>