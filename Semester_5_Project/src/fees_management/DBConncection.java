/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fees_management;

import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author rohit
 */
public class DBConncection {
    public static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/feesmanagementsystem","root","rohit23");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void main(String[] args) {
        
    }
    
}
