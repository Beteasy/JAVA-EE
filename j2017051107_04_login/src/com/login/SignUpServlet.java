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
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String username, password;
	String uname, pwd;
	DBMethod DBM = null;
    User user = null;
    int flag = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		flag = DBM.insert(user);
		
		if (flag == 0) {
			PrintWriter writer = response.getWriter();
			writer.println("×¢²áÊ§°Ü<br>Çë<a href='signUp.html'>ÖØÐÂ×¢²á");
		}
		else {
			PrintWriter writer = response.getWriter();
			writer.println("×¢²á³É¹¦<br><a href='login.html'>Á¢¼´µÇÂ¼");
		}
	}

}
