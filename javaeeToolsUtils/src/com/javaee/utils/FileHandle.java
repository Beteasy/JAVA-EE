package com.javaee.utils;

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

import com.javaee.bean.FileMessage;


/**
 * Servlet implementation class FileHandle
 */
@WebServlet("/FileHandle")
public class FileHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileHandle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FileMessage file = new FileMessage();
		request.setAttribute("file", file);
		String filePath=request.getParameter("filePath");
		String fileName=request.getParameter("fileName");
		file.setFilePath(filePath);
		file.setFileName(fileName);
		try {
			File f = new File(filePath,fileName);
			long length = f.length();
			file.setFileLength(length);
			FileReader in=new FileReader(f);
			BufferedReader inBuffer = new BufferedReader(in);
			StringBuffer stringBuffer = new StringBuffer();
			String string = null;
			while ((string=inBuffer.readLine())!=null) {
				stringBuffer.append("<br />"+string);
			}
			String content = new String(stringBuffer);
			file.setFileContent(content);
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("files/showFile.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
