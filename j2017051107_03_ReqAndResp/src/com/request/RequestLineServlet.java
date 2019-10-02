package com.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestLineServlet
 */
@WebServlet("/RequestLineServlet")
public class RequestLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestLineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html;charset=utf-8");
		 PrintWriter writer = response.getWriter();
//		 ��ȡ�����������
		 writer.println("��ȡ���󷽷�getMethod: " + "<font color="+"red>"+ request.getMethod() +"</font>" + "<br />");
		 writer.println("��ȡ��·������ַ��β getRequestURI: " + "<font color="+"red>"+ request.getRequestURI() +"</font>"  + "<br />");
		 writer.println("��ȡ��ѯ�ַ���getQueryString: " + "<font color="+"red>"+ request.getQueryString() +"</font>"  + "<br />");
		 writer.println("��ȡ��Ŀ�ĸ�·�� getContextPath: " + "<font color="+"red>"+ request.getContextPath() +"</font>"  + "<br />");
		 writer.println("��ȡ�ܹ��롰url-pattern����ƥ���·��getServletPath: " + "<font color="+"red>"+ request.getServletPath() +"</font>"  + "<br />");
		 writer.println("��ȡ���ʹ�����Ŀͻ���IP��ַgetRemoteAddr: " + "<font color="+"red>"+ request.getRemoteAddr() +"</font>"  + "<br />");
		 writer.println("��ȡ���ʹ�����Ŀͻ���������getRemoteHost: " + "<font color="+"red>"+ request.getRemoteHost() +"</font>"  + "<br />");
		 writer.println("��ȡ�˿ں�getRemotePort: " + "<font color="+"red>"+ request.getRemotePort() +"</font>"  + "<br />");
		 writer.println("��ȡ����IP��ַgetLocalAddr: " + "<font color="+"red>"+ request.getLocalAddr() +"</font>"  + "<br />");
		 writer.println("��ȡ����������getLocalName: " + "<font color="+"red>"+ request.getLocalName() +"</font>"  + "<br />");
		 writer.println("��ȡӦ�÷������˿�getLocalPort: " + "<font color="+"red>"+ request.getLocalPort() +"</font>"  + "<br />");
		 writer.println("��ȡ����������getSerName: " + "<font color="+"red>"+ request.getServerName() +"</font>"  + "<br />");
		 writer.println("��ȡ����˿�getSerPort: " + "<font color="+"red>"+ request.getServerPort() +"</font>"  + "<br />");
		 writer.println("��ȡ�����ַgetRequestURL: " + "<font color="+"red>"+ request.getRequestURL() +"</font>"  + "<br />");
		 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
