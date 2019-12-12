<%@page import="com.bean.Email"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>验证注册</title>
	</head>
	
	<body>
		<!-- 获取index.jsp提交过来的数据 -->
		<%
			request.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String confirmPass = request.getParameter("confirmPass");
			String email = request.getParameter("email");
			Email mail = new Email(email);
			String mailErro = "";
			String passErro = "";
			if(password.equals(confirmPass)){
				//如果两次密码匹配，进行邮箱验证
				if(mail.isEmail()){
					//邮箱和密码都检测通过的话，跳转到登录页面
		%>
					<jsp:forward page="login.jsp">
						<jsp:param name="username" value="<%=username %>" />
					</jsp:forward>
		<%
					
				}
				else{
					//邮箱不正确，回到注册界面，并提示邮箱错误
					mailErro = "邮箱不合法";
		%>
					<jsp:forward page="index.jsp">
						<jsp:param name="username" value="<%=username %>" />
						<jsp:param name="password" value="<%=password %>" />
						<jsp:param name="confirmPass" value="<%=confirmPass %>" />
						<jsp:param name="email" value="<%=email %>" />
						<jsp:param name="mailErro" value="<%=mailErro %>" />
					</jsp:forward>
		<%
				}
			}
			else{
				//两次密码不匹配，回到注册界面，并提示密码错误
				passErro = "两次密码不匹配";
		%>
				<jsp:forward page="index.jsp">
					<jsp:param name="username" value="<%=username %>" />
					<jsp:param name="password" value="<%=password %>" />
					<jsp:param name="confirmPass" value="<%=confirmPass %>" />
					<jsp:param name="email" value="<%=email %>" />
					<jsp:param name="passErro" value="<%=passErro %>" />
				</jsp:forward>
		<%
				
			}
		%>
	</body>
	
</html>