package com.controller.student;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentSearchAction")
public class StudentSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StudentSearchAction() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		int courNo = Integer.parseInt(request.getParameter("courNo"));
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sf.parse(request.getParameter("date"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}

}
