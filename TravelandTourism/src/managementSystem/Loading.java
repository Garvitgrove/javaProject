package managementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class Loading extends JFrame implements Runnable{
	Thread t;
	JProgressBar bar;
	String username;
	Loading(String username)
	{
		t= new Thread(this);
		this.username=username;
		setBounds(370,200,900,500);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel text = new JLabel ("TRAVEL AND TOURISM APPLICATION");
		text.setBounds(100, 22, 650, 40);
		text.setForeground(new Color(0, 0, 139));
		text.setFont(new Font("raleway",Font.BOLD,34 ));
		add(text);
		
	    bar= new JProgressBar();
		bar.setBounds(210,80,350,30);
		bar.setStringPainted(true);
		add(bar);
		
		JLabel load = new JLabel ("LOADING, PLEASE WAIT...");
		load.setBounds(310, 110, 650, 40);
		load.setForeground(Color.black);
		load.setFont(new Font("raleway",Font.BOLD,12 ));
		add(load);
		
		JLabel lusername = new JLabel ("WELCOME "+username);
		lusername.setBounds(80, 350, 250, 40);
		lusername.setForeground(new Color(255, 0, 0));
		lusername.setFont(new Font("raleway",Font.BOLD,20 ));
		add(lusername);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/loadinpage.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 500);
		add(image);
		 
		t.start();
		setVisible(true);
		
	}

	public static void main(String[] args)
	{
		new Loading("");

	}

	@Override
	public void run() {
		for(int i=1; i<=101; i++)
		{
			int max=bar.getMaximum();
			int value=bar.getValue();
			if(value< max)
			{
				bar.setValue(bar.getValue()+1);
			}else{
				setVisible(false);
				new Dashboard(username);
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
