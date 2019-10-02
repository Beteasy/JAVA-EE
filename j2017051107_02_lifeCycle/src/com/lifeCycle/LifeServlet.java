package com.lifeCycle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LifeServlet
 */
@WebServlet("/LifeServlet")
public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int count;
	ServletContext sContext;
	String path;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    /*
     * 从文件中读取被访问的次数
     * */
    public void init() throws ServletException {
//    	获取到count.txt的路径
		sContext = this.getServletContext();
		path = sContext.getRealPath("file/count.txt");
//    	path = new String("WEB-INF/count.txt");
		try {
//			File file = new File("WEB-INF/count.txt");
			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			count = Integer.parseInt(bufferedReader.readLine());
			bufferedReader.close();
			fileReader.close();
//			System.out.println(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("file is not found");
		}
	}
	
	public void destroy() {
		System.out.println("Servlet已经释放");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		count++;
		writer.println("这个servlet历史上已经被访问了" + count + "次了");
		System.out.println("该servlet的doGet方法被执行了一次");
		
//		将更新后的count重新写到count.txt中
		FileWriter fileWriter = new FileWriter(path);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		String str = String.valueOf(count);
		System.out.println(str);
		bufferedWriter.write(str);
		bufferedWriter.close();
		fileWriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("该servlet的Post方法被执行了一次");
	}

}
