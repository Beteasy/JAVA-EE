<%@page import="com.bean.Email"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>邮箱检验结果</title>
	</head>
	
	<body>
		<div>
			<!-- 获取从login.jsp传过来的数据 -->
			<%
				String email = request.getParameter("email");
				Email email2 = new Email(email); 
				if(email2.isEmail()){
					response.getWriter().println(email + "合法<br>");
				}
				else{
					response.getWriter().println(email + "不合法<br>");
				}
			%>
		</div>
		
		<div>
			<a href="index.jsp">返回检验页</a>
		</div>
		
	</body>
	
</html>