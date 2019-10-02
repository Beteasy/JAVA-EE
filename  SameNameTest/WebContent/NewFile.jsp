<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
请您输入自己的信息进行注册  
    <form action="multiNameForm_result.jsp" method="post"> 
        请您输入您的电话号码(最多4个)：<BR> 
        <%for(int i=1;i<=4;i++){ %> 
            号码<%=i %>：<input name="phone" type="text"><BR> 
        <%} %> 
        <input type="submit" value="注册"> 
    </form> 
 
 
</body>
</html>