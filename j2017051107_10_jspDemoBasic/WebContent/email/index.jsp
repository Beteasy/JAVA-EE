<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.bean.Email"%>
    
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>邮箱合法性检查</title>
	</head>
	
	<body>
		<%
			String erroMsg = "";
			String strEmail = "";
			String email = request.getParameter("email");
			if(email != null){
				strEmail = email;
				Email email2 = new Email(email); 
				if(email2.isEmail()){
					erroMsg = email + "合法";
					//response.getWriter().println(email + "合法<br>");
				}
				else{
					erroMsg = email + "不合法";
					//response.getWriter().println(email + "不合法<br>");
				}
			}
			
			%>
		<form action="index.jsp" method="post">
			<p>请输入邮箱地址：</p>
			<input type="text" name="email" value="<%=strEmail %>"/>
			<font color="red">  <%=erroMsg %></font><br>
			<button type="submit">验证</button>
		</form>
	</body>
</html>
