package managementSystem;

import java.awt.*;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class About extends JFrame implements ActionListener{

	
	About()
	{
		setBounds(380,180,850,550);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel l1 = new JLabel("ABOUT");
		l1.setBounds(320, 10, 170, 40);
		l1.setFont(new Font("Tahome",Font.BOLD,40));
		l1.setForeground(Color.red);
		add(l1);
		String s="Welcome to our Travel and Tourism Application, a comprehensive platform developed in Java to enhance your travel planning experience. This project aims to provide users with an all-in-one solution for discovering, planning, and managing their travel itineraries seamlessly. Our application is designed with a user-friendly interface and robust features to ensure a hassle-free travel experience from start to finish.About the Project\r\n"
				+ "\r\n"
				+ "The Travel and Tourism Application is a comprehensive Java-based solution designed to streamline and enhance the travel planning experience. This project aims to provide users with a seamless platform to explore, book, and manage their travel itineraries effortlessly. Built with a user-friendly interface, the application caters to both travelers and travel agencies, offering a range of features to meet diverse needs.\r\n"
				+ "\r\n"
				+ "Key Features:\r\n"
				+ "- User Authentication: Secure login and registration system to protect user data.\r\n"
				+ "- Search and Filter: Advanced search options to find destinations, hotels, and travel packages based on user preferences.\r\n"
				+ "- Booking System: Simplified booking process for flights, hotels, and tour packages.\r\n"
				+ "- Itinerary Management: Tools to create, edit, and manage travel itineraries.\r\n"
				+ "- Payment Integration: Secure payment gateway integration for hassle-free transactions.\r\n"
				+ "- Reviews and Ratings: Option for users to review and rate destinations and services.\r\n"
				+ "- Admin Panel: Administrative dashboard for managing users, bookings, and content.\r\n"
				+ "\r\n"
				+ "Our Travel and Tourism Application is your ultimate travel companion, designed to make every aspect of your journey enjoyable and stress-free. Embark on your next adventure with confidence, knowing that you have a powerful tool to guide you every step of the way.";
		TextArea area= new TextArea(s,10,40,Scrollbar.VERTICAL);
		area.setEditable(false);
		area.setFont(new Font("Gothic",Font.PLAIN,14));
		area.setBounds(80, 100, 700, 340);
		add(area);
		JButton back=new JButton("BACK");
		back.setBounds(370, 450, 80, 30);
		back.addActionListener(this);
		add(back);
		setVisible(true);
		setVisible(true);
	}
	public static void main(String[] args) {

		new About();
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		setVisible(false);
	}

}
