package com.DataPass.hiden;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Customer> customers = new ArrayList<Customer>();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		Customer customerZhu = new Customer();
		customerZhu.setId(1);
		customerZhu.setName("诸葛亮");
		customerZhu.setCity("蜀汉");
		customers.add(customerZhu);
		
		Customer customerGuan = new Customer();
		customerGuan.setId(2);
		customerGuan.setName("关羽");
		customerGuan.setCity("蜀汉");
		customers.add(customerGuan);
		
		Customer customerLiu = new Customer();
		customerLiu.setId(3);
		customerLiu.setName("刘备");
		customerLiu.setCity("蜀汉");
		customers.add(customerLiu);
		
		Customer customerZhang = new Customer();
		customerZhang.setId(4);
		customerZhang.setName("张飞");
		customerZhang.setCity("蜀汉");
		customers.add(customerZhang);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		if (uri.endsWith("/customer")) {
			sendCustomerList(response);
		}
		else if (uri.endsWith("/editCustomer")) {
			sendEditCustomerForm(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
        int customerId = 0;
        try {
            customerId = Integer.parseInt(request.getParameter("id"));
        } 
        catch (NumberFormatException e) {
        }
        Customer customer = getCustomer(customerId);
        if (customer != null) {
            customer.setName(request.getParameter("name"));
            customer.setCity(request.getParameter("city"));
        }
        sendCustomerList(response);
	}
	
	private void sendCustomerList(HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(
        		"<html>"
        		+ "<head>"
        			+ "<title>三国人物</title>"
        		+ "</head>"
                + "<body>"
                	+ "<h2>蜀汉人物</h2>"
                + "");
        writer.println("<ul>");
        for (Customer customer : customers) {
            writer.println(
            		"<li>" + customer.getName() 
                   + "(" + customer.getCity() + ") "
                   + "(" + "<a href='editCustomer?id=" + customer.getId()+ "'>更改信息</a>"+ ")");
        }
        writer.println("</ul>");
        writer.println("</body>"
        		+ "</html>");
        
    }
	
	private void sendEditCustomerForm(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        int customerId = 0;
        try {
            customerId = Integer.parseInt(request.getParameter("id"));
        } 
        catch (NumberFormatException e) {
        }
        Customer customer = getCustomer(customerId);
        
        if (customer != null) {
            writer.println(
            		"<html>"
            		+ "<head>"
            		+ "<title>修改人物信息</title>"
                    + "</head>"
                    + "<body>"
                    + "<h2>修改人物信息</h2>"
                    + "<form method='post' action='updateCustomer'>");
            writer.println(
            		"<input type='hidden' name='id' value='" + customerId + "'/>");
            writer.println(
            		"人物姓名:" 
                    + "<input name='name' value='" + 
                    customer.getName()
                    + "'/><br>");
            writer.println(
            		"所在城市:" 
                    + "<input name='city' value='" + 
                    customer.getCity()
                    + "'/><br>");
            writer.println(
                    "<input type='submit' value='更新'/><br>" 
                    );
            writer.println(
            		"<a href='customer'>人物列表</a>" 
                    );
            writer.println(
            		"</form>"
            		+ "</body>");
        } else {
            writer.println("未找到指定人物");
        }
        
    }
	
	private Customer getCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

}
