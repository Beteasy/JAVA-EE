package servletContextParam;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserServlet extends HttpServlet
{
	ServletContext sc;
	public void init()
	{
		sc=this.getServletContext();
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException
	{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String msg=(String)sc.getAttribute("msg");
                out.println("<h1>"+"发布信息"+"</h1>");
		out.println(msg);
	}
}