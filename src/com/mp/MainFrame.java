package com.mp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mp.config.DatabaseConfig;
import com.mp.model.User;
import com.mp.model.UserFee;
import com.mp.views.Login;
import com.mp.views.accountant.AccountantPanel;
import com.mp.views.admin.AdminPanel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public static JFrame frame;

//	Panels
	Login loginPanel;
	AccountantPanel accountantPanel;
	AdminPanel adminPanel;
	JPanel currentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		frame = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);

		loginPanel = new Login();
		currentPanel = loginPanel;
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(currentPanel, GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(currentPanel,
				GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);

		loginPanel.btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				User user = DatabaseConfig.check_login(loginPanel.tf_username.getText(),
						loginPanel.tf_password.getText());
				if (user != null) {
					if (user.user_type.equals("admin")) {
						// Admin Login
						adminPanel = new AdminPanel(user);
						adminPanel.setVisible(true);
						currentPanel = adminPanel;
						contentPane.add(adminPanel);
						startAdminPanelEvent();
						loginPanel.setVisible(false);
					} else if (user.user_type.equals("accountant")) {
						// Accountant Login
						accountantPanel = new AccountantPanel(user);
						accountantPanel.addSearchResult(DatabaseConfig.getAllStudentFeeList());
						accountantPanel.setVisible(true);
//						accountantPanel.setBounds(0, 0, 872, 543);
						currentPanel = accountantPanel;
						contentPane.add(accountantPanel);
						startAccountantPanelEvent();
						loginPanel.setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Invalid Login");
				}
			}
		});

	}

	public void startAccountantPanelEvent() {
		accountantPanel.btnSearchByRegistration.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<UserFee> userFees = DatabaseConfig.searchUserFee(accountantPanel.textField.getText());
				accountantPanel.addSearchResult(userFees);
			}
		});

		accountantPanel.btnLogOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loginPanel.setVisible(true);
				accountantPanel.setVisible(false);
			}
		});

	}

	public void startAdminPanelEvent() {
		adminPanel.btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(true);
				adminPanel.setVisible(false);
			}
		});
	}
}

//situation 
//task
//action
//result