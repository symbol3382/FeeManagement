package com.mp.model;

public class User {
	public String rollno;
	public String name;
	public String email;
	public String password;
	public String address;
	public String mobile_number;
	public String user_type;

	public String course;

	public int fee;
	public int paid;
	public int due;

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

}
