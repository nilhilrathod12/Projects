package com.jspiders.cardekho_case_study.operation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.jspiders.cardekho_case_study.entity.Car;

public class CarOperation {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static int result;
	private static PreparedStatement preparedStatement;
	private static final String filePath = "D:\\WEJA2\\cardekho_case_study_jdbc\\resource\\db_info.properties";
	private static final String driverPath = "com.mysql.cj.jdbc.Driver";
	private static String query;
	private static FileInputStream fileInputStream;
	private static Properties properties = new Properties();

	private static void openConnection() {
		try {
			fileInputStream = new FileInputStream(filePath);
			properties.load(fileInputStream);

			Class.forName(driverPath);

			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);

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
			if (result != 0) {
				result = 0;
			}
			if (fileInputStream != null) {
				fileInputStream.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addCarDetails() {
		openConnection();
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		System.out.println("car id already taken "+arrayList);
		System.out.println("How many car details you want to add? ");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		for (int i = 1; i <= choice; i++) {
			Car car = new Car();
			System.out.print("Enter car id : ");
			car.setCar_id(scanner.nextInt());
			System.out.print("Enter car name : ");
			car.setName(scanner.next());
			System.out.print("Enter car brand : ");
			car.setBrand(scanner.next());
			System.out.print("Enter car fuel type : ");
			car.setFuel_type(scanner.next());
			System.out.print("Enter car price : ");
			car.setPrice(scanner.nextDouble());
			arrayList.add(car.getCar_id());

			try {
				query = "insert into car_details values(?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, car.getCar_id());
				preparedStatement.setString(2, car.getName());
				preparedStatement.setString(3, car.getBrand());
				preparedStatement.setString(4, car.getFuel_type());
				preparedStatement.setDouble(5, car.getPrice());

				result = preparedStatement.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}

			System.out.println("\n\n" + car.getName() + " added..!! ");
		}
		scanner.close();
		getAllCarDetails();
	}

	public void removeCarDetails() {
		getAllCarDetails();

		openConnection();
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter car id to remove car details: ");
			int car_id = scanner.nextInt();
			query = "delete from car_details where car_id=" + car_id + "";
			statement = connection.createStatement();
			result = statement.executeUpdate(query);
			scanner.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		getAllCarDetails();
	}

	public void getAllCarDetails() {
		openConnection();
		try {
			query = "select * from car_details";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "  " + resultSet.getString(2) + "  "
						+ resultSet.getString(3) + "  " + resultSet.getString(4) + "  " + resultSet.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void searchByName() {
		openConnection();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter car name: ");
		String name = scanner.next();
		query = "select * from car_details where car_name=" + "'" + name + "'" + "";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "  " + resultSet.getString(2) + "  "
						+ resultSet.getString(3) + "  " + resultSet.getString(4) + "  " + resultSet.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		scanner.close();

	}

	public void searchByBrand() {
		openConnection();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter car brand: ");
		String brand = scanner.next();
		query = "select * from car_details where car_brand=" + "'" + brand + "'" + "";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "  " + resultSet.getString(2) + "  "
						+ resultSet.getString(3) + "  " + resultSet.getString(4) + "  " + resultSet.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		scanner.close();
	}

	public void searchByFuelType() {
		openConnection();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter car name: ");
		String fuel_type = scanner.next();
		query = "select * from car_details where car_fueltype=" + "'" + fuel_type + "'" + "";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "  " + resultSet.getString(2) + "  "
						+ resultSet.getString(3) + "  " + resultSet.getString(4) + "  " + resultSet.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		scanner.close();
	}

	public void editCarDetails() {
		getAllCarDetails();

	}
}
