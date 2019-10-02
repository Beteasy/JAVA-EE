<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="login" class="com.DataBaseOperator" scope="session"></jsp:useBean>
<html>
<body>
	<Font size=2> <%
 	String string = response.encodeUrl("login.jsp");
 %> <%-- 登录界面表单--%>
		<P>输入用户名和密码：
		<form action="<%=string%>" method="POST">
			<BR> 登录名称: <input type=text name="logname"> <BR>输入密码:
			<input type=text name="password"> <BR> <input
				type=submit name="g" value="提交">
		</form> <%
 	//提交信息后，验证信息是否正确
 	String message = "", logname = "", password = "";
 	if (!(session.isNew())) {
 		logname = request.getParameter("logname");
 		logname = login.codeString(logname);
 		if (logname == null) {
 			logname = "";

 		}
 		password = request.getParameter("password");
 		password = login.codeString(password);
 		if (password == null) {
 			password = "";

 		}
 	}
 %> <%
 	if (!(logname.equals(""))) {
 %> <jsp:setProperty property="logname" name="login"
			value="<%=logname%>" /> <jsp:setProperty property="password"
			name="login" value="<%=password%>" /> <%
 	message = login.getMessage();//获取返回的验证信息
 		if (message == null) {
 			message = "";
 		}

 	}

 	if (!(session.isNew())) {
 		if (message.equals("ok")) {
 			String str = response.encodeURL("main.jsp");
 			response.sendRedirect(str);
 		} else {
 			out.print(message);
 		}
 	}
 %>
</body>
</html>