<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>查询学生出勤记录</title>
	</head>
	<body>
		<form action="/AttendenceSystem/SearchAttenByStuController" method="post">
			学号：<input type="text" name="stuNo"><br>
			日期：<input type="date" name="date" value=""><br>
			课程：<select name="course">
					  <option value="0">所有课程</option>
					  <option value ="1">Java SE</option>
					  <option value ="2">Java EE</option>
					  <option value="3">C语言</option>
					</select>
			<input type="submit" value="查询">
		</form>
	</body>
</html>