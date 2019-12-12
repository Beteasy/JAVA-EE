<%@page import="java.util.Date"%>
<%@page import="com.bean.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!-- 创建javaBean -->    
<jsp:useBean id="article" class="com.bean.Article"></jsp:useBean>
<!-- 设置JavaBean中属性的属性值 -->
<jsp:setProperty property="id" name="article" value="01"/>
<jsp:setProperty property="title" name="article" value="Java EE 程序设计教程"/>
<jsp:setProperty property="author" name="article" value="陈丁"/>  
    
    
    
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	
	<body>
		<!-- 引入header.jsp -->
		<%@ include file="header.jsp" %><br>
		
		<div>
			<!-- 显示时间 -->
			<%
				Date date;
				int year;
				int month;
				int today;
				int day;
				date = new Date();
				year = date.getYear() + 1900;
				month = date.getMonth() + 1;
				today = date.getDate();
				day = date.getDay();
				out.println("现在是：" + year + "年" 
									+ month + "月" 
									+ today + "日；" 
									+ "星期" + day);
				
			%>
		</div>
		
		<div style="margin:20px">
			<!-- 使用javaBean -->
			使用javaBean示例：<br>
			<div>
			<!-- 获取javaBean的属性。并显示到页面 -->
				书       名：<jsp:getProperty property="title" name="article"/><br>
				图书编号：<jsp:getProperty property="id" name="article"/><br>
				图书作者：<jsp:getProperty property="author" name="article"/><br>
			</div>
		</div>
		
	
		<div style="padding:20px">
			使用java代码块示例：<br>
			<%
				Article artic = new Article();
				artic.setId(02);
				artic.setTitle("计算机操作系统");
				artic.setAuthor("张海潘");
			%>
			<div >
				书       名：<%=artic.getTitle() %><br>
				图书编号:  <%=artic.getId() %><br>
				图书作者：<%=artic.getAuthor() %><br>
			</div>
		</div>
		
		
		<!-- 引入footer.jsp -->
		<%@ include file="footer.jsp" %>
	</body>
	
</html>