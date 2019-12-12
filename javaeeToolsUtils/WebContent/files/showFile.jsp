<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所读文件的信息</title>
<style>
	#content {
		background:#F00;
		width:400px;
	}
</style>
</head>
<body>
您读的文件位置是：${requestScope.file.filePath }<br />
您读的文件名字是：${requestScope.file.fileName }<br />
您读的文件长度是：${requestScope.file.fileLength }<br />
您读的文件内容是：
<div id="content">${requestScope.file.fileContent }</div> 
</body>
</html>