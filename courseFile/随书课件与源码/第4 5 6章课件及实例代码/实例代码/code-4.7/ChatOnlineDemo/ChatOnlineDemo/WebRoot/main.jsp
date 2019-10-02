<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>龙卷风聊天室</title>
<script type="text/javascript" src="jsFile/Ajax.js"></script>

<script type="text/javascript">
var content;
function send(){
	var con = document.getElementById("content");
	var	content = con.value;
	content = content.replace(/\n/g,"<br>&nbsp&nbsp").replace(/\s/g,"&nbsp&nbsp");
	content = encodeURIComponent(content);
	if(content.length==0){
		alert("内容不能空！");
		con.focus();
	}else{
		ajax({
			url: "sendMassage.do",
			data: "content="+content,
			Success: function(msg){
				eval("result="+msg);
				con.value="";
			}
		});
	}
}

function sendbykey(event){
	//得到当前事件对象
	var event=window.event||event;
	//当按下ctrl+enter时触发
	if(event.ctrlKey&&event.keyCode==13){
	 	send();
	}else if(event.keyCode==13){
	//	var con = document.getElementById("content");
	//	content = content+con.value+"<br>";
	}
}

window.onunload =function(){
	var sure = window.confirm("确定退出聊天室吗！");
	if(sure){
		 exit();
	}else{
		event.returnValue=false;
	}
}

function exit(){
	ajax({
		url: "exit.do",
		data: "",
		Success: function(msg){
			
		}
	});
}
</script>
<style type="text/css">
body{
	background:  #ECF3F6;
	font: 13px normal;
	color: green;
}

table {
	width: 100%;
	height: 100%;
	border: 1px solid #BED6E0;
}

td {border: 1px solid #BED6E0;}

input {width: 60px;border-color: #BED6E0;background-color: #EFF4F7}
</style>
</head>
<body>
	<center>
	<div style="width: 900px;height: 500px">
		<table cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td background="image/b.jpg" height="41" style="border: 0">
						&nbsp;龙卷风聊天室
					</td>
				</tr>
				<tr>
					<td background="image/a.jpg" height="29" align="left">
						&nbsp;欢迎！${sessionScope.username }
					</td>
				</tr>
				<tr style="width: 100%;height: 430px">
					<td style="border: 0" height="430px" width="100%">
						<table cellpadding="0" cellspacing="10" style="border: 0;">
							<tbody>
								<tr >
									<td style="border: 0;">
										<iframe src="chat.jsp" name="chat" width="710px" height="350px">
										</iframe>
									</td>
									<td rowspan="3" style="border: 0;">
										<iframe src="users.jsp" name="users" width="100%" height="505px">
										</iframe>
									</td>
								</tr>
								
								<tr>
									<td align="left">
										<textarea rows="5" id="content" style="width: 710px;height: 100px; border: 0;" onkeydown="sendbykey(event)"></textarea>
										
									</td>
								</tr>
								<tr>
									<td height="30px" align="right" style="border: 0px;">
										按ctrl+Enter发送<input type="button" value="发送" onclick="send()">
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	</center>
</body>
</html>