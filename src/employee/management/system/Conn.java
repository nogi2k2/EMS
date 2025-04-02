package employee.management.system;

import java.sql.*;

public class Conn {
    Connection conn;
    Statement stmt;

    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "root");
            stmt = conn.createStatement();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
