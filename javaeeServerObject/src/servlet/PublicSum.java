package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class PublicSum extends HttpServlet
{
	//声明上下文对象
	ServletContext sc;
	
	public void init()
	{
		//实例化上下文对象
		sc=this.getServletContext();    
	}
	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException{
		int count;									//计数器
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//通过表单中的控件名称获得控件的value值
		String str=request.getParameter("number");   
		int num=Integer.parseInt(str);    			//字符串型转变为整型
		//返回Servlet上下文中count的对象,如没有count的对象，则返回null
		String o=(String)sc.getAttribute("count");
		
		if( o != null ) {   //如果在当前服务器中，曾调用过该应用程序，则有count的对象。
			count=Integer.parseInt(o);
		} else {
			count=0;
		}
		count += num;
		String result = String.valueOf(count);    	//整型转变为字符串型 
		sc.setAttribute("count",result);       		//把result对象的值赋给count对象，即count的值为result的值
		out.println("现在的累加结果是"+count);
	}
	public void destroy(){}
}