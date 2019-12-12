package com.controller.counselor;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.KaoQin;
import com.service.CounselorService;

/**
 * Servlet implementation class SearchAttenByGradeController
 */
@WebServlet("/SearchAttenByGradeController")
public class SearchAttenByGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAttenByGradeController() {
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
		
		String gradeString = request.getParameter("grade");
		Integer grade = Integer.parseInt(gradeString.trim());
		String dateString = request.getParameter("date");
		System.out.println("controller:"+dateString);
		String courseNoString = request.getParameter("course");
		Integer courseNo = Integer.parseInt(courseNoString);
		System.out.println("controller:"+courseNo);
		
		CounselorService counselorService = new CounselorService();
		List<KaoQin> kaoQinList = null;
		kaoQinList = counselorService.searchAttenByGrade(grade,dateString,courseNo);
		System.out.println("controller:"+kaoQinList.toString());
		request.setAttribute("kaoQinList", kaoQinList);
		request.getRequestDispatcher("show/showAttenByPage.jsp?type=grade&grade="+grade+"&date="+dateString+"&course="+courseNo).forward(request, response);
//		request.getRequestDispatcher("show/table-basic.jsp").forward(request, response);
	}

}
