<%@page import="java.sql.*"%>
<%@page import="com.DBUtils.DBUtils" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>登录</title>
</head>
<body>
	<div id="login">
		<form action="<%=request.getContextPath()%>/UserLoginServlet" name="login" method="post">
			<table cellspacing=1 cellpadding=0 width=400 id=CommonListArea 	align="center">
				<tr id=CommonListCell height="30">
					<td width="40%" align="right"><b>用户名：</b></td>
					<td><input type="text" size="30" name="account" value="" style="WIDTH: 150"></td>
				</tr>
				<tr id=CommonListCell height="30">
					<td width="40%" align="right"><b>密&nbsp;&nbsp;&nbsp;码：</b></td>
					<td><input size="30" type="password" name="pwd" style="WIDTH: 150"></td>
				</tr>
				<tr id=CommonListCell height="30">
					<td align="center" colspan="2">
						<input type="submit" value=" 登录 "> 
						<input type="reset" value=" 取消 ">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>