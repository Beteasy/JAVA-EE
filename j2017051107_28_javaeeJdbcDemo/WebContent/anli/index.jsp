<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JAVAEE追梦人园地</title>
<style type="text/css">
body {
	background-color: #C4F2E5;
}

#footer {
	font-size: 12px;
}

.STYLE1 {
	font-size: small;
	font-weight: lighter;
	text-decoration: blink;
}

.STYLE2 {
	color: #6633FF;
	font-weight: bold;
}

.STYLE3 {
	font-size: small
}

#wrap {
	margin: 0px auto 10px auto;
	background: #fff;
	padding: 10px;
	border: 5px solid #E6F4FE;
}
</style>
</head>

<body>
	<div align="left" class="STYLE1">
		<div align="center">
			<img src="images/head_jinhua.jpg" width="778" height="177" />
		</div>
	</div>
	<table width="778" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td width="195" valign="top"><table width="195" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="8" height="7"></td>
						<td width="187" height="7"></td>
					</tr>
				</table>
				<table width="195" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="17" valign="top">&nbsp;</td>
						<td width="178" height="67" valign="middle"><img
							src="images/ny_list_001.jpg" alt="" width="188" height="66" /></td>
					</tr>
				</table>
				<table width="195" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="8" height="16"></td>
						<td width="180" height="16"></td>
						<td width="7" height="16"></td>
					</tr>
				</table>
				<table width="195" border="0" cellspacing="0" cellpadding="0">
				</table></td>
			<td width="1"></td>
			<td width="1624" valign="top"><table width="582" border="0"
					align="left" cellpadding="0" cellspacing="0">
					<tr>
						<td width="2" height="200" valign="top" bgcolor="#099690"
							class="ny_list_bg"></td>
						<td colspan="2" rowspan="2" valign="top" bgcolor="#C4F2E5"><table
								width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="100%" colspan="2" bgcolor="#FFFFFF"><img src=""
										width="1" height="6" /></td>
								</tr>
								<tr>
									<th height="25" colspan="2" align="left" bgcolor="#FFFFFF">
										<img src="images/home.jpg" alt="返回首页" name="firstpage"
										width="94" height="32" border="0" /> <img name="second"
										src="images/bt1.jpg" border="0" alt="" /> <img name="third"
										src="images/bt2.jpg" border="0" alt="" /> <img name="forth"
										src="images/bt3.jpg" border="0" alt="" /></th>
								</tr>
							</table>
							<div id="wrap">
								<h2>登录到留言本</h2>
								<hr>
									<form action="/j2017051107_28_javaeeJdbcDemo/UserLoginServlet" name="form1" method="post">
										<table cellspacing=1 cellpadding=0 width=400 id=CommonListArea 	align="center">
											<tr id=CommonListCell height="30">
												<td width="40%" align="right"><b>用户名：</b></td>
												<td><input type="text" size="30" name="account"
													value="" style="WIDTH: 150">
												</td>
											</tr>
											<tr id=CommonListCell height="30">
												<td width="40%" align="right"><b>密&nbsp;&nbsp;&nbsp;码：</b>
												</td>
												<td><input size="30" type="password" name="pwd"
													style="WIDTH: 150">
												</td>
											</tr>
											<tr id=CommonListCell height="30">
												<td align="center" colspan="2"><input type="submit" value=" 登录 "> <input type="button" value=" 取消 ">
												</td>
											</tr>
										</table>
									</form>
							</div></td>
						<td width="1" rowspan="2" valign="top" bgcolor="#099690"></td>
					</tr>
					<tr>
						<td width="2" height="95" valign="top" bgcolor="#099690"><img
							src="/images/zw/ny_0122.jpg" width="2" height="1" /></td>
					</tr>
				</table>
				<div align="center"></div></td>
		</tr>
		<tr>
			<td colspan="3" valign="top"></td>
		</tr>
	</table>
	<br />
<table width="778" border="0" align="center" cellpadding="0"
		cellspacing="0" id="footer">
		<tr>
			<td align="center"><p>
					<a href="#">关于我们</a> | <a
						href="#">免责声明</a> | <a
						href="#">广告合作</a> | <a
						href="#">知识产权</a> | <a
						href="#">支付方式</a> | <a
						href="#">联系方式</a> | <a
						href="#">加入我们</a><br /> <em>Copyrights
						Reserved 2018-2018</em> JAVAEE课程(<em>www.cuit.edu.cn</em>) <br /> <em>成信ICP备20181111001号</em><br />
				</p>
			</td>
		</tr>
	</table>
</body>
</html>