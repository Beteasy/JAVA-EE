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
		address.setCountry("�й�");
		address.setState("�Ĵ�");
		address.setCity("�ɶ�");
		address.setStreetName("����·");
		address.setStreetNumber("110");
		address.setZipcode("111111");
		
		Student student = new Student();
		student.setName("��ͬѧ");
		student.setId("2017051107");
		student.setAddress(address);
//		�����ݷ�װ��request��
		request.setAttribute("student", student);
		
		Map<String, String> leaders = new HashMap<String, String>();
		leaders.put("��ϯ", "ϰ��ƽ");
		leaders.put("����ϯ", "���ɽ");
		leaders.put("����", "���ǿ");
//		�����ݷ�װ��request��
		request.setAttribute("leaders", leaders);
		
//		������ת����showData.jsp������ʾ
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
