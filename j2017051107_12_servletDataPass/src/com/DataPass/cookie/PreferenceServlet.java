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
 * Servlet implementation class PreferenceServlet
 */
//@WebServlet("/PreferenceServlet")
public class PreferenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String MENU = 
            "<div style='padding:15px; background:lightBlue'>"
            + "<a href='CookieClassServlet'>Cookie Class��</a>&nbsp;&nbsp;"
            + "<a href='CookieInfoServlet'>Cookie Info��Ϣ</a>&nbsp;&nbsp;"
            + "<a href='PreferenceServlet'>Preferenceƫ��</a>" 
            + "</div>";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreferenceServlet() {
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
        writer.print(
        		"<html>"
        		+ "<head>" 
        			+ "<title>Preferenceƫ������</title>"
        			+ "<style>table {" + "font-size:small;"
        			+ "background:lightBlue }"
        			+ "</style>"
                + "</head>"
                + "<body>"
                + MENU
                + "�������β������²���:"
                + "<form method='post'>"
                + "<table>"
                + "<tr><td>���ñ����ֺ�: </td>"
                + "<td><select name='titleFontSize'>"
                + "<option>large</option>"
                + "<option>x-large</option>"
                + "<option>xx-large</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td>���ñ����������: </td>"
                +"<td><select name='titleStyleAndWeight' multiple>"
                + "<option>italic</option>"
                + "<option>bold</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td>���������¼��: </td>"
                + "<td><select name='maxRecords'>"
                + "<option>5</option>"
                + "<option>10</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td>��ɫ: </td>"
                + "<td><select name='color'>"
                + "<option>#F00</option>"
                + "<option>#0F0</option>"
                + "<option>#00F</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td rowspan='2'>"
                + "<input type='submit' value='����'/></td>"
                + "</tr>"
                + "</table>" + "</form>" + "</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
    	String titleFontSize = request.getParameter("titleFontSize");
        String[] titleStyleAndWeight = request.getParameterValues("titleStyleAndWeight");
        String maxRecords = request.getParameter("maxRecords");
        String color = request.getParameter("color");
        response.addCookie(new Cookie("titleFontSize",titleFontSize));
        response.addCookie(new Cookie("maxRecords", maxRecords));
        response.addCookie(new Cookie("color", color));

        // �ȴ��� titleFontWeight �� titleFontStyle ����cookie ����ͨ����������Чʱ��Ϊ0ʹ����ʱʧЧ
        Cookie cookie = new Cookie("titleFontWeight", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        cookie = new Cookie("titleFontStyle", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        //������������titleStyleAndWeight�������titleFontWeight��titleFontStyle
        if (titleStyleAndWeight != null) {
            for (String style : titleStyleAndWeight) {
                if (style.equals("bold")) {
                    response.addCookie(new Cookie("titleFontWeight", "bold"));
                } else if (style.equals("italic")) {
                    response.addCookie(new Cookie("titleFontStyle","italic"));
                }
            }
        }

        String colorCN = "��";
        if (color.equals("#0F0")) {
			colorCN = "��";
		} else if (color.equals("#00F")) {
			colorCN = "��";
		}
        writer.println(
        		"<html>"
        		+ "<head>" 
        			+ "<title>ƫ������</title>"
                + "</head>"
                + "<body>" 
                + MENU
                + "����ƫ���Ѿ�����.<br/>"
                + "�����ֺ�: " + titleFontSize
                + "<br/>��������¼: " + maxRecords
                + "<br/>������ɫ: " + colorCN
                + "<br/>������������: ");

        // titleStyleAndWeight will be null if none of the options
        // was selected
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie2:cookies) {
        	System.out.println(cookie2.getName()+":"+cookie2.getValue());
        }
        if (titleStyleAndWeight != null) {
            writer.println("<ul>");
            for (String style : titleStyleAndWeight) {
                writer.print("<li>" + style + "</li>");
            }
            writer.println("</ul>");
        }
        writer.println("</body></html>");
	}

}
