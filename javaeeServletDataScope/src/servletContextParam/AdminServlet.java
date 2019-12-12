package servletContextParam;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class AdminServlet extends HttpServlet
{
	ServletContext sc;	//APP全局可见
	public void init()
	{
		sc=this.getServletContext();
	}
	
	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String newmsg=request.getParameter("msg");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String date=simpleDateFormat.format(new Date());
        String msg=(String)sc.getAttribute("msg");
        if(msg==null){
            String str="发布时间"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"	//相当于六个汉字的宽度
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
            		+ "&nbsp;&nbsp;&nbsp;&nbsp;"+"发布内容"+"<br>"
            		+date+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+newmsg;
            sc.setAttribute("msg",str);	//APP全局可见的参数
        }
        else
        {
            String str=msg+"<br>"+date+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+newmsg;
            sc.setAttribute("msg",str);
        }
		out.println("设置成功");
	}
}