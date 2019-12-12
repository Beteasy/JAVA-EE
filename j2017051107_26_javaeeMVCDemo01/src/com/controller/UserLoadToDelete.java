package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.service.UserService;

/**
 * Servlet implementation class UserLoadToDelete
 */
//@WebServlet("/UserLoadToDelete")
public class UserLoadToDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoadToDelete() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 1 调用，处理业务
		String idString = request.getParameter("id");
		Integer id = Integer.parseInt(idString);
		System.out.println(id);
		
		UserService userService = new UserService();
//		List<User> users = new ArrayList<User>();
		User user = null;
//		users = userService.getAllUser();
		user = userService.getUserById(id);
		System.out.println(user.toString());
		// 2 导航,转发,跳转
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("show/showUserToDelete.jsp");
		rd.forward(request, response);
	}

}
