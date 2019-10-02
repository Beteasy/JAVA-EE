package com.ttszw.actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.ttszw.action.Action;
import com.ttszw.action.ChatMassage;

public class LoginAction implements Action {

	public Object execute(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		ChatMassage cm = ChatMassage.Instance();
		
		String result =null;
		if(cm.isFull()){
			result = "聊天室人数己满！";
		}else if(cm.hasUser(name)){
			result = "此用户名己存在！";
		}else{
			cm.addUser(name);
			HttpSession session = req.getSession();
			session.setAttribute("username", name);
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			String date = dateFormat.format(new Date());
			cm.setMassage("<br><font color='red' >欢迎 "+name+"  于"+date+" 进入聊天室！</font><br>");
		}
		JSONObject json = new JSONObject();
		json.put("massage", result);
		return json;
	}

}
