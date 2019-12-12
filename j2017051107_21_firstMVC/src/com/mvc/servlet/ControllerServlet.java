package com.mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.domain.Product;
import com.mvc.form.ProductForm;



/**
 * Servlet implementation class ControllerServlet
 */
//@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		process(request, response);
	}
	
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String uri = request.getRequestURI();
        /*
         * uri is in this form: /contextName/resourceName, 
         * for example: /javaeeMVCBasic/product_input. 
         * However, in the event of a default context, the 
         * context name is empty, and uri has this form
         * /resourceName, e.g.: /product_input
         */
        int lastIndex = uri.lastIndexOf("/");
//        System.out.println("lastIndex:"+lastIndex);
        String action = uri.substring(lastIndex + 1); 
//        System.out.println("action:"+action);
        // action代表了应用可以执行的一个操作
        // 这个为商品输入
        if (action.equals("product_input.action")) {
            // no action class, there is nothing to be done
        } else if (action.equals("product_save.action")) {
            // 创建商品表单，即将请求参数整理为一个商品表单对象
            ProductForm productForm = new ProductForm();
            // 创建商品表单对象
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));
            
            // 创建商品
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            // 业务数据转换和校验：数据格式转换
            try {
            	product.setPrice(Float.parseFloat(productForm.getPrice()));
            } catch (NumberFormatException e) {
            }
            
            // 保存商品桩
            
            // store model in a scope variable for the view
            // request只能在一次页面传递之间保存数据，超过就会丢失
            // 之后这个request就会失去它的作用范围，再传就要再设一个 request.setAttribute()。
            // 而使用session.setAttribute()会在一个过程中始终保有这个值。
            request.setAttribute("product", product);
        }

        // 转发到界面的信息
        // 用Servlet去请求WEB-INF中的JSP页面，更安全，由RequestDispatcher对象完成控制
        String dispatchUrl = null;
        if (action.equals("product_input.action")) {
            dispatchUrl = "/WEB-INF/jsp/ProductForm.jsp";
        } else if (action.equals("product_save.action")) {
            dispatchUrl = "/WEB-INF/jsp/ProductDetails.jsp";
        }
        if (dispatchUrl != null) {
            RequestDispatcher rd = 
                    request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }

}
