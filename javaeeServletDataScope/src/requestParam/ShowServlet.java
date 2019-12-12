package requestParam;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ShowServlet extends HttpServlet
{
	public void init(){}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException
	{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//获取请求属性上的参数
		String strcount=(String)request.getAttribute("count");
		out.println(strcount);
	}
}