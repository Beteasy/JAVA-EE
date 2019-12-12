<%@page import="java.sql.*"%>
<%@page import="com.DBUtils.DBUtils" %>
<%@page import="com.entity.User" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用户主页</title>
</head>
<body>
	<div id="" width:300px;height:120px;border:1px solid #000;float:left>
		<% 
			User user = (User)session.getAttribute("user");
			int stuNo = user.getUser_id();
			try{
				Connection conn = DBUtils.getConnection();;
				Statement statement = null;
				Class.forName("com.mysql.cj.jdbc.Driver");
				statement = conn.createStatement();
				String sql = "select * from student where stuNo="+stuNo;
				ResultSet rs = statement.executeQuery(sql);
		%><%
			while (rs.next()) {
		%>
		<p align="left">欢迎您,&nbsp;&nbsp;<%=rs.getString("stuName")%></p>
		<%
		}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		%>
	</div>
	<div>
		<table>
			<tr>
				<td>
					<input type="button" name="chaxun" value ="按学号查询" onclick="window.location.href='/j2017051107_30_javaeeManagerSystem/input/getStudentByStuNo.jsp'"/>
				</td>
				<td>
					<input type="button" name="chaxun" value ="按姓名查询(模糊查询)" onclick="window.location.href='/j2017051107_30_javaeeManagerSystem/input/getStudentsByName.jsp'"/>
				</td>
				<td>
					<input type="button" name="chaxun" value ="按班级查询" onclick="window.location.href='/j2017051107_30_javaeeManagerSystem/input/getStudentsByClassId.jsp'"/>
				</td>
				<td>
					<input type="button" name="chaxun" value ="分页显示" onclick="window.location.href='/j2017051107_30_javaeeManagerSystem/GetAllStudents'"/>
				</td>
				<td>
					<input type="button" name="stulist" value ="编辑学生信息" onclick="window.location.href='/j2017051107_30_javaeeManagerSystem/show/redirect.jsp'"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>