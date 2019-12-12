package com.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.MyFile;


/**
 * Servlet implementation class FileServlet
 */
//@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileServlet() {
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
		MyFile myFile;
		String filePath;
		String fileName;
		long fileLength;
		String fileContent;
		HttpSession session;
		
		myFile = new MyFile();
		fileName = request.getParameter("fileName");
		filePath = request.getParameter("filePath");
//		System.out.println(request.getContextPath());
//		System.out.println();
		try {
//			File file = new File(request.getContextPath() + "/files/file.txt");
			File file = new File(filePath+fileName);
			fileLength = file.length();
			FileReader reader = new FileReader(file); 
			BufferedReader bufferedReader = new BufferedReader(reader);
			StringBuffer stringBuffer  = new StringBuffer();
			String string = null;
			while ((string = bufferedReader.readLine()) != null) {
				stringBuffer.append("\n"+string);
			}
//			将数据封装到myFile对象中
			fileContent = new String(stringBuffer);
			myFile.setFileName(fileName);
			myFile.setFilePath(filePath);
			myFile.setFileLength(fileLength);
			myFile.setFileContent(fileContent);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(myFile.getFileName());
//		session = request.getSession();
//		session.setAttribute("myFile", myFile);
//		response.sendRedirect("files/showFile.jsp");
		request.setAttribute("myFile", myFile);
//		request.getRequestDispatcher("files/showFile.jsp").forward(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("files/showFile.jsp");
		rd.forward(request, response);
	}

}
