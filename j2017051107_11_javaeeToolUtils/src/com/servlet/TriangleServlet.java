package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Triangle;

/**
 * Servlet implementation class TriangleServlet
 */
//@WebServlet("/TriangleServlet")
public class TriangleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TriangleServlet() {
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
		double sideA;
		double sideB;
		double sideC;
		double area = 0.0;
		boolean isTriangle;
		Triangle triangle;
		
//		获取三条边的数据
		sideA = Double.parseDouble(request.getParameter("sideA"));
		sideB = Double.parseDouble(request.getParameter("sideB"));
		sideC = Double.parseDouble(request.getParameter("sideC"));
		
//		判断能否构成三角形
		if ((sideA+sideB)>sideC && (sideA+sideC)>sideB && (sideB+sideC)>sideA) {
			
			isTriangle = true;
			
//			计算三角形的面积
			double p = (sideA+sideB+sideC) / 2.0;
			area = Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
		}
		else {
			isTriangle = false;
		}
		
//		封装triangle对象
		triangle = new Triangle();
		triangle.setSideA(sideA);
		triangle.setSideB(sideB);
		triangle.setSideC(sideC);
		triangle.setArea(area);
		triangle.setIsTriangle(isTriangle);
		
		request.setAttribute("triangle", triangle);
		request.getRequestDispatcher("triangle/triangleResult.jsp").forward(request, response);
	}

}
