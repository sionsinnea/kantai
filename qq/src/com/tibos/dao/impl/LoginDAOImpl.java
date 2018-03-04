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
							
			String sql = "select id , name , pic , userName , password , age , address , phone , sex , deg_id from staff where username = ? and password = ? ";
			pstate = this.conn.prepareStatement(sql);
			pstate.setString(1, userName);
			pstate.setString(2, password);
			res = pstate.executeQuery();
			if(res.next()){
				 pojo = new StaffPOJO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getInt(6),res.getString(7),res.getString(8),res.getString(9),res.getInt(10));
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
