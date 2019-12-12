<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 
	这里，bean的作用域是request
		它除了有page域，还有<jsp:forward>和<jsp:include>包含的页面
		所有通过上面两个动作连接在一起的JSP程序都可以共享request域的javaBean
	这样的方式，使得用javaBean在JSP程序之间传递信息更为容易
	但不能用于从客户端到服务器端之间传递数据
		因为客户端没有办法执行JSP程序和创建新的JavaBean对象 
--%>
<jsp:useBean id="myBean" class="bean.MyBean" scope="request"></jsp:useBean>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<LINK href="css/login.css" type=text/css rel=stylesheet>

  </head>
  
<BODY>
<DIV id=Header>
<DIV id=logo title=用户管理登录>用户管理登录</DIV>
<UL id=menu>
  <LI><A href="http://www.cuit.edu.cn">首页</A>&nbsp;|&nbsp; <A 
  href="http://www.cuit.edu.cn">注册</A> </LI></UL></DIV>
<DIV id=Container>
<DIV id=PageBody>
<DIV class=Sidebar>
<FORM name="form1" action="login2.jsp" method="post">
<UL>
				<%
					if (request.getParameter("name") != null) {
				%>
						<jsp:setProperty property="*" name="myBean" />
						【<jsp:getProperty property="name" name="myBean" />】
						用户已登录
						<jsp:getProperty property="count" name="myBean" />次
				<%
					}
				%>
  <LI><LABEL>用户名：<INPUT id=UserName onblur="this.className='input_onBlur'" 
  onfocus="this.className='input_onFocus'" name="name"><INPUT id=act 
  type=hidden value=cool name=act> </LABEL>
  <LI><LABEL>密　码：<INPUT id=Password onblur="this.className='input_onBlur'" 
  onfocus="this.className='input_onFocus'" type=password name="pass"></LABEL> 
  </LABEL>
  <LI class=CookieDate><LABEL for=CookieDate><INPUT id=CookieDate type=checkbox 
  value=3 name=CookieDate>保存我的登录信息</LABEL> 
  <LI><INPUT type=hidden name=fromurl><INPUT id=Submit onclick="return CheckForm();" type=submit value=登　录 name=Submit><A 
  href="http://www.cuit.edu.cn">忘记密码？</A> 
  
  <%--
  	这里，对success.jsp的包含
  	意味着这个页的myBean数据会共享给success.jsp页
  	而success.jsp中也有创建bean的动作，这将会使得计数据加1
  	但再一次刷新时，该页不会再创建新的bean,而且刷新会使得request完成两页之间的数据共享
  	关闭浏览器，再打开时，可以观察数据的变化
   --%>
  <Li><jsp:include page="success.jsp" flush="true"/></Li>
  
  
  <LI class=hr>
  <LI>如果你不是本站会员，请注册 
  <LI class=regbt><A href="http://www.cuit.edu.cn"><IMG 
  src="css/reg.jpg"></A> </LI></UL></FORM>
<UL class=help>
  <LI>如果你密码丢失或原有用户名登录不了，请试试<A 
  href="http://www.cuit.edu.cn">找回密码</A>。 
  <LI>当你看不清验证码时请点验证码图片刷新。 </LI></UL></DIV>
<DIV class=MainBody>
<DIV class=ad>稳定的平台，完善的功能，满意的服务，和谐的环境。</DIV>
<DL class=d1>
  <DT>发布网络文章 
  <DD>在网络中用文字记录您的日常生活 </DD></DL>
<DL class=d2>
  <DT>共享您的照片 
  <DD>保存和共享您的照片，用光和影展现您的生活 </DD></DL>
<DL class=d3>
  <DT>展示个性的您 
  <DD>您可自由设置空间，展示一个独一无二的自我 </DD></DL></DIV>
<DIV class=clear></DIV></DIV>
<DIV class=clear></DIV></DIV>
<DIV id=Footer>
<CENTER>Copyright by JAVAEE<BR></CENTER></DIV>
<SCRIPT language=javascript>

function CheckForm()
{ 
var form=document.form1;
   if (form.UserName.value=='')
    { alert("请输入用户名!");   
	  form.UserName.focus();    
	   return false;
    }
    if (form.PassWord.value=='')  
	  { alert("请输入密码!");   
	    form.PassWord.focus();   
		  return false;   
		 }  
	 
	    form.Submit.value="登　录";
		form.Submit.disabled=true;	
	    form.submit();
        return true;
}

</SCRIPT>
</BODY>
</html>
