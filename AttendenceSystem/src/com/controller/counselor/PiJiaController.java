package com.controller.counselor;

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
@WebServlet("/PiJiaController")
public class PiJiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PiJiaController() {
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
				jiaTiaoList = counselorService.getAllJiaTiao();
				break;
			case "sanctioned":
				jiaTiaoList = counselorService.getSanctionedJiaTiao();
				break;
			case "unsanctioned":
				jiaTiaoList = counselorService.getUnSanctionedJiaTiao();
				break;
			case "failed":
				jiaTiaoList = counselorService.getFailedJiaTiao();
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
			request.getRequestDispatcher("show/showJiaTiaoListByPage.jsp?range="+range).forward(request, response);
		}
		if (action.equalsIgnoreCase("deal")) {
			String result = request.getParameter("result");
			String idString = request.getParameter("id");
			Integer id = Integer.parseInt(idString);
			String stuNoString = request.getParameter("StuNo");
			Integer StuNo = Integer.parseInt(stuNoString);
			switch (result) {
			case "agree":
//				将假条的状态更新为批准
				counselorService.updateJiaTiaoStatus(id,1);
				//将学生的考勤状态改为请假  一代表同意
				counselorService.updateAttenStatus(StuNo, 1);
//				counselorService.update
				break;
			case "disagree":
//				将假条的状态更改为审核不通过
				counselorService.updateJiaTiaoStatus(id, 2);
				//不同意请假 将学生状态改为旷课  0代表不统一
				counselorService.updateAttenStatus(StuNo, 0);
				break;
			default:
				break;
			}
			
			//做转发  转发到哪里合适？？？？  先转发到所有假条的界面
			request.getRequestDispatcher("PiJiaController?action=search&range=all").forward(request, response);
		}
		

	}

}
