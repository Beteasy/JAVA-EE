package com.javaee.utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaee.bean.Computer;

/**
 * Servlet implementation class ComputerHandle
 */
@WebServlet("/ComputerHandle")
public class ComputerHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComputerHandle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Computer computer = null;
		HttpSession session = request.getSession(true);
		try {
			computer=(Computer)session.getAttribute("ok");
			if (computer==null) {
				computer = new Computer();
				session.setAttribute("ok", computer);
			}
		} catch (Exception e) {
			computer = new Computer();
			session.setAttribute("ok", computer);
		}
		
		double num1 = Double.parseDouble(request.getParameter("num1"));
		double num2 = Double.parseDouble(request.getParameter("num2"));
		String operator = request.getParameter("operator");
		double result = 0;
		if(operator.equals("+")) {result = num1 + num2;}
		if(operator.equals("-")) {result = num1 - num2;}
		if(operator.equals("*")) {result = num1 * num2;}
		if(operator.equals("/")) {result = num1 / num2;}
		computer.setNum1(num1);
		computer.setNum2(num2);
		computer.setOperator(operator);
		computer.setResult(result);
		
		RequestDispatcher rd = request.getRequestDispatcher("computer/showResult.jsp");
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
