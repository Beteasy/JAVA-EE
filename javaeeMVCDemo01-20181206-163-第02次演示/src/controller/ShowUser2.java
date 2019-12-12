package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.UserService;

/**
 * Servlet implementation class ShowUser
 */
@WebServlet("/showUser2")
public class ShowUser2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUser2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 1 接受请求
		String userName = request.getParameter("name");
//		System.out.println(userName);
		// 2 调用，处理业务
		UserService userService = new UserService();
		List<User> userList = new ArrayList<User>();
		userList = userService.findUserbyName(userName);
//		for (User user2 : userList) {
//			System.out.println(user2.toString());
//		}
		//导航,转发,跳转
		request.setAttribute("userList", userList);
		RequestDispatcher rd = request.getRequestDispatcher("show/show2.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
