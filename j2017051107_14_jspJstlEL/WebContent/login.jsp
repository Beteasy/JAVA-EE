<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>登录处理</title>
	</head>
	
	<body>
		<c:choose>
			<c:when test="${param.username=='root'&&param.password=='root'}">
				<c:set var="user" scope="session" value="${param.username}"></c:set>
				<c:redirect url="index.jsp"></c:redirect>
			</c:when>
			<c:otherwise>
				<script language="javascript">
				alert("您输入的用户名或密码错误！");
				window.location.href="index.jsp";
			</script>
			</c:otherwise>
		</c:choose>
		
		
	</body>
	
</html>