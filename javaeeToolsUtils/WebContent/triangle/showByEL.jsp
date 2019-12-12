<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用EL查看三角形处理结果</title>
</head>
<body>
三角形的三条边是：<br />
A:${requestScope.triangle.sideA}<br />
B:${requestScope.triangle.sideB}<br />
C:${requestScope.triangle.sideC}<br />
能构成三角形吗？${requestScope.triangle.isTriangle}<br />
Area:${requestScope.triangle.area}<br />
</body>
</html>