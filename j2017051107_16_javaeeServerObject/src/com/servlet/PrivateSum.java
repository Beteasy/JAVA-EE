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
		
		//���ñ���
		response.setContentType("text/html;charset=utf-8");
		//�������ò���
		writer = response.getWriter();
		numString = request.getParameter("number");
		number = Integer.parseInt(numString);
		
		/**
		 * ����ҵ��
		 * */
		//����session����
		HttpSession session = request.getSession();
		//��session�����л�ȡcount
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
		writer.println("��session���������ۼƵĽ��Ϊ��" + countString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
