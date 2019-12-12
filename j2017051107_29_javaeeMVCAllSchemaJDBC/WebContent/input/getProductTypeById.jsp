<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>按ID查找产品类型</title>
	</head>
	<body>
		<form action="../GetProductTypeByIdController" method="post">
		请输入要查询的产品类型的ID:<input type="text" name="id"><br>
		<input type="submit" value="查询">
		</form>
	</body>
</html>