package com.tibos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tibos.dao.UserDAO;
import com.tibos.pojo.StaffDTO;
import com.tibos.pojo.StaffPOJO;
import com.tibos.pojo.UserDTO;


public class UserDAOImpl implements UserDAO{
	public Connection conn ;
	public UserDAOImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public boolean updateUser(StaffPOJO staffpojo) {
		boolean flag = false;
		PreparedStatement pstate = null;
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			if(staffpojo.getPic() !=null) {
				String sql = " update staff set username = ? , password = ? ,name = ? ," +
						" age = ? , phone = ? , address = ? , pic = ? , sex = ? where id = ? ";
						pstate = this.conn.prepareStatement(sql);	
						pstate.setString(1, staffpojo.getUserName());
						pstate.setString(2, staffpojo.getPassword());
						pstate.setString(3, staffpojo.getName());
						pstate.setInt(4, staffpojo.getAge());
						pstate.setString(5, staffpojo.getPhone());
						pstate.setString(6, staffpojo.getAddress());
						pstate.setString(7, "images/"+staffpojo.getPic());
						pstate.setString(8, staffpojo.getSex());
						pstate.setInt(9, staffpojo.getId());
			}else {
				String sql = " update staff set username = ? , password = ? ,name = ? ," +
						" age = ? , phone = ? , address = ? , sex = ? where id = ? ";
						pstate = this.conn.prepareStatement(sql);	
						pstate.setString(1, staffpojo.getUserName());
						pstate.setString(2, staffpojo.getPassword());
						pstate.setString(3, staffpojo.getName());
						pstate.setInt(4, staffpojo.getAge());
						pstate.setString(5, staffpojo.getPhone());
						pstate.setString(6, staffpojo.getAddress());
						pstate.setString(7, staffpojo.getSex());
						pstate.setInt(8, staffpojo.getId());
			}
			
			pstate.execute();
			
			this.conn.commit();//提交
			flag = true;
		} catch (Exception e) {
			try {
				this.conn.rollback();
			} catch (Exception e2) {
			}
			e.printStackTrace();
		} finally {
			try {
				pstate.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean uploadPic(int id, String pic) {
		boolean flag = false;
		PreparedStatement pstate = null;
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			String sql = " update staff set pic = ? where id = ? ";
			pstate = this.conn.prepareStatement(sql);	
			pstate.setString(1, pic);
			pstate.setInt(2,id);
			pstate.execute();
			this.conn.commit();//提交
			flag = true;
		} catch (Exception e) {
			try {
				this.conn.rollback();
			} catch (Exception e2) {
			}
			e.printStackTrace();
		} finally {
			try {
				pstate.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public List<Object> listUser(int pageindex,int pagesize,String searchname) {
		PreparedStatement pstate = null;
		ResultSet res =null;
		List<Object> list = new ArrayList<Object>();
		pageindex = (pageindex-1)*pagesize;
		try {
							
			String sql = "select s.id , s.name  , s.age , s.address , s.phone , s.sex ,d.name,g.deg_name, "+
			"s.dept_id,s.deg_id  from staff s,dept d, degrade g where s.dept_id = d.dept_id "+
					" and s.deg_id = g.deg_id and is_del = 'on'  and s.name like ? limit ?,? ";
			pstate = this.conn.prepareStatement(sql);
			pstate.setString(1, "%"+searchname+"%");
			pstate.setInt(2, pageindex);
			pstate.setInt(3, pagesize);
			res = pstate.executeQuery();
			while(res.next()){
				UserDTO dto = new UserDTO(res.getInt(1),res.getString(2),res.getInt(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getInt(9),res.getInt(10));
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
	public int countpage() {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		ResultSet res =null;
		int count = 0;
		try {
							
			String sql = "select count(*) from staff ";
			pstate = this.conn.prepareStatement(sql);
			res = pstate.executeQuery();
			while(res.next()){
				count = res.getInt(1);
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
		return count;
	}

	@Override
	public boolean insUser(StaffDTO staffdto) {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstate = null;
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			StringBuilder sql = new StringBuilder();
			if(staffdto.getIs_del() != null) {
				 sql.append(" insert into staff (name,age,phone,address,sex,username,password,dept_Id,deg_Id,is_del) values "); 
				 sql.append("(?,?,?,?,?,?,?,?,?,?)");
			}else {
				 sql.append(" insert into staff (name,age,phone,address,sex,username,password,dept_Id,deg_Id) values "); 
				 sql.append("(?,?,?,?,?,?,?,?,?)");
			}
			pstate = this.conn.prepareStatement(sql.toString());	
			pstate.setString(1, staffdto.getName());
			pstate.setInt(2,staffdto.getAge());
			pstate.setString(3, staffdto.getPhone());
			pstate.setString(4, staffdto.getAddress());
			pstate.setString(5, staffdto.getSex());
			pstate.setString(6, staffdto.getName());
			pstate.setString(7, staffdto.getName());
			pstate.setInt(8, staffdto.getDeptId());
			pstate.setInt(9, staffdto.getDegId());
			if(staffdto.getIs_del() != null) {
			pstate.setString(10, staffdto.getIs_del());
			}
			pstate.execute();
			this.conn.commit();//提交
			flag = true;
		} catch (Exception e) {
			try {
				this.conn.rollback();
			} catch (Exception e2) {
			}
			e.printStackTrace();
		} finally {
			try {
				pstate.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean delUser(int delid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstate = null;
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			
			String sql = "update staff set is_del ='' where id = ?";
			pstate = this.conn.prepareStatement(sql);	
			pstate.setInt(1, delid);
			
			pstate.execute();
			this.conn.commit();//提交
			flag = true;
		} catch (Exception e) {
			try {
				this.conn.rollback();
			} catch (Exception e2) {
			}
			e.printStackTrace();
		} finally {
			try {
				pstate.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean updStaff(UserDTO userdto) {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstate = null;
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			
				String sql = " update staff set name = ? , age = ? , phone = ? , address = ? , sex = ? ,dept_id = ? , deg_id = ? where id = ? ";
						pstate = this.conn.prepareStatement(sql);	
					
						pstate.setString(1, userdto.getName());
						pstate.setInt(2, userdto.getAge());
						pstate.setString(3, userdto.getPhone());
						pstate.setString(4, userdto.getAddress());
						pstate.setString(5, userdto.getSex());
						pstate.setInt(6, userdto.getDeptId());
						pstate.setInt(7, userdto.getDegId());
						pstate.setInt(8, userdto.getId());
			
			
			pstate.execute();
			
			this.conn.commit();//提交
			flag = true;
		} catch (Exception e) {
			try {
				this.conn.rollback();
			} catch (Exception e2) {
			}
			e.printStackTrace();
		} finally {
			try {
				pstate.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}	
	
}
