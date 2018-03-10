	package com.tibos.pojo;

import java.util.Date;

public class MessageDTO {
	public Integer messageId;
	public String name;
	public String info;
	public String addtime;
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MessageDTO(Integer messageId,String name ,String info, String addtime) {
		super();
		this.messageId = messageId;
		this.info = info;
		this.addtime = addtime;
		this.name = name;
	}
	public MessageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
}
