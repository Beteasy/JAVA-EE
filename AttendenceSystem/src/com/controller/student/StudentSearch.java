package com.controller.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBUtils.DBUtils;
import com.dao.JiatiaoDao;
import com.entity.JiaTiao;
import com.entity.KaoQin;
import com.service.StuService;
@WebServlet("/StudentSearch")
public class StudentSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StudentSearch() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if( action.equals("searchallstu") ) {
			int stuNo = Integer.parseInt(request.getParameter("stuNo"));
			StuService stuService = new StuService();
			List<KaoQin> kaoqinList = null;
			kaoqinList = stuService.getAllKaoqin(stuNo);
			
			request.setAttribute("kaoqinList", kaoqinList);
			request.getRequestDispatcher("show/showAllkaoqin_stu.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
