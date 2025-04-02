package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame{
    public Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/front.gif"));
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imgcontainer = new JLabel(i3);
        imgcontainer.setBounds(0,0,1170,650);
        add(imgcontainer);

        setSize(1170, 650);
        setLocation(200, 50);
        setLayout(null);
        setVisible(true);

        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Splash();
    }
}