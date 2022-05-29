/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maturski;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ubuntu
 */
public class databaseConnection {
    public static void connectDatabase (Connection con) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con = DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/new_schema","sql","ASD123zxc");
            System.out.println("Connected.");
        } catch (Exception e) {
            System.out.println("Connection failed: " + e);
        }
    }
}
