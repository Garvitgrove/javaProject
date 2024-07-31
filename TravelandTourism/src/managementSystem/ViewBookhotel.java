package managementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class ViewBookhotel extends JFrame implements ActionListener{
	JButton back;
	String username;
	ViewBookhotel(String username)
	{
		setBounds(360,190,950,550);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel text= new JLabel("HOTEL  DETAILS");
		text.setFont(new Font("Tahoma",Font.BOLD,30));
		text.setForeground(Color.BLUE);
		text.setBounds(300, 5, 300, 30);
		add(text);
		
		JLabel labusername= new JLabel("USERNAME");
		labusername.setBounds(30, 40, 150, 25);
		labusername.setFont(new Font("raleway",Font.BOLD,16 ));
		labusername.setForeground(Color.red);
		add(labusername);
		JLabel ansusername= new JLabel();
		ansusername.setBounds(180, 40, 150, 25);
		ansusername.setFont(new Font("raleway",Font.BOLD,16 ));
		ansusername.setForeground(Color.red);
		add(ansusername);
		
		JLabel pack= new JLabel("HOTEL NAME");
		pack.setBounds(30, 80, 150, 25);
		pack.setFont(new Font("raleway",Font.BOLD,16 ));
		pack.setForeground(Color.red);
		add(pack);
		JLabel apack= new JLabel();
		apack.setBounds(180, 80, 150, 25);
		apack.setFont(new Font("raleway",Font.BOLD,16 ));
		apack.setForeground(Color.red);
		add(apack);
		JLabel person= new JLabel("TOTAL PERSON");
		person.setBounds(30, 120, 150, 25);
		person.setFont(new Font("raleway",Font.BOLD,16 ));
		person.setForeground(Color.red);
		add(person);
		JLabel aperson= new JLabel();
		aperson.setBounds(180,120, 150, 25);
		aperson.setFont(new Font("raleway",Font.BOLD,16 ));
		aperson.setForeground(Color.red);
		add(aperson);
		JLabel day= new JLabel("TOTAL DAYS");
		day.setBounds(30, 160, 150, 25);
		day.setFont(new Font("raleway",Font.BOLD,16 ));
		day.setForeground(Color.red);
		add(day);
		JLabel aday= new JLabel();
		aday.setBounds(180, 160, 150, 25);
		aday.setFont(new Font("raleway",Font.BOLD,16 ));
		aday.setForeground(Color.red);
		add(aday);
		JLabel room= new JLabel("ROOM TYPE");
		room.setBounds(30, 200, 150, 25);
		room.setFont(new Font("raleway",Font.BOLD,16 ));
		room.setForeground(Color.red);
		add(room);
		JLabel aroom= new JLabel();
		aroom.setBounds(180, 200, 150, 25);
		aroom.setFont(new Font("raleway",Font.BOLD,16 ));
		aroom.setForeground(Color.red);
		add(aroom);
		JLabel food= new JLabel("FOOD INCLUDED");
		food.setBounds(30, 240, 150, 25);
		food.setFont(new Font("raleway",Font.BOLD,16 ));
		food.setForeground(Color.red);
		add(food);
		JLabel afood= new JLabel();
		afood.setBounds(180, 240, 150, 25);
		afood.setFont(new Font("raleway",Font.BOLD,16 ));
		afood.setForeground(Color.red);
		add(afood);
		JLabel id= new JLabel("IDENTITY");
		id.setBounds(30, 280, 150, 25);
		id.setFont(new Font("raleway",Font.BOLD,16 ));
		id.setForeground(Color.red);
		add(id);
		JLabel aid= new JLabel();
		aid.setBounds(180, 280, 150, 25);
		aid.setFont(new Font("raleway",Font.BOLD,16 ));
		aid.setForeground(Color.red);
		add(aid);
		JLabel number= new JLabel("NUMBER");
		number.setBounds(30, 320, 150, 25);
		number.setFont(new Font("raleway",Font.BOLD,16 ));
		number.setForeground(Color.red);
		add(number);
		JLabel anumber= new JLabel();
		anumber.setBounds(180, 320, 150, 25);
		anumber.setFont(new Font("raleway",Font.BOLD,16 ));
		anumber.setForeground(Color.red);
		add(anumber);
		JLabel phn= new JLabel("PHONE NO.");
		phn.setBounds(30, 360, 150, 25);
		phn.setFont(new Font("raleway",Font.BOLD,16 ));
		phn.setForeground(Color.red);
		add(phn);
		JLabel aphn= new JLabel();
		aphn.setBounds(180, 360, 150, 25);
		aphn.setFont(new Font("raleway",Font.BOLD,16 ));
		aphn.setForeground(Color.red);
		add(aphn);
		JLabel price= new JLabel("TOTAL PRICE");
		price.setBounds(30, 400, 150, 25);
		price.setFont(new Font("raleway",Font.BOLD,16 ));
		price.setForeground(Color.red);
		add(price);
		JLabel aprice= new JLabel();
		aprice.setBounds(180, 400, 150, 25);
		aprice.setFont(new Font("raleway",Font.BOLD,16 ));
		aprice.setForeground(Color.red);
		add(aprice);
		
		back = new JButton("BACK");
		back.setBorder(BorderFactory.createEmptyBorder());
		back.setBackground(new Color(2, 65, 230));
		back.setForeground(Color.white);
		back.setBounds(130, 460, 100, 25);
		back.addActionListener(this);
		add(back);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
		Image i2 = i1.getImage().getScaledInstance(940, 520, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 940, 520);
		add(image);
		
		
		try {
			Conn c = new Conn();
			String query = "SELECT * FROM BOOKHOTEL WHERE USERNAME = '  "+username+"';";
		    ResultSet rs = c.s.executeQuery(query);
		    while(rs.next())
		    {
		    	ansusername.setText(rs.getString("USERNAME"));
		    	apack.setText(rs.getString("HOTELNAME"));
		    	aid.setText(rs.getString("ID"));
		    	anumber.setText(rs.getString("NUMBER"));
		    	aprice.setText(rs.getString("PRICE"));
		    	aperson.setText(rs.getString("PERSONS"));
		    	aday.setText(rs.getString("DAYS"));
		    	aphn.setText(rs.getString("PHONE"));
		    	aroom.setText(rs.getString("AC"));
		    	afood.setText(rs.getString("FOOD"));
		    }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new ViewBookhotel("gg12");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		
	}

}

