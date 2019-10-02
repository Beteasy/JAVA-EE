<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<jsp:useBean id="login" class="com.DataBaseOperator" scope="session"></jsp:useBean>

<%
	String logname = login.getLogname();
	String delop = request.getParameter("op");
	String success = login.getSuccess();
	String id1 = request.getParameter("id");
	String id2 = request.getParameter("idn");
	if (success == null) {
		success = "";
	}
	if ((session.isNew())) {
		response.sendRedirect("login.jsp");
	} else if (!(success.equals("ok"))) {
		response.sendRedirect("login.jsp");
	}

	else if ((id1 == null) && (id2 == null))

		response.sendRedirect("login.jsp");
	else {

		if (delop == null) {

			String name = request.getParameter("name");
			name = login.codeString(name);
			String age = request.getParameter("age");
			String gender = request.getParameter("gender");
			gender = login.codeString(gender);
			String major = request.getParameter("major");
			major = login.codeString(major);
			login.update(Integer.parseInt(id1), name, age, gender, major);
		}

		else {

			login.delete(Integer.parseInt(id2));
		}
	}
%>


<html>
<body>
	<Font size=2>
		<P>
			操作成功。 <a href="main.jsp">返回主页</a>
</body>
</html>