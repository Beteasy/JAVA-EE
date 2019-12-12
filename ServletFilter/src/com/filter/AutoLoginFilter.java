package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.entity.User;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
//@WebFilter("/AutoLoginFilter")
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
//将servletRequest转化为HttpServletRequest,以便使用HttpServletRequest提供的一些方法
		HttpServletRequest req = (HttpServletRequest)request;
//		在cookies中找到名为autoLogin的cookie
		Cookie[] cookies = req.getCookies();
		String autologin = null;
		for (int i = 0; cookies != null && i < cookies.length;  i++) {
			if ("autologin".equals(cookies[i].getName())) {
//				cookie中有过期时间、有效路径、value，我们只取value用来做身份验证
				autologin = cookies[i].getValue();
				break;
			}
		}
		System.out.println("在autologin中获取到的autoLogin为" + autologin);
//		如果autoLogin不为空，则说明有用户信息，进行自动登录
		if (autologin != null) {
			String[] parts = autologin.split("-");
			String username = parts[0];
			String password = parts[1];
			if ("root".equals(username) && "root".equals(password)) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				req.getSession().setAttribute("user", user);
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
