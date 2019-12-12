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
		
//		�˺�������ȷ
		if (username.equals("root") && password.equals("root")) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			
//			�����Ự
			HttpSession sess = request.getSession();
//			��Ự�������
			sess.setAttribute("user", user);
			
//			�����Զ���¼��cookie
			String autologin = request.getParameter("autologin");
			System.out.println("��LoginServlet�л�ȡ����autoLoginΪ" + autologin);
			if (autologin != null) {
//				�����Զ���¼��cookie
//				�տ�ʼ����ûע�⵽��������Ҫ��autoLogin��Ϊ�û����������ˣ�������ʱ����
				Cookie cookie = new Cookie("autologin", username+"-"+password);
//				����cookie��Ч��
				cookie.setMaxAge(Integer.parseInt(autologin));
//				����cookie��Ч·��
				cookie.setPath(request.getContextPath());
				System.out.println("��ȡ����·����"+request.getContextPath());
//				��ͻ������cookie
				response.addCookie(cookie);
			}
//			��¼�ɹ�����ת����ҳ
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		else {
//			�û������������
			request.setAttribute("errorMsg", "�û������������");
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
