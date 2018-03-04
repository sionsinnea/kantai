package com.tibos.proxy;

import java.sql.Connection;
import java.sql.SQLException;

import com.tibos.dao.LoginDAO;
import com.tibos.dao.impl.LoginDAOImpl;
import com.tibos.pojo.StaffPOJO;
import com.tibos.util.GetConnection;



public class LoginProxy implements LoginDAO{
	public Connection conn;//数据库连接对象
	public LoginDAOImpl impl;
	public LoginProxy(){
		try {
			this.conn = GetConnection.getConn();
			this.impl = new LoginDAOImpl(this.conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void close(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public StaffPOJO login(String userName, String password) {
		// TODO Auto-generated method stub\
		StaffPOJO pojo = impl.login(userName, password);
		this.close();
		return pojo;
	}

}
