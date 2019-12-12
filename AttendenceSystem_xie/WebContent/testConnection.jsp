<%@page import="java.sql.*"%>
<%@page import="com.DBUtils.DBUtils" %>
<%@page import="com.entity.User" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
</head>

<body>
	<%
	try {
		Connection conn = DBUtils.getConnection();;
		out.println("数据库连接成功!");
		conn.close(); //关闭连接，释放资源
	} catch (Exception e) {
		out.println("数据库连接失败!<br/>");
		out.print("错误信息：" + e.toString());
	}
	%>
</body>
</html>
