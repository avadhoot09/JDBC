package com.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class Client1 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/myfirstdb";
        String username = "root";
        String password = "root"; // replace with your actual password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            String insert = "INSERT INTO myfirsttable (name, age) VALUES (?, ?)";
            PreparedStatement insertStmt = con.prepareStatement(insert);
            insertStmt.setString(1, "kiran");
            insertStmt.setInt(2, 35);
            insertStmt.executeUpdate();
            System.out.println("Record inserted.");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM myfirsttable");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age"));
            }

            rs.close();
            stmt.close();
            insertStmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
