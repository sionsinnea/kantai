package com.tibos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibos.factory.MessageFactory;

import net.sf.json.JSONObject;








/**
 * Servlet implementation class ShowMessage
 */
@WebServlet("/ShowMessage")
public class ShowMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");//设置响应的Mime类型
		PrintWriter out = response.getWriter();//取得out对象
		request.setCharacterEncoding("utf-8");//设置统一编码
		int page = Integer.parseInt(request.getParameter("page"));
		List<Object> list = MessageFactory.getMessageDAOInit().listMessage(page);
		int count = MessageFactory.getMessageDAOInit().count();
		double pages = Math.ceil(count/4);
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pages", pages);
		JSONObject jsonObject = JSONObject.fromObject(map);
		out.print(jsonObject);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
