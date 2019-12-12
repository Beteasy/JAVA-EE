<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>用户登录</title>
	</head>
	
	<body>
		<!-- 导入header.jsp -->
		
		
		<div>
			<form action="admin.jsp" method="post">
				用户名:<input type="text" name="username" value="<%=request.getParameter("username") %>" ><br>
				密   码:<input type="password" name="username"><br>
				<button type="submit">登录</button><br>
		   </form>
	 	 </div>
		
		<!-- 导入footer.jsp -->
		
	</body>
	
</html>