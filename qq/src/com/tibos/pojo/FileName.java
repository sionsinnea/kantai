package com.tibos.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileName {
	String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public FileName(String ip) {
		super();
		this.ip = ip;
	}
	public String getTime() {
		Date date = new Date();
		String time = new SimpleDateFormat("yyMMddHHmmssSSS").format(date);
		return time;
	}
	public String getFileName() {
		return this.ip+this.getTime();
	}

}
