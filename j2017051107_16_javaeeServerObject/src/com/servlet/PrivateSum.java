package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Private
 */
//@WebServlet("/private")
public class PrivateSum extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PrivateSum() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int count;
		int number;
		String numString;
		PrintWriter writer;
		
		//设置编码
		response.setContentType("text/html;charset=utf-8");
		//接请求，拿参数
		writer = response.getWriter();
		numString = request.getParameter("number");
		number = Integer.parseInt(numString);
		
		/**
		 * 处理业务
		 * */
		//创建session对象
		HttpSession session = request.getSession();
		//从session对象中获取count
		String countString = (String)session.getAttribute("count");
		if (countString != null) {
			count = Integer.parseInt(countString);
		}
		else {
			count = 0;
		}
		count += number;
		countString = String.valueOf(count);
		session.setAttribute("count", countString);
		writer.println("在session作用域下累计的结果为：" + countString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
