<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	
	<body>
		
		<form action="check.jsp" method="post">
			<%
			String username;
			String password;
			String email;
			String confirmPass;
			String passErro;
			String mailErro;
			if(request.getParameter("username") == null){
				username = "";
			}
			else{
				username = request.getParameter("username");
			}
			if(request.getParameter("password") == null){
				password = "";
			}
			else{
				password = request.getParameter("password");
			}
			if(request.getParameter("email") == null){
				email = "";
			}
			else{
				email = request.getParameter("email");
			}
			if(request.getParameter("confirmPass") == null){
				confirmPass = "";
			}
			else{
				confirmPass = request.getParameter("confirmPass");
			}
			if(request.getParameter("passErro") == null){
				passErro = "";
			}
			else{
				passErro = request.getParameter("passErro");
			}
			if(request.getParameter("mailErro") == null){
				mailErro = "";
			}
			else{
				mailErro = request.getParameter("mailErro");
			}
			
		%>
			用  户  名:<input type="text" name="username" value="<%=username %>"><br>
			密       码:<input type="password" name="password" value="<%=password %>" >
			<font color="red"><%=passErro %></font><br>
			确认密码:<input type="password" name="confirmPass" value="<%=confirmPass %>"><br>
			邮       箱:<input type="text" name="email" value="<%=email %>">
			<font color="red"><%=mailErro %></font> <br>
			<button type="submit">注册</button>
		</form>
	</body>
	
</html>