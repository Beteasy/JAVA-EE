package com.javaee.request;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 * 获取单个参数值
 * 获取多个参数值，以数组方式组织
 * 
 * @author fhzheng
 *
 */
public class RequestParamsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
        HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		//name=new String(name.getBytes("iso8859-1"),"utf-8");
		System.out.println("用户名:" + name);
		System.out.println("密  码:" + password);
		// 获取参数名为“hobby”的值
		String[] hobbys = request.getParameterValues("hobby");
		System.out.print("爱好:");
		for (int i = 0; i < hobbys.length; i++) {
			System.out.print(hobbys[i] + ", ");
		}
		
		//到别的Servlet处理输出
		RequestDispatcher rd = request.getRequestDispatcher("ParamsServlet");
		rd.forward(request, response);
		//System.out.println("RequestParamsServlet end...");
	}
	public void doPost(HttpServletRequest request,
        HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
}
