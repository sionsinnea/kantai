package com.tibos.pojo;

public class ShowAllTaskDTO {
	String taskno;
	String name;
	String deptName;
	String createtime;
	String overtime;
	String process;
	public String getTaskno() {
		return taskno;
	}
	public void setTaskno(String taskno) {
		this.taskno = taskno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getOvertime() {
		return overtime;
	}
	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public ShowAllTaskDTO(String taskno, String name, String deptName, String createtime, String overtime,
			String process) {
		super();
		this.taskno = taskno;
		this.name = name;
		this.deptName = deptName;
		this.createtime = createtime;
		this.overtime = overtime;
		this.process = process;
	}
	public ShowAllTaskDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
