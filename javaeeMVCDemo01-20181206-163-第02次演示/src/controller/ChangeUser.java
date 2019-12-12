package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.UserService;

/**
 * Servlet implementation class ChangeUser
 */
@WebServlet({ "/ChangeUser", "/change.do" })
public class ChangeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1 接受请求（包括参数）
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setSex(Integer.parseInt(request.getParameter("sex")));
		user.setIdentityCode(request.getParameter("identityCode"));
		user.setEmail(request.getParameter("email"));
		user.setMobile(request.getParameter("mobile"));
		// 2 调用业务，完成处理，----修改用户
		UserService userService = new UserService();
		userService.changeUser(user);
		// 3  跳转
		//request.getRequestDispatcher("/showUser3").forward(request, response);
		response.sendRedirect("showUser3");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
