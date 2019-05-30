package com.mp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import com.mp.dao.AccountantDao;
import com.mp.views.accountant.AccountantPanel;

public class AccountantLogin extends JPanel {
	static AccountantLogin frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AccountantLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccountantLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblAccountantLogin = new JLabel("Accountant Login");
		lblAccountantLogin.setFont(new Font("Candara", Font.BOLD, 30));
		lblAccountantLogin.setForeground(Color.DARK_GRAY);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Candara", Font.PLAIN, 15));

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Candara", Font.PLAIN, 15));

		passwordField = new JPasswordField();

		JButton btnLogin = new JButton("Login");
		btnLogin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnLogin.setBackground(null);
		btnLogin.setFont(new Font("Candara", Font.BOLD, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("LoginPressed");
				String name = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				boolean status = AccountantDao.validate(name, password);
				System.out.println(status);
				if (status) {
					AccountantPanel as = new AccountantPanel();
					as.setVisible(true);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(AccountantLogin.this, "Sorry, username or password error!",
							"Login error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnBack = new JButton("Back");
		btnBack.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnBack.setBackground(null);
		btnBack.setFont(new Font("Candara", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FeeReport.main(new String[] {});
				frame.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(284)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnBack, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING,
										gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblPassword).addComponent(lblName))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(textField, GroupLayout.PREFERRED_SIZE,
																		186, GroupLayout.PREFERRED_SIZE)
																.addComponent(passwordField, GroupLayout.PREFERRED_SIZE,
																		186, GroupLayout.PREFERRED_SIZE)))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblAccountantLogin))))
						.addContainerGap(383, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane.createSequentialGroup().addGap(50)
												.addComponent(lblAccountantLogin).addGap(31)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblName))
												.addGap(18)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblPassword)
														.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap(151, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
