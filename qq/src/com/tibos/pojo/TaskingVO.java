package com.tibos.pojo;

public class TaskingVO {
	String taskingNo;
	String name;
	String detail;
	Integer level;
	String createtime;
	Integer taskId;
	
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskingNo() {
		return taskingNo;
	}
	public void setTaskingNo(String taskingNo) {
		this.taskingNo = taskingNo;
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public TaskingVO(String taskingNo, String name, String detail, Integer level, String createtime,Integer taskId) {
		super();
		this.taskingNo = taskingNo;
		this.name = name;
		this.detail = detail;
		this.level = level;
		this.createtime = createtime;
		this.taskId = taskId;
	}
	public TaskingVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
