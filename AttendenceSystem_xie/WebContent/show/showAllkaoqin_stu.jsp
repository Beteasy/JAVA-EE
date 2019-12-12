<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.DBUtils.DBUtils" %>
<%@page import="java.text.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>所有考勤记录</title>
</head>
	<body>
		<%
			Connection conn = null;
			PreparedStatement pre = null;
			ResultSet res = null;
			PrintWriter writer = response.getWriter();
			List<KaoQin> kaoqinList = (ArrayList<KaoQin>)request.getAttribute("kaoqinList");
			int totalNumber = kaoqinList.size();
			int pageSize = 2;
			int pageCount = (totalNumber-1)/pageSize+1;	//计算需要显示多少页
			int pageNum = 1;	//待显示的页面
			int currentPage;
			KaoQin kaoqin = null;
			
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
					+ "<th>年级</th>"
					+ "<th>班级</th>"
					+ "<th>课程</th>"
					+ "<th>打卡时间</th>"
					+ "<th>状态</th>"
					+"</tr>"
					);
				
				for(int i=startIndex; i<startIndex+pageSize && i<totalNumber; i++){
					System.out.print(i);
					kaoqin = kaoqinList.get(i);
					writer.print("<tr>");
					writer.print("<td>"+kaoqin.getStuNo()+"</td>");		
					writer.print("<td>"+kaoqin.getStuName()+"</td>");
					writer.print("<td>"+kaoqin.getGrade()+"</td>");					
					writer.print("<td>"+kaoqin.getClassId()+"</td>");
					try {
						conn = DBUtils.getConnection();
						String sql = "select * from course where courNo="+kaoqin.getCourNo();
						pre = conn.prepareStatement(sql);
						res = pre.executeQuery();
						while (res.next()) {
							writer.print("<td>"+res.getString("courName")+"</td>");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					conn.close();
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");				
					writer.print("<td>"+sf.format(kaoqin.getDate())+"</td>");	
					if(kaoqin.getStatus() == 0){
						writer.print("<td>正常打卡</td>");	
					}
					else if(kaoqin.getStatus() == 1){
						writer.print("<td>迟到</td>");
					}
					else if(kaoqin.getStatus() == 2){
						writer.print("<td>旷课</td>");
					}
					else if(kaoqin.getStatus() == 3){
						writer.print("<td>请假</td>");
					}
					writer.print("</tr>");
				}
				writer.print("</table>");
		%> 
		共<%=totalNumber%>个记录，分<%=pageCount%>页显示/当前第<%=pageNum%>页     <%
			for (int j = 1; j <= pageCount; j++) {
					out.print("&nbsp;&nbsp;<a href='?action=searchallstu&stuNo="+kaoqin.getStuNo()+"&pageNum=" + j + "'>"+ j + "</a>");
				}
		%>
	</body>
</html>