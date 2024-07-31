package managementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class UpdateCustomer extends JFrame implements ActionListener {
	JLabel ausername,ansusername, id,number, name, aname;
	JTextField tnum,tcountry,taddress,tphone,temail,tid,tgen;
	JRadioButton rmale,rfemale,rother;
	JButton update,back;

	UpdateCustomer(String username)
	{
		setBounds(400,190,850,500);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
		text.setBounds(280, 5, 400, 25);
		text.setFont(new Font("Tahoma",Font.BOLD,22));
		add(text);
	    ausername = new JLabel("USERNAME ");
		ausername.setBounds(30, 40, 150, 25);
		ausername.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(ausername);
		
		ansusername =new JLabel();
		ansusername.setBounds(190, 42, 170, 25);
		ansusername.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(ansusername);
		
		id=new JLabel("IDENTITY");
		id.setBounds(30, 80, 150, 25);
		id.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(id);
		
		tid= new JTextField();
		tid.setBounds(190, 80, 170, 25);
		add(tid);
		
		number = new JLabel("NUMBER ");
		number.setBounds(30, 120, 150, 25);
		number.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(number);
		tnum= new JTextField();
		tnum.setBounds(190, 122, 170, 25);
		add(tnum);
		
		name= new JLabel("NAME ");
		name.setBounds(30, 160, 150, 25);
		name.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(name);
		aname = new JLabel();
		aname.setBounds(190, 160, 150, 25);
		aname.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		add(aname);
		
		JLabel gender= new JLabel("GENDER ");
		gender.setBounds(30, 200, 150, 25);
		gender.setFont(new Font("SAN_SERIF",Font.BOLD,16));

		add(gender);
		
		tgen= new JTextField();
		tgen.setBounds(190, 200, 170, 25);
		add(tgen);
		JLabel country= new JLabel("COUNTRY ");
		country.setBounds(30, 240, 150, 25);
		country.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        add(country);
		tcountry= new JTextField();
		tcountry.setBounds(190, 240, 170, 25);
		add(tcountry);
		
		JLabel address= new JLabel("ADDRESS ");
		address.setBounds(30, 280, 150, 25);
		address.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        add(address);
		taddress= new JTextField();
		taddress.setBounds(190, 280, 170, 25);
		add(taddress);
		
		JLabel phone= new JLabel("PHONE NO.");
		phone.setBounds(30, 320, 150, 25);
		phone.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        add(phone);
		tphone= new JTextField();
		tphone.setBounds(190, 320, 170, 25);
		add(tphone);
		
		JLabel email= new JLabel("EMAIL ID ");
		email.setBounds(30, 360, 150, 25);
		email.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        add(email);
		temail= new JTextField();
		temail.setBounds(190, 360, 170, 25);
		add(temail);
		
		update= new JButton("UPDATE");
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.setFont(new Font("SAN_SERIF",Font.BOLD,14));
		update.setBounds(70, 420, 100, 25);
		update.addActionListener(this);
		add(update);
		back= new JButton("BACK");
		back.setBackground(Color.black);
		back.setForeground(Color.white);		
		back.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        back.setBounds(190, 420, 100, 25);
        back.addActionListener(this);
		add(back);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
		Image i2= i1.getImage().getScaledInstance(290, 350, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		image.setBounds(450, 40,290, 380);
		add(image);
		
		try {
			Conn c=new Conn();
			ResultSet rs = c.s.executeQuery("SELECT * FROM CUSTOMER WHERE USERNAME = '  "+username+"';");
			while(rs.next())
			{
				ansusername.setText(rs.getString("USERNAME"));
				aname.setText(rs.getString("NAME"));
				tid.setText(rs.getString("ID"));
				tnum.setText(rs.getString("NUMBER"));
				tgen.setText(rs.getString("GENDER"));
				tcountry.setText(rs.getString("COUNTRY"));
				tphone.setText(rs.getString("PHONE"));
				temail.setText(rs.getString("EMAIL"));
				taddress.setText(rs.getString("ADDRESS"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new UpdateCustomer("gg12");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()== update)
		{
			String usname = ansusername.getText();
			String idd = tid.getText();
			String num = tnum.getText();
			String Name= aname.getText();
			String gen = tgen.getText();
			String contry = tcountry.getText();
			String address= taddress.getText();
			String phn = tphone.getText();
			String email=temail.getText();
			
			try {
				Conn c = new Conn();
				String query="UPDATE CUSTOMER SET USERNAME='  "+usname+"' ,ID= '"+idd+"' ,NUMBER ='"+num+"' , NAME='"+Name+"' ,GENDER= '"+gen+"' , COUNTRY='"+contry+"' ,ADDRESS ='"+address+"' ,PHONE= '"+phn+"', EMAIL='"+email+"';";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "CUSTOMER DETAILS UPDATED SUCCESSFULLY");
				setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
	}

}
