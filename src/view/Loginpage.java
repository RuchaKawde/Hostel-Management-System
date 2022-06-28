package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Loginpage extends JFrame {
	
	
	
	public Loginpage()
	{
		
		JFrame f1=new JFrame("Hostel Management");
		JFrame f0=new JFrame();
		JLabel lb1=new JLabel("Username");
	    lb1.setBounds(50,20,100, 40);
	    JTextField txtuser=new JTextField();
	    txtuser.setBounds(150,20, 100, 40);
	    
	    JLabel lb2=new JLabel("Password");
	    lb2.setBounds(50,70,100, 40);
	    JPasswordField txtpwd=new JPasswordField();
	    txtpwd.setBounds(150,70, 100, 40);
	    
	    JButton btn1=new JButton("Submit");
	    btn1.setBounds(150, 120, 100, 40);
	    btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String userValue=txtuser.getText();
				String passValue=txtpwd.getText();
				if(userValue.equals("Admin")&& passValue.equals("2022"))
				{new Menupage();
				f1.dispose();
				}
				else
				JOptionPane.showMessageDialog(f0, "Username or Password incorrect","Alert",JOptionPane.WARNING_MESSAGE);
			}
		});
	    
	    
	    f1.add(lb1);
	    f1.add(txtuser);
	    f1.add(lb2);
	    f1.add(txtpwd);
	    f1.add(btn1);
	    f1.setSize(350, 300);
	    f1.setLayout(null);
	 //   f1.setLocationRelativeTo(null);
	//    f1.add(imglabel);
	//    f1.pack();
	    f1.setVisible(true);
	   
	}

}
