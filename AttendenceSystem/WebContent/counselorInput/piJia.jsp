<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>假条审批</title>
	</head>
	<body>
		<a href="/AttendenceSystem/PiJiaController?action=search&range=all">所有假条</a>
		<a href="/AttendenceSystem/PiJiaController?action=search&range=unsanctioned">待批准假条</a>
		<a href="/AttendenceSystem/PiJiaController?action=search&range=sanctioned">已批准假条</a>
		<a href="/AttendenceSystem/PiJiaController?action=search&range=failed">审批不通过假条</a>
	</body>
</html>