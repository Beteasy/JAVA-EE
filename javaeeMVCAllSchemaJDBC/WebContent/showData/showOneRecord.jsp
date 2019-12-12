<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看数据库一张表中的一条数据</title>
</head>
<body>
<%
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/javaeetest?useSSL=false&serverTimezone=UTC";
	String user = "root";
	String password = "root";
	String sql = "select * from easybuy_user where id = 11";
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	//1 加载驱动
	Class.forName(driver);
	//2 创建连接
	con = DriverManager.getConnection(url, user, password);
	//3 组织语句
	stmt = con.createStatement();
	//4 执行语句
	rs = stmt.executeQuery(sql);
	//5 处理结果
	rs.next();
	out.print("用户ID号："+rs.getInt("id")+"<br/>");
	out.print("用户登录名："+rs.getString("loginName")+"<br/>");
	out.print("用户名："+rs.getString("userName")+"<br/>");
	out.print("用户密码："+rs.getString("password")+"<br/>");
	out.print("用户性别："+rs.getInt("sex")+"<br/>");
	out.print("用户身份证号："+rs.getString("identityCode")+"<br/>");
	out.print("用户邮件"+rs.getString("email")+"<br/>");
	out.print("用户移动电话"+rs.getString("mobile")+"<br/>");
	out.print("用户类型"+rs.getInt("type")+"<br/>");
	//6 回收资源 
	rs.close();
	stmt.close();
	con.close();
	

%>
</body>
</html>