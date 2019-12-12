<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>主页</title>
	</head>
	
	<body>
		<div align="center">
			<h1>欢迎光临</h1>
		<c:choose>
			<c:when test="${sessionScope.user==null }">
				<a href="${pageContext.request.contextPath }/login.jsp">尚未登录，请登录</a>
			</c:when>
			<c:otherwise>
				欢迎回来，${sessionScope.user.username }!
				<br>
				<a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>
			</c:otherwise>
		</c:choose>
		</div>
		
	</body>
	
</html>