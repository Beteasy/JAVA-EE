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
        // action������Ӧ�ÿ���ִ�е�һ������
        // ���Ϊ��Ʒ����
        if (action.equals("product_input.action")) {
            // no action class, there is nothing to be done
        } else if (action.equals("product_save.action")) {
            // ������Ʒ�������������������Ϊһ����Ʒ������
            ProductForm productForm = new ProductForm();
            // ������Ʒ������
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));
            
            // ������Ʒ
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            // ҵ������ת����У�飺���ݸ�ʽת��
            try {
            	product.setPrice(Float.parseFloat(productForm.getPrice()));
            } catch (NumberFormatException e) {
            }
            
            // ������Ʒ׮
            
            // store model in a scope variable for the view
            // requestֻ����һ��ҳ�洫��֮�䱣�����ݣ������ͻᶪʧ
            // ֮�����request�ͻ�ʧȥ�������÷�Χ���ٴ���Ҫ����һ�� request.setAttribute()��
            // ��ʹ��session.setAttribute()����һ��������ʼ�ձ������ֵ��
            request.setAttribute("product", product);
        }

        // ת�����������Ϣ
        // ��Servletȥ����WEB-INF�е�JSPҳ�棬����ȫ����RequestDispatcher������ɿ���
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
