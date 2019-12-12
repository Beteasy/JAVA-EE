<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="com.entity.News"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询到的符合条件的新闻</title>
	</head>
	<body>
		<%
			PrintWriter writer = response.getWriter();
			List<News> newsList = (ArrayList<News>)request.getAttribute("newsList");
			writer.print(
				"<table border='1' width='100%' style='table-layer:fixed'>"
				+"<tr>"
				+ "<th>id</th>"
				+ "<th>title</th>"
				+ "<th>content</th>"
				+ "<th>createTime</th>"
				+"</tr>"
				);
			Iterator iterator = newsList.iterator();
			while(iterator.hasNext()){
				News tempNews = (News)iterator.next();
				writer.print("<tr>");
				writer.print("<td>"+tempNews.getId()+"</td>");		
				writer.print("<td>"+tempNews.getTitle()+"</td>");		
				writer.print("<td style='word-break:break-all'>"+tempNews.getContent()+"</td>");		
				writer.print("<td>"+tempNews.getCreateTime()+"</td>");		
				writer.print("</tr>");
			}
			writer.print("</table>");
			
		%>
	</body>
</html>