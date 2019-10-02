package com.javaee.request;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * 转发后的Serlvet
 * @author fhzheng
 *
 */
public class ResultServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
        HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = (String) request.getAttribute("username");
		if (username != null) {
			out.println("转发过来的用户名是：" + username + "<br />");
		}
	}
	public void doPost(HttpServletRequest request, 
        HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
}
