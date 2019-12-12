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
//		ֻ����Ŀ��һ������ʱ����
		context = this.getServletContext();
//		�ж��û��Ƿ��ظ���¼
		boolean flag = false;
        String url="listener/login.jsp";
        String username=request.getParameter("username");
//		��ȡ�û��б�
//		ע�⣬��һ�λ�ȡʱΪ��
        users =(ArrayList<String>)context.getAttribute("users");

//	��û���û���¼�����û�����Ϊ��ʱ
		 if(users.isEmpty()){
	            users = new ArrayList<String>(); 
//				����һ���û��ŵ��Ѿ���¼���û�������
	            users.add(username);   
				//���û����ϱ��浽ServletContext������
	            context.setAttribute("users", users); 
	            System.out.println("#############��һ���û���¼###########");
	          
	        }
		else {
//			�����û��Ѿ���¼�����û����ϲ�Ϊ��ʱ
//			�ж��û��Ƿ��Ѿ���¼��
			 for(String user : users) {
//				����û��Ѿ����ڵ�¼״̬������ת�����������ʾ�û�
				 if(username.equals(user)) {
					url = "listener/error.jsp";
					System.out.println("���Ѿ���¼�ˣ������ظ���¼����������");
					flag = true;
                    break;  
				}
			}
//			����û�û�е�¼�����û���ӵ��Ѿ���¼���û�������
			 if (!flag) {
				System.out.println("#########��ӭ����#######");
				users.add(username); 
			}
		}
		 for (String string : users) {
			System.out.println("--------" + string + "-----------");
		}
		
		 response.sendRedirect(url); 
		
	}

}
