package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import entity.User;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
//@WebFilter("/*")
public class AutoLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLoginFilter() {
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
	public void doFilter(
			ServletRequest req, 
			ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		//获得一个名为autologin的cookie
		Cookie[] cookies = request.getCookies();
		String autologin = null;
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if ("autologin".equals(cookies[i].getName())) {
				autologin = cookies[i].getValue();
				break;
			}
		}
		System.out.println("在AutoLogin中获取到的autoLogin为" + autologin);
		if (autologin != null) {
			//做自动登录
			String[] parts = autologin.split("-");
			String username = parts[0];
			String password = parts[1];
			//检查用户名和密码
			if ("fhzheng".equals(username) && "123546".equals(password)) {
				//登录成功则将用户状态存入session域
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				request.getSession().setAttribute("user", user);
			}
		}
				
		//放行
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
