package com.jspiders.jdbc.operatios;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JdbcOperations2 {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static FileInputStream fileInputStream;
	private static Properties properties = new Properties();
	private static int result;

	private static String filePath = "D:\\\\WEJA2\\\\jdbc\\\\resource\\\\db_info.properties";
	private static String query;

	public static void main(String[] args) {
		try {
			// 1.create a table.
			openConnection();
			query = "create table emp (empno int(3) primary key,ename varchar(50) not null,job varchar(30),mgr int(4),hiredate date,sal bigint (10) not null,comm int(5)) ";
			result = statement.executeUpdate(query);
			System.out.println("table is created");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeConnection();
		}
		try {
			// 2 insert 14 records.
			openConnection();
			Scanner scanner = new Scanner(System.in);
			for (int i = 1; i <= 14; i++) {
				System.out.println("enter emp no: ");
				int emp = scanner.nextInt();
				System.out.println("enter ename: ");
				String ename = scanner.next();
				System.out.println("enter job: ");
				String job = scanner.next();
				System.out.println("enter mgr no: ");
				int mgr = scanner.nextInt();
				System.out.println("enter the hiredate: ");
				String hiredate = scanner.next();
				System.out.println("enter the salary: ");
				int sal = scanner.nextInt();
				System.out.println("enter the commission : ");
				int comm = scanner.nextInt();

				query = "insert into emp values (" + emp + ",'" + ename + "','" + job + "'," + mgr + ",'" + hiredate
						+ "','" + sal + "'," + comm + ")";
				result = statement.executeUpdate(query);
				System.out.println("Query Ok, " + result + " rows updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		try {
			// 3 display all records.
			query = "select * from emp";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2) + " | " + resultSet.getString(3)
						+ " | " + resultSet.getInt(4) + " | " + resultSet.getString(5) + " | " + resultSet.getInt(6)
						+ " | " + resultSet.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		try {
			// 4 update 2 records.
			Scanner scanner = new Scanner(System.in);
			for (int i = 1; i <= 2; i++) {
				query = "update emp set job='analyst' where empno=" + i + "";
				result = statement.executeUpdate(query);
				System.out.println("Query Ok, " + result + " rows updated");

			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}
		try {
			query = "select *  from emp";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2) + " | " + resultSet.getString(3)
						+ " | " + resultSet.getInt(4) + " | " + resultSet.getString(5) + " | " + resultSet.getInt(6)
						+ " | " + resultSet.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		try {
			Scanner scanner = new Scanner(System.in);
			for (int i = 1; i <= 3; i++) {
				query = "delete from emp where empno=" + i + "";
				result = statement.executeUpdate(query);
				System.out.println("Query Ok, " + result + " rows updated");
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		try {
			query = "select * from emp";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2) + " | " + resultSet.getString(3)
						+ " | " + resultSet.getInt(4) + " | " + resultSet.getString(5) + " | " + resultSet.getInt(6)
						+ " | " + resultSet.getInt(6));
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
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (fileInputStream != null) {
				fileInputStream.close();
			}
			if (result != 0) {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
