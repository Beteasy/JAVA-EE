package com.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DBUtils.DBUtils;
/**
 * Servlet implementation class StuServlet
 */
@WebServlet("/StuServlet")
public class StuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StuServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		
		if (action.equals("del")) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DBUtils.getConnection();
				String sql = "delete from student where stuNo="
						+ request.getParameter("stuNo");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
				pstmt.close();
				response.sendRedirect("stuList.jsp");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("add")) {
				System.out.print(request.getParameter("stuName"));
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DBUtils.getConnection();
					String sql = "insert into student  values(?,?,?,?,?,?,?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1,	Integer.parseInt(request.getParameter("stuNo")));
					pstmt.setString(2, request.getParameter("stuName"));
					pstmt.setInt(3, Integer.parseInt(request.getParameter("classId")));
					pstmt.setInt(4,Integer.parseInt(request.getParameter("stuPermission")));
					pstmt.setString(5, request.getParameter("userName"));
					pstmt.setString(6, request.getParameter("password"));
					pstmt.setString(7,request.getParameter("phoneNumber"));
					pstmt.executeUpdate();
					pstmt.close();
					response.sendRedirect("stuList.jsp");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (action.equals("update")) {
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DBUtils.getConnection();
					String sql = "update student set stuName=?,classId=?,stuPermission=?,userName=?,password=?,phoneNumber=? where stuNo=?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, request.getParameter("stuName"));
					pstmt.setInt(2, Integer.parseInt(request.getParameter("classId")));
					pstmt.setInt(3,Integer.parseInt(request.getParameter("stuPermission")));
					pstmt.setString(4, request.getParameter("userName"));
					pstmt.setString(5, request.getParameter("password"));
					pstmt.setString(6,request.getParameter("phoneNumber"));
					pstmt.setInt(7,Integer.parseInt(request.getParameter("stuNo")));
					pstmt.executeUpdate();
					pstmt.close();
					response.sendRedirect("stuList.jsp");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}
	}

}
