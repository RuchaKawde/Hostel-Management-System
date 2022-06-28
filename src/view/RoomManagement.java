package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Hostel;
import model.HostelDao;


public class RoomManagement {
	
	public Hostel h=new Hostel();
	public static ArrayList<Integer> roomno=new ArrayList<>();
    int rm;
	int a=0;
	public RoomManagement()
	{
		
		 
		JFrame f3=new JFrame("Room Management");
		JLabel lbroomno=new JLabel("Room No:");
	    lbroomno.setBounds(50,20,100, 40);
	    JTextField txtRoomno=new JTextField();
	    txtRoomno.setBounds(150,20, 100, 40);
		//roomno.add(Integer.parseInt(txtRoomno.getText()));
	    
	    JLabel lbf=new JLabel("Floor No:");
	    lbf.setBounds(300,20,100, 40);
	    String[] floor={"Ground","First","Second","Third"};
	    JComboBox <String>cbtypef=new JComboBox<>(floor);
	    cbtypef.setBounds(350,20, 100, 40);
	    
		JLabel lbtype=new JLabel("Room type:");
	    lbtype.setBounds(50,70,100, 40);
	    String[] roomtype={"AC","Non-AC"};
	    JComboBox cbtype=new JComboBox(roomtype);
	   cbtype.setBounds(150,70, 100, 40);
	   
	   JLabel lbbeds=new JLabel("No of Beds:");
	    lbbeds.setBounds(50,120,100, 40);
	    String[] beds={"Single","Two Beds","Four Beds"};
	    JComboBox cbtype1=new JComboBox(beds);
	   cbtype1.setBounds(150,120, 100, 40);
	   
	   JLabel lbresult=new JLabel();
		lbresult.setBounds(300, 250, 100, 40);
		
		JButton close=new JButton("OK");
		close.setBounds(350, 200, 100, 40);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f3.dispose();
				
			}
		});
	   
	   JButton submit=new JButton("Submit");
	    submit.setBounds(150, 200, 100, 40);
	    submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			     Hostel h=new Hostel();
			    
				h.setRoomno(Integer.parseInt(txtRoomno.getText()));
				h.setFloorno(cbtypef.getSelectedItem().toString());
				h.setRoomtype(cbtype.getSelectedItem().toString());
				h.setBeds(cbtype1.getSelectedItem().toString());
				a=HostelDao.addRoom(h);
				if(a>0)
					lbresult.setText("Data Entered Successfully");
				else 
					lbresult.setText("This room is already ");
				
			}
		});
	    
	    f3.add(close);
	    f3.add(lbroomno);
	    f3.add(txtRoomno);
	    f3.add(lbtype);
	    f3.add(cbtype);
	    f3.add(lbbeds);
	    f3.add(cbtype1);
	    f3.add(lbf);
	    f3.add(cbtypef);
	    f3.add(submit);
	    f3.add(lbresult);
	    f3.setSize(800,400);
	    f3.setLocationRelativeTo(null);
	    f3.setLayout(null);
	    f3.setVisible(true);
	}

}

/*public boolean validation(){
    	StringBuilder errorText = new StringBuilder();

    	if(fillName.getText().length() == 0 ){
		    errorText.append("Textfield 1 is mandatory\n");
		    fillName.setForeground(Color.red);
		  }
    	
    	return errorText.length() == 0;
    }

   

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkOutBtn ) {
			boolean valid = validation();
			if(valid) {
                JOptionPane.showMessageDialog(this, "Room Successfully Check Out");
                jframe.dispose();
                new MenuPage();
            
			}
        }
}*/
