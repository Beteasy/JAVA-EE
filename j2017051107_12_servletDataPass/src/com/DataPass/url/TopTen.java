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
		shangHaiScenery.add("��������");
		shangHaiScenery.add("��һ�");
		shangHaiScenery.add("������");
		shangHaiScenery.add("��̲");
		shangHaiScenery.add("½����");
		shangHaiScenery.add("�Ͼ�·");
		shangHaiScenery.add("�Ϻ��Ƽ���");
		shangHaiScenery.add("�Ϻ�Ұ������԰");
		shangHaiScenery.add("ԥ԰");
		shangHaiScenery.add("������");
		
		taiWanScenery = new ArrayList<String>(10);
		taiWanScenery.add("����̶");
		taiWanScenery.add("̨���ʹ�����Ժ");
		taiWanScenery.add("������");
		taiWanScenery.add("���������");
		taiWanScenery.add("����ɽ�ֳ�");
		taiWanScenery.add("̨�п��� ");
		taiWanScenery.add("����ɽ�羰��");
		taiWanScenery.add("����ɽɭ����·");
		taiWanScenery.add("�徳ũ��");
		taiWanScenery.add("̨�Ͽ��� ");
		
		hangZhouScenery = new ArrayList<String>(10);
		hangZhouScenery.add("�������� ");
		hangZhouScenery.add("ǧ���� ");
		hangZhouScenery.add("��Ϫ����ʪ�ع�԰ ");
		hangZhouScenery.add("����� ");
		hangZhouScenery.add("��Ŀɽ ");
		hangZhouScenery.add("������ζȼ��� ");
		hangZhouScenery.add("ͩ®���ӵط羰�� ");
		hangZhouScenery.add("������԰ ");
		hangZhouScenery.add("����ͨ��� ");
		hangZhouScenery.add("˫Ϫ�� ");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		String city = request.getParameter("city");
		if(city != null && (city.equals("�Ϻ�") || city.equals("̨��") || city.equals("����"))) {
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
						+ "�������ξ���һ��"
					+ "</title>"
				+ "</head>"
				+ "<body>"
				+ "��ѡ��һ�����У�<br>"
				+ "<a href='?city=�Ϻ�'>�Ϻ�</a><br>"
				+ "<a href='?city=̨��'>̨��</a><br>"
				+ "<a href='?city=����'>����</a><br>"
				+ "</body>"
				+ "</html>");
		
		
	}
	
	private void showScenery(HttpServletRequest request, HttpServletResponse response, String city)throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
//		����ҳ����
		int page = 1;
//		�������ʼ����
		int start = 0;
//		����ÿҳ��ʾ�ľ�������
		int count = 5;
		
		String pageString = request.getParameter("page");
		if (pageString != null) {
			try {
				page = Integer.parseInt(pageString);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//���ݳ�����ʾ��Ӧ�ľ���
		List<String> scenery = null;
		switch (city) {
		case "�Ϻ�":
			scenery = shangHaiScenery;
			break;
		case "̨��":
			scenery = taiWanScenery;
			break;
		case "����":
			scenery = hangZhouScenery;
			break;
		default:
			break;
		}
		writer.println(
				"<html>"
				+ "<head>"
					+ "<title>"
						+ "�������ξ���һ��"
					+ "</title>"
				+ "</head>"
				+ "<body>"
				//���·�����TopTen
				+ "<a href='TopTen'>ѡ�����</a><br>"
				+ "<hr>��ǰѡ����У�"+city+"<br>��ǰ����ҳ�棺Page "+ page +"<hr><br>");
				//��ʾ5������
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
