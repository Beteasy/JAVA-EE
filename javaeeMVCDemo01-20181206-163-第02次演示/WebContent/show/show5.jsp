<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>分页-综合操作用户</title>
<script type="text/javascript">

//跳到某页
function go(){
	document.goForm.submit();
}
//分页控制
function doPage(p){
	document.searchForm.page.value = p;
	document.searchForm.submit();
}

//单个安全删除提示
function isDel(id){
	if(confirm("是否确认删除？")){
		location.href="${pageContext.request.contextPath}/delete.do?id="+id;
	}
}
//批量安全删除提示
function isDels(){
	if(confirm("是否确认删除？")){
		document.deletesForm.submit();
	}
}
//执行批量删除时，选中的id集
function checkAll(obj){
	var ids = document.getElementsByName("ids");
	for(var i = 0 ;i <ids.length;i++){
		ids[i].checked = obj.checked;
	}
}
</script>
</head>
<body>
<div style="color:#F00; font-size:18px;">
<!-- 多条件查询 -->
<form name="searchForm" action="${pageContext.request.contextPath }/showPageUser" method="post" >
	<input type="hidden" name="page" value="1" />
	<!-- 未处理的多查询条件组织 -->
	<input type="submit" value="分页" />
</form>
<form name="searchIdForm" action="${pageContext.request.contextPath }/showUser1" method="post" >
	请输入用户ID号：<input type="text" name="id" /><input type="submit" value="提交" />
</form>
<form name="searchNameForm" action="${pageContext.request.contextPath }/showUser2" method="post" >
	请输入用户名：<input type="text" name="name" /><input type="submit" value="提交" />
</form>
<!-- 多条件查询 end-->
<!-- 批量删除操作 -->
<form name="deletesForm" action="${pageContext.request.contextPath }/dels.do" method="post" >
<div align="left"><input type="checkbox" name="checkall" id="checkall" onclick="checkAll(this)" />全选</div>
<div align="center">
	<A href="${pageContext.request.contextPath}/input/inputUser.jsp">新增用户</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<A href="javascript:isDels()">批量删除</a>
</div>
<table border="1px" width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<th>选择</th><th>用户ID号</th><th>用户登录名</th><th>用户名</th><th>用户密码</th>
<th>用户性别</th><th>用户身份证号</th><th>用户邮箱</th><th>用户手机号</th><th>用户类型</th>
<th>操作</th>
</tr>
<c:forEach var="user" items="${requestScope.userList }" varStatus="status" >
<tr>
	<td><input type="checkbox" name="ids" value="${user.id }"/>&nbsp;&nbsp;${status.count}</td>
	<td>${user.id }</td>
	<td>${user.loginName }</td>
	<td>${user.userName }</td>
	<td>${user.password }</td>
	<td>${user.sex }</td>
	<td>${user.identityCode }</td>
	<td>${user.email }</td>
	<td>${user.mobile }</td>
	<td>${user.type }</td>
	<td>
		<a href="${pageContext.request.contextPath}/userloadtochange.do?id=${user.id }">修改</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<!-- 注意，删除不会让用户轻易地完成操作，要防止用户的误操作 -->
		<a href="javascript:isDel(${user.id })">删除</a>
		<!-- 注意，删除不会让用户轻易地完成操作，要防止用户的误操作 end-->
	</td>
</tr>	
</c:forEach>
</table>
</form>
<!-- 批量删除操作 end-->

<!-- 分页控制 -->
<table>
	<tr>
	<td>共有${requestScope.pageVO.recordCount}条记录，当前第${requestScope.pageVO.page }/${requestScope.pageVO.pageCount }页</td>
	<td>
		<table>
		<tr>
		
		<td width="45">		<!-- 首页 -->
			<c:choose>
				<c:when test="${1 eq requestScope.pageVO.page }">
					<img src = "images/first.gif" width="37" height="18" />
				</c:when>
				<c:otherwise>
					<a href="javascript:doPage(1)"><img src = "images/first.gif" width="37" height="18" /></a>
				</c:otherwise>
			</c:choose>
		</td>				<!-- 首页 end-->
		
		<td width="45">		<!-- 上一页 -->
			<c:choose>
				<c:when test="${requestScope.pageVO.page eq 1 }">
					<img src = "images/back.gif" width="37" height="18" />
				</c:when>
				<c:otherwise>
					<a href="javascript:doPage(${requestScope.pageVO.page - 1 })"><img src = "images/back.gif" width="37" height="18" /></a>
				</c:otherwise>
			</c:choose>
		</td>				<!-- 上一页 end-->
		
		<td width="45">		<!-- 下一页 -->
			<c:choose>
				<c:when test="${requestScope.pageVO.page eq requestScope.pageVO.pageCount }">
					<img src = "images/next.gif" width="37" height="18" />
				</c:when>
				<c:otherwise>
					<a href="javascript:doPage(${requestScope.pageVO.page + 1 })"><img src = "images/next.gif" width="37" height="18" /></a>
				</c:otherwise>
			</c:choose>
		</td>				<!-- 下一页 end-->
		
		<td width="45">		<!-- 尾页 -->
			<c:choose>
				<c:when test="${requestScope.pageVO.page eq requestScope.pageVO.pageCount }">
					<img src = "images/last.gif" width="37" height="18" />
				</c:when>
				<c:otherwise>
					<a href="javascript:doPage(${requestScope.pageVO.pageCount})"><img src = "images/last.gif" width="37" height="18" /></a>
				</c:otherwise>
			</c:choose>
		</td>				<!-- 尾页 end-->

		<td width="100">		<!-- 转到某页 -->
		<form name="goForm" action="${pageContext.request.contextPath }/showPageUser" method="post">
			<span>到第<input name="page" type="text" size="4" style="height:18px;width:20px;border:1px solid #999999;"/>页 </span>
		</form>
		</td>				
		<td width="40">		<!-- 转到某页 -->
			<a href="javascript:go()" >
			<img src="images/go.gif" width="37" height="18" /></a>
		</td>				<!-- 转到某页 end-->			

		</tr>
		</table>
	</td>
	</tr>
</table>
<!-- 分页控制 end-->
</div>
</body>
</html>