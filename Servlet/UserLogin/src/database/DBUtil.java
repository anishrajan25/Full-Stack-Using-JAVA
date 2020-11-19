package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getDBConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JDBCpractice","Anish@2708");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver mi Error\n\n");
		} 
		catch (SQLException e) {
			System.out.println("Connection Error");
		}
		return con;
	}
}

