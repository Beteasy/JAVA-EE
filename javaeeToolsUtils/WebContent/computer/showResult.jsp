<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看四则运算结果</title>
</head>
<body>
运算情况是：<br />
${sessionScope.ok.num1}
${sessionScope.ok.operator }
${sessionScope.ok.num2}=
${sessionScope.ok.result}
<hr />
<form action="/javaeeToolsUtils/ComputerHandle" method="post">
	请输入两个数：<br />
	<input type="text" name="num1" value="0" size=6 /><br />
	<input type="text" name="num2" value="0" size=6 /><br />
	请选择运算符号:<select name="operator" >
		<option value="+">+
		<option value="-">-
		<option value="*">*
		<option value="/">/
		</select><br />
	<input type="submit" value="提交" name="submit" /><br />
</form>
</body>
</html>