package employee.management.system;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    JButton update, back;
    JTextField tfname, taddress, taadhar, tphone, temail, tsalary, tdesignation, teducation;
    JLabel tempid;
    String empid;

    public UpdateEmployee(String empid){
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200, 150, 150, 0);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150,30);
        fname.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        add(dob);

        JLabel tdob = new JLabel ();
        dob.setBounds(200, 200, 150, 30);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 300, 150, 30);
        salary.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 300, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250,150, 30);
        address.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(650, 250, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        JLabel email = new JLabel("Email ID");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(600, 300, 150, 30);
        teducation.setBackground(new Color(177, 252, 197));
        add(teducation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        add(aadhar);

        JLabel taadhar = new JLabel();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setBackground(new Color(177, 252, 197));
        add(taadhar);

        JLabel eid = new JLabel("Employee ID");
        eid.setBounds(50,400,150,30);
        eid.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(eid);

        JLabel tempid = new JLabel();
        tempid.setBounds(200, 400, 150, 20);
        tempid.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(177, 252, 197));
        add(tdesignation);

        try{
            Conn conn = new Conn();
            String query = "Select * from employee where empID = ?";
            PreparedStatement pst = conn.conn.prepareStatement(query);
            pst.setString(1, empid);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tdob.setText(rs.getString("dob"));
                taddress.setText(rs.getString("address"));;
                tsalary.setText(rs.getString("salary"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                teducation.setText(rs.getString("education"));
                taadhar.setText(rs.getString("aadhar"));
                tempid.setText(rs.getString("empID"));
                tdesignation.setText(rs.getString("designation"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        update = new JButton("UPDATE");
        update.setBounds(250, 550, 150, 40);
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == update){
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try{
                Conn conn = new Conn();
                String query = "Update employee set fname = ?, salary = ?, address = ?, phone = ?, email = ?, education = ?, designation = ? where empID = ?";
                PreparedStatement pst = conn.conn.prepareStatement(query);

                pst.setString(1, fname);
                pst.setString(2, salary);
                pst.setString(3, address);
                pst.setString(4, phone);
                pst.setString(5, email);
                pst.setString(6, education);
                pst.setString(7, designation);
                pst.setString(8, empid);

                pst.executeQuery();
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }else if (e.getSource() == back){
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args){
        new UpdateEmployee("");
    }
}