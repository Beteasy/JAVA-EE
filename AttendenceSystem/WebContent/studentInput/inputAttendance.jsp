<%@page import="java.sql.*"%>
<%@page import="com.DBUtils.DBUtils" %>
<%@page import="com.entity.User" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8">
	<title>学生出勤查询</title>
</head>
<body>
	<% 
			User user = (User)session.getAttribute("user");
			int stuNo = user.getUseNo();
			int permission = user.getPermission();
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
		<p><b>登陆者：<%=rs.getString("stuName") %></b></p>
		<form action="<%=request.getContextPath()%>/StudentSearchAction" method="post">
			<table align="left">
				<tr>
					<td><b>学号：</b></td>
					<td><input size="30" type="text" name="stuNo" style="WIDTH: 150" value=<%=stuNo%>></td>
				</tr>
				<tr>
					<td><b>请假日期：</b></td>
					<td><input size="30" type="date" name="sdate" style="WIDTH: 150""></td>
				</tr>			
				<tr>
					<td><b>课程编号：</b></td>
					<td><input size="30" type="text" name="scourNo" style="width:100px"></td>
				</tr>
				<tr>
				</tr>					
				<tr>
					<td align="center" colspan="2">
						<input type="hidden" name="action" value="qingjia"/>
						<input type="submit" value=" 提交"> 
						<input type="reset" value=" 取消 ">
					</td>
				</tr>
			</table>
			</br>
		
		</form>

		<%
		}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		%>
</body>
</html>