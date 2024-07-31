package managementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class ForgetPass extends JFrame implements ActionListener {
    JTextField tusername, tname, tquestion, tans, tpass;
    JButton search, retrieve, back;

    ForgetPass() {
        setBounds(350, 200, 800, 350);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 420, 350);
        p1.setBackground(new Color(120, 180, 221));
        add(p1);

        JLabel username = new JLabel("USERNAME :");
        username.setBounds(30, 40, 100, 25);
        username.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(username);
        tusername = new JTextField();
        tusername.setBounds(160, 42, 120, 20);
        tusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tusername);
        search = new JButton("SEARCH");
        search.setBackground(Color.LIGHT_GRAY);
        search.setForeground(Color.black);
        search.setBounds(300, 42, 90, 20);
        search.addActionListener(this);
        p1.add(search);

        JLabel name = new JLabel("NAME :");
        name.setBounds(30, 80, 100, 25);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(name);
        tname = new JTextField();
        tname.setBounds(160, 82, 120, 20);
        tname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tname);

        JLabel question = new JLabel("SECURITY QUESTION :");
        question.setBounds(30, 120, 150, 25);
        question.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        p1.add(question);
        tquestion = new JTextField();
        tquestion.setBounds(160, 122, 120, 20);
        tquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tquestion);

        JLabel ans = new JLabel("ANSWER :");
        ans.setBounds(30, 160, 150, 25);
        ans.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(ans);
        tans = new JTextField();
        tans.setBounds(160, 162, 120, 20);
        tans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tans);

        retrieve = new JButton("RETRIEVE");
        retrieve.setBackground(Color.LIGHT_GRAY);
        retrieve.setForeground(Color.black);
        retrieve.setBounds(300, 162, 100, 20);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel pass = new JLabel("PASSWORD :");
        pass.setBounds(30, 210, 150, 25);
        pass.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(pass);
        tpass = new JTextField();
        tpass.setBounds(160, 212, 120, 20);
        tpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tpass);

        back = new JButton("BACK");
        back.setBackground(Color.LIGHT_GRAY);
        back.setForeground(Color.black);
        back.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        back.setBounds(160, 250, 100, 20);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
        	String query = "SELECT * FROM ACCOUNT WHERE USERNAME = ' " + tusername.getText() + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) 
                {
                    tname.setText(rs.getString("NAME"));
                    tquestion.setText(rs.getString("SECURITY"));
                } else {
                    JOptionPane.showMessageDialog(null, "Username not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        else if (ae.getSource() == retrieve) {
            String query = "SELECT * FROM ACCOUNT WHERE ANSWER = '" + tans.getText() + "' AND USERNAME = ' " + tusername.getText() + "'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    tpass.setText(rs.getString("PASSWORD"));
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid answer or username");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgetPass();
    }
}
