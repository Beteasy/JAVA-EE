<%@page import="java.sql.*"%>
<%@page import="com.DBUtils.DBUtils" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>学生信息修改</title>
</head>
<body>
	<div>
    <%
		try {
		Connection conn = DBUtils.getConnection();
		Statement statement = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		statement = conn.createStatement();
		String sql = "select * from student where stuNo="+request.getParameter("stuNo");
		ResultSet rs = statement.executeQuery(sql);
	%><%
		if (rs.next()) {
	%>
	<form action="<%=request.getContextPath()%>/StuServlet" method="post">
		编号：<%=rs.getString("stuNo")%><br>
		姓名：<input type="text" name="stuName" value="<%=rs.getString("stuName")%>" /><br>
		班级：<input type="text"name="classId" value="<%=rs.getString("classId")%>" /><br> 
		权限：<input type="text" name="stuPermission" value="<%=rs.getString("stuPermission")%>" /><br>
		用户名：<input type="text" name="userName" value="<%=rs.getString("userName")%>" /><br>
		密码：<input type="text" name="password" value="<%=rs.getString("password")%>" /><br> 
		手机号：<input type="text" name="phoneNumber" value="<%=rs.getString("phoneNumber")%>" /><br> 
		<input type="hidden" name="action" value="update"/>
		<input type="hidden" name="stuNo" value="<%=request.getParameter("stuNo")%>"/>
		<input type="submit" name="commit" value="提交" /><input type="reset" value="重置" /><br>
	</form>
	<%
		}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
</div>
</body>
</html>