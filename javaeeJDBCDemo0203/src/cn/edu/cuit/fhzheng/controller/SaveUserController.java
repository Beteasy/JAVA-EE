package cn.edu.cuit.fhzheng.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cuit.fhzheng.pojo.User;
import cn.edu.cuit.fhzheng.service.UserService;

/**
 * Servlet implementation class SaveUserController
 */
@WebServlet("/saveusercontroller")
public class SaveUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 中文乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 接请求，未做数据验证处理
		String loginName = request.getParameter("loginName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String sexStr = request.getParameter("sex");
		Integer sex = Integer.parseInt(sexStr);
		String identityCode = request.getParameter("identityCode");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String typeStr = request.getParameter("type");
		Integer type = Integer.parseInt(typeStr);
		// 封装成user
		User user = new User();
		user.setLoginName(loginName);
		user.setUserName(userName);
		user.setPassword(password);
		user.setSex(sex);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setType(type);
		user.setIdentityCode(identityCode);
		// 调业务，进行入库操作
		UserService userService = new UserService();
		userService.saveUser(user);
		// 跳转---更新操作，建议用重定向跳转
//		request.getRequestDispatcher("/userallcontroller").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/userallcontroller");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
