package managementSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Deletedetails extends JFrame implements ActionListener{
	JButton back;
	String username;
	
	Deletedetails(String username)
	{
		this.username=username;
		setBounds(380,180,900,550);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel labusername= new JLabel("USERNAME");
		labusername.setBounds(30, 10, 150, 25);
		add(labusername);
		JLabel ansusername= new JLabel();
		ansusername.setBounds(180, 10, 150, 25);
		add(ansusername);
		
		JLabel id= new JLabel("IDENTITY");
		id.setBounds(30, 70, 150, 25);
		add(id);
		JLabel ansid= new JLabel();
		ansid.setBounds(180, 70, 150, 25);
		add(ansid);
		
		JLabel number= new JLabel("NUMBER");
		number.setBounds(30, 130, 150, 25);
		add(number);
		JLabel anumber= new JLabel();
		anumber.setBounds(180, 130, 150, 25);
		add(anumber);
		
		JLabel name= new JLabel("NAME");
		name.setBounds(30, 190, 150, 25);
		add(name);
		JLabel aname= new JLabel();
		aname.setBounds(180, 190, 150, 25);
		add(aname);
		
		JLabel gender= new JLabel("GENDER");
		gender.setBounds(30, 250, 150, 25);
		add(gender);
		JLabel agender= new JLabel();
		agender.setBounds(180, 250, 150, 25);
		add(agender);
		
		JLabel country= new JLabel("COUNRTY");
		country.setBounds(450, 10, 150, 25);
		add(country);
		JLabel acountry= new JLabel();
		acountry.setBounds(600, 10, 150, 25);
		add(acountry);
		
		JLabel address= new JLabel("ADDRESS");
		address.setBounds(450, 70, 150, 25);
		add(address);
		JLabel aaddress= new JLabel();
		aaddress.setBounds(600, 70, 150, 25);
		add(aaddress);
		
		JLabel phn= new JLabel("PHONE NO.");
		phn.setBounds(450, 130, 150, 25);
		add(phn);
		JLabel aphn= new JLabel();
		aphn.setBounds(600, 130, 150, 25);
		add(aphn);
		
		JLabel email= new JLabel("EMAIL ID");
		email.setBounds(450, 190, 150, 25);
		add(email);
		JLabel aemail= new JLabel();
		aemail.setBounds(600, 190, 150, 25);
		add(aemail);
		
		back = new JButton("DELETE");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(350, 310, 100, 25);
		back.addActionListener(this);
		add(back);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(20, 350, 600, 200);
		add(image);
		ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i6= new ImageIcon(i5);
		JLabel image1 = new JLabel(i6);
		image1.setBounds(625, 350, 600, 200);
		add(image1);
		
		try {
			Conn c = new Conn();
			String query = "SELECT * FROM CUSTOMER WHERE USERNAME = '  "+username+"';";
		    ResultSet rs = c.s.executeQuery(query);
		    while(rs.next())
		    {
		    	ansusername.setText(rs.getString("USERNAME"));
		    	ansid.setText(rs.getString("ID"));
		    	anumber.setText(rs.getString("NUMBER"));
		    	aname.setText(rs.getString("NAME"));
		    	agender.setText(rs.getString("GENDER"));
		    	acountry.setText(rs.getString("COUNTRY"));
		    	aaddress.setText(rs.getString("ADDRESS"));
		    	aphn.setText(rs.getString("PHONE"));
		    	aemail.setText(rs.getString("EMAIL"));
		    }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Deletedetails("gg12");

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			Conn c = new Conn();
			c.s.executeUpdate("DELETE FROM ACCOUNT WHERE USERNAME =' "+username+"';");
			c.s.executeUpdate("DELETE FROM CUSTOMER WHERE USERNAME ='  "+username+"';");
			c.s.executeUpdate("DELETE FROM PACKAGE WHERE USERNAME ='  "+username+"';");
			c.s.executeUpdate("DELETE FROM BOOKHOTEL WHERE USERNAME ='  "+username+"';");

			JOptionPane.showMessageDialog(null, "DATA DELETED SUCCESSFULLY");
			System.exit(0);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

}
