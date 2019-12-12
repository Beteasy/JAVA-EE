<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>分页显示学生</title>
	</head>
	<body>
		<%
			PrintWriter writer = response.getWriter();
			List<Student> studentList = (ArrayList<Student>)request.getAttribute("studentList");
			//System.out.print(studentList.size());
			int studentsNumber = studentList.size();	//学生的总数
			int pageSize = 3;	//每页显示3个
			int pageCount = (studentsNumber-1)/pageSize+1;	//计算需要显示多少页
			int pageNum = 1;	//待显示的页面
			int currentPage;
			Student student = null;
			
			if(request.getParameter("pageNum") == null){
				pageNum = 1;
			}
			else{
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			}
			if(pageNum > pageCount){
				pageNum = pageCount;
			}
			else if(pageNum < 1){
				pageNum = 1;
			}
			
			int startIndex = (pageNum-1)*pageSize;	//计算每页开始显示的下标
			
			
			writer.print(
					"<table border='1' width='100%' style='table-layer:fixed'>"
					+"<tr>"
					+ "<th>学号</th>"
					+ "<th>姓名</th>"
					+ "<th>班级</th>"
					+ "<th>权限</th>"
					+ "<th>用户名</th>"
					+ "<th>密码</th>"
					+ "<th>电话号码</th>"
					+"</tr>"
					);
				
				for(int i=startIndex; i<startIndex+pageSize && i<studentsNumber; i++){
					System.out.print(i);
					student = studentList.get(i);
					writer.print("<tr>");
					writer.print("<td>"+student.getStuNo()+"</td>");		
					writer.print("<td>"+student.getStuName()+"</td>");
					writer.print("<td>"+student.getClassId()+"</td>");	
					//writer.print("<td>"+student.getStuPermission()+"</td>");	
					//writer.print("<td>"+student.getUserName()+"</td>");	
					//writer.print("<td>"+student.getPassword()+"</td>");	
					//writer.print("<td>"+student.getPhoneNumber()+"</td>");	
					writer.print("</tr>");
				}
				writer.print("</table>");
		%>
		共<%=studentsNumber%>个记录，分<%=pageCount%>页显示/当前第<%=pageNum%>页     <%
				for (int j = 1; j <= pageCount; j++) {
					out.print("&nbsp;&nbsp;<a href='?pageNum=" + j + "'>"
										+ j + "</a>");
							}
		%>
	</body>
</html>