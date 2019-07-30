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

public class AdminPanel extends com.mp.JPanel {
	private static final long serialVersionUID = 1L;
	JPanel adminSidePanel;
	JPanel currentPanel;

	JPanel panel = this;
	private User user;

	public JButton btnLogout;

	AdminDashboard adminDashboard;
	AdminAddUser adminAddUser;

	public AdminPanel(User user) {
		this.user = user;
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		setBackground(Color.white);

		adminSidePanel = new JPanel();
		adminSidePanel.setBackground(Color.WHITE);
		adminSidePanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));

		adminDashboard = new AdminDashboard(user);
		currentPanel = adminDashboard;

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(adminSidePanel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminDashboard, GroupLayout.PREFERRED_SIZE, 750, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(adminSidePanel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminDashboard, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		// Admin Side panel

		JButton btnDashboard = new JButton("Dashboard");
		JButton btnAddStudent = new JButton("Add User");
		JButton btnAddFeeEvent = new JButton("Add Fee Event");
		btnLogout = new JButton("Logout");

		btnDashboard.setBackground(Color.WHITE);
		btnAddStudent.setBackground(Color.WHITE);
		btnLogout.setBackground(Color.WHITE);
		btnAddFeeEvent.setBackground(Color.WHITE);

		btnDashboard.setForeground(Color.DARK_GRAY);
		btnAddStudent.setForeground(Color.DARK_GRAY);
		btnLogout.setForeground(Color.DARK_GRAY);
		btnAddFeeEvent.setForeground(Color.DARK_GRAY);

		btnDashboard.setFont(new Font("Candara", Font.BOLD, 14));
		btnAddStudent.setFont(new Font("Candara", Font.BOLD, 14));
		btnLogout.setFont(new Font("Candara", Font.BOLD, 14));
		btnAddFeeEvent.setFont(new Font("Candara", Font.BOLD, 14));

		btnDashboard.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		btnAddStudent.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		btnLogout.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
		btnAddFeeEvent.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));

		GroupLayout gl_adminSidePanel = new GroupLayout(adminSidePanel);
		gl_adminSidePanel.setHorizontalGroup(gl_adminSidePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminSidePanel.createSequentialGroup().addGroup(gl_adminSidePanel
						.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDashboard, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddFeeEvent, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGap(460)));
		gl_adminSidePanel.setVerticalGroup(gl_adminSidePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminSidePanel.createSequentialGroup()
						.addComponent(btnDashboard, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAddFeeEvent, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(392, Short.MAX_VALUE)));
		adminSidePanel.setLayout(gl_adminSidePanel);
		setLayout(groupLayout);

		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminDashboard = new AdminDashboard(user);
				hideAllComponent();
				adminDashboard.setVisible(true);
				currentPanel = adminDashboard;
				panel.add(adminDashboard);
			}
		});

		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminAddUser = new AdminAddUser(user);
				hideAllComponent();
				adminAddUser.setVisible(true);
				currentPanel = adminAddUser;
				panel.add(adminAddUser);
			}
		});

		btnAddFeeEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	@Override
	public String getPanelName() {
		return "Welcome, " + user.getName();
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