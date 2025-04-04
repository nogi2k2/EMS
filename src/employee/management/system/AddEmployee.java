package employee.management.system;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class AddEmployee extends JFrame  implements ActionListener{
    Random rand = new Random();
    int empID = rand.nextInt(999999);

    JTextField tname, tfname, taddress, taadhar, tphone, temail, tsalary, tdesignation;
    JButton add, back;
    JDateChooser tdob;
    JLabel tempid;
    JComboBox teducation;

    public AddEmployee(){
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Enter Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
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

        tdob = new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setBackground(new Color(177, 252, 197));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
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
        tphone.setBounds(600, 250, 150, 30);
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

        String[] education_list = {"BBA","B.Tech","BCA", "BA", "BSC", "B.COM",
                                     "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        teducation = new JComboBox(education_list);
        teducation.setBounds(600, 300, 150, 30);
        teducation.setBackground(new Color(177, 252, 197));
        add(teducation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setBackground(new Color(177, 252, 197));
        add(taadhar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(empid);

        tempid = new JLabel(""+empID);
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD,20));
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
        
        back = new JButton("BACK");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        add = new JButton("ADD");
        add.setBounds(250, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == add){
            String name = tname.getText();
            String fname = tfname.getText();
            String address = taddress.getText();
            String aadhar = taadhar.getText();
            String phone = tphone.getText();
            String designation = tdesignation.getText();
            String salary = tsalary.getText();
            String email = temail.getText();
            String empID = tempid.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String education = (String) teducation.getSelectedItem();

            try{
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"','"+address+"', '"+phone+"','"+email+"', '"+education+"', '"+designation+"','"+aadhar+"', '"+empID+"')";
                conn.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Details added Successfully");
                setVisible(false);
                new MainClass();
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }else if (e.getSource() == back){
            setVisible(false);
            new MainClass();
        }

    }

    public static void main(String[] args){
        new AddEmployee();
    }
}
