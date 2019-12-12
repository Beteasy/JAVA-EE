<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.entity.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>学生请假</title>
</head>
<body>
	<div>
		<%
			User user = (User)session.getAttribute("user");
			int stuNo = user.getUseNo();
		%>
		<form action="<%=request.getContextPath()%>/StudentQingjia" method="post">
			<table align="center">
				<tr>
					<td><b>学号：</b></td>
					<td><input size="30" type="text" name="stuNo" style="WIDTH: 150" value=<%=stuNo%>></td>
				</tr>
				<tr>
					<td><b>请假开始日期：</b></td>
					<td><input size="30" type="date" name="startdate" style="WIDTH: 150""></td>
				</tr>
				<tr>
					<td><b>请假截止日期：</b></td>
					<td><input size="30" type="date" name="enddate" style="WIDTH: 150""></td>
				</tr>				
				<tr>
					<td><b>课程编号：</b></td>
					<td><input size="30" type="text" name="courNo" style="width:100px"></td>
				</tr>		
				<tr>
					<td><b>请假类型：</b></td>
					<td><select name="type">
  							<option value ="bingjia">病假</option>
							<option value ="shijia">事假</option>
					</select></td>
				</tr>				
				<tr>
					<td><b>请假内容：</b></td>
					<td><input size="30" type="text" name="content" style="width:500px;height:300px"></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="hidden" name="action" value="qingjia"/>
						<input type="submit" value=" 提交"> 
						<input type="reset" value=" 取消 ">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>