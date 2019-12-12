//ShowProductServlet.java
package shoppingcart;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ShowProductServlet extends HttpServlet {

	private static final String CONTENT_TYPE="text/html;charset=utf-8";
	private Map products;
	
	public void init() throws ServletException{
		// 用HashMap来做商店，初始化各种商品，供所有用户来购买
		// 初始时，商品库存数量均为100个
		products=new HashMap();
		products.put("001",new Product("001","海信电视机","58英寸，LED液晶显示，安卓操作系统，2014年上市",6999.00,100));
		products.put("002",new Product("002","海尔洗衣机","洗涤容量6Kg，滚筒式，LED显示屏，内筒材料为不锈钢",3999.00,100));
		products.put("003",new Product("003","格力空调","三级变频，壁式挂机，超静音，超长质保，强力除湿",3269.00,100));
		products.put("004",new Product("004","海尔热水器","横式，专利金刚三层胆，专利金刚三层胆，60L",2780.00,100));
		products.put("005",new Product("005","西门子冰箱","三门冰箱，电脑控温，总容积为231-280L，能效等级为一级",5780.00,100));
		ServletContext context=getServletContext();
		// 商店置于APP全局中，所有人共享可用，买走1份少1份
		context.setAttribute("products",products);
	}
	
	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
	
		response.setContentType(CONTENT_TYPE);
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><title>ShowProductServlet</title></head>");
		out.println("<body bgcolor=\"#ffffff\">");
		out.println("<h1>商品显示</h1>");
		out.println("<a href=\""+response.encodeUrl("/javaeeServletShopCart/showcart")+"\">查看购物车</a>");
		out.println("<form name=\"productForm\" action=\"/javaeeServletShopCart/shopping\"method=\"post\">");
		out.println("<input type=\"hidden\" name=\"action\" value=\"add\"/>");
		out.println("<table border=\"1\" cellspacing=\"0\">");
		out.println("<tr bgcolor=\"#cccccc\">");
		out.println("<tr bgcolor=\"#cccccc\"><td>序号</td><td>商品名称</td><td>商品描述</td><td>商品价格(元)</td><td>库存数量</td><td>添至购物车</td></tr>");
		Set productIdSet=products.keySet();
		Iterator it=productIdSet.iterator();
		int number=1;
		while(it.hasNext()){
			String id=(String)it.next();
			Product product=(Product)products.get(id);
			out.println("<tr><td>"+number+++"</td>");
			out.println("<td>"+product.getName()+"</td>");
			out.println("<td>"+product.getDescription()+"</td>");
			out.println("<td>"+product.getPrice()+"</td>");
			out.println("<td>"+product.getNum()+"</td>");
			out.println("<td><input type=\"checkbox\" name=\"productId\" value=\""
			+product.getId()+"\"></td></tr>");
		}
		out.println("</table><p><input type=\"submit\" value=\"确定\"/>");
		out.println("<input type=\"reset\" value=\"重置\"/></p>");
		out.println("</form></body></html>");
		out.close();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
	
	public void destroy(){ }
}
