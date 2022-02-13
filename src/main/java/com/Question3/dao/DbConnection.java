package com.Question3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class DbConnection {
	
	public  Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/question", "root", "");	
			//jdbc:mysql://localhost:3306/question
			
			Statement stmt=con.createStatement();
			return con;
			
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
		
	}
	/*
	 * public static void main(String args[]) {
	 * 
	 * }
	 */
}
