package com.DataPass.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieInfoServlet
 */
//@WebServlet("/CookieInfoServlet")
public class CookieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieInfoServlet() {
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
        StringBuilder styles = new StringBuilder();
        
        //设置title的样式
        styles.append(".title {");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                if (name.equals("titleFontSize")) {
                    styles.append("font-size:" + value + ";");
                } else if (name.equals("titleFontWeight")) {
                    styles.append("font-weight:" + value + ";");
                } else if (name.equals("titleFontStyle")) {
                    styles.append("font-style:" + value + ";");
                } else if (name.equals("color")) {
                    styles.append("color:" + value + ";");
                }
            }
        }
        styles.append("}");
        
        writer.print(
        		"<html>"
        		+ "<head>" 
        		+ "<title>Cookie Info</title>"
                + "<style>" + styles.toString() + "</style>"
                + "</head>"
                + "<body>" 
                + PreferenceServlet.MENU 
                + "<div class='title'>"
                + "会话中的Cookies管理:"
                + "</div>");
        
        writer.print("<div class='title'>");
        if (cookies == null) {
            writer.print("响应中没有Cookie<br/>");
        } 
        else {
            writer.println("响应中的Cookie是:<br/>");
            for (Cookie cookie : cookies) {
                writer.println(cookie.getName() + ":" + cookie.getValue()+ "<br>");
            }
        }
        writer.print("</div>");
        writer.print(
        		"</body>"
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
