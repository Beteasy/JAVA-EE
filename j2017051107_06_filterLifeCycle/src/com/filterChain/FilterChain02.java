package com.filterChain;

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
 * Servlet Filter implementation class FilterChain02
 */
//@WebFilter("/FilterChain02")
public class FilterChain02 implements Filter {

    /**
     * Default constructor. 
     */
    public FilterChain02() {
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
		response.setContentType("text/html;charset=utf-8");
		System.out.println("我是FilterChain02，我开始工作...............");
		PrintWriter writer = response.getWriter();
		writer.println("我是FilterChain02，我开始工作...............<br>");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("我是FilterChain02，我结束工作了...............");
		writer.println("我是FilterChain02，我结束工作了...............<br>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
