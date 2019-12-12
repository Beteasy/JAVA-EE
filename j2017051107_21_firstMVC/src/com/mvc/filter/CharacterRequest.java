package com.mvc.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CharacterRequest extends HttpServletRequestWrapper{

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
