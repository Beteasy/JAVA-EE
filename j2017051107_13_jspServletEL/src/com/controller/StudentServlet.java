package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Address;
import com.model.Student;

/**
 * Servlet implementation class EmployeeServlet
 */
//@WebServlet("/EmployeeServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StudentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		Address address = new Address();
		address.setCountry("中国");
		address.setState("四川");
		address.setCity("成都");
		address.setStreetName("春熙路");
		address.setStreetNumber("110");
		address.setZipcode("111111");
		
		Student student = new Student();
		student.setName("熊同学");
		student.setId("2017051107");
		student.setAddress(address);
//		将数据封装到request中
		request.setAttribute("student", student);
		
		Map<String, String> leaders = new HashMap<String, String>();
		leaders.put("主席", "习近平");
		leaders.put("副主席", "王岐山");
		leaders.put("总理", "李克强");
//		将数据封装到request中
		request.setAttribute("leaders", leaders);
		
//		将数据转发到showData.jsp进行显示
		request.getRequestDispatcher("showData.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
