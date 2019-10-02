 package com.javaee.response; 
 import java.io.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 
 
 /**
 * 用重定向的方式处理登录以后的页面跳转
 * 完成最简单的模拟用户登录检测
 * 
 * @author fhzheng
 *
 */
public class LoginServlet extends HttpServlet {
 	public void doGet(HttpServletRequest request,
         HttpServletResponse response)throws ServletException, IOException {
 		//response.setContentType("text/html;charset=utf-8");
 		String username = request.getParameter("username");
 		String password = request.getParameter("password");
 		if (("admin").equals(username) &&("123456").equals(password)) {
               response.sendRedirect("/servletReqAndResp/welcome.html");
 		} else {
 			response.sendRedirect("/servletReqAndResp/login.html");
 		}
 	}
 	public void doPost(HttpServletRequest request, 
         HttpServletResponse response)throws ServletException, IOException {
 		doGet(request, response);
 	}
 }
