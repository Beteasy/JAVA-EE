package httpSessionParam;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ShoppingServlet extends HttpServlet
{
	public void init(){}
	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(); 					//创建session
		String shopping=(String)session.getAttribute("shopping");	//获取属性值 
       
		if( shopping==null ) {
			out.println("<h1>购物车为空！</h1>");
		} else {
			out.println("<h1>购物车</h1><br>"+shopping);
		}

	}
}