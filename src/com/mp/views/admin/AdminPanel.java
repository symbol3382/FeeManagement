package com.mp.views.admin;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.MatteBorder;

import com.mp.model.User;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JPanel adminSidePanel;
	JPanel currentPanel;

	JPanel panel = this;

	public JButton btnLogout;

	AdminDashboard adminDashboard;
	AdminAddUser adminAddUser;

	public AdminPanel(User user) {
		setBounds(0, 0, 872, 543);
		setBackground(Color.LIGHT_GRAY);

		adminSidePanel = new JPanel();
		adminSidePanel.setBackground(Color.WHITE);
		adminSidePanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));

		adminDashboard = new AdminDashboard(user);
		currentPanel = adminDashboard;

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(adminSidePanel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addComponent(currentPanel, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
						.addGap(2)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(adminSidePanel, GroupLayout.PREFERRED_SIZE, 543, GroupLayout.PREFERRED_SIZE)
						.addComponent(currentPanel, GroupLayout.PREFERRED_SIZE, 543, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.setForeground(Color.DARK_GRAY);
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminDashboard = new AdminDashboard(user);
				hideAllComponent();
				adminDashboard.setVisible(true);
				currentPanel = adminDashboard;
				panel.add(adminDashboard);
			}
		});
		btnDashboard.setBackground(Color.WHITE);
		btnDashboard.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		btnDashboard.setFont(new Font("Candara", Font.BOLD, 14));

		JButton btnAddStudent = new JButton("Add User");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminAddUser = new AdminAddUser(user);
				hideAllComponent();
				adminAddUser.setVisible(true);
				currentPanel = adminAddUser;
				panel.add(adminAddUser);
			}
		});
		btnAddStudent.setForeground(Color.DARK_GRAY);
		btnAddStudent.setFont(new Font("Candara", Font.BOLD, 14));
		btnAddStudent.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		btnAddStudent.setBackground(Color.WHITE);

		btnLogout = new JButton("Logout");

		btnLogout.setForeground(Color.DARK_GRAY);
		btnLogout.setFont(new Font("Candara", Font.BOLD, 14));
		btnLogout.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		btnLogout.setBackground(Color.WHITE);

		JButton btnAddFeeEvent = new JButton("Add Fee Event");
		btnAddFeeEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAddFeeEvent.setForeground(Color.DARK_GRAY);
		btnAddFeeEvent.setFont(new Font("Candara", Font.BOLD, 14));
		btnAddFeeEvent.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		btnAddFeeEvent.setBackground(Color.WHITE);
		GroupLayout gl_adminSidePanel = new GroupLayout(adminSidePanel);
		gl_adminSidePanel.setHorizontalGroup(
			gl_adminSidePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminSidePanel.createSequentialGroup()
					.addGroup(gl_adminSidePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDashboard, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddFeeEvent, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
					.addGap(460))
		);
		gl_adminSidePanel.setVerticalGroup(
			gl_adminSidePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminSidePanel.createSequentialGroup()
					.addComponent(btnDashboard, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAddFeeEvent, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(392, Short.MAX_VALUE))
		);
		adminSidePanel.setLayout(gl_adminSidePanel);
		setLayout(groupLayout);
	}

	private void hideAllComponent() {
		if (adminDashboard != null) {
			System.out.println("admin Dashboard false");
			adminDashboard.setVisible(false);
		}
		if (adminAddUser != null) {
			adminAddUser.setVisible(false);
		}
	}
}