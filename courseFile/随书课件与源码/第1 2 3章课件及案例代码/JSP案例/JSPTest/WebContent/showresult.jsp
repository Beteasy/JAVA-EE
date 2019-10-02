<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.Student"%>
<%@ page import="java.util.*"%>
<%@ page import=" javax.swing.JOptionPane"%>
<jsp:useBean id="login" class="com.DataBaseOperator" scope="session"></jsp:useBean>

<%
	if ((session.isNew())) {
		response.sendRedirect("login.jsp");
	}
	String success = login.getSuccess();
	if (success == null) {
		success = "";
	}
	if (!(success.equals("ok"))) {
		response.sendRedirect("login.jsp");
	}
%>

<html>
<body>
	<Font size=2> <%
 	String op = request.getParameter("op");
 	String logname = login.getLogname();
 	if (logname == null || op == null) {
 		logname = "";
 		response.sendRedirect("login.jsp");
 	} else {

 		String id = request.getParameter("id");
 		String name = request.getParameter("name");
 		name = login.codeString(name);
 		Set<Student> sts = null;
 		if (op.equals("add")) {

 			String age = request.getParameter("age");
 			String gender = request.getParameter("gender");
 			gender = login.codeString(gender);
 			String major = request.getParameter("major");
 			major = login.codeString(major);
 			int idnew = Integer.parseInt(request.getParameter("uid"));
 			//调用DataBaseOperator类中的insert方法插入一条学生记录 
 			login.insert(idnew, name, age, gender, major);
 			//调用DataBaseOperator类中的searchAllStudents方法获取所有学生记录 
 			sts = login.searchAllStudents();

 		} else
 			//调用DataBaseOperator类中的searchStudents方法获取学生记录 
 			sts = login.searchStudents(id, name);
 		Iterator<Student> it = sts.iterator();
 %>
		<P>
			学生信息： <a href="main.jsp">返回主页</a>
		<Table frame="border" bordercolor="black" style="width: 600px;">
			<!--  表头-->
			<TR>
				<TD style="border: 1px solid black;">学号</TD>
				<TD style="border: 1px solid black;">姓名</TD>
				<TD style="border: 1px solid black;">年龄</TD>
				<TD style="border: 1px solid black;">性别</TD>
				<TD style="border: 1px solid black;">专业</TD>

			</TR>

			<%
				//Iterator<Student> it = sts.iterator();
					while (it.hasNext()) {
						Student st = it.next();
			%>
			<!--  根据记录的条数，显示学生记录-->
			<TR>
				<TD style="border: 1px solid black;"><%=st.getId()%></TD>
				<TD style="border: 1px solid black;"><%=st.getName()%></TD>
				<TD style="border: 1px solid black;"><%=st.getAge()%></TD>
				<TD style="border: 1px solid black;"><%=st.getGender()%></TD>
				<TD style="border: 1px solid black;"><%=st.getMajor()%></TD>
			</TR>
			<%
				}
				}
			%>

		</Table>
</body>
</html>