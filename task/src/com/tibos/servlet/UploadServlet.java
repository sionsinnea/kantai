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
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.lxh.smart.SmartUpload;
import org.lxh.smart.SmartUploadException;

import com.tibos.pojo.FileName;


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
		    ip="23";
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
		   System.out.println(fileName);
		     
	}
		    
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
