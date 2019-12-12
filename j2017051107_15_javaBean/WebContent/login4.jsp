<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>第四个登陆界面 application范围</title>
	</head>
	<body>
		<jsp:useBean id="user" class="j2017051107_15_javaBean.User" scope="application"></jsp:useBean>
		<form action="login4.jsp" method="post">
			<%
				if(request.getParameter("username") != null){
			%>
					<jsp:setProperty property="*" name="user"/>
					<h2>
						您是第<jsp:getProperty property="count" name="user"/>次登陆
					</h2>
		
			<%
				}
			%>
		
			<div>
				用户名：<input type="text" name="username" id="username"><br>
				密    码：<input type="password" name="password" id="password"><br>
				<button type="submit" id="submit" onclick="checkFunction()">登陆</button>
			</div>
		</form>
	</body>
</html>