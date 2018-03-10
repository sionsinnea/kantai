package com.tibos.proxy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tibos.dao.TaskDAO;
import com.tibos.dao.impl.TaskDAOImpl;
import com.tibos.pojo.TaskInsDTO;
import com.tibos.pojo.TaskLogDTO;
import com.tibos.pojo.UpdTaskDTO;
import com.tibos.pojo.UpdTaskLogDTO;
import com.tibos.util.GetConnection;

public class TaskProxy implements TaskDAO {
	public Connection conn;//数据库连接对象
	public TaskDAOImpl impl;
	public TaskProxy(){
		try {
			this.conn = GetConnection.getConn();
			this.impl = new TaskDAOImpl(this.conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void close(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean insTask(TaskInsDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = impl.insTask(dto);
		return flag;
	}

	@Override
	public List<Object> listTask(int pageindex, int pagesize, String id) {
		// TODO Auto-generated method stub
		List<Object> list = impl.listTask(pageindex, pagesize, id);
		return list;
	}

	@Override
	public int countTask() {
		// TODO Auto-generated method stub
		int count = impl.countTask();
		return count;
	}

	@Override
	public boolean delTask(int taskId) {
		// TODO Auto-generated method stub
		boolean flag = impl.delTask(taskId);
		return flag;
	}

	@Override
	public boolean insTaskLog(TaskLogDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = impl.insTaskLog(dto);
		return flag;
	}

	@Override
	public boolean updTask(UpdTaskDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = impl.updTask(dto);
		return flag;
	}

	@Override
	public List<Object> listTaskLog(int pageindex, int pagesize, int taskId) {
		// TODO Auto-generated method stub
		List<Object> list = impl.listTaskLog(pageindex, pagesize, taskId);
		return list;
	}

	@Override
	public int countTaskLog(int taskId) {
		// TODO Auto-generated method stub
		int count = impl.countTaskLog(taskId);
		return count;
	}

	@Override
	public boolean delTaskLog(int taskLogId) {
		// TODO Auto-generated method stub
		boolean flag = impl.delTaskLog(taskLogId);
		return flag;
	}

	@Override
	public boolean updTaskLog(UpdTaskLogDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = impl.updTaskLog(dto);
		return flag;
	}

	@Override
	public List<Object> listMyTask(int pageindex, int pagesize, int deptId) {
		// TODO Auto-generated method stub
		List<Object> list = impl.listMyTask(pageindex, pagesize, deptId);
		return list;
	}

	@Override
	public int countMyTask(int deptId) {
		// TODO Auto-generated method stub
		 int count  = impl.countMyTask(deptId);
		return count;
	}

	@Override
	public boolean startTask(int taskId) {
		// TODO Auto-generated method stub
		boolean flag = impl.startTask(taskId);
		return flag;
	}

	@Override
	public boolean doneTask(int taskLogId) {
		// TODO Auto-generated method stub
		boolean flag = impl.doneTask(taskLogId);
		return flag;
	}

	@Override
	public int countUnDo(int taskId) {
		// TODO Auto-generated method stub
		int count = impl.countUnDo(taskId);
		return count;
	}

	@Override
	public boolean overTask(int taskId) {
		// TODO Auto-generated method stub
		boolean flag = impl.overTask(taskId);
		return flag;
	}

	@Override
	public List<Object> ListAll(int pageindex, int pagesize, String taskno) {
		// TODO Auto-generated method stub
		List<Object> list = impl.ListAll(pageindex, pagesize, taskno);
		return list;
	}

}
