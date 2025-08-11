package com.jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q7 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/capgemini";
		String username="root";
		String password="root";
		
		//step1:Load the jdbc driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//setp2:Establish the connection
		Connection con=DriverManager.getConnection(url,username,password);
		
		//setp3:write the create statement(Another type
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select name,email from employee where salary!=51000");
			//step5:printing the result set:
			while (rs.next()) {
	            System.out.println(
	               // rs.getInt("id") + "\t" +
	                rs.getString("name") + "\t" +
	                //rs.getString("profile") + "\t" +
	                rs.getString("email") + "\t" 
	                //rs.getInt("salary") + "\t" +
	                //rs.getInt("age") + "\t" +
	                //rs.getInt("experience") + "\t" +
	                //rs.getString("branch_location")
	            );
	        }
	}

}
