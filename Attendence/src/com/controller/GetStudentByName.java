//package com.controller;
//
//import java.io.IOException;
//import java.util.*;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.entity.Student;
//import com.service.StuService;
//
///**
// * Servlet implementation class GetStudentByName
// */
//@WebServlet("/GetStudentByName")
//public class GetStudentByName extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    /**
//     * Default constructor. 
//     */
//    public GetStudentByName() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
//		doPost(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		doGet(request, response);
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("textml;charset=utf-8");
//		
//		String stuName = request.getParameter("stuName");
//		System.out.println("controller get stuNo:"+stuName);
//		StuService stuService = new StuService();
////		Student student = null;
//		List<Student> studentList = new ArrayList<Student>();
//		studentList = stuService.getStudentByName(stuName);
//		
//		System.out.println(studentList.toString());
//		request.setAttribute("studentList",studentList);
//		request.getRequestDispatcher("show/showStudents.jsp").forward(request, response);
//	}
//
//}
