package servletDataPass.session;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
@WebServlet(name = "ShoppingCartServlet", urlPatterns = {
        "/products", "/viewProductDetails", 
        "/addToCart", "/viewCart" })*/
public class ShoppingCartServlet extends HttpServlet {
    private static final long serialVersionUID = -20L;
    private static final String CART_ATTRIBUTE = "cart";

    private List<Product> products = new ArrayList<Product>();
    private NumberFormat currencyFormat = NumberFormat
            .getCurrencyInstance(Locale.US);

    @Override
    public void init() throws ServletException {
        products.add(new Product(1, "高清电视Bravo 32' HDTV",
                "地板价中国产品Low-cost HDTV from renowned TV manufacturer",
                159.95F));
        products.add(new Product(2, "游戏机Bravo BluRay Player",
                "蓝光游戏机就是爽High quality stylish BluRay player", 99.95F));
        products.add(new Product(3, "高保真系统Bravo Stereo System",
                "多声道发烧级高保真5 speaker hifi system with iPod player", 
                129.95F));
        products.add(new Product(4, "多媒体播放器Bravo iPod player",
                "热插拔多媒体格式支持播放器An iPod plug-in that can play multiple formats",
                39.95F));
    }

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        String uri = request.getRequestURI();
        if (uri.endsWith("/products")) {
            sendProductList(response);
        } else if (uri.endsWith("/viewProductDetails")) {
            sendProductDetails(request, response);
        } else if (uri.endsWith("viewCart")) {
            showCart(request, response);
        }
    }

    @Override
    public void doPost(
    		HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        // add to cart
        int productId = 0;
        int quantity = 0;
        try {
            productId = Integer.parseInt(request.getParameter("id"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (NumberFormatException e) {
        }

        Product product = getProduct(productId);
        if (product != null && quantity >= 0) {
            ShoppingItem shoppingItem = new ShoppingItem(product,
                    quantity);
            HttpSession session = request.getSession();
            List<ShoppingItem> cart = (List<ShoppingItem>) session
                    .getAttribute(CART_ATTRIBUTE);
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
        writer.println("<html><head><title>产品Products</title>" +
        		"</head><body><h2>产品Products</h2>");
        writer.println("<ul>");
        for (Product product : products) {
            writer.println("<li>" + product.getName() + "("
                    + currencyFormat.format(product.getPrice())
                    + ") (" + "<a href='viewProductDetails?id="
                    + product.getId() + "'>详情Details</a>)");
        }
        writer.println("</ul>");
        writer.println("<a href='viewCart'>查看购物车View Cart</a>");
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

    private void sendProductDetails(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        int productId = 0;
        try {
            productId = Integer.parseInt(
                    request.getParameter("id"));
        } catch (NumberFormatException e) {
        }
        Product product = getProduct(productId);

        if (product != null) {
            writer.println("<html><head>"
                    + "<title>产品详情Product Details</title></head>"
                    + "<body><h2>产品详情Product Details</h2>"
                    + "<form method='post' action='addToCart'>");
            writer.println("<input type='hidden' name='id' "
            		+ "value='" + productId + "'/>");
            writer.println("<table>");
            writer.println("<tr><td>产品名称Name:</td><td>"
                    + product.getName() + "</td></tr>");
            writer.println("<tr><td>产品描述Description:</td><td>"
                    + product.getDescription() + "</td></tr>");
            writer.println("<tr>" + "<tr>"
                    + "<td><input name='quantity'/></td>"
                    + "<td><input type='submit' value='购买Buy'/>"
                    + "</td>"
                    + "</tr>");
            writer.println("<tr><td colspan='2'>"
                    + "<a href='products'>产品列表Product List</a>"
                    + "</td></tr>");
            writer.println("</table>");
            writer.println("</form></body>");
        } else {
            writer.println("未发现产品No product found");
        }

    }

    private void showCart(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>购物车Shopping Cart</title>"
        		+ "</head>");
        writer.println("<body><a href='products'>" +
        		"产品列表Product List</a>");
        HttpSession session = request.getSession();
        List<ShoppingItem> cart = (List<ShoppingItem>) session
                .getAttribute(CART_ATTRIBUTE);
        if (cart != null) {
            writer.println("<table>");
            writer.println("<tr><td style='width:150px'>数量Quantity"
            		+ "</td>"
                    + "<td style='width:150px'>产品Product</td>"
                    + "<td style='width:150px'>价格Price</td>"
                    + "<td>小计Amount</td></tr>");
            double total = 0.0;
            for (ShoppingItem shoppingItem : cart) {
                Product product = shoppingItem.getProduct();
                int quantity = shoppingItem.getQuantity();
                if (quantity != 0) {
                    float price = product.getPrice();
                    writer.println("<tr>");
                    writer.println("<td>" + quantity + "</td>");
                    writer.println("<td>" + product.getName()
                            + "</td>");
                    writer.println("<td>"
                            + currencyFormat.format(price) 
                            + "</td>");
                    double subtotal = price * quantity;

                    writer.println("<td>"
                            + currencyFormat.format(subtotal)
                            + "</td>");
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