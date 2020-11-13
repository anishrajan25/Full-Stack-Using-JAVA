package com.wipro.sales.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	public static Connection getDBConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JDBCpractice","Anish@2708");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Driver Error");
		} 
		catch (SQLException e) {
			System.out.println("Connection Error");
		}
		return con;
	}
}
