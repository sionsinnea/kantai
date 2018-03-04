package com.tibos.pojo;

public class StaffPOJO {
	Integer id;
	String userName;
	String password;
	String name;
	Integer age;
	String pic;
	Integer phone;
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public StaffPOJO(Integer id, String userName, String password, String name, Integer age, String pic) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.age = age;
		this.pic = pic;
	}
	public StaffPOJO(Integer id,String name, String pic) {
		super();
		this.id = id;
		this.name = name;
		this.pic = pic;
	}
}
