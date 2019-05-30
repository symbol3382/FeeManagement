package com.mp.views.admin;

import javax.swing.JPanel;

import com.mp.config.DatabaseConfig;
import com.mp.model.User;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.border.MatteBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminAddUser extends JPanel {
	private JTextField tf_name;
	private JTextField tf_email;
	private JTextField tf_mobile_number;
	private JTextField tf_address;
	private JPasswordField tf_password;

	public AdminAddUser(User user) {
		setBackground(Color.white);
		setBounds(152, 0, 720, 543);

		JLabel lblAddUser = new JLabel("Add User");
		lblAddUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddUser.setFont(new Font("Candara", Font.BOLD, 30));

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.DARK_GRAY);
		lblName.setFont(new Font("Candara", Font.BOLD, 14));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Candara", Font.BOLD, 14));

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Candara", Font.BOLD, 14));

		JLabel lblMobile = new JLabel("Mobile Number");
		lblMobile.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMobile.setForeground(Color.DARK_GRAY);
		lblMobile.setFont(new Font("Candara", Font.BOLD, 14));

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Candara", Font.BOLD, 14));

		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserType.setForeground(Color.DARK_GRAY);
		lblUserType.setFont(new Font("Candara", Font.BOLD, 14));

		tf_name = new JTextField();
		tf_name.setFont(new Font("Candara", Font.PLAIN, 15));
		tf_name.setColumns(10);

		tf_email = new JTextField();
		tf_email.setFont(new Font("Candara", Font.PLAIN, 15));
		tf_email.setColumns(10);

		tf_mobile_number = new JTextField();
		tf_mobile_number.setFont(new Font("Candara", Font.PLAIN, 15));
		tf_mobile_number.setColumns(10);

		tf_address = new JTextField();
		tf_address.setFont(new Font("Candara", Font.PLAIN, 15));
		tf_address.setColumns(10);

		tf_password = new JPasswordField();
		tf_password.setFont(new Font("Candara", Font.PLAIN, 15));

		String[] user_types = {"student", "accountant", "admin"};
		
		JComboBox cb_user_type = new JComboBox(user_types);
		cb_user_type.setFont(new Font("Candara", Font.PLAIN, 15));

		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tf_name.getText();
				String password = tf_password.getText();
				String email = tf_email.getText();
				String mobile_number = tf_mobile_number.getText();
				String address = tf_address.getText();
				String user_type = (String)cb_user_type.getSelectedItem();
				User user = new User(null,name,email,password,address,mobile_number,user_type);
				DatabaseConfig.addUser(user);
			}
		});
		btnAddUser.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnAddUser.setForeground(Color.WHITE);
		btnAddUser.setBackground(Color.DARK_GRAY);
		btnAddUser.setFont(new Font("Candara", Font.BOLD, 20));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblAddUser, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup().addGap(100).addGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAddUser, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblUserType, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(cb_user_type, GroupLayout.PREFERRED_SIZE, 250,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(tf_address, GroupLayout.PREFERRED_SIZE, 250,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblMobile, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(tf_mobile_number, GroupLayout.PREFERRED_SIZE, 250,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(tf_email, GroupLayout.PREFERRED_SIZE, 250,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(tf_password, GroupLayout.PREFERRED_SIZE, 250,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(tf_name, GroupLayout.PREFERRED_SIZE, 250,
												GroupLayout.PREFERRED_SIZE))))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(35)
						.addComponent(lblAddUser, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE).addGap(32)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_name, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_password, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_email, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblMobile, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(tf_mobile_number, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_address, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUserType, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(cb_user_type, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnAddUser, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(99, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}
}
