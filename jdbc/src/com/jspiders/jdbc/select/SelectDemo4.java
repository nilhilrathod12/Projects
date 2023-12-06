package com.jspiders.jdbc.select;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class SelectDemo4 {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String driverPath = "com.mysql.cj.jdbc.Driver";
	private static String dburl = "jdbc:mysql://localhost:3306/weja2";
	private static FileInputStream file;
	private static Properties properties;
	private static String query;
	public static String filePath = "D:\\WEJA2\\jdbc\\resource\\db_info.properties";

	public static void main(String[] args) {
		try {
			// 1.load driver class
			Class.forName(driverPath);

			file = new FileInputStream(filePath);
			properties = new Properties();
			properties.load(file);

			// 2.open connection
			connection = DriverManager.getConnection(dburl, properties);

			// 3.create a statement
			statement = connection.createStatement();
			query = "select * from student";
			resultSet = statement.executeQuery(query);

			// 4.process a result.
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "  ||  " + resultSet.getString(2) + "  ||  "
						+ resultSet.getString(3) + "  ||  " + resultSet.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5.close connections
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
				if (file != null) {
					file.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
