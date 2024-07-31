package managementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Login extends JFrame implements ActionListener {
	JButton login,fpassword, signup;
	JTextField tpassword,tusername;
	JPanel p2;
	Login()
	{
	   setSize(900,490);
	   setLocation(200,100);
	   setLayout(null);
	   JPanel p1= new JPanel();
	   p1.setBackground(Color.white);
	   p1.setBounds(0, 0, 400, 490);
	   p1.setLayout(null);
	   add(p1);
	   
	   
	   p2 = new JPanel();
	   p2.setLayout(null);
	   p2.setBackground(new Color(133,193,233));
	   p2.setBounds(400, 0, 550, 500);
	   add(p2);
	   
	   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login1.png"));
	   Image i2 = i1.getImage().getScaledInstance(160, 150, Image.SCALE_DEFAULT);
	   ImageIcon i3 = new ImageIcon(i2);
	   JLabel image = new JLabel(i3);
	   image.setBounds(110, 95, 160, 150);
	   p1.add(image);
	   ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icons/login2.jpg"));
	   Image im2 = im1.getImage().getScaledInstance(140, 80, Image.SCALE_DEFAULT);
	   ImageIcon im3 = new ImageIcon(im2);
	   JLabel image1 = new JLabel(im3);
	   image1.setBounds(120, 260, 140, 80);
	   p1.add(image1);
	   
	   JLabel username= new JLabel("USERNAME : ");
	   username.setBounds(50, 40, 200, 25);
	   username.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	   p2.add(username);
	   
	   tusername = new JTextField();
	   tusername.setBounds(50, 75, 200, 30);
	   tusername.setBorder(BorderFactory.createEmptyBorder());
	   p2.add(tusername);
	   setVisible(true);
	   
	   JLabel password = new JLabel("PASSWORD : ");
	   password.setBounds(50, 120, 200, 25);
	   password.setFont(new Font("SAN_SERIF ",Font.PLAIN,20));
	   p2.add(password);
	   tpassword = new JTextField();
	   tpassword.setBounds(50, 145, 200, 30);
	   tpassword.setBorder(BorderFactory.createEmptyBorder());
	   p2.add(tpassword);
	   
	   login= new JButton("LOGIN");
	   login.setBounds(50, 230, 110, 40);
	   login.setBackground(new Color(130, 180, 221));
	   login.setForeground(Color.white);
	   login.setFont(new Font("SAN_SERIF",Font.BOLD,15));
	   login.setBorder(new LineBorder(Color.BLACK));
	   login.addActionListener(this);
	   p2.add(login);
	   
	   signup= new JButton("SIGN UP");
	   signup.setBounds(280, 230, 110, 40);
	   signup.setBackground(new Color(130, 180, 221));
	   signup.setForeground(Color.white);
	   signup.setFont(new Font("SAN_SERIF",Font.BOLD,15));
	   signup.setBorder(new LineBorder(Color.BLACK));
	   signup.addActionListener(this);
	   p2.add(signup);
	   
	   fpassword= new JButton("FORGOT PASSWORD");
	   fpassword.setBounds(125, 290, 180, 40);
	   fpassword.setBackground(new Color(130, 180, 221));
	   fpassword.setForeground(Color.white);
	   fpassword.setFont(new Font("SAN_SERIF",Font.BOLD,15));
	   fpassword.setBorder(new LineBorder(Color.BLACK));
	   fpassword.addActionListener(this);
	   p2.add(fpassword);
	   
	   JLabel text = new JLabel("Error in login...");
	   text.setBounds(320, 310, 150 , 20);
	   text.setForeground(Color.red);
	   text.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
       p2.add(text);
	   
   }

	public static void main(String[] args)
	{
		new Login();

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==login)
		{
			String un=tusername.getText();
			String ps=tpassword.getText();
			String query= "SELECT * FROM ACCOUNT WHERE USERNAME = ' "+un+"' AND PASSWORD ='"+ps+"'";
			try {
				Conn c = new Conn();
				ResultSet r = c.s.executeQuery(query);
				if(r.next())
				{
					setVisible(false);
					new Loading(un);
				}
				else {
					JOptionPane.showMessageDialog(null, "INCORRECT USERNAME OR PASSWORD");
					
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==signup)
		{
			setVisible(false);
			new Signup();
		}
		else if(e.getSource()==fpassword)
		{
			setVisible(false);
			new ForgetPass();
			
		}
	}

}
