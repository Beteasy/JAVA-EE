<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>信息展示</title>
	</head>
	
	<body>
		<h2>学生信息：(使用"."获取数据)</h2>
		<p>姓名：${student.name}</p>
		<p>学号：${student.id}</p>
		<p>国籍：${student.address.country}</p>
		<p>省份：${student.address.state}</p>
		<p>城市：${student.address.city}</p>
		
		<h2>国家领导人：(使用"."获取数据)</h2>
		<p>主席：${leaders.主席 }</p>
		<p>副主席：${leaders.副主席 }</p>
		<p>总理：${leaders.总理 }</p>
		
		<h2>国家领导人：(使用"[]"获取数据)</h2>
		<p>主席：${leaders["主席"] }</p>
		<p>副主席：${leaders["副主席"] }</p>
		<p>总理：${leaders["总理"] }</p>
		
	</body>
	
</html>