package managementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Addcustomer extends JFrame implements ActionListener {
	JLabel ausername,ansusername, id,number, name, aname;
	JComboBox comboid;
	JTextField tnum,tcountry,taddress,tphone,temail;
	JRadioButton rmale,rfemale,rother;
	JButton add,back;

	@SuppressWarnings("unchecked")
	Addcustomer(String username)
	{
		setBounds(400,190,850,500);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
	    ausername = new JLabel("USERNAME ");
		ausername.setBounds(30, 30, 150, 25);
		ausername.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(ausername);
		
		ansusername =new JLabel();
		ansusername.setBounds(190, 32, 170, 25);
		ansusername.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(ansusername);
		
		id=new JLabel("IDENTITY");
		id.setBounds(30, 70, 150, 25);
		id.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(id);
		
		comboid = new JComboBox(new String[] {"PASSPORT" , "AADHAR CARD" , "PAN CARD", "DRIVING LICENCE"});
		comboid.setBounds(190, 72, 170, 25);
		comboid.setBackground(Color.white);
		add(comboid);
		
		number = new JLabel("NUMBER ");
		number.setBounds(30, 110, 150, 25);
		number.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(number);
		tnum= new JTextField();
		tnum.setBounds(190, 112, 170, 25);
		add(tnum);
		
		name= new JLabel("NAME ");
		name.setBounds(30, 150, 150, 25);
		name.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(name);
		aname = new JLabel();
		aname.setBounds(190, 150, 150, 25);
		aname.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(aname);
		
		JLabel gender= new JLabel("GENDER ");
		gender.setBounds(30, 190, 150, 25);
		gender.setFont(new Font("SAN_SERIF",Font.BOLD,16));

		add(gender);
		
		rmale = new JRadioButton("MALE");
		rmale.setBounds(170, 190, 170, 25);
		rmale.setBackground(Color.white);
		add(rmale);
		rfemale = new JRadioButton("FEMALE");
		rfemale.setBounds(240, 190, 170, 25);
		rfemale.setBackground(Color.white);
		add(rfemale);
		rother = new JRadioButton("OTHER");
		rother.setBounds(320, 190, 170, 25);
		rother.setBackground(Color.white);
		add(rother);
		JLabel country= new JLabel("COUNTRY ");
		country.setBounds(30, 230, 150, 25);
		country.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        add(country);
		tcountry= new JTextField();
		tcountry.setBounds(190, 230, 170, 25);
		add(tcountry);
		
		JLabel address= new JLabel("ADDRESS ");
		address.setBounds(30, 270, 150, 25);
		address.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        add(address);
		taddress= new JTextField();
		taddress.setBounds(190, 270, 170, 25);
		add(taddress);
		
		JLabel phone= new JLabel("PHONE NO.");
		phone.setBounds(30, 310, 150, 25);
		phone.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        add(phone);
		tphone= new JTextField();
		tphone.setBounds(190, 310, 170, 25);
		add(tphone);
		
		JLabel email= new JLabel("EMAIL ID ");
		email.setBounds(30, 350, 150, 25);
		email.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        add(email);
		temail= new JTextField();
		temail.setBounds(190, 350, 170, 25);
		add(temail);
		
		add= new JButton("ADD");
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        add.setBounds(70, 410, 90, 25);
        add.addActionListener(this);
		add(add);
		back= new JButton("BACK");
		back.setBackground(Color.black);
		back.setForeground(Color.white);		
		back.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        back.setBounds(190, 410, 90, 25);
        back.addActionListener(this);
		add(back);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
		Image i2= i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		image.setBounds(370, 30, 470, 450);
		add(image);
		
		try {
			Conn c=new Conn();
			ResultSet rs = c.s.executeQuery("SELECT * FROM ACCOUNT WHERE USERNAME = ' "+username+"';");
			while(rs.next())
			{
				ansusername.setText(rs.getString("USERNAME"));
				aname.setText(rs.getString("NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new Addcustomer("");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()== add)
		{
			String usname = ansusername.getText();
			String idd = (String) comboid.getSelectedItem();
			String num = tnum.getText();
			String Name= aname.getText();
			String gen = null;
			if(rmale.isSelected())
			{
				gen="MALE";
			}else if(rfemale.isSelected())
			{
				gen="FEMALE";
			}else {
				gen="OTHERS";
			}
			String contry = tcountry.getText();
			String address= taddress.getText();
			String phn = tphone.getText();
			String email=temail.getText();
			
			try {
				Conn c = new Conn();
				String query="INSERT INTO CUSTOMER VALUES(' "+usname+"' , '"+idd+"' , '"+num+"' , '"+Name+"' , '"+gen+"' , '"+contry+"' , '"+address+"' , '"+phn+"', '"+email+"');";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "CUSTOMER DETAILS ADDED SUCCESSFULLY");
				setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
	}

}
