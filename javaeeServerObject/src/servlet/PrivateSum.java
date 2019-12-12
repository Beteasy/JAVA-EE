package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class PrivateSum extends HttpServlet
{
	public void init(){}
	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException{
		int count;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String str=request.getParameter("number");     	//通过表单中的控件名称获得控件的value值
		int num=Integer.parseInt(str);
		HttpSession session=request.getSession();   	//创建对象
		String o=(String)session.getAttribute("count"); //返回由count指定的会话属性
		if ( o != null ) {
			count=Integer.parseInt(o);
		} else {
			count=0;
		}
		count+=num;
		String result=String.valueOf(count);
		session.setAttribute("count",result);
		out.println("现在的累加结果是"+count);
	}
	public void destroy(){}
}