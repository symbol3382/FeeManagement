package com.mp;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mp.dao.StudentDao;
import com.mp.model.User;

public class DueFee extends JFrame {
	static DueFee frame;
	public DueFee() {
		List<User>list=StudentDao.view();
		int size=list.size();
		
		String data[][]=new String[size][12];
		int row=0;
		
		for(User s:list){
			data[row][0]=String.valueOf(s.getRollno());
			data[row][1]=s.getName();
			data[row][2]=s.getEmail();
			data[row][3]=s.getCourse();
			data[row][4]=String.valueOf(s.getFee());
			data[row][5]=String.valueOf(s.getPaid());
			data[row][6]=String.valueOf(s.getDue());
			data[row][7]=s.getAddress();
			data[row][8]=s.getCity();
			data[row][9]=s.getState();
			data[row][10]=s.getCountry();
			data[row][11]=s.getContactno();
			
			row++;
		}
		String columnNames[]={"Rollno","Name","Email","Course","Fee","Paid","Due","Address","City","State","Country","Contact No"};
		
		JTable jt=new JTable(data,columnNames);
		JScrollPane js=new JScrollPane(jt);
		add(js);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
	}

	public static void main(String[] strings) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					frame=new DueFee();
					frame.setVisible(true);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}

}