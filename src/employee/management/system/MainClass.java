package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainClass extends JFrame{
    JButton add, remove, view;

    public MainClass(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340, 155, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        img.add(heading);

        add = new JButton("Add Employee");
        add.setBounds(335, 270, 150, 40);
        add.setBackground(Color.WHITE);
        add.setForeground(Color.black);
        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        view = new JButton("View Employee");
        view.setBounds(565, 270, 150, 40);
        view.setBackground(Color.WHITE);
        view.setForeground(Color.black);
        view.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new ViewEmployee();
                setVisible(false);
            }
        });
        img.add(view);

        remove = new JButton("Remove Employee");
        remove.setBounds(440, 370, 150, 40);
        remove.setBackground(Color.WHITE);
        remove.setForeground(Color.black);
        remove.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new RemoveEmployee();
            }
        });
        img.add(remove);

        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args){
        new MainClass();
    }    
}
