package com.tibos.dao;

import java.util.List;

import com.tibos.pojo.TaskInsDTO;
import com.tibos.pojo.TaskLogDTO;
import com.tibos.pojo.UpdTaskDTO;
import com.tibos.pojo.UpdTaskLogDTO;

public interface TaskDAO {
	
		public boolean insTask(TaskInsDTO dto);
		
		public List<Object> listTask(int pageindex,int pagesize,String id);
		
		public int  countTask();
		
		public boolean  delTask(int taskId);
		
		public boolean insTaskLog(TaskLogDTO dto);
		
		public boolean updTask(UpdTaskDTO dto);
		
		public List<Object> listTaskLog(int pageindex,int pagesize,int taskId);
		
		public int countTaskLog(int taskId);
		
		public boolean delTaskLog(int taskLogId);
		
		public boolean updTaskLog(UpdTaskLogDTO dto);
		
		public List<Object> listMyTask(int pageindex,int pagesize,int deptId);
		
		public int countMyTask(int deptId);
		
		public boolean startTask(int taskId);
		
		public boolean doneTask(int taskLogId);
		
		public int countUnDo(int taskId);
		
		public boolean overTask(int taskId);
		
		public List<Object> ListAll(int pageindex,int pagesize,String taskno);
}
