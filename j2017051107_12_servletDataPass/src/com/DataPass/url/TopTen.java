package com.DataPass.url;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;


/**
 * Servlet implementation class TopTen
 */
//@WebServlet("/TopTen")
public class TopTen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<String> shangHaiScenery;
	private List<String> taiWanScenery;
	private List<String> hangZhouScenery;

    /**
     * Default constructor. 
     */
    public TopTen() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		shangHaiScenery = new ArrayList<String>(10);
		shangHaiScenery.add("东方明珠");
		shangHaiScenery.add("徐家汇");
		shangHaiScenery.add("城隍庙");
		shangHaiScenery.add("外滩");
		shangHaiScenery.add("陆家嘴");
		shangHaiScenery.add("南京路");
		shangHaiScenery.add("上海科技馆");
		shangHaiScenery.add("上海野生动物园");
		shangHaiScenery.add("豫园");
		shangHaiScenery.add("静安寺");
		
		taiWanScenery = new ArrayList<String>(10);
		taiWanScenery.add("日月潭");
		taiWanScenery.add("台北故宫博物院");
		taiWanScenery.add("京华城");
		taiWanScenery.add("奇美博物馆");
		taiWanScenery.add("林田山林场");
		taiWanScenery.add("台中孔庙 ");
		taiWanScenery.add("阿里山风景区");
		taiWanScenery.add("阿里山森林铁路");
		taiWanScenery.add("清境农场");
		taiWanScenery.add("台南孔庙 ");
		
		hangZhouScenery = new ArrayList<String>(10);
		hangZhouScenery.add("杭州西湖 ");
		hangZhouScenery.add("千岛湖 ");
		hangZhouScenery.add("西溪国家湿地公园 ");
		hangZhouScenery.add("大慈岩 ");
		hangZhouScenery.add("天目山 ");
		hangZhouScenery.add("湘湖旅游度假区 ");
		hangZhouScenery.add("桐庐天子地风景区 ");
		hangZhouScenery.add("杭州乐园 ");
		hangZhouScenery.add("垂云通天河 ");
		hangZhouScenery.add("双溪竹海 ");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		String city = request.getParameter("city");
		if(city != null && (city.equals("上海") || city.equals("台湾") || city.equals("杭州"))) {
			showScenery(request,response, city);
		}
		else {
			showMainPage(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showMainPage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println(
				"<html>"
				+ "<head>"
					+ "<title>"
						+ "城市旅游景点一览"
					+ "</title>"
				+ "</head>"
				+ "<body>"
				+ "请选择一个城市：<br>"
				+ "<a href='?city=上海'>上海</a><br>"
				+ "<a href='?city=台湾'>台湾</a><br>"
				+ "<a href='?city=杭州'>杭州</a><br>"
				+ "</body>"
				+ "</html>");
		
		
	}
	
	private void showScenery(HttpServletRequest request, HttpServletResponse response, String city)throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
//		控制页面数
		int page = 1;
//		景点的起始索引
		int start = 0;
//		控制每页显示的景点数量
		int count = 5;
		
		String pageString = request.getParameter("page");
		if (pageString != null) {
			try {
				page = Integer.parseInt(pageString);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//根据城市显示相应的景点
		List<String> scenery = null;
		switch (city) {
		case "上海":
			scenery = shangHaiScenery;
			break;
		case "台湾":
			scenery = taiWanScenery;
			break;
		case "杭州":
			scenery = hangZhouScenery;
			break;
		default:
			break;
		}
		writer.println(
				"<html>"
				+ "<head>"
					+ "<title>"
						+ "城市旅游景点一览"
					+ "</title>"
				+ "</head>"
				+ "<body>"
				//重新发请求到TopTen
				+ "<a href='TopTen'>选择城市</a><br>"
				+ "<hr>当前选择城市："+city+"<br>当前所在页面：Page "+ page +"<hr><br>");
				//显示5个景点
				start = (page - 1) * 5;
				for (int i = start; i < start + count; i++) {
					writer.println(scenery.get(i)+"<br>");
				}
		writer.println(
				"<hr>"
				+ "<a href='?city=" + city + "&page=1' style='margin:10px'>Page 1</a>"
				+ "<a href='?city=" + city + "&page=2' style='margin:10px'>Page 2</a>"
				+ "</body>"
				+ "</html>");
				

	}

}
