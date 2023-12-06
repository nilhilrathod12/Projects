package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo2 {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String driverPath = "com.mysql.cj.jdbc.Driver";
	private static String dburl = "jdbc:mysql://localhost:3306/weja2?user=root&password=root";

	public static void main(String[] args) {

		try {
			// 1.load the driver class.
			Class.forName(driverPath);

			// 2.open connection.
			connection = DriverManager.getConnection(dburl);

			// 3.create statement.
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from student");

			// 4.process result
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " || " + resultSet.getString(2) + " || "
						+ resultSet.getString(3) + " || " + resultSet.getString(4));
			}
		} catch (ClassNotFoundException | SQLException e) {
			
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
					statement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
