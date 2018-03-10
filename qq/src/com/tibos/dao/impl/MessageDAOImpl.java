package com.tibos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tibos.dao.MessageDAO;
import com.tibos.pojo.MessageDTO;

public class MessageDAOImpl implements MessageDAO {
	public Connection conn ;
	public MessageDAOImpl(Connection conn){
		this.conn = conn;
	}
	@Override
	public List<Object> listMessage(int page) {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		ResultSet res =null;
		List<Object> list = new ArrayList<Object>();
		page = (page-1)*4;
		try {
							
			String sql = "SELECT m.message_id,s.`name`,m.info,m.addtime FROM message m LEFT JOIN staff s "+
			" on m.staff_id = s.id ORDER BY m.addtime desc LIMIT ?,4  ";
			pstate = this.conn.prepareStatement(sql);
			pstate.setInt(1, page);
			res = pstate.executeQuery();
			while(res.next()){

				MessageDTO	dto = new MessageDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4));
				list.add(dto);
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
		return list;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		ResultSet res =null;
		int num = 0;
		try {
			
			String sql = " select count(*) from message ";
			pstate = this.conn.prepareStatement(sql);
			res = pstate.executeQuery();
			if(res.next()) {
				num = res.getInt(1);
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
		return num;
	}
	@Override
	public boolean insMessage(int userid, String info, String addtime) {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		boolean flag = false;
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			String sql = " insert into message (staff_id,info,addtime) value (?,?,?)";
			pstate = this.conn.prepareStatement(sql);
			pstate.setInt(1, userid);
			pstate.setString(2, info);
			pstate.setString(3, addtime);
			pstate.execute();
			this.conn.commit();//提交
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			try {
				pstate.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}

}
