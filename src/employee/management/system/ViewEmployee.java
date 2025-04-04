package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewEmployee extends JFrame implements ActionListener{
    Choice empid;
    JTable table;
    JButton search, print, update, back;

    public ViewEmployee(){
        getContentPane().setBackground(new Color(255, 131, 122));

        JLabel heading = new JLabel("Enter Employee ID");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        empid = new Choice();
        empid.setBounds(180, 20, 150, 20);
        add(empid);

        try{
            Conn conn = new Conn();
            String query = "Select * from employee";
            ResultSet rs = conn.stmt.executeQuery(query);

            while (rs.next()){
                empid.add(rs.getString("empID"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        table = new JTable();
        try{
            Conn conn = new Conn();
            String query = "Select * from employee";
            ResultSet rs = conn.stmt.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane();
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        search = new JButton("SEARCH");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("PRINT");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("UPDATE");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton();
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == search){
            try{
                Conn conn = new Conn();
                String query = "Select * from employee where empID = ?";
                PreparedStatement pst = conn.conn.prepareStatement(query);
                pst.setString(1, empid.getSelectedItem());
                ResultSet rs = pst.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }else if (e.getSource() == update){
            setVisible(false);
            new UpdateEmployee(empid.getSelectedItem());
        }else if (e.getSource() == print){
            table.print();
        }else{
            setVisible(false);
            new MainClass();
        }
    }

    public static void main(String[] args){
        new ViewEmployee();
    }
}
