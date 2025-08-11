package com.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class first {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/myfirstdb";
		String username="root";
		String password="root";
		try {
			//Register the driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establishing the connection using 
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Connected to the database succesfully!");
			//creating the statement
			Statement stmt =con.createStatement();
			String insertQuery="insert into demo values(8,'shantaram',21)";
			stmt.executeUpdate(insertQuery);
			String selectQuery="select *from demo";
			ResultSet rs=stmt.executeQuery(selectQuery);
			while(rs.next()) {
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age"));
				
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
