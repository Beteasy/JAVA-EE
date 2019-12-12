package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PublicSum
 */
//@WebServlet("/PublicSum")
public class PublicSum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	声明上下文对象
	ServletContext servletContext;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicSum() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
//    	创建上下文对象
		servletContext = this.getServletContext();
		
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
		//从servletContext对象中获取count
		String countString = (String)servletContext.getAttribute("count");
		if (countString != null) {
			count = Integer.parseInt(countString);
		}
		else {
			count = 0;
		}
		count += number;
		countString = String.valueOf(count);
		servletContext.setAttribute("count", countString);
		writer.println("在servletContext作用域下累计的结果为：" + countString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
