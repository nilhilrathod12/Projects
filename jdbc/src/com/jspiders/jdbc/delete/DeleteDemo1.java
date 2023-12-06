package com.jspiders.jdbc.delete;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DeleteDemo1 {
	private static Connection connection;
	private static Statement statement;
	private static int result;
	private static String query;
	private static Properties properties = new Properties();
	private static String filePath = "D:\\WEJA2\\jdbc\\resource\\db_info.properties";
	private static FileInputStream fileInputStream;

	public static void main(String[] args) {
		try {
			fileInputStream = new FileInputStream(filePath);
			properties.load(fileInputStream);
			
			Class.forName(properties.getProperty("driverPath"));

			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);

			statement = connection.createStatement();
			query = "delete from student where sid=3";
			result = statement.executeUpdate(query);
			if (result != 0) {
				System.out.println(result + " rows affected");
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
				if (fileInputStream != null) {
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
