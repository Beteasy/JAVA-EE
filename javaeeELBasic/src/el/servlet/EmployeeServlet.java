package el.servlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import el.model.Address;
import el.model.Employee;

/*@WebServlet(urlPatterns = {"/employee"})*/
public class EmployeeServlet extends HttpServlet {
    private static final int serialVersionUID = -5392874;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Address address = new Address();
        address.setStreetName("西航港经济开发区学府路");
        address.setStreetNumber("24#");
        address.setCity("成都");
        address.setState("四川");
        address.setZipCode("610225");
        address.setCountry("中国");
        
        Employee employee = new Employee();
        employee.setId(1099);
        employee.setName("里查德风华");
        employee.setAddress(address);
        request.setAttribute("employee", employee);
        
        Map<String, String> capitals = new HashMap<String,String>();
        capitals.put("中国", "北京");
        capitals.put("奥地利", "Vienna维也那");
        capitals.put("奥小利亚", "Canberra看，赔啦");
        capitals.put("加拿小", "Ottawa屋太滑，站不稳");
        request.setAttribute("capitals", capitals);
        
        //转发时，带参数
        response.setContentType("text/html;charset=utf-8");
        RequestDispatcher rd = 
                request.getRequestDispatcher("/employee.jsp");
        rd.forward(request, response);
    }
}