package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReportManagement {

	public ReportManagement()
	{
		JFrame mainf=new JFrame();
		
		JButton roomreport=new JButton("Room Report");
		roomreport.setBounds(50,10, 150, 40);
		JButton bookreport=new JButton("Booking Report");
		bookreport.setBounds(50,60, 150, 40);
		
		
		mainf.add(roomreport);
		mainf.add( bookreport);
		mainf.setSize(300,250);
		mainf.setLocationRelativeTo(null);
		mainf.setLayout(null);
	    mainf.setVisible(true);
	    
	    roomreport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f4=new JFrame();
				String user="root";
				String pass="abc123";
				String url ="jdbc:mysql://localhost:3306/hostelmanagement";
				Statement st=null;
				 
					 
				try {
					Class.forName("com.mysql.jdbc.Driver");
				
					Connection con = DriverManager.getConnection(url, user, pass);
					 st=con.createStatement();
				} catch (Exception x) {
					x.printStackTrace();
				}
				String sql="select * from roommanagement ";
				String columns[]={"Room no","Floor","Roomtype","Beds"};
				String data[][]=new String[50][4];
				try {
					
					ResultSet rs=st.executeQuery(sql);
					int i=0;
					while (rs.next()) {
						int roomno=rs.getInt("roomno");
						String floor=rs.getString("floorno");
						String roomtype=rs.getString("roomtype");
						String beds=rs.getString("beds");
						data[i][0]=roomno+" ";
						data[i][1]=floor;
						data[i][2]=roomtype;
						data[i][3]=beds;
						i++;
						
					
				}} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				DefaultTableModel model=new DefaultTableModel(data,columns);
				
				JTable jt=new JTable(model);
				jt.setBounds(30, 40, 200, 300);
				JScrollPane sp=new JScrollPane(jt);
				f4.add(sp);
				f4.setSize(300,400);
				f4.setLocationRelativeTo(null);
			    f4.setVisible(true);
				mainf.dispose();
			}
		} );
		
	    bookreport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f5=new JFrame();
				String user="root";
				String pass="abc123";
				String url ="jdbc:mysql://localhost:3306/hostelmanagement";
				Statement st=null;
				 
					 
				try {
					Class.forName("com.mysql.jdbc.Driver");
				
					Connection con = DriverManager.getConnection(url, user, pass);
					 st=con.createStatement();
				} catch (Exception x) {
					x.printStackTrace();
				}
				String sql="select * from bookingmanagement ";
				String columns1[]={"Name","Address","City","Pincode","Mobile no","Room Alloted","Checkin Date","Room Type","No of beds"};
				String data1[][]=new String[50][9];
				try {
					
					ResultSet rs=st.executeQuery(sql);
					int i=0;
					while (rs.next()) {
						String name=rs.getString(1);
						String address=rs.getString(2);
						String city=rs.getString(3);
						double pin=rs.getDouble(4);
						double mobno=rs.getDouble(5);
						int roomno=rs.getInt(6);
						String checkin=rs.getString(7);
						String roomtype=rs.getString(8);
						String beds=rs.getString(9);
						data1[i][0]=name;
						data1[i][1]=address;
						data1[i][2]=city;
						data1[i][3]=pin+"";
						data1[i][4]=mobno+"";
						data1[i][5]=roomno+"";
						data1[i][6]=checkin;
						data1[i][7]=roomtype;
						data1[i][8]=beds;
						i++;
						
					
				}} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				DefaultTableModel model1=new DefaultTableModel(data1,columns1);
				
				JTable jt1=new JTable(model1);
				jt1.setBounds(30, 40, 200, 300);
				JScrollPane sp1=new JScrollPane(jt1);
				f5.add(sp1);
				f5.setSize(800,500);
				f5.setLocationRelativeTo(null);
			    f5.setVisible(true);
				mainf.dispose();
			}
		});

    
    
	}
}
