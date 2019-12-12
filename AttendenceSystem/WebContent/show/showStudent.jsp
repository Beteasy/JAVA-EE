<%@page import="java.util.Iterator"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>显示学生</title>
	</head>
	<body>
		<%
			PrintWriter writer = response.getWriter();
			Student student = (Student)request.getAttribute("student");
			writer.print(
					"<table border='1' width='100%' style='table-layer:fixed'>"
					+"<tr>"
					+ "<th>学号</th>"
					+ "<th>姓名</th>"
					+ "<th>班级</th>"
					+ "<th>权限</th>"
					+ "<th>用户名</th>"
					+ "<th>密码</th>"
					+ "<th>电话号码</th>"
					+"</tr>"
					);
				
					writer.print("<tr>");
					writer.print("<td>"+student.getStuNo()+"</td>");		
					writer.print("<td>"+student.getStuName()+"</td>");
					writer.print("<td>"+student.getClassId()+"</td>");	
					//writer.print("<td>"+student.getStuPermission()+"</td>");	
					//writer.print("<td>"+student.getUserName()+"</td>");	
					//writer.print("<td>"+student.getPassword()+"</td>");	
					//writer.print("<td>"+student.getPhoneNumber()+"</td>");	
					writer.print("</tr>");
				writer.print("</table>");
		%>
		
	</body>
</html>