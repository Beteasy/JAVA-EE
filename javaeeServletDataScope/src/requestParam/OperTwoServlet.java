package requestParam;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class OperTwoServlet extends HttpServlet
{
	public void init(){}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException
	{
		//获取请求属性上的参数
		String strcount=(String)request.getAttribute("count");
		int count=Integer.parseInt(strcount);
		//进行乘10处理
		count *= 10;
		//再次置入请求属性的参数
		request.setAttribute("count",String.valueOf(count));
		request.getRequestDispatcher("showServlet").forward(request,response);
	}
}