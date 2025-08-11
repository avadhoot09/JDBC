package com.jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q3 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/capgemini"; // Fixed URL
        String username = "root";
        String password = "root";

        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare query with all required columns
            String query = "SELECT id, name, profile, email, salary, age, experience, branch_location " +
                           "FROM employee WHERE age > 35";
            PreparedStatement ps = con.prepareStatement(query);

            // Step 4: Execute query
            ResultSet rs = ps.executeQuery();

            // Step 5: Process results
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("profile") + "\t" +
                    rs.getString("email") + "\t" +
                    rs.getInt("salary") + "\t" +
                    rs.getInt("age") + "\t" +
                    rs.getInt("experience") + "\t" +
                    rs.getString("branch_location")
                );
            }

            // Step 6: Close resources
            rs.close();
            ps.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
