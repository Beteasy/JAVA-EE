<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>include page</title>
	</head>
	
	<body>
		这是include page<br>
		用于测试include指令<br>
		这里将包含date.jsp文件<br>
		以下是date.jsp文件的内容<br><br>
		<hr>
		<%@ include file="date.jsp" %>
	</body>
	
</html>