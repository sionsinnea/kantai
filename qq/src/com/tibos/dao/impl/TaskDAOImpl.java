package com.tibos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tibos.dao.TaskDAO;
import com.tibos.pojo.ShowAllTaskDTO;
import com.tibos.pojo.TaskInsDTO;
import com.tibos.pojo.TaskList;
import com.tibos.pojo.TaskLogDTO;
import com.tibos.pojo.TaskLogVO;
import com.tibos.pojo.TaskingVO;
import com.tibos.pojo.UpdTaskDTO;
import com.tibos.pojo.UpdTaskLogDTO;

public class TaskDAOImpl implements TaskDAO {
	public Connection conn ;
	public TaskDAOImpl(Connection conn){
		this.conn = conn;
	}
	@Override
	public boolean insTask(TaskInsDTO dto) {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		boolean flag = false;
		Date date = new Date();
		DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String creattime  = df2.format(date);
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			String sql = " insert into task (name,detail,is_del,dept_id,createtime,status,taskno) value (?,?,?,?,?,0,?)";
			pstate = this.conn.prepareStatement(sql);
			pstate.setString(1, dto.getName());
			pstate.setString(2, dto.getDetail());
			pstate.setString(3, dto.getIs_del());
			pstate.setInt(4, dto.getDeptId());
			pstate.setString(5, creattime);
			pstate.setString(6, dto.getTaskno());
			pstate.execute();
			this.conn.commit();//提交
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			try {
				pstate.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		return flag;
	}
	@Override
	public List<Object> listTask(int pageindex, int pagesize, String id) {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		ResultSet res =null;
		List<Object> list = new ArrayList<Object>();
		pageindex = (pageindex-1)*pagesize;
		if(id ==null) {
			id = "";
		}
		try {
							
			String sql = "SELECT t.task_id,t.`name`,t.detail,t.`status`,t.createtime,d.`name`,t.dept_id ,t.taskno "+
			"from task t , dept d where t.dept_id = d.dept_id and is_del = 'on'  and t.taskno like ? ORDER BY t.createtime limit ?,?";
			pstate = this.conn.prepareStatement(sql);
			pstate.setString(1, "%"+id+"%");
			pstate.setInt(2, pageindex);
			pstate.setInt(3, pagesize);
			res = pstate.executeQuery();
			while(res.next()){
				TaskList dto = new TaskList(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8));
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
	public int countTask() {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		ResultSet res =null;
		int count = 0;
	
		try {
							
			String sql = "select count(*) from task where is_del ='on' ";
			pstate = this.conn.prepareStatement(sql);
			res = pstate.executeQuery();
			if(res.next()) {
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
	public boolean delTask(int taskId) {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstate = null;
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			
			String sql = "update task set is_del ='' where task_id = ?";
			pstate = this.conn.prepareStatement(sql);	
			pstate.setInt(1, taskId);
			
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
	public boolean insTaskLog(TaskLogDTO dto) {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		boolean flag = false;
		Date date = new Date();
		DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String creattime  = df2.format(date);
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			String sql = " insert into task_log (task_id,name,detail,status,level,createtime) value (?,?,?,0,?,?)";
			pstate = this.conn.prepareStatement(sql);
			pstate.setInt(1, dto.getTaskId());
			pstate.setString(2, dto.getName());
			pstate.setString(3, dto.getDetail());
			pstate.setInt(4, dto.getLevel());
			pstate.setString(5, creattime);
			
			pstate.execute();
			this.conn.commit();//提交
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			try {
				pstate.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		return flag;
	}
	@Override
	public boolean updTask(UpdTaskDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstate = null;
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			
				String sql = " update task set taskno = ? , name = ? ,detail = ? ," +
						" dept_id = ?  where task_id = ? ";
						pstate = this.conn.prepareStatement(sql);	
						pstate.setString(1, dto.getTaskno());
						pstate.setString(2, dto.getName());
						pstate.setString(3, dto.getDetail());
						pstate.setInt(4, dto.getDeptId());
						pstate.setInt(5, dto.getTaskId());
					
	
			
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
	public List<Object> listTaskLog(int pageindex, int pagesize, int taskId) {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		ResultSet res =null;
		List<Object> list = new ArrayList<Object>();
		pageindex = (pageindex-1)*pagesize;
	
		try {
							
			String sql = "select l.task_log_id ,t.taskno ,l.`name` ,l.detail,l.`status`,l.`level`,l.createtime from task t , task_log l " + 
					"where t.task_id = l.task_id AND l.task_id = ?  ORDER BY t.taskno ASC,l.`level` ASC,l.task_log_id ASC ,l.createtime ASC limit ?,?";
			pstate = this.conn.prepareStatement(sql);
			pstate.setInt(1, taskId);
			pstate.setInt(2, pageindex);
			pstate.setInt(3, pagesize);
			res = pstate.executeQuery();
			while(res.next()){
				TaskLogVO vo = new TaskLogVO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6),res.getString(7));
				list.add(vo);
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
	public int countTaskLog(int taskId) {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		ResultSet res =null;
		int count = 0;
	
		try {
							
			String sql = "select count(*) from task_log where task_id = ? ";
			pstate = this.conn.prepareStatement(sql);
			pstate.setInt(1, taskId);
			res = pstate.executeQuery();
			if(res.next()) {
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
	public boolean delTaskLog(int taskLogId) {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstate = null;
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			
			String sql = "delete from task_log where task_log_id = ? ";
			pstate = this.conn.prepareStatement(sql);	
			pstate.setInt(1, taskLogId);
			
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
	public boolean updTaskLog(UpdTaskLogDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstate = null;
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			
				String sql = " update task_log set name = ? , level = ? ,detail = ?  where task_log_id = ? ";
						pstate = this.conn.prepareStatement(sql);	
						pstate.setString(1, dto.getName());
						pstate.setInt(2, dto.getLevel());
						pstate.setString(3, dto.getDetail());
						pstate.setInt(4, dto.getTaskLogId());
					
	
			
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
	public List<Object> listMyTask(int pageindex, int pagesize, int deptId) {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		ResultSet res =null;
		List<Object> list = new ArrayList<Object>();
		pageindex = (pageindex-1)*pagesize;
	
		try {
							
			String sql = "select t.taskno  ,l.task_log_id ,l.`name` ,l.detail,l.`level` , l.createtime ,t.task_id from task t, task_log l WHERE " + 
					"t.task_id = l.task_id and t.dept_id = ? and t.status = '10' and  l.status = '0' ORDER BY l.`level` ASC,l.createtime ASC ,t.taskno ASC ,t.task_id ASC LIMIT ?,?";
			pstate = this.conn.prepareStatement(sql);
			pstate.setInt(1, deptId);
			pstate.setInt(2, pageindex);
			pstate.setInt(3, pagesize);
			res = pstate.executeQuery();
			while(res.next()){
				TaskingVO vo = new TaskingVO(res.getString(1)+"-"+res.getInt(2),res.getString(3),res.getString(4),res.getInt(5),res.getString(6),res.getInt(7));
				list.add(vo);
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
	public int countMyTask(int deptId) {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		ResultSet res =null;
		int count = 0;
	
		try {
							
			String sql = "SELECT count(*) from task t , task_log l where t.task_id = l.task_id AND t.dept_id = ? and t.status = '10' and l.status = '0' ";
			pstate = this.conn.prepareStatement(sql);
			pstate.setInt(1, deptId);
			res = pstate.executeQuery();
			if(res.next()) {
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
	public boolean startTask(int taskId) {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstate = null;
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			
				String sql = " update task set status = ?  where task_id = ? ";
						pstate = this.conn.prepareStatement(sql);	
						pstate.setInt(1, 10 );
						pstate.setInt(2, taskId );
			
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
	public boolean doneTask(int taskLogId) {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstate = null;
		Date date = new Date();
		DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String overtime  = df2.format(date);
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			
				String sql = " update task_log set status = ? , overtime = ? where task_log_id = ? ";
						pstate = this.conn.prepareStatement(sql);	
						pstate.setInt(1, 20 );
						pstate.setString(2, overtime);
						pstate.setInt(3, taskLogId );
			
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
	public int countUnDo(int taskId) {
		// TODO Auto-generated method stub
				PreparedStatement pstate = null;
				ResultSet res =null;
				int count = 0;
			
				try {
									
					String sql = "SELECT count(*) from task_log WHERE task_id = ? and `status` = '0'";
					pstate = this.conn.prepareStatement(sql);
					pstate.setInt(1, taskId);
					res = pstate.executeQuery();
					if(res.next()) {
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
	public boolean overTask(int taskId) {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstate = null;
		Date date = new Date();
		DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String overtime  = df2.format(date);
		try {
			this.conn.setAutoCommit(false);//取消自动提交
			
				String sql = " update task set status = ? ,overtime = ? where task_id = ? ";
						pstate = this.conn.prepareStatement(sql);	
						pstate.setInt(1, 20 );
						pstate.setString(2, overtime);
						pstate.setInt(3, taskId );
			
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
	public List<Object> ListAll(int pageindex,int pagesize,String taskno) {
		// TODO Auto-generated method stub
		PreparedStatement pstate = null;
		ResultSet res =null;
		List<Object> list = new ArrayList<Object>();
		pageindex = (pageindex-1)*pagesize;
	
		try {
							
			String sql = "SELECT t.taskno,t.name,d.name,t.createtime,t.overtime ,CONCAT(left((count(CASE WHEN l.`status` ='20' then l.`status` END)/count(*)),4)*100,'%')as progress FROM task t ,task_log l,dept d WHERE t.task_id = l.task_id AND t.dept_id = d.dept_id AND is_del ='on' AND t.taskno LIKE ? GROUP BY l.task_id LIMIT ?,?";
			pstate = this.conn.prepareStatement(sql);
			pstate.setString(1, "%"+taskno+"%");
			pstate.setInt(2, pageindex);
			pstate.setInt(3, pagesize);
			res = pstate.executeQuery();
			while(res.next()){
				ShowAllTaskDTO dto = new ShowAllTaskDTO(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6));
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


}
