package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Menupage {

	Menupage()
	{
		JFrame f2=new JFrame();
		JButton b2=new JButton("Room Management");
		b2.setBounds(300,50, 150, 40);
		JButton b3=new JButton("Booking Management");
		b3.setBounds(300,140, 150, 40);
		JButton b4=new JButton("Report Management");
		b4.setBounds(300, 230, 150, 40);
		
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				new RoomManagement();
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				new BookingManagement();
			}
		});

		b4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				new ReportManagement();
			}
		});
		f2.add(b2);
		f2.add(b3);
		f2.add(b4);
		f2.setSize(800,400);
		f2.setLocationRelativeTo(null);
	    f2.setLayout(null);
	    f2.setVisible(true);
	}
}
