<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>JSP脚本</title>
	</head>
	
	<body>
		<%!
			int a = 1;
			int b = 1;
		%>
		<%!
			public String print(){
			String cuit = "www.cuit.edu.cn";
			return cuit;
		}
		%>
		<%="a=1,b=1,则a+b=" + (a+b) %><br>
		<%="在JSP页面中定义print()方法，输出成都信息工程大学的官网是：" + print() %><br>
	</body>
	
</html>