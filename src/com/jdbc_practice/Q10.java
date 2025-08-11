package com.jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q10 {

	public void m1(String name) throws ClassNotFoundException, SQLException {
	    String url="jdbc:mysql://localhost:3306/capgemini";
		String username="root";
		String password="root";
		
		//setp1:load the jdbc driver:
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step2:Establish the connection:
		Connection con=DriverManager.getConnection(url,username,password);
		
		//setp3:use the prepare statememnt
		PreparedStatement ps=con.prepareStatement("update employee set salary=salary-21000 where name=?");
		ps.setString(1, name);
		int rows=ps.executeUpdate();
		System.out.println("The totall rows deleted after the deletion operation is performed are:"+rows);
		PreparedStatement ps1=con.prepareStatement("select *  from employee");
		//step4:printing the resultset
		ResultSet rs=ps1.executeQuery();
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
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Q10 obj=new Q10();
		obj.m1("john");
	}

}
