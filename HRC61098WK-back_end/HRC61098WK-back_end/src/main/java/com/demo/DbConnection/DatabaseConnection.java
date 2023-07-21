package com.demo.DbConnection;

import java.sql.*;

public class DatabaseConnection {
	public static Connection createConnect() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/grey_goose";
		String userName = "root";
		String pwd = "codingisgod@10";
		//Establishing connection with mySQL
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, userName, pwd);
			System.out.println("Post establishing a DB connection - "+con);
			
		}
		catch(SQLException e)
		{
			//executes in case any error occurs in establishing connection
			System.out.println("Error Occurred");
			e.printStackTrace();
		}
		return con;
		
	}
}

