package com.tibos.dao;

import java.util.List;

import com.tibos.pojo.StaffDTO;
import com.tibos.pojo.StaffPOJO;
import com.tibos.pojo.UserDTO;

public interface UserDAO {
	public boolean updateUser(StaffPOJO staffpojo);
	
	public boolean uploadPic(int id,String pic);
	
	public List<Object> listUser(int pageindex,int pagesize,String searchname);
	
	public boolean insUser(StaffDTO staffdto);
	
	public boolean delUser(int delid);
	
	public int countpage();
	
	public boolean updStaff(UserDTO staffdto);
}
