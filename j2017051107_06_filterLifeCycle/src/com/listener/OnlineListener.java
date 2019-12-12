package com.listener;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Application Lifecycle Listener implementation class OnlineListener
 *
 */
@WebListener
public class OnlineListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

	
	private ServletContext application = null;
//	为什么users是String的链表，而不是User
	private ArrayList<String> users = null;
	private HttpSession session = null;
	private String user = null;
    /**
     * Default constructor. 
     */
    public OnlineListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("一个session创建了!");
    }
    
	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	session = se.getSession();
    	user = (String)session.getAttribute("username");
    	users = (ArrayList<String>)session.getServletContext().getAttribute("users");
    	for(String u:users) {
    		if (u.equals(user)) {
				users.remove(u);
				break;
			}
    	}
    	session.invalidate();
    	System.out.println("一个session被销毁掉了！");
    }


	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	this.application = sce.getServletContext();
    	this.application.setAttribute("users", new ArrayList<String>());
    }
    
    public void attributeAdded(HttpSessionBindingEvent se) {
    	users = (ArrayList<String>)application.getAttribute("users");
    	users.add(se.getValue().toString());
    	this.application.setAttribute("users", users);
	}
	
}
