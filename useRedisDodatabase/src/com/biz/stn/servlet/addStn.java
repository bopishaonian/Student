package com.biz.stn.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.biz.stn.pojo.Student;
import com.biz.stn.util.DBconn;
import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Servlet implementation class addStn
 */
@WebServlet("/addStn")
public class addStn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		DBconn db = new DBconn();
		Student stn = new Student();
		
		
		
		
		
		
	
		//验证id是否重复
		if(db.checkStn_id(request.getParameter("stn_id"))){
			request.setAttribute("flag", 0);
			//指定日期字符串的格式
			SimpleDateFormat  formatter= new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				//将取出来的出生日期字符串转成Date类型存入stn
				Date date = formatter.parse(request.getParameter("stn_birthday"));
				stn.setStn_id(request.getParameter("stn_id"));
				stn.setStn_name(request.getParameter("stn_name"));
				stn.setStn_birthday(date);
				stn.setStn_description(request.getParameter("stn_description"));
				stn.setStn_avgscore(Integer.valueOf(request.getParameter("stn_avgscore")).intValue());
				if(stn==null){
					request.setAttribute("error", "数据不能为空");
					request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
					
				}else{
					db.addStn(stn);
					response.sendRedirect("ShowPage");
				
				}
				} catch (ParseException e){
					e.printStackTrace();
				}
			
		}else{
				
				request.setAttribute("flag", 1);
				request.getRequestDispatcher("WEB-INF/addStn.jsp").forward(request, response);
		}
		
}
	

}
