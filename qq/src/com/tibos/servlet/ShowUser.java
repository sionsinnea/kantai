package com.tibos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibos.factory.UserFactory;
import com.tibos.pojo.StaffPOJO;
import com.tibos.util.DTOBuilder;
import com.util.Testflect;

/**
 * Servlet implementation class ShowUser
 */
@WebServlet("/ShowUser")
public class ShowUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		StaffPOJO staffpojo = (StaffPOJO)DTOBuilder.getDTO(request, StaffPOJO.class);
		
		response.setContentType("text/html; charset=utf-8");//设置响应的Mime类型
		PrintWriter out = response.getWriter();//取得out对象
		request.setCharacterEncoding("utf-8");//设置统一编码
		
		boolean flag = UserFactory.getUserDAOInit().updateUser(staffpojo);
		
		
		if(flag ==  true) {
			HttpSession session = request.getSession(); 
			session.setAttribute("username", staffpojo.getUserName());
			if(staffpojo.getPic() != null) {
				session.setAttribute("pic", "images/"+staffpojo.getPic());
			}
			session.setAttribute("password", staffpojo.getPassword());
			session.setAttribute("name", staffpojo.getName());
			session.setAttribute("age", staffpojo.getAge());
			session.setAttribute("address", staffpojo.getAddress());
			session.setAttribute("phone", staffpojo.getPhone());
			session.setAttribute("sex", staffpojo.getSex());
			
		}
		
		
		out.print(flag);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
