package com.controller.student;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.DBUtils.DBUtils;
import com.dao.*;
import com.entity.*;
import com.service.StuService;
import java.util.Date;
@WebServlet("/StudentQingjia")
public class StudentQingjia extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StudentQingjia() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if(action.equals("search")) {
			int stuNo = Integer.parseInt(request.getParameter("stuNo"));
			StuService stuService = new StuService();
			List<JiaTiao> jiatiaoList = null;
			jiatiaoList = stuService.getAllQingjia(stuNo);
			
			request.setAttribute("jiatiaoList", jiatiaoList);
			request.getRequestDispatcher("studentInput/searchQingjia.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if(action.equals("qingjia")) {
			int stuNo = Integer.parseInt(request.getParameter("stuNo"));
			int courNo = Integer.parseInt(request.getParameter("courNo"));
			String stype = request.getParameter("type");
			int type = 0;
			if( stype.equals("bingjia") ) {
				type = 1;
			}
			else if( stype.equals("shijia") ) {
				type = 2;
			}
			String content = request.getParameter("content");
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date startdate = null;
			Date enddate = null;
			try {
				startdate =  sf.parse(request.getParameter("startdate"));
				enddate = sf.parse(request.getParameter("enddate"));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			JiatiaoDao jd = new JiatiaoDao();
			JiaTiao jiatiao = jd.getJiatiao(stuNo, courNo, content, type, startdate, enddate);
			if(jiatiao.getStuName() == null) {
				PrintWriter out = response.getWriter();
				out.print("<script>alert('学生不存在'); window.location='studentinput/qingjia.jsp' </script>");
			}
			try {
				Connection conn = DBUtils.getConnection();
				String sql = "insert into dayoff values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, jiatiao.getId());
				pstmt.setInt(2, jiatiao.getStuNo());
				pstmt.setString(3, jiatiao.getStuName());
				pstmt.setInt(4, jiatiao.getGrade());
				pstmt.setInt(5, jiatiao.getClassId());
				pstmt.setInt(6, jiatiao.getCourNo());
				pstmt.setInt(7, jiatiao.getType());
				pstmt.setString(8, jiatiao.getContent());
				java.sql.Date sd=new java.sql.Date((jiatiao.getStartdate()).getTime());
				pstmt.setDate(9, sd);
				java.sql.Date ed=new java.sql.Date((jiatiao.getEnddate()).getTime());
				pstmt.setDate(10, ed);
				pstmt.setInt(11, jiatiao.getStatus());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	

		}
		PrintWriter out = response.getWriter();
		out.print("<script>alert('请假成功'); window.location='functionPage/studentFunction.jsp' </script>");
	}

}
