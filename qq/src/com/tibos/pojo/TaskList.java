package com.tibos.pojo;

public class TaskList {
	Integer taskId;
	String name;
	String detail;
	Integer status;
	String createtime;
	String deptName;
	Integer deptId;
	String taskno;
	
	public String getTaskno() {
		return taskno;
	}
	public void setTaskno(String taskno) {
		this.taskno = taskno;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public TaskList(Integer taskId, String name, String detail, Integer status, String createtime, String deptName,
			Integer deptId,String taskno) {
		super();
		this.taskId = taskId;
		this.name = name;
		this.detail = detail;
		this.status = status;
		this.createtime = createtime;
		this.deptName = deptName;
		this.deptId = deptId;
		this.taskno = taskno;
	}
	public TaskList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
