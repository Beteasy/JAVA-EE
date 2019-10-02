package com.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamsServlet
 * 获取从RequestParamsServlet中传过来的参数
 */
@WebServlet("/ParamsServlet")
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
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		获取从RequestParamsServlet中传过来的username和password
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		获取response输出对象，将username和password输出到浏览器页面
		PrintWriter writer = response.getWriter();
		writer.println("用户名 = " + username + "<br>");
		writer.println("密码  = " + password + "<br>");
		
//		获取同名不同值的参数(hobbies)
//		返回类型为字符串数组
		String[] hobbies = request.getParameterValues("hobbies");
		writer.println("爱好:<br>");
		if(hobbies != null) {
			for (String hobby : hobbies) {
				writer.println(hobby + "<br>");
			}
		}
		else {
			writer.println("最大的爱好就是，没有爱好！");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
