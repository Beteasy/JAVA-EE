<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
  		<meta charset="UTF-8">   
		<title>按班级查找学生</title>
	</head>
	<body>
		<form action="/AttendenceSystem/SearchAttenByClassId" method="post">
			班级：<input type="text" name="classId"><br>
			日期：<input type="date" name="date"><br>
			课程：<select name="course">
					  <option value ="1">Java SE</option>
					  <option value ="2">Java EE</option>
					  <option value="3">C语言</option>
					  <option value="4">Audi</option>
					</select>
			<input type="submit" value="查询">
			</form>
	</body>
</html>