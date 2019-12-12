package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAllServlet
 */
//@WebServlet("/LoginAllServlet")
public class LoginAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> users = null;
	private ServletContext context = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
		
	}
    
    public void destroy() {
		super.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("utf-8");
//		只在项目第一次启动时创建
		context = this.getServletContext();
//		判断用户是否重复登录
		boolean flag = false;
        String url="listener/login.jsp";
        String username=request.getParameter("username");
//		获取用户列表
//		注意，第一次获取时为空
        users =(ArrayList<String>)context.getAttribute("users");

//	还没有用户登录过，用户集合为空时
		 if(users.isEmpty()){
	            users = new ArrayList<String>(); 
//				将第一个用户放到已经登录的用户集合中
	            users.add(username);   
				//将用户集合保存到ServletContext对象中
	            context.setAttribute("users", users); 
	            System.out.println("#############第一个用户登录###########");
	          
	        }
		else {
//			当有用户已经登录过，用户集合不为空时
//			判断用户是否已经登录了
			 for(String user : users) {
//				如果用户已经处于登录状态，在跳转到错误界面提示用户
				 if(username.equals(user)) {
					url = "listener/error.jsp";
					System.out.println("您已经登录了，请勿重复登录！！！！！");
					flag = true;
                    break;  
				}
			}
//			如果用户没有登录，将用户添加到已经登录的用户集合中
			 if (!flag) {
				System.out.println("#########欢迎回来#######");
				users.add(username); 
			}
		}
		 for (String string : users) {
			System.out.println("--------" + string + "-----------");
		}
		
		 response.sendRedirect(url); 
		
	}

}
