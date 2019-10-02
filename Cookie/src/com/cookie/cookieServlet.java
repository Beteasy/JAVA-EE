package com.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookieServlet
 */
@WebServlet("/cookieServlet")
public class cookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cookieServlet() {
//        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		//create cookie
		Cookie c = new Cookie("myCookie", "john");
		Cookie c2 = new Cookie("key2", "john2");
		
		
		//set cookie
			//set cookie's life time   /s
			c2.setMaxAge(3*24*60*60);
			//set effictive path
			c2.setPath("/Cookie/getCookie");
		//response cookie info
		response.addCookie(c);
		response.addCookie(c2);
		//direct request
		response.getWriter().write("direct request");
	}

}
