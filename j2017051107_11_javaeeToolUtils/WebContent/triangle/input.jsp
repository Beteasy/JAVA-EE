<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>输入三角形的三条边</title>
	</head>
	
	<body>
		<form action="../TriangleServlet" method="post">
			<h1>输入三角形的三条边</h1>
			sideA:<input type="text" name="sideA"><br>
			sideB:<input type="text" name="sideB"><br>
			sideC:<input type="text" name="sideC"><br>
			<button type="submit">提交</button>
		</form>
	</body>
	
</html>