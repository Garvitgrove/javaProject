package managementSystem;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Payment extends JFrame implements ActionListener{

	JButton pay,back;
	Payment()
	{
		setBounds(380,180,850,550);
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
		Image i2 =i1.getImage().getScaledInstance(850, 550, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 850, 550);
		add(image);
		back= new JButton("BACK");
		back.setBounds(480, 5, 80, 30);
		back.addActionListener(this);
		image.add(back);
		pay= new JButton("PAY");
		pay.setBounds(280, 5, 80, 30);
		pay.addActionListener(this);
		image.add(pay);
		
		setVisible(true);
	}
	public static void main(String[] args) {

		new Payment();
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==pay)
		{
			setVisible(false);
			new Paytm();
			
		}else {
			setVisible(false);
		}
	}

}
