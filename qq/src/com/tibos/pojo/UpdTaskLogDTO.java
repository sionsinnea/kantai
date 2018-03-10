package com.tibos.pojo;

public class UpdTaskLogDTO {
		Integer taskLogId;
		String name;
		Integer level;
		String detail;
		public Integer getTaskLogId() {
			return taskLogId;
		}
		public void setTaskLogId(Integer taskLogId) {
			this.taskLogId = taskLogId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getLevel() {
			return level;
		}
		public void setLevel(Integer level) {
			this.level = level;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		public UpdTaskLogDTO(Integer taskLogId, String name, Integer level, String detail) {
			super();
			this.taskLogId = taskLogId;
			this.name = name;
			this.level = level;
			this.detail = detail;
		}
		public UpdTaskLogDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
