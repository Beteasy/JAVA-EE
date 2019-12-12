<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>forEach标签</title>
</head>
<body>
	<%
		String[] fruits = { "lemon", "orange", "apple", "pear" };
	%>
	String数组中的元素：
	<br />
	<c:forEach var="name" items="<%=fruits%>">
 		${name}<br />
	</c:forEach>
	<%
		Map userMap = new HashMap();
		userMap.put("Jack", "123456");
		userMap.put("Jim", "123456");
		userMap.put("Lucy", "123456");
	%>
	<hr />
	HashMap集合中的元素：
	<br />
	<c:forEach var="entry" items="<%=userMap%>">
		${entry.key}&nbsp;&nbsp;&nbsp;${entry.value}<br />
	</c:forEach>
</body>
</html>
