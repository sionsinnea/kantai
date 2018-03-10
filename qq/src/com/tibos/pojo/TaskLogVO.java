package com.tibos.pojo;

public class TaskLogVO {
		Integer taskLogId;
		String taskno;
		String name;
		String detail;
		Integer status;
		Integer level;
		String createtime;
	
	
		public Integer getTaskLogId() {
			return taskLogId;
		}
		public void setTaskLogId(Integer taskLogId) {
			this.taskLogId = taskLogId;
		}
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
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
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
		public TaskLogVO(Integer taskLogId, String taskno, String name, String detail, Integer status, Integer level,
				String createtime) {
			super();
			this.taskLogId = taskLogId;
			this.taskno = taskno;
			this.name = name;
			this.detail = detail;
			this.status = status;
			this.level = level;
			this.createtime = createtime;
		}
		public TaskLogVO() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
