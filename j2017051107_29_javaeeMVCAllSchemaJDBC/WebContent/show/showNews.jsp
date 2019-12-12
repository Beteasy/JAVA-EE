<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>显示查询到的新闻</title>
	</head>
	<body>
		<h1>查询到该新闻的详情：</h1>
		新闻ID：${requestScope.news.id }<br>
		新闻标题：${requestScope.news.title }<br>
		新闻内容：${requestScope.news.content }<br>
		发布时间：${requestScope.news.createTime }<br>
	</body>
</html>