<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查找到的产品类型</title>
	</head>
	<body>
		<h1>查询到该产品类型的详情：</h1>
		产品类型ID：${requestScope.productType.id }<br>
		产品类型名：${requestScope.productType.name }<br>

	</body>
</html>