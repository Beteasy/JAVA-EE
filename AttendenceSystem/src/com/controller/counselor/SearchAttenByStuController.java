package com.controller.counselor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.KaoQin;
import com.service.CounselorService;

/**
 * Servlet implementation class SearchAttenByStuController
 */
@WebServlet("/SearchAttenByStuController")
public class SearchAttenByStuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAttenByStuController() {
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
		response.setContentType("text/html;charset=utf-8");
		
		String stuNoString = request.getParameter("stuNo");
		Integer stuNo = Integer.parseInt(stuNoString);
		String dateString = request.getParameter("date");
		System.out.println("controller datestring:"+dateString);
		String courseNoString = request.getParameter("course");
		Integer courseNo = Integer.parseInt(courseNoString);
//		System.out.println("controller:"+courseNo);
		
		CounselorService counselorService = new CounselorService();
		List<KaoQin> kaoQinList = null;
		kaoQinList = counselorService.searchAttenByStu(stuNo,dateString,courseNo);
//		System.out.println("controller:"+kaoQinList.toString());
		request.setAttribute("kaoQinList", kaoQinList);
		request.getRequestDispatcher("show/showAttenByPage.jsp?type=student&stuNo="+stuNo+"&date="+dateString+"&course="+courseNo).forward(request, response);
	}

}
