<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>简易计算器</title>
	</head>
	
	<body>
		<form action="../ComputerServlet" method="post">
			<h1>简易计算器</h1>
			<input type="text" name="x" value="${sessionScope.computer.x }">
			<select name="operator">
				<option value="+">+
				<option value="-">-
				<option value="*">*
				<option value="/">/
			</select>
			<input type="text" name="y" value="${sessionScope.computer.y }">
			<button type="submit">计算</button><br><br>
		</form>
		${sessionScope.computer.x }
		${sessionScope.computer.operator }
		${sessionScope.computer.y }
		=
		${sessionScope.computer.result }
		
	</body>
	
</html>