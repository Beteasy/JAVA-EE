<%@page import="java.sql.*"%>
<%@page import="com.DBUtils.DBUtils" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>学生列表</title>
</head>
<body>
<%
	try {
		//驱动类
		Connection conn = DBUtils.getConnection();;
		Statement statement = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		statement = conn.createStatement();
		String sql = "select * from student";
		ResultSet rs = statement.executeQuery(sql);
%>
	<table border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" width="100%">
	 	<tr align="center" bgcolor="#FAFAF1" >
   		<td>编号</td>
   		<td>姓名</td>
   		<td>班级</td>
   		<td>权限</td>
   		<td>用户名</td>
   		<td>密码</td>
   		<td>手机号</td>
   	</tr>
   	<%
		while (rs.next()) {
	%>
	<tr>
		<td><%=rs.getString("stuNo")%></td>
		<td><%=rs.getString("stuName")%></td>
		<td><%=rs.getString("classId")%></td>
		<td><%=rs.getString("stuPermission")%></td>
		<td><%=rs.getString("userName")%></td>
		<td><%=rs.getString("password")%></td>
		<td><%=rs.getString("phoneNumber") %></td>
		<td>
			<a href="stucontroller/stuUpdate.jsp?stuNo=<%=rs.getString("stuNo")%>"><img src="imgs/edit.gif"/>
			</a>
			<a href="<%=request.getContextPath()%>/StuServlet?action=del&stuNo=<%=rs.getString("stuNo")%>">
				<img src="imgs/del.gif"/>
			</a>
		</td>
	</tr>
	<%
		}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	%></table>
	<a href="stucontroller/stuAdd.jsp">添加学生</a>
</body>
</html>