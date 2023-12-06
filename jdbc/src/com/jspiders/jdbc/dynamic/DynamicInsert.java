package com.jspiders.jdbc.dynamic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DynamicInsert {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
 	private static FileInputStream fileInputStream;
	private static int result;
	private static String query;
	private static String filePath = "D:\\WEJA2\\jdbc\\resource\\db_info.properties";
	private static Properties properties = new Properties();

	public static void main(String[] args) {
		try {
			fileInputStream = new FileInputStream(filePath);
			properties.load(fileInputStream);

			Class.forName(properties.getProperty("driverPath"));

			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);

			query = "insert into stud_details values (?,?,?,?)";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, 7);
			preparedStatement.setString(2, "vikas");
			preparedStatement.setString(3, "vikas@gmail.com");
			preparedStatement.setLong(4, 6666666);

			result = preparedStatement.executeUpdate();

			System.out.println("Query OK, " + result + " row(s) affected");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
