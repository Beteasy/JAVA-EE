<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javaee.bean.Triangle" %>
<jsp:useBean id="triangle" class="com.javaee.bean.Triangle" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看三角形处理结果</title>
</head>
<body>
三角形的三条边是：<br />
边A：<jsp:getProperty name="triangle" property="sideA" /><br />
边B：<jsp:getProperty name="triangle" property="sideB" /><br />
边C：<jsp:getProperty name="triangle" property="sideC" /><br />
它们能构成一个三角形吗？<br />
<jsp:getProperty name="triangle" property="isTriangle" /><br />
面积是：
<jsp:getProperty name="triangle" property="area" /><br />
</body>
</html>