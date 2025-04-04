package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener{
    Choice empid;
    JButton delete, back;

    public RemoveEmployee(){
        JLabel eid = new JLabel("Employee ID");
        eid.setBounds(50, 50, 100, 30);
        eid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(eid);

        empid = new Choice();
        empid.setBounds(200, 50, 150, 30);
        add(empid);

        try{
            Conn conn = new Conn();
            String query = "Select * from employee";
            PreparedStatement pst = conn.conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                empid.add(rs.getString("empID"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(20, 100, 100, 30);
        name.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200, 100, 100, 30);
        add(tname);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(50, 150, 100, 30);
        phone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(phone);

        JLabel tphone = new JLabel();
        tphone.setBounds(200, 150, 100, 30);
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 200, 100, 30);
        email.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(email);

        JLabel temail = new JLabel();
        temail.setBounds(200, 200, 100, 30);
        add(temail);

        try{
            Conn conn = new Conn();
            String query = "Select * from employee where empID = ?";
            PreparedStatement pst = conn.conn.prepareStatement(query);
            pst.setString(1, empid.getSelectedItem());
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                tname.setText(rs.getString("name"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        empid.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                try{
                    Conn conn = new Conn();
                    String query = "Select * from employee where empID = ?";
                    PreparedStatement pst = conn.conn.prepareStatement(query);
                    pst.setString(1, empid.getSelectedItem());
                    ResultSet rs = pst.executeQuery();
        
                    while(rs.next()){
                        tname.setText(rs.getString("name"));
                        tphone.setText(rs.getString("phone"));
                        temail.setText(rs.getString("email"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("DELETE");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("BACK");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/deldete.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img1 = new JLabel(i3);
        img1.setBounds(700, 80, 200, 200);
        add(img1);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("assets/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel img2 = new JLabel(i33);
        img2.setBounds(0, 0, 1120, 630);
        add(img2);

        setSize(1000, 400);
        setLocation(300, 150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == delete){
            try{
                Conn conn = new Conn();
                String query = "delete from employee where empID = ?";
                PreparedStatement pst = conn.conn.prepareStatement(query);
                pst.setString(1, empid.getSelectedItem());
                pst.executeQuery();
                JOptionPane.showMessageDialog(null, "Employee Details Removed Successfully");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }else if(e.getSource() == back){
            setVisible(false);
            new MainClass();
        }
    }

    public static void main(String[] args){
        new RemoveEmployee();
    }
}
