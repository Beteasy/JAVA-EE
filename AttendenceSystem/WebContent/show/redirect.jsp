<%@page import="java.io.PrintWriter"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		PrintWriter writer = response.getWriter();
		User user = (User)session.getAttribute("user");
		if(user.getPermission() == 1){
			//request.getRequestDispatcher("/j2017051107_30_javaeeManagerSystem/stuList.jsp").forward(request, response);
			writer.print("<script>window.location='/j2017051107_30_javaeeManagerSystem/stuList.jsp' </script>");
		}
		else{
			writer.print("<script>alert('您的权限不足！不能进行编辑！'); window.location='/j2017051107_30_javaeeManagerSystem/input/loginsuccess.jsp' </script>");
		}
	%>
	
</body>
</html>