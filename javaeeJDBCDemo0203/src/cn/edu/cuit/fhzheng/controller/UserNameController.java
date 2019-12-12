package cn.edu.cuit.fhzheng.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.edu.cuit.fhzheng.pojo.User;
import cn.edu.cuit.fhzheng.service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/usernamecontroller")
public class UserNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserNameController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 接请求，拿参数
		String userName = request.getParameter("userName");
//		System.out.println(userName);
		//2 调业务方法处理
		UserService userService = new UserService();
		List<User> userList = userService.getUserByName(userName);
//		System.out.println(userList.toString());
		//3 导航跳转
		request.setAttribute("userList", userList);
		RequestDispatcher rd = request.getRequestDispatcher("/showallusers.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
