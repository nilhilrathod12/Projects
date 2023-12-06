package com.jspiders.cardekhorest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekhorest.pojo.CarPOJO;

@Repository
public class CarRepository {
	public static EntityManagerFactory factory;
	public static EntityManager manager;
	public static EntityTransaction transaction;
	public static Query query;
	
	public void openConnection() {
		factory=Persistence.createEntityManagerFactory("cardekhorest");
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
	public CarPOJO addCar(CarPOJO pojo) {
		openConnection();
		transaction.begin();
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}
	public CarPOJO removeCar(int id) {
		openConnection();
		transaction.begin();
		CarPOJO pojo = manager.find(CarPOJO.class,id );
		manager.remove(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}
	public CarPOJO searchCar(int id) {
		openConnection();
		transaction.begin();
		CarPOJO pojo = manager.find(CarPOJO.class, id);
		transaction.commit();
		closeConnection();
		return pojo;
	}
	public List<CarPOJO> searchAll() {
		openConnection();
		transaction.begin();
		String jpql="from CarPOJO";
		query=manager.createQuery(jpql);
		List cars = query.getResultList();
		transaction.commit();
		closeConnection();
		return cars;
	}
	public CarPOJO updateCar(CarPOJO pojo) {
		openConnection();
		transaction.begin();
		CarPOJO car = manager.find(CarPOJO.class, pojo.getId());
		car.setName(pojo.getName());
		car.setBrand(pojo.getBrand());
		car.setPrice(pojo.getPrice());
		car.setFueltype(pojo.getFueltype());
		car.setAirbags(pojo.getAirbags());
		manager.persist(car);
		transaction.commit();
		closeConnection();
		return car;
	}

}
