<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>第二个登陆界面 request范围</title>
	</head>
	<body>
		<!-- 创建一个user的javabean，设置其作用域为request范围 -->
		<jsp:useBean id="user" class="j2017051107_15_javaBean.User" scope="request"></jsp:useBean>
		<form action="login2.jsp" method="post" name="myForm">
			<%
				if(request.getParameter("username") != null){
					//用户名不为空，设置值到javaBean
			%>
					<!-- 一次性将所有值都放到javabean中 -->
					<jsp:setProperty property="*" name="user"/>
					<h2>
						<jsp:getProperty property="username" name="user"/>
						,欢迎回来，您是第<jsp:getProperty property="count" name="user"/>次登陆
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
		
		<!-- 
		转发给success.jsp
		注意加上和不加上flush的区别
		注意刷新和关闭浏览器的现象
		 -->
		<jsp:include page="success.jsp"></jsp:include>
		
		<script type="text/javascript">
			function checkFunction(){
				var form = doucument.myForm;
				if(form.username.value=""){
					alert("用户名不能为空!");
					form.username.focus();
					return false;
				}
				if (form.password.value=='')  
				{ 
			    	alert("密码不能为空!");   
				    form.password.focus();   
					return false;   
				}  
					return true;
			}
		</script>
	</body>
</html>