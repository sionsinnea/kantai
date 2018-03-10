package com.tibos.factory;

import com.tibos.dao.TaskDAO;
import com.tibos.proxy.TaskProxy;

public class TaskFactory{

	
	     public static TaskDAO getTaskDAOInit(){
	    	 return new TaskProxy();
	     }

	
}
