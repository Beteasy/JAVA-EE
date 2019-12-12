<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>按学号查找学生</title>
</head>
<body>
	输入学号：
	<form action="../GetStudentByStuNo" method="post">
		<input type="text" name="stuNo">
		<input type="submit" value="查询">
	</form>
</body>
</html>