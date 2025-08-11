package com.jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Q4 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url="jdbc:mysql://localhost:3306/capgemini";
		String username="root";
		String password="root";
		
		//step1:load the driver for the jdbc
		Class.forName("com.mysql.cj.jdbc.Driver");
				
		//Step2:Establish the connection
		Connection con=DriverManager.getConnection(url,username,password);
		
		//step3:Use prepared statement
		PreparedStatement ps=con.prepareStatement("select * from employee where profile='dev'");
		
		//Step04:execute the query
		
		ResultSet rs=ps.executeQuery();
		//Step4:Print the resultSet:-
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
		ps.close();
		rs.close();
	}

}
