package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBUtils.DBUtils;

import com.dao.UserDao;
import com.entity.Counselor;
import com.entity.Course;
import com.entity.User;
import com.service.CounselorService;
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserLoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		UserDao ud = new UserDao();
		User user = ud.getUser(account, pwd);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		if( "errorname".equals(user.getUsername())) {
			PrintWriter out = response.getWriter();
			out.print("<script>alert('用户不存在'); window.location='index.jsp' </script>");
		}
		else {
			if( "errorpwd".equals(user.getPassword()) ) {
				PrintWriter out = response.getWriter();
				out.print("<script>alert('密码错误'); window.location='index.jsp' </script>");
			}
			else {
				if( user.getPermission() == 1 ) {
					request.getRequestDispatcher("/functionPage/studentFunction.jsp").forward(request, response);
				}
				if( user.getPermission() == 2 ) {
					request.getRequestDispatcher("/functionPage/teacherFunction.jsp").forward(request, response);
				}
				if( user.getPermission() == 3 ) {
					CounselorService counselorService = new CounselorService();
					Counselor counselor = null;
					List<Course> courseList = null;
					counselor = counselorService.getCounselorInfo(user.getUseNo());
					courseList = counselorService.getCourse();
//					System.out.println("userloginservlet:"+courseList.toString());
					session.setAttribute("counselor", counselor);
					session.setAttribute("courseList", courseList);
					request.getRequestDispatcher("/functionPage/counselorFunction.jsp").forward(request, response);
				}
			}
		}
	}

}
