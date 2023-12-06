package com.jspiders.jdbc.insert;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class InsertDemo1 {
	private static Connection connection;
	private static Statement statement;
	private static int result;
	private static FileInputStream file;
	private static Properties properties = new Properties();
	private static String query;
	private static String filePath = "D:\\WEJA2\\jdbc\\resource\\db_info.properties";

	public static void main(String[] args) {

		try {
			file = new FileInputStream(filePath);
			properties.load(file);

			Class.forName(properties.getProperty("driverPath"));

			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
			statement = connection.createStatement();
			query = "insert into student value (3,'tirupati','tirupati@gmail.com',344556)";
			result = statement.executeUpdate(query);
			if (result != 0) {
				System.out.println(result+" row(s) affected");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (file != null) {
					file.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
