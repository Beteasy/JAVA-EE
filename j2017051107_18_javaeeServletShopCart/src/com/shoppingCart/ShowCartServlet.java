package com.shoppingCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowCartServlet
 */
//@WebServlet("/ShowCartServlet")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		HttpSession session=request.getSession();
		
		ShopCart shopcart=(ShopCart)session.getAttribute("cart");
		List products=null;
		
		if(shopcart==null||(products=shopcart.getAllProductsFromCart())==null){
			writer.println("<html>");
			writer.println("<head><title>购物车</title></head>");
			writer.println("<body bgcolor=\"#ffffff\">");
			writer.println("<p><h1>你目前没有购买任何商品</h1></p>");
			writer.println("<p><a href=\"showProductServlet\">返回商品显示页</a></p>");
			writer.println("</body></html>");
			writer.close();
		} else {
			Iterator it=products.iterator();
			writer.println("<html>");
			writer.println("<head><title>购物车</title></head>");
			writer.println("<body bgcolor=\"#ffffff\">");
			writer.println("<p><h1>你目前购买的商品为：</h1></p>");
			writer.println("<table border=\"1\" cellspacing=\"0\">");
			writer.println("<tr bgcolor=\"#cccccc\"><td>商品名称</td><td>商品描述</td><td>价格</td><td>购买数量</td><td>操作</td></tr>");
			while(it.hasNext()){
				Product productItem=(Product)it.next();
				writer.println("<tr><td>"+productItem.getName()+"</td>");
				writer.println("<td>"+productItem.getDescription()+"</td>");
				writer.println("<td>"+productItem.getPrice()+"</td>");
				writer.println("<td>"+(200-productItem.getNum())+"</td>");
				writer.println("<td><a href='shoppingServlet?action=remove&productId="+productItem.getId()+"'>删除</a>");
			}
			writer.println("</table>");
			writer.println("<p>目前您购物车的总价格为："+shopcart.getAllProductPrice()+"元人民币。</p>");
			writer.println("<p></br><a href=\"showProductServlet\">返回产品显示页</a></p>");
			writer.println("</body></html>");
			writer.close();
		}
	}

}
