<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>JSTL Basic</title>
	</head>
		
	<body>
		<h1>JSTL 基本测试</h1>
		<div>
			<p>
				<c:out value="使用c:out输出字符串"></c:out>
			</p>
		</div>
		
		<div>
			<b>浏览器版本：</b><br>
			<c:out value="<font color='red'>${header['User-Agent'] }" escapeXml="true"></c:out><br>
			<c:out value="<font color='red'>${header['User-Agent'] }" escapeXml="false"></c:out><br>
		</div>
		
		<div>
			<c:set var="x" value="用c:set设置变量值和对象属性"></c:set>
			<c:out value="${x }"></c:out>
		</div>
		
	</body>
	
</html>