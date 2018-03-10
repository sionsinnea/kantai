package com.tibos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibos.factory.TaskFactory;

/**
 * Servlet implementation class DelTask
 */
@WebServlet("/DelTask")
public class DelTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");//设置响应的Mime类型
		PrintWriter out = response.getWriter();//取得out对象
		request.setCharacterEncoding("utf-8");//设置统一编码
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		boolean flag = TaskFactory.getTaskDAOInit().delTask(taskId);
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
