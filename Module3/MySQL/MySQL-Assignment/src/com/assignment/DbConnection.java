package com.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static Connection conn = null;

	public static Connection dbConnect(String dbName, String userName, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return conn;
		}
	}

}
