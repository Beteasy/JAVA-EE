package servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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
	int count;
	ServletContext sc;
	String path;
    
	public void init() throws ServletException{
		//count = 0;
		//System.out.println("在init中完成计数器的初始化");
		sc = this.getServletContext();
		path = sc.getRealPath("WEB-INF/count.txt");
		try {
			InputStream is = LifeServlet.class.getResourceAsStream("count.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String string = br.readLine();
			count = Integer.parseInt(string);
			br.close();
			is.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void destroy() {
		System.out.println("Servlet已经释放");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		count++;
		out.println("这个Servlet历史上已经被访问了"+count+"次了！");
		OutputStream fw = new FileOutputStream(path);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fw));
		String string = String.valueOf(count);
		bw.write(string);
		bw.close();
		fw.close();
		
		System.out.println("该Servlet的doGet方法被执行了一次");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("该Servlet的doPost方法被执行了一次");
	}

}
