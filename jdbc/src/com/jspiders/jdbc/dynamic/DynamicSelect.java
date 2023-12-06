package com.jspiders.jdbc.dynamic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DynamicSelect {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static FileInputStream fileInputStream;
	private static  String filePath= "D:\\WEJA2\\jdbc\\resource\\db_info.properties";
	private static String query;
	private static Properties properties=new Properties();
	
	public static void main(String[] args) {
		try {
			 fileInputStream=new FileInputStream(filePath);
			 properties.load(fileInputStream);
			 
			 Class.forName(properties.getProperty("driverPath"));
			 
			 connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
			 
			 query="select * from stud_details where sid=?";
			 
			 preparedStatement=connection.prepareStatement(query);
			 
			 preparedStatement.setInt(1, 1);
			 
			 resultSet=preparedStatement.executeQuery();
			 
			 while (resultSet.next()) {
				System.out.println(resultSet.getString(1)+" | "
						          + resultSet.getString(2)+" | "
						          +resultSet.getString(3)+" | "
						          +resultSet.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
