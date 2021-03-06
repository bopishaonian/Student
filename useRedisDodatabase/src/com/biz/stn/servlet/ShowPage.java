package com.biz.stn.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.stn.pojo.Page;
import com.biz.stn.pojo.Student;
import com.biz.stn.util.DBconn;

/**
 * Servlet implementation class ShowPage
 */
@WebServlet("/ShowPage")
public class ShowPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		DBconn initJedis = new DBconn();
		
		if(request.getParameter("nowPage")==null){
			
			Page page = initJedis.getSomeStnList("1");

			request.setAttribute("page", page);

			request.getRequestDispatcher("WEB-INF/shouwInfo.jsp").forward(request, response);
		}else{
			String str = request.getParameter("nowPage");
			
			Page page = initJedis.getSomeStnList(str);

			request.setAttribute("page", page);

			request.getRequestDispatcher("WEB-INF/shouwInfo.jsp").forward(request, response);	
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
