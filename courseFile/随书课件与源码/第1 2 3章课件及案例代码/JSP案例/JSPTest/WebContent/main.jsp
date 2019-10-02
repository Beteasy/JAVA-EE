<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.Student"%>

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
	<Font size=2>
		<P>
			显示学生信息：

			<%
			String logname = login.getLogname();
			if (logname == null) {
				logname = "";
			}

			Set<Student> sts = login.searchAllStudents();
			Iterator<Student> it = sts.iterator();
		%>
		
		<Table frame="border" bordercolor="black" style="width: 600px;">
			<!--  表头-->

			<TR>
				<TD style="border: 1px solid black;">学号</TD>
				<TD style="border: 1px solid black;">姓名</TD>
				<TD style="border: 1px solid black;">年龄</TD>
				<TD style="border: 1px solid black;">性别</TD>
				<TD style="border: 1px solid black;">专业</TD>
				<TD style="border: 1px solid black;">操作</TD>
			</TR>

			<%
				while (it.hasNext()) {
					Student st = it.next();
			%>
			<TR>
				<TD style="border: 1px solid black;"><%=st.getId()%></TD>
				<TD style="border: 1px solid black;"><%=st.getName()%></TD>
				<TD style="border: 1px solid black;"><%=st.getAge()%></TD>
				<TD style="border: 1px solid black;"><%=st.getGender()%></TD>
				<TD style="border: 1px solid black;"><%=st.getMajor()%></TD>

				<TD style="border: 1px solid black;"><a
					href="update.jsp?op=del&idn=<%=st.getId()%>">删除</a>
					&nbsp&nbsp&nbsp&nbsp <a
					href="modify.jsp?op=modi&idn=<%=st.getId()%>">修改</a></TD>
			</TR>
			<%
				}
			%>
		</Table> <script type="text/javascript">
			function check() {//javascript表单验证方法，提交表单时验证
				var id = document.getElementById("uid").value;//通过uid获取表单元素学号的值
				var age = document.getElementById("age").value;//通过age获取表单元素年龄的值
				if (isNaN(age) || id == "" || isNaN(id)) {
					alert("学号不能为空，且学号与年龄必须是数字！");
					return false;//学号为空、学号与年龄不是数字，则返回false，不提交表单
				}
				return true;//提交表单
			}
			function checkid() {//javascript验证学号是否为数字
				var id = document.getElementById("id").value;
				if (isNaN(id)) {
					alert("学号必须是数字！");
					return false;//返回false，不提交表单
				}
				return true;//提交表单
			}
		</script> <%--该表单根据学号或姓名查询学生记录 --%>
		<form action="showresult.jsp?op=select" method="POST"
			onsubmit="return checkid();">
			<BR> 学号: <input type=text name="id" value=""> <BR>
			姓名: <input type=text name="name" value=""> <input type=submit
				name="sel" value="查询记录">
		</form> <%--该表单输入各属性的值--%>
		<form action="showresult.jsp?op=add" method="POST"
			onsubmit="return check();">
			<BR> 学号: <input type=text name="uid" value=""> <BR>
			姓名: <input type=text name="name" value=""> <BR> 年龄: <input
				type=text name="age" value=""> <BR> 性别: <input
				type=text name="gender" value=""> <BR> 专业: <input
				type=text name="major" value=""> <input type=submit
				name="add" value="添加记录">
		</form>
</body>
</html>