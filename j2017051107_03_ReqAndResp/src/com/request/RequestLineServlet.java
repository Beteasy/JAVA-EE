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
//		 获取请求各个参数
		 writer.println("获取请求方法getMethod: " + "<font color="+"red>"+ request.getMethod() +"</font>" + "<br />");
		 writer.println("获取根路径到地址结尾 getRequestURI: " + "<font color="+"red>"+ request.getRequestURI() +"</font>"  + "<br />");
		 writer.println("获取查询字符串getQueryString: " + "<font color="+"red>"+ request.getQueryString() +"</font>"  + "<br />");
		 writer.println("获取项目的根路径 getContextPath: " + "<font color="+"red>"+ request.getContextPath() +"</font>"  + "<br />");
		 writer.println("获取能够与“url-pattern”中匹配的路径getServletPath: " + "<font color="+"red>"+ request.getServletPath() +"</font>"  + "<br />");
		 writer.println("获取发送此请求的客户端IP地址getRemoteAddr: " + "<font color="+"red>"+ request.getRemoteAddr() +"</font>"  + "<br />");
		 writer.println("获取发送此请求的客户端主机名getRemoteHost: " + "<font color="+"red>"+ request.getRemoteHost() +"</font>"  + "<br />");
		 writer.println("获取端口号getRemotePort: " + "<font color="+"red>"+ request.getRemotePort() +"</font>"  + "<br />");
		 writer.println("获取本地IP地址getLocalAddr: " + "<font color="+"red>"+ request.getLocalAddr() +"</font>"  + "<br />");
		 writer.println("获取本地主机名getLocalName: " + "<font color="+"red>"+ request.getLocalName() +"</font>"  + "<br />");
		 writer.println("获取应用服务器端口getLocalPort: " + "<font color="+"red>"+ request.getLocalPort() +"</font>"  + "<br />");
		 writer.println("获取请求主机名getSerName: " + "<font color="+"red>"+ request.getServerName() +"</font>"  + "<br />");
		 writer.println("获取请求端口getSerPort: " + "<font color="+"red>"+ request.getServerPort() +"</font>"  + "<br />");
		 writer.println("获取请求地址getRequestURL: " + "<font color="+"red>"+ request.getRequestURL() +"</font>"  + "<br />");
		 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
