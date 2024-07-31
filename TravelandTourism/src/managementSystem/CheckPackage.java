package managementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class CheckPackage extends JFrame{
	
	CheckPackage(){
		setBounds(380,180,930,550);
		setLayout(null);
		String[] package1= {"DIAMOND PACKAGE","6 DAYS 7 NIGHTS","AIRPORT ASSISTANCE","CITY TOUR, ACTIVITIES ","DAILY BUFFET","WELCOME DRINKS","3 ISLAND CRUISE","PERSONAL LANGUAGE GUIDE","BOOK NOW","SUMMER SPECIAL FOR 32000/-","package1.jpg"};
		String[] package2= {"GOLD PACKAGE","5 DAYS 6 NIGHTS","AIRPORT ASSISTANCE","FULL CITY TOUR","BREAKFAST BUFFET","WELCOME DRINKS","2 ISLAND CRUISE","NIGHT SAFARI","BOOK NOW","WINTER SPECIAL FOR 26000/-","package2.jpg"};
		String[] package3= {"SILVER PACKAGE","4 DAYS 5 NIGHTS","RETURN AIRFARE","FREE ACTIVITIES","BREAKFAST BUFFET","WELCOME DRINKS","1 ISLAND CRUISE","1 DAY STAY AT TREE HOUSE","BOOK NOW","MOONSOON SPECIAL FOR 20000/-","package3.jpg"};
		JTabbedPane tab= new JTabbedPane();
		tab.setBounds(0, 0, 930, 550);
		JPanel p1= Createpackage(package1);
		tab.addTab("PACKAGE 1", null, p1);
		JPanel p2= Createpackage(package2);
		tab.addTab("PACKAGE 2", null, p2);
		JPanel p3= Createpackage(package3);
		tab.addTab("PACKAGE 3", null, p3);
		add(tab);
		
		setVisible(true);
	}
	public JPanel Createpackage(String[] pack)
	{
		JPanel p1= new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.white);
		
		JLabel l1=new JLabel(pack[0]);
		l1.setForeground(Color.yellow);
		l1.setBounds(50, 5, 350, 30);
		l1.setFont(new Font("Tahoma",Font.BOLD,30));
		p1.add(l1);
		JLabel l2=new JLabel(pack[1]);
		l2.setForeground(Color.green);
		l2.setBounds(40, 60, 300, 30);
		l2.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l2);
		JLabel l3=new JLabel(pack[2]);
		l3.setForeground(Color.green);
		l3.setBounds(40, 110, 300, 30);
		l3.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l3);
		JLabel l4=new JLabel(pack[3]);
		l4.setForeground(Color.green);
		l4.setBounds(40, 160, 300, 30);
		l4.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l4);
		JLabel l5=new JLabel(pack[4]);
		l5.setForeground(Color.green);
		l5.setBounds(40, 210, 300, 30);
		l5.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l5);
		JLabel l6=new JLabel(pack[5]);
		l6.setForeground(Color.green);
		l6.setBounds(40, 260, 300, 30);
		l6.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l6);
		JLabel l7=new JLabel(pack[6]);
		l7.setForeground(Color.green);
		l7.setBounds(40, 310, 300, 30);
		l7.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l7);
		JLabel l8=new JLabel(pack[7]);
		l8.setForeground(Color.green);
		l8.setBounds(40, 360, 300, 30);
		l8.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l8);
		JLabel l9=new JLabel(pack[8]);
		l9.setForeground(Color.red);
		l9.setBounds(70, 410, 300, 30);
		l9.setFont(new Font("Tahoma",Font.BOLD,23));
		p1.add(l9);
		JLabel l10=new JLabel(pack[9]);
		l10.setForeground(Color.magenta);
		l10.setBounds(450, 400, 400, 30);
		l10.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(l10);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[10]));
		Image i2=i1.getImage().getScaledInstance(930, 550, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image =new JLabel(i3);
		image.setBounds(0, 0, 930, 550);
		p1.add(image);
		return p1;
	}
	public static void main(String[] args) {

		new CheckPackage();
	}

}
