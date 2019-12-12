<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
		<!-- 
			此界面编写辅导员的功能界面
			所有的功能都提交到CounselorFunctionController
			在controller中根据请求作出相应的判断并处理
		 -->
	<head>
		<meta charset="UTF-8">
		<title>功能界面</title>
	</head>
	<body>
	
		<div>
			<table>
				<tr>
					<td>
						<input type="button" name="chaxun" value ="查询年级所有学生出勤记录" onclick="window.location.href='/AttendenceSystem/counselorInput/searchAttenByGrade.jsp'"/>
					</td>
					
					<td>
						<input type="button" name="chaxun" value ="按学号查询" onclick="window.location.href='/AttendenceSystem/counselorInput/searchAttenByStu.jsp'"/>
					</td>
					<td>
						<input type="button" name="pijia" value ="请假审批" onclick="window.location.href='/AttendenceSystem/counselorInput/piJia.jsp'"/>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>