package listener;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnLineCountListener implements ServletContextListener, HttpSessionListener,
		HttpSessionAttributeListener {
	
	private ServletContext application = null;
	private ArrayList<String> users = null;
	private HttpSession session = null;
	private String user = null;
	
	public void contextInitialized(ServletContextEvent sce) {
		this.application = sce.getServletContext();
		this.application.setAttribute("users", new ArrayList<String>());
		
	}
	public void contextDestroyed(ServletContextEvent sce) {
	}
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("一个Session创建了!"); 
	}
	public void sessionDestroyed(HttpSessionEvent se) {		
		session = se.getSession();    
		user = (String)session.getAttribute("username");    
		users = (ArrayList<String>)session.getServletContext().getAttribute("users");  
		for(String u:users){ 
		    if(u.equals(user)){   
		        users.remove(u);      
		        break;   
		    }   
		}   
		session.invalidate();   
		System.out.println("一个Session被销毁掉了!"); 
	}
	public void attributeAdded(HttpSessionBindingEvent se) {
		users=(ArrayList<String>)application.getAttribute("users");
		users.add(se.getValue().toString());
		this.application.setAttribute("users", users);
	}
	public void attributeRemoved(HttpSessionBindingEvent se) {
	}
	public void attributeReplaced(HttpSessionBindingEvent se) {
	}
}
