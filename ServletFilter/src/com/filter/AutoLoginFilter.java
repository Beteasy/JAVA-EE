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
//��servletRequestת��ΪHttpServletRequest,�Ա�ʹ��HttpServletRequest�ṩ��һЩ����
		HttpServletRequest req = (HttpServletRequest)request;
//		��cookies���ҵ���ΪautoLogin��cookie
		Cookie[] cookies = req.getCookies();
		String autologin = null;
		for (int i = 0; cookies != null && i < cookies.length;  i++) {
			if ("autologin".equals(cookies[i].getName())) {
//				cookie���й���ʱ�䡢��Ч·����value������ֻȡvalue�����������֤
				autologin = cookies[i].getValue();
				break;
			}
		}
		System.out.println("��autologin�л�ȡ����autoLoginΪ" + autologin);
//		���autoLogin��Ϊ�գ���˵�����û���Ϣ�������Զ���¼
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
