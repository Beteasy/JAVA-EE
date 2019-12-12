<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!-- 通过JSP的page指令导入java包 -->
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>显示时间的静态页面</title>
	</head>
		
	<body>
		这是静态部分<br>
		<% out.println("转换前的格式："+new Date()); %><br>
		<% out.println("转换后的格式："+new Date().toLocaleString()); %>
	</body>
	
</html>