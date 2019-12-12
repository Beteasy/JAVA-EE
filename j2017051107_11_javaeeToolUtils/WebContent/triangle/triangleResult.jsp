<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>triangleResult</title>
	</head>
	
	<body>
		三角形的三条边为：<br>
		sideA：${requestScope.triangle.sideA }<br>
		sideB：${requestScope.triangle.sideB }<br>
		sideC：${requestScope.triangle.sideC }<br>
		三条边能否构成三角形：${requestScope.triangle.isTriangle }<br>
		三角形的面积为：
		<c:if test="${requestScope.triangle.isTriangle }">
			${requestScope.triangle.area }
		</c:if>
		<c:if test="${requestScope.triangle.isTriangle == false}">
			不能计算面积
		</c:if>
	</body>
	
</html>