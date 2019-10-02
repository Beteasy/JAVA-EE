<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jsFile/Ajax.js"></script>

<script type="text/javascript">
function login(){
	var name = document.getElementById("name").value;
	if(name.length==0){
		document.getElementById("sp").innerText="用户名不能为空！";
	}else{
		ajax({
			data: "name="+name,
			url: "login.do",
			Success: function(msg){
				eval("res="+msg);
				var result = res.massage;
				if(typeof result=="undefined"){
					window.location.href="main.jsp";
				}else{
					document.getElementById("sp").innerText=result;
				}
			}
		});
	}
}
</script>
</head>
<body>
		姓名：<input type="text" id="name"><span id="sp"></span><br>
		<input type="button" value="登陆" onclick="login()"><font color=""></font>
</body>
</html>