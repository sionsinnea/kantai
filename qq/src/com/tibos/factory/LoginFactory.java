package com.tibos.factory;

import com.tibos.dao.LoginDAO;
import com.tibos.proxy.LoginProxy;

public class LoginFactory{

	
	     public static LoginDAO getLoginDAOInit(){
	    	 return new LoginProxy();
	     }

	
}
