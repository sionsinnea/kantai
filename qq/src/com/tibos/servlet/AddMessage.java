package com.tibos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibos.factory.MessageFactory;


/**
 * Servlet implementation class AddMessage
 */
@WebServlet("/AddMessage")
public class AddMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");//设置响应的Mime类型
		PrintWriter out = response.getWriter();//取得out对象
		request.setCharacterEncoding("utf-8");//设置统一编码
		String info = request.getParameter("textinfo");
		HttpSession session = request.getSession(); 
		int userid = (int)session.getAttribute("userid");
		Date date = new Date();
		DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String addtime  = df2.format(date);
		boolean flag = MessageFactory.getMessageDAOInit().insMessage(userid, info, addtime);
		out.println(flag);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
