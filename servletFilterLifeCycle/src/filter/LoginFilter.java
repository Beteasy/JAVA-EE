package filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * 演示要点
 * 1 正常登录，会有session对象
 * 2 为空登录，不会有session对象
 * 3 用firefox直接访问admin/index.jsp会弹出未登录【过滤器发生作用】
 * 4 登录后，再直接访问admin/index.jsp，有session存在，不用重新登录
 * 5 关闭浏览器或是换一个浏览器，没有session了，将被过滤
 * @author fhzheng
 *
 */

public class LoginFilter implements Filter {
	
	private FilterConfig config = null;
	
	public void doFilter(
			ServletRequest request, 
			ServletResponse response,
			FilterChain chain) 
					throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = ((HttpServletRequest) request).getSession();
		if (session.getAttribute("user") == null) {
			PrintWriter out = response.getWriter();
			out.print("<script language = javascript>alert('都没有登录，访问我干嘛！！！');window.location.href='../login/login.jsp;'</script>");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	/**
	 * Constructor of the object.
	 */
	public LoginFilter() {
		super();
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}



	

}
