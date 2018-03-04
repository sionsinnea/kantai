package com.tibos.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

	
import org.lxh.smart.SmartUpload;
import org.lxh.smart.SmartUploadException;

import com.tibos.factory.LoginFactory;
import com.tibos.factory.UserFactory;
import com.tibos.pojo.FileName;
import com.tibos.pojo.StaffPOJO;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String ip = request.getRemoteAddr();
		    ip = ip.replaceAll(":","");
		    ip="1";
		    FileName f = new FileName(ip);
		    String autoFileName = f.getFileName();
		    request.setCharacterEncoding("utf-8");
		    request.getParameter("name");
		    SmartUpload smartupload = new SmartUpload();
		    JspFactory fac = JspFactory.getDefaultFactory();
		    PageContext pageContext = fac.getPageContext(this,request,response,null,false,8192,true);
		    smartupload.initialize(pageContext);
		    
		    try {
				smartupload.upload();
				
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    String endName = smartupload.getFiles().getFile(0).getFileExt();
		    String fileName = request.getSession().getServletContext().getRealPath("images")+"/"+autoFileName+"."+endName;
		    try {
				smartupload.getFiles().getFile(0).saveAs(fileName);
				  
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		    String pic = "images/"+autoFileName + "." + endName ;
//		    HttpSession session = request.getSession(); 
//		    int id = (Integer)session.getAttribute("userid");
//		    boolean flag = UserFactory.getUserDAOInit().uploadPic(id, pic);
//		    if(flag == true) {
//		    	session.setAttribute("pic", pic);
//		    }
		    response.setCharacterEncoding("UTF-8");
			   PrintWriter out = response.getWriter();
			   out.println(autoFileName);
		     
	}
		    
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
