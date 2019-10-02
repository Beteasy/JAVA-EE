<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%  
        //String[] phone = request.getParameterValues("phone");  
    	String phone = request.getParameter("phone");
    	out.println("号码为:");  
    	out.print(phone);
        //for(int i=0;i<phone.length;i++){  
           // out.println(phone[i]);  
        //}  
    %> 
</body>
</html>