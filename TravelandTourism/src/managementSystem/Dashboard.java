package managementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {
	String username;
	JButton persondetail,Cpackage,Payment,about,logout,Dpersondetail,calculator,VBhotel,Bhotel,Destination,Vhotel,Bpackage,Vpersondetail,Upersondetail,Vpackage;
	Dashboard(String username)
	{
		this.username=username;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		JPanel p1= new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(0,0,102));
		p1.setBounds(0, 0, 1600, 70);
		add(p1);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
		Image i2=i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(5, 0, 70, 70);
		p1.add(image);
		
		JLabel heading = new JLabel("DASHBOARD");
		heading.setBounds(90, 12, 300, 40);
		heading.setForeground(Color.white);
		heading.setFont(new Font("TAHOMA",Font.BOLD,22));
		p1.add(heading);
		
		JPanel p2= new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(0,0,102));
		p2.setBounds(0, 65, 300, 900);
		add(p2);
		
		persondetail = new JButton("ADD PERSONAL DETAILS ");
		persondetail.setBounds(0, 5, 300, 40);
		persondetail.setBackground(new Color(0,0,102));
		persondetail.setForeground(Color.white);
		persondetail.setFont(new Font("tahoma",Font.PLAIN,18));
		persondetail.setMargin(new Insets(0,0,0,63));
		persondetail.addActionListener(this);
		p2.add(persondetail);
		
	    Upersondetail = new JButton("UPDATE PERSONAL DETAILS ");
		Upersondetail.setBounds(0, 45, 300, 40);
		Upersondetail.setBackground(new Color(0,0,102));
		Upersondetail.setForeground(Color.white);
		Upersondetail.setFont(new Font("tahoma",Font.PLAIN,18));
		Upersondetail.setMargin(new Insets(0,0,0,35));
		Upersondetail.addActionListener(this);
		p2.add(Upersondetail);
		
	    Vpersondetail = new JButton("MY PERSONAL DETAILS ");
		Vpersondetail.setBounds(0, 85, 300, 40);
		Vpersondetail.setBackground(new Color(0,0,102));
		Vpersondetail.setForeground(Color.white);
		Vpersondetail.setFont(new Font("tahoma",Font.PLAIN,18));
		Vpersondetail.setMargin(new Insets(0,0,0,70));
		Vpersondetail.addActionListener(this);
		p2.add(Vpersondetail);
		
		Dpersondetail = new JButton("DELETE PERSONAL DETAILS ");
		Dpersondetail.setBounds(0, 125, 300, 40);
		Dpersondetail.setBackground(new Color(0,0,102));
		Dpersondetail.setForeground(Color.white);
		Dpersondetail.setFont(new Font("tahoma",Font.PLAIN,18));
		Dpersondetail.setMargin(new Insets(0,0,0,33));
		Dpersondetail.addActionListener(this);
		p2.add(Dpersondetail);
		
	    Cpackage = new JButton("VIEW PACKAGES ");
		Cpackage.setBounds(0, 165, 350, 40);
		Cpackage.setBackground(new Color(0,0,102));
		Cpackage.setForeground(Color.white);
		Cpackage.setFont(new Font("tahoma",Font.PLAIN,18));
		Cpackage.setMargin(new Insets(0,0,0,178));
		Cpackage.addActionListener(this);
		p2.add(Cpackage);
		
	    Bpackage = new JButton("BOOK PACKAGES ");
		Bpackage.setBounds(0, 205, 300, 40);
		Bpackage.setBackground(new Color(0,0,102));
		Bpackage.setForeground(Color.white);
		Bpackage.setFont(new Font("tahoma",Font.PLAIN,18));
        Bpackage.setMargin(new Insets(0, 0, 0, 125));
        Bpackage.addActionListener(this);
		p2.add(Bpackage);
		
		Vpackage = new JButton("MY PACKAGES ");
		Vpackage.setBounds(0, 245, 300, 40);
		Vpackage.setBackground(new Color(0,0,102));
		Vpackage.setForeground(Color.white);
		Vpackage.setFont(new Font("tahoma",Font.PLAIN,18));
        Vpackage.setMargin(new Insets(0, 0, 0, 145));
        Vpackage.addActionListener(this);
		p2.add(Vpackage);
		
	    Vhotel = new JButton("VIEW HOTELS ");
		Vhotel.setBounds(0, 285, 300, 40);
		Vhotel.setBackground(new Color(0,0,102));
		Vhotel.setForeground(Color.white);
		Vhotel.setFont(new Font("tahoma",Font.PLAIN,18));
		Vhotel.setMargin(new Insets(0, 0, 0, 150));
		Vhotel.addActionListener(this);
		p2.add(Vhotel);
		
	    Bhotel = new JButton("BOOK HOTELS ");
		Bhotel.setBounds(0, 325, 300, 40);
		Bhotel.setBackground(new Color(0,0,102));
		Bhotel.setForeground(Color.white);
		Bhotel.setFont(new Font("tahoma",Font.PLAIN,18));
		Bhotel.setMargin(new Insets(0, 0, 0, 146));
		Bhotel.addActionListener(this);
		p2.add(Bhotel);
		
	    VBhotel = new JButton("MY HOTEL BOOKINGS ");
		VBhotel.setBounds(0, 365, 300, 40);
		VBhotel.setBackground(new Color(0,0,102));
		VBhotel.setForeground(Color.white);
		VBhotel.setFont(new Font("tahoma",Font.PLAIN,18));
		VBhotel.addActionListener(this);
		VBhotel.setMargin(new Insets(0, 0, 0, 85));
		p2.add(VBhotel);
		
	    Destination = new JButton("DESTINATIONS ");
		Destination.setBounds(0, 405, 300, 40);
		Destination.setBackground(new Color(0,0,102));
		Destination.setForeground(Color.white);
		Destination.setFont(new Font("tahoma",Font.PLAIN,18));
		Destination.setMargin(new Insets(0, 0, 0, 138));
		Destination.addActionListener(this);
		p2.add(Destination);
		
	    Payment = new JButton("PAYMENTS ");
		Payment.setBounds(0, 445, 300, 40);
		Payment.setBackground(new Color(0,0,102));
		Payment.setForeground(Color.white);
		Payment.setFont(new Font("tahoma",Font.PLAIN,18));
		Payment.setMargin(new Insets(0, 0, 0, 180));
		Payment.addActionListener(this);
		p2.add(Payment);
		
	    calculator = new JButton("CALCULATOR ");
		calculator.setBounds(0, 485, 300, 40);
		calculator.setBackground(new Color(0,0,102));
		calculator.setForeground(Color.white);
		calculator.setFont(new Font("tahoma",Font.PLAIN,18));
		calculator.setMargin(new Insets(0, 0, 0, 155));
		calculator.addActionListener(this);
		p2.add(calculator);
		
	    about = new JButton("ABOUT ");
		about.setBounds(0, 525, 300, 40);
		about.setBackground(new Color(0,0,102));
		about.setForeground(Color.white);
		about.setFont(new Font("tahoma",Font.PLAIN,18));
		about.setMargin(new Insets(0, 0, 0, 205));
		about.addActionListener(this);
		p2.add(about);
		
		 logout = new JButton("LOGOUT ");
		 logout.setBounds(0, 565, 300, 40);
		 logout.setBackground(new Color(0,0,102));
		 logout.setForeground(Color.white);
		 logout.setFont(new Font("tahoma",Font.PLAIN,18));
		 logout.setMargin(new Insets(0, 0, 0, 190));
		 logout.addActionListener(this);
		 p2.add(logout);
		

		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image i5=i4.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image1= new JLabel(i6);
		image1.setBounds(0, 0, 1500, 1000);
		add(image1);
		
		JLabel text = new JLabel ("TRAVEL AND TOURISM MANAGEMENT SYSTEM");
		text.setBounds(440, 80, 1000, 90);
		text.setForeground(Color.white);
		text.setFont(new Font("raleway",Font.BOLD,35 ));
		image1.add(text);
		
		setVisible(true);
		
	}
	public static void main(String[] args) 
	{
		new Dashboard("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==persondetail)
		{
			new Addcustomer(username);
		}else if (e.getSource()==Vpersondetail)
		{
			new ViewCustomer(username);
		}else if (e.getSource()==Upersondetail)
		{
			new UpdateCustomer(username);
		}else if(e.getSource()==Cpackage)
		{
			new CheckPackage();
		}else if(e.getSource()==Bpackage)
		{
			new Bokpackage(username);
		}else if(e.getSource()==Vpackage)
		{
			new ViewPack(username);
		}else if(e.getSource()==Vhotel)
		{
			new ViewHotels();
		}else if(e.getSource()==Destination)
		{
			new Destination();
		}else if(e.getSource()==Bhotel)
		{
			new Bookhotel(username);
		}else if(e.getSource()==VBhotel)
		{
			new ViewBookhotel(username);
		}else if(e.getSource()==Payment)
		{
			new Payment();
		}else if(e.getSource()==calculator)
		{
			try {
				Runtime.getRuntime().exec("calc.exe");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource()==about)
		{
			new About();
		}else if(e.getSource()==about)
		{
			new Deletedetails(username);
		}else if(e.getSource()==logout)
		{
			new Logout(username);
			setVisible(false);
		}
		
	}

}
