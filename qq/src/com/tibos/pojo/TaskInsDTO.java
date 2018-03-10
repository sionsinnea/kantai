package com.tibos.pojo;

public class TaskInsDTO {
	String taskno;
	String name;
	String detail;
	Integer deptId;
	String is_del;
	
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
	public String getIs_del() {
		return is_del;
	}
	public void setIs_del(String is_del) {
		this.is_del = is_del;
	}
	public TaskInsDTO(String name, String detail, Integer deptId, String is_del) {
		super();
		this.name = name;
		this.detail = detail;
		this.deptId = deptId;
		this.is_del = is_del;
	}
	public TaskInsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
