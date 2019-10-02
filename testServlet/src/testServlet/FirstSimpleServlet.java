package testServlet;

import java.io.IOException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstSimpleServlet extends HttpServlet{
	
	public FirstSimpleServlet() {
		super();	//���Բ���ʾ����
	}
	
	//����HTTP GET ���͵�����
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//�������ҳ��֧��������ʾ
		resp.setContentType("text/html;charset=UTF-8");
		//��ȡ�������
		PrintWriter out = resp.getWriter();
		//������������Ϣ
		out.println("this is a simple servlet"+"<br>");
		//��ʾ��������GET��ʽ����POST��ʽ�ύ��
		out.println(req.getMethod());
	}
	
	//����HTTP POST���͵�����
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//���յ�HTTP POST���͵�����ʱ��ֱ�ӵ���doGet����������ͬ�Ĵ���
		super.doPost(req, resp);
	}
}
