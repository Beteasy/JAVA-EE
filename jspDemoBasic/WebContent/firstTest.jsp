<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="bean.Article" %>


<jsp:useBean id="article" class="bean.Article"></jsp:useBean>
<jsp:setProperty property="id" name="article" value="25" />
<jsp:setProperty property="title" name="article" value="JAVAEE教学指导" />
<jsp:setProperty property="author" name="article" value="郑十一" />

<!DOCTYPE html 
	PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>第一个JSP页面</title>
</head>
<body>
<%@include file="header.jsp" %><br />
<%
/* 输出年月日星期 */
java.util.Date dt = new java.util.Date();
int year = dt.getYear();
year += 1900;
int month = dt.getMonth();
month += 1;
int date = dt.getDate();
int day = dt.getDay();

String strYear = String.valueOf(year);
String strMonth = String.valueOf(month);
String strDate = String.valueOf(date);
String strDay = String.valueOf(day);

out.print("现在时间是："+strYear+"年");
out.print(strMonth+"月");
out.print(strDate+"日");
out.println("星期"+strDay);

%>

<%
out.println("<br />");
out.println("现在的时间是：");
Date myDate = new Date();
out.println(myDate.toLocaleString());
%>

<hr />
Bean的使用<br />
<p>
编号：<jsp:getProperty property="id" name="article" /><br />
书名：<jsp:getProperty property="title" name="article" /><br />
作者：<jsp:getProperty property="author" name="article" /><br />
</p>
<%
Article article1=new Article();
article1.setId(50);
article1.setTitle("JAVAEE上机实验指导");
article1.setAuthor("郑国庆");
%>
<p>
编号1：<%=article1.getId() %><br />
书名1：<%=article1.getTitle() %><br />
作者1：<%=article1.getAuthor() %><br />
</p>
<br />
<%@include file="footer.jsp" %>
</body>
</html>