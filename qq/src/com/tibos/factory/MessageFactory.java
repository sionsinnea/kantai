package com.tibos.factory;

import com.tibos.dao.MessageDAO;
import com.tibos.proxy.MessageProxy;

public class MessageFactory{

	
	     public static MessageDAO getMessageDAOInit(){
	    	 return new MessageProxy();
	     }

	
}
