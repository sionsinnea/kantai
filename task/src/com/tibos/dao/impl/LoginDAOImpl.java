package com.tibos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tibos.dao.LoginDAO;
import com.tibos.pojo.StaffPOJO;


public class LoginDAOImpl implements LoginDAO {
	public Connection conn ;
	public LoginDAOImpl(Connection conn){
		this.conn = conn;
	}
	@Override
	public StaffPOJO login(String userName, String password) {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		ResultSet res =null;
		StaffPOJO pojo = null;
		try {
							
			String sql = "select id , name , pic from staff where username = ? and password = ? ";
			pstate = this.conn.prepareStatement(sql);
			pstate.setString(1, userName);
			pstate.setString(2, password);
			res = pstate.executeQuery();
			if(res.next()){
				 pojo = new StaffPOJO(res.getInt(1),res.getString(2),res.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			try {
				res.close();
				pstate.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return pojo;
	}

}
