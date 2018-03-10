package com.tibos.dao;

import java.util.List;


public interface MessageDAO {
	
	public  List<Object> listMessage(int page);
	
	public int count();
	
	public boolean insMessage(int userid,String info,String addtime);

}
