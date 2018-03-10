package com.tibos.proxy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tibos.dao.MessageDAO;
import com.tibos.dao.impl.MessageDAOImpl;
import com.tibos.pojo.MessageDTO;
import com.tibos.util.GetConnection;

public class MessageProxy implements MessageDAO{
	public Connection conn;//数据库连接对象
	public MessageDAOImpl impl;
	public MessageProxy(){
		try {
			this.conn = GetConnection.getConn();
			this.impl = new MessageDAOImpl(this.conn);
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
	public List<Object> listMessage(int page) {
		// TODO Auto-generated method stub
		List<Object> dto = impl.listMessage(page);
		return dto;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int num = impl.count();
		return num;
	}

	@Override
	public boolean insMessage(int userid, String info, String addtime) {
		// TODO Auto-generated method stub
		boolean flag = impl.insMessage(userid, info, addtime);
		return flag;
	}

}
