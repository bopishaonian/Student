package com.biz.stn.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.stn.pojo.Student;
import com.biz.stn.util.DBconn;

/**
 * Servlet implementation class editStn
 */
@WebServlet("/editStn")
public class editStn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editStn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");
			DBconn db = new DBconn();
			Student stn = new Student();
			
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
			Date date = formatter.parse(request.getParameter("stn_birthday"));
			
			
			stn.setStn_id(request.getParameter("stn_id"));
			stn.setStn_name(request.getParameter("stn_name"));
			stn.setStn_birthday(date);
			stn.setStn_description(request.getParameter("stn_description"));
			stn.setStn_avgscore(Integer.valueOf(request.getParameter("stn_avgscore")).intValue());
			
			db.editStn(stn);
			
			response.sendRedirect("ShowPage");
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
