package com.tibos.pojo;

public class TaskLogDTO {
	Integer taskId;
	String Name;
	String detail;
	Integer level;
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public TaskLogDTO(Integer taskId, String name, String detail, Integer level) {
		super();
		this.taskId = taskId;
		Name = name;
		this.detail = detail;
		this.level = level;
	}
	public TaskLogDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
