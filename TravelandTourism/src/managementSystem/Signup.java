package managementSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Signup extends JFrame implements ActionListener{
	JButton create,back;
	JTextField tusername,tname,tpass,tans;
	Choice security;
	Signup()
	{
		setBounds(300,200,900,400);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JPanel p1= new JPanel();
		p1.setBackground(new Color(133,193,233));
		p1.setBounds(0, 0, 500, 400);
		p1.setLayout(null);
		add(p1);
		 
		JLabel username = new JLabel("USERNAME :");
		username.setBounds(50, 40, 125, 20);
		username.setFont(new Font("Gothic", Font.BOLD,16));
		p1.add(username);
		
	    tusername= new JTextField();
		tusername.setBounds(210, 40, 180, 20);
		tusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tusername);
		
		JLabel name = new JLabel("NAME :");
		name.setBounds(50, 80, 125, 20);
		name.setFont(new Font("Gothic", Font.BOLD,16));
		p1.add(name);
		tname= new JTextField();
		tname.setBounds(210, 80, 180, 20);
		tname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tname);
		
		JLabel pass = new JLabel("PASSWORD :");
		pass.setBounds(50, 120, 125, 20);
		pass.setFont(new Font("Gothic", Font.BOLD,16));
		p1.add(pass);
		tpass= new JTextField();
		tpass.setBounds(210, 120, 180, 20);
		tpass.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tpass);
		
		JLabel sq = new JLabel("SECURITY QUESTION :");
		sq.setBounds(50, 160, 160, 20);
		sq.setFont(new Font("Gothic", Font.BOLD,14));
		p1.add(sq);
		security = new Choice();
		security.add("YOUR PET NAME ");
		security.add("YOUR FAV SUPERHERO " );
		security.add("YOUR LUCKY NUMBER " );
		security.setBounds(210, 160, 180, 20);
		p1.add(security);
		
		JLabel ans = new JLabel("ANSWER :");
		ans.setBounds(50, 200, 160, 20);
		ans.setFont(new Font("Gothic", Font.BOLD,14));
		p1.add(ans);
		tans= new JTextField();
		tans.setBounds(210, 200, 180, 20);
		tans.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tans);
		
	    create=new JButton("CREATE");
		create.setBackground(Color.white);
		create.setForeground(new Color(133,193,233));
		create.setFont(new Font("SAN_SERIF",Font.BOLD,14));
		create.setBounds(85, 260, 100, 30);
		create.addActionListener(this);
		p1.add(create);
		
	    back=new JButton("BACK");
		back.setBackground(Color.white);
		back.setForeground(new Color(133,193,233));
		back.setFont(new Font("SAN_SERIF",Font.BOLD,14));
		back.setBounds(250, 260, 100, 30);
		back.addActionListener(this);
		p1.add(back);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/signuppp.jpg"));
		Image i2= i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		image.setBounds(580, 50, 250, 250);
		add(image);
		
		setVisible(true);
		
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==create)
		{
			String username=tusername.getText();
			String name=tname.getText();
			String pass=tpass.getText();
			String sq = security.getSelectedItem();
			String ans=tans.getText();
			String query="INSERT INTO ACCOUNT VALUES(' "+username+"' , '"+name+"' , '"+pass+"' , '"+sq+"' , '"+ans+"');";
			try {
				Conn c = new Conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"ACCOUNT CREATED SUCCESSFULLY !!");
			    setVisible(false);
			    new Login();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource()==back)
		{
			setVisible(false);
			new Login();
		}
	}

	public static void main(String[] args) {
		new Signup();

	}

}
