package com.tibos.pojo;

public class UpdTaskDTO {
	Integer taskId;
	String name;
	String detail;
	Integer deptId;
	String taskno;
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
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getTaskno() {
		return taskno;
	}
	public void setTaskno(String taskno) {
		this.taskno = taskno;
	}
	public UpdTaskDTO(Integer taskId, String name, String detail, Integer deptId, String taskno) {
		super();
		this.taskId = taskId;
		this.name = name;
		this.detail = detail;
		this.deptId = deptId;
		this.taskno = taskno;
	}
	public UpdTaskDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
