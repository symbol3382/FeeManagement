package com.mp;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class WindowTitleBar extends JPanel{
	public WindowTitleBar() {
		setBorder(new MatteBorder(1, 1, 0, 1, (Color) Color.DARK_GRAY));
		setSize(900, 16);
		setBackground(new Color(230,230,230));
		
		ImageIcon closeIcon = new ImageIcon("reference/close-active.png");
		
		JButton indent = new JButton("");
		indent.setBackground(null);
		indent.setBorder(null);
		
		JButton closeBtn = new JButton();
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		closeBtn.setIcon(closeIcon);
		closeBtn.setBorder(null);
				
		closeBtn.setBackground(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(indent, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(closeBtn, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addGap(178)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(indent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
				.addComponent(closeBtn, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
			
		);
		setLayout(groupLayout);
	}
}
