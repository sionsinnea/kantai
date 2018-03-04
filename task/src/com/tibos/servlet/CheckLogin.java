package com.tibos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibos.factory.AbstractFactory;
import com.tibos.factory.LoginFactory;
import com.tibos.pojo.StaffPOJO;



/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");//设置响应的Mime类型
		PrintWriter out = response.getWriter();//取得out对象
		request.setCharacterEncoding("utf-8");//设置统一编码
		String userName = request.getParameter("userName");//取得注册的用户名
		String password = request.getParameter("password");//取得注册的用户名
		 //获取登录工厂
		
	      StaffPOJO pojo = LoginFactory.getLoginDAOInit().login(userName, password);
		
			
		if(pojo !=  null) {
			HttpSession session = request.getSession(); 
			session.setAttribute("userid", pojo.getId());
			session.setAttribute("username", pojo.getName());
			session.setAttribute("pic", pojo.getPic());
			out.print("success");
		}else {
			out.print("error");
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
