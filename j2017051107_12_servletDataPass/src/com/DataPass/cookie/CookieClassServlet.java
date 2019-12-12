package com.DataPass.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CookieClassServlet
 */
//@WebServlet("/CookieClassServlet")
public class CookieClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String[] methods = {
	           "clone", "getComment", "getDomain",
	           "getMaxAge", "getName", "getPath",
	           "getSecure", "getValue", "getVersion",
	           "isHttpOnly", "setComment", "setDomain",
	           "setHttpOnly", "setMaxAge", "setPath",
	           "setSecure", "setValue", "setVersion"};
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieClassServlet() {
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

        PrintWriter writer = response.getWriter();
        Cookie[] cookies = request.getCookies();
        Cookie maxRecordsCookie = null;	
        int maxRecords = 5; 
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("maxRecords")) {
                    maxRecordsCookie = cookie;
                    break;
                }
            }
        }
        
        if (maxRecordsCookie != null) {
            try {
                maxRecords = Integer.parseInt(
                        maxRecordsCookie.getValue());
            } catch (NumberFormatException e) {
                
            }
        }
        
       
        writer.print(
        		"<html>"
        		+ "<head>" 
        		+ "<title>Cookie Class</title>"
                + "</head>"
                + "<body>" 
                + PreferenceServlet.MENU
                + "<div>"
                + "这是Cookie中的一些方法:根据前面设置的最大记录数显示相应数量的方法<br>");
        writer.print("<ul>");
        
        for (int i = 0; i < maxRecords; i++) {
            writer.print("<li>" + methods[i] + "</li>");
        }
        writer.print("</ul>");
        writer.print("</div>"
        		+ "</body>"
        		+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
