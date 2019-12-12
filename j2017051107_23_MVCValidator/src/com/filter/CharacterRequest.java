package com.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet implementation class CharacterRequest
 */
//@WebServlet("/CharacterRequest")
public class CharacterRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;
	public CharacterRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
		this.request = request;
	}
	
	public String getParameter(String name) {
		//调用父类的方法获取参数
		String value =  super.getParameter(name);
		if (value == null) {
			return null;
		}
		String method = super.getMethod();
		if (method.equalsIgnoreCase("get")) {
			try {
				value = new String(value.getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		}
		return value;
	}

}
