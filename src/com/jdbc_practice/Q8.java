package com.jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q8 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/capgemini";
		String username="root";
		String password="root";
		
		//set1:Load the jdbc driver:
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		//step2:Establish the connection
		Connection con=DriverManager.getConnection(url,username,password);
		
		//step3:Use the create statement(another methode):
		Statement stmt=con.createStatement();
		stmt.executeUpdate("update employee set salary=salary+10000 where experience<20");
		ResultSet rs=stmt.executeQuery("select * from employee where experience<20000");
		//step4:printint the resultset:
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
		//Step 05:Closing all the operation
		con.close();
		rs.close();
		
		
	}

}
