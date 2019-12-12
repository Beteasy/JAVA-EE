<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
	<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> -->
	<title>Employee</title>
</head>
<body>
	语言accept-language: ${header['accept-language']}
	<br/>
	会话编号session id: ${pageContext.session.id}
	<br/>
	雇员信息employee: 
	&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.employee.name},<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;${employee.address.country},<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;${employee.address.state},<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;${employee.address.city},<br/>
	
	<br/><hr/>
	首都信息<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;capital: ${capitals["中国"]},<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;capital: ${capitals["加拿小"]},<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;capital: ${capitals["奥地利"]},<br/>
	&nbsp;&nbsp;&nbsp;&nbsp;capital: ${capitals["奥小利亚"]},<br/>
</body>
</html>