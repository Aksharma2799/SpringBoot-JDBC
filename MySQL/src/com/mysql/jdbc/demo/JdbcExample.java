package com.mysql.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

	public static void main(String[] args) {
		Connection con = null;
		Statement statement = null;
		try {
			// Register the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Create the database connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctask", "root", "bahwan$123");
			
			System.out.println("Database connected successfully!");
			
			statement = con.createStatement();
	
			String insertSql = "insert into user values (101, 'Vikas', 'Singh', 'vikki@gill.com', 'vs@1234', '2000-12-25', 'M')";
			int status = statement.executeUpdate(insertSql);
			System.out.println(status);
			
			String selectSql = "select * from user";
			
			ResultSet rs = statement.executeQuery(selectSql);
			while(rs.next()) {
				System.out.println("ID = " + rs.getString("id")
				                + " first name = " + rs.getString("firstname")
				                + " last name =" + rs.getString("lastname")
				                + " email =" + rs.getString("email")
				                + " password = " + rs.getString("password")
				                + " DOB = " + rs.getString("birth_date")
				                + " Gender = " + rs.getString("gender")); 
			}
			
			// Close the database connection
			con.close();
			
			System.out.println("database connection closed !");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}		
	}

}

