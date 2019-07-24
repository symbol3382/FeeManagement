package com.mp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mp.MainFrame;
import com.mp.model.User;
import com.mp.model.UserFee;

public class DatabaseConfig {
	private static Connection connection = null;
	final static private String IP = "localhost";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + IP + ":3306/feedb", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static User check_login(String reg_id, String pass) {
		Connection con = getConnection();
		PreparedStatement ps;
		User user = null;
		try {
			ps = con.prepareStatement("select * from user where id=? and password=?");
			ps.setString(1, reg_id);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				String mobile_number = rs.getString(5);
				String address = rs.getString(6);
				String user_type = rs.getString(7);

				user = new User(id, name, email, password, address, mobile_number, user_type);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public static List<UserFee> getAllStudentFeeList(){
		List<UserFee> userFees = new ArrayList<UserFee>();
		Connection con = getConnection();
		PreparedStatement ps;
		UserFee userFee = null;
		try {
			String sql = "SELECT u.id, u.name, u.mobile_number, c.fee_type, c.course_name, c.fee, c.paid, c.due FROM user u JOIN user_course c on u.id = c.user_id ORDER BY u.id";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userFee = null;
				String reg_no = rs.getString(1);
				String name = rs.getString(2);
				String mobile_number = rs.getString(3);
				String fee_type = rs.getString(4);
				String course = rs.getString(5);
				int fee = rs.getInt(6);
				int paid = rs.getInt(7);
				int due = rs.getInt(8);
				
				userFee = new UserFee(reg_no, name, mobile_number, fee_type, course, fee, paid, due);
				userFees.add(userFee);
				System.out.println(userFee);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userFees;
	}
	public static List<UserFee> searchUserFee(String id){
		List<UserFee> userFees = new ArrayList<UserFee>();
		Connection con = getConnection();
		PreparedStatement ps;
		UserFee userFee = null;
		try {
			String sql = "SELECT u.id, u.name, u.mobile_number, c.fee_type, c.course_name, c.fee, c.paid, c.due FROM user u JOIN user_course c on u.id = c.user_id WHERE u.id LIKE '%" + id + "%' AND user_type = 'student' ORDER BY u.id";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userFee = null;
				String reg_no = rs.getString(1);
				String name = rs.getString(2);
				String mobile_number = rs.getString(3);
				String fee_type = rs.getString(4);
				String course = rs.getString(5);
				int fee = rs.getInt(6);
				int paid = rs.getInt(7);
				int due = rs.getInt(8);
				
				userFee = new UserFee(reg_no, name, mobile_number, fee_type, course, fee, paid, due);
				userFees.add(userFee);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userFees;
	}
	
	public static int payFees(String reg_no, String fee_type, String course, int fee, int paid, int due, int paying) {
		paid = paid + paying;
		due = due - paying;
		Connection con = getConnection();
		PreparedStatement ps;
		int i = 0;
		try {
			String sql = "UPDATE `user_course` SET `paid`=" + paid + ", `due`=" + due + " WHERE user_id = '" + reg_no + "' AND course_name = '" + course + "' AND fee_type = '" + fee_type + "'";
			ps = con.prepareStatement(sql);
			i = ps.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return i;
	}
	
	public static String getStudentCount() {
		Connection con = getConnection();
		PreparedStatement ps;
		String i = "0";
		try {
			String sql = "SELECT COUNT(*) FROM `user` WHERE user_type = 'student'";
			ps = con.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				i = resultSet.getString(1);
			} else {
				JOptionPane.showMessageDialog(MainFrame.frame, "Error in getting student count", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return i;
	}
	
	public static String getTotalFeeDue() {
		Connection con = getConnection();
		PreparedStatement ps;
		String i = "0";
		try {
			String sql = "select SUM(due) from user_course";
			ps = con.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				i = resultSet.getString(1);
			} else {
				JOptionPane.showMessageDialog(MainFrame.frame, "Error in getting Total fee due", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return i;
	}
	
	public static void addUser(User user) {
		Connection con = getConnection();
		PreparedStatement ps;
		System.out.println(user);
		try {
			String sql = "INSERT INTO `user`(`name`, `password`, `email`, `mobile_number`, `address`, `user_type`) VALUES (?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.name);
			ps.setString(2, user.password);
			ps.setString(3, user.email);
			ps.setString(4, user.mobile_number);
			ps.setString(5, user.address);
			ps.setString(6, user.user_type);
			
			if(ps.executeUpdate() == 1) {
				JOptionPane.showMessageDialog(MainFrame.frame, "User added", "Success", JOptionPane.INFORMATION_MESSAGE);
			}			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
}