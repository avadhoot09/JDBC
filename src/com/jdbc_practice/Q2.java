package com.jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/capgemini";        
        String username = "root";
        String password = "root";

        // Step 1: Load JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: Establish connection
        Connection con = DriverManager.getConnection(url, username, password);

        // Step 3: Prepare query
        PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE salary > 51000");

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
    }
}
