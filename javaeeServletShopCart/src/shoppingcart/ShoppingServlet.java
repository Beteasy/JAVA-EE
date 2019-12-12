//ShoppingServlet.java
package shoppingcart;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * 交易控制器
 * @author fhzheng
 *
 */
public class ShoppingServlet extends HttpServlet {
	
	private static final String CONTENT_TYPE="text/html;charset=utf-8";
	
	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		
		response.setContentType(CONTENT_TYPE);
		ServletContext context=getServletContext();
		HttpSession session=request.getSession();
		ShopCart cart=(ShopCart)session.getAttribute("shopCart");
		
		String action=request.getParameter("action");
		if("remove".equals(action)){  //从购物车中移走一件产品
			String removeId=request.getParameter("removeId");
			cart.removeProductFromCart(removeId);
		}
		else if("add".equals(action)){
			String[] productIds=request.getParameterValues("productId");//获取当前用户选择的产品ID
			Map products=(Map)context.getAttribute("products");    //从ServletContext对象中提取产品信息
			if(cart==null){
				cart=new ShopCart();  //创建一个购物车对象
				session.setAttribute("shopCart",cart);
			}
			if(productIds==null){
				productIds=new String[0];
			}
			for(int i=0;i<productIds.length;i++){  //将用户选择的产品添加到购物车中
				Product product=(Product)products.get(productIds[i]);
				cart.addProductToCart(product);
			}
		}
		RequestDispatcher rd=request.getRequestDispatcher("/showcart");
		rd.forward(request,response);   //转向购物车显示的Servlet
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}
