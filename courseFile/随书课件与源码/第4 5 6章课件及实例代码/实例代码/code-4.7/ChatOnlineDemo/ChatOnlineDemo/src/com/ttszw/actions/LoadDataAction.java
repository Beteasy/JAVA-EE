package com.ttszw.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.ttszw.action.Action;
import com.ttszw.action.ChatMassage;

public class LoadDataAction implements Action {

	public Object execute(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String numb = req.getParameter("num");
		//上次加载时客户端信息总数
		int num;
		if(numb==null){
			num = Integer.valueOf(session.getAttribute("massageNumber").toString());
		}else{
			num = Integer.valueOf(numb.trim());
		}
		ChatMassage cm = ChatMassage.Instance();
		//得到对话信息
		String mas = cm.getMassage(num);

		//得到信息总数
		int massageNumber=cm.mass_num;
		session.setAttribute("massageNumber", massageNumber);
		
		JSONObject json = new JSONObject();
		json.put("massage", mas);
		json.put("massageNumber", massageNumber);
		return json;
	}

}
