package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String username, password;
	String url = "jdbc:mysql://localhost:3306/servlet?serverTimezone=UTC";
	String DBUsername = "root";
	String DBPassword = "root";
	String uname, pwd;
	DBMethod DBM = null;
	User user = null;
//	String searchSQL = "select * from users where username=?";
       
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		username = request.getParameter("username");
		password = request.getParameter("password");
		user = new User();
		user.setUserName(username);
		user.setPassword(password);
		
		DBM = new DBMethod();
		pwd = DBM.search(user);
		
		if (password.equals(pwd)) {
			response.sendRedirect("welcome.html");
		}
		else {
			PrintWriter writer = response.getWriter();
			writer.println("µÇÂ¼Ê§°Ü<br>Çë<a href='login.html'>ÖØÐÂµÇÂ¼");
		}
	}
}
