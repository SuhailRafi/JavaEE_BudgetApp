package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection con=null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/budgetapp","root","toor");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}

	public static Connection getConnection() {
		return con;
	}
}
