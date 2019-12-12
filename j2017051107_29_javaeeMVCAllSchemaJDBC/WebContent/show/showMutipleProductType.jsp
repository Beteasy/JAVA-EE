<%@page import="com.entity.ProductType"%>
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
		<title>所有的产品类型</title>
	</head>
	<body>
		<%
			PrintWriter writer = response.getWriter();
			List<ProductType> productTypeList = (ArrayList<ProductType>)request.getAttribute("productTypeList");
			writer.print(
				"<table border='1' width='100%' style='table-layer:fixed'>"
				+"<tr>"
				+ "<th>id</th>"
				+ "<th>name</th>"
				+"</tr>"
				);
			Iterator iterator = productTypeList.iterator();
			while(iterator.hasNext()){
				ProductType productType = (ProductType)iterator.next();
				writer.print("<tr>");
				writer.print("<td>"+productType.getId()+"</td>");		
				writer.print("<td>"+productType.getName()+"</td>");			
				writer.print("</tr>");
			}
			writer.print("</table>");
			
		%>
	</body>
</html>