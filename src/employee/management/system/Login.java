package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    public Login(){
        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 20, 150, 30);
        add(tusername);

        JLabel password = new JLabel("Password");;
        password.setBounds(40, 70, 100, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 150, 30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(150, 180, 150, 30);
        back.setBackground(Color.black );
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("assets/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350, 10, 600, 400);
        add(imgg);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 600, 300);
        add(img);

        setSize(600, 300);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == login){
            try{    
                String usn = tusername.getText();
                String pwd = new String(tpassword.getPassword());

                Conn conn = new Conn();
                String query = "Select * from login where username = ? and password = ?";
                PreparedStatement pst = conn.conn.prepareStatement(query);
                pst.setString(1, usn);
                pst.setString(2, pwd);
                ResultSet rs = pst.executeQuery();

                if (rs.next()){
                    setVisible(false);
                    new MainClass();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }else if (e.getSource() == back){
            System.exit(90);
        }
    }

    public static void main(String[] args){
        new Login();
    }
}
