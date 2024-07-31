package managementSystem;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Paytm extends JFrame implements ActionListener{
	
	Paytm()
	{
		setBounds(380,180,850,550);
		setLayout(null);
		/*JEditorPane pane = new JEditorPane();
		pane.setEditable(false);
		
		try {
			pane.setPage("https://paytm.com/rent-payment");
		} catch (IOException e) {
			pane.setContentType("text/html");
			pane.setText("<html>COULD NOT LOAD,ERROR 404</html>");
		}
		
		JScrollPane sp = new JScrollPane(pane);
		getContentPane().add(sp);*/
		
		JButton back=new JButton("BACK");
		back.setBounds(610, 20, 80, 30);
		back.addActionListener(this);
		add(back);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
		Image i2 =i1.getImage().getScaledInstance(850, 550, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 850, 550);
		add(image);
		setVisible(true);
		JOptionPane.showMessageDialog(null, "WORK IN PROGRESS");


	}

	public static void main(String[] args) {

		new Paytm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		setVisible(false);
		new Payment();
		
	}

}
