/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maturski;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Maturski {
        
    public static void main(String[] args) {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con = DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/new_schema","sql","ASD123zxc");
            System.out.println("Connected.");
            displayProducts (con);
            selectProducts (con);
        } catch (Exception e) {
            System.out.println("Connection failed: " + e);
        }
    }
    
    private static void displayProducts (Connection con) {
        String querry = "SELECT * FROM new_schema.proizvod;";
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(querry);
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(3);
                int price = rs.getInt(4);
                System.out.println("Broj proizvoda: "+ id + "\t Ime: " + name + "\t" + "- " + price);
            }
            System.out.println("Izaberi proizvod. Da zavrsis selekciju, klikni 0 ");
        } catch (Exception e) {
            System.out.println("Connection failed: " + e);
        }
    }
    
    private static void selectProducts (Connection con) {
        Scanner reader = new Scanner(System.in);
        ArrayList<Integer> selection = new ArrayList<Integer>();
        ArrayList<Integer> ammount = new ArrayList<Integer>();
        do {
            System.out.println("Broj proizvoda");
            selection.add(reader.nextInt());
            System.out.println("Kolicina proizvoda");
            ammount.add(reader.nextInt());
        } while (selection.get(selection.size()-1) != 0 || 
                 selection.get(ammount.size()-1) != 0);
        reader.close();
        
        int billNumber = getNextBillNumber (con);
        System.out.println("Vas racun:");
        for (int i = 0; i < selection.size()-1; i++) {
            createItemAndAddToBill (con, billNumber,
                                    selection.get(i), ammount.get(i));
            System.out.println("Ime: " + selection.get(i) + "\t" + "Kolicina - " + ammount.get(i));
            
        }
    }
    
    private static int getNextBillNumber (Connection con) {
        String querry = "SELECT COUNT(*) FROM new_schema.racun;";
        int number = 0;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(querry);
            while (rs.next()){
                number = rs.getInt(1);
            }
            return number + 1; 
        } catch (Exception e) {
        }
        return number;
    }
    
    private static int getItemNumber (Connection con) {
        String querry = "SELECT COUNT(*) FROM new_schema.stavka;";
        int number = 0;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(querry);
            while (rs.next()){
                number = rs.getInt(1);
            }
            return number + 1; 
        } catch (Exception e) {
        }
        return number;
    }
    
    private static void createItemAndAddToBill (Connection con, int currentBill,
                                         int productId, int productAmmount) {
        String itemQuerry = "INSERT INTO stavka (proizvod, kolicina) VALUES ( "+productId+", "+productAmmount+");";
        String billQuerry = "INSERT INTO racun (br_racuna, stavka) VALUES ( "+currentBill+", "+getItemNumber (con)+");";
        try {
            PreparedStatement stmt = con.prepareStatement(itemQuerry);
            PreparedStatement stmt1 = con.prepareStatement(billQuerry);
            stmt.executeUpdate();
            stmt1.executeUpdate();
        } catch (Exception e) {
            System.out.println("Querry failed: " + e);
        }
    }
    
    private void selectMenu () {
        System.out.println("Izaberi proizvod:");
    }
}
