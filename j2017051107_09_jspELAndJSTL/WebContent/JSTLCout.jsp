<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>JSTLOUT</title>
	</head>
	
	<body>
		<div>
			c:out输出字符串：<c:out value="我直接输出value中的字符串"></c:out><br><br>
			c:out输出EL算数运算的值(1+1)：<c:out value="${1 + 1 }"></c:out><br><br>
			c:out输出客户端请求的数据：<c:out value="${param.data }" default="默认值"></c:out><br><br>
			c:out escapeXml默认值为TRUE：<c:out value="<font color='red'>${header['User-Agent'] }"></c:out><br><br>
			c:out 设置escapeXml的值为FALSE：<c:out value="<font color='red'>${header['User-Agent'] }" escapeXml="false"></c:out><br><br>
		</div>
	</body>
	
</html>