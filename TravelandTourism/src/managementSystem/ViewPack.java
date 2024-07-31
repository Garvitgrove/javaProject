package managementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class ViewPack extends JFrame implements ActionListener{
	JButton back;
	String username;
	ViewPack(String username)
	{
		setBounds(360,190,940,520);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel text= new JLabel("PACKAGE DETAILS");
		text.setFont(new Font("Tahoma",Font.BOLD,30));
		text.setForeground(Color.BLUE);
		text.setBounds(300, 5, 300, 30);
		add(text);
		
		JLabel labusername= new JLabel("USERNAME");
		labusername.setBounds(30, 40, 150, 25);
		labusername.setFont(new Font("raleway",Font.BOLD,16 ));
		labusername.setForeground(Color.red);
		add(labusername);
		JLabel ansusername= new JLabel();
		ansusername.setBounds(180, 40, 150, 25);
		ansusername.setFont(new Font("raleway",Font.BOLD,16 ));
		ansusername.setForeground(Color.red);
		add(ansusername);
		
		JLabel pack= new JLabel("PACKAGE NAME");
		pack.setBounds(30, 90, 150, 25);
		pack.setFont(new Font("raleway",Font.BOLD,16 ));
		pack.setForeground(Color.red);
		add(pack);
		JLabel apack= new JLabel();
		apack.setBounds(180, 90, 150, 25);
		apack.setFont(new Font("raleway",Font.BOLD,16 ));
		apack.setForeground(Color.red);
		add(apack);
		JLabel person= new JLabel("TOTAL PERSON");
		person.setBounds(30, 140, 150, 25);
		person.setFont(new Font("raleway",Font.BOLD,16 ));
		person.setForeground(Color.red);
		add(person);
		JLabel aperson= new JLabel();
		aperson.setBounds(180, 140, 150, 25);
		aperson.setFont(new Font("raleway",Font.BOLD,16 ));
		aperson.setForeground(Color.red);
		add(aperson);
		JLabel id= new JLabel("IDENTITY");
		id.setBounds(30, 190, 150, 25);
		id.setFont(new Font("raleway",Font.BOLD,16 ));
		id.setForeground(Color.red);
		add(id);
		JLabel aid= new JLabel();
		aid.setBounds(180, 190, 150, 25);
		aid.setFont(new Font("raleway",Font.BOLD,16 ));
		aid.setForeground(Color.red);
		add(aid);
		JLabel number= new JLabel("NUMBER");
		number.setBounds(30, 240, 150, 25);
		number.setFont(new Font("raleway",Font.BOLD,16 ));
		number.setForeground(Color.red);
		add(number);
		JLabel anumber= new JLabel();
		anumber.setBounds(180, 240, 150, 25);
		anumber.setFont(new Font("raleway",Font.BOLD,16 ));
		anumber.setForeground(Color.red);
		add(anumber);
		JLabel phn= new JLabel("PHONE NO.");
		phn.setBounds(30, 290, 150, 25);
		phn.setFont(new Font("raleway",Font.BOLD,16 ));
		phn.setForeground(Color.red);
		add(phn);
		JLabel aphn= new JLabel();
		aphn.setBounds(180, 290, 150, 25);
		aphn.setFont(new Font("raleway",Font.BOLD,16 ));
		aphn.setForeground(Color.red);
		add(aphn);
		JLabel price= new JLabel("PACKAGE PRICE");
		price.setBounds(30, 340, 150, 25);
		price.setFont(new Font("raleway",Font.BOLD,16 ));
		price.setForeground(Color.red);
		add(price);
		JLabel aprice= new JLabel();
		aprice.setBounds(180, 340, 150, 25);
		aprice.setFont(new Font("raleway",Font.BOLD,16 ));
		aprice.setForeground(Color.red);
		add(aprice);
		
	
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
		Image i2 = i1.getImage().getScaledInstance(940, 520, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 940, 520);
		add(image);
		back = new JButton("BACK");
		back.setBorder(BorderFactory.createEmptyBorder());
		back.setBackground(new Color(40, 54, 99));
		back.setForeground(Color.white);
		back.setBounds(80, 400, 80, 25);
		back.addActionListener(this);
		image.add(back);
		
		try {
			Conn c = new Conn();
			String query = "SELECT * FROM PACKAGE WHERE USERNAME = '  "+username+"';";
		    ResultSet rs = c.s.executeQuery(query);
		    while(rs.next())
		    {
		    	ansusername.setText(rs.getString("USERNAME"));
		    	aid.setText(rs.getString("ID"));
		    	anumber.setText(rs.getString("NUMBER"));
		    	aprice.setText(rs.getString("PRICE"));
		    	aperson.setText(rs.getString("PERSONS"));
		    	apack.setText(rs.getString("PACKAGE"));
		    	aphn.setText(rs.getString("PHONE"));
		    }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new ViewPack("gg12");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		
	}

}

