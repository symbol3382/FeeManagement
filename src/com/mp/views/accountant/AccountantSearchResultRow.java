package com.mp.views.accountant;

import javax.swing.JPanel;
import com.mp.model.UserFee;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AccountantSearchResultRow extends JPanel {

	private static final long serialVersionUID = 1L;

	public JButton btnPay;

	public AccountantSearchResultRow(int i, UserFee userFee) {
		setBounds(0, 0, 851, 30);

		JLabel lblRegNo = new JLabel(userFee.reg_no);
		lblRegNo.setFont(new Font("Candara", Font.PLAIN, 12));
		lblRegNo.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		JLabel lblName = new JLabel(userFee.name);
		lblName.setFont(new Font("Candara", Font.PLAIN, 12));
		lblName.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		JLabel lblMobileNumber = new JLabel(userFee.mobile_number);
		lblMobileNumber.setFont(new Font("Candara", Font.PLAIN, 12));
		lblMobileNumber.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		JLabel lblFeeType = new JLabel(userFee.fee_type);
		lblFeeType.setFont(new Font("Candara", Font.PLAIN, 12));
		lblFeeType.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		JLabel lblFee = new JLabel(userFee.fee + "");
		lblFee.setFont(new Font("Candara", Font.PLAIN, 12));
		lblFee.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		JLabel lblPaid = new JLabel(userFee.paid + "");
		lblPaid.setFont(new Font("Candara", Font.PLAIN, 12));
		lblPaid.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		JLabel lblDue = new JLabel(userFee.due + "");
		lblDue.setFont(new Font("Candara", Font.PLAIN, 12));
		lblDue.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		btnPay = new JButton("Pay");
		btnPay.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		btnPay.setFont(new Font("Candara", Font.BOLD, 12));
		btnPay.setForeground(Color.WHITE);
		btnPay.setBackground(Color.DARK_GRAY);
		if (i % 2 == 0) {
			setBackground(Color.white);
		} else {
			setBackground(Color.LIGHT_GRAY);
		}

		JLabel lblCourse = new JLabel(userFee.course);
		lblCourse.setFont(new Font("Candara", Font.PLAIN, 12));
		lblCourse.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(7)
						.addComponent(lblRegNo, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE).addGap(7)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE).addGap(7)
						.addComponent(lblMobileNumber, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addGap(7).addComponent(lblCourse, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGap(7).addComponent(lblFeeType, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGap(7).addComponent(lblFee, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addGap(7).addComponent(lblPaid, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addGap(7).addComponent(lblDue, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addGap(2).addComponent(btnPay, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFee, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPaid, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMobileNumber, GroupLayout.DEFAULT_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFeeType, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRegNo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDue, GroupLayout.DEFAULT_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPay, GroupLayout.DEFAULT_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCourse, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						));
		setLayout(groupLayout);
	}
}
