package testServlet;

import java.io.IOException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstSimpleServlet extends HttpServlet{
	
	public FirstSimpleServlet() {
		super();	//试试不显示调用
	}
	
	//处理HTTP GET 类型的请求
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//设置输出页面支持中文显示
		resp.setContentType("text/html;charset=UTF-8");
		//获取输出对象
		PrintWriter out = resp.getWriter();
		//想请求端输出信息
		out.println("this is a simple servlet"+"<br>");
		//显示请求是以GET方式还是POST方式提交的
		out.println(req.getMethod());
	}
	
	//处理HTTP POST类型的请求
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//当收到HTTP POST类型的请求时，直接调用doGet方法进行相同的处理
		super.doPost(req, resp);
	}
}
