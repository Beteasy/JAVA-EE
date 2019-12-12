package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MyFilter02
 */
public class MyFilter02 implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter02() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
/*		out.write("<html>"
				+ "<head><title>Filter and Servlet</title></head>"
				+ "<body>");*/
		out.write("这里是过滤器02工作中开始...<br />");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		out.write("<br />这里是过滤器02工作中结束...<br />");
		//out.write("</body></html>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
