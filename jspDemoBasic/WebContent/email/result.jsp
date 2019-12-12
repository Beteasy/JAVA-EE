<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.Email"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮箱认证系统</title>

<style type="text/css">
	div {
		backgroud:#666666;
		color:#333333;
	}
	#email {
		width: 300px;
		margin: 0 auto;
		float: left;
	}
	#back {
		width:300px;
		margin: 0 auto;
		background: #95ba46;
	}
</style>
</head>
<body>
<h2>邮箱认证系统</h2><br />
<div id="email">
<% 
	String mail = request.getParameter("email");
	Email email = new Email(mail);
	if(email.isMail()){
		out.print(mail+"<br>是一个标准的邮箱地址<br>");
	}else{
		out.print(mail+"<br>不是一个标准的邮箱地址<br>");
	}
%>
</div>
<div id="back">
	<a href="index.jsp">【返回】</a>
</div>

</body>
</html>