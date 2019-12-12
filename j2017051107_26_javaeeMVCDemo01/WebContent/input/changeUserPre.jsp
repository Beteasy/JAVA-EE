<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>请输入要修改用户的ID</title>
	</head>
	<body>
		<form action="../LoadUserToChangeController" method="post">
			请输入要修改的用户的ID:<input type="text" name="id"><br>
			<input type="submit" value="查询">
		</form>
	</body>
</html>