<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看数据库一张表中的数据</title>
</head>
<body>
<%
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/javaeetest?useSSL=false&serverTimezone=UTC";
	String username = "root";
	String password = "root";
	String sql = "select * from easybuy_user";
	
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url,username,password);
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	out.print("<table><tr>"
		+ "<th>id</th>"
		+ "<th>loginName</th>"
		+ "<th>userName</th>"
		+ "<th>password</th>"
		+ "<th>sex</th>"
		+ "<th>identityCode</th>"
		+ "<th>email</th>"
		+ "<th>mobile</th>"
		+ "<th>type</th></tr>"
		);	
	while(rs.next()){
		out.print("<tr>");
		out.print("<td>"+rs.getInt("id")+"</td>");
		out.print("<td>"+rs.getString("loginName")+"</td>");		
		out.print("<td>"+rs.getString("userName")+"</td>");		
		out.print("<td>"+rs.getString("password")+"</td>");		
		out.print("<td>"+rs.getString("sex")+"</td>");		
		out.print("<td>"+rs.getString("identityCode")+"</td>");		
		out.print("<td>"+rs.getString("email")+"</td>");		
		out.print("<td>"+rs.getString("mobile")+"</td>");		
		out.print("<td>"+rs.getString("type")+"</td>");
		out.print("</tr>");
	}
	out.print("</table>");
	rs.close();
	stmt.close();
	con.close();

%>
</body>
</html>