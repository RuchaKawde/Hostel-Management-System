package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Hostel;
import model.HostelDao;

public class BookingManagement {
	
	
	public static String r1;
	  
	public BookingManagement()
	{

		JFrame checkin=new JFrame("Booking Management");
		JFrame falert=new JFrame();
		JButton cin=new JButton("New Registration");
		cin.setBounds(50,10, 150, 40);
		JButton cout=new JButton("Delete Registration");
		cout.setBounds(50,60, 150, 40);
		 ImageIcon img2=new ImageIcon("C:\\Users\\Hp\\Desktop\\room.jpeg");
		    JLabel imglabel2=new JLabel(img2);
		
		checkin.add(cin);
		checkin.add(cout);
		checkin.setSize(300,250);
		checkin.setLayout(null);
	//	checkin.setLocationRelativeTo(null);
	//	checkin.add(imglabel2);
	//	checkin.pack();	
	    checkin.setVisible(true);
	    
	    cin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
		JFrame f4=new JFrame();
		JLabel lbname=new JLabel("Candidate Name:");
	    lbname.setBounds(50,20,100, 40);
	    JTextField txtName=new JTextField();
	    txtName.setBounds(150,20, 100, 40);
	    
	    JLabel lbaddress=new JLabel("Address:");
	    lbaddress.setBounds(50,70,100, 40);
	    JTextField txtAddress1=new JTextField();
	    txtAddress1.setBounds(150,70, 300, 40);
	   
	    
	    JLabel lbcity=new JLabel("City:");
	    lbcity.setBounds(50,120,100, 40);
	    String[] city={" ","Nagpur","Pune","Mumbai","Amaravati","Wardha"};
	    JComboBox cbcity=new JComboBox(city);
	   cbcity.setBounds(150,120, 100, 40);
	   
	   JLabel lbpin=new JLabel("Postal Code:");
	    lbpin.setBounds(50,170,100, 40);
	    JTextField txtPin=new JTextField();
	    txtPin.setBounds(150,170, 100, 40);
	    
	    JLabel lbmob=new JLabel("Phone no:");
	    lbmob.setBounds(50,220,100, 40);
	    JTextField txtMob=new JTextField();
	    txtMob.setBounds(150,220, 100, 40);
	    
		JLabel lbtype=new JLabel("Room type:");
	    lbtype.setBounds(50,270,100, 40);
	    String[] roomtype={" ","AC","Non-AC"};
	    JComboBox cbtype=new JComboBox(roomtype);
	   cbtype.setBounds(150,270, 100, 40);
	   
	   JLabel lbbeds=new JLabel("No of Beds:");
	    lbbeds.setBounds(260,270,100, 40);
	    String[] beds={" ","Single","Two Beds","Four Beds"};
	    JComboBox cbbeds=new JComboBox(beds);
	   cbbeds.setBounds(370,270, 100, 40);
	
	  
		JLabel lballot=new JLabel("Room Alloted:");
		lballot.setBounds(480,270,100, 40);
		JComboBox cbBook=  new JComboBox();
		cbBook.setBounds(570,270, 100, 40);
	
			cbbeds.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent arg0) {
		        ArrayList <String>ar=new ArrayList<String> ();
					String user="root";
					String pass="abc123";
					String url ="jdbc:mysql://localhost:3306/hostelmanagement";
					Statement st=null;
					 String cb1=cbbeds.getSelectedItem().toString();
						String cb2=cbtype.getSelectedItem().toString();
						 
					try {
						Class.forName("com.mysql.jdbc.Driver");
					
						Connection con = DriverManager.getConnection(url, user, pass);
						 st=con.createStatement();
					} catch (Exception e) {
						e.printStackTrace();
					}
					String sql="select * from roommanagement where beds ='"+cb1+"'and roomtype ='"+cb2+"'";
					try {
						
						ResultSet rs=st.executeQuery(sql);
						while (rs.next()) {
							cbBook.addItem(rs.getString(1));
						}
					
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					

				}
			});
			
	  
	    JLabel lbin=new JLabel("Checked In Date:");
	    lbin.setBounds(50,320,100, 40);
	    JFormattedTextField txtIn=new JFormattedTextField();
	    txtIn.setBounds(150,320, 100, 40);
	   
	   Calendar cal=Calendar.getInstance();
	   SimpleDateFormat df=new SimpleDateFormat("MM-dd-yyyy"); 
	   txtIn.setText(df.format(cal.getTime()));
	   
	   JLabel lbresult=new JLabel();
		lbresult.setBounds(350, 470, 200, 40);

	    
	    JButton checkin=new JButton("Check In");
		checkin.setBounds(350,420, 150, 40);
		 checkin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 Hostel r=new Hostel();
				r.setName(txtName.getText());
				r.setAddress(txtAddress1.getText());
				r.setCity(cbcity.getSelectedItem().toString());
				r.setPincode(Double.parseDouble(txtPin.getText()));
				r.setMobno(Double.parseDouble(txtMob.getText()));
				r.setRoomallot(Integer.parseInt(cbBook.getSelectedItem().toString()));
			    r.setIndate(txtIn.getText());
			    r.setRoomtype(cbtype.getSelectedItem().toString());
			    r.setBeds(cbbeds.getSelectedItem().toString());
			    System.out.println(cbBook.getSelectedItem());
				int a=HostelDao.addbooking(r);
				cbBook.removeAllItems();
				txtName.setText(" ");
				txtAddress1.setText(" ");
				txtPin.setText(" ");
				txtMob.setText(" ");
				cbcity.setSelectedItem(" ");
				cbbeds.setSelectedItem(" ");
				cbtype.setSelectedItem(" ");
				
				
				if(a>0)
					lbresult.setText("Data Entered Successfully");
				else
					JOptionPane.showMessageDialog(falert, "This room is already alloted select other room","Alert",JOptionPane.WARNING_MESSAGE);
			}
			
		});
		
		
	
		  txtIn.setEditable(false);
		f4.add(checkin);
	    f4.add(lbname);
	    f4.add(txtName);
	    f4.add(lbaddress);
	    f4.add(lbcity);
	    f4.add(txtPin);
	    f4.add(lbmob);
	    f4.add(txtMob);
	    f4.add(lbpin);
	    f4.add(cbcity);
	    f4.add(txtAddress1);
	    f4.add(lballot);
	    f4.add(cbBook);
	    f4.add(lbin);
	    f4.add(txtIn);
	    f4.add(lbtype);
	    f4.add(cbtype);
	    f4.add(lbbeds);
	    f4.add(cbbeds);
	    f4.add(lbresult);
	    f4.setSize(800,600);
	    f4.setLayout(null);
	  //  f4.setLocationRelativeTo(null);
	  //  f4.add(imglabel2);
	 //   f4.pack();
	    f4.setVisible(true);
	  
	    
			}

			
		} );
	    
	    cout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			    JFrame f5=new JFrame();
			    
			    JLabel lballot=new JLabel("Room Alloted:");
			    lballot.setBounds(50,70,100, 40);
			    JTextField txtBook=new JTextField();
			    txtBook.setBounds(150,70, 100, 40);
				
			    JLabel lb2=new JLabel("Candidate Name:");
			    lb2.setBounds(50,20,100, 40);
			    JTextField txtName=new JTextField();
			    txtName.setBounds(150,20, 100, 40);
			    
			    JLabel lbin=new JLabel("Check in Date:");
			    lbin.setBounds(50,120,100, 40);
			    JTextField txtin=new JTextField();
			    txtin.setBounds(150,120, 100, 40);
			    
			    JLabel lbout=new JLabel("Check Out Date:");
			    lbout.setBounds(50,170,120, 40);
			    JTextField txtOut=new JTextField();
			    txtOut.setBounds(150,170, 100, 40);
			    
			    Calendar cal=Calendar.getInstance();
				   SimpleDateFormat df=new SimpleDateFormat("MM-dd-yyyy"); 
				   txtOut.setText(df.format(cal.getTime()));
			    
			    JButton submit=new JButton("Search");
			    submit.setBounds(50, 250, 100, 40);
			submit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
			
					String user="root";
					String pass="abc123";
					String url ="jdbc:mysql://localhost:3306/hostelmanagement";
					Statement st=null;
					 r1=txtName.getText();
						
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					
						Connection con = DriverManager.getConnection(url, user, pass);
						 st=con.createStatement();
					} catch (Exception e) {
						e.printStackTrace();
					}
					String sql="select * from bookingmanagement where name ='"+r1+"'";
					try {
						
						ResultSet rs=st.executeQuery(sql);
						while (rs.next()) {
							
						txtin.setText(rs.getString(7));
						txtBook.setText(rs.getString(6));
						
						}
						
					
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
					
				}
			});
						
						
			
			    JButton checkout=new JButton("Checkout");
			    checkout.setBounds(150, 250, 100, 40);
				
			    checkout.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						HostelDao.deleteCandidate(txtName.getText());
				
					}
				});
			    
			    
			    f5.add(lbin);
			    f5.add(submit);
			    f5.add(txtin);
			    f5.add(txtName);
			    f5.add(txtBook);
			    f5.add(txtOut);
			    f5.add(lb2);
			    f5.add( lballot);
			    f5.add(lbout);
			    f5.add(checkout);
			    f5.setSize(400,350);
			    f5.setLocationRelativeTo(null);
			    f5.setLayout(null);
			    f5.setVisible(true);
			    
			}
		
	});}}



/*	public boolean validation(){
StringBuilder errorText = new StringBuilder();

if(txtName.getText().length() == 0 ){
    errorText.append("Textfield 1 is mandatory\n");
    txtName.setForeground(Color.red);
  }

return;
}


submit.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == submit ) {
		boolean valid = validation();
		if(valid) {
            JOptionPane.showMessageDialog(this, "Candidate added successfully");
            jframe.dispose();
            new MenuPage();
	
}
}}});*/

