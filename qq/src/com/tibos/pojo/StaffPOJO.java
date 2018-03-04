package com.tibos.pojo;

public class StaffPOJO {
	@Override
	public String toString() {
		return "StaffPOJO [id=" + id + ", userName=" + userName + ", password=" + password + ", name=" + name + ", age="
				+ age + ", pic=" + pic + ", phone=" + phone + ", address=" + address + ", sex=" + sex + ", file=" + file
				+ "]";
	}
	public StaffPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}
	Integer id;
	String userName;
	String password;
	String name;
	Integer age;
	String pic;
	String phone;
	String address;
	String sex;
	String file;
	Integer degId;
	
	

	
	public Integer getDegId() {
		return degId;
	}
	public void setDegId(Integer degId) {
		this.degId = degId;
	}
	public StaffPOJO(Integer id, String name, Integer age,  String address, String phone,String sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.sex = sex;
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
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public StaffPOJO(Integer id, String name, String pic, String userName, String password, Integer age, String address,
			String phone, String sex, Integer degId) {
		super();
		this.id = id;
		this.name = name;
		this.pic = pic;
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.sex = sex;
		this.degId = degId;
	}
	public StaffPOJO(String userName, String password, String name, Integer age, String pic, String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.age = age;
		this.pic = pic;
		this.phone = phone;
	}
	public StaffPOJO(String userName, String password, String name, Integer age, String pic, String phone,
			String address) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.age = age;
		this.pic = pic;
		this.phone = phone;
		this.address = address;
	}
	public StaffPOJO(Integer id, String userName, String password, String name, Integer age, String pic, String phone,
			String address, String sex, String file) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.age = age;
		this.pic = pic;
		this.phone = phone;
		this.address = address;
		this.sex = sex;
		this.file = file;
	}


	
	
}
