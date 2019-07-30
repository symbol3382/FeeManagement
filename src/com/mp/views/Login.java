package com.mp.views;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import com.mp.JPanel;

import javax.swing.SwingConstants;

public class Login extends JPanel {
	private static final long serialVersionUID = 1L;
	public JTextField tf_username;
	public JPasswordField tf_password;

	public JButton btnLogin;
	private String panelName;

	public Login() {
		
		panelName = "Login";
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		setBackground(Color.white);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Candara", Font.BOLD, 35));

		JLabel lblUsername = new JLabel("Reg ID");
		lblUsername.setFont(new Font("Candara", Font.PLAIN, 16));

		tf_username = new JTextField();
		tf_username.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Candara", Font.PLAIN, 16));

		tf_password = new JPasswordField();

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Candara", Font.BOLD, 16));
		btnLogin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnLogin.setBackground(Color.WHITE);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Candara", Font.BOLD, 16));
		btnReset.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnReset.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(293)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblUsername)
										.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(tf_password, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
										.addComponent(tf_username, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLogin, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblLogin)
					.addGap(76)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(tf_username, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_password, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(188, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	@Override
	public String getPanelName() {
		return panelName;
	}

}
