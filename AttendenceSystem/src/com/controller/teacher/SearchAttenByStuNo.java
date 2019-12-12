package com.controller.teacher;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoImpl.TeacherDaoImpl;
import com.entity.KaoQin;
import com.service.TeacherService;

/**
 * Servlet implementation class SearchAttenByGradeController
 */
@WebServlet("/SearchAttenByStuNo")
public class SearchAttenByStuNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAttenByStuNo() {
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
//		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String stuNoString = request.getParameter("stuNo");
		Integer stuNo = Integer.parseInt(stuNoString);
		String dateString = request.getParameter("date");
		System.out.println("controller:"+dateString);
		String courseNoString = request.getParameter("course");
		Integer courseNo = Integer.parseInt(courseNoString);
		System.out.println("controller:"+courseNo);
		
		TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
		List<KaoQin> kaoQinList = null;
		kaoQinList = TeacherService.searchAttenByStuNo(stuNo,dateString,courseNo);
		System.out.println("teacher:"+kaoQinList.toString());
		request.setAttribute("kaoQinList", kaoQinList);
		request.getRequestDispatcher("show/showAttenByPage.jsp").forward(request, response);
	}

}
