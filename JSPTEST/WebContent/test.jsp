<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int i, sum=0;
		for(i=1;i<=100;i++){
			sum+=i;
		}
	%>
	<br>
	<%=sum %>
</body>
</html>