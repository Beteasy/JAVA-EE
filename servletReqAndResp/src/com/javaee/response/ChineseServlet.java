package com.javaee.response;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * 输入处理中文乱码
 * 
 * @author fhzheng
 *
 */
public class ChineseServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, 
        HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String data = "JAVAEE应用程序开发";
		PrintWriter out = response.getWriter();
		out.println(data);
	}
	public void doPost(HttpServletRequest request, 
        HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
}
