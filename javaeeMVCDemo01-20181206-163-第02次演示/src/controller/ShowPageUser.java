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

import entity.PageVO;
import entity.User;
import service.UserService;

/**
 * Servlet implementation class ShowUser
 */
@WebServlet("/showPageUser")
public class ShowPageUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPageUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1 分页初始设置
		int recordOfPage = 6;
		int page = 1;
		if (request.getParameter("page") != null) {
			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (Exception e) {
				e.printStackTrace();
				page = 1;
			}
		}
		UserService userService = new UserService();
		PageVO<User> pageVO = new PageVO<User>();
		pageVO = userService.search(page, recordOfPage);
		List<User> userList = new ArrayList<User>();
		userList = pageVO.getList();
		// 3 导航,转发,跳转
		request.setAttribute("pageVO", pageVO);
		request.setAttribute("userList", userList);
		RequestDispatcher rd = request.getRequestDispatcher("show/show5.jsp");
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
