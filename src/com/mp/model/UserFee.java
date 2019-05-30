package com.mp.model;

public class UserFee {
	public String reg_no;
	public String name;
	public String mobile_number;
	public String fee_type;
	public String course;
	public int fee;
	public int paid;
	public int due;
		
	public UserFee(String reg_no, String name, String mobile_number, String fee_type, String course, int fee, int paid, int due) {
		this.reg_no = reg_no;
		this.name = name;
		this.mobile_number = mobile_number;
		this.fee_type = fee_type;
		this.course = course;
		this.fee = fee;
		this.paid = paid;
		this.due = due;
	}

	@Override
	public String toString() {
		return "UserFee [reg_no=" + reg_no + ", name=" + name + ", mobile_number=" + mobile_number + ", fee_type="
				+ fee_type + ", fee=" + fee + ", paid=" + paid + ", due=" + due + "]";
	}
	
	
}
