package managementSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;


public class Bookhotel extends JFrame implements ActionListener{
	
	Choice chotel,cac,cfood;
	JTextField tperson,tdays;
	String username;
	JLabel ansusername,aid,aphn,anum,aprice;
	JButton checkprice,bookpack,back;
	Bookhotel(String username)
	{
		this.username=username;
		setBounds(320,180,1000,560);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel text= new JLabel("BOOK HOTEL");
		text.setBounds(100, 10, 250, 30);
		text.setForeground(Color.blue);
		text.setFont(new Font("Tahoma",Font.BOLD,30));
		add(text);
		
		JLabel labusername= new JLabel("USERNAME");
		labusername.setBounds(40, 70, 100, 20);
		labusername.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(labusername);
	    ansusername= new JLabel();
		ansusername.setBounds(210, 70, 150, 20);
		ansusername.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(ansusername);
		
		JLabel spack= new JLabel("SELECT HOTEL");
		spack.setBounds(40, 110, 150, 20);
		spack.setFont(new Font("Tahoma",Font.PLAIN,15));

		add(spack);
		chotel= new Choice();
		chotel.setBounds(210, 110, 180, 20);
		add(chotel);
		
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("SELECT * FROM HOTEL");
			while(rs.next())
			{
				chotel.add(rs.getString("NAME"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		JLabel person= new JLabel("TOTAL PERSONS");
		person.setBounds(40, 150, 150, 20);
		person.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(person);
		tperson = new JTextField("1");
		tperson.setBounds(210, 150, 150, 20);
		add(tperson);
		
		JLabel days= new JLabel("NO. OF DAYS");
		days.setBounds(40, 190, 150, 20);
		days.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(days);
		tdays = new JTextField("1");
		tdays.setBounds(210, 190, 150, 20);
		add(tdays);
		
		JLabel ac= new JLabel("AC / NON AC");
		ac.setBounds(40, 230, 150, 20);
		ac.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(ac);
        cac= new Choice();
        cac.add("AC");
        cac.add("NON AC");
		cac.setBounds(210, 230, 180, 20);
		add(cac);
		
		JLabel food= new JLabel("FOOD INCLUDED");
		food.setBounds(40, 270, 150, 20);
		food.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(food);
        cfood= new Choice();
        cfood.add("YES");
        cfood.add("NO");
		cfood.setBounds(210, 270, 180, 20);
		add(cfood);
	   
		JLabel id= new JLabel("IDENTITY");
		id.setBounds(40, 310, 150, 20);
		id.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(id);
		aid= new JLabel();
		aid.setBounds(210, 310, 150, 20);
		add(aid);
		
		JLabel num= new JLabel("NUMBER");
		num.setBounds(40,350, 150, 20);
		num.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(num);
	    anum= new JLabel();
		anum.setBounds(210, 350, 150, 20);
		add(anum);
		JLabel phn= new JLabel("PHONE");
		phn.setBounds(40, 390, 150, 20);
		phn.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(phn);
	    aphn= new JLabel();
		aphn.setBounds(210, 390, 150, 20);
		add(aphn);
		

		JLabel price= new JLabel("TOTAL PRICE");
		price.setBounds(40, 430, 150, 20);
		price.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(price);
	    aprice= new JLabel();
		aprice.setBounds(210, 430, 150, 20);
		add(aprice);
		
		try {
			Conn c = new Conn();
			String query = "SELECT * FROM CUSTOMER WHERE USERNAME = '  "+username+"';";
		    ResultSet rs = c.s.executeQuery(query);
		    while(rs.next())
		    {
		    	ansusername.setText(rs.getString("USERNAME"));
		    	aid.setText(rs.getString("ID"));
		    	anum.setText(rs.getString("NUMBER"));
		    	aphn.setText(rs.getString("PHONE"));
		    }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	
		checkprice = new JButton("CHECK PRICE");
		checkprice.setBackground(Color.black);
		checkprice.setForeground(Color.white);
		checkprice.setBounds(40,480, 120, 25);
		checkprice.addActionListener(this);
		add(checkprice);
		bookpack = new JButton("BOOK ");
		bookpack.setBackground(Color.black);
		bookpack.setForeground(Color.white);
		bookpack.setBounds(180, 480, 100, 25);
		bookpack.addActionListener(this);
		add(bookpack);
		back = new JButton("BACK ");
        back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(300, 480, 100, 25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
		Image i2=i1.getImage().getScaledInstance(620, 560, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image =new JLabel(i3);
		image.setBounds(400, 0, 620, 560);
		add(image);

		setVisible(true);
	}

	public static void main(String[] args) {

		new Bookhotel("gg12");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==checkprice)
		{
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("SELECT * FROM HOTEL WHERE NAME='"+chotel.getSelectedItem()+"';");
			    while(rs.next())
			    {
			    	int cost = Integer.parseInt(rs.getString("COSTPP"));
			    	int Food = Integer.parseInt(rs.getString("FOOD"));
			    	int AC = Integer.parseInt(rs.getString("ACROOM"));
			    	
			    	int Person = Integer.parseInt(tperson.getText());
			    	int Days=Integer.parseInt(tdays.getText());
			    	String acselect = cac.getSelectedItem();
			    	String foodselect=cfood.getSelectedItem();
			   
			    	if(Person*Days>0) {
			    		int Total=0;
			    		Total+=acselect.equals("AC")? AC :0;
			    		Total+=foodselect.equals("YES") ? Food : 0;
			    		Total+=cost;
			    		Total = Total * Person * Days;
			    		aprice.setText("Rs. "+Total);
			    	}else {
			    		JOptionPane.showMessageDialog(null, "ENTER A VALID NUMBER");
			    	}
			    }
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getSource()==bookpack)
		{
			try {
				Conn c = new Conn();
				c.s.executeUpdate("INSERT INTO BOOKHOTEL VALUES('"+ansusername.getText()+"' , '"+chotel.getSelectedItem()+"','"+tperson.getText()+"','"+tdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+aid.getText()+"','"+anum.getText()+"','"+aphn.getText()+"','"+aprice.getText()+"');");
			    JOptionPane.showMessageDialog(null, "HOTEL BOOKED SUCCESSFULLY");
			    setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}

}
