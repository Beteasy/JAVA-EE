package com.ttszw.actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttszw.action.Action;
import com.ttszw.action.ChatMassage;

public class SendMassageAction implements Action {

	public Object execute(HttpServletRequest req, HttpServletResponse res) {
		String content = req.getParameter("content").trim();
		ChatMassage cm = ChatMassage.Instance();
		//用户姓名
		String name = req.getSession().getAttribute("username").toString();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String date = dateFormat.format(new Date());
		System.out.println(content);
		//得到当前用户的颜色
		String color = cm.getColor(name);
		String mass = "<font color='"+color+"'>"+name+"  "+date+"</font><br><span style='color:#6495ED;'>&nbsp&nbsp"+content+"</span><br>";
		cm.setMassage(mass);
		return "loadData.do";
	}
	
	/**
	 * 转义字符
	 * @param source
	 * @return
	 */
	private String filer(String source){
		StringBuffer result = new StringBuffer(source);
		Pattern p = Pattern.compile("[^0-9|^a-z|^A-Z|^\u4e00-\u9fa5]");
		Matcher m = p.matcher(source);
        boolean f=true;
        
        List<Integer> a = new ArrayList<Integer>();
        while (f) {
           f = m.find();
           if (f) {
               int con = m.start();
               a.add(con);
           }
        }
        int n=0;  // '\'的数量
        for(int i:a){
        	result.insert(i+n, "\\\\");
        	n++;
        }
        return result.toString();
	}
}
