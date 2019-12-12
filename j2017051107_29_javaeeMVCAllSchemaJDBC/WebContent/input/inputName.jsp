<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>按照Name查询</title>
	</head>
	<body>
		<form action="../GetUserByNameController" method="post">
			请输入要查询的Name:<input type="text" name="name"><br>
			<input type="submit" value="查询">
		</form>
	</body>
</html>