package com.tibos.pojo;

public class StaffDTO {
	Integer id;
	String name;
	Integer age;
	String phone;
	String address;
	String sex;
	String is_del;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIs_del() {
		return is_del;
	}
	public void setIs_del(String is_del) {
		this.is_del = is_del;
	}
	public StaffDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StaffDTO(String name, Integer age, String phone, String address, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.sex = sex;
	}
	public StaffDTO(String name, Integer age, String phone, String address, String sex, String is_del) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.sex = sex;
		this.is_del = is_del;
	}
	public StaffDTO(Integer id, String name, Integer age, String phone, String address, String sex, String is_del) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.sex = sex;
		this.is_del = is_del;
	}
	

}
