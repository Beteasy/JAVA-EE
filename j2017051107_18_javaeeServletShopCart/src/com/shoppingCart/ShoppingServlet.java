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
		//接请求  拿参数
		//获取servletContext对象
		ServletContext context = request.getServletContext();
		HttpSession session = request.getSession();
		//拿到sesson中的购物车对象
		ShopCart cart = (ShopCart)session.getAttribute("cart");
		
		String action = request.getParameter("action");
		
		//处理数据
		//添加商品到购物车中
		if (action.equals("add")) {
			String[] productIds = request.getParameterValues("productId");
			//获取servletContext中的商品
			Map products = (Map) context.getAttribute("products");
			if (cart == null) {
				//session中没有cart对象
				cart = new ShopCart();
				//将cart添加到session中
				session.setAttribute("cart", cart);
			}
			if (productIds == null) {
				productIds = new String[0];
			}
			//逐个将用户选择的商品添加到购物车中
			for (int i = 0; i < productIds.length; i++) {
				Product product = (Product) products.get(productIds[i]);
				cart.addProductToCart(product);
			}
			
		}
		//删除购物车中的某类商品
		if (action.equals("remove")) {
			String productId = request.getParameter("productId");
			cart.removeProductFromCart(productId);
		}
		request.getRequestDispatcher("showCartServlet").forward(request, response);
	}

}
