package com.mp.model;

public class User {
	private String rollno;
	private String name;
	private String email;
	private String password;
	private String address;
	private String mobile_number;
	private String user_type;

	private String course;

	private int fee;
	private int paid;
	private int due;

	public User() {

	}

	public User(String rollno, String name, String email, String password, String address, String mobile_number,
			String user_type) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobile_number = mobile_number;
		this.user_type = user_type;
	}

	public User(String rollno, String name, String email, String password, String address, String mobile_number,
			String course, int fee, int paid, int due, String user_type) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobile_number = mobile_number;
		this.course = course;
		this.fee = fee;
		this.paid = paid;
		this.due = due;
		this.user_type = user_type;
	}

	@Override
	public String toString() {
		return "User [rollno=" + rollno + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", mobile_number=" + mobile_number + ", user_type=" + user_type + ", course="
				+ course + ", fee=" + fee + ", paid=" + paid + ", due=" + due + "]";
	}

	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	} 
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	public int getDue() {
		return due;
	}
	public void setDue(int due) {
		this.due = due;
	}

}
