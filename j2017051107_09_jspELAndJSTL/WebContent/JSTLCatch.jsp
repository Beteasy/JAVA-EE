<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>JSTLCatch</title>
	</head>
		
	<body>
		<c:catch var="catchException">
		<%
			int div = 99 / 0;
		%>
		</c:catch>
		<!--<c:out value="${catchException }"/>  -->
		<c:if test="${catchException != null }">
			catch捕获到了错误：${catchException }
		</c:if>
	</body>
	
</html>