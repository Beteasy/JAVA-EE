<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>注销</title>
	</head>
	<body>
		<%
			session.invalidate();
		%>
		<c:redirect url="index.jsp"></c:redirect>
	</body>
</html>