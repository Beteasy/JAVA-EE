package mvc.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.InputProductController;
import mvc.controller.SaveProductController;

public class DispatcherServlet extends HttpServlet {
    
    private static final long serialVersionUID = 748495L;

    @Override
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    /**
     * 核心方法
     * 		只用于完成控制业务跳转
     * @param 请求request
     * @param 响应response
     * @throws 异常IOException
     * @throws 控制器异常ServletException
     */
    private void process(
    		HttpServletRequest request,
            HttpServletResponse response) 
            throws IOException, ServletException {

        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1); 
        
        String dispatchUrl = null;
        if (action.equals("product_input.action")) {
        	InputProductController controller = new InputProductController();
        	dispatchUrl = controller.handleRequest(request, response);
        } else if (action.equals("product_save.action")) {
        	SaveProductController controller = new SaveProductController();
        	dispatchUrl = controller.handleRequest(request, response);
        }

        if (dispatchUrl != null) {
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }
}
