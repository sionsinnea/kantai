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

import com.tibos.factory.TaskFactory;
import com.tibos.factory.UserFactory;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ListTask
 */
@WebServlet("/ListTask")
public class ListTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");//������Ӧ��Mime����
		PrintWriter out = response.getWriter();//ȡ��out����
		request.setCharacterEncoding("utf-8");//����ͳһ����
		String id  = request.getParameter("taskno");

		int pageindex = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("limit"));
		List<Object> list = TaskFactory.getTaskDAOInit().listTask(pageindex, pagesize, id);
		int count = TaskFactory.getTaskDAOInit().countTask();
		Map<String , Object> stu = new HashMap<String, Object>();
		stu.put("code", 0);
		stu.put("msg", "��ȡ�ɹ�");
		stu.put("data", list);
		stu.put("count", count);
		JSONObject jsonObject = JSONObject.fromObject(stu);  
//		JSONArray json =JSONArray.fromObject(stu);
	    
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
