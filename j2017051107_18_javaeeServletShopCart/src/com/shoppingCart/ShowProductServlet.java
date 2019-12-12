package com.shoppingCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ShowProductServlet
 */
//@WebServlet("/ShowProductServlet")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//用于存储商店的商品
	private Map products;

    /**
     * Default constructor. 
     */
    public ShowProductServlet() {
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
		products = new HashMap();
		products.put("001", new Product("001","小米9 Pro",
                "小米9 Pro 不仅是一部超快的 5G 手机，更是一部全面成熟的性能旗舰",
                3699F,200));
		products.put("002", new Product("002","小米MIX Alpha",
                "MIX Alpha 是小米站在 5G时代的起点，设计的一款面向未来的概念手机", 
                19999F,200));
		products.put("003", new Product("003","RedmiBook 14",
                "RedmiBook将14英寸笔记本的性能和轻薄推动到一个全新的境界", 
                3999F,200));
		products.put("004", new Product("004","小米游戏本",
                "最高采用全新第九代酷睿™ i7 高性能处理器，采用14nm制程，搭载6核心12线程，单核睿频最高可达4.5GHz3",
                7499F,200));
		ServletContext context = this.getServletContext();
		//放到servletContext中，数据被所有应用共享
		context.setAttribute("products", products);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>商品展示</title></head>");
		writer.println("<body bgcolor=\"#ffffff\">");
		writer.println("<h1>商品显示</h1>");
		//表单提交到shoppingServlet
		writer.println("<form name=\"productForm\" action=\"shoppingServlet\"method=\"post\">");
		//利用隐藏域传递处理操作--添加商品
		writer.println("<input type=\"hidden\" name=\"action\" value=\"add\"/>");
		writer.println("<table border=\"1\" cellspacing=\"0\">");
		writer.println("<tr bgcolor=\"#cccccc\">");
		writer.println("<tr bgcolor=\"#cccccc\"><td>序号</td><td>商品名称</td><td>商品描述</td><td>商品价格(元)</td><td>库存数量</td><td>添至购物车</td></tr>");
		//获取到商品的ID集
		Set productIdSet=products.keySet();
		Iterator it=productIdSet.iterator();
		int number=1;
//		根据ID遍历商品
		while(it.hasNext()){
			String id=(String)it.next();
			Product product=(Product)products.get(id);
			writer.println("<tr><td>"+number+++"</td>");
			writer.println("<td>"+product.getName()+"</td>");
			writer.println("<td>"+product.getDescription()+"</td>");
			writer.println("<td>"+product.getPrice()+"</td>");
			writer.println("<td>"+product.getNum()+"</td>");
			writer.println("<td><input type=\"checkbox\" name=\"productId\" value=\""
			+product.getId()+"\"></td></tr>");
		}
		writer.println("</table><p><input type=\"submit\" value=\"确定\"/>");
		writer.println("<input type=\"reset\" value=\"重置\"/></p>");
		writer.println("<a href=\"showCartServlet\")>查看购物车</a>");
		writer.println("</form></body></html>");
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
