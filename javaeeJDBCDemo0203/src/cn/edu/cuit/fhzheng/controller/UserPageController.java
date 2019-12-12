package cn.edu.cuit.fhzheng.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cuit.fhzheng.pojo.User;
import cn.edu.cuit.fhzheng.service.UserService;

/**
 * Servlet implementation class UserAllController
 */
@WebServlet("/userpagecontroller")
public class UserPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageString= request.getParameter("page");
		Integer page = Integer.parseInt(pageString);
		UserService userService = new UserService();
		List<User> userList = userService.getPageUsers(page);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/showallusers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
