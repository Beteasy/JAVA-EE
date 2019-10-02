package com.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestParamsServelt
 */
@WebServlet("/RequestParamsServelt")
public class RequestParamsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestParamsServelt() {
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
//		获取从form.html中传过来的username和password
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("用户名 = " + username);
		System.out.println("密码 = " + password);
		
//		获取同名不同值的参数(hobbies)
//		返回类型为字符串数组
		String[] hobbies = request.getParameterValues("hobbies");
		System.out.println("爱好:");
		if(hobbies != null) {
			for (String hobby : hobbies) {
				System.out.println(hobby);
			}
		}
		else {
			System.out.println("no hobby!");
		}
		
//		通过forward转发到com.response包下的ParamsServlet——绝对路径
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ParamsServlet");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
