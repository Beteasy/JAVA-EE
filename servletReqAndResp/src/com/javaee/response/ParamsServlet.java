package com.javaee.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取参数
 * 注意中文乱码的处理
 * Servlet implementation class ParamsServlet
 */
public class ParamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParamsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("用户名:" + name);
		out.println("<br />密码:" + password );
		
		// 获取参数名为“hobby”的值，输出到页面
		String[] hobbys = request.getParameterValues("hobby");
		out.print("<br />爱好:");
		if (hobbys == null) {
			out.println("没有爱好.");
		}else {
			for (int i = 0; i < hobbys.length; i++) {
				out.print(hobbys[i] + ", ");
			}
		}
		out.println("<br />");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
