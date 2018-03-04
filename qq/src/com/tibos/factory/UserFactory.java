package com.tibos.factory;

import com.tibos.dao.UserDAO;
import com.tibos.proxy.UserProxy;

public class UserFactory{

	
	     public static UserDAO getUserDAOInit(){
	    	 return new UserProxy();
	     }

	
}
