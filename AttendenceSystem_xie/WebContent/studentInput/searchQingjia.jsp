<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.JiaTiao"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.DBUtils.DBUtils" %>
<%@page import="java.text.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>学生请假情况</title>
</head>
	<body>
		<%
			Connection conn = null;
			PreparedStatement pre = null;
			ResultSet res = null;
			PrintWriter writer = response.getWriter();
			List<JiaTiao> jiatiaoList = (ArrayList<JiaTiao>)request.getAttribute("jiatiaoList");
			int totalNumber = jiatiaoList.size();
			int pageSize = 2;
			int pageCount = (totalNumber-1)/pageSize+1;	//计算需要显示多少页
			int pageNum = 1;	//待显示的页面
			int currentPage;
			JiaTiao jiatiao = null;
			
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
					+ "<th>课程</th>"
					+ "<th>班级</th>"
					+ "<th>年级</th>"
					+ "<th>请假类型</th>"
					+ "<th>开始日期</th>"
					+ "<th>截止日期</th>"
					+ "<th>状态</th>"
					+"</tr>"
					);
				
				for(int i=startIndex; i<startIndex+pageSize && i<totalNumber; i++){
					System.out.print(i);
					jiatiao = jiatiaoList.get(i);
					writer.print("<tr>");
					writer.print("<td>"+jiatiao.getStuNo()+"</td>");		
					writer.print("<td>"+jiatiao.getStuName()+"</td>");
					try {
						conn = DBUtils.getConnection();
						String sql = "select * from course where courNo="+jiatiao.getCourNo();
						pre = conn.prepareStatement(sql);
						res = pre.executeQuery();
						while (res.next()) {
							writer.print("<td>"+res.getString("courName")+"</td>");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					conn.close();
					writer.print("<td>"+jiatiao.getClassId()+"</td>");	
					writer.print("<td>"+jiatiao.getGrade()+"</td>");
					if(jiatiao.getType() == 1){
						writer.print("<td>病假</td>");	
					}
					else if(jiatiao.getType() == 2){
						writer.print("<td>事假</td>");	
					}
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");				
					writer.print("<td>"+sf.format(jiatiao.getStartdate())+"</td>");	
					writer.print("<td>"+sf.format(jiatiao.getEnddate())+"</td>");	
					if(jiatiao.getStatus() == 0){
						writer.print("<td>等待辅导员审批</td>");	
					}
					else if(jiatiao.getStatus() == 1){
						writer.print("<td>请假通过</td>");
					}
					else if(jiatiao.getStatus() == 2){
						writer.print("<td>请假未通过</td>");
					}
					writer.print("</tr>");
				}
				writer.print("</table>");
		%>
		共<%=totalNumber%>个记录，分<%=pageCount%>页显示/当前第<%=pageNum%>页     <%
				for (int j = 1; j <= pageCount; j++) {
					out.print("&nbsp;&nbsp;<a href='?action=search&stuNo="+jiatiao.getStuNo()+"&pageNum=" + j + "'>"+ j + "</a>");
				}
		%>
	</body>
</html>