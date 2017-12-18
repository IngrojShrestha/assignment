package com.assignment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Connection con = null;
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// Enter the credentials for database access
		Map<String, String> map = getCredentials();

		// Connect to database
		con = DbConnection.dbConnect(map.get("dbName").toString(), map.get("userName").toString(),
				map.get("password").toString());
		// select option (1: non-indexed, 2:indexed)
		char ch;

		do {
			System.out.println("************** Menu **************");
			System.out.println("1. Perform Query without index");
			System.out.println("2. Perform Query with index");
			System.out.println("Select option (1/2)");

			int choice = in.nextInt();

			switch (choice) {
			case 1:
				performQueryNonIndexed(con);
				break;

			case 2:
				performQueryIndexed(con);
				break;
			default:
				System.out.println("Please enter valid option (1/2)\n ");
				break;

			}
			System.out.println("\nDo you want to exit (Type y or n) \n");
			ch = in.next().charAt(0);
		} while (ch == 'n' || ch == 'N');
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Map<String, String> getCredentials() {
		Map<String, String> map = new HashMap<String, String>();

		System.out.println("============== Enter Credential to access database ===========");
		System.out.println("Enter database name");
		map.put("dbName", in.next());

		System.out.println("Enter username");
		map.put("userName", in.next());

		System.out.println("Enter password");
		map.put("password", in.next());

		return map;
	}

	public static void performQueryIndexed(Connection con) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("CREATE INDEX firstname_index ON students(firstName)");

			long start = System.currentTimeMillis();
			ResultSet rs = stmt.executeQuery("select * from students where firstName='lisa'");
			long end = System.currentTimeMillis();

			displayResult(start, end, rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void performQueryNonIndexed(Connection con) {
		try {
			Statement stmt = con.createStatement();
			String query = "SHOW INDEX from students WHERE key_name = 'firstname_index'";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				stmt.executeUpdate("DROP INDEX firstname_index ON students");
			}

			long start = System.currentTimeMillis();
			rs = stmt.executeQuery("select * from students where firstName='lisa'");
			long end = System.currentTimeMillis();

			displayResult(start, end, rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void displayResult(long start, long end, ResultSet rs) {
		System.out.println("Query execution time : " + (end - start) + "ms");
		System.out.println();

		try {
			if (rs.next()) {
				System.out.println("------------------------------------------------------------");
				System.out.println("First Name \tLast Name \tAddress");
				System.out.println("------------------------------------------------------------");
				while (rs.next()) {
					System.out.println(rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" + rs.getString(4));
				}
			} else {
				System.out.println("No result Found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
