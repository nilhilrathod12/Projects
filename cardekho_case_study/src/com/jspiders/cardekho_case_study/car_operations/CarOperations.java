package com.jspiders.cardekho_case_study.car_operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jspiders.cardekho_case_study.entity.Car;

public class CarOperations {
	public static List<Car> cars = new ArrayList<Car>();
	public static Scanner sc = new Scanner(System.in);

	public void addCarDetails() {
		System.out.println("How Many Cars Do You Want To Add");
		Scanner sc = new Scanner(System.in);
		int obj = sc.nextInt();
		for (int i = 1; i <= obj; i++) {
			Car car = new Car();
			System.out.println("Enter car id: ");
			car.setCar_id(sc.nextInt());
			System.out.println("Enter Car Name: ");
			car.setName(sc.next());
			System.out.println("Enter Model: ");
			car.setModel(sc.next());
			System.out.println("Enter Car Brand");
			car.setBrand(sc.next());
			System.out.println("Enter Fuel Type: ");
			car.setFuel_type(sc.next());
			System.out.println("Enter Price of a Caer: ");
			car.setPrice(sc.nextDouble());
			cars.add(car);

		}
		System.out.println("Your car details successfully added......");
		carDetails();

	}

	public void removeCarDetails() {

		if (cars.isEmpty()) {
			System.out.println("No Data Found.....");

		} else {
			carDetails();
			System.out.println("Enter a Car_id to remove");
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			for (int i = 0; i < cars.size(); i++) {
				Car car = cars.get(i);
				if (car.getCar_id() == a) {
					cars.remove(i);
					System.out.println("car detail is Successfully removed");
				}
			}
			carDetails();

		}

	}

	public void editCarDetails() {

		if (cars.isEmpty()) {
			System.out.println("No details found");
		} else {
			carDetails();
			System.out.println("Enter a Car_id that Your want Edit: ");
			int a = sc.nextInt();
			for (Car car : cars) {
				if (car.getCar_id() == a) {
					System.out.println("Enter a Car new Car_id: ");
					car.setCar_id(sc.nextInt());
					System.out.println("Enter a New Car Name: ");
					car.setName(sc.next());
					System.out.println("Enter a New Car Model: ");
					car.setModel(sc.next());
					System.out.println("Enter a New Brand: ");
					car.setBrand(sc.next());
					System.out.println("Enter a fuel type: ");
					car.setFuel_type(sc.next());
					System.out.println("Enter a price: ");
					car.setPrice(sc.nextDouble());
				}
				carDetails();
			}

		}
	}

	public void carDetails() {
		System.out.println("car_id" + "\tCarName" + "\tCarModel" + "\tCarBrand" + "\tFuelType" + "\tPrice");
		System.out.println(
				"===============================================================================================");
		for (Car car : cars) {
			System.out.println(car);
		}
	}

	public void searchByName() {
		System.out.println("Enter a Name: ");
		String name = sc.next();
		System.out.println("car_id" + "\tCarName" + "\tCarModel" + "\tCarBrand" + "\tFuelType" + "\tPrice");
		System.out.println(
				"===============================================================================================");
		for (Car car : cars) {
			if (car.getName().equalsIgnoreCase(name)) {
				System.out.println(car.getCar_id() + "\t" + car.getName() + "\t\t" + car.getModel() + "\t\t"
						+ car.getBrand() + "\t\t" + car.getFuel_type() + "\t\t" + car.getPrice() + "");
			}
		}

	}

	public void searchByFuel_type() {
		System.out.println("Enter a Fuel Type : ");
		String fuel_type = sc.next();
		System.out.println("car_id" + "\tCarName" + "\tCarModel" + "\tCarBrand" + "\tFuelType" + "\tPrice");
		System.out.println(
				"===============================================================================================");
		for (Car car : cars) {
			if (car.getFuel_type().equalsIgnoreCase(fuel_type)) {
				System.out.println(car.getCar_id() + "\t" + car.getName() + "\t\t" + car.getModel() + "\t\t"
						+ car.getBrand() + "\t\t" + car.getFuel_type() + "\t\t" + car.getPrice() + "");
			}
		}

	}

	public void searchByBrand() {
		System.out.println("Enter a brand: ");
		String brand = sc.next();
		System.out.println(
				"car_id" + "\tCarName" + "\tCarModel" + "\tCarBrand" + "\tFuelType" + "\tPrice");
		System.out.println(
				"===============================================================================================");
		for (Car car : cars) {
			if (car.getBrand().equalsIgnoreCase(brand)) {
				System.out.println(car.getCar_id() + "\t" + car.getName() + "\t\t" + car.getModel() + "\t\t"
						+ car.getBrand() + "\t\t" + car.getFuel_type() + "\t\t" + car.getPrice() + "");
			}
		}

	}

	public void searchByPrice() {
		System.out.println("Enter a Price: ");
		double price = sc.nextDouble();
		System.out.println("car_id" + "\tCarName" + "\tCarModel" + "\tCarBrand" + "\tFuelType" + "\tPrice");
		System.out.println(
				"===============================================================================================");
		for (Car car : cars) {
			if (car.getPrice() == price) {
				System.out.println(car.getCar_id() + "\t" + car.getName() + "\t\t" + car.getModel() + "\t\t"
						+ car.getBrand() + "\t\t" + car.getFuel_type() + "\t\t" + car.getPrice() + "");
			}
		}

	}

}
