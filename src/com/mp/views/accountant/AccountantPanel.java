package com.mp.views.accountant;

import javax.swing.JPanel;

import com.mp.config.DatabaseConfig;
import com.mp.model.User;
import com.mp.model.UserFee;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class AccountantPanel extends com.mp.JPanel {

	private static final long serialVersionUID = 1L;

	public JTextField textField;
	public JButton btnLogOut;
	public JButton btnSearchByRegistration;
	public JScrollPane scrollPaneUserList;
	public User user;

	private JLabel lblRegNo;
	private JLabel lblName;
	private JLabel lblMobileNumber;
	private JLabel lblFee;
	private JLabel lblPaid;
	private JLabel lblDue;
	private JLabel lblPay;
	private JLabel lblFeetype;

	JPanel panel;

	public AccountantPanel(User user) {
		this.user = user;
		panel = this;
		btnLogOut = new JButton("Log Out");
		btnSearchByRegistration = new JButton("Search By Registration ID");

		setBounds(0, 0, 872, 543);
		setBackground(Color.WHITE);

		btnLogOut.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnLogOut.setBackground(Color.WHITE);

		textField = new JTextField();
		textField.setColumns(10);

		btnSearchByRegistration.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnSearchByRegistration.setBackground(Color.WHITE);

		JLabel lblAccountant = new JLabel(user.getName());
		lblAccountant.setFont(new Font("Candara", Font.PLAIN, 30));

		JPanel listTitlePanel = new JPanel();
		listTitlePanel.setForeground(Color.DARK_GRAY);
		listTitlePanel.setBackground(Color.WHITE);

		scrollPaneUserList = new JScrollPane();
		scrollPaneUserList.getViewport().setBackground(Color.white);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(scrollPaneUserList, GroupLayout.DEFAULT_SIZE, 852,
												Short.MAX_VALUE)
										.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 414,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnSearchByRegistration, GroupLayout.PREFERRED_SIZE, 173,
												GroupLayout.PREFERRED_SIZE)
										.addGap(137))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(listTitlePanel, GroupLayout.PREFERRED_SIZE, 851,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(11, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblAccountant, GroupLayout.PREFERRED_SIZE, 435,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
										.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 77,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup().addGap(23).addComponent(btnLogOut,
								GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblAccountant,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addGap(21)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSearchByRegistration, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
				.addComponent(listTitlePanel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(8)
				.addComponent(scrollPaneUserList, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));

		lblRegNo = new JLabel("  Reg No");
		lblRegNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegNo.setFont(new Font("Candara", Font.BOLD, 14));
		lblRegNo.setForeground(Color.DARK_GRAY);
		lblRegNo.setBackground(Color.WHITE);
		lblRegNo.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));

		lblName = new JLabel("  Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Candara", Font.BOLD, 14));
		lblName.setForeground(Color.DARK_GRAY);
		lblName.setBackground(Color.WHITE);
		lblName.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));

		lblMobileNumber = new JLabel("  Mobile Number");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblMobileNumber.setFont(new Font("Candara", Font.BOLD, 14));
		lblMobileNumber.setForeground(Color.DARK_GRAY);
		lblMobileNumber.setBackground(Color.WHITE);
		lblMobileNumber.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));

		lblFee = new JLabel("  Fee");
		lblFee.setHorizontalAlignment(SwingConstants.CENTER);
		lblFee.setFont(new Font("Candara", Font.BOLD, 14));
		lblFee.setForeground(Color.DARK_GRAY);
		lblFee.setBackground(Color.WHITE);
		lblFee.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));

		lblPaid = new JLabel("  Paid");
		lblPaid.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaid.setFont(new Font("Candara", Font.BOLD, 14));
		lblPaid.setForeground(Color.DARK_GRAY);
		lblPaid.setBackground(Color.WHITE);
		lblPaid.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));

		lblDue = new JLabel("  Due");
		lblDue.setHorizontalAlignment(SwingConstants.CENTER);
		lblDue.setFont(new Font("Candara", Font.BOLD, 14));
		lblDue.setForeground(Color.DARK_GRAY);
		lblDue.setBackground(Color.WHITE);
		lblDue.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));

		lblPay = new JLabel("  Pay");
		lblPay.setHorizontalAlignment(SwingConstants.CENTER);
		lblPay.setFont(new Font("Candara", Font.BOLD, 14));
		lblPay.setForeground(Color.DARK_GRAY);
		lblPay.setBackground(Color.WHITE);
		lblPay.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		lblFeetype = new JLabel("FeeType");
		lblFeetype.setFont(new Font("Candara", Font.BOLD, 14));
		lblFeetype.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		lblFeetype.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblCourse = new JLabel("Course");
		lblCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourse.setFont(new Font("Candara", Font.BOLD, 14));
		lblCourse.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));

		GroupLayout gl_listTitlePanel = new GroupLayout(listTitlePanel);
		gl_listTitlePanel.setHorizontalGroup(gl_listTitlePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_listTitlePanel.createSequentialGroup()
						.addComponent(lblRegNo, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMobileNumber, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCourse, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFeetype, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFee, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPaid, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDue, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPay, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)));
		gl_listTitlePanel.setVerticalGroup(gl_listTitlePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblMobileNumber, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblFee, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblFeetype, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblCourse, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblPaid, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblDue, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblPay, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblRegNo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE));
		listTitlePanel.setLayout(gl_listTitlePanel);
		setLayout(groupLayout);
		setVisible(true);

	}

	public void addSearchResult(List<UserFee> userFees) {
		JPanel temp = new JPanel();
		int i = 0;
		for (UserFee userFee : userFees) {
			AccountantSearchResultRow resultRow = new AccountantSearchResultRow(i, userFee);
			resultRow.btnPay.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String reg_no = userFee.reg_no;
					String fee_type = userFee.fee_type;
					String course = userFee.course;
					int fee = userFee.fee;
					int paid = userFee.paid;
					int due = userFee.due;
					if (due == 0) {
						JOptionPane.showMessageDialog(panel,
								"There is no amount to pay on this fees for student : " + userFee.name, "No Due",
								JOptionPane.WARNING_MESSAGE);
					} else {
						int paying = Integer.parseInt(JOptionPane.showInputDialog(panel, "Enter Amount",
								"Fee Pay - " + fee, JOptionPane.QUESTION_MESSAGE));
						if (paying > due) {
							JOptionPane.showMessageDialog(panel,
									"Please Enter pay by student on less or equal than : " + due, "Amount Exceed",
									JOptionPane.WARNING_MESSAGE);
						} else {
							// Pay fees
							if (DatabaseConfig.payFees(reg_no, fee_type, course, fee, paid, due, paying) == 1) {
								JOptionPane.showMessageDialog(panel, "Done for " + userFee.name + " : " + due, "Done", JOptionPane.PLAIN_MESSAGE);
								addSearchResult(DatabaseConfig.getAllStudentFeeList());
							}
						}
					}
				}
			});
			temp.add(resultRow);
			i++;
		}
		temp.setLayout(new BoxLayout(temp, 1));
		scrollPaneUserList.setViewportView(temp);
		scrollPaneUserList.setBackground(Color.white);
	}
	
	@Override 
	public String getPanelName() {
		return "Welcome, " + user.getName();
	}
}
