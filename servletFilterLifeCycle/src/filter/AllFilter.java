package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 该过滤器对
 * 任意地址、任意请求方式都进行过滤
 * Servlet Filter implementation class AllFilter
 */
/*@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/*" })*/
public class AllFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AllFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("AllFilter destroy()...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("全部过滤器工作...AllFilter...");
		// 这里只是控制台的输出，如是是out响应输出
		// 且而把输出设置为html全格式，则这个输出将导致替换过滤后的部分内容
		// 即可以理解为它拦截了之后的内容【好象浏览器也可以显示出来，但已经不是标准的一个网页了】
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("全部过滤器工作...AllFilter...");
		
/*		out.write("<!DOCTYPE html>"
				+ "<html>"
				+ "<head><titl>AllFilter</title></head>"
				+ "<body>全部过滤器工作...AllFilter...</body>"
				+ "</html>");*/
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("AllFilter init()...");
	}

}
