package com.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client2 {

	
	public void m1(int id,String name,int age) throws ClassNotFoundException, SQLException {
	String url="jdbc:mysql://localhost:3306/myfirstdb";
	String username="root";
	String password="root";
		//setp-1:load the jdbc driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	//step-2:Establishing the connection:
		Connection con=DriverManager.getConnection(url,username,password);
		
	//set-3:Use of prepared statemnet to execute the query
		
		PreparedStatement ps=con.prepareStatement("insert into demo values(?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		int rows =ps.executeUpdate();
		System.out.println("total "+rows+" inserted in the table");
	
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Client2 cc =new Client2();
		cc.m1(10,"sukdoji",98);	

	}

}
