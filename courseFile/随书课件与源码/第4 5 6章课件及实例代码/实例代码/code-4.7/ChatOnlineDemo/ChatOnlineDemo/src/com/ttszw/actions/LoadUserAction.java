package com.ttszw.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.ttszw.action.Action;
import com.ttszw.action.ChatMassage;

public class LoadUserAction implements Action {

	public Object execute(HttpServletRequest req, HttpServletResponse res) {
		ChatMassage cm = ChatMassage.Instance();
		String userMass = cm.getUsers();
		int CurrentUsers = cm.userNum;
		
		JSONObject json = new JSONObject();
		json.put("num", CurrentUsers);
		json.put("userMass", userMass);
		return json;
	}

}
