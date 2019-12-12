<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<!-- 
when  otherwise
url


 -->
<html>

	<head>
		<meta charset="UTF-8">
		<title>首页</title>
	</head>
	
	<body>
		<c:choose>
			
			<c:when test="${empty sessionScope.user }">
				<form action="login.jsp" method="post">
					用户名：<input type="text" name="username"><br>
					密码：<input type="password" name="password"><br>
					<button type="submit">登录</button>
				</form>	
			</c:when>
			
			<c:otherwise>
				<p>欢迎回来，${sessionScope.user }</p>
				<c:url var="url" value="logout.jsp"></c:url>
				<a href="logout.jsp">注销登录</a>
				
			</c:otherwise>
		</c:choose>
	
	</body>
	
</html>
