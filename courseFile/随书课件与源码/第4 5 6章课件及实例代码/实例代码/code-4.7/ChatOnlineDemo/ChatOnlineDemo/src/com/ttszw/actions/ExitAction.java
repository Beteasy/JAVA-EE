package com.ttszw.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttszw.action.Action;
import com.ttszw.action.ChatMassage;

public class ExitAction implements Action {

	public Object execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		ChatMassage cm = ChatMassage.Instance();
		Object name = session.getAttribute("username");
		
		if(name!=null){
			cm.setMassage("<font color='#708090'>"+name.toString()+" 退出了聊天室！</font><br>");
			cm.exit(name.toString());
		}
		return null;
	}

}
