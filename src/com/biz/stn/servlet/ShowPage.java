package com.biz.stn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.stn.util.DBconn;

/**
 * Servlet implementation class ShowPage
 */
@WebServlet("/ShowPage")
public class ShowPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBconn initJedis = new DBconn();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List stns = initJedis.getAllStn();
		if(stns.size()>-1&&stns!=null){
			request.setAttribute("stns", stns);
		}else{
			request.setAttribute("stns", "¿ÕÊý¾Ý£¡");
		}
		request.getRequestDispatcher("WEB-INF/shouwInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
