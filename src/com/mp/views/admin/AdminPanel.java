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
	private JPanel adminLeftPanel, adminRightSide, adminUIPanel, panel = this;;
	private User user;

	public JButton btnLogout;
	private AdminAddUser adminAddUser;
	private AdminDashboard adminDashboard;

	public AdminPanel(User user) {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		this.user = user;
		setBackground(Color.white);
		
		adminDashboard = new AdminDashboard(user);
		adminAddUser = new AdminAddUser(user);
		
		adminLeftPanel = new JPanel();
		adminRightSide = new JPanel();

		adminLeftPanel.setBackground(Color.WHITE);
		
		updatePanel(adminDashboard);

//		Layout design(150x600) for side panel 

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(adminLeftPanel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addComponent(adminRightSide, GroupLayout.PREFERRED_SIZE, 749, GroupLayout.PREFERRED_SIZE)
		));
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(adminLeftPanel, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminRightSide, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
					)
		);
		

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

		GroupLayout gl_adminLeftPanel = new GroupLayout(adminLeftPanel);
		gl_adminLeftPanel.setHorizontalGroup(gl_adminLeftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminLeftPanel.createSequentialGroup().addGroup(gl_adminLeftPanel
						.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDashboard, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddFeeEvent, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGap(460)));
		gl_adminLeftPanel.setVerticalGroup(gl_adminLeftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminLeftPanel.createSequentialGroup()
						.addComponent(btnDashboard, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAddFeeEvent, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(392, Short.MAX_VALUE)));
		adminLeftPanel.setLayout(gl_adminLeftPanel);
		setLayout(groupLayout);

		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePanel(adminDashboard);
			}
		});

		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updatePanel(adminAddUser);
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
	
	private void hideOtherPanels() {
		adminDashboard.setVisible(false);
		adminAddUser.setVisible(false);
	}
	
	private void updatePanel(JPanel currentPanel) {
		hideOtherPanels();
		currentPanel.setVisible(true);
		GroupLayout gl_panel_1 = new GroupLayout(adminRightSide);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(currentPanel, GroupLayout.PREFERRED_SIZE, 750, GroupLayout.PREFERRED_SIZE)
		));
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addComponent(currentPanel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
		));
		adminRightSide.setLayout(gl_panel_1);
	}
}