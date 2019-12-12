package requestParam;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class OperServlet extends HttpServlet
{
	public void init(){}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException
	{
		//获取请求参数
		String strcount=request.getParameter("count");
		int count = (int)Double.parseDouble(strcount);
		//int count = (int)Integer.parseInt(strcount);
		//进行开根号处理
		count = (int)Math.sqrt(count);
		String str=String.valueOf(count);
		request.setAttribute("count",str); //设置请求上属性的参数
		request.getRequestDispatcher("operTwoServlet").forward(request,response);
	}
}