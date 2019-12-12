package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.service.UserService;

/**
 * Servlet implementation class InsertUserController
 */
//@WebServlet("/InsertUserController")
public class InsertUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String loginNameString = request.getParameter("loginName");
		String userNameString = request.getParameter("userName");
		String passwordString = request.getParameter("password");
		String sexString = request.getParameter("sex");
		Integer sex = Integer.parseInt(sexString);
		String typeString = request.getParameter("type");
		System.out.println("获取到的type"+typeString);
		Integer type = Integer.parseInt(typeString);
		
		User user = new User();	
		user.setLoginName(loginNameString);
		user.setUserName(userNameString);
		user.setPassword(passwordString);
		user.setSex(sex);
		user.setType(type);
		
		
		UserService userService = new UserService();
		userService.insertUser(user);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("show/showInsertResult.jsp").forward(request, response);
	}

}
