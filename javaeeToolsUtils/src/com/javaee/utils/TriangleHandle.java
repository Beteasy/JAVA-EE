package com.javaee.utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaee.bean.Triangle;

/**
 * Servlet implementation class TriangleHandle
 */
@WebServlet("/TriangleHandle")
public class TriangleHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TriangleHandle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Triangle triangle = new Triangle();
		request.setAttribute("triangle", triangle);
		Double a = Double.parseDouble(request.getParameter("sideA"));
		Double b = Double.parseDouble(request.getParameter("sideB"));
		Double c = Double.parseDouble(request.getParameter("sideC"));
		Double p = (a+b+c)/2.0;
		Double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		
		triangle.setSideA(a);
		triangle.setSideB(b);
		triangle.setSideC(c);
		triangle.setArea(area);
		
		if((a+b>c) && (b+c>a) && (c+a>b)) {
			triangle.setIsTriangle(true);
		} else {
			triangle.setIsTriangle(false);
		}
		
		//RequestDispatcher rd = request.getRequestDispatcher("triangle/show.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("triangle/showByEL.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
