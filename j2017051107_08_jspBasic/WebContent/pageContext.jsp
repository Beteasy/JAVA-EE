<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>pageContext object</title>
	</head>
	
	<body>
		<%
			
		HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
		pageContext.setAttribute("str", "我是pageScope，我是page范围内的属性", pageContext.PAGE_SCOPE);
		req.setAttribute("str", "我是requestScope，我是request范围内的属性");
		String pageScope = (String)pageContext.getAttribute("str", pageContext.PAGE_SCOPE);
		String requestScope = (String)pageContext.getAttribute("str", pageContext.REQUEST_SCOPE);

		%>
		<%="page范围内的属性:" + pageScope + "<br>"%>
		<%="request范围内的属性:" + requestScope + "<br>" %>
	</body>
	
</html>