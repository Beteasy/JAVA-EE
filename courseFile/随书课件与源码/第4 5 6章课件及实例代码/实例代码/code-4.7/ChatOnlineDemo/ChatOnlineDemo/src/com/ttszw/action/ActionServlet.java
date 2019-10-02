package com.ttszw.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.ttszw.actions.ExitAction;
import com.ttszw.actions.LoadDataAction;
import com.ttszw.actions.LoadUserAction;
import com.ttszw.actions.LoginAction;
import com.ttszw.actions.SendMassageAction;

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = -3547709943224681062L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String currentURL = req.getServletPath();
		req.setCharacterEncoding("utf-8");
		//得到请求路径
		String path = currentURL.substring(0, currentURL.indexOf("."));

		Action action = null;
		if("/login".equalsIgnoreCase(path)){
			//登陆
			action = new LoginAction();
		}else if("/loadData".equalsIgnoreCase(path)){
			//加载对话信息
			action = new LoadDataAction();
		}else if("/sendMassage".equalsIgnoreCase(path)){
			//发送消息
			action = new SendMassageAction();
		}else if("/loadUser".equalsIgnoreCase(path)){
			//加载用户列表
			action = new LoadUserAction();
		}else if("/exit".equalsIgnoreCase(path)){
			//加载用户列表
			action = new ExitAction();
		}
		Object result = action.execute(req, res);
		
		if(result instanceof String){
			//如果返回的结果是String类型，则跳转
			req.getRequestDispatcher(result.toString()).forward(req, res);
		}else if(result instanceof JSONObject){
			//如果是JSONObject类型，则返回给浏览器
			res.setCharacterEncoding("utf-8");
			res.getWriter().print((JSONObject)result);
		}
		
	}
	
}
