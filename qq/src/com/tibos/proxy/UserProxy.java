package com.tibos.proxy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tibos.dao.LoginDAO;
import com.tibos.dao.UserDAO;
import com.tibos.dao.impl.LoginDAOImpl;
import com.tibos.dao.impl.UserDAOImpl;
import com.tibos.pojo.StaffDTO;
import com.tibos.pojo.StaffPOJO;
import com.tibos.util.GetConnection;



public class UserProxy implements UserDAO{
	public Connection conn;//数据库连接对象
	public UserDAOImpl impl;
	public UserProxy(){
		try {
			this.conn = GetConnection.getConn();
			this.impl = new UserDAOImpl(this.conn);
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
	public boolean updateUser(StaffPOJO staffpojo) {
		// TODO Auto-generated method stub
		boolean flag = impl.updateUser(staffpojo);
		return flag;
	}

	@Override
	public boolean uploadPic(int id, String pic) {
		// TODO Auto-generated method stub
		boolean flag = impl.uploadPic(id, pic);
		return flag;
	}

	@Override
	public List<Object> listUser(int pageindex,int pagesize,String searchname) {
		// TODO Auto-generated method stub
		List<Object> pojo = impl.listUser(pageindex,pagesize,searchname);
		return pojo;
	}

	@Override
	public int countpage() {
		// TODO Auto-generated method stub
		int count = impl.countpage();
		return count;
	}

	@Override
	public boolean insUser(StaffDTO staffdto) {
		// TODO Auto-generated method stub
		boolean flag = impl.insUser(staffdto);
		return flag;
	}

	@Override
	public boolean delUser(int delid) {
		// TODO Auto-generated method stub
		boolean flag = impl.delUser(delid);
		return flag;
	}

	@Override
	public boolean updStaff(StaffDTO StaffDTO) {
		// TODO Auto-generated method stub
		boolean flag = impl.updStaff(StaffDTO);
		return flag;
	}

	
	
}
