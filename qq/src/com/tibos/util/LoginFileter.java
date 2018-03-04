package com.tibos.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFileter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 HttpServletRequest req = (HttpServletRequest)arg0;
	        HttpServletResponse resp =(HttpServletResponse) arg1;
	        HttpSession session = req.getSession();
	           // ����û������URI
	        String path = req.getRequestURI();
	        // ��sessionȡ���Ѿ���¼��֤��ƾ֤ �������demo�õ���password����Ϊ��¼ƾ֤
	        String password = (String) session.getAttribute("account");
	        // login.jspҳ���������(�����Լ���Ŀ��Ҫ����)

	        //Ҳ����path.contains("login.jsp")  ������ô��ȷ��ô���Ͳ���˵��
	        if(path.indexOf("/login.jsp") > -1) {//ע�⣺��¼ҳ��ǧ���ܹ���  ��Ȼ�������͡������������е��Բ�Ҫ͵���������������
	            arg2.doFilter(req, resp);
	            return;
	        } else {//�������login.jsp���й���
	        	if (password == null || "".equals(password)) {
	            	// ��ת����½ҳ��
	            	resp.sendRedirect("login.jsp");
	            } else {
	                // �Ѿ���½,�����˴�����
	                arg2.doFilter(req, resp);
	            }
	        }
	}

}
