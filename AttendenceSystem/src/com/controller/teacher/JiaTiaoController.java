package com.controller.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.JiaTiao;
import com.entity.KaoQin;
import com.mysql.cj.xdevapi.Result;
import com.service.CounselorService;

/**
 * Servlet implementation class PiJiaController
 */
@WebServlet("/JiaTiaoController")
public class JiaTiaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JiaTiaoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		CounselorService counselorService = new CounselorService();
		
		String action = request.getParameter("action");
		System.out.println("action:"+action);
		if (action.equalsIgnoreCase("search")) {
			String range = request.getParameter("range");
			String idString = null;
			Integer id;
			List<JiaTiao> jiaTiaoList = null;
			JiaTiao jiaTiao = null;
			switch (range) {
			case "all":
//				jiaTiaoList = counselorService.getAllJiaTiao();
				break;
			case "id":
				idString = request.getParameter("id");
				id = Integer.parseInt(idString);
				jiaTiao = counselorService.getJiaTiaoById(id);
			default:
				break;
			}
			System.out.println("controller:"+jiaTiaoList.toString());
			request.setAttribute("jiaTiaoList", jiaTiaoList);
			request.getRequestDispatcher("show/showJiaTiaoListByPage.jsp").forward(request, response);
		}
		/*if (action.equalsIgnoreCase("deal")) {
			String result = request.getParameter("result");
			String idString = request.getParameter("id");
			Integer id = Integer.parseInt(idString);
			switch (result) {
			case "agree":
				counselorService.updateJiaTiaoStatus(id,1);
				break;
			case "disagree":
				counselorService.updateJiaTiaoStatus(id, 2);
				break;
			default:
				break;
			}*/
			
			//做转发  转发到哪里合适？？？？  先转发到没有审批的界面
			request.getRequestDispatcher("JiaTiaoController?action=search&range=unsanctioned").forward(request, response);
		}
		
}

