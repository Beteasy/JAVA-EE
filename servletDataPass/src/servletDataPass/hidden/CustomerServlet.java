package servletDataPass.hidden;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Not thread-safe. For illustration purpose only
 */
/*@WebServlet(name = "CustomerServlet", urlPatterns = { 
        "/customer", "/editCustomer", "/updateCustomer"})*/
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = -20L;

    private List<Customer> customers = new ArrayList<Customer>();
    
    @Override
    public void init() throws ServletException {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("张全蛋蛋");
        customer1.setCity("成都东");
        customers.add(customer1);
        
        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("张半蛋蛋");
        customer2.setCity("成都西");
        customers.add(customer2);       

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setName("唐马德鸡");
        customer3.setCity("成都南");
        customers.add(customer3);       

        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setName("唐马德西");
        customer4.setCity("成都北");
        customers.add(customer4);       
    }
    
    private void sendCustomerList(HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>Customers客户</title></head>"
                + "<body><h2>客户们</h2>");
        writer.println("<ul>");
        for (Customer customer : customers) {
            writer.println("<li>" + customer.getName() 
                   + "(" + customer.getCity() + ") (" 
                   + "<a href='editCustomer?id=" + customer.getId()
                   + "'>点击编辑</a>)");
        }
        writer.println("</ul>");
        writer.println("</body></html>");
        
    }
    
    private Customer getCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }
    
    private void sendEditCustomerForm(HttpServletRequest request, 
            HttpServletResponse response) throws IOException {
    	request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        int customerId = 0;
        try {
            customerId = 
                    Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
        }
        Customer customer = getCustomer(customerId);
        
        if (customer != null) {
            writer.println("<html><head>"
                    + "<title>编辑客户信息</title></head>"
                    + "<body><h2>编辑客户信息</h2>"
                    + "<form method='post' "
                    + "action='updateCustomer'>");
            writer.println("<input type='hidden' name='id' value='" 
                    + customerId + "'/>");
            writer.println("<table>");
            writer.println("<tr><td>客户姓名:</td><td>" 
                    + "<input name='name' value='" + 
                    customer.getName().replaceAll("'", "&#39;") 
                    + "'/></td></tr>");
            writer.println("<tr><td>所在城市:</td><td>" 
                    + "<input name='city' value='" + 
                    customer.getCity().replaceAll("'", "&#39;") 
                    + "'/></td></tr>");
            writer.println("<tr>"
                    + "<td colspan='2' style='text-align:right'>" 
                    + "<input type='submit' value='更新'/></td>" 
                    + "</tr>");
            writer.println("<tr><td colspan='2'>"
                    + "<a href='customer'>客户列表</a>" 
                    + "</td></tr>");
            writer.println("</table>");
            writer.println("</form></body>");
        } else {
            writer.println("No customer found");
        }
        
    }
    @Override
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();
        if (uri.endsWith("/customer")) {
            sendCustomerList(response);
        } else if (uri.endsWith("/editCustomer")) {
            sendEditCustomerForm(request, response);
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        // update customer
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
        int customerId = 0;
        try {
            customerId = 
                    Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
        }
        Customer customer = getCustomer(customerId);
        if (customer != null) {
            customer.setName(request.getParameter("name"));
            customer.setCity(request.getParameter("city"));
        }
        sendCustomerList(response);
    }
}