package com.jspiders.cardekho_casestudy_hibernate.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.cardekho_casestudy_hibernate.dto.Car;

public class CarOperation {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("car");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConeection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

	public void addCarDetails() {
		openConnection();
		Scanner scanner = new Scanner(System.in);
		System.out.print("How Many Car You Want to Add : ");
		int num = scanner.nextInt();
		for (int i = 1; i <= num; i++) {
			entityTransaction.begin();
			Car car = new Car();
			System.out.print("Enter Car Id : ");
			car.setCar_id(scanner.nextInt());
			System.out.print("Enter Car Name : ");
			car.setName(scanner.next());
			System.out.println("Enter Car Brand: ");
			car.setBrand(scanner.next());
			System.out.println("Enter Car Fuel Type : ");
			car.setFuel_type(scanner.next());
			System.out.println("Enter Car Price : ");
			car.setPrice(scanner.nextDouble());
			entityManager.persist(car);
			entityTransaction.commit();
		}
		closeConeection();
	}

	public void removeCarDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter car id to remove : ");
		openConnection();
		entityTransaction.begin();
		Car car = entityManager.find(Car.class, scanner.next());
		entityManager.remove(car);
		entityManager.persist(car);
		entityTransaction.commit();
		closeConeection();

	}

	public void searchByName() {
		Scanner scanner=new Scanner(System.in);
		openConnection();
        Car car=new Car();
        System.out.println("Enter Car Name: ");
		Query query = entityManager.createQuery("select c from Car c where c.name= :carName");
        query.setParameter("carName",scanner.next() );
		List list = query.getResultList();
		for (Object e : list) {
			System.out.println(e);
		}

		closeConeection();

	}

	public void searchByBrand() {
		Scanner scanner=new Scanner(System.in);
		openConnection();
        Car car=new Car();
        System.out.println("Enter Car Brand: ");
		Query query = entityManager.createQuery("select c from Car c where c.brand= :carBrand");
        query.setParameter("carBrand",scanner.next() );
		List list = query.getResultList();
		for (Object e : list) {
			System.out.println(e);
		}

		closeConeection();

	}

	public void searchByFuelType() {
		Scanner scanner=new Scanner(System.in);
		openConnection();
        Car car=new Car();
        System.out.println("Enter Car Name: ");
		Query query = entityManager.createQuery("select c from Car c where c.fuel_type= :carFuelType");
        query.setParameter("carFuelType",scanner.next() );
		List list = query.getResultList();
		for (Object e : list) {
			System.out.println(e);
		}

		closeConeection();

	}

	public void getAllCarDetails() {
		openConnection();

		Query query = entityManager.createQuery("select c from Car c");

		List list = query.getResultList();
		for (Object e : list) {
			System.out.println(e);
		}

		closeConeection();

	}

	public void editCarDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Car id to Edit: ");
		openConnection();
		entityTransaction.begin();
		Car car = entityManager.find(Car.class, scanner.nextInt());
		System.out
				.println("select option to update : \n" + "1. Name \n" + "2. Brand\n" + "3. Fuel type\n" + "4. Price ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter Car Name :");
			car.setName(scanner.next());
			break;
		case 2:
			System.out.println("Enter Car Brand :");
			car.setBrand(scanner.next());
			break;
		case 3:
			System.out.println("Enter Car Fuel Type :");
			car.setFuel_type(scanner.next());
			break;
		case 4:
			System.out.println("Enter Car Price :");
			car.setPrice(scanner.nextDouble());
			break;

		default:
			System.out.println("Invalid Choise");
			break;
		}
		entityTransaction.commit();
		closeConeection();

	}

}
