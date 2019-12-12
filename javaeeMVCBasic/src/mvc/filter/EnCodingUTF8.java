package mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EnCodingUTF8
 * 用过滤器实现全站统一编码为utf-8
 * post请求参数存放于消息体中，而get请求参数存放于消息头中
 * 消息体中可用setChararcterEncoding设置
 * 而消息头中须通过获取URI参数才能进行设置
 * 统一的解决方法：重写getParameter()
 */
@WebFilter("/*")
public class EnCodingUTF8 implements Filter {

    /**
     * Default constructor. 
     */
    public EnCodingUTF8() {
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
		// 将对象退回到带协议的请求对象和响应对象上去
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		//拦截所有请求，解决全站中文乱码，统一为utf-8
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 对req重新包装
		CharacterRequest characterRequest = new CharacterRequest(req);
		chain.doFilter(characterRequest, response);
		//response.setContentType("text/html;charset=utf-8");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	

}
