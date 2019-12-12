package com.DataPass.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingCartServlet
 */
//@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CART_ATTRIBUTE = "cart";

    private List<Product> products = new ArrayList<Product>();
    private NumberFormat currencyFormat = NumberFormat
            .getCurrencyInstance(Locale.CHINA);
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
        products.add(new Product(1, "小米9 Pro",
                "小米9 Pro 不仅是一部超快的 5G 手机，更是一部全面成熟的性能旗舰",
                3699F));
        products.add(new Product(2, "小米MIX Alpha",
                "MIX Alpha 是小米站在 5G时代的起点，设计的一款面向未来的概念手机", 
                19999F));
        products.add(new Product(3, "RedmiBook 14",
                "RedmiBook将14英寸笔记本的性能和轻薄推动到一个全新的境界", 
                3999F));
        products.add(new Product(4, "小米游戏本",
                "最高采用全新第九代酷睿™ i7 高性能处理器，采用14nm制程，搭载6核心12线程，单核睿频最高可达4.5GHz3",
                7499F));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		 String uri = request.getRequestURI();
	        if (uri.endsWith("products")) {
	            sendProductList(response);
	        } else if (uri.endsWith("viewProductDetails")) {
	            sendProductDetails(request, response);
	        } else if (uri.endsWith("viewCart")) {
	            showCart(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		  	int productId = 0;
	        int quantity = 0;
	        try {
	            productId = Integer.parseInt(request.getParameter("id"));
	            quantity = Integer.parseInt(request.getParameter("quantity"));
	        } catch (NumberFormatException e) {
	        }

	        Product product = getProduct(productId);
	        if (product != null && quantity >= 0) {
	            ShoppingItem shoppingItem = new ShoppingItem(product,quantity);
	            HttpSession session = request.getSession();
	            List<ShoppingItem> cart = (List<ShoppingItem>) session.getAttribute(CART_ATTRIBUTE);
	            if (cart == null) {
	                cart = new ArrayList<ShoppingItem>();
	                session.setAttribute(CART_ATTRIBUTE, cart);
	            }
	            cart.add(shoppingItem);
	        }
	        sendProductList(response);
	}
	
	private void sendProductList(HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(
        		"<html>"
        		+ "<head>"
        		+ "<title>产品</title>" 
        		+"</head>"
        		+ "<body>"
        		+ "<h2>产品</h2>");
        writer.println("<ul>");
        for (Product product : products) {
            writer.println(
            		"<li>" + product.getName() 
            		+ "("+ currencyFormat.format(product.getPrice())+ ") "
            		+ "(" + "<a href='viewProductDetails?id="+ product.getId() + "'>详情</a>)");
        }
        writer.println("</ul>");
        writer.println("<a href='viewCart'>查看购物车</a>");
        writer.println("</body></html>");

    }

    private Product getProduct(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    private void sendProductDetails(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        int productId = 0;
        try {
            productId = Integer.parseInt(request.getParameter("id"));
        } 
        catch (NumberFormatException e) {
        }
        Product product = getProduct(productId);

        if (product != null) {
            writer.println(
            		"<html>"
            		+ "<head>"
                    + "<title>产品详情</title>"
                    + "</head>"
                    + "<body>"
                    + "<h2>产品详情</h2>"
                    + "<form method='post'");
            writer.println("<input type='hidden' name='id' " + "value='" + productId + "'/>");
            writer.println("<table>");
            writer.println("<tr><td>产品名称Name:</td><td>"+ product.getName() + "</td></tr>");
            writer.println("<tr><td>产品描述Description:</td><td>"+ product.getDescription() + "</td></tr>");
            writer.println("<tr>" + "<tr>"
                    + "<td><input name='quantity'/></td>"
                    + "<td><input type='submit' value='加入购物车'/>"
                    + "</td>"
                    + "</tr>");
            writer.println("<tr><td colspan='2'>"
                    + "<a href='products'>产品列表</a>"
                    + "</td></tr>");
            writer.println("</table>");
            writer.println("</form></body>");
        } else {
            writer.println("未发现产品");
        }

    }

    private void showCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();
        writer.println(
        		"<html>"
        		+ "<head>"
        		+ "<title>购物车</title>"
        		+ "</head>");
        writer.println(
        		"<body>"
        		+ "<a href='products'>" +"产品列表</a>");

        List<ShoppingItem> cart = (List<ShoppingItem>) session.getAttribute(CART_ATTRIBUTE);
        
    
        if (cart != null) {
            writer.println("<table>");
            writer.println("<tr>"
            		+ "<td style='width:150px'>数量"+ "</td>"
                    + "<td style='width:150px'>产品</td>"
                    + "<td style='width:150px'>价格</td>"
                    + "<td>小计</td></tr>");
            double total = 0.0;
            for (ShoppingItem shoppingItem : cart) {
                Product product = shoppingItem.getProduct();
                int quantity = shoppingItem.getQuantity();
                if (quantity != 0) {
                    float price = product.getPrice();
                    writer.println("<tr>");
                    writer.println("<td>" + quantity + "</td>");
                    writer.println("<td>" + product.getName()+ "</td>");
                    writer.println("<td>"+ currencyFormat.format(price) + "</td>");
                    double subtotal = price * quantity;

                    writer.println("<td>"+ currencyFormat.format(subtotal)+ "</td>");
                    total += subtotal;
                    writer.println("</tr>");
                }
            }
            writer.println("<tr><td colspan='4' " 
                    + "style='text-align:right'>"
                    + "总额Total:"
                    + currencyFormat.format(total)
                    + "</td></tr>");
            writer.println("</table>");
        }
        writer.println("</table></body></html>");

    }

}
