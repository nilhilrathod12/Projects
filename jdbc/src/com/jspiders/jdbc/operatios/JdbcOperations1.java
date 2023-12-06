package com.jspiders.jdbc.operatios;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JdbcOperations1 {
	private static Connection connection;
	private static Statement statement;
	private static int result;
	private static String query;
	
	private static ResultSet resultSet;
	private static Properties properties = new Properties();
	private static FileInputStream fileInputStream;
	private static String filePath = "D:\\\\WEJA2\\\\jdbc\\\\resource\\\\db_info.properties";

	public static void main(String[] args) {
		try {
			//1.create table.
			openConnection();
			query="create table stud_details (sid int(3) primary key, name varchar(50),email varchar(30), contact bigint(10))";
			result=statement.executeUpdate(query);
			System.out.println("Query Ok, "+result+" row(s) affected");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		//2. insert 5 records.
		try {
			openConnection();
			Scanner scanner=new Scanner(System.in);
			for (int i = 0; i <= 5; i++) {
				System.out.println("Enter id : ");
				int sid=scanner.nextInt();
				System.out.println("Enter name: ");
				String name=scanner.next();
				System.out.println("Enter email :");
				String email=scanner.next();
				System.out.println("Enter number :");
				long contact=scanner.nextLong();
				
				query="insert into stud_details values("+sid+",'"+name+"','"+email+"',"+contact+")";
				result=statement.executeUpdate(query);
				System.out.println("Query Ok, "+result+" row(s) affected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		//3 select all records.
		try {
			openConnection();
			query="select * from stud_details";
			resultSet=statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3)+" | "+resultSet.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}

	}

	private static void openConnection() {
		try {
			fileInputStream = new FileInputStream(filePath);
			properties.load(fileInputStream);

			Class.forName(properties.getProperty("driverPath"));

			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);

			statement = connection.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  private static void closeConnection() {
	 try {
		 if (statement != null) {
				statement.close();
			}
		 if (connection != null) {
			connection.close();
		}
		 if (resultSet != null) {
			resultSet.close();
		}
		 if (fileInputStream != null) {
			fileInputStream.close();
		}
		 if (result != 0) {
			result=0;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
  }

}
