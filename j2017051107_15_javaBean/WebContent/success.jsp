<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>success</title>
	</head>
	<body>
		<jsp:useBean id="user" class="j2017051107_15_javaBean.User" scope="request"></jsp:useBean>
		<%
			if(request.getParameter("username") != null){
		%>
				<jsp:setProperty property="*" name="user"/>
				<h2>
					<jsp:getProperty property="username" name="user"/>
					,欢迎回来，您是第<jsp:getProperty property="count" name="user"/>次登陆
				</h2>
		
		<%
			}
		%>
		
		
	</body>
</html>