<%@page import="java.sql.*"%>
<%@page import="com.DBUtils.DBUtils" %>
<%@page import="com.entity.User" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
		<!-- 
			此界面编写学生的功能界面
			所有的功能都提交到StudentFunctionController
			在controller中根据请求作出相应的判断并处理
		 -->
	<head>
		<meta charset="UTF-8">
		<title>学生页面</title>
	</head>
	<body>
		<div id="" width:300px;height:120px;border:1px solid #000;float:left>
		<% 
			User user = (User)session.getAttribute("user");
			int stuNo = user.getUseNo();
			int permission = user.getPermission();
			try{
				Connection conn = DBUtils.getConnection();
				Statement statement = null;
				Class.forName("com.mysql.cj.jdbc.Driver");
				statement = conn.createStatement();
				String sql = "select * from student where stuNo="+stuNo;
				ResultSet rs = statement.executeQuery(sql);
		%><%
			while (rs.next()) {
		%>
		<p align="left">欢迎您,&nbsp;&nbsp;<%=rs.getString("stuName")%></p>
		<p align="left">您的用户类型是&nbsp;&nbsp;<%=permission%></p>
		<%
		}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		%>
	</div>
		<table>
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/StudentSearch?action=searchallstu&stuNo=<%=stuNo%>">
						查询总出勤
					</a>
					<input type="button" name="search_chuqin" value ="查询总出勤情况" onclick="window.location.href='/AttendenceSystem/StudentSearch?action=searchallstu&stuNo=<%=stuNo%>"/>
				</td>
				<td>
					<input type="button" name="search_chuqin" value ="查询出勤情况" onclick="window.location.href='/AttendenceSystem/studentInput/inputAttendance.jsp'"/>
				</td>
				<td>
					<input type="button" name="search_chuqin" value ="查询请假" onclick="window.location.href='<%=request.getContextPath()%>/StudentQingjia?action=search&stuNo=<%=stuNo%>'"/>
				</td>
				<td>
					<input type="button" name="qingjia" value ="请假" onclick="window.location.href='/AttendenceSystem/studentInput/qingjia.jsp'"/>
				</td>
			</tr>
		</table>
	</body>
</html>