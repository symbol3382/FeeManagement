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
import javax.swing.border.MatteBorder;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminDashboard extends JPanel {

	private static final long serialVersionUID = 1L;

	public AdminDashboard(User user) {
		setBackground(Color.white);
		setBounds(152, 0, 720, 543);


		JLabel lblUserName = new JLabel(user.getName());
		lblUserName.setFont(new Font("Candara", Font.BOLD, 30));
		lblUserName.setBackground(Color.WHITE);

		JLabel lblTotalStudents = new JLabel("Total Students");
		lblTotalStudents.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalStudents.setFont(new Font("Candara", Font.BOLD, 20));

		JLabel lblSpliter = new JLabel("");
		lblSpliter.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lblSpliter.setBackground(Color.DARK_GRAY);

		JLabel lblFee = new JLabel("Fee");
		lblFee.setHorizontalAlignment(SwingConstants.CENTER);
		lblFee.setFont(new Font("Candara", Font.BOLD, 20));

		JLabel lblStudentCount = new JLabel(DatabaseConfig.getStudentCount());
		lblStudentCount.setFont(new Font("Candara", Font.PLAIN, 40));

		JLabel lblFee_1 = new JLabel("Total Fee Due");
		lblFee_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblFee_1.setFont(new Font("Candara", Font.BOLD, 20));

		JLabel lblTotalFeeDue = new JLabel(DatabaseConfig.getTotalFeeDue());
		lblTotalFeeDue.setFont(new Font("Candara", Font.PLAIN, 40));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(30).addComponent(lblUserName,
										GroupLayout.PREFERRED_SIZE, 687, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(976).addComponent(lblFee,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGap(3))
				.addGroup(
						groupLayout.createSequentialGroup().addGap(123)
								.addComponent(lblStudentCount, GroupLayout.PREFERRED_SIZE, 306,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(580, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(55)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFee_1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSpliter, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotalStudents, GroupLayout.PREFERRED_SIZE, 215,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(490, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(120)
						.addComponent(lblTotalFeeDue, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(580, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(37).addComponent(lblFee,
										GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(49).addComponent(lblTotalStudents,
										GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblStudentCount, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addGap(25).addComponent(lblSpliter, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
						.addGap(38).addComponent(lblFee_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblTotalFeeDue, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(87, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}
}
