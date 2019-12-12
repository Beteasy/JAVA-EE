<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
     <title>Insert title here</title>
</head>
<body>
	这是静态部分
     <!--输出当前时间 -->
     <% out.println(new java.util.Date().toLocaleString());%>
</body>
</html>
