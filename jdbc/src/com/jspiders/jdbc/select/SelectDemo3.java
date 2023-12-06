package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo3 {
	// 2nd way of connection
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String driverPath = "com.mysql.cj.jdbc.Driver";
	private static String dburl = "jdbc:mysql://localhost:3306/weja2";
	private static String user = "root";
	private static String password = "root";

	public static void main(String[] args) {
		try {
			// 1.load the driver class.
			Class.forName(driverPath);

			// 2.open connection.
			connection = DriverManager.getConnection(dburl, user, password);

			// 3.create a statement.
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from student");

			// 4.process a result.
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " || " + resultSet.getString(2) + " || "
						+ resultSet.getString(3) + " || " + resultSet.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();

				}
				if (resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
