package com.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamsServlet
 * ��ȡ��RequestParamsServlet�д������Ĳ���
 */
@WebServlet("/ParamsServlet")
public class ParamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParamsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		��ȡ��RequestParamsServlet�д�������username��password
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		��ȡresponse������󣬽�username��password����������ҳ��
		PrintWriter writer = response.getWriter();
		writer.println("�û��� = " + username + "<br>");
		writer.println("����  = " + password + "<br>");
		
//		��ȡͬ����ֵͬ�Ĳ���(hobbies)
//		��������Ϊ�ַ�������
		String[] hobbies = request.getParameterValues("hobbies");
		writer.println("����:<br>");
		if(hobbies != null) {
			for (String hobby : hobbies) {
				writer.println(hobby + "<br>");
			}
		}
		else {
			writer.println("���İ��þ��ǣ�û�а��ã�");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
