package com.servletConetxtParam;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class PublishServlet
 */
//@WebServlet("/PublishServlet")
public class PublishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServletContext context;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
		this.context = this.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());\
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		������  �ò���
		String requestMsg = request.getParameter("msg");
		
//		��������
		PrintWriter writer = response.getWriter();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleDateFormat.format(new Date());
//		��ȡcontext�е�msg
		String msg = (String)context.getAttribute("msg");
		if (msg == null) {
			String str = "����ʱ��"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"	
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;"+"��������"+"<br>"
            		+date+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+requestMsg;
//			��msg��ӵ�context��
			context.setAttribute("msg", str);
					
		}
		else {
			String str = msg + "<br>" + date + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+requestMsg;
			context.setAttribute("msg", str);
		}
		writer.println("���óɹ�");
		
		
	}

}
