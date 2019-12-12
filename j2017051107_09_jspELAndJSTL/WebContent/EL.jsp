<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>EL运算符</title>
	</head>
	
	<body>
		<div>
			<h1>比较运算符</h1>
			<p>判断：4 &gt; 3 ；返回值：${4 gt 3}</p>
			<p>判断：4 &lt; 3 ；返回值：${4 lt 3}</p>
			<p>判断：4 &ge; 3 ；返回值：${4 ge 3}</p>
			<p>判断：4 &le; 3 ；返回值：${4 le 3}</p>
			<p>判断：4 = 4    ；返回值：${4 eq 3}</p>
		</div>
		
		<div>
			<h1>Empty 运算符</h1>
			<p>判断：empty " " ；返回值：${empty " " }</p>
			<p>判断：empty "" ；返回值：${empty "" }</p>
			<p>判断：empty " sometext" ；返回值：${empty " sometext" }</p>
		</div>
	</body>
	
</html>