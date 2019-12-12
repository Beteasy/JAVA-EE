<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>删除结果</title>
	</head>
	<body>
		<h1>
			${requestScope.result == 0 ? '删除失败' : '删除成功' }
		</h1>
	</body>
</html>