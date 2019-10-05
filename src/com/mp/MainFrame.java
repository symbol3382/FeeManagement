package com.mp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import com.mp.config.DatabaseConfig;
import com.mp.model.User;
import com.mp.model.UserFee;
import com.mp.views.Login;
import com.mp.views.accountant.AccountantPanel;
import com.mp.views.admin.AdminPanel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.MatteBorder;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	public static JFrame frame;

//	Panels
	Login loginPanel;
	AccountantPanel accountantPanel;
	AdminPanel adminPanel;
	com.mp.JPanel currentPanel;
	JPanel windowTitleBar, uiPanel;

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

		// Frame details
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(900, 620);
		setLocationRelativeTo(null);

		windowTitleBar = new WindowTitleBar();

		contentPane = new JPanel();
		setContentPane(contentPane);
		
		FrameDragListener frameDragListener = new FrameDragListener(frame);
		windowTitleBar.addMouseListener(frameDragListener);
		windowTitleBar.addMouseMotionListener(frameDragListener);

		uiPanel = new JPanel();
		loginPanel = new Login();

		updatePanel(loginPanel);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(windowTitleBar, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
				.addComponent(uiPanel, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(windowTitleBar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(uiPanel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		loginPanel.btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User user = DatabaseConfig.check_login(loginPanel.tf_username.getText(),
						loginPanel.tf_password.getText());
				if (user != null) {
					if (user.getUser_type().equals("admin")) {
						// Admin Login
						adminPanel = new AdminPanel(user);
						updatePanel(adminPanel);
						startAdminPanelEvent();
						loginPanel.setVisible(false);
					} else if (user.getUser_type().equals("acountant")) {
						// Accountant Login
						accountantPanel = new AccountantPanel(user);
						accountantPanel.addSearchResult(DatabaseConfig.getAllStudentFeeList());
						// accountantPanel.setBounds(0, 0, 872, 543);
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

		contentPane.setLayout(gl_contentPane);

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

	private void updatePanel(com.mp.JPanel panel) {
		currentPanel = panel;
		WindowTitleBar.setPanelName(panel.getPanelName());
		
		GroupLayout gl_uiPanel = new GroupLayout(uiPanel);
		gl_uiPanel.setHorizontalGroup(
				gl_uiPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_uiPanel.createSequentialGroup()
						.addComponent(currentPanel, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)));
		gl_uiPanel.setVerticalGroup(
				gl_uiPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_uiPanel.createSequentialGroup()
						.addComponent(currentPanel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)));
		uiPanel.setLayout(gl_uiPanel);
	}
}

//situation 
//task
//action
//result