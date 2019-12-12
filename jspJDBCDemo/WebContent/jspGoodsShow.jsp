<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看商品信息</title>
</head>
<body>
<%
	//1获得数据库连接四大参数项
	String driverClassName="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jspdb"
		+"?useUnicode=true&characterEncoding=utf-8";
	String username="root";
	String password="rootcuit";
	//2注册驱动
	Class.forName(driverClassName);
	//3创建数据库连接
	Connection  conn = DriverManager.getConnection(url,username,password);
	//4获取操作对象
	PreparedStatement pstat = conn.prepareStatement("select * from goods");
	//5执行查询，获取查询结构
	ResultSet rs = pstat.executeQuery();
	//6循环迭代rs，处理查询结果
	while(rs.next()){
		out.print(rs.getString(1)+" : ");
		out.print(rs.getString(2)+"<br />");
	}
	//7回收资源
	conn.close();
%>

</body>
</html>