package managementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Logout extends JFrame implements ActionListener{

	String username;
	JButton yes,no;
	Logout(String username)
	{
		this.username=username;
		setBounds(500,300,400,200);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel text = new JLabel("DO YOU WANT TO DELETE YOUR DETAILS");
		text.setBounds(35, 20, 350, 20);
		text.setFont(new Font ( "Tahoma",Font.PLAIN,15));
		add(text);
		yes= new JButton("YES");
		yes.setBounds(100, 110, 80, 20);
		yes.addActionListener(this);
		add(yes);
		no= new JButton("NO");
		no.setBounds(200, 110, 80, 20);
		no.addActionListener(this);
		add(no);
		setVisible(true);
		
	}
	public static void main(String[] args) {

		new Logout("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==yes)
		{
			new Deletedetails(username);
			setVisible(false);
		}else {
			new Login();
			setVisible(false);
		}
	}

}
