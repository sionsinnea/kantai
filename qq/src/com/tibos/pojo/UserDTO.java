package com.tibos.pojo;

public class UserDTO {
	Integer id;
	String name;
	Integer age;
	String address;
	String phone;
	String sex;
	String deptName;
	String degName;
	Integer deptId;
	Integer degId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDegName() {
		return degName;
	}
	public void setDegName(String degName) {
		this.degName = degName;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getDegId() {
		return degId;
	}
	public void setDegId(Integer degId) {
		this.degId = degId;
	}
	public UserDTO(Integer id, String name, Integer age, String address, String phone, String sex, String deptName,
			String degName, Integer deptId, Integer degId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.sex = sex;
		this.deptName = deptName;
		this.degName = degName;
		this.deptId = deptId;
		this.degId = degId;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
