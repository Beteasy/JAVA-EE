<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>按姓名查找学生</title>
	</head>
	<body>
		<h1>请输入姓名：</h1>
		<form action="../GetStudentByName">
			<input type="text" name="stuName">
			<input type="submit" name="查询">
		</form>
	</body>
</html>