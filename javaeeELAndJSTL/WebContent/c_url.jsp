<%@ page 
	language="java" 
	contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" 
	import="java.util.*"
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>param和url标签</title>
</head>
<body>
	使用绝对路径构造URL:
	<br />
	<c:url var="myURL" value="http://localhost:8080/javaeeELAndJSTL/info.jsp">
		<c:param name="user" value="张三" />
		<c:param name="addr" value="北京" />
	</c:url>
	<a href="${myURL}">info.jsp</a>
	<br /> 使用相对路径构造URL:
	<br />
	<c:url var="myURL" value="login.jsp?username=admin&pwd=123456" />
	<a href="${ myURL}">login.jsp</a>
</body>
</html>
