<%@page import="java.sql.*"%>
<%@page import="com.DBUtils.DBUtils" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>添加学生</title>
</head>
<body>
<div>
	<form action="/j2017051107_30_javaeeManagerSystem/StuServlet" method="post">
		编号：<input type="text" name="stuNo" /><br> 
		姓名：<input type="text" name="stuName" /><br>
		班级：<input type="text"name="classId" /><br> 
		权限：<input type="text" name="stuPermission" /><br>
		用户名：<input type="text" name="userName" /><br>
		密码：<input type="text" name="password" /><br> 
		手机号：<input type="text" name="phoneNumber" /><br> 
		<input type="hidden" name="action" value="add"/>
		<input type="submit" name="commit" value="提交" /><input type="reset" value="重置" /><br>
	</form>
</div>
</body>
</html>