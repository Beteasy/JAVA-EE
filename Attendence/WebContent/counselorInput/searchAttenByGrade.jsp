<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询年级学生出勤记录</title>
	</head>
	<body>
		<form action="/AttendenceSystem/SearchAttenByGradeController" method="post">
			<!-- 从session中拿到辅导员的所属年级 -->
			<!-- 年级还没有拿到   ！！！！！！！！！！！！！ -->
			年级：<input type="text" value="${sessionScope}" disabled="disabled"><br>
		
			<input type="submit" value="查询">
		</form>
	</body>
</html>