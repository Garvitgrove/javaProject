package managementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class Destination extends JFrame implements Runnable {
    
    Thread t1;
    JLabel[] label = new JLabel[10];

    Destination() {
        setBounds(340, 200, 970, 560);        
        
        ImageIcon[] image = new ImageIcon[10];
        Image[] jimage = new Image[10];
        ImageIcon[] kimage = new ImageIcon[10];
        
        for (int i = 0; i<8; i++) {
            image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/dest"+(i+1)+".jpg"));
            jimage[i] = image[i].getImage().getScaledInstance(970, 560, Image.SCALE_DEFAULT);
            kimage[i] = new ImageIcon(jimage[i]);
            label[i] = new JLabel(kimage[i]);
            label[i].setBounds(0, 0, 970, 560);
            add(label[i]);
        }

        t1 = new Thread(this);
        t1.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Destination();
    }

    @Override
    public void run() {
        for (int i = 0; i<8; i++) {
            try {
                label[i].setVisible(true);
                Thread.sleep(2500);
                label[i].setVisible(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setVisible(false);
    }
}
