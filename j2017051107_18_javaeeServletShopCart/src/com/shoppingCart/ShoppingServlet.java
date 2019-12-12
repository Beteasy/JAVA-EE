package com.shoppingCart;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingServlet
 */
//@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		//������  �ò���
		//��ȡservletContext����
		ServletContext context = request.getServletContext();
		HttpSession session = request.getSession();
		//�õ�sesson�еĹ��ﳵ����
		ShopCart cart = (ShopCart)session.getAttribute("cart");
		
		String action = request.getParameter("action");
		
		//��������
		//�����Ʒ�����ﳵ��
		if (action.equals("add")) {
			String[] productIds = request.getParameterValues("productId");
			//��ȡservletContext�е���Ʒ
			Map products = (Map) context.getAttribute("products");
			if (cart == null) {
				//session��û��cart����
				cart = new ShopCart();
				//��cart��ӵ�session��
				session.setAttribute("cart", cart);
			}
			if (productIds == null) {
				productIds = new String[0];
			}
			//������û�ѡ�����Ʒ��ӵ����ﳵ��
			for (int i = 0; i < productIds.length; i++) {
				Product product = (Product) products.get(productIds[i]);
				cart.addProductToCart(product);
			}
			
		}
		//ɾ�����ﳵ�е�ĳ����Ʒ
		if (action.equals("remove")) {
			String productId = request.getParameter("productId");
			cart.removeProductFromCart(productId);
		}
		request.getRequestDispatcher("showCartServlet").forward(request, response);
	}

}
