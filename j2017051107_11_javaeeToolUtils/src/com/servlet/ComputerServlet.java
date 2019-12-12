package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Computer;

/**
 * Servlet implementation class ComputerServlet
 */
//@WebServlet("/ComputerServlet")
public class ComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public ComputerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Computer computer = null;
		double x;
		double y;
		double result = 0.0;
		String operator = null;
		HttpSession session;
		
//		获取从inputNumbers传过来的数据
		x = Double.parseDouble(request.getParameter("x"));
		y = Double.parseDouble(request.getParameter("y"));
		operator = request.getParameter("operator");
		
//		根据获取到的操作符进行相应运算
		switch (operator) {
		case "+":
			result = x + y;
			break;
		case "-":
			result = x - y;
			break;
		case "*":
			result = x * y;
			break;
		case "/":
			result = x / y;
			break;
		default:
			break;
		}
		
//		将数据封装到computer对象中，传递到
		computer = new Computer();
		computer.setX(x);
		computer.setY(y);
		computer.setOperator(operator);
		computer.setResult(result);
		
		session = request.getSession();
		session.setAttribute("computer", computer);
//		request.getRequestDispatcher("computer/inputNumber.jsp").forward(request, response);
//		通过重定向回到inputNumber.jsp，可以重复进行计算
		response.sendRedirect("computer/inputNumber.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
