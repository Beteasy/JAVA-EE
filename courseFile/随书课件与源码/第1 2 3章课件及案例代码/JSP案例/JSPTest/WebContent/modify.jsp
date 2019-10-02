<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.Student"%>
<jsp:useBean id="login" class="com.DataBaseOperator" scope="session"></jsp:useBean>

<%
	String success = login.getSuccess();
	String logname = login.getLogname();
	String stuid = request.getParameter("idn");
	if (success == null) {
		success = "";
	}
	if ((session.isNew())) {
		response.sendRedirect("login.jsp");
	} else if (!(success.equals("ok"))) {
		response.sendRedirect("login.jsp");
	} else if (stuid == null) {

		response.sendRedirect("login.jsp");
	}

	else {
		int id = Integer.parseInt(stuid);
		Student st = new Student();
		st = login.searchOneStudent(id);
%>

<script type="text/javascript">
	function check() {
		var id = document.getElementById("id").value;
		var age = document.getElementById("age").value;
		if (isNaN(age) || id == "" || isNaN(id)) {
			alert("学号不能为空，且学号与年龄必须是数字！");
			return false;
		}
		return true;
	}
</script>
<html>
<body>
	<Font size=2> <%-- 修改学生信息的表单--%>
		<P>修改学生信息：
		<form action="update.jsp" method="POST" onsubmit="return check();">
			<BR> 学号: <input type=text name="id" value="<%=st.getId()%>">
			<BR> 姓名: <input type=text name="name" value="<%=st.getName()%>">
			<BR> 年龄: <input type=text name="age" value="<%=st.getAge()%>">
			<BR> 性别: <input type=text name="gender"
				value="<%=st.getGender()%>"> <BR> 专业: <input type=text
				name="major" value="<%=st.getMajor()%>"> <BR> <input
				type=submit name="g" value="提交修改">
		</form> <%
 	}
 %>
</body>
</html>