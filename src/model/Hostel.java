package model;

import javax.swing.JComboBox;

public class Hostel {
	String Name;
	String Address;
	Double pincode;
	Double mobno;
	String indate;
	String outdate;
	int roomallot;
	String floorno;
	String roomtype;
	String beds;
	int roomno;
	String city;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFloorno() {
		return floorno;
	}
	public void setFloorno(String floorno) {
		this.floorno=floorno ;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getBeds() {
		return beds;
	}
	public void setBeds(String beds) {
		this.beds = beds;
	}
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(Object object) {
		this.roomno =(int) object;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Double getPincode() {
		return pincode;
	}
	public void setPincode(Double pincode) {
		this.pincode = pincode;
	}
	public Double getMobno() {
		return mobno;
	}
	public void setMobno(Double mobno) {
		this.mobno = mobno;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getOutdate() {
		return outdate;
	}
	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}
	public int getRoomallot() {
		return roomallot;
	}
	

	public void setRoomallot(int a) {
		// TODO Auto-generated method stub
		roomallot=a;
	}
	

	
	
}
