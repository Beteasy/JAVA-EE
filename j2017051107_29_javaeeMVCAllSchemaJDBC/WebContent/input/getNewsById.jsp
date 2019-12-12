<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>按照ID查询</title>
	</head>
	<body>
		<form action="../GetNewsByIdController" method="post">
			请输入要查询的新闻的ID:<input type="text" name="id"><br>
			<input type="submit" value="查询">
		</form>
	</body>
</html>