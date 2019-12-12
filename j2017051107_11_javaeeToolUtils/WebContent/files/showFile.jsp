<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>展示文件信息</title>
	</head>
	
	<body>
		读取的文件名：${requestScope.myFile.fileName }<br>
		读取的文件路径：${requestScope.myFile.filePath }<br>
		读取的文件内容：${requestScope.myFile.fileContent }<br>
		读取的文件长度：${requestScope.myFile.fileLength }<br>
	</body>
	
</html>