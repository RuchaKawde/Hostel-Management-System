package model;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import view.BookingManagement;

public class HostelDao {
	
	    public static int roomallot;
	    public static String indate;
		public static int a=0;
		public static Connection con;
		public static Statement st;
		public static void getcon()
		{
			String user="root";
			String pass="abc123";
			String url ="jdbc:mysql://localhost:3306/hostelmanagement";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				con = DriverManager.getConnection(url, user, pass);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public static int addRoom(Hostel h)
		{
			getcon();
			try {
				 st=con.createStatement();
				PreparedStatement pst= con.prepareStatement("insert into roommanagement values(?,?,?,?)");
				pst.setInt(1,h.getRoomno());
				pst.setString(2,h.getFloorno());
				pst.setString(3,h.getRoomtype());
				pst.setString(4,h.getBeds());
				a=pst.executeUpdate();
				con.close();
					

			} catch (SQLException e) {
				e.printStackTrace();
			}
		return a;
		}

		
		public static int addbooking(Hostel r)
		{
			getcon();
			try {
				Statement st=con.createStatement();
				PreparedStatement pst= con.prepareStatement("insert into bookingmanagement values(?,?,?,?,?,?,?,?,?)");
				pst.setString(1,r.getName());
				pst.setString(2,r.getAddress());
				pst.setString(3,r.getCity());
				pst.setDouble(4,r.getPincode());
				pst.setDouble(5,r.getMobno());
				pst.setInt(6,r.getRoomallot());
				pst.setString(7,r.getIndate());
				pst.setString(8,r.getRoomtype());
				pst.setString(9,r.getBeds());
				a=pst.executeUpdate();
				con.close();
					

			} catch (SQLException e) {
				e.printStackTrace();
			}
		return a;
		}
		
		
		public static void deleteCandidate(String r)
		{
			getcon();
				
				try 
				{  
					Statement st=con.createStatement();
				PreparedStatement pst= con.prepareStatement("delete from bookingmanagement where name='"+BookingManagement.r1+"'");
				a=pst.executeUpdate();
				    con.close();
				}
				catch (SQLException e) 
				{
					System.out.println("Error sql "+e);
				}
				
				
		}

}



