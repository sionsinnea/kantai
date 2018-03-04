package com.tibos.dao;

import com.tibos.pojo.StaffPOJO;

public interface LoginDAO {
	public StaffPOJO login(String userName,String password);
}
