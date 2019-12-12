<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
		<!-- 
			此界面编写教师的功能界面
			所有的功能都提交到TeacherFunctionController
			在controller中根据请求作出相应的判断并处理
		 -->
	<head>
		<meta charset="UTF-8">
		<title>教师页面</title>
	</head>
	<body>
		
		<table>
			<tr>
				<td>
					<input type="button" name="search_chuqin" value ="查询班级总出勤情况" onclick="window.location.href='/AttendenceSystem/teacherInput/searchAttenByClassId.jsp'"/>
				</td>
				<td>
					<input type="button" name="search_chuqin" value ="按学号查询" onclick="window.location.href='/AttendenceSystem/teacherInput/searchAttenByStuNo.jsp'"/>
				</td>
				<td>
					<input type="button" name="qingjia" value ="请假" onclick="window.location.href='/AttendenceSystem/teacherInput/searchQinJia.jsp'"/>
				</td>
				<td>
					<input type="button" name="UpdateAttend" value ="修改出勤记录" onclick="window.location.href='/AttendenceSystem/teacherInput/UpdateAttend.jsp'"/>
				</td>
			</tr>
		</table>
	</body>
</html>