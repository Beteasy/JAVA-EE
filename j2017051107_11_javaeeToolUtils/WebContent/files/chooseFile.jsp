<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>选择文件</title>
	</head>
	
	<body>
	
		<form action="../FileServlet" method="post">
			文件路径：<input type="text"  name="filePath"><br>
			文件名字：<input type="text"  name="fileName"><br>
			<button type="submit">读取</button>
		</form>

	</body>
	
</html>