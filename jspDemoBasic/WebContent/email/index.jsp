<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮箱检测</title>
<style type="text/css">
	#box {
		width: 320px;
		margin: 0 auto;
		background-color:#eee;
	}
	#email {
		width: 300px;
		margin: 0 15px;
	}
	
	#top {
		background-color:#666;
		height:50px;
		width:300px;
		margin:10px;
	}
	#main {
		background-color:#ddd;
		height:50px;
		width:300px;
		margin:10px;	
	}
	#left {
		background-color:#bbb;
		height:46px;
		width:95px;
		margin:2px;
		float:left;	
	}	
	#center {
		background-color:#bbb;
		height:46px;
		width:95px;
		margin:2px;	
		float:left;
	}	
	#right {
		background-color:#bbb;
		height:46px;
		width:95px;
		margin:2px;	
		float:left;
	}	
	#bottom {
		background-color:#999;
		height:50px;
		width:300px;
		margin:10px;	
	}
	#email {
		background-color:#aaa;
		height:50px;
		width:300px;
		margin:10px;	
	}
</style>

</head>
<body>
<div id="box">
<div id="top">顶</div>
<div id="main">
	<div id="left">左</div>
	<div id="center">中</div>
	<div id="right">右</div>
</div>
<div id="bottom">底</div>
<div id="email">
	<form method="post" id="searchForm" action="result.jsp">
		<fieldset>
			<input type="text" name="email" id="searchText" />
			<input type="submit" value="验证" id="searchSubmit" />
		</fieldset>
	</form>
</div>
</div>
</body>
</html>