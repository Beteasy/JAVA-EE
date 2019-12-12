package cn.edu.cuit.fhzheng.controller;

import java.io.IOException;

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
@WebServlet("/usercontroller")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 接请求，拿参数
		String idString = request.getParameter("id");
		Integer id = Integer.parseInt(idString);
		
		//2 调业务方法处理
		UserService userService = new UserService();
		User user = userService.getUserById(id);
		
		//3 导航跳转
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/showuser.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
