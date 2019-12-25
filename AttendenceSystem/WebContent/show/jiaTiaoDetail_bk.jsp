<%@page import="com.daoImpl.CounselorDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.entity.JiaTiao"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>假条详情</title>
	</head>
	<body>
		<%
			String idString = request.getParameter("id");
			PrintWriter writer = response.getWriter();
			Integer id = Integer.parseInt(idString);
			CounselorDaoImpl counselorDaoImpl = new CounselorDaoImpl();
			JiaTiao jiaTiao = null;
			System.out.print("idString:"+idString);
			System.out.print("id:"+id);
			jiaTiao = counselorDaoImpl.getJiaTiaoById(id);
			
			//做界面显示的转换
			String type = null;
			String status = null;
			
			switch(jiaTiao.getType()){
			case 1:
				type = "病假";
				break;
			case 2:
				type = "事假";
				break;
			default:
				break;
			}
			
			switch(jiaTiao.getStatus()){
			case 0:
				status = "待审批";
				break;
			case 1:
				status = "批准请假";
				break;
			case 2:
				status = "审核不通过";
				break;
			default:
				break;
			}
			
		%>
		 
	  <form action="">
			编号：<input type="text" name="id" value="<%=jiaTiao.getId() %>" readonly="readonly"><br>
			学号：<input type="text" name="stuNo" value="<%=jiaTiao.getStuNo() %>" readonly="readonly"><br>
			姓名：<input type="text" name="stuName" value="<%=jiaTiao.getStuName() %>" readonly="readonly"><br>
			年级：<input type="text" name="grade" value="<%=jiaTiao.getGrade() %>" readonly="readonly"><br>
			班级：<input type="text" name="classId" value="<%=jiaTiao.getClassId() %>" readonly="readonly"><br>
			课程：<input type="text" name="courNo" value="<%=jiaTiao.getCourNo() %>" readonly="readonly"><br>
			类型：<input type="text" name="title" value="<%=type %>" readonly="readonly"><br>
			内容：<br><textarea cols="20" rows="5" name="content" readonly="readonly"><%=jiaTiao.getContent() %></textarea><br>
			开始日期：<input type="text" name="startdate" value="<%=jiaTiao.getStartdate() %>" readonly="readonly"><br>
			截止日期：<input type="text" name="enddate" value="<%=jiaTiao.getEnddate() %>" readonly="readonly"><br>
			状态：<input type="text" name="status" value="<%=status %>" readonly="readonly"><br>
		<a href="/AttendenceSystem/PiJiaController?action=deal&result=agree&id=<%=jiaTiao.getId() %>&StuNo=<%=jiaTiao.getStuNo() %>">同意</a> 
		<a href='/AttendenceSystem/PiJiaController?action=deal&result=disagree&id=<%=jiaTiao.getId() %>&StuNo=<%=jiaTiao.getStuNo() %>'>拒绝</a>
	</form>
		
	
	</body>
</html>