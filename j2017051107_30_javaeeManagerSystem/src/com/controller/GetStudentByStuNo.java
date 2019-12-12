package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Student;
import com.service.StuService;

/**
 * Servlet implementation class GetStudentById
 */
@WebServlet("/GetStudentByStuNo")
public class GetStudentByStuNo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetStudentByStuNo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String stuNoString = request.getParameter("stuNo");
		Integer stuNo = Integer.parseInt(stuNoString);
		System.out.println("controller get stuNo:"+stuNo);
		StuService stuService = new StuService();
		Student student = null;
		student = stuService.getStudentByStuNo(stuNo);
		
		System.out.println(student.toString());
		request.setAttribute("student", student);
		request.getRequestDispatcher("show/showStudent.jsp").forward(request, response);
	}

}
