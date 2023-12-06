package com.jspiders.cardekhomvc.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekhomvc.pojo.CarPOJO;

@Repository
public class CarRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	public void openConnection() {
		factory=Persistence.createEntityManagerFactory("cardekho");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	
	public void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public CarPOJO addCar(String name, String brand, double price, String fueltype, int airbags) {
		openConnection();
		transaction.begin();
		CarPOJO pojo=new CarPOJO();
		pojo.setName(name);
		pojo.setBrand(brand);
		pojo.setPrice(price);
		pojo.setFueltype(fueltype);
		pojo.setAirbags(airbags);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public List<CarPOJO> getCarData() {
		
		openConnection();
		transaction.begin();
		String jpql1="from CarPOJO";
		query=manager.createQuery(jpql1);
		
		List<CarPOJO> cars = query.getResultList();
		transaction.commit();
		closeConnection();
		return cars;
	}

	public CarPOJO removeCar(int id) {
		openConnection();
		transaction.begin();
		CarPOJO car = manager.find(CarPOJO.class, id);
		manager.remove(car);
		
		transaction.commit();
		closeConnection();
		return car;
	}

	public CarPOJO searchCar(int id) {
		openConnection();
		transaction.begin();
		CarPOJO pojo = manager.find(CarPOJO.class, id);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public CarPOJO updateCarData(int id, String name, String brand, double price, String fueltype, int airbags) {
		openConnection();
		transaction.begin();
		CarPOJO pojo = manager.find(CarPOJO.class, id);
		pojo.setName(name);
		pojo.setBrand(brand);
		pojo.setPrice(price);
		pojo.setFueltype(fueltype);
		pojo.setAirbags(airbags);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

}
