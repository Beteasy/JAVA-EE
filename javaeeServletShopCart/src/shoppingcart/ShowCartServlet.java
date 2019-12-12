//ShowCartServlet.java
package shoppingcart;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ShowCartServlet extends HttpServlet{
	
	private static final String CONTENT_TYPE="text/html;charset=utf-8";
	
	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		
		response.setContentType(CONTENT_TYPE);
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		ShopCart shopcart=(ShopCart)session.getAttribute("shopCart");
		List products=null;
		
		if(shopcart==null||(products=shopcart.getAllProductsFromCart())==null){
			out.println("<html>");
			out.println("<head><title>ShowCartServlet</title></head>");
			out.println("<body bgcolor=\"#ffffff\">");
			out.println("<p><h1>你目前没有购买任何商品</h1></p>");
			out.println("<p><a href=\""+response.encodeUrl("/javaeeServletShopCart/show")+"\">返回产品显示页</a></p>");
			out.println("</body></html>");
			out.close();
		} else {
			Iterator it=products.iterator();
			out.println("<html>");
			out.println("<head><title>ShowCartServlet</title></head>");
			out.println("<body bgcolor=\"#ffffff\">");
			out.println("<p><h1>你目前购买的商品为：</h1></p>");
			out.println("<table border=\"1\" cellspacing=\"0\">");
			out.println("<tr bgcolor=\"#cccccc\"><td>商品名称</td><td>商品描述</td><td>价格</td><td>购买数量</td><td>操作</td></tr>");
			while(it.hasNext()){
				Product productItem=(Product)it.next();
				out.println("<tr><td>"+productItem.getName()+"</td>");
				out.println("<td>"+productItem.getDescription()+"</td>");
				out.println("<td>"+productItem.getPrice()+"</td>");
				out.println("<td>"+(100-productItem.getNum())+"</td>");
				out.println("<td><a href=\""+response.encodeURL("/javaeeServletShopCart/shopping?action=remove&removeId=")+productItem.getId()+"\">删除</a>");
			}
			out.println("</table>");
			out.println("<p>目前您购物车的总价格为："+shopcart.getAllProductPrice()+"元人民币。</p>");
			out.println("<p></br><a href=\""+response.encodeURL("/javaeeServletShopCart/show")+"\">返回产品显示页</a></p>");
			out.println("</body></html>");
			out.close();
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}

