package com.javaee.request;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * 转发前的Servlet
 * @author fhzheng
 *
 */
public class RequestForwardServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
        HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("username", "周星星");
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ResultServlet");
		dispatcher.forward(request, response);
	}
	public void doPost(HttpServletRequest request,
        HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
}
