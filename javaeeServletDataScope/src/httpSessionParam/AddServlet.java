package httpSessionParam;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AddServlet extends HttpServlet
{
	public void init(){}
	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();				//创建session
		String product=(String)request.getParameter("product");
		String shopping=(String)session.getAttribute("shopping");
        String newproduct=new String(product.getBytes(),"utf-8");
		if(shopping==null)
		{
			session.setAttribute("shopping",newproduct); 		//设置属性参数值
		}
		else
		{
			String str=shopping+"<br>"+newproduct;
			session.setAttribute("shopping",str);
		}
		out.println("产品已添加至购物车中！");
	}
}