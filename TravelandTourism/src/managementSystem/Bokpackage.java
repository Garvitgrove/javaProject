package managementSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;


public class Bokpackage extends JFrame implements ActionListener{
	
	Choice cpackage;
	JTextField tperson;
	String username;
	JLabel ansusername,aid,aphn,anum,aprice;
	JButton checkprice,bookpack,back;
	Bokpackage(String username)
	{
		this.username=username;
		setBounds(320,200,1000,480);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel text= new JLabel("BOOK PACKAGE");
		text.setBounds(100, 10, 250, 30);
		text.setForeground(Color.blue);
		text.setFont(new Font("Tahoma",Font.BOLD,30));
		add(text);
		
		JLabel labusername= new JLabel("USERNAME");
		labusername.setBounds(40, 70, 100, 20);
		labusername.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(labusername);
	    ansusername= new JLabel();
		ansusername.setBounds(210, 70, 150, 20);
		ansusername.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(ansusername);
		
		JLabel spack= new JLabel("SELECT PACKAGE");
		spack.setBounds(40, 110, 150, 20);
		spack.setFont(new Font("Tahoma",Font.PLAIN,15));

		add(spack);
		cpackage= new Choice();
		cpackage.add("GOLD PACKAGE");
		cpackage.add("DIAMOND PACKAGE");
		cpackage.add("SILVER PACKAGE");
		cpackage.setBounds(210, 110, 150, 20);
		add(cpackage);
		
		JLabel person= new JLabel("TOTAL PERSONS");
		person.setBounds(40, 150, 150, 20);
		person.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(person);
		tperson = new JTextField("1");
		tperson.setBounds(210, 150, 150, 20);
		add(tperson);
		
		JLabel id= new JLabel("IDENTITY");
		id.setBounds(40, 190, 150, 20);
		id.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(id);
		aid= new JLabel();
		aid.setBounds(210, 190, 150, 20);
		add(aid);
		
		JLabel num= new JLabel("NUMBER");
		num.setBounds(40, 230, 150, 20);
		num.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(num);
	    anum= new JLabel();
		anum.setBounds(210, 230, 150, 20);
		add(anum);
		
		JLabel phn= new JLabel("PHONE");
		phn.setBounds(40, 270, 150, 20);
		phn.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(phn);
	    aphn= new JLabel();
		aphn.setBounds(210, 270, 150, 20);
		add(aphn);
		

		JLabel price= new JLabel("TOTAL PRICE");
		price.setBounds(40, 310, 150, 20);
		price.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(price);
	    aprice= new JLabel();
		aprice.setBounds(210, 310, 150, 20);
		add(aprice);
		
		try {
			Conn c = new Conn();
			String query = "SELECT * FROM CUSTOMER WHERE USERNAME = '  "+username+"';";
		    ResultSet rs = c.s.executeQuery(query);
		    while(rs.next())
		    {
		    	ansusername.setText(rs.getString("USERNAME"));
		    	aid.setText(rs.getString("ID"));
		    	anum.setText(rs.getString("NUMBER"));
		    	aphn.setText(rs.getString("PHONE"));
		    }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		checkprice = new JButton("CHECK PRICE");
		checkprice.setBackground(Color.black);
		checkprice.setForeground(Color.white);
		checkprice.setBounds(60, 380, 120, 25);
		checkprice.addActionListener(this);
		add(checkprice);
		bookpack = new JButton("BOOK ");
		bookpack.setBackground(Color.black);
		bookpack.setForeground(Color.white);
		bookpack.setBounds(200, 380, 100, 25);
		bookpack.addActionListener(this);
		add(bookpack);
		back = new JButton("BACK ");
        back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(320, 380, 100, 25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
		Image i2=i1.getImage().getScaledInstance(600, 480, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image =new JLabel(i3);
		image.setBounds(430, 0, 600, 480);
		add(image);

		setVisible(true);
	}

	public static void main(String[] args) {

		new Bokpackage("gg12");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==checkprice)
		{
			String pack=cpackage.getSelectedItem();
			int cost=0;
			if (pack.equals("GOLD PACKAGE"))
			{
				cost+=32000;
			}else if (pack.equals("DIAMOND PACKAGE"))
			{
				cost+=26000;

			}else {
				cost+=20000;

			}
			int person=Integer.parseInt(tperson.getText());
			cost*=person;
			aprice.setText("Rs. "+cost);
			
		}else if (e.getSource()==bookpack)
		{
			try {
				Conn c = new Conn();
				c.s.executeUpdate("INSERT INTO PACKAGE VALUES('"+ansusername.getText()+"' , '"+cpackage.getSelectedItem()+"','"+tperson.getText()+"','"+aid.getText()+"','"+anum.getText()+"','"+aphn.getText()+"','"+aprice.getText()+"');");
			    JOptionPane.showMessageDialog(null, "PACKAGE BOOKED SUCCESSFULLY");
			    setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}

}
