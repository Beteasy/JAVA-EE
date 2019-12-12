package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username, password;
		username = request.getParameter("username");
		password = request.getParameter("password");
		
//		账号密码正确
		if (username.equals("root") && password.equals("root")) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			
//			创建会话
			HttpSession sess = request.getSession();
//			向会话添加属性
			sess.setAttribute("user", user);
			
//			发送自动登录的cookie
			String autologin = request.getParameter("autologin");
			System.out.println("在LoginServlet中获取到的autoLogin为" + autologin);
			if (autologin != null) {
//				创建自动登录的cookie
//				刚开始这里没注意到，这里需要吧autoLogin改为用户名和密码了，不再是时间了
				Cookie cookie = new Cookie("autologin", username+"-"+password);
//				设置cookie有效期
				cookie.setMaxAge(Integer.parseInt(autologin));
//				设置cookie有效路径
				cookie.setPath(request.getContextPath());
				System.out.println("获取到的路径是"+request.getContextPath());
//				向客户端添加cookie
				response.addCookie(cookie);
			}
//			登录成功，跳转到首页
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		else {
//			用户名或密码错误
			request.setAttribute("errorMsg", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
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
