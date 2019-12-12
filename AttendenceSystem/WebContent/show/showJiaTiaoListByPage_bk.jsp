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
	<title>请假管理</title>
	</head>
	<body>
		<%
			PrintWriter writer = response.getWriter();
			List<JiaTiao> jiaTiaoList = (ArrayList<JiaTiao>)request.getAttribute("jiaTiaoList");
			//System.out.print(jiaTiaoList.size());
			int jiaTiaoNumber = jiaTiaoList.size();	//假条的总数
			int pageSize = 3;	//每页显示3个
			int pageCount = (jiaTiaoNumber-1)/pageSize+1;	//计算需要显示多少页
			int pageNum = 1;	//待显示的页面
			int currentPage;
			JiaTiao jiaTiao = null;
			
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
					+ "<th>编号</th>"
					+ "<th>学号</th>"
					+ "<th>姓名</th>"
					+ "<th>年级</th>"
					+ "<th>班级</th>"
					+ "<th>课程</th>"
					+ "<th>类型</th>"
					+ "<th>开始时间</th>"
					+ "<th>结束时间</th>"
					+ "<th>状态</th>"
					+ "<th>操作</th>"
					+"</tr>"
					);
				
				for(int i=startIndex; i<startIndex+pageSize && i<jiaTiaoNumber; i++){
					System.out.print(i);
					jiaTiao = jiaTiaoList.get(i);
					
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
					
					
					writer.print("<tr>");
					writer.print("<td>"+jiaTiao.getId()+"</td>");
					writer.print("<td>"+jiaTiao.getStuNo()+"</td>");		
					writer.print("<td>"+jiaTiao.getStuName()+"</td>");
					writer.print("<td>"+jiaTiao.getGrade()+"</td>");
					writer.print("<td>"+jiaTiao.getClassId()+"</td>");
					writer.print("<td>"+jiaTiao.getCourNo()+"</td>");
					writer.print("<td>"+type+"</td>");
					writer.print("<td>"+jiaTiao.getStartdate()+"</td>");
					writer.print("<td>"+jiaTiao.getEnddate()+"</td>");
					writer.print("<td>"+status+"</td>");
					writer.print("<td><a href='/AttendenceSystem/show/jiaTiaoDetail.jsp?id="+jiaTiao.getId()+"'>查看</a></td>");
					writer.print("</tr>");
				}
				writer.print("</table>");
		%>
		共<%=jiaTiaoNumber%>个记录，分<%=pageCount%>页显示/当前第<%=pageNum%>页     <%
				for (int j = 1; j <= pageCount; j++) {
					out.print("&nbsp;&nbsp;<a href='?pageNum=" + j + "'>"
										+ j + "</a>");
							}
		%>
	</body>
</html>